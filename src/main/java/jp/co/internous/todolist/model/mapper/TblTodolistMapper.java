package jp.co.internous.todolist.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.todolist.model.domain.TblTodolist;

@Mapper
public interface TblTodolistMapper {

	@Select(value="select * from tbl_todolist where user_id = #{userId} order by deadline asc")
	List<TblTodolist> findAllByUserId(int userId);
	
	@Insert(value="insert into tbl_todolist (user_id, todo, deadline) values (#{userId}, #{todo}, #{deadline})")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(TblTodolist todoList);
	
	@Update(value="update tbl_todolist set completed = 1 where id = #{id}")
	int complete(int id);
}
