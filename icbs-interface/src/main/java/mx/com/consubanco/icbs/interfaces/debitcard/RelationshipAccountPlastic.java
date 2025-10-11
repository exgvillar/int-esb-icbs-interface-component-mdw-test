/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.debitcard;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;
import com.ibm.as400.access.AS400Exception;

/**
 * @author Mfinis
 *
 */
public interface RelationshipAccountPlastic {
	
	public mx.com.consubanco.icbs.interfaces.debitcard.bo.RelationshipAccountPlasticResponseBO relationshipAccountPlastic(com.ibm.as400.access.AS400 system,mx.com.consubanco.icbs.interfaces.debitcard.bo.RelationshipAccountPlasticRequestBO relationshipAccountPlasticRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException, ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException;

}
