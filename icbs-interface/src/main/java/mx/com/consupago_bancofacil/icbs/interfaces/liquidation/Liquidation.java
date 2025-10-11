/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.liquidation;
import com.ibm.as400.access.AS400Exception;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

/**
 * @author Mfinis
 *
 */
public interface Liquidation {	
	public mx.com.consupago_bancofacil.icbs.interfaces.liquidation.bo.LiquidationResponseBO getLiquidation(com.ibm.as400.access.AS400 system,mx.com.consupago_bancofacil.icbs.interfaces.liquidation.bo.LiquidationRequestBO liquidationRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException,ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException,Exception;
}
