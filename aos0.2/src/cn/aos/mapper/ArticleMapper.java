package cn.aos.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.aos.po.Article;

public interface ArticleMapper {
	// 保存文章信息的方法
	@Insert("insert into article( r_author,r_summary,r_content, r_date, r_verify, r_publish, r_status) values( #{r_author}, #{r_summary}, #{r_content}, #{r_date}, #{r_verify}, #{r_publish}, #{r_status} )")
	public void saveArticle(Article article);

	// 查询（未clean）总记录数
	@Select("select count(*) from article where r_status = 0")
	public int selectCount();

	// 查询（已clean）记录总数
	@Select("select count(*) from article where r_status = 1")
	public int selectCount2();

	public List<Article> findByPage(HashMap<String, Object> map);

	public List<Article> findConByPage(Map<String, Object> conMap);

	@Delete("delete from article where r_id = #{id}")
	public void delete(@Param(value = "id") int id);

	@Select("select * from article where r_id = #{r_id}")
	public Article findById(int r_id);

	// 文章删除功能（仅把文章放入到回收站
	@Update(" update article set r_status = 1 where r_id = #{r_id}")
	public void clean(int r_id);

	// 恢复文章的功能（将文章从回收站中移除，即仅仅改变status的值即可
	@Update("  update article set r_status = 0 where r_id = #{r_id}")
	public void restore(int r_id);

	@Update(" update article set r_id = #{r_id},r_author= #{r_author},r_summary=#{r_summary},r_content= #{r_content},r_date= #{r_date},r_verify= #{r_verify},r_publish= #{r_publish},r_status= #{r_status} where r_id = #{r_id}")
	public void update(Article article);

	@Select("select * from article")
	public List<Article> findAll();

	@Insert("insert into article(r_author,r_date,r_summary) values(#{name}, #{phone}, #{date})")
	@Options(useGeneratedKeys = true, keyProperty = "r_id")
	public void insertarticle(@Param(value = "name") String name,
			@Param(value = "phone") String phone,
			@Param(value = "date") String date);

	@Insert("insert into article(r_author,r_date,r_summary) values(#{r_author}, #{r_date}, #{r_summary})")
	@Options(useGeneratedKeys = true, keyProperty = "r_id")
	public void insertarticle1(Article a);

	@Update(" update article set r_summary=#{date} where r_id = #{id}")
	public void updatearticle(@Param(value = "id") int id,
			@Param(value = "date") String date);

	@Select("select r_summary from article where r_id = #{id}")
	public List<Article> findid(@Param(value = "id") int id);

	@Delete("delete from article where r_id = #{id}")
	public void delete1(@Param(value = "id") int id);

}
