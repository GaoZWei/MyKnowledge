package cn.wzb.ssm.mapper;

import org.springframework.stereotype.Repository;

import cn.wzb.ssm.po.Admin;
@Repository
public interface AdminMapperCustom {

	public Admin findLoginAdmin(Admin admin);

}