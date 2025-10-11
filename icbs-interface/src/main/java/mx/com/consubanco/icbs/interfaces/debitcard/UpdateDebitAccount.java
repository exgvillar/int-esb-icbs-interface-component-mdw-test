/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.debitcard;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;
import com.ibm.as400.access.AS400Exception;

/**
 * @author Mfinis
 *
 */
public interface UpdateDebitAccount {
	
	public mx.com.consubanco.icbs.interfaces.debitcard.bo.UpdateDebitAccountResponseBO updateDebitAccount(com.ibm.as400.access.AS400 system,mx.com.consubanco.icbs.interfaces.debitcard.bo.UpdateDebitAccountRequestBO updateDebitAccountRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException, ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException;

}
