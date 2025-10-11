/**
 * Clase que obtiene los creditos activos hacia AS400
 */
package mx.com.consupago_bancofacil.icbs.interfaces.calculator.impl;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400Exception;




/**
 * 
 * @author Mfinis
 *
 */
public class SubstitutionCalculator implements
		mx.com.consupago_bancofacil.icbs.interfaces.calculator.SubstitutionCalculator {

	/**
	 * 
	 */
	public SubstitutionCalculator() {
		super();
	}
	
	
	/**
	 * 
	 * @param system
	 * @param calculatorResponseBO
	 * @return
	 */
	public mx.com.consupago_bancofacil.icbs.interfaces.calculator.bo.CalculatorResponseBO getCalculator(com.ibm.as400.access.AS400 system,
			mx.com.consupago_bancofacil.icbs.interfaces.calculator.bo.CalculatorRequestBO calculatorRequestBO)throws java.rmi.RemoteException,java.net.MalformedURLException,ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException{			
		 //return mx.com.consupago_bancofacil.icbs.interfaces.calculator.connection.ConnectionAS400.getInstance().calculator(system,calculatorRequestBO);
		mx.com.consupago_bancofacil.icbs.interfaces.calculator.connection.ConnectionAS400 connectionAS400 = new mx.com.consupago_bancofacil.icbs.interfaces.calculator.connection.ConnectionAS400();
		return connectionAS400.calculator(system,calculatorRequestBO);
	}


	

}
