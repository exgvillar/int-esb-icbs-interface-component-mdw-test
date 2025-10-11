/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.statement.impl;

import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400Exception;




/**
 * @author Mfinis
 *
 */
public class Statement implements
		mx.com.consupago_bancofacil.icbs.interfaces.statement.Statement {

	/**
	 * 
	 */
	public Statement() {
		super();
	}

	
	public mx.com.consupago_bancofacil.icbs.interfaces.statement.bo.StatementResponseBO getStatement(com.ibm.as400.access.AS400 system,
			mx.com.consupago_bancofacil.icbs.interfaces.statement.bo.StatementRequestBO statementRequestBO) throws java.rmi.RemoteException,java.net.MalformedURLException, ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException, Exception {
		
		//return mx.com.consupago_bancofacil.icbs.interfaces.statement.connection.ConnectionAS400.getInstance().statement(system,statementRequestBO);
		mx.com.consupago_bancofacil.icbs.interfaces.statement.connection.ConnectionAS400 connectionAS400 = new mx.com.consupago_bancofacil.icbs.interfaces.statement.connection.ConnectionAS400();
		return connectionAS400.statement(system, statementRequestBO);
	}	

}
