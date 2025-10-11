/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.confirmcredit.impl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.RemoteException;


import mx.com.consupago_bancofacil.icbs.interfaces.confirmcredit.bo.ConfirmCreditRequestBO;
import mx.com.consupago_bancofacil.icbs.interfaces.confirmcredit.bo.ConfirmCreditResponseBO;
import mx.com.consupago_bancofacil.icbs.interfaces.confirmcredit.impl.ConfirmCredit;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.as400.access.AS400;

/**
 * @author Mfinis
 *
 */
public class ConfirmCreditTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link mx.com.consupago_bancofacil.icbs.interfaces.adminClient.impl.AdminClient#AdminClient()}.
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	@Test
	public void testConfirmCredit() throws RemoteException, MalformedURLException {		
		ConfirmCreditRequestBO confirmCreditRequestBO = new ConfirmCreditRequestBO();		
		confirmCreditRequestBO.setApplicationId("java");
		confirmCreditRequestBO.setRequestId("junit");
		confirmCreditRequestBO.setAccountId("0001671294");//0050017300,0050005748 
		confirmCreditRequestBO.setStatusConfirm("1");
		try {	
	    ConfirmCredit test = new ConfirmCredit();		
		ConfirmCreditResponseBO confirmCreditResponseBO = test.confirmCredit(new AS400("172.16.50.241", "S620100003","santafe07"), confirmCreditRequestBO);
		
		
		
		System.out.println("status::"+confirmCreditResponseBO.getStatus());
		System.out.println("code::"+confirmCreditResponseBO.getCode());
		System.out.println("Response::"+confirmCreditResponseBO.getResponse());
		
		
		assertNotNull(confirmCreditResponseBO);
		} catch (ICBSInterfaceException e) {			
			e.printStackTrace();
		} catch (AS400ICBSInterfaceException e) {			
			e.printStackTrace();
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	

}
