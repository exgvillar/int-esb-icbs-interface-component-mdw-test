/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.sic;

import mx.com.consubanco.icbs.interfaces.sic.vhi.bo.GetPostingMonitorRequest;
import mx.com.consubanco.icbs.interfaces.sic.vhi.bo.GetPostingMonitorResponse;

import com.ibm.as400.access.AS400;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public interface SICICSBSService {

	/**
	 * 
	 * @param system
	 * @param request
	 * @param debug
	 * @return
	 * @throws Exception
	 */
	public GetPostingMonitorResponse getPostingMonitor(AS400 as400System, GetPostingMonitorRequest request) throws Exception;
}
