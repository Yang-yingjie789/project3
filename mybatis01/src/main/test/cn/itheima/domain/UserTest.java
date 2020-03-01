package cn.itheima.domain;

import cn.itheima.dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserTest {
     private InputStream inputStream;
     private SqlSessionFactory factory;
     private  SqlSession session;
     private UserMapper mapper;


     @Before //在test方法执行前执行
    public void init() throws IOException {
        //获取配置文件，生成字节流文件
         inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionConfig工厂
         factory= new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
         session = factory.openSession();
        //使用代理对象执行方法
         mapper=session.getMapper(UserMapper.class);
    }
    @After  ////在test方法执行后执行
    public void destory() throws IOException {
        //释放资源
        session.commit();//事务的提交
        session.close();
        inputStream.close();
    }

    /**
     * 查询所有用户
     * @throws IOException
     */

    @Test
     public  void findAllTest() throws IOException {
        //获取配置文件，生成字节流文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionConfig工厂
        SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession对象
        SqlSession session = factory.openSession();
        //使用代理对象执行方法
       UserMapper mapper=session.getMapper(UserMapper.class);
       List<User> lists= mapper.findAll();
        System.out.println(lists);

    }

    /**
     * 保存用户操作
     * @throws IOException
     */
    @Test
    public void saveUseTest() throws IOException {
        User user=new User();
        user.setUserName("ID测试33");
        user.setUserBirthday(new Date());
        user.setUserAddress("北京市朝阳区望京街道");
        user.setUserSex("女");
        System.out.println(user);
        mapper.saveUser(user);
        System.out.println(user);

    }
    /**
     * 更细用户信息操作
     */
    @Test
    public void updateUser() throws IOException {
        User user=new User();
        user.setUserId(44);
        user.setUserName("Update测试");
        user.setUserBirthday(new Date());
        user.setUserAddress("北京市朝阳区望京街道");
        user.setUserSex("男");
        mapper.updateUser(user);
    }

    /**
     * 删除用户信息操作
     */
    @Test
    public void deleteUser() throws IOException {
        mapper.deleteUser(45);
    }

    /**
     * 根据ID查询用户信息操作
     */
    @Test
    public void findUserById() throws IOException {
       User user=mapper.findById(44);

        System.out.println(user);
    }

    /**
     * 根据姓名模糊查询用户信息操作
     */
    @Test
    public void findUserByName() throws IOException {
        List<User> users=mapper.findUserByName("%测试%");
        for (User user: users) {
            System.out.println(user);
        }
    }


    /**
     * 根据QueryVo模糊查询用户信息操作
     */
    @Test
    public void findUserByVo() throws IOException {
        QueryVo vo=new QueryVo();
        User user=new User();
        user.setUserName("%测试%");
        vo.setUser(user);
        List<User> users=mapper.findUserByVo(vo);
        for (User u: users) {
            System.out.println(u);
        }
    }


}
