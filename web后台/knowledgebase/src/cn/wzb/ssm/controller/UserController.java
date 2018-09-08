package cn.wzb.ssm.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.wzb.ssm.po.UserCustom;
import cn.wzb.ssm.po.Cate;
import cn.wzb.ssm.po.Collect;
import cn.wzb.ssm.po.CollectCustom;
import cn.wzb.ssm.po.KnowledgeCustom;
import cn.wzb.ssm.po.Tag;
import cn.wzb.ssm.po.Tags;
import cn.wzb.ssm.po.User;
import cn.wzb.ssm.service.CateService;
import cn.wzb.ssm.service.CollectionService;
import cn.wzb.ssm.service.KnowledgeService;
import cn.wzb.ssm.service.TagService;
import cn.wzb.ssm.service.TagsService;
import cn.wzb.ssm.service.UserService;

@Controller

@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CollectionService collectionService;
	
	@Autowired
	private KnowledgeService knowledgeService;
	
	@Autowired
	private CateService cateService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private TagsService tagsService;

	@ResponseBody
	@RequestMapping("/user_knowledge_list")
	public List<KnowledgeCustom> user_knowledge_list(Integer id) {
		List<KnowledgeCustom> knowledgeList = knowledgeService.findUserKnowledgeList(id);
		return knowledgeList ;
	}
	
	/*@ResponseBody
	@RequestMapping("/user_knowledge_list1")
	public Map user_knowledge_list1(Integer id) {
		Map data = new HashMap();
		UserCustom userCustom = userService.findUserById(id);
		List<KnowledgeCustom> knowledgeList = knowledgeService.findUserKnowledgeList(userCustom.getId());
		if(knowledgeList != null) {
			data.put("knowledgeList", knowledgeList);
		}
		else {
			data.put("status", 302);
			data.put("msg", "未知原因，查询失败");
		}
			
		return data ;
	}*/
	

