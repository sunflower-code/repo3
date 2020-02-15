package com.mf.repository;

import com.mf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {

    @Query(value="select * from t_user where username like ?1",nativeQuery=true)
    public User findByUserName(String userName);

    @Query(value="select * from t_user where sign like ?1",nativeQuery=true)
    public User findByUserSign(String sign);

}
