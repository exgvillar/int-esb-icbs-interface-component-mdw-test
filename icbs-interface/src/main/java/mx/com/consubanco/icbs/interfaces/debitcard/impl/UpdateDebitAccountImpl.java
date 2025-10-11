/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.debitcard.impl;

import java.net.MalformedURLException;
import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;
import mx.com.consubanco.icbs.interfaces.debitcard.UpdateDebitAccount;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.UpdateDebitAccountRequestBO;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.UpdateDebitAccountResponseBO;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

/**
 * @author Mfinis
 *
 */
public class UpdateDebitAccountImpl implements UpdateDebitAccount{

	public UpdateDebitAccountResponseBO updateDebitAccount(AS400 system,
			UpdateDebitAccountRequestBO updateDebitAccountRequestBO)
			throws MalformedURLException, ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException {
		mx.com.consubanco.icbs.interfaces.debitcard.connection.ConnectionAS400UpdateDebitAccount connectionAS400UpdateDebitAccount = new mx.com.consubanco.icbs.interfaces.debitcard.connection.ConnectionAS400UpdateDebitAccount();
		mx.com.consubanco.icbs.interfaces.debitcard.bo.UpdateDebitAccountResponseBO updateDebitAccountResponseBO = connectionAS400UpdateDebitAccount.updateDebitAccount(system, updateDebitAccountRequestBO);
		return updateDebitAccountResponseBO;
	}

}
