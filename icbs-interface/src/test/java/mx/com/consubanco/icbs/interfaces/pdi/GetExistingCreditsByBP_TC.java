/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.pdi;

import junit.framework.TestCase;
import mx.com.consubanco.icbs.interfaces.ConstantesICBS;
import mx.com.consubanco.icbs.interfaces.pdi.impl.PlataformaDigitalICBSServiceImpl;
import mx.com.consubanco.icbs.interfaces.pdi.model.ExistingCreditsResponse;

import com.ibm.as400.access.AS400;

/**
 * @author juribe
 *
 */
public class GetExistingCreditsByBP_TC extends TestCase {
	PlataformaDigitalICBSService service = new PlataformaDigitalICBSServiceImpl();
	
	private AS400 as400System = new AS400(ConstantesICBS.ConnectionCXN.IP,
			ConstantesICBS.ConnectionCXN.USER,
			ConstantesICBS.ConnectionCXN.PASSWORD);
	
	public void testDeberiaEjecutarMetodo() throws Exception{
		/*
		 * BP's de Prueba
		 * 
		 * 0001496945
		 * 0000719746
		 * 0000035199
		 * 
		 */
		String bpId = "0000035199";
		
		ExistingCreditsResponse existingCreditsResponse = service.getExistingCreditsByBP(as400System, bpId);
		assertNotNull(existingCreditsResponse);
		assertEquals("200", existingCreditsResponse.getCode());
		assertEquals("C", existingCreditsResponse.getStatus());
		
		System.out.println(existingCreditsResponse);
		
	}
}
