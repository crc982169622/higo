package com.crc.higo.mapper;

import com.crc.higo.domain.UserDomain;
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
     * 判断用户信息
     */
    List<UserDomain> findUserByName(String userName);


}
