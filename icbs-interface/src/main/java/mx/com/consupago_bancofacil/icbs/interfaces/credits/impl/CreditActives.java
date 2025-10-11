/**
 * Clase que obtiene los creditos activos hacia AS400
 */
package mx.com.consupago_bancofacil.icbs.interfaces.credits.impl;

import mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditResponseBO;
import mx.com.consupago_bancofacil.icbs.interfaces.credits.connection.GetCreditsByBPComponent;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;


/**
 * 
 * @author Mfinis
 *
 */
public class CreditActives implements
		mx.com.consupago_bancofacil.icbs.interfaces.credits.CreditActives {

	/**
	 * 
	 */
	public CreditActives() {
		super();
	}
	
	
	/**
	 * 
	 * @param system
	 * @param creditResponseBO
	 * @return
	 */
	public mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditResponseBO getCreditsActives(com.ibm.as400.access.AS400 system,
			mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditRequestBO creditRequestBO)throws java.rmi.RemoteException,java.net.MalformedURLException,ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException{			
		//return mx.com.consupago_bancofacil.icbs.interfaces.credits.connection.ConnectionAS400.getInstance().getCreditsActives(system,creditRequestBO);	
		mx.com.consupago_bancofacil.icbs.interfaces.credits.connection.ConnectionAS400 connectionAS400 = new mx.com.consupago_bancofacil.icbs.interfaces.credits.connection.ConnectionAS400();
		return connectionAS400.getCreditsActives(system,creditRequestBO);
	}


	public CreditResponseBO getCreditsByBP(AS400 as400System, String bpId) {
		GetCreditsByBPComponent component = new GetCreditsByBPComponent();
		
		return component.getCreditsByBP(as400System, bpId, Boolean.FALSE);
	}

}
