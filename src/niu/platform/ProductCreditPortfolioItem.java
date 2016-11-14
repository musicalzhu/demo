package niu.platform; /***********************************************************************
 * Module:  niu.platform.ProductCreditPortfolioItem.java
 * Author:  Tom
 * Purpose: Defines the Class niu.platform.ProductCreditPortfolioItem
 ***********************************************************************/

import niu.product.Product;

import java.util.*;

/** 平台针对每位MOM经理的产品授信
 * 每个条目代码某类产品的授信信息
 * 
 * @pdOid f0432ac0-6f00-446c-86f7-176171ec5fcb */
public class ProductCreditPortfolioItem {
   public ProductCreditPortfolioItem(Product product, Map properties) {
		super();
		this.properties = properties;
		this.product = product;
	}

   private Map properties;
   
   public Map getProperties() {
	return properties;
}

public void setProperties(Map properties) {
	this.properties = properties;
}

/** @pdRoleInfo migr=no name=niu.product.Product assc=Association10 mult=0..1 */
   public Product product;
   
   public Product getProduct() {
	return product;
}

public void setProperty(String property, Object value)
   {
       if (properties == null) {
           properties = new HashMap();
       }
       properties.put(property, value);
   }
   
   public Object getProperty(String property) {
       if (properties == null) {
           throw new RuntimeException("No properties for this Unit.");
       }
       Object value = properties.get(property);
       if (value == null)
       {
           throw new RuntimeException("Request for non-existent property.");
       }
       else
       {
           return value;
       }
   }

}