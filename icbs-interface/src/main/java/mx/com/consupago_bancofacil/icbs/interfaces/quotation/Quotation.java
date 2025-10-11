/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.quotation;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400Exception;






/**
 * @author Mfinis
 *
 */
public interface Quotation {
	public mx.com.consupago_bancofacil.icbs.interfaces.quotation.bo.QuotationResponseBO getQuotation(com.ibm.as400.access.AS400 system,mx.com.consupago_bancofacil.icbs.interfaces.quotation.bo.QuotationRequestBO QuotationRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException, ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException;

}
