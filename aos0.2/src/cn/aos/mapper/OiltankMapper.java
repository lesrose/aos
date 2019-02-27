package cn.aos.mapper;

import cn.aos.po.Oiltank;
import cn.aos.po.OiltankPlus;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface OiltankMapper {

	// 查找油罐所有数据
	@Select("select * from ${tname}")
	public List<Oiltank> finddataListbyname(@Param(value = "tname") String tname);

	// 根据Id查找一条数据
	@Select("select * from ${tname} where id=${id}")
	public Oiltank findById(@Param(value = "tname") String tname,
			@Param(value = "id") int id);

	// 根据提供的表名创建新表
	@Update("create table ${tname} (id int primary key identity(1,1),height float,volume float)")
	public void addtankBySname(@Param(value = "tname") String tname);

	// 添加油罐数据
	@Insert("insert into ${tname} (height,volume)values(#{height},#{volume})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void addTankdata(@Param(value = "tname") String tname,
			@Param(value = "height") Double height,
			@Param(value = "volume") Double volume);

	@Insert("insert into ${tname} (height,volume)values(#{height},#{volume})")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void addTankdata1(OiltankPlus oiltankPlus);

	// 修改表名
	@Update("EXEC sp_rename ${oldname}, ${newname}")
	public void changetanknamebByName(@Param(value = "oldname") String oldname,
			@Param(value = "newname") String newname);

	// 删除表
	@Delete("drop table ${taname}")
	public void deleteByName(@Param(value = "taname") String taname);

	// 根据Id删除一条数据
	@Delete("delete from  ${tname} where id=#{id}")
	public void deleteById(OiltankPlus oiltankPlus);

	// 修改表的数据
	@Update("update ${tname} set height=#{height},volume=#{volume} where id=#{id}")
	public void uptankById(@Param(value = "tname") String tname, Oiltank oiltank);

	// 修改表的数据
	@Update("update ${tname} set height=#{height},volume=#{volume} where id=#{id}")
	public void uptankById1(@Param(value = "tname") String tname,
			@Param(value = "height") Double height,
			@Param(value = "volume") Double volume,
			@Param(value = "id") Integer id);

	// 查询表中height的最小值
	@Select("select min(height) height from ${biao}")
	public List<Oiltank> selectheight(@Param(value = "biao") String biao);

	// 查询表中height的最大值
	@Select("select max(height) height from ${biao}")
	public List<Oiltank> selectHeight(@Param(value = "biao") String biao);

	// 查询表中头两行数据
	@Select("select top 2 * from ${biao}")
	public List<Oiltank> selectmin(@Param(value = "biao") String biao);

	// 查询表中后两行数据
	@Select("select top 2 * from ${biao} Order by id desc")
	public List<Oiltank> selectmax(@Param(value = "biao") String biao);

	// 查询表中小于height的高的最大值和对应的体积
	@Select("select max(height) height,max(volume) volume from ${biao} where height<${height}")
	public List<Oiltank> selectbyheight(@Param(value = "height") double height,
			@Param(value = "biao") String biao);

	// 查询表中大于height的高的最小值和对应的体积
	@Select("select min(height) height,min(volume) volume from ${biao} where height>${height}")
	public List<Oiltank> selectbyHeight(@Param(value = "height") double height,
			@Param(value = "biao") String biao);

	// 根据表名查询表中height,volume两列数据
	@Select("select height,volume from ${biao}")
	public List<Oiltank> selectall(@Param(value = "biao") String biao);

	// 查询表中数据count
	@Select("select count(id) from ${biao}")
	public int selectcount(@Param(value = "biao") String biao);

	// 查询表中height的平均值
	@Select("select AVG(height) from ${biao}")
	public double selecthavg(@Param(value = "biao") String biao);

	// 查询表中volume的平均值
	@Select("select AVG(volume) from ${biao}")
	public double selectvavg(@Param(value = "biao") String biao);

	// 根据表名查询表中所有数据
	@Select("select * from ${biao}")
	public List<Oiltank> findAll(@Param(value = "biao") String biao);

	// 将得到的excel文件数据导入数据库表中
	@Insert("insert into ${biao}(height,volume)values(#{oiltank.height},#{oiltank.volume})")
	public void insertdata(@Param(value = "oiltank") Oiltank oiltank,
			@Param(value = "biao") String biao);
	@Select("select sname from autho where id=#{id}")
	public String selectname(@Param(value = "id")int id);

}