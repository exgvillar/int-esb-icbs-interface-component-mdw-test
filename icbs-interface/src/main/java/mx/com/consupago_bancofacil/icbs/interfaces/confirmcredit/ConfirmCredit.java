/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.confirmcredit;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

/**
 * @author Mfinis
 *
 */
public interface ConfirmCredit {

	public mx.com.consupago_bancofacil.icbs.interfaces.confirmcredit.bo.ConfirmCreditResponseBO confirmCredit(com.ibm.as400.access.AS400 system,mx.com.consupago_bancofacil.icbs.interfaces.confirmcredit.bo.ConfirmCreditRequestBO confirmCreditRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException, ICBSInterfaceException, AS400ICBSInterfaceException, Exception;
}
