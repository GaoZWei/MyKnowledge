package cn.wzb.ssm.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.wzb.ssm.po.Cate;
import cn.wzb.ssm.po.KnowledgeCustom;
import cn.wzb.ssm.po.Tag;
import cn.wzb.ssm.service.CateService;
import cn.wzb.ssm.service.KnowledgeService;
import cn.wzb.ssm.service.TagService;

@Controller
//定义该Controller的根访问路径 /views
@RequestMapping("/views")
public class KnowledgeController {
	
	@Autowired
	private KnowledgeService knowledgeService;
	
	@Autowired
	private CateService cateservice;
	
	@Autowired
	private TagService tagService;

	@ResponseBody
	@RequestMapping("/knowledge_list_online")
	public List knowledge_list_online() {
		List lt = new ArrayList();
		List<KnowledgeCustom> knowledgeList = knowledgeService.findOnlineKnowledgeList(null);
		List<Cate> findCateList = cateservice.findCateList();
		List<Tag> findTagList = tagService.findTagList();
		lt.add(knowledgeList);
		lt.add(findCateList);
		lt.add(findTagList);
		return lt ;
		
	}
	
	@ResponseBody
	@RequestMapping("/knowledge_list_hot")
	public List<KnowledgeCustom> knowledge_list_hot() {
		List<KnowledgeCustom> knowledgeList = knowledgeService.findHotKnowledgeList(null);
		return knowledgeList;
	}
	
	@ResponseBody
	@RequestMapping("/knowledge_inf")
	public List knowledge_inf(Integer id) {
		List lt = new ArrayList();
		KnowledgeCustom knowledgeinf = knowledgeService.findKnowledgeById(id);
		List<KnowledgeCustom> findKnowledgeinf = knowledgeService.findKnowledgeinf(knowledgeinf.getId());
		List<KnowledgeCustom> findSameTypeKnowledgeCustomList = knowledgeService
				.findSameTypeKnowledgeList(knowledgeinf.getCateid());
		lt.add(findKnowledgeinf);
		lt.add(findSameTypeKnowledgeCustomList);
		return lt ;
	}

	@ResponseBody
	@RequestMapping("/select_knowledge_list")
	public List<KnowledgeCustom> select_knowledge_list(String title) {
		List<KnowledgeCustom> knowledgelist = knowledgeService.findKnowledgeSelByName(title);
		if(title == null) {
			return null;
		}else {
		return knowledgelist;
		}
	}
	
}
		// 模糊查询商品
		/*@RequestMapping("/select_knowledge_list")*/
		/*public ModelAndView select_goods_list(String name) throws Exception {
			// 创建返回的对象modeAndView
			ModelAndView modelAndView = new ModelAndView();
			List<GoodsCustom> goodList = goodsService.findGoodSelName(name);
			if (name == null) {
				modelAndView.setViewName("/index.action");
			} else {

				modelAndView.addObject("goodList", goodList);
				// 返回到jsp显示
				modelAndView.setViewName("/views/select_goods_list");
			}

			return modelAndView;
		}*/
		

