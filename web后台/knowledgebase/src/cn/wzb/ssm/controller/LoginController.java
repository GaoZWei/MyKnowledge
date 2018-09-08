package cn.wzb.ssm.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.wzb.ssm.po.Admin;
import cn.wzb.ssm.po.User;
import cn.wzb.ssm.po.UserCustom;
import cn.wzb.ssm.service.AdminService;
import cn.wzb.ssm.service.UserService;
@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	// 注入AdminService
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/adminLoginPage")
	public ModelAndView adminLoginPage() throws Exception {
		// 创建返回的对象modeAndView
		ModelAndView modelAndView = new ModelAndView();
		// 返回到jsp显示
		modelAndView.setViewName("/adminLogin");
		return modelAndView;
	}
	@RequestMapping("/adminLogin")
	public String adminLogin(HttpServletRequest request, HttpSession session,
			String account, String password){
		Admin r = adminService.findLoginAdmin(account, password);
		if (r != null) {
			session.setAttribute("account", r.getAccount());
			session.setAttribute("adminid", r.getId());
			return "redirect:/admin/admin_user_list";
		} else {
			request.setAttribute("msg", "账号名或密码错误！");
			request.setAttribute("href", "/adminLoginPage");
			return "forward:/WEB-INF/jsp/result.jsp";
		}
	}
/*	@ResponseBody
	@RequestMapping("/adminLogin")
	public Map adminLogin(HttpSession session,@RequestBody String account,@RequestBody String password) {
		Map data = new HashMap();
		Admin a = adminService.findLoginAdmin(account,password);
		if (a != null) {
			session.setAttribute("account", a.getAccount());
			session.setAttribute("adminid", a.getId());
			data.put("status", 200);
			data.put("msg", "success");
		} else {
			data.put("status", 302);
			data.put("msg", "用户名或密码错误！");
		}
		return data;
	}*/
	
/*	@RequestMapping("/userLoginPage")
	public ModelAndView userLoginPage() throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/userLogin");
	
		return modelAndView;
	}
	*/
	@ResponseBody
	@RequestMapping("/userLogin")
	public Map userLogin(HttpSession session,String account,String password) {
		Map data = new HashMap();
		User r = userService.findLoginUser(account,password);
		if (r != null && r.getIdent() == 1) {
			session.setAttribute("account", r.getAccount());
			session.setAttribute("userid", r.getId());
			data.put("status", 200);
			data.put("msg", "success");
		}
		else if (r != null && r.getIdent() != 1)  {
				data.put("status", 301);
				data.put("msg", "您的账号已被禁！请联系管理员解禁！");
			}else {
				data.put("status", 302);
				data.put("msg", "用户名或密码错误！");
			}
			return data;
	}
	
/*	@RequestMapping("/userRegisterPage")
	public ModelAndView userRegisterPage() throws Exception {
		// 创建返回的对象modeAndView
		ModelAndView modelAndView = new ModelAndView();
		// 返回到jsp显示
		modelAndView.setViewName("/userRegister");
	
		return modelAndView;
	}*/
	
	@ResponseBody
	@RequestMapping("/userRegister")
	public Map userRegister(@RequestBody UserCustom userCustom,@RequestBody String account) {
		Map data = new HashMap();
		User r = userService.findRegisterUser(account);
		if (r != null) {
			data.put("status", 301);
			data.put("msg", "用户已存在");
			
		}
		else if(r == null){
			userService.userRegister(userCustom);
			data.put("status", 200);
			data.put("msg", "success");
			}else {
				data.put("status", 302);
				data.put("msg", "未知原因，用户注册失败");
			}
		return data;
	}
	
	@RequestMapping("/adminLogout")
	public String adminLogout(HttpSession session) {

		session.invalidate();

		return "redirect:/adminLoginPage";
	}

	@RequestMapping("/userLogout")
	public String userLogout(HttpSession session) {

		session.invalidate();

		return "redirect:/index";
	}
}
