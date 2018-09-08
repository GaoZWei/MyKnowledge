package cn.wzb.ssm.service.impl;

import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wzb.ssm.mapper.UserMapper;
import cn.wzb.ssm.mapper.UserMapperCustom;
import cn.wzb.ssm.po.User;
import cn.wzb.ssm.po.UserCustom;
import cn.wzb.ssm.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapperCustom userMapperCustom;

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findRegisterUser(String account) {
		User user = new User();
		user.setAccount(account);
		return userMapperCustom.findRegisterUser(user);
	}

	@Override
	public void userRegister(UserCustom userCustom) {

		userMapper.insertSelective(userCustom);
		
	}

	@Override
	public User findLoginUser(String account, String password) {

		User user = new User();
		user.setAccount(account);
		user.setPassword(password);
		return userMapperCustom.findLoginUser(user);
	}

	@Override
	public void insertUser(UserCustom userCustom){

		userMapper.insertSelective(userCustom);
		
	}

	@Override
	public List<UserCustom> findUserList(){

		return userMapperCustom.findUserList();
	}

	@Override
	public UserCustom findUserById(Integer id) {
		
		User user = userMapper.selectByPrimaryKey(id);
		UserCustom userCustom = new UserCustom();
		// 将user的属性值拷贝到userCustom
		BeanUtils.copyProperties(user,userCustom);

		return userCustom;
	}

	@Override
	public void updateUser(Integer id, UserCustom userCustom){

		userCustom.setId(id);
		userCustom.setIdent(1);
		userMapper.updateByPrimaryKey(userCustom);
		
	}

	@Override
	public void deleteUser(Integer id, UserCustom userCustom) {

		userMapper.deleteByPrimaryKey(id);
		
	}

	@Override
	public void isdeleteUser(Integer id, UserCustom userCustom) {

		userMapperCustom.isdeleteUser(id);
		
	}

	@Override
	public void nodeleteUser(Integer id, UserCustom userCustom){

		userMapperCustom.nodeleteUser(id);
		
	}

	@Override
	public List<UserCustom> selectUser(String username) {
		return userMapperCustom.selectUser(username) ;
	}

}
