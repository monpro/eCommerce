package eCommerce.service.impl;

import eCommerce.mapper.UserMapper;
import eCommerce.pojo.User;
import eCommerce.pojo.UserExample;
import eCommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public void add(User user) {
        userMapper.insert(user);

    }

    @Override
    public void delete(int id) {
        userMapper.deleteByPrimaryKey(id);

    }

    @Override
    public User get(int id) {
        return userMapper.selectByPrimaryKey(id);


    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);

    }

    @Override
    public List list() {
        UserExample userExample = new UserExample();
        userExample.setOrderByClause("id desc");
        return userMapper.selectByExample(userExample);
    }
}
