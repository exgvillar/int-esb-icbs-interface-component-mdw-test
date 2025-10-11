/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.debitcard;

import mx.com.consubanco.icbs.interfaces.debitcard.bo.GatNominalResponse;

import com.ibm.as400.access.AS400;

/**
 * @author juribe
 *
 */
public interface IDebitICBSServices {

	GatNominalResponse gatNominalByDebitAccount(AS400 as400System,String debitAccount) throws Exception;

}
