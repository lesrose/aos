package cn.aos.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.aos.po.Autho;
import cn.aos.po.Oiltank;
import cn.aos.service.OilService;
import cn.aos.service.Searchtank;
import cn.aos.service.Userservice;

@Controller
public class Stlist {
	
	@Autowired
	@Qualifier("oilService")
	private OilService oilService;
	@Autowired
	@Qualifier("searchtank")
	private Searchtank searchtank;
	@Autowired
	@Qualifier("userservice")
	private Userservice userservice;
	
	@RequestMapping("/stlist.action")
	public ModelAndView stlist(HttpSession session) throws Exception {	
		List<Autho> autho=searchtank.selectAll();
		List<String> v=new ArrayList();
		for (int i = 0; i < autho.size(); i++) {
			v.add(autho.get(i).getSname());
		}
		//System.out.println(v.toString());
		List<String> p=new ArrayList();
	    for (int i = 0; i < v.size(); i++) {
	    	int a=jug(v.get(i));
			String c=v.get(i).substring(0, a);
			if(!p.contains(c)){
				p.add(c);
			}		
		}
		// 创建modelAndView准备填充数据、设置视图
		ModelAndView modelAndView = new ModelAndView();
		session.setAttribute("b", p);
		modelAndView.addObject("b", p);
		// 视图
		modelAndView.setViewName("oil/stlist");
		return modelAndView;
	}
	
	
	@RequestMapping("/tanklist.action")
	public ModelAndView uptankdate(HttpSession session,@RequestParam(value="id",required=false) Integer id) throws Exception {

		//String oname=(String) session.getAttribute("oname");
		//Oiltank oiltank=oilService.findById(oname, id);
		//session.setAttribute("oiltank", oiltank);
		List<String> a=(List<String>) session.getAttribute("b");
		String s=a.get(id);
		List<Autho> autho=searchtank.selectBystName(s);
		// 创建modelAndView准备填充数据、设置视图
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("autho", autho);
		// 视图
		modelAndView.setViewName("oil/tanklist");

		return modelAndView;
	}
	
	public static int jug(String a){

		int c=0;
		for (int j = 0; j <a.length(); j++) {
			if(a.charAt(j)>=48&&a.charAt(j)<=57){
				break;
			}else c++;
		}	
	return c;
}
	

}
