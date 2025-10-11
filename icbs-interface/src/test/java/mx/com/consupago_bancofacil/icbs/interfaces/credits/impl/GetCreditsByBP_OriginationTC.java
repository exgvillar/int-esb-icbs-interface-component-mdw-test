/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.credits.impl;

import mx.com.consubanco.icbs.interfaces.ConstantesICBS;
import mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditResponseBO;

import com.ibm.as400.access.AS400;

import junit.framework.TestCase;

/**
 * @author juribe
 *
 */
public class GetCreditsByBP_OriginationTC extends TestCase {

	
	public void testDeberiaEjecutarPrograma() {
		
		CreditActives iCreditActives = new CreditActives();
		
		String bpId = "123";
			
		AS400 as400CxN = new AS400(ConstantesICBS.ConnectionCXN.IP,
				ConstantesICBS.ConnectionCXN.USER,
				ConstantesICBS.ConnectionCXN.PASSWORD);
		
			
		CreditResponseBO creditsByBP = iCreditActives.getCreditsByBP(as400CxN, bpId );
		
		System.out.println(creditsByBP);
	}
}
