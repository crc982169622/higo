package com.crc.higo.service;

import com.crc.higo.domain.UserDomain;

import java.util.List;

/**
 * @author: chenrencun
 * @version：
 * @date: 2019/8/12 22:11
 **/
public interface UserService {

    List<UserDomain> findUserByName(String userName);
}
