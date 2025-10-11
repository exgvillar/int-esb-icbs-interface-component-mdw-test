/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.confirmquotation;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400Exception;






/**
 * @author Mfinis
 *
 */
public interface QuotationConfirmation {
	public mx.com.consupago_bancofacil.icbs.interfaces.confirmquotation.bo.QuotationConfirmationResBO getQuotationConfirmation(com.ibm.as400.access.AS400 system,mx.com.consupago_bancofacil.icbs.interfaces.confirmquotation.bo.QuotationConfirmationReqBO QuotationConfirmationReqBO) throws java.rmi.RemoteException,java.net.MalformedURLException, ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException;

}
