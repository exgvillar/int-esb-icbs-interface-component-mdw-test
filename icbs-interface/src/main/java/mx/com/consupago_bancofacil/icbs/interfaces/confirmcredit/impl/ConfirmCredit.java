/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.confirmcredit.impl;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;


/**
 * @author Mfinis
 *
 */
public class ConfirmCredit implements
		mx.com.consupago_bancofacil.icbs.interfaces.confirmcredit.ConfirmCredit {

	/* (non-Javadoc)
	 * @see mx.com.consupago_bancofacil.icbs.interfaces.adminCredit.AdminCredit#adminCredit(com.ibm.as400.access.AS400, mx.com.consupago_bancofacil.icbs.interfaces.adminCredit.bo.AdminCreditRequestBO)
	 */
	public mx.com.consupago_bancofacil.icbs.interfaces.confirmcredit.bo.ConfirmCreditResponseBO confirmCredit(com.ibm.as400.access.AS400 system,
			mx.com.consupago_bancofacil.icbs.interfaces.confirmcredit.bo.ConfirmCreditRequestBO confirmCreditRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException, ICBSInterfaceException, ICBSInterfaceException, AS400ICBSInterfaceException, Exception {		
		//return mx.com.consupago_bancofacil.icbs.interfaces.adminCredit.connection.ConnectionAS400.getInstance().adminCredit(system,adminCreditRequestBO);
		mx.com.consupago_bancofacil.icbs.interfaces.confirmcredit.connection.ConnectionAS400 connectionAS400 = new mx.com.consupago_bancofacil.icbs.interfaces.confirmcredit.connection.ConnectionAS400();
		return connectionAS400.confirmCredit(system, confirmCreditRequestBO);
	}

}
