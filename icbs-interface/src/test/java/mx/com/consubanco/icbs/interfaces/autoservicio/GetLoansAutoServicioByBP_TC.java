/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.autoservicio;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import junit.framework.TestCase;
import mx.com.consubanco.icbs.interfaces.autoservicio.credits.bo.ActiveCreditsResponseBO;
import mx.com.consubanco.icbs.interfaces.autoservicio.impl.AutoServiceCreditsImpl;

import org.junit.Test;

import com.ibm.as400.access.AS400;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class GetLoansAutoServicioByBP_TC extends TestCase {

	/**
	 * 
	 */
	public GetLoansAutoServicioByBP_TC() {
	}

	/**
	 * @param name
	 */
	public GetLoansAutoServicioByBP_TC(String name) {
		super(name);
	}

	/**
	 * Exito en la consulta  de Creditos Activos para AutoServicio
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	@Test
	public void testGetCreditsActives_TestCase1()  {
		
		
		try {
			
			//0000003679
			ActiveCreditsResponseBO loansByBP = new AutoServiceCreditsImpl().getLoansByBP(new AS400("172.16.50.245", "S620100013", "S620100013"), "0000003679");
			
			System.out.println(loansByBP);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
