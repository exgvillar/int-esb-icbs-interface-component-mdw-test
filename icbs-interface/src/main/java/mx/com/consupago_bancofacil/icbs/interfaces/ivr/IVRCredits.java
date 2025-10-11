/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.ivr;

import mx.com.consupago_bancofacil.icbs.interfaces.ivr.bo.IVRResponseBO;

import com.ibm.as400.access.AS400;

/**
 * @author juribe
 *
 */
public interface IVRCredits {

	/**
	 * 
	 * @param system
	 * @param bpId
	 * @throws Exception
	 */
	IVRResponseBO getLoansByBP(AS400 system, String bpId) throws Exception;
	
	/**
	 * 
	 * @param system
	 * @param bpId
	 * @throws Exception
	 */
	IVRResponseBO getPaidCreditsByBP(AS400 system, String bpId) throws Exception;
	
	
	
}
