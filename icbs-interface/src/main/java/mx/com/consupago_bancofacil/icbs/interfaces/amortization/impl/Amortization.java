/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.amortization.impl;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;

/**
 * @author Mfinis
 *
 */
public class Amortization implements
		mx.com.consupago_bancofacil.icbs.interfaces.amortization.Amortization {

	/**
	 * 
	 */
	public Amortization() {
		super();
	}

	/**
	 * 
	 */
	public mx.com.consupago_bancofacil.icbs.interfaces.amortization.bo.AmortizationResponseBO getAmortization(AS400 system,
			mx.com.consupago_bancofacil.icbs.interfaces.amortization.bo.AmortizationRequestBO amortizationRequestBO)
			throws java.rmi.RemoteException,java.net.MalformedURLException, ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException {
		//return mx.com.consupago_bancofacil.icbs.interfaces.amortization.connection.ConnectionAS400.getInstance().amortizationTable(system,amortizationRequestBO);
		 mx.com.consupago_bancofacil.icbs.interfaces.amortization.connection.ConnectionAS400 connectionAS400 = new  mx.com.consupago_bancofacil.icbs.interfaces.amortization.connection.ConnectionAS400();
		 return connectionAS400.amortizationTable(system,amortizationRequestBO);
	}

}
