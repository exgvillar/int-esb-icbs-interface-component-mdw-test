/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.pdi;

import junit.framework.TestCase;
import mx.com.consubanco.icbs.interfaces.ConstantesICBS;
import mx.com.consubanco.icbs.interfaces.pdi.impl.PlataformaDigitalICBSServiceImpl;
import mx.com.consubanco.icbs.interfaces.pdi.model.CreditDetailResponse;

import com.ibm.as400.access.AS400;

/**
 * @author juribe
 *
 */
public class GetCreditDetailByAccountId_TC extends TestCase {

PlataformaDigitalICBSService service = new PlataformaDigitalICBSServiceImpl();
	
	private AS400 as400System = new AS400(ConstantesICBS.ConnectionCXN.IP,
			ConstantesICBS.ConnectionCXN.USER,
			ConstantesICBS.ConnectionCXN.PASSWORD);
	
	public void testDeberiaEjecutarMetodo() throws Exception{
		/*
		 * Creditos de prueba
		 * 
		 * 0002420400, 0002569877, 0002714567, 0007334083, 0003562185, 0006035301, 0007483117
		 */
		String accountId = "0003562185";
		
		CreditDetailResponse CcreditDetailResponse = service.getCreditDetailByAccountId(as400System, accountId);
		
		assertNotNull(CcreditDetailResponse);
		assertEquals("200", CcreditDetailResponse.getCode());
		assertEquals("C", CcreditDetailResponse.getStatus());
		
		System.out.println(CcreditDetailResponse);
		
	}
}
