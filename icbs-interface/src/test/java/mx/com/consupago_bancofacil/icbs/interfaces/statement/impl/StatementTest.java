/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.statement.impl;

import static org.junit.Assert.assertNotNull;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import mx.com.consupago_bancofacil.icbs.interfaces.commons.bo.AccountingBucketBO;
import mx.com.consupago_bancofacil.icbs.interfaces.commons.bo.BorrowerBO;
import mx.com.consupago_bancofacil.icbs.interfaces.commons.bo.CommissionBO;
import mx.com.consupago_bancofacil.icbs.interfaces.commons.bo.LoanBO;
import mx.com.consupago_bancofacil.icbs.interfaces.commons.bo.TransactionBO;
import mx.com.consupago_bancofacil.icbs.interfaces.statement.bo.StatementRequestBO;
import mx.com.consupago_bancofacil.icbs.interfaces.statement.bo.StatementResponseBO;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;

/**
 * @author Mfinis
 * 
 */
public class StatementTest {

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
	 * Exito en Statement
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	@Test
	public void testStatement_TestCase1() throws RemoteException,
			MalformedURLException {
		System.out
				.println("TEST CASE 1**************************************************");
		Statement test = new Statement();

		StatementRequestBO statementReqBO = new StatementRequestBO();

		statementReqBO.setApplicationId("");
		statementReqBO.setRequestId("");
		statementReqBO.setCredit(1366125L);//50005491,41472,789817
		//statementReqBO.setCredit(101022l);// 240,
		//statementReqBO.setCredit(46354l);// 240,
		// statementReqBO.setCredit(1200l);

		StatementResponseBO statementResponseBO;
		try {
			//statementResponseBO = test.getStatement(new AS400("172.16.50.241",
			//		"S620100003", "santafe07"), statementReqBO);
			
			// QA
			statementResponseBO = test.getStatement(new AS400("172.16.50.245", "S620100003", "santafe07"), statementReqBO);

			// PROD
//			statementResponseBO = test.getStatement(new AS400("172.16.50.245", "S620100013","S620100013"), statementReqBO);
			
			System.out.println("status::" + statementResponseBO.getStatus());
			System.out.println("code::" + statementResponseBO.getCode());
			System.out
					.println("response::" + statementResponseBO.getResponse());
			
			System.out
			.println("CurrentBalance::" + statementResponseBO.getCurrentBalance());
			System.out
			.println("CapitalBalance::" + statementResponseBO.getCapitalBalance());
			System.out
			.println("InterestBalance::" + statementResponseBO.getInterestBalance());

			BorrowerBO borrowerBO = statementResponseBO.getBorrowerBO();

			System.out.println("borrowerId:" + borrowerBO.getBorrowerId());
			System.out
					.println("parternalName:" + borrowerBO.getPaternalName());
			System.out.println("maternalName:" + borrowerBO.getMaternalName());
			System.out.println("firstName:" + borrowerBO.getFirstName());

			LoanBO loanBO = statementResponseBO.getLoanBO();

			System.out.println("companyCode:" + loanBO.getCompanyCode());
			System.out.println("convenioID:" + loanBO.getConvenioID());
			System.out.println("convenioName:" + loanBO.getConvenioName());
			System.out.println("formalizationDate:"
					+ loanBO.getFormalizationDate());
			System.out
					.println("requestedAmount:" + loanBO.getRequestedAmount());
			System.out.println("operationType:" + loanBO.getOperationType());
			System.out.println("bankName:" + loanBO.getBankName());
			System.out.println("totalPaymentsNumber:"
					+ loanBO.getTotalPaymentsNumber());
			System.out.println("paymentsNumber:" + loanBO.getPaymentsNumber());
			System.out.println("paymentFrequencyName:"
					+ loanBO.getPaymentFrequencyName());
			System.out.println("paymentAmount:" + loanBO.getPaymentAmount());
			System.out.println("currencyName:" + loanBO.getCurrencyName());
			System.out.println("anualInterestRate:"
					+ loanBO.getAnualInterestRate());
			System.out.println("anualInterestMoratorioRate:"
					+ loanBO.getAnualInterestMoratorioRate());
			System.out.println("montoBaseInteresOrdinario:"
					+ loanBO.getMontoBaseInteresOrdinario());
			System.out.println("montoBaseInteresMoratorio:"
					+ loanBO.getMontoBaseInteresMoratorio());
			System.out.println("vatRate:" + loanBO.getVatRate());
			System.out.println("quebranto:" + loanBO.getQuebranto());

			List<CommissionBO> listCommisionBO = loanBO.getCommissionBO();

			for (CommissionBO commissionBO : listCommisionBO) {
				System.out.println("commissionName:"
						+ commissionBO.getCommissionName());
				System.out
						.println("IsDeferred:" + commissionBO.getIsDeferred());
				System.out.println("commissionAmount:"
						+ commissionBO.getCommissionAmount());
				System.out.println("commissionDate:"
						+ commissionBO.getCommissionDate());
				System.out.println("commissionCurrencyName:"
						+ commissionBO.getCommissionCurrencyName());
			}

			List<AccountingBucketBO> listAccountingBucketBO = loanBO
					.getAccountingBucketBO();
			for (AccountingBucketBO accountingBucketBO : listAccountingBucketBO) {
				System.out.println("bucketName:"
						+ accountingBucketBO.getBucketName());
				System.out.println("totalPaymentAmount:"
						+ accountingBucketBO.getTotalPaymentAmount());
				System.out.println("totalPaidAmount:"
						+ accountingBucketBO.getTotalPaidAmount());
				System.out.println("totalBalanceAmount:"
						+ accountingBucketBO.getTotalBalanceAmount());
			}

			List<TransactionBO> listTransactionBO = statementResponseBO
					.getTransactionBO();

			for (TransactionBO transactionBO : listTransactionBO) {
				System.out.println("transactionNumber:"
						+ transactionBO.getTransactionNumber());
				System.out.println("transactionDate:"
						+ transactionBO.getTransactionDate());
				System.out.println("postingDate:"
						+ transactionBO.getPostingDate());
				System.out.println("transactionName:"
						+ transactionBO.getTransactionName());
				System.out.println("transactionAmount:"
						+ transactionBO.getTransactionAmount());
				System.out.println("prinicpalAmount:"
						+ transactionBO.getPrinicpalAmount());
				System.out.println("interestAmount:"
						+ transactionBO.getInterestAmount());
				System.out.println("interestTaxAmount:"
						+ transactionBO.getInterestTaxAmount());
				System.out.println("delinquebcyAmount:"
						+ transactionBO.getDelinquebcyAmount());
				System.out.println("delinquebcyTaxAmount:"
						+ transactionBO.getDelinquebcyTaxAmount());
				System.out.println("commission1Amount:"
						+ transactionBO.getCommission1Amount());
				System.out.println("commission1TaxAmount:"
						+ transactionBO.getCommission1TaxAmount());
				System.out.println("commission2Amount:"
						+ transactionBO.getCommission2Amount());
				System.out.println("commission2TaxAmount:"
						+ transactionBO.getCommission2TaxAmount());
				System.out.println("commission3Amount:"
						+ transactionBO.getCommission3Amount());
				System.out.println("commission3TaxAmount:"
						+ transactionBO.getCommission3TaxAmount());
				System.out.println("insuranceAmount:"
						+ transactionBO.getInsuranceAmount());
				System.out.println("insuranceTaxAmount:"
						+ transactionBO.getInsuranceTaxAmount());
				System.out.println("transactionId:"
						+ transactionBO.getTransactionId());
			}
			
			System.out.println("Saldo Remanente::" + statementResponseBO.getSaldoRemanente());
			
			assertNotNull(statementResponseBO);
		} catch (AS400Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AS400ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	/**
	 * Exito statement
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testStatement_TestCase2() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 2**************************************************");
		Statement test = new Statement();
		
		StatementRequestBO statementReqBO = new StatementRequestBO();
		
		statementReqBO.setApplicationId("");
		statementReqBO.setRequestId("");
		//statementReqBO.setCredit(101022l);//240,
		statementReqBO.setCredit(71664l);
		
		StatementResponseBO statementResponseBO;
		try {
			statementResponseBO = test.getStatement(new AS400("172.16.50.241", "S620100001",
					"santafe07"),statementReqBO);
			
		System.out.println("status::"+statementResponseBO.getStatus());
		System.out.println("code::"+statementResponseBO.getCode());
		System.out.println("response::"+statementResponseBO.getResponse());
		
		BorrowerBO borrowerBO = statementResponseBO.getBorrowerBO();
		
		System.out.println("borrowerId:"+borrowerBO.getBorrowerId());
		System.out.println("parternalName:"+borrowerBO.getPaternalName());
		System.out.println("maternalName:"+borrowerBO.getMaternalName());
		System.out.println("firstName:"+borrowerBO.getFirstName());
		
		LoanBO loanBO = statementResponseBO.getLoanBO();
		
		System.out.println("companyCode:"+loanBO.getCompanyCode());
		System.out.println("convenioID:"+loanBO.getConvenioID());
		System.out.println("convenioName:"+loanBO.getConvenioName());
		System.out.println("formalizationDate:"+loanBO.getFormalizationDate());
		System.out.println("requestedAmount:"+loanBO.getRequestedAmount());
		System.out.println("operationType:"+loanBO.getOperationType());
		System.out.println("bankName:"+loanBO.getBankName());
		System.out.println("totalPaymentsNumber:"+loanBO.getTotalPaymentsNumber());
		System.out.println("paymentsNumber:"+loanBO.getPaymentsNumber());
		System.out.println("paymentFrequencyName:"+loanBO.getPaymentFrequencyName());
		System.out.println("paymentAmount:"+loanBO.getPaymentAmount());
		System.out.println("currencyName:"+loanBO.getCurrencyName());
		System.out.println("anualInterestRate:"+loanBO.getAnualInterestRate());
		System.out.println("anualInterestMoratorioRate:"+loanBO.getAnualInterestMoratorioRate());
		System.out.println("montoBaseInteresOrdinario:"+loanBO.getMontoBaseInteresOrdinario());
		System.out.println("montoBaseInteresMoratorio:"+loanBO.getMontoBaseInteresMoratorio());
		System.out.println("vatRate:"+loanBO.getVatRate());
		
		List<CommissionBO> listCommisionBO = loanBO.getCommissionBO();
		
		for (CommissionBO commissionBO:listCommisionBO){
			System.out.println("commissionName:"+commissionBO.getCommissionName());
			System.out.println("IsDeferred:"+commissionBO.getIsDeferred());
			System.out.println("commissionAmount:"+commissionBO.getCommissionAmount());
			System.out.println("commissionDate:"+commissionBO.getCommissionDate());
			System.out.println("commissionCurrencyName:"+commissionBO.getCommissionCurrencyName());
		}

		List<AccountingBucketBO> listAccountingBucketBO = loanBO.getAccountingBucketBO();
		for (AccountingBucketBO accountingBucketBO:listAccountingBucketBO){
			System.out.println("bucketName:"+accountingBucketBO.getBucketName());
			System.out.println("totalPaymentAmount:"+accountingBucketBO.getTotalPaymentAmount());
			System.out.println("totalPaidAmount:"+accountingBucketBO.getTotalPaidAmount());
			System.out.println("totalBalanceAmount:"+accountingBucketBO.getTotalBalanceAmount());
		}
		
		List<TransactionBO> listTransactionBO = statementResponseBO.getTransactionBO();
		
		
		for (TransactionBO transactionBO:listTransactionBO){
			System.out.println("transactionNumber:"+transactionBO.getTransactionNumber());
			System.out.println("transactionDate:"+transactionBO.getTransactionDate());
			System.out.println("postingDate:"+transactionBO.getPostingDate());
			System.out.println("transactionName:"+transactionBO.getTransactionName());
			System.out.println("transactionAmount:"+transactionBO.getTransactionAmount());
			System.out.println("prinicpalAmount:"+transactionBO.getPrinicpalAmount());
			System.out.println("interestAmount:"+transactionBO.getInterestAmount());
			System.out.println("interestTaxAmount:"+transactionBO.getInterestTaxAmount());
			System.out.println("delinquebcyAmount:"+transactionBO.getDelinquebcyAmount());
			System.out.println("delinquebcyTaxAmount:"+transactionBO.getDelinquebcyTaxAmount());
			System.out.println("commission1Amount:"+transactionBO.getCommission1Amount());
			System.out.println("commission1TaxAmount:"+transactionBO.getCommission1TaxAmount());
			System.out.println("commission2Amount:"+transactionBO.getCommission2Amount());
			System.out.println("commission2TaxAmount:"+transactionBO.getCommission2TaxAmount());
			System.out.println("commission3Amount:"+transactionBO.getCommission3Amount());
			System.out.println("commission3TaxAmount:"+transactionBO.getCommission3TaxAmount());
			System.out.println("insuranceAmount:"+transactionBO.getInsuranceAmount());
			System.out.println("insuranceTaxAmount:"+transactionBO.getInsuranceTaxAmount());
		}
		assertNotNull(statementResponseBO);
		//assertTrue(lista.size()>0);
		
		} catch (AS400Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AS400ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
	/**
	 * Exito statement
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testStatement_TestCase3() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 3**************************************************");
		Statement test = new Statement();
		StatementRequestBO statementReqBO = new StatementRequestBO();
		
		statementReqBO.setApplicationId("");
		statementReqBO.setRequestId("");
		//statementReqBO.setCredit(101022l);//240,
		statementReqBO.setCredit(46354l);
		
		StatementResponseBO statementResponseBO;
		try {
			statementResponseBO = test.getStatement(new AS400("172.16.50.241", "S620100001",
					"santafe07"),statementReqBO);
		
		
		System.out.println("status::"+statementResponseBO.getStatus());
		System.out.println("code::"+statementResponseBO.getCode());
		System.out.println("response::"+statementResponseBO.getResponse());
		
		BorrowerBO borrowerBO = statementResponseBO.getBorrowerBO();
		
		System.out.println("borrowerId:"+borrowerBO.getBorrowerId());
		System.out.println("parternalName:"+borrowerBO.getPaternalName());
		System.out.println("maternalName:"+borrowerBO.getMaternalName());
		System.out.println("firstName:"+borrowerBO.getFirstName());
		
LoanBO loanBO = statementResponseBO.getLoanBO();
		
		System.out.println("companyCode:"+loanBO.getCompanyCode());
		System.out.println("convenioID:"+loanBO.getConvenioID());
		System.out.println("convenioName:"+loanBO.getConvenioName());
		System.out.println("formalizationDate:"+loanBO.getFormalizationDate());
		System.out.println("requestedAmount:"+loanBO.getRequestedAmount());
		System.out.println("operationType:"+loanBO.getOperationType());
		System.out.println("bankName:"+loanBO.getBankName());
		System.out.println("totalPaymentsNumber:"+loanBO.getTotalPaymentsNumber());
		System.out.println("paymentsNumber:"+loanBO.getPaymentsNumber());
		System.out.println("paymentFrequencyName:"+loanBO.getPaymentFrequencyName());
		System.out.println("paymentAmount:"+loanBO.getPaymentAmount());
		System.out.println("currencyName:"+loanBO.getCurrencyName());
		System.out.println("anualInterestRate:"+loanBO.getAnualInterestRate());
		System.out.println("anualInterestMoratorioRate:"+loanBO.getAnualInterestMoratorioRate());
		System.out.println("montoBaseInteresOrdinario:"+loanBO.getMontoBaseInteresOrdinario());
		System.out.println("montoBaseInteresMoratorio:"+loanBO.getMontoBaseInteresMoratorio());
		System.out.println("vatRate:"+loanBO.getVatRate());
		
		List<CommissionBO> listCommisionBO = loanBO.getCommissionBO();
		
		for (CommissionBO commissionBO:listCommisionBO){
			System.out.println("commissionName:"+commissionBO.getCommissionName());
			System.out.println("IsDeferred:"+commissionBO.getIsDeferred());
			System.out.println("commissionAmount:"+commissionBO.getCommissionAmount());
			System.out.println("commissionDate:"+commissionBO.getCommissionDate());
			System.out.println("commissionCurrencyName:"+commissionBO.getCommissionCurrencyName());
		}

		List<AccountingBucketBO> listAccountingBucketBO = loanBO.getAccountingBucketBO();
		for (AccountingBucketBO accountingBucketBO:listAccountingBucketBO){
			System.out.println("bucketName:"+accountingBucketBO.getBucketName());
			System.out.println("totalPaymentAmount:"+accountingBucketBO.getTotalPaymentAmount());
			System.out.println("totalPaidAmount:"+accountingBucketBO.getTotalPaidAmount());
			System.out.println("totalBalanceAmount:"+accountingBucketBO.getTotalBalanceAmount());
		}
		
		List<TransactionBO> listTransactionBO = statementResponseBO.getTransactionBO();
		
		
		for (TransactionBO transactionBO:listTransactionBO){
			System.out.println("transactionNumber:"+transactionBO.getTransactionNumber());
			System.out.println("transactionDate:"+transactionBO.getTransactionDate());
			System.out.println("postingDate:"+transactionBO.getPostingDate());
			System.out.println("transactionName:"+transactionBO.getTransactionName());
			System.out.println("transactionAmount:"+transactionBO.getTransactionAmount());
			System.out.println("prinicpalAmount:"+transactionBO.getPrinicpalAmount());
			System.out.println("interestAmount:"+transactionBO.getInterestAmount());
			System.out.println("interestTaxAmount:"+transactionBO.getInterestTaxAmount());
			System.out.println("delinquebcyAmount:"+transactionBO.getDelinquebcyAmount());
			System.out.println("delinquebcyTaxAmount:"+transactionBO.getDelinquebcyTaxAmount());
			System.out.println("commission1Amount:"+transactionBO.getCommission1Amount());
			System.out.println("commission1TaxAmount:"+transactionBO.getCommission1TaxAmount());
			System.out.println("commission2Amount:"+transactionBO.getCommission2Amount());
			System.out.println("commission2TaxAmount:"+transactionBO.getCommission2TaxAmount());
			System.out.println("commission3Amount:"+transactionBO.getCommission3Amount());
			System.out.println("commission3TaxAmount:"+transactionBO.getCommission3TaxAmount());
			System.out.println("insuranceAmount:"+transactionBO.getInsuranceAmount());
			System.out.println("insuranceTaxAmount:"+transactionBO.getInsuranceTaxAmount());
		}
		assertNotNull(statementResponseBO);
		
		assertNotNull(statementResponseBO);
		} catch (AS400Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AS400ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
	/**
	 * Exito statement
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testStatement_TestCase4() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 4**************************************************");		
		Statement test = new Statement();
		StatementRequestBO statementReqBO = new StatementRequestBO();
		
		statementReqBO.setApplicationId("");
		statementReqBO.setRequestId("");
		//statementReqBO.setCredit(101022l);//240,
		statementReqBO.setCredit(-0l);
		
		StatementResponseBO statementResponseBO;
		try {
			statementResponseBO = test.getStatement(new AS400("172.16.50.241", "S620100001",
					"santafe07"),statementReqBO);
		
		
		System.out.println("status::"+statementResponseBO.getStatus());
		System.out.println("code::"+statementResponseBO.getCode());
		System.out.println("response::"+statementResponseBO.getResponse());
		
		BorrowerBO borrowerBO = statementResponseBO.getBorrowerBO();
		
		System.out.println("borrowerId:"+borrowerBO.getBorrowerId());
		System.out.println("parternalName:"+borrowerBO.getPaternalName());
		System.out.println("maternalName:"+borrowerBO.getMaternalName());
		System.out.println("firstName:"+borrowerBO.getFirstName());
		
		assertNotNull(statementResponseBO);
		} catch (AS400Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AS400ICBSInterfaceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
	
	/**
	 * Exito statement
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testStatement_TestCase5() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 5**************************************************");
		Statement test = new Statement();
		
		
		
		
		StatementRequestBO statementReqBO = new StatementRequestBO();
		
		statementReqBO.setApplicationId("");
		statementReqBO.setRequestId("");
		statementReqBO.setCredit(999999999999l);//5012  y 5011
		
		StatementResponseBO statementResponseBO = test.getStatement(new AS400("172.16.50.241", "S620100001",
				"santafe07"),statementReqBO);	
		System.out.println("status::"+statementResponseBO.getStatus());
		System.out.println("code::"+statementResponseBO.getCode());
		System.out.println("response::"+statementResponseBO.getResponse());
		System.out.println("fecha Emision::"+statementResponseBO.getIssuanceDate());
		System.out.println("Cuenta::"+statementResponseBO.getAccount());
		System.out.println("Nombre::"+statementResponseBO.getName());
		System.out.println("Credito::"+statementResponseBO.getCredit());
		System.out.println("Dependencia:"+statementResponseBO.getDependence());
		System.out.println("fecha Formalizacion::"+statementResponseBO.getCompletionDate());
		System.out.println("Monto Disposicion::"+statementResponseBO.getDispositionAmount());
		System.out.println("Medio::"+statementResponseBO.getMiddle());
		System.out.println("Total a Pagar::"+statementResponseBO.getTotalAmountDue());	
		System.out.println("Numero Pagos::"+statementResponseBO.getNumberPayments());
		System.out.println("Descuento por periodos::"+statementResponseBO.getDiscountPeriod());
		System.out.println("Tipo de Moneda::"+statementResponseBO.getCurrency());
		System.out.println("Interes a Pagar::"+statementResponseBO.getInterestPayable());
		System.out.println("Periodicidad::"+statementResponseBO.getPeriodicity());
		System.out.println("Tasa de Interes Ord::"+statementResponseBO.getInterestRateOrd());
		System.out.println("Monto Base Interes Ord::"+statementResponseBO.getBaseAmountInterestOrd());
		System.out.println("Tasa Interes Mor:"+statementResponseBO.getInterestRateMora());
		System.out.println("Monto Base Interes Mor:"+statementResponseBO.getBaseAmountInterestMor());
		System.out.println("Comisiones:"+statementResponseBO.getComission());
		System.out.println("Comisiones Cobradas:"+statementResponseBO.getFeesCharged());
		System.out.println("Fecha de Cobro Comision:"+statementResponseBO.getDateRecoveryComission());
		System.out.println("Total Pagado:"+statementResponseBO.getTotalPaid());
		System.out.println("Saldo pendiente Total Pagado:"+statementResponseBO.getOutstandingBalance());
		System.out.println("Saldo de capital:"+statementResponseBO.getPrincipalBalance());
		System.out.println("Pagos Pendientes:"+statementResponseBO.getOutstandingPayments());
		System.out.println("IVA APLICABLE:"+statementResponseBO.getIvaApplicable());
		System.out.println("Fecha Corte:"+statementResponseBO.getCourtDate());
		System.out.println("Fecha Limite a Pagar:"+statementResponseBO.getPaymentDeadline());
		
		
		List<StatementRespBO> lista = statementResponseBO.getListStatementRespBO();
		if (lista.size()>0){
			
			FormatUtils.formatoEncabezado(encabezado);
			
			for (StatementRespBO statementRespBO: lista){
				System.out.print("|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getPaymentNumber()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getPaymentDate()+"",espacios," ")+"|");				
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getCapital()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getInterest()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getInterestIVA()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getComission()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getComissionIVA()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getTotal()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getPaymentDependecies()+"",espacios," ")+"|");
				System.out.println(FormatUtils.llenarCaracter(statementRespBO.getDescription()+"",espacios," ")+"|");		
			}
		}
		assertNotNull(lista.size());
	}*/
	
	
	/**
	 * Exito statement
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testStatement_TestCase6() throws RemoteException, MalformedURLException {
		System.out.println("TEST CASE 6**************************************************");
		Statement test = new Statement();
		
		
		
		
		StatementRequestBO statementReqBO = new StatementRequestBO();
		
		statementReqBO.setApplicationId("");
		statementReqBO.setRequestId("");
		statementReqBO.setCredit(5006l);//5012  y 5011
		
		StatementResponseBO statementResponseBO = test.getStatement(new AS400("172.16.50.241", "S620100001",
				"santafe07"),statementReqBO);	
		System.out.println("status::"+statementResponseBO.getStatus());
		System.out.println("code::"+statementResponseBO.getCode());
		System.out.println("response::"+statementResponseBO.getResponse());
		System.out.println("fecha Emision::"+statementResponseBO.getIssuanceDate());
		System.out.println("Cuenta::"+statementResponseBO.getAccount());
		System.out.println("Nombre::"+statementResponseBO.getName());
		System.out.println("Credito::"+statementResponseBO.getCredit());
		System.out.println("Dependencia:"+statementResponseBO.getDependence());
		System.out.println("fecha Formalizacion::"+statementResponseBO.getCompletionDate());
		System.out.println("Monto Disposicion::"+statementResponseBO.getDispositionAmount());
		System.out.println("Medio::"+statementResponseBO.getMiddle());
		System.out.println("Total a Pagar::"+statementResponseBO.getTotalAmountDue());	
		System.out.println("Numero Pagos::"+statementResponseBO.getNumberPayments());
		System.out.println("Descuento por periodos::"+statementResponseBO.getDiscountPeriod());
		System.out.println("Tipo de Moneda::"+statementResponseBO.getCurrency());
		System.out.println("Interes a Pagar::"+statementResponseBO.getInterestPayable());
		System.out.println("Periodicidad::"+statementResponseBO.getPeriodicity());
		System.out.println("Tasa de Interes Ord::"+statementResponseBO.getInterestRateOrd());
		System.out.println("Monto Base Interes Ord::"+statementResponseBO.getBaseAmountInterestOrd());
		System.out.println("Tasa Interes Mor:"+statementResponseBO.getInterestRateMora());
		System.out.println("Monto Base Interes Mor:"+statementResponseBO.getBaseAmountInterestMor());
		System.out.println("Comisiones:"+statementResponseBO.getComission());
		System.out.println("Comisiones Cobradas:"+statementResponseBO.getFeesCharged());
		System.out.println("Fecha de Cobro Comision:"+statementResponseBO.getDateRecoveryComission());
		System.out.println("Total Pagado:"+statementResponseBO.getTotalPaid());
		System.out.println("Saldo pendiente Total Pagado:"+statementResponseBO.getOutstandingBalance());
		System.out.println("Saldo de capital:"+statementResponseBO.getPrincipalBalance());
		System.out.println("Pagos Pendientes:"+statementResponseBO.getOutstandingPayments());
		System.out.println("IVA APLICABLE:"+statementResponseBO.getIvaApplicable());
		System.out.println("Fecha Corte:"+statementResponseBO.getCourtDate());
		System.out.println("Fecha Limite a Pagar:"+statementResponseBO.getPaymentDeadline());
		
		
		List<StatementRespBO> lista = statementResponseBO.getListStatementRespBO();
		if (lista.size()>0){
				
			FormatUtils.formatoEncabezado(encabezado);
			
			for (StatementRespBO statementRespBO: lista){
				System.out.print("|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getPaymentNumber()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getPaymentDate()+"",espacios," ")+"|");				
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getCapital()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getInterest()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getInterestIVA()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getComission()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getComissionIVA()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getTotal()+"",espacios," ")+"|");
				System.out.print(FormatUtils.llenarCaracter(statementRespBO.getPaymentDependecies()+"",espacios," ")+"|");
				System.out.println(FormatUtils.llenarCaracter(statementRespBO.getDescription()+"",espacios," ")+"|");		
			}
		}
		assertNotNull(lista.size());
	}*/
	
	
	
}
