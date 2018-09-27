package eCommerce.service;

import eCommerce.pojo.Category;
import eCommerce.util.Page;

import java.util.List;

public interface CategoryService {
    List<Category> list();
//    List<Category> list(Page page);
//    int total();
    void add(Category category);
    void delete(int id);
    Category get(int id);
    void update(Category category);
}
