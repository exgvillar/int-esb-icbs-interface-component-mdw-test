/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.quotation.impl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
public class QuotationTest {

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
	 * Exito en Quotation
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testQuotation_TestCase1() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 1**************************************************");
		Quotation test = new Quotation();
		List<ReqQuotationBO> listaReq = new ArrayList<ReqQuotationBO>();
		//for (int i=0; i< 4000; i++){
		ReqQuotationBO reqQuotationBO = new ReqQuotationBO();
		
		reqQuotationBO.setIdProductEnd(840);
		reqQuotationBO.setCreditAmount(10000.0);
		reqQuotationBO.setNumberPayments(168);//240
		reqQuotationBO.setPeriodPayments("D");
		reqQuotationBO.setFrecuencyPayments(15);
		reqQuotationBO.setAnnualInterestRate(0.48);
		reqQuotationBO.setIVARate(0.11);
		reqQuotationBO.setAmountCommissionOpening(0.0);
		reqQuotationBO.setPercentageCommissionOpening(0.0);
		reqQuotationBO.setPercentageDeferredCommission(0.0);
		
		listaReq.add(reqQuotationBO);
		
		//}
		ReqQuotationBO reqQuotation2BO = new ReqQuotationBO();
		
		reqQuotation2BO.setIdProductEnd(840);
		reqQuotation2BO.setCreditAmount(10500.0);
		reqQuotation2BO.setNumberPayments(168);
		reqQuotation2BO.setPeriodPayments("D");
		reqQuotation2BO.setFrecuencyPayments(15);
		reqQuotation2BO.setAnnualInterestRate(0.48);
		reqQuotation2BO.setIVARate(0.16);
		reqQuotation2BO.setAmountCommissionOpening(0.0);
		reqQuotation2BO.setPercentageCommissionOpening(0.0);
		reqQuotation2BO.setPercentageDeferredCommission(0.0);
		
		listaReq.add(reqQuotation2BO);
		
		ReqQuotationBO reqQuotation3BO = new ReqQuotationBO();
		
		reqQuotation3BO.setIdProductEnd(840);
		reqQuotation3BO.setCreditAmount(11000.00);
		reqQuotation3BO.setNumberPayments(168);
		reqQuotation3BO.setPeriodPayments("D");
		reqQuotation3BO.setFrecuencyPayments(15);
		reqQuotation3BO.setAnnualInterestRate(0.48);
		reqQuotation3BO.setIVARate(0.16);
		reqQuotation3BO.setAmountCommissionOpening(0.0);
		reqQuotation3BO.setPercentageCommissionOpening(0.0);
		reqQuotation3BO.setPercentageDeferredCommission(0.0);
		
		listaReq.add(reqQuotation3BO);
		
		ReqQuotationBO reqQuotation4BO = new ReqQuotationBO();
		
		reqQuotation4BO.setIdProductEnd(840);
		reqQuotation4BO.setCreditAmount(11500.00);
		reqQuotation4BO.setNumberPayments(168);
		reqQuotation4BO.setPeriodPayments("D");
		reqQuotation4BO.setFrecuencyPayments(15);
		reqQuotation4BO.setAnnualInterestRate(0.48);
		reqQuotation4BO.setIVARate(0.11);
		reqQuotation4BO.setAmountCommissionOpening(0.0);
		reqQuotation4BO.setPercentageCommissionOpening(0.0);
		reqQuotation4BO.setPercentageDeferredCommission(0.0);
		
		listaReq.add(reqQuotation4BO);
		
		ReqQuotationBO reqQuotation5BO = new ReqQuotationBO();
		
		reqQuotation5BO.setIdProductEnd(840);
		reqQuotation5BO.setCreditAmount(12000.0);
		reqQuotation5BO.setNumberPayments(168);
		reqQuotation5BO.setPeriodPayments("D");
		reqQuotation5BO.setFrecuencyPayments(15);
		reqQuotation5BO.setAnnualInterestRate(0.48);
		reqQuotation5BO.setIVARate(0.11);
		reqQuotation5BO.setAmountCommissionOpening(0.0);
		reqQuotation5BO.setPercentageCommissionOpening(0.0);
		reqQuotation5BO.setPercentageDeferredCommission(0.0);
		
