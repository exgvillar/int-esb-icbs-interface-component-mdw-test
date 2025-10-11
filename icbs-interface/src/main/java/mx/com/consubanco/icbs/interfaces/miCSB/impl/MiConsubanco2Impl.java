/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.miCSB.impl;

import mx.com.consubanco.icbs.interfaces.miCSB.IMiConsubanco2;
import mx.com.consubanco.icbs.interfaces.miCSB.component.CreditsSubjectToRestructuringComponent;
import mx.com.consubanco.icbs.interfaces.miCSB.model.GetActiveCreditsResponse;

import com.ibm.as400.access.AS400;

/**
 * @author juribe
 *
 */
public class MiConsubanco2Impl implements IMiConsubanco2 {

	public GetActiveCreditsResponse getActiveCreditsSubjectToRestructuring(AS400 as400System, String customerBP) throws Exception {
		
		return new CreditsSubjectToRestructuringComponent().getActiveCreditsSubjectToRestructuring(as400System, customerBP, Boolean.FALSE);
	}

}
