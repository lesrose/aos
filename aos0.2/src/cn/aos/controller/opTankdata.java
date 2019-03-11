package cn.aos.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.aos.po.Autho;
import cn.aos.po.Oiltank;
import cn.aos.po.OiltankPlus;
import cn.aos.po.User;
import cn.aos.service.OilService;
import cn.aos.service.Searchtank;
import cn.aos.service.Userservice;

@Controller
public class opTankdata {

	@Autowired
	@Qualifier("oilService")
	private OilService oilService;
	@Autowired
	@Qualifier("searchtank")
	private Searchtank searchtank;
	@Autowired
	@Qualifier("userservice")
	private Userservice userservice;

	@RequestMapping("/uptankdate.action")
	public ModelAndView uptankdate(HttpSession session,
			HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "id", required = false) Integer id)
			throws Exception {

		String oname = (String) session.getAttribute("oname");
		Oiltank oiltank = oilService.findById(oname, id);
		session.setAttribute("oiltank", oiltank);
		String uname = (String) request.getSession().getAttribute("uname");
		String pwd = (String) request.getSession().getAttribute("pwd");
		String userroleplay = userservice.selectroleplay(uname, pwd);
		// 创建modelAndView准备填充数据、设置视图
		ModelAndView modelAndView = new ModelAndView();
		if (userroleplay.equals("woker")) {
			modelAndView.addObject("oiltank", oiltank);
			// 视图
			modelAndView.setViewName("oil/tankupdate");

			return modelAndView;
		} else {
			String msg = "你不具有此权限！！！";
			JOptionPane.showMessageDialog(null, msg);
			modelAndView.setViewName("redirect:/querytank.action");
			return modelAndView;
		}
	}

	@RequestMapping("/uptankdateSubmit.action")
	public String uptankdateSubmit(HttpSession session,
			HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		String oname = (String) session.getAttribute("oname");
		Oiltank oiltank = (Oiltank) session.getAttribute("oiltank");
		// 创建modelAndView准备填充数据、设置视图
		// int id=(int) request.getAttribute("id");
		String height = request.getParameter("height");
		String volume = request.getParameter("volume");
		double h = Double.parseDouble(height);
		double v = Double.parseDouble(volume);
		// oiltank.setId(id);
		oiltank.setHeight(h);
		oiltank.setVolume(v);
		// oilService.uptankById(oname, oiltank);
		oilService.uptankById1(oname, h, v, oiltank.getId());
		// ModelAndView modelAndView = new ModelAndView();

		// 视图
		// modelAndView.setViewName("items/upTankdate");

		return "success";
	}

	
	//向油罐表添加一条数据
	@RequestMapping("/addTankdata.action")
	public ModelAndView addTankdata(HttpSession session,
			HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		// 创建modelAndView准备填充数据、设置视图
		ModelAndView modelAndView = new ModelAndView();
		String uname = (String) request.getSession().getAttribute("uname");
		String pwd = (String) request.getSession().getAttribute("pwd");
		String userroleplay = userservice.selectroleplay(uname, pwd);
		if (userroleplay.equals("woker")) {
			// 视图
			modelAndView.setViewName("oil/addtank");

			return modelAndView;
		} else {
			String msg = "你不具有此权限！！！";
			JOptionPane.showMessageDialog(null, msg);
			modelAndView.setViewName("redirect:/querytank.action");
			return modelAndView;
		}
	}

	@RequestMapping("/addTankdataSubmit.action")
	public String addTankdataSubmit(HttpSession session,
			HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		String oname = (String) session.getAttribute("oname");

		String height = request.getParameter("height");
		String volume = request.getParameter("volume");
		double h = Double.parseDouble(height);
		double v = Double.parseDouble(volume);
		OiltankPlus oiltankPlus = new OiltankPlus();
		oiltankPlus.setHeight(h);
		oiltankPlus.setVolume(v);
		oiltankPlus.setTname(oname);
		// oilService.addTankdata(oname, h, v);
		oilService.addTankdata1(oiltankPlus);
		//return "success";
		return "oil/showdate";
	}
	
	
	
	@RequestMapping("/deleteTankdata.action")
	public String deleteTankdata(HttpSession session,
			HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "id", required = false) Integer id)
			throws Exception {
		String uname = (String) request.getSession().getAttribute("uname");
		String pwd = (String) request.getSession().getAttribute("pwd");
		String userroleplay = userservice.selectroleplay(uname, pwd);
		if (userroleplay.equals("woker")) {
			String oname = (String) session.getAttribute("oname");

			OiltankPlus oiltankPlus = new OiltankPlus();
			oiltankPlus.setId(id);
			oiltankPlus.setTname(oname);
			// oilService.addTankdata(oname, h, v);
			oilService.deleteById(oiltankPlus);
			return "success";
		} else {
			String msg = "你不具有此权限！！！";
			JOptionPane.showMessageDialog(null, msg);
			return "redirect:querytank.action";

		}
	}
	@RequestMapping("/deleteTankdataduo.action")
	public String deleteTankdataduo(HttpSession session,
			HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "id", required = false) Integer id)
			throws Exception {
//		String uname = (String) request.getSession().getAttribute("uname");
//		String pwd = (String) request.getSession().getAttribute("pwd");
//		String userroleplay = userservice.selectroleplay(uname, pwd);
//		if (userroleplay.equals("woker")) {
//			String oname = (String) session.getAttribute("oname");
//
//			OiltankPlus oiltankPlus = new OiltankPlus();
//			oiltankPlus.setId(id);
//			oiltankPlus.setTname(oname);
//			// oilService.addTankdata(oname, h, v);
//			oilService.deleteById(oiltankPlus);
//			return "success";
//		} else {
//			String msg = "你不具有此权限！！！";
//			JOptionPane.showMessageDialog(null, msg);
//			return "redirect:querytank.action";
//
//		}
		String oname = (String) session.getAttribute("oname");
		OiltankPlus oiltankPlus = new OiltankPlus();
		String[] checkbox=request.getParameterValues("deleteduo");
		//System.out.println("111111111"+checkbox[1]);
		for (int i = 0; i < checkbox.length; i++) {
			System.out.println("********"+checkbox[i]);
			
					oiltankPlus.setId(Integer.valueOf(checkbox[i]).intValue());
					oiltankPlus.setTname(oname);
						// oilService.addTankdata(oname, h, v);
						oilService.deleteById(oiltankPlus);
		}
		return "success";
	}
}
