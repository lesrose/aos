package cn.aos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.aos.mapper.AuthoMapper;
import cn.aos.po.Autho;
import cn.aos.service.Searchtank;

@Service(value = "searchtank")
public class Searchtankimpl implements Searchtank {

	@Autowired
	private AuthoMapper authoMapper;

	public List<Autho> selectAll() {
		return authoMapper.selectAll();
	}

	public Autho selectById(Integer id) {
		return authoMapper.selectById(id);
	}

	public int deleteById(Integer id) {
		return authoMapper.deleteById(id);
	}

	public int insertTank(Autho autho) {
		return authoMapper.insertTank(autho);
	}

	public List<Autho> selectByAutAndPro(String authority, String pro) {

		return authoMapper.selectByAutAndPro(authority, pro);
	}

	public int updateById(Autho autho) {
		return authoMapper.updateById(autho);
	}

	public List<Autho> selectBystName(String sname) {
		return authoMapper.selectBystName(sname);
	}

}
