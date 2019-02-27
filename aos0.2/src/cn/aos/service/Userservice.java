package cn.aos.service;

import java.util.List;
import cn.aos.po.User;

public interface Userservice {

	public List<User> selectAll();

	public User selectByNameAndPwd(String uname, String pwd);

	public String selectroleplay(String uname, String pwd);

	public List<User> selectfindall();

	public void userupdatedb(int id, String phonenumber, String roleplay,
			String athority, String pro);

	public void userdelete(int id);

	public List<User> userselect(String name);

	public void userinsert(String name, String pwd, int age, String sex,
			String phone, String roleplay, String athority, String pro);

	public void userpwdupdate(String name, String newpassword);

	public void tishi();
}
