package niu.product; /***********************************************************************
 * Module:  niu.product.RobustProduct.java
 * Author:  Tom
 * Purpose: Defines the Class niu.product.RobustProduct
 ***********************************************************************/

import java.lang.annotation.*;
import java.util.*;

/** 稳健型产品
 * 
 * @pdOid a2ff39bb-3d40-4b7b-bc4f-6650e2223bed */
public class RobustProduct extends Product {
	
   /** @pdOid 0edfc27b-a934-4e01-a6b3-0600aef57c3d */
   @Override
   public void profitAssignment() {
      // TODO: implement
   }
   
   /** @param starCode
 * @return 
    * @pdOid 4e82257b-932c-48e2-b69e-d5da1879c4be */
   @Override
   public Map credit(short starCode) {
   	// TODO Auto-generated method stub
   	return super.credit(starCode);
   }

}