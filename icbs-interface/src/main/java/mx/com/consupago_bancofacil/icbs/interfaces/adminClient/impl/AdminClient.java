/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.adminClient.impl;

/**
 * @author Mfinis
 *
 */
public class AdminClient implements
		mx.com.consupago_bancofacil.icbs.interfaces.adminClient.AdminClient {

	/**
	 * 
	 */
	public AdminClient() {
		super();
	}

	/**
	 * 
	 */
	public mx.com.consupago_bancofacil.icbs.interfaces.adminClient.bo.AdminClientResponseBO adminClient(com.ibm.as400.access.AS400 system,
			mx.com.consupago_bancofacil.icbs.interfaces.adminClient.bo.AdminClientRequestBO adminClientRequestBO) throws java.rmi.RemoteException,
			java.net.MalformedURLException {
		//return mx.com.consupago_bancofacil.icbs.interfaces.adminClient.connection.ConnectionAS400.getInstance().adminClient(system,adminClientRequestBO);
		mx.com.consupago_bancofacil.icbs.interfaces.adminClient.connection.ConnectionAS400 connectionAS400 = new mx.com.consupago_bancofacil.icbs.interfaces.adminClient.connection.ConnectionAS400();
		return connectionAS400.adminClient(system,adminClientRequestBO);
	}

}
