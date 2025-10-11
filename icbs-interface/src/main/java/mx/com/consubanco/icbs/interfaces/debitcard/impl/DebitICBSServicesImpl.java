/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.debitcard.impl;

import mx.com.consubanco.icbs.interfaces.debitcard.IDebitICBSServices;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.GatNominalResponse;
import mx.com.consubanco.icbs.interfaces.debitcard.connection.GatNominalComponent;

import com.ibm.as400.access.AS400;

/**
 * @author juribe
 *
 */
public class DebitICBSServicesImpl implements IDebitICBSServices {

	/*
	 * (non-Javadoc)
	 * 
	 * @see mx.com.consubanco.icbs.interfaces.debitcard.IDebitICBSServices#
	 * gatNominalByDebitAccount(java.lang.String)
	 */
	public GatNominalResponse gatNominalByDebitAccount(AS400 as400System,
			String debitAccount) throws Exception {
		return new GatNominalComponent().execute(as400System, debitAccount, Boolean.FALSE);
	}

}
