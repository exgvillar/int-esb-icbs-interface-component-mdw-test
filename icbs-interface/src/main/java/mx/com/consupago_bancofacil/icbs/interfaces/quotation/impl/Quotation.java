/**
 * Clase que realiza un consulta de precios
 */
package mx.com.consupago_bancofacil.icbs.interfaces.quotation.impl;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400Exception;


/**
 * 
 * @author Mfinis
 *
 */
public class Quotation implements
		mx.com.consupago_bancofacil.icbs.interfaces.quotation.Quotation {

	/**
	 * 
	 */
	public Quotation() {
		super();
	}
	
	
	/**
	 * 
	 * @param system
	 * @param creditResponseBO
	 * @return
	 */
	public mx.com.consupago_bancofacil.icbs.interfaces.quotation.bo.QuotationResponseBO getQuotation(com.ibm.as400.access.AS400 system,
			mx.com.consupago_bancofacil.icbs.interfaces.quotation.bo.QuotationRequestBO quotationRequestBO)throws java.rmi.RemoteException,java.net.MalformedURLException,ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException{	
		//return mx.com.consupago_bancofacil.icbs.interfaces.quotation.connection.ConnectionAS400.getInstance().quotation(system,quotationRequestBO);
		mx.com.consupago_bancofacil.icbs.interfaces.quotation.connection.ConnectionAS400 connectionAS400 = new mx.com.consupago_bancofacil.icbs.interfaces.quotation.connection.ConnectionAS400();
		return connectionAS400.quotation(system, quotationRequestBO);
	}

}
