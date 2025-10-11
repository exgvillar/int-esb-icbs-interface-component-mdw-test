/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.miCSB2;

import junit.framework.TestCase;
import mx.com.consubanco.icbs.interfaces.ConstantesICBS;
import mx.com.consubanco.icbs.interfaces.miCSB.IMiConsubanco2;
import mx.com.consubanco.icbs.interfaces.miCSB.impl.MiConsubanco2Impl;
import mx.com.consubanco.icbs.interfaces.miCSB.model.GetActiveCreditsResponse;

import com.ibm.as400.access.AS400;

/**
 * @author juribe
 * 
 */
public class MiConsubanco2_TC extends TestCase {

	private IMiConsubanco2 iMiConsubanco2 = new MiConsubanco2Impl();

	private AS400 as400System = new AS400(ConstantesICBS.ConnectionCXN.IP,
			ConstantesICBS.ConnectionCXN.USER,
			ConstantesICBS.ConnectionCXN.PASSWORD);

	public void testDeberiaEjecutarPrograma() throws Exception {

		String customerBP = "1468286";

		GetActiveCreditsResponse response = iMiConsubanco2
				.getActiveCreditsSubjectToRestructuring(as400System, customerBP);

		assertNotNull(response);
		assertEquals("200", response.getCode());
		assertEquals("C", response.getStatus());

		System.out.println(response);

	}
}
