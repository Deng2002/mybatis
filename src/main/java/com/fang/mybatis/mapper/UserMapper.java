package com.fang.mybatis.mapper;

import com.fang.mybatis.pojo.User;

public interface UserMapper {
    /**
     * 添加用户
     * @return
     */
    int insertUser();

    /**
     * 更新用户
     */
    void updataUser();

    /**
     * 删除用户
     */
    void deleteUser();

    /**
     * 查询用户
     */
    User getUserByUsername(String username);
    /**
     * 验证用户
     */
    User checkUser(String username,String password);
}
