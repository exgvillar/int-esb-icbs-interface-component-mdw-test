/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.statement;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400Exception;

/**
 * @author Mfinis
 *
 */
public interface Statement {
	
	public mx.com.consupago_bancofacil.icbs.interfaces.statement.bo.StatementResponseBO getStatement(com.ibm.as400.access.AS400 system,mx.com.consupago_bancofacil.icbs.interfaces.statement.bo.StatementRequestBO statementRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException, ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException, Exception;

	

}
