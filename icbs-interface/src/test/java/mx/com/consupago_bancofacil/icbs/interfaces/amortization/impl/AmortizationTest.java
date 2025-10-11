/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.amortization.impl;



import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;
import mx.com.consupago_bancofacil.icbs.interfaces.amortization.bo.AmortizationRequestBO;
import mx.com.consupago_bancofacil.icbs.interfaces.amortization.bo.AmortizationResponseBO;
import mx.com.consupago_bancofacil.icbs.interfaces.commons.bo.PaymentBO;
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
public class AmortizationTest {
	
	//private static List<String> encabezado = Arrays.asList(new String[]{"NumberPayments","Fecha Apertura","Fecha Pago","Base Calculo","Fecha Inicial","Fecha Final","Dias Interes","pago Capital","pago Interes","pago Impuesto Interes","pago Comision","pago Impuesto Comision","pago Total"});
	private static List<String> encabezado = Arrays.asList(new String[]{"PaymentNumber","PaymentDate","PaymentAmount","PrincipalAmount","InterestAmount","InterestTaxAmount","Commission1Amount","Commission1TaxAmount","Commission2Amount","Commission2TaxAmount","Commission3Amount","Commission3TaxAmount","InsuranceAmount","InsuranceTaxAmount"});
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
	
	@Test
	public void testStatement_TestCase1() {
		System.out.println("TEST CASE 1**************************************************");
		Amortization test = new Amortization();
		
		
		AmortizationRequestBO amortizationReqBO = new AmortizationRequestBO();
		
		amortizationReqBO.setApplicationId("123");
		amortizationReqBO.setRequestId("123");
		amortizationReqBO.setCreditId(5075225);
		
		AmortizationResponseBO amortizationResponseBO;
		
		
		try {
			amortizationResponseBO = test.getAmortization(new AS400("172.16.50.245", "S620100013","S620100013"),amortizationReqBO);
			System.out.println("code:::"+amortizationResponseBO.getCode());
			System.out.println("status:::"+amortizationResponseBO.getStatus());
			System.out.println("response:::"+amortizationResponseBO.getResponse());
			String creditId = amortizationReqBO.getCreditId().toString();
			System.out.println("creditId::"+creditId);
			if (amortizationResponseBO.getBorrowerBO()!=null){
				System.out.println("BorrowerID:::"+amortizationResponseBO.getBorrowerBO().getBorrowerId());
				System.out.println("FirstName:::"+amortizationResponseBO.getBorrowerBO().getFirstName());
				System.out.println("PaternalName:::"+amortizationResponseBO.getBorrowerBO().getPaternalName());
				System.out.println("MaternlaName:::"+amortizationResponseBO.getBorrowerBO().getMaternalName());
			}
			
			if (amortizationResponseBO.getLoanBO()!=null){
				//System.out.println("BorrowerID:::"+amortizationResponseBO.getLoanBO().getBankName());
				System.out.println("BorrowerID:::"+amortizationResponseBO.getLoanBO().getCompanyCode());
				System.out.println("ConvenioID:::"+amortizationResponseBO.getLoanBO().getConvenioID());
				System.out.println("ConvenioName:::"+amortizationResponseBO.getLoanBO().getConvenioName());		
				
			
				System.out.println("RequestAmount:::"+amortizationResponseBO.getLoanBO().getRequestedAmount());		
				System.out.println("TotalPaymentsNumber:::"+amortizationResponseBO.getLoanBO().getTotalPaymentsNumber());		
				System.out.println("PaymentFrequencyName:::"+amortizationResponseBO.getLoanBO().getPaymentFrequencyName());
				System.out.println("PaymentAmount:::"+amortizationResponseBO.getLoanBO().getPaymentAmount());
			}
			//System.out.println("size::::"+amortizationResponseBO.getPaymentTableBO().getListPaymentBO().size());
			if (amortizationResponseBO.getPaymentTableBO()!=null){
				
				FormatUtils.formatoEncabezado(encabezado);
				//System.out.print(FormatUtils.llenarCaracter(creditBO.getCreditNumber(),espacios," ")+"|");
				for (PaymentBO paymentBO:amortizationResponseBO.getPaymentTableBO().getListPaymentBO()){
					System.out.print("|");
					System.out.print(FormatUtils.llenarCaracter(paymentBO.getPaymentNumber()+"",espacios," ")+"|");
					System.out.print(FormatUtils.llenarCaracter(paymentBO.getPaymentDate()+"",espacios," ")+"|");
					System.out.print(FormatUtils.llenarCaracter(paymentBO.getPaymentAmount()+"",espacios," ")+"|");
					System.out.print(FormatUtils.llenarCaracter(paymentBO.getPrincipalAmount()+"",espacios," ")+"|");
					System.out.print(FormatUtils.llenarCaracter(paymentBO.getInterestAmount()+"",espacios," ")+"|");
					System.out.print(FormatUtils.llenarCaracter(paymentBO.getInterestTaxAmount()+"",espacios," ")+"|");
					System.out.print(FormatUtils.llenarCaracter(paymentBO.getCommission1Amount()+"",espacios," ")+"|");
					System.out.print(FormatUtils.llenarCaracter(paymentBO.getCommission1TaxAmount()+"",espacios," ")+"|");
					System.out.print(FormatUtils.llenarCaracter(paymentBO.getCommission2Amount()+"",espacios," ")+"|");
					System.out.print(FormatUtils.llenarCaracter(paymentBO.getCommission2TaxAmount()+"",espacios," ")+"|");
					System.out.print(FormatUtils.llenarCaracter(paymentBO.getCommission3Amount()+"",espacios," ")+"|");
					System.out.print(FormatUtils.llenarCaracter(paymentBO.getCommission3TaxAmount()+"",espacios," ")+"|");
					System.out.print(FormatUtils.llenarCaracter(paymentBO.getInsuranceAmount()+"",espacios," ")+"|");
					System.out.println(FormatUtils.llenarCaracter(paymentBO.getInsuranceTaxAmount()+"",espacios," ")+"|");
					
					
				}
			}
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
	 * Exito en Amortization
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testStatement_TestCase1() {
		System.out.println("TEST CASE 1**************************************************");
		Amortization test = new Amortization();
		
		
		AmortizationRequestBO amortizationReqBO = new AmortizationRequestBO();
		
		amortizationReqBO.setApplicationId("");
		amortizationReqBO.setRequestId("");
		amortizationReqBO.setIdProductEnd(840);
		amortizationReqBO.setCreditAmount(10000.00);
		amortizationReqBO.setNumberPayments(60);
		
		amortizationReqBO.setOpeningDate("31082011");
		
		
		amortizationReqBO.setFirstPaymentDate("30092011");
		
		amortizationReqBO.setPeriodPayments("M");
		amortizationReqBO.setFrecuencyPayments(1);
		amortizationReqBO.setAnnualInterestRate(0.42);
		amortizationReqBO.setIVARate(0.16);
		amortizationReqBO.setAmountCommissionOpening(0.0);
		amortizationReqBO.setPercentageCommissionOpening(0.0);
		amortizationReqBO.setPercentageDeferredCommission(0.0);
		//amortizationReqBO.setCredit(7012);//240
		
		AmortizationResponseBO amortizationResponseBO;
		
			try {
				amortizationResponseBO = test.getAmortization(new AS400("172.16.50.241", "S620100001",
						"santafe07"),amortizationReqBO);
			
		
		System.out.println("status::"+amortizationResponseBO.getStatus());
		System.out.println("code::"+amortizationResponseBO.getCode());
		System.out.println("response::"+amortizationResponseBO.getResponse());
		
		
		List<AmortizationRespBO> lista = amortizationResponseBO.getAmortizationRespBO();
		
		FormatUtils.formatoEncabezado(encabezado);
		
		for (AmortizationRespBO amortizationRespBO: lista){
			System.out.print("|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getNumberPayments()+"",espacios," ")+"|");
			//System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.get()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getDatePayments()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getCalculationBase()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getDateInitial()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getDateEnd()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getInterestDays()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getCapitaPayments()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getInterestPayments()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getInterestPaymentsTax()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getCommissionPayment()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getCommissionPaymentTax()+"",espacios," ")+"|");
			System.out.println(FormatUtils.llenarCaracter(amortizationRespBO.getTotalPayment()+"",espacios," ")+"|");						
		}
		assertTrue(lista.size()>0);
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
	 * Exito en Amortization Quincenal
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testStatement_TestCase2() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 2**************************************************");
		Amortization test = new Amortization();
		
		
		AmortizationRequestBO amortizationReqBO = new AmortizationRequestBO();
		
		amortizationReqBO.setApplicationId("");
		amortizationReqBO.setRequestId("");
		amortizationReqBO.setIdProductEnd(840);
		amortizationReqBO.setCreditAmount(10000.00);
		amortizationReqBO.setNumberPayments(60);
		
		amortizationReqBO.setOpeningDate("31082011");
		
		
		amortizationReqBO.setFirstPaymentDate("15092011");
		
		amortizationReqBO.setPeriodPayments("D");
		amortizationReqBO.setFrecuencyPayments(15);
		amortizationReqBO.setAnnualInterestRate(0.42);
		amortizationReqBO.setIVARate(0.16);
		amortizationReqBO.setAmountCommissionOpening(0.0);
		amortizationReqBO.setPercentageCommissionOpening(0.0);
		amortizationReqBO.setPercentageDeferredCommission(0.0);
		//amortizationReqBO.setCredit(7012);//240
		try{
		AmortizationResponseBO amortizationResponseBO = test.getAmortization(new AS400("172.16.50.241", "S620100001",
				"santafe07"),amortizationReqBO);	
		System.out.println("status::"+amortizationResponseBO.getStatus());
		System.out.println("code::"+amortizationResponseBO.getCode());
		System.out.println("response::"+amortizationResponseBO.getResponse());
		
		
		List<AmortizationRespBO> lista = amortizationResponseBO.getAmortizationRespBO();
		
		
		FormatUtils.formatoEncabezado(encabezado);
		
		for (AmortizationRespBO amortizationRespBO: lista){			
			System.out.print("|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getNumberPayments()+"",espacios," ")+"|");
			//System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getDateInitial()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getDatePayments()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getCalculationBase()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getDateInitial()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getDateEnd()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getInterestDays()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getCapitaPayments()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getInterestPayments()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getInterestPaymentsTax()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getCommissionPayment()+"",espacios," ")+"|");
			System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getCommissionPaymentTax()+"",espacios," ")+"|");
			System.out.println(FormatUtils.llenarCaracter(amortizationRespBO.getTotalPayment()+"",espacios," ")+"|");						
		}
		assertTrue(lista.size()>0);
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
	 * Exito en Amortization Catorcenal
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testStatement_TestCase3() throws RemoteException,
			MalformedURLException {
		System.out
				.println("TEST CASE 3**************************************************");
		Amortization test = new Amortization();

		AmortizationRequestBO amortizationReqBO = new AmortizationRequestBO();

		amortizationReqBO.setApplicationId("");
		amortizationReqBO.setRequestId("");
		amortizationReqBO.setIdProductEnd(840);
		amortizationReqBO.setCreditAmount(10000.00);
		amortizationReqBO.setNumberPayments(60);

		amortizationReqBO.setOpeningDate("31082011");

		amortizationReqBO.setFirstPaymentDate("14092011");

		amortizationReqBO.setPeriodPayments("D");
		amortizationReqBO.setFrecuencyPayments(14);
		amortizationReqBO.setAnnualInterestRate(0.42);
		amortizationReqBO.setIVARate(0.16);
		amortizationReqBO.setAmountCommissionOpening(0.0);
		amortizationReqBO.setPercentageCommissionOpening(0.0);
		amortizationReqBO.setPercentageDeferredCommission(0.0);
		// amortizationReqBO.setCredit(7012);//240
		try {
			AmortizationResponseBO amortizationResponseBO = test
					.getAmortization(new AS400("172.16.50.241", "S620100001",
							"santafe07"), amortizationReqBO);
			System.out.println("status::" + amortizationResponseBO.getStatus());
			System.out.println("code::" + amortizationResponseBO.getCode());
			System.out.println("response::"
					+ amortizationResponseBO.getResponse());

			List<AmortizationRespBO> lista = amortizationResponseBO
					.getAmortizationRespBO();

			
			FormatUtils.formatoEncabezado(encabezado);

			for (AmortizationRespBO amortizationRespBO : lista) {
				System.out.print("|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getNumberPayments() + "", espacios,
						" ") + "|");
				// System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getDateInitial()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getDatePayments() + "", espacios,
						" ") + "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getCalculationBase() + "", espacios,
						" ") + "|");
				System.out
						.print(FormatUtils.llenarCaracter(
								amortizationRespBO.getDateInitial() + "",
								espacios, " ") + "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getDateEnd() + "", espacios, " ")
						+ "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getInterestDays() + "", espacios,
						" ") + "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getCapitaPayments() + "", espacios,
						" ") + "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getInterestPayments() + "",
						espacios, " ") + "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getInterestPaymentsTax() + "",
						espacios, " ") + "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getCommissionPayment() + "",
						espacios, " ") + "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getCommissionPaymentTax() + "",
						espacios, " ") + "|");
				System.out.println(FormatUtils.llenarCaracter(
						amortizationRespBO.getTotalPayment() + "", espacios,
						" ")
						+ "|");
			}
			assertTrue(lista.size() > 0);
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
	 * Exito en Amortization Semanal
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testStatement_TestCase4() throws RemoteException,
			MalformedURLException {
		System.out
				.println("TEST CASE 4**************************************************");
		Amortization test = new Amortization();

		AmortizationRequestBO amortizationReqBO = new AmortizationRequestBO();

		amortizationReqBO.setApplicationId("");
		amortizationReqBO.setRequestId("");
		amortizationReqBO.setIdProductEnd(840);
		amortizationReqBO.setCreditAmount(10000.00);
		amortizationReqBO.setNumberPayments(60);

		amortizationReqBO.setOpeningDate("31082011");

		amortizationReqBO.setFirstPaymentDate("07092011");

		amortizationReqBO.setPeriodPayments("D");
		amortizationReqBO.setFrecuencyPayments(7);
		amortizationReqBO.setAnnualInterestRate(0.42);
		amortizationReqBO.setIVARate(0.16);
		amortizationReqBO.setAmountCommissionOpening(0.0);
		amortizationReqBO.setPercentageCommissionOpening(0.0);
		amortizationReqBO.setPercentageDeferredCommission(0.0);
		// amortizationReqBO.setCredit(7012);//240
		try {
			AmortizationResponseBO amortizationResponseBO = test
					.getAmortization(new AS400("172.16.50.241", "S620100001",
							"santafe07"), amortizationReqBO);
			System.out.println("status::" + amortizationResponseBO.getStatus());
			System.out.println("code::" + amortizationResponseBO.getCode());
			System.out.println("response::"
					+ amortizationResponseBO.getResponse());

			List<AmortizationRespBO> lista = amortizationResponseBO
					.getAmortizationRespBO();

		
			FormatUtils.formatoEncabezado(encabezado);

			for (AmortizationRespBO amortizationRespBO : lista) {
				
				System.out.print("|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getNumberPayments() + "", espacios,
						" ") + "|");
				// System.out.print(FormatUtils.llenarCaracter(amortizationRespBO.getDateInitial()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getDatePayments() + "", espacios,
						" ") + "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getCalculationBase() + "", espacios,
						" ") + "|");
				System.out
						.print(FormatUtils.llenarCaracter(
								amortizationRespBO.getDateInitial() + "",
								espacios, " ") + "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getDateEnd() + "", espacios, " ")
						+ "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getInterestDays() + "", espacios,
						" ") + "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getCapitaPayments() + "", espacios,
						" ") + "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getInterestPayments() + "",
						espacios, " ") + "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getInterestPaymentsTax() + "",
						espacios, " ") + "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getCommissionPayment() + "",
						espacios, " ") + "|");
				System.out.print(FormatUtils.llenarCaracter(
						amortizationRespBO.getCommissionPaymentTax() + "",
						espacios, " ") + "|");
				System.out.println(FormatUtils.llenarCaracter(
						amortizationRespBO.getTotalPayment() + "", espacios,
						" ")
						+ "|");
			}
			assertTrue(lista.size() > 0);
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
	 * Exito en Amortization Semanal
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testStatement_TestCase5() throws RemoteException,
			MalformedURLException {
		System.out
				.println("TEST CASE 5**************************************************");
		Amortization test = new Amortization();

		AmortizationRequestBO amortizationReqBO = new AmortizationRequestBO();

		amortizationReqBO.setApplicationId("");
		amortizationReqBO.setRequestId("");
		amortizationReqBO.setIdProductEnd(870);
		amortizationReqBO.setCreditAmount(10000.00);
		amortizationReqBO.setNumberPayments(60);

		amortizationReqBO.setOpeningDate("31082011");

		amortizationReqBO.setFirstPaymentDate("07092011");

		amortizationReqBO.setPeriodPayments("D");
		amortizationReqBO.setFrecuencyPayments(7);
		amortizationReqBO.setAnnualInterestRate(0.42);
		amortizationReqBO.setIVARate(0.16);
		amortizationReqBO.setAmountCommissionOpening(0.0);
		amortizationReqBO.setPercentageCommissionOpening(0.0);
		amortizationReqBO.setPercentageDeferredCommission(0.0);
		// amortizationReqBO.setCredit(7012);//240
		try {
			AmortizationResponseBO amortizationResponseBO = test
					.getAmortization(new AS400("172.16.50.241", "S620100001",
							"santafe07"), amortizationReqBO);
			System.out.println("status::" + amortizationResponseBO.getStatus());
			System.out.println("code::" + amortizationResponseBO.getCode());
			System.out.println("response::"
					+ amortizationResponseBO.getResponse());

			List<AmortizationRespBO> lista = amortizationResponseBO
					.getAmortizationRespBO();

			assertNull(lista);
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
	 * Exito en Amortization Semanal
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testStatement_TestCase6() throws RemoteException,
			MalformedURLException {
		System.out
				.println("TEST CASE 6**************************************************");
		Amortization test = new Amortization();

		AmortizationRequestBO amortizationReqBO = new AmortizationRequestBO();

		amortizationReqBO.setApplicationId("");
		amortizationReqBO.setRequestId("");
		amortizationReqBO.setIdProductEnd(840);
		amortizationReqBO.setCreditAmount(10000.00);
		amortizationReqBO.setNumberPayments(60);

		amortizationReqBO.setOpeningDate("31082011");

		amortizationReqBO.setFirstPaymentDate("07092011");

		amortizationReqBO.setPeriodPayments("L");
		amortizationReqBO.setFrecuencyPayments(7);
		amortizationReqBO.setAnnualInterestRate(0.42);
		amortizationReqBO.setIVARate(0.16);
		amortizationReqBO.setAmountCommissionOpening(0.0);
		amortizationReqBO.setPercentageCommissionOpening(0.0);
		amortizationReqBO.setPercentageDeferredCommission(0.0);
		// amortizationReqBO.setCredit(7012);//240
		try {
			AmortizationResponseBO amortizationResponseBO = test
					.getAmortization(new AS400("172.16.50.241", "S620100001",
							"santafe07"), amortizationReqBO);
			System.out.println("status::" + amortizationResponseBO.getStatus());
			System.out.println("code::" + amortizationResponseBO.getCode());
			System.out.println("response::"
					+ amortizationResponseBO.getResponse());

			List<AmortizationRespBO> lista = amortizationResponseBO
					.getAmortizationRespBO();

			assertNull(lista);
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
	 * Error en Amortization Semanal
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testStatement_TestCase7() throws RemoteException,
			MalformedURLException {
		System.out
				.println("TEST CASE 7**************************************************");
		Amortization test = new Amortization();

		AmortizationRequestBO amortizationReqBO = new AmortizationRequestBO();

		amortizationReqBO.setApplicationId("");
		amortizationReqBO.setRequestId("");
		amortizationReqBO.setIdProductEnd(840);
		amortizationReqBO.setCreditAmount(10000.00);
		amortizationReqBO.setNumberPayments(0);

		amortizationReqBO.setOpeningDate("31082011");

		amortizationReqBO.setFirstPaymentDate("07092011");

		amortizationReqBO.setPeriodPayments("D");
		amortizationReqBO.setFrecuencyPayments(7);
		amortizationReqBO.setAnnualInterestRate(0.42);
		amortizationReqBO.setIVARate(0.16);
		amortizationReqBO.setAmountCommissionOpening(0.0);
		amortizationReqBO.setPercentageCommissionOpening(0.0);
		amortizationReqBO.setPercentageDeferredCommission(0.0);
		// amortizationReqBO.setCredit(7012);//240
		try {
			AmortizationResponseBO amortizationResponseBO = test
					.getAmortization(new AS400("172.16.50.241", "S620100001",
							"santafe07"), amortizationReqBO);
			System.out.println("status::" + amortizationResponseBO.getStatus());
			System.out.println("code::" + amortizationResponseBO.getCode());
			System.out.println("response::"
					+ amortizationResponseBO.getResponse());

			List<AmortizationRespBO> lista = amortizationResponseBO
					.getAmortizationRespBO();

			assertNull(lista);
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
	 * Error en Amortization Semanal
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testStatement_TestCase8() throws RemoteException,
			MalformedURLException {
		System.out
				.println("TEST CASE 8**************************************************");
		Amortization test = new Amortization();

		AmortizationRequestBO amortizationReqBO = new AmortizationRequestBO();

		amortizationReqBO.setApplicationId("");
		amortizationReqBO.setRequestId("");
		amortizationReqBO.setIdProductEnd(840);
		amortizationReqBO.setCreditAmount(10000.00);
		amortizationReqBO.setNumberPayments(60);

		amortizationReqBO.setOpeningDate("31122011");

		amortizationReqBO.setFirstPaymentDate("07092011");

		amortizationReqBO.setPeriodPayments("D");
		amortizationReqBO.setFrecuencyPayments(7);
		amortizationReqBO.setAnnualInterestRate(0.42);
		amortizationReqBO.setIVARate(0.16);
		amortizationReqBO.setAmountCommissionOpening(0.0);
		amortizationReqBO.setPercentageCommissionOpening(0.0);
		amortizationReqBO.setPercentageDeferredCommission(0.0);
		// amortizationReqBO.setCredit(7012);//240
		try {
			AmortizationResponseBO amortizationResponseBO = test
					.getAmortization(new AS400("172.16.50.241", "S620100001",
							"santafe07"), amortizationReqBO);
			System.out.println("status::" + amortizationResponseBO.getStatus());
			System.out.println("code::" + amortizationResponseBO.getCode());
			System.out.println("response::"
					+ amortizationResponseBO.getResponse());

			List<AmortizationRespBO> lista = amortizationResponseBO
					.getAmortizationRespBO();

			assertNull(lista);
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
	 * Error en Amortization Semanal
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testStatement_TestCase9() throws RemoteException,
			MalformedURLException {
		System.out
				.println("TEST CASE 9**************************************************");
		Amortization test = new Amortization();

		AmortizationRequestBO amortizationReqBO = new AmortizationRequestBO();

		amortizationReqBO.setApplicationId("");
		amortizationReqBO.setRequestId("");
		amortizationReqBO.setIdProductEnd(840);
		amortizationReqBO.setCreditAmount(10000.00);
		amortizationReqBO.setNumberPayments(-1);

		amortizationReqBO.setOpeningDate("31082011");

		amortizationReqBO.setFirstPaymentDate("07092011");

		amortizationReqBO.setPeriodPayments("D");
		amortizationReqBO.setFrecuencyPayments(7);
		amortizationReqBO.setAnnualInterestRate(0.42);
		amortizationReqBO.setIVARate(0.16);
		amortizationReqBO.setAmountCommissionOpening(0.0);
		amortizationReqBO.setPercentageCommissionOpening(0.0);
		amortizationReqBO.setPercentageDeferredCommission(0.0);
		// amortizationReqBO.setCredit(7012);//240
		try {
			AmortizationResponseBO amortizationResponseBO = test
					.getAmortization(new AS400("172.16.50.241", "S620100001",
							"santafe07"), amortizationReqBO);
			System.out.println("status::" + amortizationResponseBO.getStatus());
			System.out.println("code::" + amortizationResponseBO.getCode());
			System.out.println("response::"
					+ amortizationResponseBO.getResponse());

			List<AmortizationRespBO> lista = amortizationResponseBO
					.getAmortizationRespBO();

			assertNull(lista);
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
