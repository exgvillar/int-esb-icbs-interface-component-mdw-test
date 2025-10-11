/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.calculator;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400Exception;






/**
 * @author Mfinis
 *
 */
public interface SubstitutionCalculator {
	public mx.com.consupago_bancofacil.icbs.interfaces.calculator.bo.CalculatorResponseBO getCalculator(com.ibm.as400.access.AS400 system,mx.com.consupago_bancofacil.icbs.interfaces.calculator.bo.CalculatorRequestBO calculatorRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException,ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException;

}
