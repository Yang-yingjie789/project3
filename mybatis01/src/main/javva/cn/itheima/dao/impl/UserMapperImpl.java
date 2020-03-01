package cn.itheima.dao.impl;

import cn.itheima.dao.UserMapper;
import cn.itheima.domain.QueryVo;
import cn.itheima.domain.User;
import com.mysql.cj.Session;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    private SqlSessionFactory factory;
    private SqlSession  session;
    @Override
    public List<User> findAll() {
        session=factory.openSession();
        session.selectList("");

        return null;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(int uid) {

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findUserByName(String username) {
        return null;
    }

    @Override
    public List<User> findUserByVo(QueryVo vo) {
        return null;
    }
}
