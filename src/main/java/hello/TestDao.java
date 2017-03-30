package hello;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface TestDao {

    @Select("select * from wx_userinfo;")
    public Map<String,Object> find();

    @Insert("insert into wx_userinfo(openid,status,nickname,sex,city,province,country,headimgurl,subscribe_time) "+
            "values(#{id},1,'nick',1,'city','provi','contr','img',now())")
    public int insert(@Param("id")int id);
}