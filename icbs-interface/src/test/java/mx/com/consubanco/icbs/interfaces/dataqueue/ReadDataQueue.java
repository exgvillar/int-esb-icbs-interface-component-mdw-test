/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.dataqueue;


import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mx.com.consubanco.icbs.interfaces.ConstantesICBS;
import mx.com.consubanco.icbs.interfaces.debitcard.CreateDebitAccount;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.AddressBO;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.CreateDebitAccountRequestBO;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.CreateDebitAccountResponseBO;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.InterviningBO;
import mx.com.consubanco.icbs.interfaces.debitcard.bo.ProductBO;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;
import com.ibm.as400.access.DataQueue;
import com.ibm.as400.access.DataQueueEntry;

/**
 * @author Mfinis
 *
 */
public class ReadDataQueue {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link mx.com.consupago_bancofacil.icbs.interfaces.adminClient.impl.AdminClient#AdminClient()}.
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	@Test
	public void testCreateDebitAccount() throws RemoteException, MalformedURLException {
		
		try {
			AS400 as400Captacion = new AS400("172.16.40.241",
					"S620100009",
					"Santafe020");
			
			DataQueue speiDQ = new DataQueue(as400Captacion,"/QSYS.LIB/CAPTAP.LIB/SPEIOUTDQ.DTAQ");
			
			DataQueueEntry speiDataQueueEntry = speiDQ.peek( );
			
		    System.out.println( speiDataQueueEntry.toString() );
			
		} catch (AS400Exception e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}	

}
