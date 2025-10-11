/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.financial;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400Exception;

/**
 * @author Mfinis
 *
 */
public interface FinancialProducts {
	public mx.com.consupago_bancofacil.icbs.interfaces.financial.bo.FinancialResponseBO getFinancialProducts(com.ibm.as400.access.AS400 system,mx.com.consupago_bancofacil.icbs.interfaces.financial.bo.FinancialRequestBO financialRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException,ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException;

}
