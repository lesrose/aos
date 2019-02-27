package cn.aos.po;

public class Oilsell {
	private long id;//id序列号
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getOilNO() {
		return oilNO;
	}
	public void setOilNO(long oilNO) {
		this.oilNO = oilNO;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	private long oilNO;//石油表序列号
	private int amount;//购买数量
	public Oilsell(){
		this.id=0;
		this.oilNO=0;
		this.amount=0;
	}
}
