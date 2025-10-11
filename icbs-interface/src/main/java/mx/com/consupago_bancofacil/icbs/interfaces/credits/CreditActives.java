/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.credits;

import mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditResponseBO;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;






/**
 * @author Mfinis
 *
 */
public interface CreditActives {
	public mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditResponseBO getCreditsActives(com.ibm.as400.access.AS400 system,mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditRequestBO creditRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException, ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException;

	/**
	 * Origination Process method: Reingeniería pantalla de originación 
	 * 
	 * @param as400System
	 * @param bpId
	 * @return
	 */
	CreditResponseBO getCreditsByBP(AS400 as400System,String bpId);

}

