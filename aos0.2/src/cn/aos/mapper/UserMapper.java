package cn.aos.mapper;

import cn.aos.po.User;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface UserMapper {

	@Select("select * from ouser")
	public List<User> selectAll();

	@Select("select * from ouser where uname=#{uname} and password=#{pwd}")
	public User selectByNameAndPwd(@Param(value = "uname") String uname,
			@Param(value = "pwd") String pwd);

	// @Update("update user set sname=#{sname},authority=#{authority},pro=#{pro} where id=#{id}")
	// public int updateById(Autho autho);
	// @Delete("delete from user where id=#{id}")
	// public int deleteById(@Param(value="id")Integer id);
	// @Insert("insert into autho (id,sname,authority,pro)values(#{id},#{sname},#{authority},#{pro})")
	// @Options(useGeneratedKeys=true,keyProperty="id")
	// public int insertTank(Autho autho);
	@Select("select roleplay from ouser where uname=#{uname} and password=#{pwd}")
	public String selectroleplay(@Param(value = "uname") String uname,
			@Param(value = "pwd") String pwd);

	@Select("select * from ouser")
	public List<User> selectfindall();

	@Update("update ouser set phonenumber=#{phonenumber},roleplay=#{roleplay}, athority=#{athority},pro=#{pro} where id=#{id}")
	public void userupdatedb(@Param(value = "phonenumber") String phonenumber,
			@Param(value = "roleplay") String roleplay,
			@Param(value = "athority") String athority,
			@Param(value = "pro") String pro, @Param(value = "id") int id);

	@Delete("delete from ouser where id=#{id}")
	public void userdelete(@Param(value = "id") int id);

	@Select("select * from ouser where uname=#{name}")
	public List<User> userselect(@Param(value = "name") String name);

	@Insert("insert into ouser(uname,password,age,sex,phonenumber,roleplay,athority,pro) values(#{name},#{pwd},#{age},#{sex},#{phone},#{roleplay},#{athority},#{pro})")
	public void userinsert(@Param(value = "name") String name,
			@Param(value = "pwd") String pwd, @Param(value = "age") int age,
			@Param(value = "sex") String sex,
			@Param(value = "phone") String phone,
			@Param(value = "roleplay") String roleplay,
			@Param(value = "athority") String athority,
			@Param(value = "pro") String pro);

	@Update("update ouser set password=#{newpassword} where uname=#{name};")
	public void userpwdupdate(@Param(value = "name") String name,
			@Param(value = "newpassword") String newpassword);

}