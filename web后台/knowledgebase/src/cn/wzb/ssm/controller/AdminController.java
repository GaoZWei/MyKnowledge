package cn.wzb.ssm.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import cn.wzb.ssm.service.CateService;
import cn.wzb.ssm.service.TagService;
import cn.wzb.ssm.service.UserService;
import cn.wzb.ssm.po.Cate;
import cn.wzb.ssm.po.Tag;
import cn.wzb.ssm.po.User;
import cn.wzb.ssm.po.UserCustom;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CateService cateService;
	
	@Autowired
	private TagService tagService;
	
	@RequestMapping("/admin_user_add")
	public String admin_user_add() {

		return "admin/admin_user_add";
	}

	@RequestMapping("/admin_user_addSubmit")
	public String admin_user_addSubmit(HttpServletRequest request,
			UserCustom userCustom, String account){
		User r = userService.findRegisterUser(account);
		if (r != null) {
			request.setAttribute("msg", "用户名已存在！请重新添加！");
			request.setAttribute("href", "/admin/admin_user_add");
			return "forward:/WEB-INF/jsp/result.jsp";
		} else {			
			userService.insertUser(userCustom);
			request.setAttribute("msg", "添加成功！");
			request.setAttribute("href", "/admin/admin_user_list");
			return "forward:/WEB-INF/jsp/result.jsp";
		}
	}
	
/*	@ResponseBody
	@RequestMapping("/admin_user_addSubmit")
	public Map admin_user_addSubmit(@RequestBody UserCustom userCustom,@RequestBody String account) {
		Map data = new HashMap();
		User r = userService.findRegisterUser(account);
		if (r != null) {
			data.put("status", 301);
			data.put("msg", "用户已存在");
			
		}
		else if(r == null){
			userService.insertUser(userCustom);
			data.put("status", 200);
			data.put("msg", "success");
			}else {
				data.put("status", 302);
				data.put("msg", "未知原因，用户注册失败");
			}
		return data;
	}*/
	
	
	@RequestMapping("/admin_user_list")
	public ModelAndView admin_user_list(){
	
		ModelAndView modelAndView = new ModelAndView();
		
		List<UserCustom> userList = userService.findUserList();
		
		modelAndView.addObject("userList", userList);
	
		modelAndView.setViewName("admin/admin_user_list");
		return modelAndView;
	}
	
