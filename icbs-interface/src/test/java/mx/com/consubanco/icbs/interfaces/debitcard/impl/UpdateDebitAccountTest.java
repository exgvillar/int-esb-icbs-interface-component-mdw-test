/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.debitcard.impl;


import java.net.MalformedURLException;
import java.rmi.RemoteException;

import mx.com.consubanco.icbs.interfaces.ConstantesICBS;
import mx.com.consubanco.icbs.interfaces.debitcard.UpdateDebitAccount;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.UpdateDebitAccountRequestBO;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.UpdateDebitAccountResponseBO;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;

/**
 * @author Mfinis
 *
 */
public class UpdateDebitAccountTest {

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
	public void testUpdateDebitAccount() throws RemoteException, MalformedURLException {
		
		UpdateDebitAccountRequestBO updateDebitAccountRequestBO = new UpdateDebitAccountRequestBO();
		updateDebitAccountRequestBO.setApplicationId("test1");	
		updateDebitAccountRequestBO.setRequestId("test1");
		updateDebitAccountRequestBO.setProcessId("2");
		updateDebitAccountRequestBO.setAccount("11996603");
		updateDebitAccountRequestBO.setStatusAccount("4");
		UpdateDebitAccountResponseBO updateDebitAccountResponseBO=null;
		UpdateDebitAccount test = new UpdateDebitAccountImpl();
		try {
			AS400 as400Captacion = new AS400(ConstantesICBS.ConnectionCaptacion.IP,
					ConstantesICBS.ConnectionCaptacion.USER,
					ConstantesICBS.ConnectionCaptacion.PASSWORD);
			
			updateDebitAccountResponseBO = test.updateDebitAccount(as400Captacion, updateDebitAccountRequestBO);
			
			System.out.println("status::"+updateDebitAccountResponseBO.getStatus());
			System.out.println("code::"+updateDebitAccountResponseBO.getCode());
			System.out.println("Response::"+updateDebitAccountResponseBO.getResponse());
			System.out.println("Status Accunt::"+updateDebitAccountResponseBO.getStatusUpdate());
			System.out.println("Status Cause::"+updateDebitAccountResponseBO.getCause());
		} catch (AS400Exception e) {
			
			e.printStackTrace();
		} catch (ICBSInterfaceException e) {
			
			e.printStackTrace();
		} catch (AS400ICBSInterfaceException e) {
			
			e.printStackTrace();
		}
		Assert.assertNotNull(updateDebitAccountResponseBO);
	}	

}
