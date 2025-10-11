/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.liquidation;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;

import mx.com.consupago_bancofacil.icbs.interfaces.commons.bo.AccountingBucketBO;
import mx.com.consupago_bancofacil.icbs.interfaces.commons.bo.BorrowerBO;
import mx.com.consupago_bancofacil.icbs.interfaces.commons.bo.CommissionBO;
import mx.com.consupago_bancofacil.icbs.interfaces.commons.bo.LoanBO;
import mx.com.consupago_bancofacil.icbs.interfaces.commons.bo.TransactionBO;
import mx.com.consupago_bancofacil.icbs.interfaces.liquidation.bo.ComisionBO;
import mx.com.consupago_bancofacil.icbs.interfaces.liquidation.bo.CreditBO;
import mx.com.consupago_bancofacil.icbs.interfaces.liquidation.bo.LiquidationRequestBO;
import mx.com.consupago_bancofacil.icbs.interfaces.liquidation.bo.LiquidationResponseBO;
import mx.com.consupago_bancofacil.icbs.interfaces.liquidation.bo.MontoAPagarBO;
import mx.com.consupago_bancofacil.icbs.interfaces.liquidation.bo.MontoAplicadoBO;
import mx.com.consupago_bancofacil.icbs.interfaces.liquidation.bo.MontoDescuentoBO;
import mx.com.consupago_bancofacil.icbs.interfaces.liquidation.impl.Liquidation;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;



/**
 * @author Mfinis
 *
 */
