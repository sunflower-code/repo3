package com.mf.service.Impl;

import com.mf.entity.User;
import com.mf.repository.UserRepository;
import com.mf.service.UserService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;


    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }


    @Override
    public User findByUserSign(String sign) {
        return userRepository.findByUserSign(sign);
    }


    @Override
    public List<User> list(User user, Integer page, Integer pageSize, Sort.Direction direction, String... properties) {
        return null;
    }

    @Override
    public Long getCount(User user) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public User findById(Integer id) {
        return null;
    }
    
}
