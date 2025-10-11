/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.price;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400Exception;






/**
 * @author Mfinis
 *
 */
public interface CheckPrice {
	public mx.com.consupago_bancofacil.icbs.interfaces.price.bo.PriceResponseBO checkPrice(com.ibm.as400.access.AS400 system,mx.com.consupago_bancofacil.icbs.interfaces.price.bo.PriceRequestBO priceRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException, ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException;

}
