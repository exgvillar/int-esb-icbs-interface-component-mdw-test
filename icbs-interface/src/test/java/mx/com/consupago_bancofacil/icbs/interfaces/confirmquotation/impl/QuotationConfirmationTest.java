/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.confirmquotation.impl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import mx.com.consupago_bancofacil.icbs.interfaces.confirmquotation.bo.QuotationConfirmationReqBO;
import mx.com.consupago_bancofacil.icbs.interfaces.confirmquotation.bo.QuotationConfirmationResBO;
import mx.com.consupago_bancofacil.icbs.interfaces.quotation.bo.ComissionInfoBO;
import mx.com.consupago_bancofacil.icbs.interfaces.quotation.bo.MultiRateInfoBO;
import mx.com.consupago_bancofacil.icbs.interfaces.quotation.bo.QuotationRequestBO;
import mx.com.consupago_bancofacil.icbs.interfaces.quotation.bo.QuotationResponseBO;
import mx.com.consupago_bancofacil.icbs.interfaces.quotation.bo.ReqQuotationBO;
import mx.com.consupago_bancofacil.icbs.interfaces.quotation.bo.RespQuotationBO;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.utils.FormatUtils;
import mx.com.consupago_bancofacil.interfaces.utils.WrapperUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;

/**
 * @author Mfinis
 * 
 */
public class QuotationConfirmationTest {

	private static List<String> encabezado = Arrays.asList(new String[]{"CreditNumber", "NumberPayments","PeriodPayments","FrecuencyPayments","PaymentsAmount","CAT"});
	private static int espacios = 40;
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
	 * Exito en Quotation con 4000 registros
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	@Test
	public void testQuotationConfirmation_TestCase1() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 1**************************************************");
		QuotationConfirmation test = new QuotationConfirmation();	
		
		QuotationConfirmationReqBO quotationConfirmationReqBO = new QuotationConfirmationReqBO();
		
		quotationConfirmationReqBO.setApplicationId("1");
		quotationConfirmationReqBO.setRequestId("PAC");
		quotationConfirmationReqBO.setProductCRM(12);
		quotationConfirmationReqBO.setConfirmation(true);
		
		
		QuotationConfirmationResBO quotationConfirmationResBO;
		try {
		quotationConfirmationResBO = test.getQuotationConfirmation(new AS400("172.16.50.241", "S620100001",
			"santafe07"), quotationConfirmationReqBO);
			
			System.out.println("status::"+quotationConfirmationResBO.getStatus());
			System.out.println("code::"+quotationConfirmationResBO.getCode());
			System.out.println("response::"+quotationConfirmationResBO.getResponse());
		
		
			assertNotNull(quotationConfirmationResBO);
		} catch (AS400Exception e) {			
			e.printStackTrace();
		} catch (ICBSInterfaceException e) {		
			e.printStackTrace();
		} catch (AS400ICBSInterfaceException e) {		
			e.printStackTrace();
		}
	}
	
}
