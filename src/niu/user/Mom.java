package niu.user; /***********************************************************************
 * Module:  niu.user.Mom.java
 * Author:  Tom
 * Purpose: Defines the Class niu.user.Mom
 ***********************************************************************/

import niu.common.Subject;
import niu.common.Observer;
import niu.platform.Platform;
import niu.platform.ProductCreditPortfolio;
import niu.platform.ProjectTradeCycle;
import niu.product.ProductType;
import niu.project.Project;

import java.util.ArrayList;


/**
 * @author Tom
 * 可以做普通用户所有的事情，而且还可以发起项目操盘
 */
public class Mom extends NormalUser implements Subject {
   
   public Mom(String mOMName) {
        super(mOMName);
        this.mOMName = mOMName;
        this.productCreditPortfolio = new ProductCreditPortfolio();
        this.starCode = 1;

        observers = new ArrayList<Observer>();
	}

	
	private ArrayList<Observer> observers;
	   
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public void notifyObservers(Object arg) {
		for (Observer observer : observers) {
			observer.update(this, arg);
		}
	}
	
	public void mOMChanged(Object arg) {
		notifyObservers(arg);
	}
	

/** MOM编号
    * 
    * @pdOid cf21c965-5f0f-4967-9f07-c6595f86494f */
   private long mOMID;
   /** MOM名称
    * 
    * @pdOid 6cf707b3-0c2d-4342-8775-4c535634b122 */
   private java.lang.String mOMName;
   public java.lang.String getmOMName() {
	return mOMName;
}

public void setmOMName(java.lang.String mOMName) {
	this.mOMName = mOMName;
}

/** @pdOid a224d57c-742c-436a-8a88-726f1a014df1 */
   private java.lang.String tradeIdea;
   /** @pdOid 5fe2237c-f465-4857-9e01-c11f93726435 */
   private java.lang.String personIntroduction;
   /** 合买宣言
    * 
    * @pdOid dc360f2e-de98-4bff-b0da-42e6b151c89a */
   private java.lang.String buyDeclaration;
   /** @pdOid fb6f809e-6c23-4615-80af-1f79863ca178 */
   private MomType mOMType;
   /** @pdOid 2836fc15-8eac-48cb-b039-5aa4795fff4f */
   private Boolean ifAutomaticBid;
   /** @pdOid e1d0a7fb-d238-45b2-ac43-bd4bf61e92d9 */
   private Boolean ifAutomaticRepayment;
   /** @pdOid 4aa59cdd-6947-4206-8a17-343a94c0c2f1 */
   private short starCode;
   
   /** @pdRoleInfo migr=no name=niu.platform.ProductCreditPortfolio assc=Association11 mult=0..1 */
   private ProductCreditPortfolio productCreditPortfolio;
   
   /** @pdRoleInfo migr=no name=niu.myProjects.Project assc=Association13 coll=java.util.Collection impl=java.util.HashSet mult=0..* */
   public java.util.Collection<Project> myProjects;
   
   /** @pdOid 1aee4fc7-09f4-4149-a8fc-2484ef9ea446 */
   public void signAutomaticBid() {
      // TODO: implement
   }
   
   /** @pdOid 9abd71ae-5181-46da-b954-2e0310b4daa2 */
   public void signAutomaticRepayment() {
      // TODO: implement
   }
   
   
   /** @pdGenerated default getter */
   public java.util.Collection<Project> getMyProjects() {
      if (myProjects == null)
         myProjects = new java.util.HashSet<Project>();
      return myProjects;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorProject() {
      if (myProjects == null)
         myProjects = new java.util.HashSet<Project>();
      return myProjects.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newProject */
   public void setMyProjects(java.util.Collection<Project> newProject) {
      removeAllProject();
      for (java.util.Iterator iter = newProject.iterator(); iter.hasNext();)
         addProject((Project)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newProject */
   public void addProject(Project newProject) {
      if (newProject == null)
         return;
      if (this.myProjects == null)
         this.myProjects = new java.util.HashSet<Project>();
      if (!this.myProjects.contains(newProject))
      {
         this.myProjects.add(newProject);
         newProject.setMOM(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldProject */
   public void removeProject(Project oldProject) {
      if (oldProject == null)
         return;
      if (this.myProjects != null)
         if (this.myProjects.contains(oldProject))
         {
            this.myProjects.remove(oldProject);
            oldProject.setMOM((Mom)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllProject() {
      if (myProjects != null)
      {
         Project oldProject;
         for (java.util.Iterator iter = getIteratorProject(); iter.hasNext();)
         {
            oldProject = (Project)iter.next();
            iter.remove();
            oldProject.setMOM((Mom)null);
         }
      }
   }

public short getStarCode() {
	return starCode;
}

public void setStarCode(short starCode) {
	this.starCode = starCode;
}

/**
 * @return the productCreditPortfolio
 */
public ProductCreditPortfolio getProductCreditPortfolio() {
	return productCreditPortfolio;
}


    /** 申请开立项目
     *
     * @param productType
     * @param projectName
     * @param originatorSubscribedAmount
     * @param projectTradeCycle
     * @param projectStopLossPercent
     * @param projectStopWinPercent
     * @param projectCommissionBonusPercent
     * @param projectBuyDeclaration
     */
    public Project applyProject(ProductType productType, java.lang.String projectName, double originatorSubscribedAmount, ProjectTradeCycle projectTradeCycle, double projectStopLossPercent, double projectStopWinPercent, double projectCommissionBonusPercent, java.lang.String projectBuyDeclaration) {

        Project myProject = platform.applyProject(this, productType, projectName, originatorSubscribedAmount,projectTradeCycle,projectStopLossPercent,projectStopWinPercent,projectCommissionBonusPercent,projectBuyDeclaration);
        promotionValidation();
        return myProject;
    }

    public String toString() {
        return this.getmOMName();
    }
}