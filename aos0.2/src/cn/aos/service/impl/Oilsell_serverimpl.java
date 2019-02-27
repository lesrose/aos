package cn.aos.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aos.mapper.Oilsell_Mapper;
import cn.aos.po.Oil;
import cn.aos.service.Oilsell_server;

@Service(value = "oilsell_server")
public class Oilsell_serverimpl implements Oilsell_server {

	@Autowired
	private Oilsell_Mapper oilsell_Mapper;

	public void delete(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		oilsell_Mapper.delete(id);
	}

	public List<Oil> findAll() throws SQLException {
		// TODO Auto-generated method stub
		return oilsell_Mapper.findAll();
	}

	public void add(Oil s) {
		// TODO Auto-generated method stub
		oilsell_Mapper.add(s);
	}

	public List<Oil> findById(Integer id) {
		// TODO Auto-generated method stub
		return oilsell_Mapper.findById(id);
	}

	public void update(Oil s) throws SQLException {
		// TODO Auto-generated method stub

	}

	public void updateoilsell(int id, int m) {
		// TODO Auto-generated method stub
		oilsell_Mapper.updateoilsell(id, m);
	}

	public void updateoilsell2(int id, int m) {
		// TODO Auto-generated method stub
		oilsell_Mapper.updateoilsell2(id, m);
	}

	public void insertprice(int id,int m, float toprice) {
		// TODO Auto-generated method stub
		oilsell_Mapper.insertprice(id,m,toprice);
	}

	public List<Oil> findById1(Integer id) {
		// TODO Auto-generated method stub
		return oilsell_Mapper.findById1(id);
	}

	public String selectnumber(int id) {
		// TODO Auto-generated method stub
		return oilsell_Mapper.selectnumber(id);
	}
}
