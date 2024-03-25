package jp.co.internous.todolist.controller;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.todolist.model.domain.MstUser;
import jp.co.internous.todolist.model.domain.TblTodolist;
import jp.co.internous.todolist.model.form.AddTodoListForm;
import jp.co.internous.todolist.model.form.CompleteForm;
import jp.co.internous.todolist.model.form.LoginForm;
import jp.co.internous.todolist.model.mapper.MstUserMapper;
import jp.co.internous.todolist.model.mapper.TblTodolistMapper;
import jp.co.internous.todolist.model.session.LoginSession;

@Controller
@RequestMapping("/todo")
public class IndexController {

	@Autowired
	private LoginSession loginSession;

	@Autowired
	private MstUserMapper userMapper;
	
	@Autowired
	private TblTodolistMapper todoListMapper;

	@GetMapping("/")
	public String todo() {

		if (loginSession.isLoginFlag() == true) {
			return "redirect:/todo/mypage";
		} else {
			return "index";
		}
	}

	@PostMapping("/")
	public String todoLogin(LoginForm f, Model m) {

		MstUser user = userMapper.findByUserNameAndPassword(f);

		m.addAttribute("userName", f.getUserName());
		m.addAttribute("password", f.getPassword());

		if (user == null) {
			m.addAttribute("errorMessage", "ユーザー名またはパスワードが違います。");
			return "index";
		}

		loginSession.setUserId(user.getId());
		loginSession.setUserName(user.getUserName());
		loginSession.setFullName(user.getFullName());
		loginSession.setLoginFlag(true);

		return "redirect:/todo/mypage";
	}

	@GetMapping("/mypage")
	public String mypage(Model m) {

		List<TblTodolist> todoLists  = todoListMapper.findAllByUserId(loginSession.getUserId());
		
		m.addAttribute("fullName", loginSession.getFullName());
		m.addAttribute("userId", loginSession.getUserId());
		m.addAttribute("todoLists", todoLists);
		
		if (loginSession.isLoginFlag() == true) {
			return "mypage";
		} else {
			return "redirect:/todo/";
		}
	}
	
	@PostMapping("/addtodolist")
	public String addTodoList(AddTodoListForm f) throws Exception {
		
		TblTodolist todoList = new TblTodolist();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = dateFormat.parse(f.getDeadline());
		
		Timestamp deadline = new Timestamp(date.getTime());
		
		todoList.setUserId(f.getUserId());
		todoList.setTodo(f.getTodo());
		todoList.setDeadline(deadline);
		
		todoListMapper.insert(todoList);
		
		return "redirect:/todo/mypage";
	}
	
	@PostMapping("/complete")
	public String complete(CompleteForm f) {
		
		todoListMapper.complete(f.getId());
		
		return "redirect:/todo/mypage";
	}
	
	@GetMapping("/logout")
	public String logout() {
		loginSession.setUserId(0);
		loginSession.setUserName(null);
		loginSession.setFullName(null);
		loginSession.setLoginFlag(false);
		
		return "redirect:/todo/";
	}

}
