package cn.aos.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.aos.po.Autho;



public interface Searchtank {
	
	public List<Autho> selectAll( );
	public Autho selectById(Integer id);
	public int updateById(Autho autho);
	public int deleteById(Integer id);
	public int insertTank(Autho autho);
	public List<Autho> selectByAutAndPro(String authority,String pro);
	public List<Autho> selectBystName(String s);
}
