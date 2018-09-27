package eCommerce.service;

import eCommerce.pojo.User;

import java.util.List;

public interface UserService {
    void add(User user);
    void delete(int id);
    User get(int id);
    void update(User user);
    List list();
}
