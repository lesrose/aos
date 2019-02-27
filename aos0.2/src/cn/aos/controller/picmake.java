package cn.aos.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cn.aos.mpic.Tpic;
import cn.aos.po.Oiltank;


@Controller
public class picmake {
	
		
	@RequestMapping("/picmake.action")
	public String picMake(HttpSession session) throws Exception {

		Tpic tic=new Tpic();
		List<Oiltank> dList=(List<Oiltank>) session.getAttribute("dataList");
		int[] a=new int[dList.size()];
		int[] b=new int[dList.size()];
		for (int i = 0; i < dList.size(); i++) {
			a[i]=dList.get(i).getHeight().intValue();
			b[i]=dList.get(i).getVolume().intValue();
		}		
		tic.drawpic(a, b);
//		for (int i = 0; i < b.length; i++) {
//			System.out.print(a[i]+"  ");
//		}
//		System.out.println("  ");
//		for (int i = 0; i < b.length; i++) {
//			System.out.print(b[i]+"  ");
//		}
		
		return "oil/showdatepic";
	} 
	

}
