package cn.wzb.ssm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.wzb.ssm.po.User;
import cn.wzb.ssm.po.UserCustom;

@Repository
public interface UserMapperCustom {
	
	public List<UserCustom> findUserList();

	public User findLoginUser(User user) ;

	public User findRegisterUser(User user);

	public void isdeleteUser(Integer id) ;

	public void nodeleteUser(Integer id) ;
	
	//模糊查找用户
	
	public List<UserCustom> selectUser(String username);

}
