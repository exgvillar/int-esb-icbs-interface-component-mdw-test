/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.sic.impl;

import mx.com.consubanco.icbs.interfaces.sic.SICICSBSService;
import mx.com.consubanco.icbs.interfaces.sic.vhi.bo.GetPostingMonitorRequest;
import mx.com.consubanco.icbs.interfaces.sic.vhi.bo.GetPostingMonitorResponse;
import mx.com.consubanco.icbs.interfaces.sic.vhi.connection.GetPostingMonitorComponent;

import com.ibm.as400.access.AS400;

/**
 * @author <a href="mailto:juribe@consubanco.com">juribe</a>
 * 
 */
public class SICICSBSServiceImpl implements SICICSBSService {

	/*
	 * (non-Javadoc)
	 * @see mx.com.consubanco.icbs.interfaces.sic.SICICSBSService#getPostingMonitor(com.ibm.as400.access.AS400, mx.com.consubanco.icbs.interfaces.sic.vhi.bo.GetPostingMonitorRequest, boolean)
	 */
	public GetPostingMonitorResponse getPostingMonitor(AS400 as400System, GetPostingMonitorRequest request) throws Exception {
		return new GetPostingMonitorComponent().getPostingMonitor(as400System, request, Boolean.FALSE);
	}

}
