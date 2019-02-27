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
import cn.aos.po.User;
import cn.aos.service.Searchtank;
import cn.aos.service.Userservice;

@Controller
public class login {

	@Autowired
	@Qualifier("userservice")
	private Userservice userservice;
	@Autowired
	@Qualifier("searchtank")
	private Searchtank searchtank;

	@RequestMapping("/welcome1.action")
	public ModelAndView welcom() throws Exception {

		User user = new User();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("oil/login");
		return modelAndView;
	}

	@RequestMapping("/login.action")
	public ModelAndView ologin(HttpServletResponse response,
			HttpServletRequest request, HttpSession session, User user)
			throws Exception {

		// user.setUname(request.getParameter("uname"));
		// user.setPassword(request.getParameter("pwd"));
		// String uname=request.getParameter("uname");
		// String pwd=request.getParameter("pwd");
		String uname = request.getParameter("uname");
		String pwd = request.getParameter("password");
		request.getSession().setAttribute("uname", uname);
		request.getSession().setAttribute("pwd", pwd);
		User user1 = userservice.selectByNameAndPwd(uname, pwd);
		ModelAndView modelAndView = new ModelAndView();
		String authority = user1.getAthority();
		String pro = user1.getPro();
		// char s1=authority.charAt(0);
		// char s2=authority.charAt(1);
		List<Autho> autholist = searchtank.selectByAutAndPro(authority, pro);
		modelAndView.addObject("autholist", autholist);
		modelAndView.addObject("authority", authority);
		modelAndView.addObject("uname", uname);
		modelAndView.addObject("pro", pro);
		session.setAttribute("authority", authority);
		session.setAttribute("pro", pro);
		session.setAttribute("uname", uname);
		session.setAttribute("pwd", pwd);

		modelAndView.setViewName("oil/Public");

		return modelAndView;
	}

	@RequestMapping("/test.action")
	public ModelAndView test(HttpServletResponse response,
			HttpServletRequest request, User user) throws Exception {

		// user.setUname(request.getParameter("uname"));
		// user.setPassword(request.getParameter("pwd"));
		// String uname=request.getParameter("uname");
		// String pwd=request.getParameter("pwd");
		// User user1=userservice.selectByNameAndPwd(uname, pwd);
		// String authority=user1.getAthority();
		// String pro=user1.getPro();
		// //char s1=authority.charAt(0);
		// //char s2=authority.charAt(1);
		// List<Autho> autholist=searchtank.selectByAutAndPro(authority, pro);
		ModelAndView modelAndView = new ModelAndView();
		// modelAndView.addObject("autholist",autholist);
		// modelAndView.setViewName("oil/Public");
		String typr = "worker";
		if (typr.equals("worker")) {

			modelAndView.setViewName("oil/Public");
			return modelAndView;
		}

		return modelAndView;
	}

	@RequestMapping("/userlist.action")
	public ModelAndView userlist(HttpServletResponse response,
			HttpServletRequest request, HttpSession session, User user)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String uname = (String) request.getSession().getAttribute("uname");
		String pwd = (String) request.getSession().getAttribute("pwd");
		String userroleplay = userservice.selectroleplay(uname, pwd);
		if (userroleplay.equals("admin")) {
			List<User> listall = userservice.selectfindall();
			modelAndView.addObject("listall", listall);
			modelAndView.setViewName("oil/userlist");

			return modelAndView;
		} else {
			String msg = "你不具有此权限！！！";
			JOptionPane.showMessageDialog(null, msg);
			modelAndView.setViewName("oil/Public");
			return modelAndView;
		}

	}

	@RequestMapping("/userupdate.action")
	public ModelAndView userupdate(HttpServletResponse response,
			HttpServletRequest request, HttpSession session, User user,
			@RequestParam(value = "id", required = false) Integer id)
			throws Exception {
		request.getSession().setAttribute("id", id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("oil/userupdate");

		return modelAndView;
	}

	@RequestMapping("/userupdatedb.action")
	public ModelAndView userupdatedb(HttpServletResponse response,
			HttpServletRequest request, HttpSession session, User user)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		int id = (Integer) request.getSession().getAttribute("id");
		String phonenumber = request.getParameter("phonenumber");
		String roleplay = request.getParameter("roleplay");
		String athority = request.getParameter("athority");
		String pro = request.getParameter("pro");
		userservice.userupdatedb(id, phonenumber, roleplay, athority, pro);
		modelAndView.setViewName("redirect:/userlist.action");

		return modelAndView;
	}

	@RequestMapping("/userdelete.action")
	public ModelAndView userdelete(HttpServletResponse response,
			HttpServletRequest request, HttpSession session, User user,
			@RequestParam(value = "id", required = false) int id)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		userservice.userdelete(id);
		modelAndView.setViewName("redirect:/userlist.action");

		return modelAndView;
	}

	@RequestMapping("/userselect.action")
	public ModelAndView userselect(HttpServletResponse response,
			HttpServletRequest request, HttpSession session, User user)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String name = request.getParameter("uname");
		List<User> listall = userservice.userselect(name);
		modelAndView.addObject("listall", listall);
		modelAndView.setViewName("oil/userlist");
		return modelAndView;
	}

	@RequestMapping("/userinsert.action")
	public ModelAndView userinsert(HttpServletResponse response,
			HttpServletRequest request, HttpSession session, User user)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		int age = Integer.parseInt(request.getParameter("age"));
		String sex = request.getParameter("type");
		String phone = request.getParameter("phone");
		String roleplay = request.getParameter("roleplay");
		String athority = request.getParameter("athority");
		String pro = request.getParameter("pro");
		userservice.userinsert(name, pwd, age, sex, phone, roleplay, athority,
				pro);
		modelAndView.setViewName("redirect:/userlist.action");
		return modelAndView;
	}

	@RequestMapping("/userpwdupdate.action")
	public ModelAndView userpwdupdate(HttpServletResponse response,
			HttpServletRequest request, HttpSession session, User user)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String name = (String) request.getSession().getAttribute("uname");
		String newpassword = request.getParameter("newPassword");
		userservice.userpwdupdate(name, newpassword);
		userservice.tishi();
		modelAndView.setViewName("redirect:/welcome1.action");

		return modelAndView;
	}
}