/*	@ResponseBody
	@RequestMapping("/admin_user_list")
	public List admin_user_list() {
		List<UserCustom> userList = userService.findUserList();
		return userList;
	}*/
	
	
	//查找用户
	@RequestMapping("/find_user")
	public ModelAndView find_user(String username){	
				ModelAndView modelAndView = new ModelAndView();			
				List<UserCustom> userList = userService.selectUser(username);
				if (username == null) {
					modelAndView.setViewName("admin/admin_user_list");
				} else {
					modelAndView.addObject("userList", userList);				
					modelAndView.setViewName("admin/admin_user_list");
				}		
				return modelAndView;
	}
	
	/*@ResponseBody
	@RequestMapping("/find_user")
	public List find_user(String username) {
		List<UserCustom> userList = userService.selectUser(username);
		return userList;
	}*/

	// 限制http请求方法
	@RequestMapping(value = "/admin_user_edit", method = { RequestMethod.POST,RequestMethod.GET })
	public ModelAndView admin_user_edit(Integer id) {
		ModelAndView modelAndView = new ModelAndView();	
		UserCustom userCustom = userService.findUserById(id);	
		modelAndView.addObject("userCustom", userCustom);	
		return modelAndView;
	}

	/*@ResponseBody
	@RequestMapping(value = "/admin_user_edit", method = { RequestMethod.POST,RequestMethod.GET })
	public Map admin_user_edit(Integer id) {
		Map data = new HashMap();
		UserCustom userCustom = userService.findUserById(id);
		data.put("userCustom", userCustom);
		return data;
	}*/
	

	@RequestMapping("/admin_user_editSubmit")
	public String admin_user_editSubmit(Integer id,UserCustom userCustom) {		
		userService.updateUser(id, userCustom);		
		return "forward:admin_user_list";
	}
	
	/*@ResponseBody
	@RequestMapping("/admin_user_editSubmit")
	public Map admin_user_editSubmit(Integer id,@RequestBody UserCustom userCustom) {
		Map data = new HashMap();
		userService.updateUser(id, userCustom);
		data.put("status", 200);
		data.put("msg", "success");
		return data;
	}*/

	
	@RequestMapping("/admin_user_del")
	public String admin_user_del(Integer id,UserCustom userCustom) {
		userService.deleteUser(id, userCustom);
		return "forward:admin_user_list";
	}

	/*@ResponseBody
	@RequestMapping("/admin_user_del")
	public Map admin_user_del(Integer id,@RequestBody UserCustom userCustom) {
		Map data = new HashMap();
		userService.deleteUser(id, userCustom);
		data.put("status", 200);
		data.put("msg", "success");
		return data;
	}*/
	
	@RequestMapping("/admin_user_isdel")
	public String admin_user_isdel(Integer id,UserCustom userCustom) {		
		userService.isdeleteUser(id, userCustom);	
		return "forward:admin_user_list";
	}
	
	/*@ResponseBody
	@RequestMapping("/admin_user_isdel")
	public Map admin_user_isdel(Integer id,@RequestBody UserCustom userCustom) {
		Map data = new HashMap();
		userService.isdeleteUser(id, userCustom);
		data.put("status", 200);
		data.put("msg", "success");
		return data;
	}*/

	@RequestMapping("/admin_user_nodel")
	public String admin_user_nodel(Integer id,UserCustom userCustom) {		
		userService.nodeleteUser(id, userCustom);		
		return "forward:admin_user_list";
	}
	
	/*@ResponseBody
	@RequestMapping("/admin_user_nodel")
	public Map admin_user_nodel(Integer id,@RequestBody UserCustom userCustom) {
		Map data = new HashMap();
		userService.nodeleteUser(id, userCustom);
		data.put("status", 200);
		data.put("msg", "success");
		return data;
	}*/

	//轮播图管理
	// 限制http请求方法
	/*	@RequestMapping(value = "/admin_banner_list", method = {
				RequestMethod.POST, RequestMethod.GET })
		public ModelAndView admin_banner_list(Integer id) throws Exception {
			// 创建返回的对象modeAndView
			ModelAndView modelAndView = new ModelAndView();
			// 将参数传入Service层进行处理
			Banner bannerCustom = bannerService.findBannerById(id);
			// 将处理的结果封装到ModelAndView中
			modelAndView.addObject("bannerCustom", bannerCustom);
			// 返回到jsp显示
			return modelAndView;
		}

		@RequestMapping("/admin_banner_editSubmit")
		public String admin_banner_editSubmit(HttpServletRequest request,
				Integer id, Banner bannerCustom) throws Exception {
			bannerService.updateBanner(id, bannerCustom);
			// forward返回到jsp显示
			request.setAttribute("msg", "修改成功！");
			request.setAttribute("href", "/admin/admin_banner_list.action?id=1");
			return "forward:/WEB-INF/jsp/result.jsp";
		}*/


		@RequestMapping("/admin_cate_list")
		public ModelAndView admin_cate_list(){
			// 创建返回的对象modeAndView
			ModelAndView modelAndView = new ModelAndView();
			// 将参数传入Service层进行处理
			List<Cate> findCateList = cateService.findCateList();
			// 将处理的结果封装到ModelAndView中
			modelAndView.addObject("findCateList", findCateList);
			// 返回到jsp显示
			modelAndView.setViewName("admin/admin_cate_list");
			return modelAndView;
		}

		@RequestMapping("/admin_tag_list")
		public ModelAndView admin_tag_list() {
			// 创建返回的对象modeAndView
			ModelAndView modelAndView = new ModelAndView();
			// 将参数传入Service层进行处理
			List<Tag> findTagList = tagService.findTagList();
			// 将处理的结果封装到ModelAndView中
			modelAndView.addObject("findTagList", findTagList);
			// 返回到jsp显示
			modelAndView.setViewName("admin/admin_tag_list");
			return modelAndView;
		}

		@RequestMapping("/admin_cate_add")
		public String admin_cate_add() {

			return "admin/admin_cate_add";
		}

		@RequestMapping("/admin_tag_add")
		public String admin_tag_add() {
		
			return "admin/admin_tag_add";
		}

		@RequestMapping("/admin_cate_addSubmit")
		public String admin_cate_addSubmit(HttpServletRequest request,
				Cate cate, String catename) {
			Cate r = cateService.findCateName(catename);
			if (r != null) {
				request.setAttribute("msg", "分类已存在！请重新添加！");
				request.setAttribute("href", "/admin/admin_cate_add");
				return "forward:/WEB-INF/jsp/result.jsp";
			} else {
				
				cateService.insertCate(cate);
				request.setAttribute("msg", "添加成功！");
				request.setAttribute("href", "/admin/admin_cate_list");
				return "forward:/WEB-INF/jsp/result.jsp";
			}
		}

		@RequestMapping("/admin_tag_addSubmit")
		public String admin_tag_addSubmit(HttpServletRequest request,Tag tag, String tagname) {
			Tag r = tagService.findTagName(tagname);
			if (r != null) {
				request.setAttribute("msg", "标签已存在！请重新添加！");
				request.setAttribute("href", "/admin/admin_tag_add");
				return "forward:/WEB-INF/jsp/result.jsp";
			} else {
				// 调用service添加类型
				tagService.insertTag(tag);
				request.setAttribute("msg", "添加成功！");
				request.setAttribute("href", "/admin/admin_tag_list");
				return "forward:/WEB-INF/jsp/result.jsp";
			}
		}


		// 限制http请求方法
		@RequestMapping(value = "/admin_cate_edit", method = {
				RequestMethod.POST, RequestMethod.GET })
		public ModelAndView admin_cate_edit(Integer id) {
			// ,创建返回的对象modeAndView
			ModelAndView modelAndView = new ModelAndView();
			// 将参数传入Service层进行处理
			Cate cate = cateService.findCateById(id);
			// 将处理的结果封装到ModelAndView中
			modelAndView.addObject("cate", cate);
			// 返回到jsp显示
			return modelAndView;
		}

		@RequestMapping(value = "/admin_tag_edit", method = {
				RequestMethod.POST, RequestMethod.GET })
		public ModelAndView admin_tag_edit(Integer id) {
			// ,创建返回的对象modeAndView
			ModelAndView modelAndView = new ModelAndView();
			// 将参数传入Service层进行处理
			Tag tag = tagService.findTagById(id);
			modelAndView.addObject("tag", tag);
			// 返回到jsp显示
			return modelAndView;
		}

		// 定义访问子路径
		@RequestMapping("/admin_cate_editSubmit")
		public String admin_cate_editSubmit(Integer id,Cate cate) {
			// 调用service更新信息
			cateService.updateCate(id, cate);
			// forward返回到jsp显示
			return "forward:admin_cate_list";
		}

		@RequestMapping("/admin_tag_editSubmit")
		public String admin_tag_editSubmit(Integer id, Tag tag) {
			// 调用service更新信息
			tagService.updateTag(id, tag);
			// forward返回到jsp显示
			return "forward:admin_tag_list";
		}

		@RequestMapping("/admin_cate_del")
		public String admin_cate_del(HttpServletRequest request, Integer id){
			// 调用service更新信息
			cateService.delCate(id);
			// forward返回到jsp显示
			request.setAttribute("msg", "删除成功!");
			request.setAttribute("href", "/admin/admin_cate_list");
			return "forward:/WEB-INF/jsp/result.jsp";
		}
		
		@RequestMapping("/admin_cate1_del")
		public String admin_cate_del(Integer id){
			// 调用service更新信息
			cateService.delCate(id);
			// forward返回到jsp显示
			return "forward:/admin/admin_cate_del?id=" + id;
		}

		@RequestMapping("/admin_tag_del")
		public String admin_tag_del(HttpServletRequest request, Integer id){
			// 调用service更新信息
			tagService.delTag(id);
			// forward返回到jsp显示
			request.setAttribute("msg", "删除成功!");
			request.setAttribute("href", "/admin/admin_tag_list");
			return "forward:/WEB-INF/jsp/result.jsp";
		}
		
		@RequestMapping("/admin_tag1_del")
		public String admin_tag_del(Integer id){
			// 调用service更新信息
			tagService.delTag(id);
			// forward返回到jsp显示
			return "forward:/admin/admin_tag_del?id=" + id;
		}
		
}
