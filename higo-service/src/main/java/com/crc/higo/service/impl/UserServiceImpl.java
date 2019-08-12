package com.crc.higo.service.impl;

import com.crc.higo.domain.UserDomain;
import com.crc.higo.mapper.UserDomainMapper;
import com.crc.higo.service.UserService;
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
}
