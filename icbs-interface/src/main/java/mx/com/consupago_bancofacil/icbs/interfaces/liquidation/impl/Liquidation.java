/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.liquidation.impl;



import mx.com.consupago_bancofacil.icbs.interfaces.liquidation.bo.LiquidationRequestBO;
import mx.com.consupago_bancofacil.icbs.interfaces.liquidation.bo.LiquidationResponseBO;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;

/**
 * @author jmartinezru
 *
 */
public class Liquidation implements
		mx.com.consupago_bancofacil.icbs.interfaces.liquidation.Liquidation {

	/* (non-Javadoc)
	 * @see mx.com.consupago_bancofacil.icbs.interfaces.liquidation.Liquidation#getLiquidation(com.ibm.as400.access.AS400, mx.com.consupago_bancofacil.icbs.interfaces.liquidation.bo.LiquidationRequestBO)
	 */
	public LiquidationResponseBO getLiquidation(AS400 system,
			LiquidationRequestBO liquidationRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException,ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException,Exception{
		mx.com.consupago_bancofacil.icbs.interfaces.liquidation.connection.ConnectionAS400 connectionAS400 = new mx.com.consupago_bancofacil.icbs.interfaces.liquidation.connection.ConnectionAS400();
		return connectionAS400.getLiquidation(system, liquidationRequestBO);
	}

}
