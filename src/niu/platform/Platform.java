package niu.platform; /***********************************************************************
 * Module:  niu.platform.Platform.java
 * Author:  Tom
 * Purpose: Defines the Class niu.platform.Platform
 ***********************************************************************/

import niu.product.EagerProduct;
import niu.product.Product;
import niu.product.ProductType;
import niu.product.RobustProduct;
import niu.project.Project;
import niu.user.Mom;

/** @pdOid 60c2dbbc-567a-4d3a-ae1b-042ef296a7cb */
public class Platform {

   private static Platform uniqueInstance;

   public static synchronized Platform getInstance() {
      if (uniqueInstance == null) {
         uniqueInstance = new Platform();
      }
      return uniqueInstance;
   }

   // other useful methods here
   public String getDescription() {
      return "I'm a thread safe Singleton!";
   }

   private Platform() {
		// TODO Auto-generated constructor stub
	   addProduct(new RobustProduct());
	   addProduct(new EagerProduct());
	   projectList = new ProjectList();
	}

/** @pdOid 09638ea5-a9fe-40a1-91bc-58677a1421ad */
   private long platformID;
   
   /** @pdRoleInfo migr=no name=niu.product.Product assc=Association7 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Product> product;
   /** @pdRoleInfo migr=no name=niu.platform.ProjectList assc=Association拥有项目清单 mult=0..1 type=Composition */
   public ProjectList projectList;
   /** @pdRoleInfo migr=no name=niu.platform.PlatformInvestmentPolicy assc=Association平台投资 mult=0..1 */
   public PlatformInvestmentPolicy platformInvestmentPolicy;
   /** @pdRoleInfo migr=no name=niu.platform.PlatformIssuePolicy assc=AssociationIssue mult=0..1 */
   public PlatformIssuePolicy platformIssuePolicy;
   
   /** 平台审核用户的MOM申请
    * 
    * @param mOMApplyDocument
    * @pdOid 1a4c043d-1748-42ce-b206-49b0a2cf2ee3 */
   public void auditMOM(MOMApplyDocument mOMApplyDocument) {
      // TODO: implement
      // 审核逻辑
      // 产生 niu.user.Mom
      // 产生 产品授信组合
   }
   
   /** 平台审核MOM提交的新项目
    * 
    * @param parameter1
    * @pdOid b3473fe2-fa35-4f22-b8c2-2d00743d1c7a */
   public void auditProject(Project parameter1) {
      // TODO: implement
      // 1.审核逻辑
      // 2.调用合约的审核方法
   }
   
   /** MOM经理申请开立项目
    * 
    * @param mOM 
    * @param productType
    * @param projectName 
    * @param originatorSubscribedAmount 
    * @param projectTradeCycle 
    * @param projectStopLossPercent 
    * @param projectStopWinPercent 
    * @param projectCommissionBonusPercent 
    * @param projectBuyDeclaration
    */
   public Project applyProject(Mom mOM, ProductType productType, java.lang.String projectName, double originatorSubscribedAmount, ProjectTradeCycle projectTradeCycle, double projectStopLossPercent, double projectStopWinPercent, double projectCommissionBonusPercent, java.lang.String projectBuyDeclaration) {
	   // TODO: implement
	   // 1.确认满足产品授信
	   // 2.冻结发起人认购金额 
	   // 3.调用项目清单的添加项目方法创建新项目
	   return projectList.addProject(mOM, productType, projectName, originatorSubscribedAmount,projectTradeCycle,projectStopLossPercent,projectStopWinPercent,projectCommissionBonusPercent,projectBuyDeclaration);
   }
   
   /** 平台给MOM经理提供产品授信
    * 
    * @param mOM
    * @pdOid a60b4953-7e0d-4166-bbd8-08cb872f1bff */
   public void credit(Mom mOM) {
      // TODO: implement
      for (java.util.Iterator iter = product.iterator(); iter.hasNext();) {
    	  Product newProduct = (Product)iter.next();
    	  ProductCreditPortfolioItem newProductCreditPortfolioItem = 
    			  new ProductCreditPortfolioItem(newProduct, newProduct.credit(mOM.getStarCode()));
          mOM.getProductCreditPortfolio().addProductCreditPortfolioItem(newProductCreditPortfolioItem);
      }
   }
   
   /** @pdOid 7aa3dc90-b143-453b-aa86-8283c601b09f */
   public void issueProduct() {
      // TODO: implement
   }
   
   /** @pdOid 5d3be07b-fc9e-4f83-a6bb-b712e524ca17 */
   public void createdMOM() {
      // TODO: implement
   }
   
   /** @pdOid e8932d68-9f53-4064-9e6b-f33054a3a31f */
   public void createdUser() {
      // TODO: implement
   }
   
   /** @param parameter1
    * @pdOid d9e9026a-8afe-4062-a1d3-21964fffec9c */
   public int platformInvestment(PlatformInvestmentPolicy parameter1) {
      // TODO: implement
      return 0;
   }
   
   /** @param parameter1
    * @pdOid a7167e0b-af20-464b-a058-53a11e00f1bb */
   public int platformIssue(PlatformIssuePolicy parameter1) {
      // TODO: implement
      return 0;
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Product> getProduct() {
      if (product == null)
         product = new java.util.HashSet<Product>();
      return product;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProduct() {
      if (product == null)
         product = new java.util.HashSet<Product>();
      return product.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProduct */
   public void setProduct(java.util.Collection<Product> newProduct) {
      removeAllProduct();
      for (java.util.Iterator iter = newProduct.iterator(); iter.hasNext();)
         addProduct((Product)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProduct */
   public void addProduct(Product newProduct) {
      if (newProduct == null)
         return;
      if (this.product == null)
         this.product = new java.util.HashSet<Product>();
      if (!this.product.contains(newProduct))
         this.product.add(newProduct);
   }
   
   /** @pdGenerated default remove
     * @param oldProduct */
   public void removeProduct(Product oldProduct) {
      if (oldProduct == null)
         return;
      if (this.product != null)
         if (this.product.contains(oldProduct))
            this.product.remove(oldProduct);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProduct() {
      if (product != null)
         product.clear();
   }

}