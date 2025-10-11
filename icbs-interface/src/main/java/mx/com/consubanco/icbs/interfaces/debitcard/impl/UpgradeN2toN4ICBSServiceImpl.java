package mx.com.consubanco.icbs.interfaces.debitcard.impl;

import mx.com.consubanco.icbs.interfaces.debitcard.IUpgradeN2toN4ICBSService;
import mx.com.consubanco.icbs.interfaces.debitcard.n2ton4.bo.GetUDISValueResponse;
import mx.com.consubanco.icbs.interfaces.debitcard.n2ton4.bo.UpgradeN2toN4Response;
import mx.com.consubanco.icbs.interfaces.debitcard.n2ton4.connection.GetUDISValueComponent;
import mx.com.consubanco.icbs.interfaces.debitcard.n2ton4.connection.UpgradeN2toN4Component;

import com.ibm.as400.access.AS400;

public class UpgradeN2toN4ICBSServiceImpl implements IUpgradeN2toN4ICBSService {

	public UpgradeN2toN4Response changeAccountLevel(AS400 as400System, String accountId, String productId) throws Exception {
		return new UpgradeN2toN4Component().execute(as400System, accountId, productId, Boolean.FALSE);
	}

	public GetUDISValueResponse getUDISValue(AS400 as400System, String productNumber) throws Exception {
		return new GetUDISValueComponent().execute(as400System, productNumber, Boolean.FALSE);
	}

}
