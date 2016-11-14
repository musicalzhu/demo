package niu.platform; /***********************************************************************
 * Module:  niu.platform.ProductCreditPortfolio.java
 * Author:  Tom
 * Purpose: Defines the Class niu.platform.ProductCreditPortfolio
 ***********************************************************************/

import java.util.*;

/** 平台针对每位MOM经理的产品授信
 * 
 * @pdOid fcc00eed-36b2-4f84-9156-bbc6b0dc1284 */
public class ProductCreditPortfolio {
   /** @pdRoleInfo migr=no name=niu.platform.ProductCreditPortfolioItem assc=Association9 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Composition */
   public java.util.Collection<ProductCreditPortfolioItem> productCreditPortfolioItem;
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<ProductCreditPortfolioItem> getProductCreditPortfolioItem() {
      if (productCreditPortfolioItem == null)
         productCreditPortfolioItem = new java.util.HashSet<ProductCreditPortfolioItem>();
      return productCreditPortfolioItem;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProductCreditPortfolioItem() {
      if (productCreditPortfolioItem == null)
         productCreditPortfolioItem = new java.util.HashSet<ProductCreditPortfolioItem>();
      return productCreditPortfolioItem.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProductCreditPortfolioItem */
   public void setProductCreditPortfolioItem(java.util.Collection<ProductCreditPortfolioItem> newProductCreditPortfolioItem) {
      removeAllProductCreditPortfolioItem();
      for (java.util.Iterator iter = newProductCreditPortfolioItem.iterator(); iter.hasNext();)
         addProductCreditPortfolioItem((ProductCreditPortfolioItem)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProductCreditPortfolioItem */
   public void addProductCreditPortfolioItem(ProductCreditPortfolioItem newProductCreditPortfolioItem) {
      if (newProductCreditPortfolioItem == null)
         return;
      if (this.productCreditPortfolioItem == null)
         this.productCreditPortfolioItem = new java.util.HashSet<ProductCreditPortfolioItem>();
      if (!this.productCreditPortfolioItem.contains(newProductCreditPortfolioItem))
         this.productCreditPortfolioItem.add(newProductCreditPortfolioItem);
   }
   
   /** @pdGenerated default remove
     * @param oldProductCreditPortfolioItem */
   public void removeProductCreditPortfolioItem(ProductCreditPortfolioItem oldProductCreditPortfolioItem) {
      if (oldProductCreditPortfolioItem == null)
         return;
      if (this.productCreditPortfolioItem != null)
         if (this.productCreditPortfolioItem.contains(oldProductCreditPortfolioItem))
            this.productCreditPortfolioItem.remove(oldProductCreditPortfolioItem);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProductCreditPortfolioItem() {
      if (productCreditPortfolioItem != null)
         productCreditPortfolioItem.clear();
   }

}