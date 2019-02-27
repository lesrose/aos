package cn.aos.mpic;


public class Axis {

	
	public static final String HEIGHT = "height";
	public static final String VOLUME = "volume";
	
	private int lineColor;		//y轴颜色
	private int lineWidth;		//y轴宽度
	private String title;		//y轴标题
	private String type;		//y轴类型  支持value 类型 和datetime类型
	
	private double max;			//最大值
	private double min;			//最小值
	
	private int ticks;			//刻度个数
	
	private int istart;
	private int iend;
	
	
	private String labelFormat; //刻度值排版 
	
	
	public Axis(){
		
	}
	


	public Axis(int lineColor, int lineWidth, String title, String type,
			double max, double min, int ticks, int istart, int iend,
			String labelFormat) {
		super();
		this.lineColor = lineColor;
		this.lineWidth = lineWidth;
		this.title = title;
		this.type = type;
		this.max = max;
		this.min = min;
		this.ticks = ticks;
		this.istart = istart;
		this.iend = iend;
		this.labelFormat = labelFormat;
	}






	public int getLineColor() {
		return lineColor;
	}

	public void setLineColor(int lineColor) {
		this.lineColor = lineColor;
	}

	public int getLineWidth() {
		return lineWidth;
	}

	public void setLineWidth(int lineWidth) {
		this.lineWidth = lineWidth;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}


	public String getLabelFormat() {
		return labelFormat;
	}

	public void setLabelFormat(String labelFormat) {
		this.labelFormat = labelFormat;
	}


	public int getIstart() {
		return istart;
	}



	public void setIstart(int istart) {
		this.istart = istart;
	}



	public int getIend() {
		return iend;
	}



	public void setIend(int iend) {
		this.iend = iend;
	}



	public int getTicks() {
		return ticks;
	}


	public void setTicks(int ticks) {
		this.ticks = ticks;
	}
	
}
