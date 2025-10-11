/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.debitcard.impl;

import junit.framework.TestCase;
import mx.com.consubanco.icbs.interfaces.ConstantesICBS;
import mx.com.consubanco.icbs.interfaces.debitcard.IDebitICBSServices;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.GatNominalResponse;

import org.junit.Test;

import com.ibm.as400.access.AS400;

/**
 * @author juribe
 *
 */
public class GatNominalByDebitAccount_TC extends TestCase {
	IDebitICBSServices srv = new DebitICBSServicesImpl();

	private AS400 as400System = new AS400(ConstantesICBS.ConnectionCXN.IP,
			ConstantesICBS.ConnectionCXN.USER,
			ConstantesICBS.ConnectionCXN.PASSWORD);

	@Test
	public void testGetGatNominalByDebitAccount() throws Exception {
		String debitAccount = "1234";

		GatNominalResponse response = srv.gatNominalByDebitAccount(as400System,
				debitAccount);
		assertNotNull(response);
		assertEquals("C", response.getStatus());
		assertEquals("200", response.getCode());
		assertEquals("Exito", response.getResponse());
	}

}
