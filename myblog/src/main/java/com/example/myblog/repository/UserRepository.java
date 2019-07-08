package com.example.myblog.repository;

import com.example.myblog.domain.User;
import org.springframework.data.repository.CrudRepository;


/**
 * @author victor
 * @date 2019-07-04
 */


// 定义用户操作接口
public interface UserRepository extends CrudRepository<User, Long> {

}
