/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.pdi.impl;

import com.ibm.as400.access.AS400;

import mx.com.consubanco.icbs.interfaces.pdi.PlataformaDigitalICBSService;
import mx.com.consubanco.icbs.interfaces.pdi.component.ExistingCreditsComponent;
import mx.com.consubanco.icbs.interfaces.pdi.component.CreditDetailComponent;
import mx.com.consubanco.icbs.interfaces.pdi.model.ExistingCreditsResponse;
import mx.com.consubanco.icbs.interfaces.pdi.model.CreditDetailResponse;

/**
 * @author jrauluribes
 *
 */
public class PlataformaDigitalICBSServiceImpl implements PlataformaDigitalICBSService {

	/* (non-Javadoc)
	 * @see mx.com.consubanco.icbs.interfaces.pdi.PlataformaDigitalICBSService#getExistingCreditsByBP(com.ibm.as400.access.AS400, java.lang.String)
	 */
	public ExistingCreditsResponse getExistingCreditsByBP(AS400 as400System,
			String bpId) throws Exception {
		return new ExistingCreditsComponent().getExistingCreditsByBP(as400System, bpId, Boolean.FALSE);
	}

	/* (non-Javadoc)
	 * @see mx.com.consubanco.icbs.interfaces.pdi.PlataformaDigitalICBSService#getPaymentDetailByAccountId(com.ibm.as400.access.AS400, java.lang.String)
	 */
	public CreditDetailResponse getCreditDetailByAccountId(AS400 as400System,
			String accountId) throws Exception {
		return new CreditDetailComponent().getCreditDetailByAccount(as400System, accountId, Boolean.FALSE); 
	}

}
