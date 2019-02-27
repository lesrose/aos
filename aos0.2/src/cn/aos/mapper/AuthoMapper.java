package cn.aos.mapper;

import cn.aos.po.Autho;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface AuthoMapper {

	@Select("select * from autho")
	public List<Autho> selectAll();

	@Select("select * from autho where id=#{id}")
	public Autho selectById(@Param(value = "id") Integer id);

	@Select("select * from autho where authority=#{authority} and pro=#{pro}")
	public List<Autho> selectByAutAndPro(
			@Param(value = "authority") String authority,
			@Param(value = "pro") String pro);

	@Update("update autho set sname=#{sname},authority=#{authority},pro=#{pro} where id=#{id}")
	public int updateById(Autho autho);

	@Delete("delete from autho where id=#{id}")
	public int deleteById(@Param(value = "id") Integer id);

	@Insert("insert into autho (sname,authority,pro)values(#{sname},#{authority},#{pro})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public int insertTank(Autho autho);

	@Select("select * from autho where sname like '%${sname}%'")
	public List<Autho> selectBystName(@Param(value = "sname") String sname);

}