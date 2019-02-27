package cn.aos.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import cn.aos.po.Autho;
import cn.aos.po.Oiltank;
import cn.aos.po.User;
import cn.aos.service.OilService;
import cn.aos.service.Searchtank;
import cn.aos.service.Userservice;

@Controller
public class oiltanklist {

	@Autowired
	@Qualifier("oilService")
	private OilService oilService;
	@Autowired
	@Qualifier("searchtank")
	private Searchtank searchtank;
	@Autowired
	@Qualifier("userservice")
	private Userservice userservice;

	@RequestMapping("/querytank.action")
	public ModelAndView queryTank(HttpSession session) throws Exception {
		// Oiltank oiltank=new Oiltank();
		// 油罐列表
		// List<Autho> autholist = searchtank.selectAll();
		String uname = (String) session.getAttribute("uname");
		String pwd = (String) session.getAttribute("pwd");
		User user1 = userservice.selectByNameAndPwd(uname, pwd);
		String authority = user1.getAthority();
		String pro = user1.getPro();
		List<Autho> autholist = searchtank.selectByAutAndPro(authority, pro);

		// 创建modelAndView准备填充数据、设置视图
		ModelAndView modelAndView = new ModelAndView();

		// 填充数据
		modelAndView.addObject("autholist", autholist);
		// 视图
		modelAndView.setViewName("oil/oillist");
		return modelAndView;
	}

