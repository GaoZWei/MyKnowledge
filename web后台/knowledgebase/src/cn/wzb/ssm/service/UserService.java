package cn.wzb.ssm.service;

import java.util.List;

import cn.wzb.ssm.po.User;
import cn.wzb.ssm.po.UserCustom;

public interface UserService {
	public User findRegisterUser(String account) ;

	public void userRegister(UserCustom userCustom);

	public User findLoginUser(String account, String password);

	public void insertUser(UserCustom userCustom) ;

	public List<UserCustom> findUserList();

	public UserCustom findUserById(Integer id);

	public void updateUser(Integer id, UserCustom userCustom);

	public void deleteUser(Integer id, UserCustom userCustom);

	public void isdeleteUser(Integer id, UserCustom userCustom);

	public void nodeleteUser(Integer id, UserCustom userCustom);
  
	//模糊查找用户
	
	public List<UserCustom> selectUser(String username);
}
