/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.sic;

import com.ibm.as400.access.AS400;

import mx.com.consubanco.icbs.interfaces.sic.impl.SICICSBSServiceImpl;
import mx.com.consubanco.icbs.interfaces.sic.vhi.bo.GetPostingMonitorRequest;
import mx.com.consubanco.icbs.interfaces.sic.vhi.bo.GetPostingMonitorResponse;
import junit.framework.TestCase;

/**
 * @author jrauluribes
 *
 */
public class GetPostingMonitor_TC extends TestCase {

	private SICICSBSService sicicsbsService;
	
	public void testDeberiaEjecutar() throws Exception {
		sicicsbsService = new SICICSBSServiceImpl();
		
		AS400 as400System = new AS400("172.16.50.245", "S620100003", "santafe07");
		
		GetPostingMonitorRequest request = new GetPostingMonitorRequest();
		//419
		request.setPaymentSourceIdFilter("213");//210
		request.setPeriodFilter("");
		request.setStatusFilter("");
		request.setIcbsLoteFilter("0");
		
		GetPostingMonitorResponse postingMonitor = sicicsbsService.getPostingMonitor(as400System , request );
		
		System.out.println(postingMonitor);
		
	}
}
