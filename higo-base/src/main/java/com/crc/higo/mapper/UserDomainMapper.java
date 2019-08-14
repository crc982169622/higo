package com.crc.higo.mapper;

import com.crc.higo.domain.UserDomain;
import org.apache.catalina.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: chenrencun
 * @Date: 2019/8/12 11:16
 * @Description: 描述
 */
@Repository
public interface UserDomainMapper {

    /**
     * 通过用户名获取用户信息
     *
     */
    List<UserDomain> findUserByName(String userName);

    /**
     * 新增用户
     * @param userDomain
     * @return
     */
    String addUserDomain(UserDomain userDomain);

    /**
     * 删除用户信息
     * @param userId
     */
    void deleteUserDomain(String userId);

    /**
     * 更新用户洗洗
     * @param userDomain
     */
    void updateUserDomain(UserDomain userDomain);

    /**
     * 查询所有用户
     * @return
     */
    List<UserDomain> findUserList();

    /**
     * 根据id查找用户信息
     * @return
     */
    UserDomain findUserById(String userId);






}
