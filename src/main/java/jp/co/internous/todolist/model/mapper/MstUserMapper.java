package jp.co.internous.todolist.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.internous.todolist.model.domain.MstUser;
import jp.co.internous.todolist.model.form.LoginForm;

@Mapper
public interface MstUserMapper {

	@Select(value="select * from mst_user where user_name = #{userName} and password = #{password}")
	MstUser findByUserNameAndPassword(LoginForm form);
	
}
