package cn.aos.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.aos.po.Oil;

public interface Oilsell_Mapper {

	@Select("select * from oilsell")
	public List<Oil> findAll();

	// update oilsell set leavecnt=leavecnt-amount where where amount=#{amount};
	@Update("update oilsell set leavecnt=leavecnt-#{m} where id=#{id}")
	// public void update(Oil s);
	public void updateoilsell(@Param(value = "id") Integer id,
			@Param(value = "m") int m);

	@Delete("delete from oilsell where id=#{id}")
	public void delete(@Param(value = "id") Integer id);

	@Insert("insert into oilsell(Id,oilname,price,leavecnt)values(#{Id},#{oilname},#{price},#{leavecnt})")
	public void add(Oil s);

	@Select("select * from oilsell where id=#{id}")
	public List<Oil> findById(@Param(value = "id") Integer id);

	@Update("update oilsell set leavecnt=leavecnt+#{m} where id=#{id}")
	public void updateoilsell2(@Param(value = "id") Integer id,
			@Param(value = "m") int m);

	@Update("update oilsell set amount=#{m},toprice=#{toprice} where id=#{id}")
	// @Insert("insert into oilsell (id,amount,price,toprice)values(#{id},#{m},#{toprice})")
	public void insertprice(@Param(value = "id") int id,
			@Param(value = "m") int m, @Param(value = "toprice") float toprice);

	@Select("select * from price where id=#{id}")
	public List<Oil> findById1(@Param(value = "id") Integer id);

	@Select("select leavecnt from oilsell where id=#{id}")
	public String selectnumber(@Param(value = "id") int id);

}
