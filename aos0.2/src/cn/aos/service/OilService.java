package cn.aos.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.ibatis.annotations.Param;

import cn.aos.po.Oiltank;
import cn.aos.po.OiltankPlus;

public interface OilService {

	public List<Oiltank> finddataListbyname(String tname);

	public void addtankBySname(String tname);

	public void deleteByName(String taname);

	public void changetanknamebByName(String oldname, String newname);

	public Oiltank findById(String tname, Integer id);

	public void uptankById(String tname, Oiltank oiltank);

	public void uptankById1(String tname, Double height, Double volume,
			Integer id);

	public void addTankdata(String tname, Double height, Double volume);

	public void addTankdata1(OiltankPlus oiltankPlus);

	public void deleteById(OiltankPlus oiltankPlus);

	public List<Oiltank> selectheight(String biao);

	public List<Oiltank> selectHeight(String biao);

	public List<Oiltank> selectmin(String biao);

	public double math(double h1, double v1, double h2, double v2);

	public double math1(double t, double height, double h1, double v1,
			double h2, double v2);

	public double Math2(double t, double height, double b);

	public void compare(double volume);

	public List<Oiltank> selectmax(String biao);

	public List<Oiltank> selectbyheight(double height, String biao);

	public List<Oiltank> selectbyHeight(double height, String biao);

	public double Math(double t, double height, double h1, double v1);

	public double mathtwo(double t, double height, double h2, double v2);

	public List<Oiltank> selectall(String biao);

	public int selectcount(String biao);

	public double selectvavg(String biao);

	public double selecthavg(String biao);

	public double countb(Double[] arr, Double[] arr1, int count, double h,
			double v);

	public double counta(double b, double h, double v);

	public double countvolume(double b, double a, double height);

	public void exportAls(FileInputStream fileInputStream,
			ServletOutputStream outputStream, String biao);

	public Boolean importXls(File f, String myFileContentType, String biao);

	public List<Oiltank> findAll(String biao);

	public void comparetwo(Boolean flag);

	public String selectname(int id);



}
