/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.miCSB;

import mx.com.consubanco.icbs.interfaces.miCSB.model.GetActiveCreditsResponse;

import com.ibm.as400.access.AS400;

/**
 * @author juribe
 * 
 */
public interface IMiConsubanco2 {

	/**
	 * Método que permite obtener la lista de créditos activos y sujetos a
	 * reestructura del customerBP
	 * 
	 * @param as400System
	 * @param customerBP
	 * @return
	 * 
	 * @throws Exception
	 */
	GetActiveCreditsResponse getActiveCreditsSubjectToRestructuring(AS400 as400System, String customerBP) throws Exception;
}
