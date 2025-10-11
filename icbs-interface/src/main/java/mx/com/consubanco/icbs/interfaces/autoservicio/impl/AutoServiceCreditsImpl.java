/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.autoservicio.impl;

import java.util.logging.Logger;

import mx.com.consubanco.icbs.interfaces.autoservicio.AutoServiceCredits;
import mx.com.consubanco.icbs.interfaces.autoservicio.credits.connection.ConnectionAS400;
import mx.com.consubanco.icbs.interfaces.autoservicio.credits.bo.ActiveCreditsRequestBO;
import mx.com.consubanco.icbs.interfaces.autoservicio.credits.bo.ActiveCreditsResponseBO;

import com.ibm.as400.access.AS400;

/**
 * 
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 *
 */
public class AutoServiceCreditsImpl implements AutoServiceCredits {

	private static final Logger logger = Logger.getLogger(AutoServiceCreditsImpl.class
			.getName());
	
	private ConnectionAS400 connectionAS400;
	/**
	 * 
	 */
	public AutoServiceCreditsImpl() {
		connectionAS400 = new ConnectionAS400();
	}

	/* (non-Javadoc)
	 * @see mx.com.consubanco.icbs.interfaces.autoservicio.AutoServiceCredits#getLoansByBP(com.ibm.as400.access.AS400, java.lang.String)
	 */
	public ActiveCreditsResponseBO getLoansByBP(AS400 system, String bpId) throws Exception {
		logger.info("-->AutoServiceCreditsImpl.getLoansByBP [ " + bpId + " ]");
		
		ActiveCreditsRequestBO request = null;
		request = new ActiveCreditsRequestBO();
		request.setBpId(bpId);
		
		logger.info("-->AutoServiceCreditsImpl.getLoansByBP [ " + bpId + " ]");
		
		return connectionAS400.getCreditsActivesAutoServiceByBP(system, request );
	}

}