public class LiquidationTest {
	
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
		public void testLiquidation_TestCase1() throws RemoteException,
				MalformedURLException {
			System.out
					.println("TEST CASE 1**************************************************");
			Liquidation test = new Liquidation();

			LiquidationRequestBO liquidationRequestBO = new LiquidationRequestBO();

			liquidationRequestBO.setApplicationId("");
			liquidationRequestBO.setRequestId("");
			liquidationRequestBO.setCreditId(5075154L);// 2285745,2305768,4160278,4160287 -,1619136,1638761, 1531447
			//liquidationRequestBO.setCreditId(1638761l);
			liquidationRequestBO.setTipoCarta("DEFINITIVA");
//			liquidationRequestBO.setTipoCarta("CNCA");
			//liquidationRequestBO.setRequestDate("        ");
			liquidationRequestBO.setRequestDate("20170202");
			//liquidationRequestBO.setCreditId(486644l);
			//liquidationRequestBO.setCreditId(1558089l);
			//liquidationRequestBO.setCreditId(471724l);
			//liquidationRequestBO.setCreditId(466113l);
			//liquidationRequestBO.setCreditId(977130l);
			//liquidationRequestBO.setCreditId(977103l);
			//liquidationRequestBO.setCreditId(30300l);
			//liquidationRequestBO.setCreditId(101022l);
			//liquidationRequestBO.setCreditId(1l);
			
			LiquidationResponseBO liquidationResponseBO;
			try {
				//liquidationResponseBO = test.getLiquidation(new AS400("172.16.50.241",
				//		"S620100002", "santafe07"), liquidationRequestBO);
				liquidationResponseBO = test.getLiquidation(new AS400("172.16.50.245", "S620100013","S620100013"), liquidationRequestBO);
				//liquidationResponseBO = test.getLiquidation(new AS400("172.16.40.241",
				//				"S620100003", "santafe123"), liquidationRequestBO);
				
				System.out.println(":::Salida:::"+liquidationResponseBO.toString());
				System.out.println("status::" + liquidationResponseBO.getStatus());
				System.out.println("code::" + liquidationResponseBO.getCode());
				System.out.println("response::" + liquidationResponseBO.getResponse());
				System.out.println("requestDate::" + liquidationResponseBO.getRequestDate());

				BorrowerBO borrowerBO = liquidationResponseBO.getBorrowerBO();

				System.out.println("borrowerId:" + borrowerBO.getBorrowerId());
				System.out
						.println("parternalName:" + borrowerBO.getPaternalName());
				System.out.println("maternalName:" + borrowerBO.getMaternalName());
				System.out.println("firstName:" + borrowerBO.getFirstName());

				LoanBO loanBO = liquidationResponseBO.getLoanBO();

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
				
				System.out.println("Convenio -Activo-:"+liquidationResponseBO.getCreditBO().getConvenioBO().getActivo());
				System.out.println("Convenio -Clave-:"+liquidationResponseBO.getCreditBO().getConvenioBO().getClave());
				System.out.println("Convenio -Fecha Fin Vigencia-:"+liquidationResponseBO.getCreditBO().getConvenioBO().getFechaFinVigencia());
				
				CreditBO creditBO = liquidationResponseBO.getCreditBO();
				
				//CreditBO
				System.out.println("dias atraso:"+creditBO.getDiasAtraso());
				System.out.println("fecha Expiracion:"+creditBO.getFechaExpiracion());
				System.out.println("fecha Formalizacion:"+creditBO.getFechaFormalizacion());
				System.out.println("fecha 1er Pago:"+creditBO.getFechaPrimerPago());
				System.out.println("fecha ultimo Pago:"+creditBO.getFechaUltimoPago());
				System.out.println("frecuencia Pago:"+creditBO.getFrecuenciaPago());
				System.out.println("Id Estatus:"+creditBO.getIdEstatus());
				System.out.println("Interes Devengado:"+creditBO.getInteresDevengado());
				System.out.println("Interes No Devengado:"+creditBO.getInteresNoDevengado());
				
				MontoAplicadoBO montoAplicadoBO = liquidationResponseBO.getMontoAplicadoBO();
				
				//Monto Aplicado
				System.out.println("Capital Aplicado:"+montoAplicadoBO.getCapitalAplicado());
				System.out.println("InteresAplicado:"+montoAplicadoBO.getInteresAplicado());
				System.out.println("IvaAplicado:"+montoAplicadoBO.getIvaAplicado());
				
				MontoDescuentoBO montoDescuentoBO = liquidationResponseBO.getMontoDescuentoBO();
				
				//Monto Descuento
				System.out.println("Capital Aplicado Des:"+montoDescuentoBO.getCapitalDescuento());
				System.out.println("InteresAplicado Des:"+montoDescuentoBO.getInteresDescuento());
				System.out.println("IvaAplicado Des:"+montoDescuentoBO.getIvaDescuento());
				
				
				MontoAPagarBO montoAPagarBO = liquidationResponseBO.getMontoAPagarBO();
				//Monto A Pagar
				System.out.println("Capital A Pagar:"+montoAPagarBO.getCapitalAPagar());
				System.out.println("InteresAplicado A Pagar:"+montoAPagarBO.getInteresAPagar());
				System.out.println("IvaAplicado A Pagar:"+montoAPagarBO.getIvaAPagar());				
				
				//creditBO
				System.out.println("companyCode:" +creditBO.getPagosTransito());
				System.out.println("pagoVoluntario:" +creditBO.getPagoVoluntario());
				System.out.println("Ratificado:"+creditBO.getRatificado());
				System.out.println("Tasa Iva:"+creditBO.getTasaIva());
				System.out.println("Tasa Interes:"+creditBO.getTasaInteres());
				System.out.println("Quebranto:"+creditBO.getTieneQuebranto());
				System.out.println("Aplicado N Meses:"+creditBO.getTotalAplicadoNMeses());
				System.out.println("PortafolioId:"+creditBO.getPortafolioId());
				System.out.println("PortafolioNM:"+creditBO.getPortafolioNm());

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

				List<TransactionBO> listTransactionBO = liquidationResponseBO
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
				
				List<ComisionBO> listComisionBO = liquidationResponseBO.getComision();

				for (ComisionBO comisionBO : listComisionBO) {
					System.out.println("Tipo:"+ comisionBO.getTipo());
					System.out.println("Iva:" + comisionBO.getIva());
					System.out.println("Monto:"+ comisionBO.getMonto());					
				}
				
				List<ComisionBO> listComisionABO = liquidationResponseBO.getComisionA();

				for (ComisionBO comisionABO : listComisionABO) {
					System.out.println("Tipo A:"+ comisionABO.getTipo());
					System.out.println("Iva A:" + comisionABO.getIva());
					System.out.println("Monto A:"+ comisionABO.getMonto());					
				}
				
				List<ComisionBO> listComisionDBO = liquidationResponseBO.getComisionD();

				for (ComisionBO comisionDBO : listComisionDBO) {
					System.out.println("Tipo D:"+ comisionDBO.getTipo());
					System.out.println("Iva D:" + comisionDBO.getIva());
					System.out.println("Monto D:"+ comisionDBO.getMonto());					
				}

				List<ComisionBO> listComisionPBO = liquidationResponseBO.getComisionP();

				for (ComisionBO comisionPBO : listComisionPBO) {
					System.out.println("Tipo P:"+ comisionPBO.getTipo());
					System.out.println("Iva P:" + comisionPBO.getIva());
					System.out.println("Monto P:"+ comisionPBO.getMonto());					
				}

				System.out.println("Empresa Actual:"+ creditBO.getIdCurrentOwner());	

				assertNotNull(liquidationResponseBO);
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
		 * Error en Statement
		 * .
		 * @throws MalformedURLException 
		 * @throws RemoteException 
		 */
		/*@Test
		public void testLiquidation_TestCase2() throws RemoteException,
				MalformedURLException {
			System.out
					.println("TEST CASE 2**************************************************");
			Liquidation test = new Liquidation();

			LiquidationRequestBO liquidationRequestBO = new LiquidationRequestBO();

			liquidationRequestBO.setApplicationId("");
			liquidationRequestBO.setRequestId("");
			liquidationRequestBO.setCreditId(0L);			
			
			LiquidationResponseBO liquidationResponseBO;
			try {
				liquidationResponseBO = test.getLiquidation(new AS400("172.16.50.241",
						"S620100001", "santafe07"), liquidationRequestBO);

				System.out.println("status::" + liquidationResponseBO.getStatus());
				System.out.println("code::" + liquidationResponseBO.getCode());
				System.out.println("response::" + liquidationResponseBO.getResponse());
				

				assertNotNull(liquidationResponseBO);
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
		 * Error en Statement
		 * .
		 * @throws MalformedURLException 
		 * @throws RemoteException 
		 */
		/*@Test
		public void testLiquidation_TestCase3() throws RemoteException,
				MalformedURLException {
			System.out
					.println("TEST CASE 3**************************************************");
			Liquidation test = new Liquidation();

			LiquidationRequestBO liquidationRequestBO = new LiquidationRequestBO();

			liquidationRequestBO.setApplicationId("");
			liquidationRequestBO.setRequestId("");
			liquidationRequestBO.setCreditId(-1L);			
			
			LiquidationResponseBO liquidationResponseBO;
			try {
				liquidationResponseBO = test.getLiquidation(new AS400("172.16.50.241",
						"S620100001", "santafe07"), liquidationRequestBO);

				System.out.println("status::" + liquidationResponseBO.getStatus());
				System.out.println("code::" + liquidationResponseBO.getCode());
				System.out.println("response::" + liquidationResponseBO.getResponse());
				

				assertNotNull(liquidationResponseBO);
			} catch (AS400Exception e) {				
				e.printStackTrace();
			} catch (ICBSInterfaceException e) {				
				e.printStackTrace();
			} catch (AS400ICBSInterfaceException e) {				
				e.printStackTrace();
			} catch (Exception e) {				
				e.printStackTrace();
			}
			
		}*/
		
}
