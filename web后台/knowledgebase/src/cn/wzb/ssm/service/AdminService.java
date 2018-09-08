package cn.wzb.ssm.service;

import cn.wzb.ssm.po.Admin;

public interface AdminService {

	public Admin findLoginAdmin(String account,String password);

}
