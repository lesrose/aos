package cn.aos.mpic;

public class AxisBorder {
	
	private int left;
	private int right;
	private int top;
	private int bottom;
	
	private int backgroundColor;	//背景色
	
	public AxisBorder(){
		
	}
	
	public AxisBorder(int left, int right, int top, int bottom,
			int backgroundColor) {
		super();
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
		this.backgroundColor = backgroundColor;
	}



	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getRight() {
		return right;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public int getBottom() {
		return bottom;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
	}

	public int getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(int backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

}
