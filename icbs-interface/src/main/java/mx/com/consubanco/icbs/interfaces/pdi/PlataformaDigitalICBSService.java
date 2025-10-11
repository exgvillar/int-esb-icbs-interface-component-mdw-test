/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.pdi;

import com.ibm.as400.access.AS400;

import mx.com.consubanco.icbs.interfaces.pdi.model.ExistingCreditsResponse;
import mx.com.consubanco.icbs.interfaces.pdi.model.CreditDetailResponse;

/**
 * @author juribe
 *
 */
public interface PlataformaDigitalICBSService {

	/**
	 * 
	 * @param as400
	 * @param bpId
	 * @return
	 * @throws Exception
	 */
	ExistingCreditsResponse getExistingCreditsByBP(AS400 as400System, String bpId) throws Exception;
	
	/**
	 * 
	 * @param as400
	 * @param accountId
	 * @return
	 * @throws Exception
	 */
	CreditDetailResponse getCreditDetailByAccountId(AS400 as400System, String accountId) throws Exception;
	
}
