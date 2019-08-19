package com.crc.higo.mapper;

import com.crc.higo.domain.UserDomain;
import com.crc.higo.vo.UserVO;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Param;
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
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    List<UserDomain> findUserByName(@Param("userName")String userName);

    /**
     * 新增用户
     * @param userDomain
     *
     */
    void addUserDomain(UserDomain userDomain);

    /**
     * 删除用户信息
     * @param userId
     */
    void deleteUserDomain(@Param("userId")String userId);

    /**
     * 更新用户洗洗
     * @param userDomain
     */
    void updateUserDomain(UserDomain userDomain);

    /**
     * 查询用户信息
     * @param userVO
     * @return
     */
    List<UserDomain> findUserList(UserVO userVO);


    /**
     * 根据id获取用户信息
     * @param userId
     * @return
     */
    UserDomain findUserById(@Param("userId")String userId);

    /**
     * 修改用户密码
     * @param userDomain
     */
    void updatePassword(UserDomain userDomain);

    /**
     * 查询管理员用户信息
     * @param userVO
     * @return
     */
    List<UserDomain> findAdminUserList(UserVO userVO);

    /**
     * 添加管理员用户
     * @param userDomain
     *
     */
    void addAdminUser(UserDomain userDomain);

    /**
     * 修改用户信息
     * @param userDomain
     */
    void updateUser(UserDomain userDomain);





}