		listaReq.add(reqQuotation5BO);
		
		QuotationResponseBO quotationResponseBO = test.getQuotation(new AS400("172.16.50.241", "S620100001",
				"santafe07"), new QuotationRequestBO("App001", "0001", listaReq));	
		System.out.println("status::"+quotationResponseBO.getStatus());
		System.out.println("code::"+quotationResponseBO.getCode());
		System.out.println("response::"+quotationResponseBO.getResponse());
		List<RespQuotationBO> lista = quotationResponseBO.getRespQuotationBO();
		System.out.print("CreditNumber::");
		System.out.print("NumberPayments::");
		System.out.print("PeriodPayments::");
		System.out.print("FrecuencyPayments::");
		System.out.print("PaymentsAmount::");
		System.out.println("CAT::");
		FormatUtils.formatoEncabezado(encabezado);
		for (RespQuotationBO respQuotationBO: lista){
			
			
			System.out.print("|");
			System.out.print(FormatUtils.llenarCaracter(respQuotationBO.getCreditAmount()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respQuotationBO.getNumberPayments()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respQuotationBO.getPeriodPayments()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respQuotationBO.getFrecuencyPayments()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respQuotationBO.getPaymentsAmount()+"",espacios," ")+"|");
			System.out.println(FormatUtils.llenarCaracter(respQuotationBO.getCAT()+"",espacios," ")+"|");
		}
		assertTrue(lista.size()>0);
	}*/
	
	
	/**
	 * Se prueba la idProductEnd Inexistente
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testQuotation_TestCase2() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 2**************************************************");
		Quotation test = new Quotation();
		List<ReqQuotationBO> listaReq = new ArrayList<ReqQuotationBO>();
		
		ReqQuotationBO reqQuotationBO = new ReqQuotationBO();
		
		reqQuotationBO.setIdProductEnd(40);
		reqQuotationBO.setCreditAmount(5000.0);
		reqQuotationBO.setNumberPayments(240);
		reqQuotationBO.setPeriodPayments("D");
		reqQuotationBO.setFrecuencyPayments(7);
		reqQuotationBO.setAnnualInterestRate(0.5064);
		reqQuotationBO.setIVARate(0.11);
		reqQuotationBO.setAmountCommissionOpening(0.0);
		reqQuotationBO.setPercentageCommissionOpening(0.0);
		reqQuotationBO.setPercentageDeferredCommission(0.0);
		
		listaReq.add(reqQuotationBO);
		
		
		
		QuotationResponseBO quotationResponseBO = test.getQuotation(new AS400("172.16.50.241", "S620100001",
				"WEBSERVICE"), new QuotationRequestBO("App001", "0001", listaReq));		
		System.out.println("status::"+quotationResponseBO.getStatus());
		System.out.println("code::"+quotationResponseBO.getCode());
		System.out.println("response::"+quotationResponseBO.getResponse());
		List<RespQuotationBO> lista = quotationResponseBO.getRespQuotationBO();
		
		assertNull(lista);
	}*/
	
	
	/**
	 * Se prueba error de formato
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testQuotation_TestCase3() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 3**************************************************");
		Quotation test = new Quotation();
		List<ReqQuotationBO> listaReq = new ArrayList<ReqQuotationBO>();
		
		ReqQuotationBO reqQuotationBO = new ReqQuotationBO();
		
		reqQuotationBO.setIdProductEnd(840);
		reqQuotationBO.setCreditAmount(5000.0);
		reqQuotationBO.setNumberPayments(240);
		reqQuotationBO.setPeriodPayments("L");
		reqQuotationBO.setFrecuencyPayments(7);
		reqQuotationBO.setAnnualInterestRate(0.5064);
		reqQuotationBO.setIVARate(0.11);
		reqQuotationBO.setAmountCommissionOpening(0.0);
		reqQuotationBO.setPercentageCommissionOpening(0.0);
		reqQuotationBO.setPercentageDeferredCommission(0.0);
		
		listaReq.add(reqQuotationBO);
		
		
		
		QuotationResponseBO quotationResponseBO = test.getQuotation(new AS400("172.16.50.241", "S620100001",
				"WEBSERVICE"), new QuotationRequestBO("App001", "0001", listaReq));		
		System.out.println("status::"+quotationResponseBO.getStatus());
		System.out.println("code::"+quotationResponseBO.getCode());
		System.out.println("response::"+quotationResponseBO.getResponse());
		List<RespQuotationBO> lista = quotationResponseBO.getRespQuotationBO();
		
		assertNull(lista);
	}*/
	
	/**
	 * Se prueba error de formato
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testQuotation_TestCase4() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 4**************************************************");
		Quotation test = new Quotation();
		List<ReqQuotationBO> listaReq = new ArrayList<ReqQuotationBO>();
		
		ReqQuotationBO reqQuotationBO = new ReqQuotationBO();
		
		reqQuotationBO.setIdProductEnd(840);
		reqQuotationBO.setCreditAmount(0.0);
		reqQuotationBO.setNumberPayments(240);
		reqQuotationBO.setPeriodPayments("D");
		reqQuotationBO.setFrecuencyPayments(7);
		reqQuotationBO.setAnnualInterestRate(500.5064);
		reqQuotationBO.setIVARate(0.11);
		reqQuotationBO.setAmountCommissionOpening(0.0);
		reqQuotationBO.setPercentageCommissionOpening(0.0);
		reqQuotationBO.setPercentageDeferredCommission(0.0);
		
		listaReq.add(reqQuotationBO);
		
		QuotationResponseBO quotationResponseBO = test.getQuotation(new AS400("172.16.50.241", "S620100001",
				"santafe07"), new QuotationRequestBO("App001", "0001", listaReq));		
		System.out.println("status::"+quotationResponseBO.getStatus());
		System.out.println("code::"+quotationResponseBO.getCode());
		System.out.println("response::"+quotationResponseBO.getResponse());
		//List<RespQuotationBO> lista = quotationResponseBO.getRespQuotationBO();
		
	}*/
	
	
	/**
	 * Se prueba error de formato
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testQuotation_TestCase5() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 5**************************************************");
		Quotation test = new Quotation();
		List<ReqQuotationBO> listaReq = new ArrayList<ReqQuotationBO>();
		
		ReqQuotationBO reqQuotationBO = new ReqQuotationBO();
		
		reqQuotationBO.setIdProductEnd(840);
		reqQuotationBO.setCreditAmount(5000.0);
		reqQuotationBO.setNumberPayments(240);
		reqQuotationBO.setPeriodPayments("D");
		reqQuotationBO.setFrecuencyPayments(7);
		reqQuotationBO.setAnnualInterestRate(0.5064);
		reqQuotationBO.setIVARate(0.11);
		reqQuotationBO.setAmountCommissionOpening(0.0);
		reqQuotationBO.setPercentageCommissionOpening(0.0);
		reqQuotationBO.setPercentageDeferredCommission(0.0);
		
		listaReq.add(reqQuotationBO);
		
		QuotationResponseBO quotationResponseBO = test.getQuotation(new AS400("172.16.50.241", "S620100001",
				"santafe07"), new QuotationRequestBO("App001", "0001", listaReq));		
		System.out.println("status::"+quotationResponseBO.getStatus());
		System.out.println("code::"+quotationResponseBO.getCode());
		System.out.println("response::"+quotationResponseBO.getResponse());
		
		List<RespQuotationBO> lista = quotationResponseBO.getRespQuotationBO();
		for (RespQuotationBO respQuotationBO: lista){
			System.out.println("CreditNumber::"+respQuotationBO.getCreditAmount());
			System.out.println("NumberPayments::"+respQuotationBO.getNumberPayments());
			System.out.println("PeriodPayments::"+respQuotationBO.getPeriodPayments());
			System.out.println("FrecuencyPayments::"+respQuotationBO.getFrecuencyPayments());
			System.out.println("PaymentsAmount::"+respQuotationBO.getPaymentsAmount());
			System.out.println("CAT::"+respQuotationBO.getCAT());
		}
		
		
		System.out.print("CreditNumber::");
		System.out.print("NumberPayments::");
		System.out.print("PeriodPayments::");
		System.out.print("FrecuencyPayments::");
		System.out.print("PaymentsAmount::");
		System.out.println("CAT::");
		
		
		FormatUtils.formatoEncabezado(encabezado);
		List<RespQuotationBO> lista = quotationResponseBO.getRespQuotationBO();
		for (RespQuotationBO respQuotationBO: lista){
			System.out.println("CreditNumber::"+respQuotationBO.getCreditAmount());
			System.out.println("NumberPayments::"+respQuotationBO.getNumberPayments());
			System.out.println("PeriodPayments::"+respQuotationBO.getPeriodPayments());
			System.out.println("FrecuencyPayments::"+respQuotationBO.getFrecuencyPayments());
			System.out.println("PaymentsAmount::"+respQuotationBO.getPaymentsAmount());
			System.out.println("CAT::"+respQuotationBO.getCAT());
			
			
			System.out.print("|");
			System.out.print(FormatUtils.llenarCaracter(respQuotationBO.getCreditAmount()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respQuotationBO.getNumberPayments()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respQuotationBO.getPeriodPayments()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respQuotationBO.getFrecuencyPayments()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(respQuotationBO.getPaymentsAmount()+"",espacios," ")+"|");
			System.out.println(FormatUtils.llenarCaracter(respQuotationBO.getCAT()+"",espacios," ")+"|");
		}
		
		assertTrue(lista.size()>0);
	}*/
	
	
	/**
	 * Exito en Quotation
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testQuotation_TestCase6() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 6**************************************************");
		Quotation test = new Quotation();
		List<ReqQuotationBO> listaReq = new ArrayList<ReqQuotationBO>();
		
		ReqQuotationBO reqQuotationBO = new ReqQuotationBO();
		
		reqQuotationBO.setIdProductEnd(840);
		reqQuotationBO.setCreditAmount(5000.0);
		reqQuotationBO.setNumberPayments(240);
		reqQuotationBO.setPeriodPayments("D");
		reqQuotationBO.setFrecuencyPayments(7);
		reqQuotationBO.setAnnualInterestRate(0.5064);
		reqQuotationBO.setIVARate(0.11);
		reqQuotationBO.setAmountCommissionOpening(0.0);
		reqQuotationBO.setPercentageCommissionOpening(0.0);
		reqQuotationBO.setPercentageDeferredCommission(0.0);
		
		listaReq.add(reqQuotationBO);
		
		ReqQuotationBO reqQuotation2BO = new ReqQuotationBO();
		
		reqQuotation2BO.setIdProductEnd(840);
		reqQuotation2BO.setCreditAmount(4995.66);
		reqQuotation2BO.setNumberPayments(239);
		reqQuotation2BO.setPeriodPayments("L");
		reqQuotation2BO.setFrecuencyPayments(7);
		reqQuotation2BO.setAnnualInterestRate(0.5064);
		reqQuotation2BO.setIVARate(0.11);
		reqQuotation2BO.setAmountCommissionOpening(0.0);
		reqQuotation2BO.setPercentageCommissionOpening(0.0);
		reqQuotation2BO.setPercentageDeferredCommission(0.0);
		
		listaReq.add(reqQuotation2BO);
		
		ReqQuotationBO reqQuotation3BO = new ReqQuotationBO();
		
		reqQuotation3BO.setIdProductEnd(840);
		reqQuotation3BO.setCreditAmount(4991.27);
		reqQuotation3BO.setNumberPayments(238);
		reqQuotation3BO.setPeriodPayments("D");
		reqQuotation3BO.setFrecuencyPayments(7);
		reqQuotation3BO.setAnnualInterestRate(0.5064);
		reqQuotation3BO.setIVARate(0.11);
		reqQuotation3BO.setAmountCommissionOpening(0.0);
		reqQuotation3BO.setPercentageCommissionOpening(0.0);
		reqQuotation3BO.setPercentageDeferredCommission(0.0);
		
		listaReq.add(reqQuotation3BO);
		
		
		QuotationResponseBO quotationResponseBO = test.getQuotation(new AS400("172.16.50.241", "S620100001",
				"santafe07"), new QuotationRequestBO("App001", "0001", listaReq));	
		System.out.println("status::"+quotationResponseBO.getStatus());
		System.out.println("code::"+quotationResponseBO.getCode());
		System.out.println("response::"+quotationResponseBO.getResponse());
		List<RespQuotationBO> lista = quotationResponseBO.getRespQuotationBO();
		
		assertTrue(lista==null);
	}*/
	
	
	/**
	 * Exito en Quotation con 4000 registros
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testQuotation_TestCase7() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 1**************************************************");
		Quotation test = new Quotation();
		List<ReqQuotationBO> listaReq = new ArrayList<ReqQuotationBO>();
		for (int i=0; i< 4000; i++){
		ReqQuotationBO reqQuotationBO = new ReqQuotationBO();
		
		reqQuotationBO.setIdProductEnd(840);
		reqQuotationBO.setCreditAmount(5000.0);
		reqQuotationBO.setNumberPayments(240);//240
		reqQuotationBO.setPeriodPayments("D");
		reqQuotationBO.setFrecuencyPayments(7);
		reqQuotationBO.setAnnualInterestRate(0.5064);
		reqQuotationBO.setIVARate(0.11);
		reqQuotationBO.setAmountCommissionOpening(0.0);
		reqQuotationBO.setPercentageCommissionOpening(0.0);
		reqQuotationBO.setPercentageDeferredCommission(0.0);
		
		listaReq.add(reqQuotationBO);
		
		}
		
		
		QuotationResponseBO quotationResponseBO = test.getQuotation(new AS400("172.16.50.241", "S620100001",
				"WEBSERVICE"), new QuotationRequestBO("App001", "0001", listaReq));	
		System.out.println("status::"+quotationResponseBO.getStatus());
		System.out.println("code::"+quotationResponseBO.getCode());
		System.out.println("response::"+quotationResponseBO.getResponse());
		List<RespQuotationBO> lista = quotationResponseBO.getRespQuotationBO();
		for (RespQuotationBO respQuotationBO: lista){
			System.out.println("CreditNumber::"+respQuotationBO.getCreditAmount());
			System.out.println("NumberPayments::"+respQuotationBO.getNumberPayments());
			System.out.println("PeriodPayments::"+respQuotationBO.getPeriodPayments());
			System.out.println("FrecuencyPayments::"+respQuotationBO.getFrecuencyPayments());
			System.out.println("PaymentsAmount::"+respQuotationBO.getPaymentsAmount());
			System.out.println("CAT::"+respQuotationBO.getCAT());
		}
		assertTrue(lista.size()>0);
	}*/
	
	
	
	/**
	 * Exito en Quotation con 4000 registros
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testQuotation_TestCase7() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 7**************************************************");
		Quotation test = new Quotation();
		List<ReqQuotationBO> listaReq = new ArrayList<ReqQuotationBO>();
		double monto = 10000.00;
		for (int i=0; i< 6647; i++){
		ReqQuotationBO reqQuotationBO = new ReqQuotationBO();
		
		reqQuotationBO.setIdProductEnd(840);
		reqQuotationBO.setCreditAmount(monto);
		reqQuotationBO.setNumberPayments(168);//240
		reqQuotationBO.setPeriodPayments("D");
		reqQuotationBO.setFrecuencyPayments(15);
		reqQuotationBO.setAnnualInterestRate(0.48);
		reqQuotationBO.setIVARate(0.11);
		reqQuotationBO.setAmountCommissionOpening(0.0);
		reqQuotationBO.setPercentageCommissionOpening(0.0);
		reqQuotationBO.setPercentageDeferredCommission(0.0);
		monto = monto + 500.0;
		listaReq.add(reqQuotationBO);
		
		}
		
		
		QuotationResponseBO quotationResponseBO;
		try {
			quotationResponseBO = test.getQuotation(new AS400("172.16.50.241", "S620100001",
			"santafe07"), new QuotationRequestBO("App001", "0001", listaReq));
			
			System.out.println("status::"+quotationResponseBO.getStatus());
			System.out.println("code::"+quotationResponseBO.getCode());
			System.out.println("response::"+quotationResponseBO.getResponse());
			List<RespQuotationBO> lista = quotationResponseBO.getRespQuotationBO();
		
			assertTrue(lista.size()>0);
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
	 * Exito en Quotation con 4000 registros
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	@Test
	public void testQuotation_TestCase8() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 8**************************************************");
		Quotation test = new Quotation();	
		
		QuotationRequestBO quotationRequestBO = new QuotationRequestBO();
		
		quotationRequestBO.setApplicationId("1");
		quotationRequestBO.setRequestId("PAC");
		quotationRequestBO.setFinancialProduct(850);
		quotationRequestBO.setFrecuencyPayment("SEMANAL");
		quotationRequestBO.setProductCRM(850);
		quotationRequestBO.setVatRate(16.00);
		//quotationRequestBO.setVatRate(16.00);
		
		MultiRateInfoBO multiRateInfoBO = new MultiRateInfoBO();
		multiRateInfoBO.setFinancialAmount(10.00);
		multiRateInfoBO.setMontlyRate(10.00);
		multiRateInfoBO.setPaymentPeriod("1");
		
		ComissionInfoBO comissionInfoBO = new ComissionInfoBO();
		comissionInfoBO.setAmountComission(10.00);
		comissionInfoBO.setDeffered(false);
		comissionInfoBO.setPorcentual(false);
		
		List<MultiRateInfoBO> listaMulti = new ArrayList<MultiRateInfoBO>();
		List<ComissionInfoBO> listaComissionInfoBO = new ArrayList<ComissionInfoBO>();
		listaMulti.add(multiRateInfoBO);
		listaComissionInfoBO.add(comissionInfoBO);
		
		quotationRequestBO.setMultiRateInfo(listaMulti);
		quotationRequestBO.setComissionInfo(listaComissionInfoBO);
		
		QuotationResponseBO quotationResponseBO;
		try {
		quotationResponseBO = test.getQuotation(new AS400("172.16.50.241", "S620100001",
			"santafe07"), quotationRequestBO);
			
			System.out.println("status::"+quotationResponseBO.getStatus());
			System.out.println("code::"+quotationResponseBO.getCode());
			System.out.println("response::"+quotationResponseBO.getResponse());
			List<RespQuotationBO> lista = quotationResponseBO.getRespQuotationBO();
			
			for (RespQuotationBO respQuotationBO:lista){
				System.out.println(respQuotationBO.getPaymentNumber());
				System.out.println(respQuotationBO.getAnnualizedRate());
				System.out.println(respQuotationBO.getPercentageCommission());
				System.out.println(respQuotationBO.getCat());
				System.out.println(respQuotationBO.getAmountCredit());			
				System.out.println(respQuotationBO.getAmountDiscount());
				System.out.println(respQuotationBO.getTotalPayment());
			}
		
			assertTrue(lista.size()>0);
		} catch (AS400Exception e) {			
			e.printStackTrace();
		} catch (ICBSInterfaceException e) {		
			e.printStackTrace();
		} catch (AS400ICBSInterfaceException e) {		
			e.printStackTrace();
		}
	}
	
}
