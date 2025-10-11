/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.autoservicio;

import com.ibm.as400.access.AS400;

import mx.com.consubanco.icbs.interfaces.autoservicio.credits.bo.ActiveCreditsResponseBO;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public interface AutoServiceCredits {

	/**
	 * 
	 * @param system
	 * @param bpId
	 * @return
	 * @throws Exception
	 */
	ActiveCreditsResponseBO  getLoansByBP(AS400 system, String bpId) throws Exception;
}
