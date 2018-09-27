package eCommerce.service.impl;

import eCommerce.mapper.CategoryMapper;
import eCommerce.pojo.Category;
import eCommerce.pojo.CategoryExample;
import eCommerce.service.CategoryService;
import eCommerce.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> list() {
        CategoryExample example = new CategoryExample();
        example.setOrderByClause("id desc");
        return categoryMapper.selectByExample(example);
    }
    //    public List<Category> list(Page page) {
//        //mybatis
//        return categoryMapper.list(page);
//    }

//    public int total(){
//        return categoryMapper.total();
//    }

    public void add(Category category){
        categoryMapper.insert(category);
    }

    public void delete(int id){
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Category get(int id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKey(category);
    }
}
