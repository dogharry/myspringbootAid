package hello;

import org.apache.ibatis.io.ResolverUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World SpringBoot!!!";
    }


    @RequestMapping("/userinfo")
    @ResponseBody
    String userinfo() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        TestDao testDao = sqlSession.getMapper(TestDao.class);
        return testDao.find().toString();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}