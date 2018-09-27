package eCommerce.service.impl;

import eCommerce.mapper.PropertyValueMapper;
import eCommerce.pojo.Product;
import eCommerce.pojo.Property;
import eCommerce.pojo.PropertyValue;
import eCommerce.pojo.PropertyValueExample;
import eCommerce.service.CategoryService;
import eCommerce.service.PropertyService;
import eCommerce.service.PropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PropertyValueServiceImpl implements PropertyValueService {
    @Autowired
    PropertyValueMapper propertyValueMapper;

    @Autowired
    PropertyService propertyService;
    @Override
    public void init(Product p) {
        List<Property> list = propertyService.list(p.getCid());
        for(Property property: list){
            PropertyValue propertyValue = get(property.getId(), p.getCid());
            if(propertyValue == null){
                PropertyValue pv = new PropertyValue();
                pv.setId(p.getId());
                pv.setPtid(property.getId());
                propertyValueMapper.insert(pv);
            }

        }

    }

    @Override
    public void update(PropertyValue pv) {
        propertyValueMapper.updateByPrimaryKeySelective(pv);
    }

    @Override
    public PropertyValue get(int ptid, int pid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPtidEqualTo(ptid).andPidEqualTo(pid);
        List<PropertyValue> pvs= propertyValueMapper.selectByExample(example);
        if (pvs.isEmpty())
            return null;
        return pvs.get(0);
    }

    @Override
    public List<PropertyValue> list(int pid) {
        PropertyValueExample example = new PropertyValueExample();
        example.createCriteria().andPidEqualTo(pid);
        List<PropertyValue> result = propertyValueMapper.selectByExample(example);
        for (PropertyValue pv : result) {
            Property property = propertyService.get(pv.getPtid());
            pv.setProperty(property);
        }
        return result;
    }
}
