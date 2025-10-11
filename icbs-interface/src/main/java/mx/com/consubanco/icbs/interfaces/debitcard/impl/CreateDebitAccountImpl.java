/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.debitcard.impl;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;

import mx.com.consubanco.icbs.interfaces.debitcard.CreateDebitAccount;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.CreateDebitAccountRequestBO;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.CreateDebitAccountResponseBO;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

/**
 * @author Mfinis
 *
 */
public class CreateDebitAccountImpl implements CreateDebitAccount{

	public CreateDebitAccountResponseBO createDebitAccount(AS400 system,
			CreateDebitAccountRequestBO debitAccountRequestBO)
			throws MalformedURLException, ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException {
		mx.com.consubanco.icbs.interfaces.debitcard.connection.ConnectionAS400DebitAccount connectionAS400DebitAccount = new mx.com.consubanco.icbs.interfaces.debitcard.connection.ConnectionAS400DebitAccount();
		mx.com.consubanco.icbs.interfaces.debitcard.bo.CreateDebitAccountResponseBO debitAccountResponseBO = connectionAS400DebitAccount.createDebitAccount(system, debitAccountRequestBO);
		return debitAccountResponseBO;
	}

}
