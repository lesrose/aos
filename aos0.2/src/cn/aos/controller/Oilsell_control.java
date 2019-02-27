package cn.aos.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.aos.po.Autho;
import cn.aos.po.Oil;
import cn.aos.po.Oilsell;
import cn.aos.po.User;
import cn.aos.service.Oilsell_server;
import cn.aos.service.Userservice;

@Controller
public class Oilsell_control {
	@Autowired
	@Qualifier("oilsell_server")
	private Oilsell_server oilsell_server;
	@Autowired
	@Qualifier("userservice")
	private Userservice userservice;

	@RequestMapping("/oilwelcme.action")
	public ModelAndView queryTank(HttpSession session) throws Exception {

		User user = new User();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("oilsell/oilsellwlm");
		return modelAndView;
	}

	@RequestMapping("/oilupdate.action")
	private String update(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String oilname = request.getParameter("oilname");
		float price = Float.valueOf(request.getParameter("price"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		// String pubdate=request.getParameter("pubdate");
		String leavecnt = request.getParameter("leavecnt");
		// ModelAndView modelAndView = new ModelAndView();
		try {

			Oil s = new Oil(id, oilname, price, amount, leavecnt);
			oilsell_server.update(s);

		} catch (SQLException e) {
			// TODO Auto-generated catch block;
			e.printStackTrace();
		}
		return "redirect:oilfinall.action";

	}

	@RequestMapping("/oilfindByid.action")
	private ModelAndView findById(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "id", required = false) Integer id)
			throws IOException, ServletException, SQLException {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(id);
		List<Oil> s = oilsell_server.findById(id);
		request.getSession().setAttribute("id", id);
		// float price = s.get(0).getPrice();
		// request.getSession().setAttribute("price", price);

		// 填充数据
		modelAndView.addObject("s", s);
		// 视图
		modelAndView.setViewName("l/add2");
		return modelAndView;
	}

	@RequestMapping("/oilfindByid2.action")
	private ModelAndView findById2(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "id", required = false) Integer id)
			throws IOException, ServletException, SQLException {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println(id);
		List<Oil> list = oilsell_server.findById(id);
		// List<Oil> list1 = oilsell_server.findById1(id);
		request.getSession().setAttribute("id", id);
		float price = list.get(0).getPrice();
		request.getSession().setAttribute("price", price);

		// 填充数据
		modelAndView.addObject("list", list);
		// modelAndView.addObject("list1", list1);
		// 视图
		modelAndView.setViewName("l/list");
		return modelAndView;
	}

	@RequestMapping("/oildelete.action")
	private String delete(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		try {

			oilsell_server.delete(id);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:oilfinall.action";
	}

	@RequestMapping("/oiladd.action")
	private String add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		String oilname = request.getParameter("oilname");
		float price = Float.valueOf(request.getParameter("price"));
		// int amount=Integer.parseInt(request.getParameter("amount"));
		// String pubdate=request.getParameter("pubdate");
		String leavecnt = request.getParameter("leavecnt");

		try {
			Oil st = new Oil(id, oilname, price, leavecnt);
			oilsell_server.add(st);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:oilfinall.action";
	}

	@RequestMapping("/oilfinall.action")
	private ModelAndView findAll(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException,
			ServletException, SQLException {
		// TODO Auto-generated method stub
		// ModelAndView modelAndView = new ModelAndView();
		List<Oil> list = oilsell_server.findAll();
		ModelAndView modelAndView = new ModelAndView();

		// 填充数据
		modelAndView.addObject("list", list);
		// 视图
		modelAndView.setViewName("l/index");
		return modelAndView;

	}

	// 加油操作
	@RequestMapping("/updateoilsell.action")
	private String updateoilsell(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException,
			ServletException, SQLException {
		int id = (Integer) request.getSession().getAttribute("id");
		int m = Integer.parseInt(request.getParameter("s"));
		System.out.println(m);
		String number = oilsell_server.selectnumber(id);
		System.out.println(number);
		int num = Integer.parseInt(number);
		if (m <= num) {
			float price = (Float) request.getSession().getAttribute("price");
			float toprice = m * price;
			oilsell_server.updateoilsell(id, m);
			oilsell_server.insertprice(id, m, toprice);
			return "redirect:oilfindByid2.action?id=" + id;
		}else {
			String msg = "油量不足,请重新输入！！！";
			JOptionPane.showMessageDialog(null, msg);
			return "redirect:oilfindByid2.action?id=" + id;
		}

	}

	// 添加油操作
	@RequestMapping("/updateoilsell2.action")
	private String updateoilsell2(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException,
			ServletException, SQLException {
		int id = (Integer) request.getSession().getAttribute("id");
		int m = Integer.parseInt(request.getParameter("leavecnt"));
		float price = (Float) request.getSession().getAttribute("price");
		float l = m * price;
		oilsell_server.updateoilsell2(id, m);
		return "redirect:oilfindByid.action?id=" + id;
	}

}
