package mx.com.consubanco.icbs.interfaces.debitcard;

import mx.com.consubanco.icbs.interfaces.debitcard.n2ton4.bo.GetUDISValueResponse;
import mx.com.consubanco.icbs.interfaces.debitcard.n2ton4.bo.UpgradeN2toN4Response;

import com.ibm.as400.access.AS400;

public interface IUpgradeN2toN4ICBSService {
	/**
	 * 
	 * @param accountId
	 * @param type
	 * @param debug
	 * @return
	 */
	UpgradeN2toN4Response changeAccountLevel(AS400 as400System,
			String accountId, String productId) throws Exception;

	GetUDISValueResponse getUDISValue(AS400 as400System, String productNumber)
			throws Exception;
}
