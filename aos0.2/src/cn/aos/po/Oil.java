package cn.aos.po;

public class Oil {

	private int  id;
	public String getOilname() {
		return oilname;
	}
	public void setOilname(String oilname) {
		this.oilname = oilname;
	}
	private String oilname;
	private float price;
	private int amount;
	private String leavecnt;
	private float toprice;
	public float getToprice() {
		return toprice;
	}
	public void setToprice(float toprice) {
		this.toprice = toprice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getLeavecnt() {
		return leavecnt;
	}
	public void setLeavecnt(String leavecnt) {
		this.leavecnt = leavecnt;
	}



public Oil (int id, String oilname,float price, String leavecnt)
{
	this.id=id;
	
	this.price=price;
	this.leavecnt=leavecnt;
	this.oilname=oilname;

	
	
	

}
public Oil (int id, String oilname,float price,int amount, String leavecnt)
{
	this.id=id;
	
	this.price=price;
	this.leavecnt=leavecnt;
	this.oilname=oilname;
	
	this.amount=amount;
	
	
	
	

}
public Oil()
{}
}

