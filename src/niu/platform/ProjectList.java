package niu.platform; /***********************************************************************
 * Module:  niu.platform.ProjectList.java
 * Author:  Tom
 * Purpose: Defines the Class niu.platform.ProjectList
 ***********************************************************************/

import niu.project.ProjectState;
import niu.product.ProductType;
import niu.project.Project;
import niu.user.Mom;

import java.util.*;

/** @pdOid e42f83b6-6c76-4e5f-871c-1970b622eb3a */
public class ProjectList {
   /** @pdRoleInfo migr=no name=niu.myProjects.Project assc=Association15 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   public java.util.Collection<Project> project;
   
   /** @param mOMName 
    * @param projectName 
    * @param projectState
    * @param productType
    * @pdOid ad5947ab-8742-4c6f-8305-0940a800aaea */
   public Project[] searchProject(java.lang.String mOMName, java.lang.String projectName, ProjectState projectState, ProductType productType) {
      // TODO: implement
      return null;
   }
   
   /** 添加项目
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
    * @pdOid de7efd07-b3c8-4164-b6d1-80cd9b5ef5b6 */
   public Project addProject(Mom mOM, ProductType productType, java.lang.String projectName, double originatorSubscribedAmount, ProjectTradeCycle projectTradeCycle, double projectStopLossPercent, double projectStopWinPercent, double projectCommissionBonusPercent, java.lang.String projectBuyDeclaration) {
      // TODO: implement
	  Collection<ProductCreditPortfolioItem> productCreditPortfolioItem = mOM.getProductCreditPortfolio().getProductCreditPortfolioItem();
      for (java.util.Iterator iter = productCreditPortfolioItem.iterator(); iter.hasNext();) {
    	  ProductCreditPortfolioItem currentProductCreditPortfolioItem = (ProductCreditPortfolioItem)iter.next();
    	  ProductType currentProductType = (ProductType) currentProductCreditPortfolioItem.getProperty("niu.product.ProductType");
    	  if (productType == currentProductType) {
    	      Project project = new Project(mOM, 
    	    		  productType, 
    	    		  projectName, 
    	    		  originatorSubscribedAmount,
    	    		  projectTradeCycle,
    	    		  projectStopLossPercent,
    	    		  projectStopWinPercent,
    	    		  projectCommissionBonusPercent,
    	    		  projectBuyDeclaration,
    	    		  currentProductCreditPortfolioItem.getProperties());
    	      
    	      this.addProject(project);
    	      
    	      return project;
    	  }
      }
      
      return null;
   }
   
   /** @param projectID
    * @pdOid 1ecb204f-ad06-4c66-8c2a-7e62ec47ba3a */
   public void getProject(long projectID) {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Project> getProject() {
      if (project == null)
         project = new java.util.HashSet<Project>();
      return project;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProject() {
      if (project == null)
         project = new java.util.HashSet<Project>();
      return project.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProject */
   public void setProject(java.util.Collection<Project> newProject) {
      removeAllProject();
      for (java.util.Iterator iter = newProject.iterator(); iter.hasNext();)
         addProject((Project)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProject */
   public void addProject(Project newProject) {
      if (newProject == null)
         return;
      if (this.project == null)
         this.project = new java.util.HashSet<Project>();
      if (!this.project.contains(newProject))
         this.project.add(newProject);
   }
   
   /** @pdGenerated default remove
     * @param oldProject */
   public void removeProject(Project oldProject) {
      if (oldProject == null)
         return;
      if (this.project != null)
         if (this.project.contains(oldProject))
            this.project.remove(oldProject);
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProject() {
      if (project != null)
         project.clear();
   }

}