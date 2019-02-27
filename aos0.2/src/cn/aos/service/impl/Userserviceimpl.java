package cn.aos.service.impl;

import java.util.List;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.aos.mapper.UserMapper;
import cn.aos.po.User;
import cn.aos.service.Userservice;

@Service(value = "userservice")
public class Userserviceimpl implements Userservice {
	@Autowired
	private UserMapper userMapper;

	public List<User> selectAll() {
		return userMapper.selectAll();
	}

	public User selectByNameAndPwd(String uname, String pwd) {
		return userMapper.selectByNameAndPwd(uname, pwd);
	}

	public String selectroleplay(String uname, String pwd) {
		// TODO Auto-generated method stub
		return userMapper.selectroleplay(uname, pwd);
	}

	public List<User> selectfindall() {
		return userMapper.selectfindall();
	}

	public void userupdatedb(int id, String phonenumber, String roleplay,
			String athority, String pro) {
		userMapper.userupdatedb(phonenumber, roleplay, athority, pro, id);

	}

	public void userdelete(int id) {
		// TODO Auto-generated method stub
		userMapper.userdelete(id);
	}

	public List<User> userselect(String name) {
		// TODO Auto-generated method stub
		return userMapper.userselect(name);
	}

	public void userinsert(String name, String pwd, int age, String sex,
			String phone, String roleplay, String athority, String pro) {
		// TODO Auto-generated method stub
		userMapper.userinsert(name, pwd, age, sex, phone, roleplay, athority,
				pro);
	}

	public void userpwdupdate(String name, String newpassword) {
		// TODO Auto-generated method stub
		userMapper.userpwdupdate(name, newpassword);
	}

	public void tishi() {
		// TODO Auto-generated method stub
		String msg = "密码已修改请重新登录！！！";
		JOptionPane.showMessageDialog(null, msg);
	}

}
