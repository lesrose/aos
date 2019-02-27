package cn.aos.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.swing.JOptionPane;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aos.controller.Music;
import cn.aos.mapper.OiltankMapper;
import cn.aos.po.Oiltank;
import cn.aos.po.OiltankPlus;
import cn.aos.service.OilService;

@Service(value = "oilService")
public class OilServiceImpl implements OilService {
	@Autowired
	private OiltankMapper oiltankMapper;

	public List<Oiltank> finddataListbyname(String tname) {

		return oiltankMapper.finddataListbyname(tname);
	}

	public void addtankBySname(String tname) {

		oiltankMapper.addtankBySname(tname);
	}

	public void deleteByName(String taname) {

		oiltankMapper.deleteByName(taname);
	}

	public void changetanknamebByName(String oldname, String newname) {

		oiltankMapper.changetanknamebByName(oldname, newname);
	}

	public Oiltank findById(String tname, Integer id) {
		return oiltankMapper.findById(tname, id);
	}

	public void uptankById(String tname, Oiltank oiltank) {

		oiltankMapper.uptankById(tname, oiltank);
	}

	public void uptankById1(String tname, Double height, Double volume,
			Integer id) {

		oiltankMapper.uptankById1(tname, height, volume, id);
	}

	public void addTankdata(String tname, Double height, Double volume) {

		oiltankMapper.addTankdata(tname, height, volume);
	}

	public void addTankdata1(OiltankPlus oiltankPlus) {

		oiltankMapper.addTankdata1(oiltankPlus);
	}

	public void deleteById(OiltankPlus oiltankPlus) {

		oiltankMapper.deleteById(oiltankPlus);
	}

	public List<Oiltank> selectheight(String biao) {
		return oiltankMapper.selectheight(biao);
	}

	public List<Oiltank> selectHeight(String biao) {
		return oiltankMapper.selectHeight(biao);
	}

	public List<Oiltank> selectmin(String biao) {
		return oiltankMapper.selectmin(biao);
	}

	public double math(double h1, double v1, double h2, double v2) {
		double t = (v2 - v1) / (h2 - h1);
		return t;
	}

	public double math1(double t, double height, double h1, double v1,
			double h2, double v2) {
		double b1 = v1 - h1 * t;
		double b2 = v2 - h2 * t;
		double b = (b2 + b1) / 2;
		return b;
	}

	public double Math2(double t, double height, double b) {
		double v = t * height + b;
		return v;
	}

