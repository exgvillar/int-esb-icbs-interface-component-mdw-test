/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.debitcard.impl;

import java.net.MalformedURLException;
import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;

import mx.com.consubanco.icbs.interfaces.debitcard.RelationshipAccountPlastic;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.RelationshipAccountPlasticRequestBO;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.RelationshipAccountPlasticResponseBO;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

/**
 * @author Mfinis
 *
 */
public class RelationshipAccountPlasticImpl implements RelationshipAccountPlastic{

	public RelationshipAccountPlasticResponseBO relationshipAccountPlastic(AS400 system,
			RelationshipAccountPlasticRequestBO relationshipAccountPlasticRequestBO)
			throws MalformedURLException, ICBSInterfaceException, AS400Exception, AS400ICBSInterfaceException {
		mx.com.consubanco.icbs.interfaces.debitcard.connection.ConnectionAS400RelationshipAccountPlastic connectionAS400UpdateDebitAccount = new mx.com.consubanco.icbs.interfaces.debitcard.connection.ConnectionAS400RelationshipAccountPlastic();
		mx.com.consubanco.icbs.interfaces.debitcard.bo.RelationshipAccountPlasticResponseBO relationshipAccountPlasticResponseBO = connectionAS400UpdateDebitAccount.relationshipAccountPlastic(system, relationshipAccountPlasticRequestBO);
		return relationshipAccountPlasticResponseBO;
	}

}
