/**
 * Clase que la consulta del Cotizador
 */
package mx.com.consupago_bancofacil.icbs.interfaces.confirmquotation.impl;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400Exception;


/**
 * 
 * @author Mfinis
 *
 */
public class QuotationConfirmation implements
		mx.com.consupago_bancofacil.icbs.interfaces.confirmquotation.QuotationConfirmation {

	/**
	 * 
	 */
	public QuotationConfirmation() {
		super();
	}
	
	
	/**
	 * 
	 * @param system
	 * @param creditResponseBO
	 * @return
	 */
	public mx.com.consupago_bancofacil.icbs.interfaces.confirmquotation.bo.QuotationConfirmationResBO getQuotationConfirmation(com.ibm.as400.access.AS400 system,
			mx.com.consupago_bancofacil.icbs.interfaces.confirmquotation.bo.QuotationConfirmationReqBO quotationConfirmationReqBO)throws java.rmi.RemoteException,java.net.MalformedURLException,ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException{	
		//return mx.com.consupago_bancofacil.icbs.interfaces.quotation.connection.ConnectionAS400.getInstance().quotation(system,quotationRequestBO);
		mx.com.consupago_bancofacil.icbs.interfaces.confirmquotation.connection.ConnectionAS400 connectionAS400 = new mx.com.consupago_bancofacil.icbs.interfaces.confirmquotation.connection.ConnectionAS400();
		return connectionAS400.quotationConfirmation(system, quotationConfirmationReqBO);
	}

}
