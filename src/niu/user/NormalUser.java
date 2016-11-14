package niu.user; /**
 * 
 */

/**
 * @author Tom
 * 普通用户，只能投资
 */
public class NormalUser extends User {

	/**
	 * @param userName
	 */
	public NormalUser(String userName) {
		super(userName);
		// TODO Auto-generated constructor stub
	}


	   /** 提现 */
	   public void withdraw() {
	      // TODO: implement
		   System.out.println("提现");
		   
	   }
}
