package cn.aos.controller;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.fkit.domain.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.aos.po.Article;
import cn.aos.po.Opfile;
import cn.aos.service.ArticleService;
import cn.aos.service.Userservice;

@Controller
public class FileUploadController {
	@Autowired
	@Qualifier("userservice")
	private Userservice userservice;
	@Autowired
	@Qualifier("articleService")
	private ArticleService articleService;

	@RequestMapping("/upfile.action")
	public ModelAndView welcom() throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("oil/upfile");
		return modelAndView;
	}

	@RequestMapping("/showm.action")
	public ModelAndView showm() throws Exception {

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/articlefinall.action");
		return modelAndView;
	}

	// 上传文件会自动绑定到MultipartFile中
	@RequestMapping(value = "/upload.action", method = RequestMethod.POST)
	public String upload(HttpServletRequest request,
	// @RequestParam("description") String description,
			@RequestParam("file") MultipartFile file) throws Exception {

		// System.out.println(description);
		// 如果文件不为空，写入上传路径
		if (!file.isEmpty()) {
			// 上传文件路径
			String path = request.getServletContext().getRealPath("/upload/");
			// 上传文件名
			String filename = file.getOriginalFilename();
			File filepath = new File(path, filename);
			// 判断路径是否存在，如果不存在就创建一个
			if (!filepath.getParentFile().exists()) {
				filepath.getParentFile().mkdirs();
			}
			// 将上传文件保存到一个目标文件当中
			file.transferTo(new File(path + File.separator + filename));
			// System.out.print(path+File.separator+ filename);
			return "success";
		} else {
			return "error";
		}

	}

	// @RequestMapping(value="/register")
	// public String register(HttpServletRequest request,
	// @ModelAttribute User user,
	// Model model)throws Exception{
	// System.out.println(user.getUsername());
	// // 如果文件不为空，写入上传路径
	// if(!user.getImage().isEmpty()){
	// // 上传文件路径
	// String path = request.getServletContext().getRealPath(
	// "/images/");
	// // 上传文件名
	// String filename = user.getImage().getOriginalFilename();
	// File filepath = new File(path,filename);
	// // 判断路径是否存在，如果不存在就创建一个
	// if (!filepath.getParentFile().exists()) {
	// filepath.getParentFile().mkdirs();
	// }
	// // 将上传文件保存到一个目标文件当中
	// user.getImage().transferTo(new File(path+File.separator+ filename));
	// // 将用户添加到model
	// model.addAttribute("user", user);
	// return "userInfo";
	// }else{
	// return "error";
	// }
	// }

	@RequestMapping("/downfile.action")
	public ModelAndView downfile(HttpSession session) throws Exception {
		String path = "E:\\JAVA\\project\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp1\\wtpwebapps\\aos0.2\\upload";
		File file = new File(path);
		File[] array = file.listFiles();
		int[] a = new int[array.length];
		String[] p = new String[array.length];
		Opfile[] opfile = new Opfile[array.length];
		for (int i = 0; i < array.length; i++) {
			if (array[i].isFile()) {
				p[i] = array[i].getName();
				a[i] = i;
			}
		}
		for (int i = 0; i < opfile.length; i++) {
			opfile[i] = new Opfile();
			opfile[i].setFilename(p[i]);
			opfile[i].setId(i);
		}
		ModelAndView modelAndView = new ModelAndView();
		session.setAttribute("p", p);
		modelAndView.addObject("opfile", opfile);
		modelAndView.setViewName("oil/downfile");
		return modelAndView;

	}

	@RequestMapping(value = "/download")
	public ResponseEntity<byte[]> download(HttpSession session,
			HttpServletRequest request, @RequestParam("id") int id, Model model)
			throws Exception {

		String[] s = (String[]) session.getAttribute("p");
		String filename = s[id];
		// 下载文件路径
		String path = request.getServletContext().getRealPath("/upload/");
		// System.out.println(path);
		File file = new File(path + File.separator + filename);
		HttpHeaders headers = new HttpHeaders();
		// 下载显示的文件名，解决中文名称乱码问题 iso-8859-1
		// String downloadFielName = new
		// String(filename.getBytes("UTF-8"),"UTF-8");
		// 通知浏览器以attachment（下载方式）打开图片
		// System.out.print(filename);
		headers.setContentDispositionFormData("attachment", filename);
		// application/octet-stream ： 二进制流数据（最常见的文件下载）。
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 201 HttpStatus.CREATED
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
				headers, HttpStatus.CREATED);
	}

	@RequestMapping("/articlefinall.action")
	private ModelAndView articlefinall(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException,
			ServletException, SQLException {
		// TODO Auto-generated method stub
		// ModelAndView modelAndView = new ModelAndView();
		List<Article> list = articleService.findAll();
		ModelAndView modelAndView = new ModelAndView();

		// 填充数据
		modelAndView.addObject("list", list);
		// 视图
		modelAndView.setViewName("oil/message");
		return modelAndView;

	}

	@RequestMapping("/up.action")
	private ModelAndView up(HttpServletRequest request,
			HttpServletResponse response, Model model,
			@RequestParam(value = "id", required = false) int id)
			throws IOException, ServletException, SQLException {
		request.getSession().setAttribute("id", id);
		ModelAndView modelAndView = new ModelAndView();
		// 视图
		String uname = (String) request.getSession().getAttribute("uname");
		String pwd = (String) request.getSession().getAttribute("pwd");
		String userroleplay = userservice.selectroleplay(uname, pwd);
		if (userroleplay.equals("boss")) {
			modelAndView.setViewName("oil/msupdate");

			return modelAndView;
		} else {
			String msg = "你不具有此权限！！！";
			JOptionPane.showMessageDialog(null, msg);
			modelAndView.setViewName("redirect:/articlefinall.action");
			return modelAndView;
		}
	}

	@RequestMapping("/articleupdate.action")
	private ModelAndView articleupdate(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException,
			ServletException, SQLException {
		String date = request.getParameter("lytext");
		int id = (Integer) request.getSession().getAttribute("id");
		// int id=Integer.parseInt(request.getParameter("id"));
		// autho.setId(id);
		System.out.println(id);
		System.out.println(date);
		articleService.updatearticle(id, date);

		ModelAndView modelAndView = new ModelAndView();

		// 填充数据
		// 视图
		modelAndView.setViewName("redirect:/articlefinall.action");
		return modelAndView;

	}

	@RequestMapping("/articleinsert.action")
	private ModelAndView articleinsert(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException,
			ServletException, SQLException {
		// int id = Integer.parseInt(request.getParameter("id"));
		Article a = new Article();
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String date = request.getParameter("lytext");
		a.setR_author(name);
		a.setR_date(phone);
		a.setR_summary(date);
		// int id=Integer.parseInt(request.getParameter("id"));
		// autho.setId(id);
		// articleService.insertarticle(name, phone, date);

		articleService.insertarticle1(a);
		ModelAndView modelAndView = new ModelAndView();

		// 填充数据
		// 视图
		modelAndView.setViewName("redirect:/articlefinall.action");
		return modelAndView;

	}

	@RequestMapping("/articledelete.action")
	public String delete(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "id", required = false) int id) {
		String uname = (String) request.getSession().getAttribute("uname");
		String pwd = (String) request.getSession().getAttribute("pwd");
		String userroleplay = userservice.selectroleplay(uname, pwd);
		if (userroleplay.equals("boss")) {
			articleService.delete1(id);
			return "redirect:/articlefinall.action";
		} else {
			String msg = "你不具有此权限！！！";
			JOptionPane.showMessageDialog(null, msg);
			return "redirect:/articlefinall.action";
		}
	}

}
