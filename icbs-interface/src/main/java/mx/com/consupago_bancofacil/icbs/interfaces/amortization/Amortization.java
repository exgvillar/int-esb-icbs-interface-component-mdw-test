/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.amortization;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400Exception;

/**
 * @author Mfinis
 *
 */
public interface Amortization {
	public mx.com.consupago_bancofacil.icbs.interfaces.amortization.bo.AmortizationResponseBO getAmortization(com.ibm.as400.access.AS400 system,mx.com.consupago_bancofacil.icbs.interfaces.amortization.bo.AmortizationRequestBO amortizationRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException, ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException;
}
