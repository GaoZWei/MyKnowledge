package cn.wzb.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.wzb.ssm.mapper.AdminMapperCustom;
import cn.wzb.ssm.po.Admin;
import cn.wzb.ssm.service.AdminService;
@Service
@Transactional
public class AdminServiceImpl implements AdminService{
	@Autowired
	private AdminMapperCustom adminMapperCustom;

	@Override
	public Admin findLoginAdmin(String account,String password) {
		Admin admin = new Admin();
		admin.setAccount(account);
		admin.setPassword(password);
		return adminMapperCustom.findLoginAdmin(admin);
	}

}
