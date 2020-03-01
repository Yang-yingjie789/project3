package cn.itheima.dao;

import cn.itheima.domain.QueryVo;
import cn.itheima.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
    void saveUser(User user);
    /**
     * 更新用户信息操作
     */
    void updateUser(User user);
    /**
     * 删除用户操作
     */
    void  deleteUser(int uid);
    /**
     * 根据 ID查询一个用户
     */
    User findById(int id);
    /**
     * 根据姓名模糊查询
     */
    List<User> findUserByName(String username);
    /**
     * 使用queryVo 实现模糊插叙
     */
    List<User> findUserByVo(QueryVo vo);
}
