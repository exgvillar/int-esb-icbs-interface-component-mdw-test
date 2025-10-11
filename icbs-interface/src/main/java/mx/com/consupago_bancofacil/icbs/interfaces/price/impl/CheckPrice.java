/**
 * Clase que realiza un consulta de precios
 */
package mx.com.consupago_bancofacil.icbs.interfaces.price.impl;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400Exception;


/**
 * 
 * @author Mfinis
 *
 */
public class CheckPrice implements
		mx.com.consupago_bancofacil.icbs.interfaces.price.CheckPrice {

	/**
	 * 
	 */
	public CheckPrice() {
		super();
	}
	
	
	/**
	 * 
	 * @param system
	 * @param creditResponseBO
	 * @return
	 */
	public mx.com.consupago_bancofacil.icbs.interfaces.price.bo.PriceResponseBO checkPrice(com.ibm.as400.access.AS400 system,
			mx.com.consupago_bancofacil.icbs.interfaces.price.bo.PriceRequestBO priceRequestBO)throws java.rmi.RemoteException,java.net.MalformedURLException,ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException{			
		//return mx.com.consupago_bancofacil.icbs.interfaces.price.connection.ConnectionAS400.getInstance().getPrice(system,priceRequestBO);
		mx.com.consupago_bancofacil.icbs.interfaces.price.connection.ConnectionAS400 connectionAS400 = new mx.com.consupago_bancofacil.icbs.interfaces.price.connection.ConnectionAS400();
		return connectionAS400.getPrice(system,priceRequestBO);
	}

}
