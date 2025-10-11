/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.financial.impl;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400Exception;



/**
 * @author Isaac Tenorio
 *
 */
public class FinancialProducts implements
		mx.com.consupago_bancofacil.icbs.interfaces.financial.FinancialProducts {

	/**
	 * 
	 */
	public FinancialProducts() {
		super();
	}

	/**
	 * Se encarga de obtener todos los productos financieros existentes
	 * @param system
	 * @param financialResponseBO 
	 */
	public  mx.com.consupago_bancofacil.icbs.interfaces.financial.bo.FinancialResponseBO getFinancialProducts(com.ibm.as400.access.AS400 system,
			mx.com.consupago_bancofacil.icbs.interfaces.financial.bo.FinancialRequestBO financialRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException, ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException
			 {		
		//return mx.com.consupago_bancofacil.icbs.interfaces.financial.connection.ConnectionAS400.getInstance().getfinancialProducts(system,financialRequestBO);
		 mx.com.consupago_bancofacil.icbs.interfaces.financial.connection.ConnectionAS400 financialProduct= new mx.com.consupago_bancofacil.icbs.interfaces.financial.connection.ConnectionAS400();
		 return financialProduct.getfinancialProducts(system,financialRequestBO);
	}

}
