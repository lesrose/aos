package cn.aos.mpic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;


@Service(value="tpic")
public class Tpic {
	
	public void drawpic(int[] a,int[] b){
		
		int width = 2500;
		int height=800;
		//int[] a={180,285,376,459,534,608};
		//int[] b={1034,2035,3035,4037,5038,6039};
		AxisBorder border = new AxisBorder(60, 60, 40, 40, 0xffffff);
		BufferedImage bufferedImage = new BufferedImage(width+60 + 60,
				height + 40 +40, BufferedImage.TYPE_INT_RGB);		
		Graphics2D g = bufferedImage.createGraphics();
		Axis xAxis = new Axis(0x000000, 2, "油高(mm)", "height", a[a.length-1], 0, a.length, a[0], a[a.length-1], "");
		Axis yAxis = new Axis(0x000000, 2, "体积(L)", "volume", b[b.length-1], 0, b.length, b[0], b[b.length-1], "");		
		//黑色
		//int c=0x000000;
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//白色
		g.setColor(new Color(0xFFFFFF));		
		g.fillRect(0, 0, border.getLeft(), border.getTop()+height+border.getBottom()); //填充背景色
		g.fillRect(border.getLeft(), 0, width+border.getRight(), border.getTop());
		g.fillRect(border.getLeft(), border.getTop()+height, width+border.getRight(), border.getBottom());
		g.fillRect(border.getLeft()+width, border.getTop(), border.getRight(), height);
//		g.setColor(new Color(0xFFFFFF));
//		g.fillRect(60, 40, width, height);
		g.setColor(new Color(0xFFFFFF));
		g.fillRect(border.getLeft(), border.getTop(), width, height);
		//g.setColor(new Color(0x000000));
		//g.setStroke(new BasicStroke(3));
		//g.drawLine(60, 540, 1060, 540);
		//g.drawLine(60, 540, 60, 40);
		drawx(a,border, xAxis, width, height, g);
		drawy(b,border, yAxis, width, height, g);
		drawxy(a,b,g);
		//g.drawLine(60, 540, 356, 455);
		//导出图片
		String pathname = "E:\\JAVA\\apache-tomcat-7.0.81\\webapps\\aos0.2\\img\\test.jpg";
		try {
			ImageIO.write(bufferedImage, "jpg", new File(pathname));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
public static void drawx(int[] a,AxisBorder axisBorder, Axis xaxis, int width, int height, Graphics2D g){
		
		//画x坐标
		Point point1 = new Point(axisBorder.getLeft(), axisBorder.getTop() + height);
		Point point2 = new Point(axisBorder.getLeft() + width, axisBorder.getTop() + height);
		drawLine(point1, point2, g);
		
		//int[] a={180,285,376,459,534,608};
		//int[] b={1034,2035,3035,4037,5038,6039};

		//画刻度
		int ticks = xaxis.getTicks();
		int skips = width / ticks;
		int x = axisBorder.getLeft();
		int y1 = axisBorder.getTop() + height ;
		int y2 = y1 + 10;
		String type = xaxis.getType();	//获取坐标轴类型
		for(int i = 1 ; i <= ticks ; i++){
			point1 = new Point(x + skips * i,y1);
			point2 = new Point(x + skips * i,y2);
			drawLine(point1, point2,g);					
				}
		
		//画label
		if(type.equals(Axis.HEIGHT)){
					//double vskips = (xaxis.getMax() - xaxis.getMin() ) / ticks + xaxis.getMin();
			for(int i = 1 ; i <= ticks ; i++){
				String p=Integer.toString(skips * i);
				drawString(g, x + skips * i, y2, p);
					}
				}
		
		//画title
		Font font = new Font("宋体", Font.BOLD, 16);
		g.setFont(font);
		drawString(g, axisBorder.getLeft(), 
				axisBorder.getTop() + height + axisBorder.getBottom() /2, xaxis.getTitle());
		
	}
	public static void drawy(int[] b,AxisBorder axisBorder, Axis yAxis, int width, int height, Graphics2D g){
		
		
		//int[] a={180,285,376,459,534,608};
		//int[] b={1034,2035,3035,4037,5038,6039};
		//画Y轴
		Point point1 = new Point(axisBorder.getLeft(), axisBorder.getTop() + height);
		Point point2 = new Point(axisBorder.getLeft(), axisBorder.getTop());
		drawLine(point1, point2,g);
		
		//画刻度
		int ticks = yAxis.getTicks();
		int skips = height / ticks;
		int x1 = axisBorder.getLeft();
		int x2 = x1 - 10 ;
		int y1 = axisBorder.getTop() + height ;
		String type = yAxis.getType();	//获取坐标轴类型
		for(int i = 1 ; i <= ticks ; i++){
			point1 = new Point(x2,y1 - skips * i);
			point2 = new Point(x1,y1 - skips * i);
			drawLine(point1, point2,g);
			}
		//画label
		if(type.equals(Axis.VOLUME)){
		   //double vskips = (yAxis.getMax() - yAxis.getMin() ) / ticks + yAxis.getMin();
			for(int i = 1 ; i <= ticks ; i++){
				String p=Integer.toString(skips * i*(b[b.length-1]/800));
				drawString(g, x2 - 20 , y1 - skips * i,p);
					}
				}
	
		//画title
		//画y坐标title
		int x = Math.min(30, axisBorder.getLeft());
		int y0 = axisBorder.getTop() + height/2 + 80;
				
		//逆时针旋转180度
		g.rotate(-Math.PI/2, x, y0);
		Font font = new Font("宋体", Font.BOLD, 16);
		g.setFont(font);
		g.drawString(yAxis.getTitle(),x,y0);
		//恢复画布，顺时针旋转180度
		g.rotate(Math.PI/2,x,y0);

	}
	//根据数据画线段
	public static void drawxy(int[] a,int[] b,Graphics2D g){
		
		//int[] a={180,285,376,459,534,608};
		//int[] b={1034,2035,3035,4037,5038,6039};
		g.drawLine(60, 840, a[0]+60, 840-b[0]*800/b[b.length-1]);
		for (int i = 0; i < a.length-1; i++) {
			
		g.drawLine(a[i]+60, 840-b[i]*800/b[b.length-1], a[i+1]+60,840-b[i+1]*800/b[b.length-1]);
		}
	}
	/**
	 * 画线
	 * @param point1
	 * @param point2
	 * @param lineColor
	 * @param lineWidth
	 * @param g
	 */
	private static void drawLine(Point point1 , Point point2,Graphics2D g){
		g.setStroke(new BasicStroke(2));
		g.setColor(new Color(0x000000));
		g.drawLine(point1.getX(), point1.getY(), point2.getX(), point2.getY());
	}
	
	/**
	 * 写字符
	 */
	private static void drawString(Graphics2D g,int x ,int y,String str){
		g.drawString(str, x, y);
	}

}