/*	@ResponseBody
	@RequestMapping("/user_knowledge_add")
	public List user_knowledge_add() {
		List lt = new ArrayList();
		List<Cate> findCateList = cateservice.findCateList();
		List<Tag> findTagList = tagService.findTagList();
		lt.add(findCateList);
		lt.add(findTagList);
		return lt;
	}*/
	
	

	@ResponseBody
	@RequestMapping(value ="/user_knowledge_addSubmit", method = { RequestMethod.POST,RequestMethod.GET })
	public Map user_knowledge_addSubmit(String title,String knowledgecontent,String tagname,String catename) {
		Map data = new HashMap();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		KnowledgeCustom knowledgeCustom = new KnowledgeCustom();	
		knowledgeCustom.setTitle(title);
		knowledgeCustom.setUserid(2);
		knowledgeCustom.setSfshare(0);
		knowledgeCustom.setTime(df.format(new Date()));
		knowledgeCustom.setKnowledgecontent(knowledgecontent);
		Cate cate = cateService.findCateName(catename);
		knowledgeCustom.setCateid(cate.getId());
		knowledgeService.insertKnowledge(knowledgeCustom);
		KnowledgeCustom kc = knowledgeService.findEntityByName(title);
		Tags tags = new Tags();
		Tag tag = tagService.findTagName(tagname);
		tags.setTagid(tag.getId());
		tags.setKnowledgeid(kc.getId());
		tagsService.insertTag(tags);
		data.put("status", 200);
		data.put("msg", "添加成功");
		return data;
	}

	@ResponseBody
	@RequestMapping("/user_knowledge_editSubmit")
	public Map user_knowledge_editSubmit(Integer id, KnowledgeCustom knowledgeCustom,String catename){
		Map data = new HashMap();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Cate cate = cateService.findCateName(catename);
		System.out.println(knowledgeCustom.getKnowledgecontent());
		System.out.println(cate.getId());
		knowledgeCustom.setCateid(cate.getId());
		knowledgeCustom.setTime(df.format(new Date()));
		knowledgeService.updateKnowledge(id, knowledgeCustom);
		data.put("status", 200);
		data.put("msg", "添加成功");
		return data;
	}
	
	
	@ResponseBody
	@RequestMapping("/user_knowledge_del")
	public Map user_knowledge_del(Integer id) {
		Map data = new HashMap();
		knowledgeService.deleteknowledge(id);
		data.put("status", 200);
		data.put("msg", "已删除");
		return data;
	}
	
	@ResponseBody
	@RequestMapping("/user_cate_list")
	public List<Cate> user_cate_list(Integer id) {
		List<Cate> catelist = knowledgeService.findKnowledgecatelist(id);
		return catelist;		
	}
	
	@ResponseBody
	@RequestMapping("/user_cate_edit")
	public Map user_cate_edit(Integer id,Cate cate) {
		Map data = new HashMap();
		cateService.updateCate(id, cate);
		return data;		
	}
	
	@ResponseBody
	@RequestMapping("/user_cate_del")
	public Map user_cate_del(Integer id) {
		Map data = new HashMap();
		cateService.delCate(id);
		data.put("status", 200);
		data.put("msg", "已删除");
		return data;
	}
	
	@ResponseBody
	@RequestMapping("/user_inf")
	public UserCustom user_inf(Integer id) {
		UserCustom userCustom = userService.findUserById(id);
		return userCustom;
	}

	@ResponseBody
	@RequestMapping(value = "/user_inf_edit", method = { RequestMethod.POST,RequestMethod.GET })
	public UserCustom user_inf_edit(Integer id) {
		UserCustom userCustom = userService.findUserById(id);
		return userCustom;
	}

	@RequestMapping("/user_inf_editSubmit")
	public Map user_inf_editSubmit(Integer id,UserCustom userCustom){
		Map data = new HashMap();
		userService.updateUser(id, userCustom);
		return data;
	}
	
	
	@ResponseBody
	@RequestMapping("/add_Collection")
	public Map add_Collection(Collect relevance){
		Map data = new HashMap();
		int	count = relevance.getCount();
		count = count +1;	
		relevance.setCount(count);
		collectionService.insert(relevance);
		KnowledgeCustom knowledgeCustom = knowledgeService.getEntity(relevance.getKnowledgeid());
		knowledgeCustom.setCount(count);
		knowledgeService.updateCount(knowledgeCustom.getId(), knowledgeCustom);
		data.put("msg", "收藏成功！");
		return data;
	}
	
	@ResponseBody
	@RequestMapping("/list_Collection")
	public List<CollectCustom> list_Collection(User user) {
		List<CollectCustom> knowledge = collectionService.findKnowledgeIdByUserId(user);
/*		List<CollectCustom> tag = knowledgeService.findTaglist(user.getId());
		knowledge.addAll(tag);*/
		return knowledge;
	}

	@ResponseBody
	@RequestMapping("/delete_Collection")
	public Map delete_Collection(Integer id) {
		Map data = new HashMap();
		CollectCustom collectCustom = collectionService.getEntity(id);
		collectionService.deleteCollection(id);
		KnowledgeCustom knowledgeCustom = knowledgeService.getEntity(collectCustom.getKnowledgeid());
		int count = 0;
		if(knowledgeCustom.getCount() != null) {
		count = knowledgeCustom.getCount();
		count = count -1;
		}
		knowledgeCustom.setCount(count);
		knowledgeService.updateCount(knowledgeCustom.getId(), knowledgeCustom);
		data.put("msg", "已取消收藏");
		return data;
	}
	
	@ResponseBody
	@RequestMapping("/knowledge_isshare")
	public Map knowledge_isshare(Integer id) {
		Map data = new HashMap();
		knowledgeService.isdeleteKnowledge(id);
		data.put("status", 200);
		data.put("msg", "已取消分享");
		return data;
	}
	
/*	@ResponseBody
	@RequestMapping("/knowledge_isdelshare")
	public Map knowledge_isdelshare(Integer id) {
		Map data = new HashMap();
		knowledgeService.isdelshare(id);
		data.put("status", 200);
		data.put("msg", "已取消分享");
		return data;
	}*/
	
	@ResponseBody
	@RequestMapping("/list_Share")
	public List<KnowledgeCustom> list_Share(Integer id) {
		List<KnowledgeCustom> knowledge = knowledgeService.findShareKnowledgeByUserId(id);
		return knowledge;
	}
	
	@ResponseBody
	@RequestMapping("/knowledge_onshare")
	public Map knowledge_onshare(Integer id) {
		Map data = new HashMap();
		knowledgeService.nodeleteKnowledge(id);
		data.put("status", 200);
		data.put("msg", "分享成功");
		return data;
	}
	
}
