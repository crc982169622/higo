package com.crc.higo.service;

import com.crc.higo.domain.UserDomain;
import com.crc.higo.vo.UserVO;

import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/12 22:11
 **/
public interface UserService {

    /**
     * 查询用户信息
     * @param userName
     * @return
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
     * @param userVO
     * @return
     */
    List<UserDomain> findUserList(UserVO userVO);

    /**
     * 根据id查找用户信息
     * @param userId
     * @return
     */
    UserDomain findUserById(String userId);

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
     * @return
     */
    String addAdminUser(UserDomain userDomain);
}
