/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.createcredit;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

/**
 * @author Mfinis
 *
 */
public interface CreateCredit {

	public mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.CreateCreditResponseBO createCredit(com.ibm.as400.access.AS400 system,mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.CreateCreditRequestBO createCreditRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException, ICBSInterfaceException, AS400ICBSInterfaceException, Exception;
}
