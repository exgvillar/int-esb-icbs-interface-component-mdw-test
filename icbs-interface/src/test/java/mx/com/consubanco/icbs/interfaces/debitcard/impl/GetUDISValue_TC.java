package mx.com.consubanco.icbs.interfaces.debitcard.impl;

import junit.framework.TestCase;
import mx.com.consubanco.icbs.interfaces.ConstantesICBS;
import mx.com.consubanco.icbs.interfaces.debitcard.IUpgradeN2toN4ICBSService;
import mx.com.consubanco.icbs.interfaces.debitcard.n2ton4.bo.GetUDISValueResponse;

import com.ibm.as400.access.AS400;

public class GetUDISValue_TC extends TestCase {
	IUpgradeN2toN4ICBSService srv = new UpgradeN2toN4ICBSServiceImpl();

	private AS400 as400System = new AS400(ConstantesICBS.ConnectionCXN.IP,
			ConstantesICBS.ConnectionCXN.USER,
			ConstantesICBS.ConnectionCXN.PASSWORD);

	
	public void testDeberiaObtenerValorDeUDIS() throws Exception {
		
		
		String productNumber = "3";
		GetUDISValueResponse response = srv.getUDISValue(as400System, productNumber);
		
		assertNotNull(response);
		assertEquals("C", response.getStatus());
		assertEquals("200", response.getCode());
		assertEquals("Exito", response.getResponse());
	}
}
