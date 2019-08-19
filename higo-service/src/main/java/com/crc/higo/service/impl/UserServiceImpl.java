package com.crc.higo.service.impl;

import com.crc.higo.domain.UserDomain;
import com.crc.higo.mapper.UserDomainMapper;
import com.crc.higo.service.UserService;
import com.crc.higo.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/12 22:11
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDomainMapper userDomainMapper;

    @Override
    public List<UserDomain> findUserByName(String userName) {
        return userDomainMapper.findUserByName(userName);
    }

    @Override
    public void addUserDomain(UserDomain userDomain) {
         userDomainMapper.addUserDomain(userDomain);
    }

    @Override
    public void deleteUserDomain(String userId) {
        userDomainMapper.deleteUserDomain(userId);

    }

    @Override
    public void updateUserDomain(UserDomain userDomain) {
        userDomainMapper.updateUserDomain(userDomain);
    }

    @Override
    public List<UserDomain> findUserList(UserVO userVO) {
        return userDomainMapper.findUserList(userVO);
    }

    @Override
    public UserDomain findUserById(String userId) {
        return userDomainMapper.findUserById(userId);
    }

    @Override
    public void updatePassword(UserDomain userDomain) {
        userDomainMapper.updatePassword(userDomain);
    }

    @Override
    public List<UserDomain> findAdminUserList(UserVO userVO) {
        return userDomainMapper.findAdminUserList(userVO);
    }

    @Override
    public void addAdminUser(UserDomain userDomain) {
         userDomainMapper.addAdminUser(userDomain);
    }

    @Override
    public void updateUser(UserDomain userDomain) {
        userDomainMapper.updateUser(userDomain);
    }
}
