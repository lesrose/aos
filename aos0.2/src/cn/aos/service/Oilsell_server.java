package cn.aos.service;

import java.sql.SQLException;
import java.util.List;

import cn.aos.po.Autho;
import cn.aos.po.Oil;

public interface Oilsell_server {
	 public void add(Oil s ) throws SQLException ;
	 public void delete(Integer id) throws SQLException ;
	 void update(Oil s) throws SQLException ;
	 public List<Oil> findAll() throws SQLException;
	public List<Oil> findById(Integer id);
	public List<Oil> findById1(Integer id);
	public void updateoilsell(int id, int m);
	public void updateoilsell2(int id, int m);
	public void insertprice( int id,int m, float toprice);
	public String selectnumber(int id);

	

}
