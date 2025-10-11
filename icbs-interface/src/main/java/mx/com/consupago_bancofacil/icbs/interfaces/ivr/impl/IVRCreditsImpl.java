/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.ivr.impl;

import java.util.logging.Logger;

import mx.com.consupago_bancofacil.icbs.interfaces.ivr.IVRCredits;
import mx.com.consupago_bancofacil.icbs.interfaces.ivr.bo.IVRRequestBO;
import mx.com.consupago_bancofacil.icbs.interfaces.ivr.bo.IVRResponseBO;

import com.ibm.as400.access.AS400;

/**
 * @author juribe
 *
 */
public class IVRCreditsImpl implements IVRCredits {

	private static final Logger logger = Logger.getLogger(IVRCreditsImpl.class
			.getName());
	
	private mx.com.consupago_bancofacil.icbs.interfaces.ivr.connection.ConnectionAS400 connectionAS400;
	
	/**
	 * 
	 */
	public IVRCreditsImpl() {
		connectionAS400 = new mx.com.consupago_bancofacil.icbs.interfaces.ivr.connection.ConnectionAS400();
	}

	/* (non-Javadoc)
	 * @see mx.com.consupago_bancofacil.icbs.interfaces.ivr.IVRCredits#getLoansByBP(com.ibm.as400.access.AS400, java.lang.String)
	 */
	public IVRResponseBO getLoansByBP(AS400 system, String bpId) throws Exception{
		logger.info("-->IVRCreditsImpl.getLoansByBP [ " + bpId + " ]");
		
		IVRRequestBO request = new IVRRequestBO();
		request.setBpId(bpId);
		
		logger.info("<--IVRCreditsImpl.getLoansByBP()");
		return connectionAS400.getLoansByBP( system, request ); 
	}

	/* (non-Javadoc)
	 * @see mx.com.consupago_bancofacil.icbs.interfaces.ivr.IVRCredits#getPaidCreditsByBP(com.ibm.as400.access.AS400, java.lang.String)
	 */
	public IVRResponseBO getPaidCreditsByBP(AS400 system, String bpId) throws Exception{
		logger.info("-->IVRCreditsImpl.getPaidCreditsByBP [ " + bpId + " ]");
		
		IVRRequestBO request = new IVRRequestBO();
		request.setBpId(bpId);
		
		logger.info("<--IVRCreditsImpl.getPaidCreditsByBP()");
		return connectionAS400.getPaidCreditsByBP( system, request ); 
	}

}
