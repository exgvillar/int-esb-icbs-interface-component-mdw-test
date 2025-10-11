/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.debitcard.impl;


import java.net.MalformedURLException;
import java.rmi.RemoteException;

import mx.com.consubanco.icbs.interfaces.ConstantesICBS;
import mx.com.consubanco.icbs.interfaces.debitcard.RelationshipAccountPlastic;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.RelationshipAccountPlasticRequestBO;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.RelationshipAccountPlasticResponseBO;
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
public class RelationshipAccountPlasticTest {

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
		
		RelationshipAccountPlasticRequestBO relationshipAccountPlasticRequestBO = new RelationshipAccountPlasticRequestBO();
		relationshipAccountPlasticRequestBO.setApplicationId("test1");	
		relationshipAccountPlasticRequestBO.setRequestId("test1");
		relationshipAccountPlasticRequestBO.setProcessId("2");
		relationshipAccountPlasticRequestBO.setAccountNumber("0001996434");
		relationshipAccountPlasticRequestBO.setCreditCardNumber("4712391010000093");
		RelationshipAccountPlasticResponseBO relationshipAccountPlasticResponseBO=null;
		RelationshipAccountPlastic test = new RelationshipAccountPlasticImpl();
		try {
			AS400 as400Captacion = new AS400(ConstantesICBS.ConnectionCXN.IP,
					ConstantesICBS.ConnectionCXN.USER,
					ConstantesICBS.ConnectionCXN.PASSWORD);
			
			relationshipAccountPlasticResponseBO = test.relationshipAccountPlastic(as400Captacion, relationshipAccountPlasticRequestBO);
			
			System.out.println("status::"+relationshipAccountPlasticResponseBO.getStatus());
			System.out.println("code::"+relationshipAccountPlasticResponseBO.getCode());
			System.out.println("Response::"+relationshipAccountPlasticResponseBO.getResponse());
			//System.out.println("Status Accunt::"+updateDebitAccountResponseBO.getStatusUpdate());
			//System.out.println("Status Cause::"+updateDebitAccountResponseBO.getCause());
		} catch (AS400Exception e) {
			
			e.printStackTrace();
		} catch (ICBSInterfaceException e) {
			
			e.printStackTrace();
		} catch (AS400ICBSInterfaceException e) {
			
			e.printStackTrace();
		}
		Assert.assertNotNull(relationshipAccountPlasticResponseBO);
	}	

}
