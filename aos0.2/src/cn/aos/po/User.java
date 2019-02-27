package cn.aos.po;

public class User {
	private Integer id;

	private String uname;

	private String password;
	private Integer age;
	private String sex;
	private String phonenumber;
	private String roleplay;

	private String athority;

	private String pro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname == null ? null : uname.trim();
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber == null ? null : phonenumber.trim();
	}

	public String getRoleplay() {
		return roleplay;
	}

	public void setRoleplay(String roleplay) {
		this.roleplay = roleplay == null ? null : roleplay.trim();
	}

	public String getAthority() {
		return athority;
	}

	public void setAthority(String athority) {
		this.athority = athority == null ? null : athority.trim();
	}

	public String getPro() {
		return pro;
	}

	public void setPro(String pro) {
		this.pro = pro == null ? null : pro.trim();
	}
}