	@RequestMapping("/updatetank.action")
	public ModelAndView updateTank(HttpSession session, Model model,
			HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "id", required = false) Integer id)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		String uname = (String) request.getSession().getAttribute("uname");
		String pwd = (String) request.getSession().getAttribute("pwd");
		String userroleplay = userservice.selectroleplay(uname, pwd);
		System.out.println(userroleplay);
		if (userroleplay.equals("woker")) {
			Autho autho = searchtank.selectById(id);
			// 创建modelAndView准备填充数据、设置视图
			String oldname = autho.getSname();
			modelAndView.addObject("autho", autho);
			session.setAttribute("oldname", oldname);
			session.setAttribute("id", id);
			modelAndView.setViewName("oil/oilupdate");

			return modelAndView;
		} else {
			String msg = "你不具有此权限！！！";
			JOptionPane.showMessageDialog(null, msg);
			modelAndView.setViewName("redirect:/querytank.action");
			return modelAndView;
		}
	}

	@RequestMapping("/updatetankSubmit.action")
	public String updatetankSubmit(HttpSession session,
			HttpServletResponse response, HttpServletRequest request)
			throws Exception {

		Autho autho = new Autho();
		String authority = request.getParameter("authority");
		String pro = request.getParameter("pro");
		String sname = request.getParameter("sname");
		String oldname = (String) session.getAttribute("oldname");
		int id = (Integer) session.getAttribute("id");
		autho.setSname(sname);
		autho.setAuthority(authority);
		autho.setPro(pro);
		autho.setId(id);
		String uname = (String) request.getSession().getAttribute("uname");
		String pwd = (String) request.getSession().getAttribute("pwd");
		String userroleplay = userservice.selectroleplay(uname, pwd);
		System.out.println(userroleplay);
		if (userroleplay.equals("woker")) {
			// int id=Integer.parseInt(request.getParameter("id"));
			// autho.setId(id);
			oilService.changetanknamebByName(oldname, sname);
			searchtank.updateById(autho);
			// 重定向到查询列表
			// return "redirect:queryItems.action";
			// 页面转发
			// return "forward:queryItems.action";
			return "redirect:querytank.action";
		} else {
			String msg = "你不具有此权限！！！";
			JOptionPane.showMessageDialog(null, msg);
			return "redirect:querytank.action";
		}
	}

	@RequestMapping("/showdata.action")
	// @RequestParam里边指定request传入参数名称和形参进行绑定。
	// 通过required属性指定参数是否必须要传入
	// 通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public ModelAndView showData(HttpSession session, Model model,
			HttpServletResponse response, HttpServletRequest request,
			@RequestParam(value = "id", required = false) Integer id,
			@RequestParam(value = "page", required = false) Integer page)
			throws Exception {
		Autho autho = searchtank.selectById(id);
		int id1 = autho.getId();
		request.getSession().setAttribute("id1", id1);
		String oname = autho.getSname();
		session.setAttribute("oname", oname);
		request.getSession().setAttribute("oname", oname);
		// int id1=id;
		// 创建modelAndView准备填充数据、设置视图
		ModelAndView modelAndView = new ModelAndView();
		// 油罐数据列表
		List<Oiltank> dataList = oilService.finddataListbyname(oname);
		session.setAttribute("dataList", dataList);
		int d = dataList.size();
		if (d >= 10) {
			String e = "";
			int page1;
			int perpage = 10;
			int pagecount = (d + perpage - 1) / perpage;
			String p = request.getParameter("page");
			// int p1=Integer.valueOf(p);
			// if(page==0)page1=1;
			try {
				if (Integer.valueOf(p) < 1)
					page1 = 1;
				else if (Integer.valueOf(p) > pagecount)
					page1 = pagecount;
				else
					page1 = Integer.valueOf(p);
			} catch (NumberFormatException s) {
				page1 = 1;
			}
			int beginindex = (page1 - 1) * perpage;
			int endindex = beginindex + perpage;
			// if(endindex>d)

			// endindex=d;
			request.setAttribute("d", d);
			request.setAttribute("perpage", perpage);
			request.setAttribute("pagecount", pagecount);
			request.setAttribute("beginindex", beginindex);
			request.setAttribute("endindex", endindex);
			request.setAttribute("page1", page1);
			request.setAttribute("id", id);
			// request.setAttribute("dataList", dataList);
			// dataList.subList(beginindex, beginindex);
			// dataList=dataList.subList((page1-1)*perpage,(page1-1)*perpage+perpage);
			if (page1 == pagecount)
				dataList = dataList.subList((page1 - 1) * perpage, d);
			else
				dataList = dataList.subList((page1 - 1) * perpage, (page1 - 1)
						* perpage + perpage);
			modelAndView.addObject("dataList", dataList);
			modelAndView.addObject("e", e);

			// 视图
			modelAndView.setViewName("oil/showdate");
			return modelAndView;
		} else {

			int page1 = 1;
			int pagecount = 1;

			if (dataList.size() == 0) {
				Oiltank o = new Oiltank();
				o.setId(1);
				o.setHeight(0.0);
				o.setVolume(0.0);
				dataList.add(o);
				String e = "没有数据，请添加数据,上行数据无效";

				modelAndView.addObject("page1", page1);
				modelAndView.addObject("pagecount", pagecount);
				modelAndView.addObject("dataList", dataList);
				modelAndView.addObject("e", e);
				modelAndView.setViewName("oil/showdate");
				return modelAndView;
			} else {
				modelAndView.addObject("page1", page1);
				modelAndView.addObject("pagecount", pagecount);
				modelAndView.addObject("dataList", dataList);
				modelAndView.setViewName("oil/showdate");
				return modelAndView;
			}

		}
	}

	@RequestMapping("/addtank.action")
	// @RequestParam里边指定request传入参数名称和形参进行绑定。
	// 通过required属性指定参数是否必须要传入
	// 通过defaultValue可以设置默认值，如果id参数没有传入，将默认值和形参绑定。
	public ModelAndView addtank(HttpServletResponse response,
			HttpServletRequest request, Model model) throws Exception {

		String authority = request.getParameter("authority");
		String pro = request.getParameter("pro");
		// 创建modelAndView准备填充数据、设置视图
		ModelAndView modelAndView = new ModelAndView();
		Autho autho = new Autho();
		// 填充数据
		modelAndView.addObject("autho", autho);
		modelAndView.addObject("authority", authority);
		modelAndView.addObject("pro", pro);
		// 视图
		modelAndView.setViewName("oil/addtank");

		return modelAndView;
	}

	@RequestMapping("/addTankSubmit")
	public String addTankSubmit(HttpSession session,
			HttpServletResponse response, HttpServletRequest request,
			Autho autho) throws Exception {

		//
		// String authority=request.getParameter("authority");
		// String pro=request.getParameter("pro");
		String sname = request.getParameter("sname");
		autho.setSname(request.getParameter("sname"));
		request.getSession().setAttribute("sname", sname);
		autho.setAuthority((String) session.getAttribute("authority"));
		autho.setPro((String) session.getAttribute("pro"));
		String uname = (String) request.getSession().getAttribute("uname");
		String pwd = (String) request.getSession().getAttribute("pwd");
		String userroleplay = userservice.selectroleplay(uname, pwd);
		if (userroleplay.equals("woker")) {
			// int id=Integer.parseInt(request.getParameter("id"));
			// autho.setId(id);
			searchtank.insertTank(autho);
			oilService.addtankBySname(sname);
			// 重定向到查询列表
			// return "redirect:queryItems.action";
			// 页面转发
			// return "forward:queryItems.action";
			return "redirect:querytank.action";
		} else {
			String msg = "你不具有此权限！！！";
			JOptionPane.showMessageDialog(null, msg);
			return "redirect:querytank.action";
		}
	}

	@RequestMapping("/deletetank.action")
	public String deleteTank(HttpSession session, HttpServletResponse response,
			HttpServletRequest request,
			@RequestParam(value = "id", required = true) Integer id)
			throws Exception {
		String uname = (String) request.getSession().getAttribute("uname");
		String pwd = (String) request.getSession().getAttribute("pwd");
		String userroleplay = userservice.selectroleplay(uname, pwd);
		if (userroleplay.equals("woker")) {
			Autho autho = searchtank.selectById(id);
			oilService.deleteByName(autho.getSname());
			searchtank.deleteById(id);

			// 重定向到查询列表
			// return "redirect:queryItems.action";
			// 页面转发
			// return "forward:queryItems.action";
			return "forward:querytank.action";
		} else {
			String msg = "你不具有此权限！！！";
			JOptionPane.showMessageDialog(null, msg);
			return "forward:querytank.action";
		}
	}

	@RequestMapping("/select.action")
	public String select(HttpServletResponse response,
			HttpServletRequest request, Oiltank oiltank) throws Exception {
		String type = request.getParameter("type");
		String height = request.getParameter("height");
		request.getSession().setAttribute("height", height);
		if (type.equals("算法一")) {

			return "redirect:calibrationone.action";
		} else if (type.equals("算法二")) {

			return "redirect:calibrationtwo.action";
		} else {

			return "redirect:calibrationthree.action";
		}
	}

	@RequestMapping("/calibrationone.action")
	public String calibrationone(HttpServletResponse response,
			HttpServletRequest request, Oiltank oiltank) throws Exception {

		// 调用service更新商品信息，页面需要将商品信息传到此方法
		String height = (String) request.getSession().getAttribute("height");
		String biao = (String) request.getSession().getAttribute("oname");
		double Height = Double.parseDouble(height);
		oiltank.setHeight(Height);
		List<Oiltank> sum = oilService.selectheight(biao);// 查询数据表中height的min
		double min = sum.get(0).getHeight();
		List<Oiltank> num = oilService.selectHeight(biao);// 查询数据表中height的min
		double max = num.get(0).getHeight();
		if (Height <= min) {// 将输入的height和min，max进行比较
			List<Oiltank> mimlist = oilService.selectmin(biao);// 查询数据表的（top
																// 2）数据
			double h1 = mimlist.get(0).getHeight();// 得到查询值
			double v1 = mimlist.get(0).getVolume();
			double h2 = mimlist.get(1).getHeight();
			double v2 = mimlist.get(1).getVolume();
			double t = oilService.math(h1, v1, h2, v2);// 计算斜率
			double b = oilService.math1(t, Height, h1, v1, h2, v2);// 计算常量
			double v = oilService.Math2(t, Height, b);// 计算体积
			v = (double) Math.round(v * 100) / 100;// 保留小数点后两位
			request.setAttribute("v", v);
			double volume = Double.valueOf(v);
			oilService.compare(volume);// 输出体积和提示信息
			int id = (Integer) request.getSession().getAttribute("id1");
			return "redirect:showdata.action?id=" + id;
		} else if (Height >= max) {
			List<Oiltank> maxlist = oilService.selectmax(biao);// 查询数据表的最后两列数据
			double h1 = maxlist.get(1).getHeight();// 得到查询值
			double v1 = maxlist.get(1).getVolume();
			double h2 = maxlist.get(0).getHeight();
			double v2 = maxlist.get(0).getVolume();
			double t = oilService.math(h1, v1, h2, v2);// 计算斜率
			double b = oilService.math1(t, Height, h1, v1, h2, v2);// 计算常量
			double v = oilService.Math2(t, Height, b);// 计算体积
			v = (double) Math.round(v * 100) / 100;// 保留小数点后两位
			request.setAttribute("v", v);
			double volume = Double.valueOf(v);
			oilService.compare(volume);// 输出体积和提示信息
			int id = (Integer) request.getSession().getAttribute("id1");
			return "redirect:showdata.action?id=" + id;
		} else {
			List<Oiltank> s1 = oilService.selectbyheight(Height, biao);// 查询小于Height的最大的height和volume
			double h1 = s1.get(0).getHeight();
			double v1 = s1.get(0).getVolume();
			List<Oiltank> s2 = oilService.selectbyHeight(Height, biao);// 查询大于Height的最小的height和volume
			double h2 = s2.get(0).getHeight();
			double v2 = s2.get(0).getVolume();
			double t = oilService.math(h1, v1, h2, v2);// 计算斜率
			double b = oilService.math1(t, Height, h1, v1, h2, v2);// 计算常量
			double v = oilService.Math2(t, Height, b);// 计算体积
			v = (double) Math.round(v * 100) / 100;// 保留小数点后两位
			request.setAttribute("v", v);
			double volume = Double.valueOf(v);
			oilService.compare(volume);// 输出体积和提示信息
			// 重定向到查询列表
			// return "redirect:querytank.action";
			// 页面转发
			// return "forward:queryItems.action";
			int id = (Integer) request.getSession().getAttribute("id1");
			return "redirect:showdata.action?id=" + id;
		}
	}

	@RequestMapping("/calibrationtwo.action")
	public String calibrationtwo(HttpServletResponse response,
			HttpServletRequest request, Oiltank oiltank) throws Exception {

		// 调用service更新商品信息，页面需要将商品信息传到此方法
		String height = (String) request.getSession().getAttribute("height");
		String biao = (String) request.getSession().getAttribute("oname");
		double Height = Double.parseDouble(height);
		oiltank.setHeight(Height);
		List<Oiltank> sum = oilService.selectheight(biao);// 查询数据表中height的min
		double min = sum.get(0).getHeight();
		List<Oiltank> num = oilService.selectHeight(biao);// 查询数据表中height的max
		double max = num.get(0).getHeight();
		System.out.print(max);
		if (Height <= min) {// 将输入的height和min，max进行比较
			List<Oiltank> mimlist = oilService.selectmin(biao);// 查询数据表的（top
																// 2）数据
			double h1 = mimlist.get(0).getHeight();// 得到查询值
			double v1 = mimlist.get(0).getVolume();
			double h2 = mimlist.get(1).getHeight();
			double v2 = mimlist.get(1).getVolume();
			double t = oilService.math(h1, v1, h2, v2);// 计算两点间斜率
			double v = oilService.Math(t, Height, h1, v1);// 计算体积
			v = (double) Math.round(v * 100) / 100;// 保留小数点后两位
			request.setAttribute("v", v);
			double volume = Double.valueOf(v);
			oilService.compare(volume);// 输出体积和提示信息
			// 重定向到查询列表
			// return "redirect:querytank.action";
			// 页面转发
			// return "forward:queryItems.action";
			int id = (Integer) request.getSession().getAttribute("id1");
			return "redirect:showdata.action?id=" + id;
		} else if (Height >= max) {
			List<Oiltank> maxlist = oilService.selectmax(biao);// 查询数据表的最后两列数据
			double h1 = maxlist.get(1).getHeight();// 得到查询值
			double v1 = maxlist.get(1).getVolume();
			double h2 = maxlist.get(0).getHeight();
			double v2 = maxlist.get(0).getVolume();
			double t = oilService.math(h1, v1, h2, v2);// 计算两点间斜率
			double v = oilService.mathtwo(t, Height, h2, v2);// 计算体积
			v = (double) Math.round(v * 100) / 100;// 保留小数点后两位
			request.setAttribute("v", v);
			double volume = Double.valueOf(v);
			oilService.compare(volume);// 输出体积和提示信息
			// 重定向到查询列表
			// return "redirect:querytank.action";
			// 页面转发
			// return "forward:queryItems.action";
			int id = (Integer) request.getSession().getAttribute("id1");
			return "redirect:showdata.action?id=" + id;
		} else {
			List<Oiltank> s1 = oilService.selectbyheight(Height, biao);// 查询小于Height的最大的height和volume
			double h1 = s1.get(0).getHeight();
			double v1 = s1.get(0).getVolume();
			List<Oiltank> s2 = oilService.selectbyHeight(Height, biao);// 查询大于Height的最小的height和volume
			double h2 = s2.get(0).getHeight();
			double v2 = s2.get(0).getVolume();
			double t = oilService.math(h1, v1, h2, v2);// 计算两点间斜率
			double v = oilService.Math(t, Height, h1, v1);// 计算体积
			v = (double) Math.round(v * 100) / 100;// 保留小数点后两位
			request.setAttribute("v", v);
			double volume = Double.valueOf(v);
			oilService.compare(volume);// 输出体积和提示信息
			// 重定向到查询列表
			// return "redirect:querytank.action";
			// 页面转发
			// return "forward:queryItems.action";
			int id = (Integer) request.getSession().getAttribute("id1");
			return "redirect:showdata.action?id=" + id;
		}
	}

	@RequestMapping("/calibrationthree.action")
	public String calibrationthree(HttpServletResponse response,
			HttpServletRequest request, Oiltank oiltank) throws Exception {

		String height = (String) request.getSession().getAttribute("height");
		String biao = (String) request.getSession().getAttribute("oname");
		double Height = Double.parseDouble(height);
		oiltank.setHeight(Height);
		List<Oiltank> s = oilService.selectall(biao);
		Double[] arr = new Double[s.size()];
		Double[] arr1 = new Double[s.size()];
		for (int i = 0; i < s.size(); i++) {
			arr[i] = s.get(i).getHeight();
			arr1[i] = s.get(i).getVolume();
		}
		int count = oilService.selectcount(biao);
		double h = oilService.selecthavg(biao);// 查询数据表height的平均值
		double v = oilService.selectvavg(biao);// 查询数据表volume的平均值
		double b = oilService.countb(arr, arr1, count, h, v);// 求出系数b
		double a = oilService.counta(b, h, v);// 求出常量a
		System.out.println(h);
		System.out.println(v);
		System.out.println(b);
		System.out.println(a);
		double vo = oilService.countvolume(b, a, Height);// 利用回归直线求出散点分布数据的近似方程求体积
		vo = (double) Math.round(vo * 100) / 100;// 保留小数点后两位
		request.setAttribute("vo", vo);
		double volume = Double.valueOf(vo);
		oilService.compare(volume);// 输出体积和提示信息
		// 重定向到查询列表
		// return "redirect:querytank.action";
		// 页面转发
		// return "forward:queryItems.action";
		int id = (Integer) request.getSession().getAttribute("id1");
		return "redirect:showdata.action?id=" + id;
	}

	// 文件导出
	// 将数据库数据导出成excel文件
	@RequestMapping("/export.action")
	public void exportXls(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "id", required = false) Integer id)
			throws Exception {
		Autho autho = searchtank.selectById(id);
		String oname = autho.getSname();
		request.getSession().setAttribute("oname", oname);
		response.setContentType("application/vnd.ms-excel"); // 常见的文件 可以省略

		// 文件的打开方式 inline在线打开
		String agent = request.getHeader("User-Agent");
		String filename = FileUtils.encodeDownloadFilename("data.xlsx", agent);
		response.setHeader("content-disposition", "attachment;fileName="
				+ filename);
		ServletOutputStream outputStream = response.getOutputStream();

		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		// 文件分离，得到文件路径
		String templatePath = request.getServletContext().getRealPath(
				File.separator)
				+ File.separator + "data.xlsx";
		System.out.println(templatePath);
		FileInputStream fileInputStream = new FileInputStream(templatePath);
		String biao = (String) request.getSession().getAttribute("oname");
		// 调用导出函数
		oilService.exportAls(fileInputStream, outputStream, biao);
	}

	// 文件导入
	// 将页面传来的excel文件导入进数据库
	@RequestMapping("/import.action")
	public String importXlsx(HttpServletResponse response,
			HttpServletRequest request, Oiltank oiltank) throws Exception {
		int id = (Integer) request.getSession().getAttribute("id1");
		String uname = (String) request.getSession().getAttribute("uname");
		String pwd = (String) request.getSession().getAttribute("pwd");
		String userroleplay = userservice.selectroleplay(uname, pwd);
		String biao=oilService.selectname(id);
		if (userroleplay.equals("woker")) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile myFile = multipartRequest.getFile("myFile"); // 通过参数名获取指定文件

			String myFileFileName = myFile.getOriginalFilename();// 文件的名字
			String myFileContentType = myFile.getContentType(); // 文件的类型

			CommonsMultipartFile cf = (CommonsMultipartFile) myFile;
			DiskFileItem fi = (DiskFileItem) cf.getFileItem();// 转换文件格式

			File f = fi.getStoreLocation();
			Boolean flag = oilService.importXls(f, myFileContentType, biao);// 文件导入
			oilService.comparetwo(flag);
			return "redirect:showdata.action?id=" + id;
		} else {
			String msg = "你不具有此权限！！！";
			JOptionPane.showMessageDialog(null, msg);
			return "redirect:showdata.action?id=" + id;
		}

	}

	/**
	 * 复制单个文件
	 * 
	 * @param oldPathFile
	 *            准备复制的文件源
	 * @param newPathFile
	 *            拷贝到新绝对路径带文件名(注：目录路径需带文件名)
	 * @return
	 */
	// public void CopySingleFile(String oldPathFile, String newPathFile) {
	// try {
	// int bytesum = 0;
	// int byteread = 0;
	// File oldfile = new File(oldPathFile);
	// if (oldfile.exists()) { // 文件存在时
	// InputStream inStream = new FileInputStream(oldPathFile); // 读入原文件
	// FileOutputStream fs = new FileOutputStream(newPathFile);
	// byte[] buffer = new byte[1444];
	// while ((byteread = inStream.read(buffer)) != -1) {
	// bytesum += byteread; // 字节数 文件大小
	// fs.write(buffer, 0, byteread);
	// }
	// inStream.close();
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * @param args
	 * @throws Exception
	 */
	// @RequestMapping("/backup.action")
	// public void backup(String[] args) throws Exception {
	// oiltanklist databean = new oiltanklist();
	// databean.CopySingleFile(
	// "C:\\Program Files\\Microsoft SQL Server\\MSSQL12.MSSQLSERVER\\MSSQL\\DATA\\aosdb.mdf",
	// "F:\\data\\aosdb.mdf");
	// }

}
