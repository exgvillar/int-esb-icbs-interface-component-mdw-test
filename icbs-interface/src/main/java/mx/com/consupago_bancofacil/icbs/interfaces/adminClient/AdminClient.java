/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.adminClient;

/**
 * @author Mfinis
 *
 */
public interface AdminClient {
	
	public mx.com.consupago_bancofacil.icbs.interfaces.adminClient.bo.AdminClientResponseBO adminClient(com.ibm.as400.access.AS400 system,mx.com.consupago_bancofacil.icbs.interfaces.adminClient.bo.AdminClientRequestBO adminClientRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException;

}
