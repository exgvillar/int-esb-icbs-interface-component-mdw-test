package mx.com.consupago_bancofacil.icbs.interfaces.financial.impl;


import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import mx.com.consupago_bancofacil.icbs.interfaces.financial.bo.FinancialRequestBO;
import mx.com.consupago_bancofacil.icbs.interfaces.financial.bo.FinancialResBO;
import mx.com.consupago_bancofacil.icbs.interfaces.financial.bo.FinancialResponseBO;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.utils.FormatUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;

public class FinancialProductsTest {
	
	private static List<String> encabezado = Arrays.asList(new String[]{"Number", "Description"});
	private static int espacios = 40;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * Test method for
	 * {@link mx.com.consupago_bancofacil.icbs.interfaces.financial.impl.FinancialProducts#getFinancialProducts(com.ibm.as400.access.AS400, mx.com.consupago_bancofacil.icbs.interfaces.financial.bo.FinancialRequestBO)}
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	@Test
	public void testFinancial_TestCase1() {
		System.out.println("Test Case 1*************************************************");
		FinancialProducts test = new FinancialProducts();
		FinancialRequestBO financialRequestBO = new FinancialRequestBO();
		financialRequestBO.setApplicationId("ap001");
		financialRequestBO.setRequestId("001");
		
		
		
		FinancialResponseBO financialResponseBO;
		try {
			financialResponseBO = test.getFinancialProducts(new AS400("172.16.50.241", "S620100003",
			"santafe07"), financialRequestBO);
		
		
		System.out.println("STATUS::" + financialResponseBO.getStatus());
		System.out.println("CODE::" + financialResponseBO.getCode());
		System.out.println("RESPONSE::" + financialResponseBO.getResponse());
		
		FormatUtils.formatoEncabezado(encabezado);
		for (FinancialResBO financialResBO:financialResponseBO.getFinancialResBO()){
			System.out.print("|");
			System.out.print(FormatUtils.llenarCaracter(financialResBO.getNumProduct()+"",espacios," ")+"|");
			System.out.println(FormatUtils.llenarCaracter(financialResBO.getDescProduct()+"",espacios," ")+"|");
		}
		assertTrue(financialResponseBO!=null);
		} catch (AS400Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AS400ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
