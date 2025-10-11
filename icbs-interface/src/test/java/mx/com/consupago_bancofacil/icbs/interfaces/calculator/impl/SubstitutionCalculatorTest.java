/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.calculator.impl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import mx.com.consupago_bancofacil.icbs.interfaces.calculator.bo.CalculatorRequestBO;
import mx.com.consupago_bancofacil.icbs.interfaces.calculator.bo.CalculatorResponseBO;
import mx.com.consupago_bancofacil.icbs.interfaces.calculator.bo.RespCalculatorBO;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.utils.FormatUtils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;

/**
 * @author Mfinis
 * 
 */
public class SubstitutionCalculatorTest {
	
	private static List<String> encabezado = Arrays.asList(new String[]{"AmountFinanced","FrecuencyPayment","PaymentPeriod","AnnualizedRate","Cat","TotalPayment","TotalPayment"});
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
	 * Prueba de todos lo datos esta calculado correctmente
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testSubstitutionCalculator_TestCase1()  {
		SubstitutionCalculator test = new SubstitutionCalculator();
		CalculatorRequestBO reqCalculatorBO = new CalculatorRequestBO();
		
		reqCalculatorBO.setApplicationId("");
		reqCalculatorBO.setRequestId("");
		reqCalculatorBO.setFinancialProduct(850);
		reqCalculatorBO.setConventionId(8l);
		reqCalculatorBO.setAmountDiscount(320.00);
		reqCalculatorBO.setFrecuencyPayment("MENSUAL");
		reqCalculatorBO.setProductCRM(580);
		
		CalculatorResponseBO calculatorResponseBO;
		
			try {
				calculatorResponseBO = test.getCalculator(new AS400("172.16.50.241", "S620100001",
						"santafe07"), reqCalculatorBO);
			
				
		
		System.out.println("STATUS::" + calculatorResponseBO.getStatus());
		System.out.println("CODE::" + calculatorResponseBO.getCode());
		System.out.println("RESPONSE::" + calculatorResponseBO .getResponse());
		FormatUtils.formatoEncabezado(encabezado);
		for (RespCalculatorBO respuesta:calculatorResponseBO.getRespCalculatorBO()){
			System.out.print("|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getAmountFinanced()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getFrecuencyPayment()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getPaymentPeriod()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getAmountFinanced()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getAnnualizedRate()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getCat()+"",espacios," ")+"|");
			System.out.println(FormatUtils.llenarCaracter(respuesta.getTotalPayment()+"",espacios," ")+"|");
		}
		assertTrue(calculatorResponseBO!=null);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AS400Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ICBSInterfaceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AS400ICBSInterfaceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}*/
	
	
	/**
	 * Prueba con valor de incorrecto de periodo de pagos
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testSubstitutionCalculator_TestCase2()  {
		SubstitutionCalculator test = new SubstitutionCalculator();
		CalculatorRequestBO reqCalculatorBO = new CalculatorRequestBO();
		
		reqCalculatorBO.setApplicationId("");
		reqCalculatorBO.setRequestId("");
		reqCalculatorBO.setFinancialProduct(850);
		reqCalculatorBO.setConventionId(88888888l);
		reqCalculatorBO.setAmountDiscount(0.00);
		reqCalculatorBO.setFrecuencyPayment("MENSUAL");
		reqCalculatorBO.setProductCRM(580);
		
		CalculatorResponseBO calculatorResponseBO;
		try {
			calculatorResponseBO = test.getCalculator(new AS400("172.16.50.241", "S620100001",
					"santafe07"), reqCalculatorBO);
				
		
		System.out.println("STATUS::" + calculatorResponseBO.getStatus());
		System.out.println("CODE::" + calculatorResponseBO.getCode());
		System.out.println("RESPONSE::" + calculatorResponseBO .getResponse());
		FormatUtils.formatoEncabezado(encabezado);
		for (RespCalculatorBO respuesta:calculatorResponseBO.getRespCalculatorBO()){
			System.out.print("|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getAmountFinanced()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getFrecuencyPayment()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getPaymentPeriod()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getAmountFinanced()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getAnnualizedRate()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getCat()+"",espacios," ")+"|");
			System.out.println(FormatUtils.llenarCaracter(respuesta.getTotalPayment()+"",espacios," ")+"|");
		}
		assertNull(calculatorResponseBO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AS400Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AS400ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
	
	
	/**
	 * Prueba con diferente .
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	/*@Test
	public void testSubstitutionCalculator_TestCase3() throws RemoteException,
			MalformedURLException {
		SubstitutionCalculator test = new SubstitutionCalculator();
		CalculatorRequestBO reqCalculatorBO = new CalculatorRequestBO();

		reqCalculatorBO.setApplicationId("");
		reqCalculatorBO.setRequestId("");
		reqCalculatorBO.setFinancialProduct(850);
		reqCalculatorBO.setConventionId(88888888l);
		reqCalculatorBO.setAmountDiscount(340.00);
		reqCalculatorBO.setFrecuencyPayment("DIARIO");
		reqCalculatorBO.setProductCRM(580);
		try {
			CalculatorResponseBO calculatorResponseBO = test.getCalculator(
					new AS400("172.16.50.241", "S620100001", "santafe07"),
					reqCalculatorBO);

			System.out.println("STATUS::" + calculatorResponseBO.getStatus());
			System.out.println("CODE::" + calculatorResponseBO.getCode());
			System.out.println("RESPONSE::"
					+ calculatorResponseBO.getResponse());
			FormatUtils.formatoEncabezado(encabezado);
			for (RespCalculatorBO respuesta : calculatorResponseBO
					.getRespCalculatorBO()) {
				System.out.print("|");
				System.out.print(FormatUtils.llenarCaracter(
						respuesta.getAmountFinanced() + "", espacios, " ")
						+ "|");
				System.out.print(FormatUtils.llenarCaracter(
						respuesta.getFrecuencyPayment() + "", espacios, " ")
						+ "|");
				System.out.print(FormatUtils.llenarCaracter(
						respuesta.getPaymentPeriod() + "", espacios, " ")
						+ "|");
				System.out.print(FormatUtils.llenarCaracter(
						respuesta.getAmountFinanced() + "", espacios, " ")
						+ "|");
				System.out.print(FormatUtils.llenarCaracter(
						respuesta.getAnnualizedRate() + "", espacios, " ")
						+ "|");
				System.out.print(FormatUtils.llenarCaracter(respuesta.getCat()
						+ "", espacios, " ")
						+ "|");
				System.out.println(FormatUtils.llenarCaracter(
						respuesta.getTotalPayment() + "", espacios, " ")
						+ "|");
			}

			assertNull(calculatorResponseBO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AS400Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AS400ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
	/**
	 * Existo en la prueba de la Calculadora de Substitución
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	/*@Test
	public void testSubstitutionCalculator_TestCase4() throws RemoteException,
			MalformedURLException {
		SubstitutionCalculator test = new SubstitutionCalculator();
		CalculatorRequestBO reqCalculatorBO = new CalculatorRequestBO();
		reqCalculatorBO.setApplicationId("144");
		reqCalculatorBO.setRequestId("Subs Calc");
		reqCalculatorBO.setFinancialProduct(850);
		reqCalculatorBO.setConventionId(88888888l);
		reqCalculatorBO.setAmountDiscount(340.00);
		reqCalculatorBO.setFrecuencyPayment("MENSUAL");
		reqCalculatorBO.setProductCRM(580);
		try {
			CalculatorResponseBO calculatorResponseBO = test.getCalculator(
					new AS400("172.16.50.241", "S620100001", "santafe07"),
					reqCalculatorBO);

			System.out.println("STATUS::" + calculatorResponseBO.getStatus());
			System.out.println("CODE::" + calculatorResponseBO.getCode());
			System.out.println("RESPONSE::"
					+ calculatorResponseBO.getResponse());
			FormatUtils.formatoEncabezado(encabezado);
			for (RespCalculatorBO respuesta : calculatorResponseBO
					.getRespCalculatorBO()) {
				System.out.print("|");
				System.out.print(FormatUtils.llenarCaracter(
						respuesta.getAmountFinanced() + "", espacios, " ")
						+ "|");
				System.out.print(FormatUtils.llenarCaracter(
						respuesta.getFrecuencyPayment() + "", espacios, " ")
						+ "|");
				System.out.print(FormatUtils.llenarCaracter(
						respuesta.getPaymentPeriod() + "", espacios, " ")
						+ "|");
				System.out.print(FormatUtils.llenarCaracter(
						respuesta.getAmountFinanced() + "", espacios, " ")
						+ "|");
				System.out.print(FormatUtils.llenarCaracter(
						respuesta.getAnnualizedRate() + "", espacios, " ")
						+ "|");
				System.out.print(FormatUtils.llenarCaracter(respuesta.getCat()
						+ "", espacios, " ")
						+ "|");
				System.out.println(FormatUtils.llenarCaracter(
						respuesta.getTotalPayment() + "", espacios, " ")
						+ "|");
			}

			assertNotNull(calculatorResponseBO);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AS400Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AS400ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
	

}
