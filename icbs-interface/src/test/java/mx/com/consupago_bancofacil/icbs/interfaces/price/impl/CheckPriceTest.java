/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.price.impl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import mx.com.consupago_bancofacil.icbs.interfaces.price.bo.CheckPriceBO;
import mx.com.consupago_bancofacil.icbs.interfaces.price.bo.PriceRequestBO;
import mx.com.consupago_bancofacil.icbs.interfaces.price.bo.PriceResponseBO;
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
public class CheckPriceTest {
	private static List<String> encabezado = Arrays.asList(new String[]{"PeriodPayment","frecuencyPayment","discountAmount","AmountFinanced","TotalAmount","CAT","annualizedRate"});
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
	 * Test method for
	 * {@link mx.com.consupago_bancofacil.icbs.interfaces.credits.impl.CreditActives#getCreditsActives(com.ibm.as400.access.AS400, mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditRequestBO)}
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	@Test
	public void testGetPrice_TestCase1()  {
		System.out
				.println("Test Case 1*************************************************");
		CheckPrice test = new CheckPrice();
		PriceRequestBO priceRequestBO = new PriceRequestBO();
		priceRequestBO.setApplicationId("");
		priceRequestBO.setRequestId("");
		priceRequestBO.setIdProductEnd(850);
		priceRequestBO.setConvenioId(88888888l);
		priceRequestBO.setCreditAmount(5000.0);
		priceRequestBO.setFrecuencyPayments("DIARIO");
		priceRequestBO.setProductCRM(580);

		PriceResponseBO priceResponseBO;
		try {
			priceResponseBO = test.checkPrice(new AS400("172.16.50.241",
					"S620100001", "santafe07"), priceRequestBO);

			System.out.println("STATUS::" + priceResponseBO.getStatus());
			System.out.println("CODE::" + priceResponseBO.getCode());
			System.out.println("RESPONSE::" + priceResponseBO.getResponse());
			FormatUtils.formatoEncabezado(encabezado);
			if (priceResponseBO.getRespuesta() != null) {
				for (CheckPriceBO respuesta : priceResponseBO.getRespuesta()) {
					// FormatUtils.llenarCaracter(respQuotationBO.getCreditAmount()+"",espacios," ")+"|")
					System.out.print("|");
					System.out.print(FormatUtils.llenarCaracter(
							respuesta.getPeridoPayment() + "", espacios, " ")
							+ "|");
					System.out
							.print(FormatUtils.llenarCaracter(
									respuesta.getFrecuencyPayment() + "",
									espacios, " ") + "|");
					System.out.print(FormatUtils.llenarCaracter(
							respuesta.getDiscountAmount() + "", espacios, " ")
							+ "|");
					System.out.print(FormatUtils.llenarCaracter(
							respuesta.getAmountFinanced() + "", espacios, " ")
							+ "|");
					System.out.print(FormatUtils.llenarCaracter(
							respuesta.getTotalAmount() + "", espacios, " ")
							+ "|");
					System.out.print(FormatUtils.llenarCaracter(
							respuesta.getCAT() + "", espacios, " ")
							+ "|");
					System.out.println(FormatUtils.llenarCaracter(
							respuesta.getAnnualizedRate() + "", espacios, " ")
							+ "|");
				}
			}
			System.out
					.println("Test Case 1*************************************************");
			assertTrue(priceResponseBO != null);
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
	}
	
	
	/**
	 * Test method for
	 * {@link mx.com.consupago_bancofacil.icbs.interfaces.credits.impl.CreditActives#getCreditsActives(com.ibm.as400.access.AS400, mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditRequestBO)}
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	@Test
	public void testGetPrice_TestCase2()  {
		System.out
				.println("Test Case 2*************************************************");
		CheckPrice test = new CheckPrice();
		PriceRequestBO priceRequestBO = new PriceRequestBO();
		priceRequestBO.setApplicationId(null);
		priceRequestBO.setRequestId(null);
		priceRequestBO.setIdProductEnd(112);
		priceRequestBO.setConvenioId(null);
		priceRequestBO.setCreditAmount(null);
		priceRequestBO.setFrecuencyPayments(null);
		priceRequestBO.setProductCRM(null);

		PriceResponseBO priceResponseBO;

		try {
			priceResponseBO = test.checkPrice(new AS400("172.16.50.241",
					"S620100001", "santafe07"), priceRequestBO);

			System.out.println("STATUS::" + priceResponseBO.getStatus());
			System.out.println("CODE::" + priceResponseBO.getCode());
			System.out.println("RESPONSE::" + priceResponseBO.getResponse());
			FormatUtils.formatoEncabezado(encabezado);
			if (priceResponseBO.getRespuesta() != null) {
				for (CheckPriceBO respuesta : priceResponseBO.getRespuesta()) {
					// FormatUtils.llenarCaracter(respQuotationBO.getCreditAmount()+"",espacios," ")+"|")
					System.out.print("|");
					System.out.print(FormatUtils.llenarCaracter(
							respuesta.getPeridoPayment() + "", espacios, " ")
							+ "|");
					System.out
							.print(FormatUtils.llenarCaracter(
									respuesta.getFrecuencyPayment() + "",
									espacios, " ") + "|");
					System.out.print(FormatUtils.llenarCaracter(
							respuesta.getDiscountAmount() + "", espacios, " ")
							+ "|");
					System.out.print(FormatUtils.llenarCaracter(
							respuesta.getAmountFinanced() + "", espacios, " ")
							+ "|");
					System.out.print(FormatUtils.llenarCaracter(
							respuesta.getTotalAmount() + "", espacios, " ")
							+ "|");
					System.out.print(FormatUtils.llenarCaracter(
							respuesta.getCAT() + "", espacios, " ")
							+ "|");
					System.out.println(FormatUtils.llenarCaracter(
							respuesta.getAnnualizedRate() + "", espacios, " ")
							+ "|");
				}
			}
			System.out
					.println("Test Case 2*************************************************");
			assertTrue(priceResponseBO != null);
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
	}	
	
	
	/**
	 * Test method for
	 * {@link mx.com.consupago_bancofacil.icbs.interfaces.credits.impl.CreditActives#getCreditsActives(com.ibm.as400.access.AS400, mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditRequestBO)}
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testGetPrice_TestCase3() throws RemoteException, MalformedURLException {
		System.out.println("Test Case 3*************************************************");
		CheckPrice test = new CheckPrice();
		PriceRequestBO priceRequestBO = new PriceRequestBO();
		priceRequestBO.setIdProductEnd(40);
		priceRequestBO.setCreditAmount(5000.0);
		priceRequestBO.setNumberPayments(12);
		priceRequestBO.setPeriodPayments("M");
		priceRequestBO.setFrecuencyPayments(1);
		priceRequestBO.setAnnualInterestRate(0.5064);
		priceRequestBO.setIVARate(0.16);
		priceRequestBO.setAmountCommissionOpening(0.0);
		priceRequestBO.setPercentageCommissionOpening(0.0);
		priceRequestBO.setPercentageDeferredCommission(0.0);
		
		
		PriceResponseBO priceResponseBO = test.checkPrice(new AS400("172.16.50.241", "S620100001",
		"WEBSERVICE"), priceRequestBO);
		
		System.out.println("STATUS::" + priceResponseBO.getStatus());
		System.out.println("CODE::" + priceResponseBO.getCode());
		System.out.println("RESPONSE::" + priceResponseBO.getResponse());
		
		System.out.println("Monto Pago::" + priceResponseBO.getAmountPayment());
		System.out.println("Monto Capital::" + priceResponseBO.getCapitalAmount());
		System.out.println("Monto Interes::" + priceResponseBO.getAmountInterest());
		System.out.println("Monto IVA::" + priceResponseBO.getAmountIVA());
		System.out.println("CAT::" + priceResponseBO.getCAT());
		
		System.out.println("Test Case 3*************************************************");
		assertTrue(priceResponseBO!=null);
	}*/
	
	
	
	/**
	 * Test method for
	 * {@link mx.com.consupago_bancofacil.icbs.interfaces.credits.impl.CreditActives#getCreditsActives(com.ibm.as400.access.AS400, mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditRequestBO)}
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testGetPrice_TestCase4() throws RemoteException, MalformedURLException {
		System.out.println("Test Case 4*************************************************");
		CheckPrice test = new CheckPrice();
		PriceRequestBO priceRequestBO = new PriceRequestBO();
		priceRequestBO.setIdProductEnd(840);
		priceRequestBO.setCreditAmount(5000.0);
		priceRequestBO.setNumberPayments(240);
		priceRequestBO.setPeriodPayments("D");
		priceRequestBO.setFrecuencyPayments(15);
		priceRequestBO.setAnnualInterestRate(0.11);
		priceRequestBO.setIVARate(0.16);
		priceRequestBO.setAmountCommissionOpening(0.0);
		priceRequestBO.setPercentageCommissionOpening(0.0);
		priceRequestBO.setPercentageDeferredCommission(0.0);
		
		
		PriceResponseBO priceResponseBO = test.checkPrice(new AS400("172.16.50.241", "S620100001",
		"WEBSERVICE"), priceRequestBO);
		
		System.out.println("STATUS::" + priceResponseBO.getStatus());
		System.out.println("CODE::" + priceResponseBO.getCode());
		System.out.println("RESPONSE::" + priceResponseBO.getResponse());
		
		System.out.println("Monto Pago::" + priceResponseBO.getAmountPayment());
		System.out.println("Monto Capital::" + priceResponseBO.getCapitalAmount());
		System.out.println("Monto Interes::" + priceResponseBO.getAmountInterest());
		System.out.println("Monto IVA::" + priceResponseBO.getAmountIVA());
		System.out.println("CAT::" + priceResponseBO.getCAT());
		
		System.out.println("Test Case 4*************************************************");
		assertTrue(priceResponseBO!=null);
	}	*/
	
	
	/**
	 * Test method for
	 * {@link mx.com.consupago_bancofacil.icbs.interfaces.credits.impl.CreditActives#getCreditsActives(com.ibm.as400.access.AS400, mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditRequestBO)}
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testGetPrice_TestCase5() throws RemoteException, MalformedURLException {
		System.out.println("Test Case 5*************************************************");
		CheckPrice test = new CheckPrice();
		PriceRequestBO priceRequestBO = new PriceRequestBO();
		priceRequestBO.setIdProductEnd(840);
		priceRequestBO.setCreditAmount(5000.0);
		priceRequestBO.setNumberPayments(240);
		priceRequestBO.setPeriodPayments("D");
		priceRequestBO.setFrecuencyPayments(7);
		priceRequestBO.setAnnualInterestRate(0.11);
		priceRequestBO.setIVARate(0.16);
		priceRequestBO.setAmountCommissionOpening(0.0);
		priceRequestBO.setPercentageCommissionOpening(0.0);
		priceRequestBO.setPercentageDeferredCommission(0.0);
		
		
		PriceResponseBO priceResponseBO = test.checkPrice(new AS400("172.16.50.241", "S620100001",
		"WEBSERVICE"), priceRequestBO);
		
		System.out.println("STATUS::" + priceResponseBO.getStatus());
		System.out.println("CODE::" + priceResponseBO.getCode());
		System.out.println("RESPONSE::" + priceResponseBO.getResponse());
		
		System.out.println("Monto Pago::" + priceResponseBO.getAmountPayment());
		System.out.println("Monto Capital::" + priceResponseBO.getCapitalAmount());
		System.out.println("Monto Interes::" + priceResponseBO.getAmountInterest());
		System.out.println("Monto IVA::" + priceResponseBO.getAmountIVA());
		System.out.println("CAT::" + priceResponseBO.getCAT());
		
		System.out.println("Test Case 5*************************************************");
		assertTrue(priceResponseBO!=null);
	}*/
	
	/**
	 * 
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	@Test
	public void testGetPrice_TestCase6()  {
		System.out.println("Test Case 6*************************************************");
		CheckPrice test = new CheckPrice();
		PriceRequestBO priceRequestBO = new PriceRequestBO();
		priceRequestBO.setApplicationId("");
		priceRequestBO.setRequestId("");
		priceRequestBO.setIdProductEnd(850);
		priceRequestBO.setConvenioId(88888888l);
		priceRequestBO.setCreditAmount(5000.0);
		priceRequestBO.setFrecuencyPayments("MENSUAL");
		priceRequestBO.setProductCRM(580);		
		
		
		PriceResponseBO priceResponseBO;
		try {
			priceResponseBO = test.checkPrice(new AS400("172.16.50.241", "S620100001",
			"santafe07"), priceRequestBO);
		
		
		System.out.println("STATUS::" + priceResponseBO.getStatus());
		System.out.println("CODE::" + priceResponseBO.getCode());
		System.out.println("RESPONSE::" + priceResponseBO.getResponse());
		FormatUtils.formatoEncabezado(encabezado);
		for (CheckPriceBO respuesta:priceResponseBO.getRespuesta()){
			//FormatUtils.llenarCaracter(respQuotationBO.getCreditAmount()+"",espacios," ")+"|")
			System.out.print("|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getPeridoPayment()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getFrecuencyPayment()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getDiscountAmount()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getAmountFinanced()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getTotalAmount()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respuesta.getCAT()+"",espacios," ")+"|");
			System.out.println(FormatUtils.llenarCaracter(respuesta.getAnnualizedRate()+"",espacios," ")+"|");
		}
		System.out.println("Test Case 6*************************************************");
		assertTrue(priceResponseBO!=null);
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
	}
	
	
}
