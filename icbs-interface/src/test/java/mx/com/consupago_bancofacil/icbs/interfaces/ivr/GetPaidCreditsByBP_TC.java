/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.ivr;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import junit.framework.TestCase;
import mx.com.consupago_bancofacil.icbs.interfaces.ivr.bo.IVRResponseBO;
import mx.com.consupago_bancofacil.icbs.interfaces.ivr.impl.IVRCreditsImpl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.as400.access.AS400;

/**
 * @author juribe
 *
 */
public class GetPaidCreditsByBP_TC extends TestCase {

	/**
	 * 
	 */
	public GetPaidCreditsByBP_TC() {
	}

	/**
	 * @param name
	 */
	public GetPaidCreditsByBP_TC(String name) {
		super(name);
	}
	

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
	 * Exito en la consulta  de Creditos Activos
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	@Test
	public void testGetCreditsActives_TestCase1()  {
		IVRCredits ivrCredits = new IVRCreditsImpl();
		AS400 as400 = new AS400("172.16.50.245", "S620100003", "santafe07");
		
		try {
//			IVRResponseBO ivrResponseBO = ivrCredits.getPaidCreditsByBP(as400 , "0000019076");
			IVRResponseBO ivrResponseBO = ivrCredits.getPaidCreditsByBP(as400 , "0002602811");
//			IVRResponseBO ivrResponseBO = ivrCredits.getPaidCreditsByBP(as400 , "0000152715");
			
			
			System.out.println(ivrResponseBO);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
