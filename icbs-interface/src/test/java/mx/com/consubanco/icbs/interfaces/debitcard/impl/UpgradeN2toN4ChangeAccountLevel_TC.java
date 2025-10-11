package mx.com.consubanco.icbs.interfaces.debitcard.impl;

import junit.framework.TestCase;
import mx.com.consubanco.icbs.interfaces.ConstantesICBS;
import mx.com.consubanco.icbs.interfaces.debitcard.IUpgradeN2toN4ICBSService;
import mx.com.consubanco.icbs.interfaces.debitcard.n2ton4.bo.UpgradeN2toN4Response;

import com.ibm.as400.access.AS400;

public class UpgradeN2toN4ChangeAccountLevel_TC extends TestCase {
	IUpgradeN2toN4ICBSService srv = new UpgradeN2toN4ICBSServiceImpl();

	private AS400 as400System = new AS400(ConstantesICBS.ConnectionCXN.IP,
			ConstantesICBS.ConnectionCXN.USER,
			ConstantesICBS.ConnectionCXN.PASSWORD);

	
	public void testDeberiaActualizarCuenta() throws Exception {
		
		
		String accountId = "132312";
		String type = "23";
		UpgradeN2toN4Response response = srv.changeAccountLevel(as400System, accountId, type);
		
		assertNotNull(response);
		assertEquals("C", response.getStatus());
		assertEquals("200", response.getCode());
		assertEquals("Exito", response.getResponse());
	}
}