	public void compare(double volume) {
		if (volume <= 500) {
			try {
				new Music().play();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String msg = "油量不足，请加油！！！";
			JOptionPane.showInputDialog(msg, volume);
		} else if (volume > 500 && volume <= 8000) {
			String msg = "油量正常，请保持！！！";
			JOptionPane.showInputDialog(msg, volume);

		} else {
			try {
				new Music().play();
			} catch (IOException e) {
				e.printStackTrace();
			}
			String msg = "油量过多，请出油！！！";
			JOptionPane.showInputDialog(msg, volume);
		}
	}

	public List<Oiltank> selectmax(String biao) {
		return oiltankMapper.selectmax(biao);
	}

	public List<Oiltank> selectbyheight(double height, String biao) {
		return oiltankMapper.selectbyheight(height, biao);
	}

	public List<Oiltank> selectbyHeight(double height, String biao) {

		return oiltankMapper.selectbyHeight(height, biao);
	}

	public double Math(double t, double height, double h1, double v1) {
		double v = t * (height - h1) + v1;
		return v;
	}

	public double mathtwo(double t, double height, double h2, double v2) {
		double v = t * (height - h2) + v2;
		return v;
	}

	public List<Oiltank> selectall(String biao) {

		return oiltankMapper.selectall(biao);
	}

	public int selectcount(String biao) {

		return oiltankMapper.selectcount(biao);
	}

	public double selecthavg(String biao) {
		return oiltankMapper.selecthavg(biao);
	}

	public double selectvavg(String biao) {
		return oiltankMapper.selectvavg(biao);
	}

	public double countb(Double[] arr, Double[] arr1, int count, double h,
			double v) {
		double sum = 0;
		double num = 0;
		for (int i = 0; i < count; i++) {
			sum = sum + arr[i] * arr1[i];
		}
		double x = sum - count * h * v;
		for (int i = 0; i < count; i++) {
			num = num + arr[i] * arr[i];
		}
		double y = num - count * h * h;
		double b = x / y;
		return b;
	}

	public double counta(double b, double h, double v) {
		double a = v - b * h;
		return a;
	}

	public double countvolume(double b, double a, double height) {
		double volume = b * height + a;
		return volume;
	}

	// 查询所有数据
	public List<Oiltank> findAll(String biao) {
		List<Oiltank> result = oiltankMapper.findAll(biao);
		return result;
	}

	// 导出数据
	public void exportAls(FileInputStream fileInputStream,
			ServletOutputStream outputStream, String biao) {
		// Workbook工作簿
		XSSFWorkbook book = null;
		try {
			book = new XSSFWorkbook(fileInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 工作表 sheet
		XSSFSheet sheet = book.getSheetAt(0);
		List<Oiltank> list = oiltankMapper.findAll(biao);
		System.out.println(list.size());
		int rowIndex = 1; // 让表格从第二行开始导入
		XSSFCell cell = null;
		for (Oiltank oiltank : list) {
			// 新建一行
			XSSFRow row = sheet.createRow(rowIndex);
			cell = row.createCell(0); // 第一个单元格
			Integer id = oiltank.getId();
			if (id != null) {
				cell.setCellValue(id);
			}
			cell = row.createCell(1); // 第二个单元格
			Double height = oiltank.getHeight();
			if (height != null) {
				cell.setCellValue(height);
			}
			cell = row.createCell(2); // 第三个单元格
			Double volume = oiltank.getVolume();
			if (volume != null) {
				cell.setCellValue(volume);
			}
			rowIndex++;
		}
		// 把工作簿放在输出流中
		try {
			book.write(outputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 导入数据
	public Boolean importXls(File myFile, String myFileContentType, String biao) {

		if ("application/vnd.ms-excel".equals(myFileContentType)) {
			try {
				// 获取workbook工作簿
				HSSFWorkbook hssfWorkbook = new HSSFWorkbook(
						new FileInputStream(myFile));
				// 获取sheet 工作表
				HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
				// 获取工作表的最后一行索引
				int lastRowNum = sheet.getLastRowNum();
				for (int i = 1; i < lastRowNum; i++) {
					Oiltank oiltank = new Oiltank();
					HSSFRow row = sheet.getRow(i);
					// 数据id
					//Integer id = (int) row.getCell(0).getNumericCellValue();
					//oiltank.setId(id);
					// 数据height
					Double height = row.getCell(1).getNumericCellValue();
					oiltank.setHeight(height);
					;
					// 数据volume
					Double volume = row.getCell(2).getNumericCellValue();
					oiltank.setVolume(volume);
					// 向新建表插入数据
					oiltankMapper.insertdata(oiltank, biao);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else if ("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"// 不同版本的excel
		.equals(myFileContentType)) {
			try {
				// 获取workbook工作簿
				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(
						new FileInputStream(myFile));
				// 获取sheet 工作表
				XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
				// 获取工作表的最后一行索引
				int lastRowNum = sheet.getLastRowNum();
				for (int i = 1; i <= lastRowNum; i++) {
					Oiltank oiltank = new Oiltank();
					XSSFRow row = sheet.getRow(i);
					// 数据id
					//Integer id = (int) row.getCell(0).getNumericCellValue();
					//oiltank.setId(id);
					// 数据height
					Double height = row.getCell(1).getNumericCellValue();
					oiltank.setHeight(height);

					// 数据volume
					Double volume = row.getCell(2).getNumericCellValue();
					oiltank.setVolume(volume);
					// 向新建表插入数据
					oiltankMapper.insertdata(oiltank, biao);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	public void comparetwo(Boolean flag) {
		if (flag) {
			String msg = "导入成功！！！";
			JOptionPane.showMessageDialog(null, msg);
		} else {
			String msg = "导入失败，请重试！！！";
			JOptionPane.showMessageDialog(null, msg);
		}

	}

	public String selectname(int id) {
		// TODO Auto-generated method stub
		return oiltankMapper.selectname(id);
	}

}
