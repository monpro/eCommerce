package eCommerce.service;

import eCommerce.pojo.Product;
import eCommerce.pojo.Property;
import eCommerce.pojo.PropertyValue;

import java.util.List;

public interface PropertyValueService {
    void init(Product p);
    void update(PropertyValue propertyValue);
    PropertyValue get(int propertyId, int productId);
    List<PropertyValue> list(int productId);

}
