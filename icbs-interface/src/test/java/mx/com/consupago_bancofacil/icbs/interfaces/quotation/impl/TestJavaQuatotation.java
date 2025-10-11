/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.quotation.impl;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import mx.com.consupago_bancofacil.icbs.interfaces.quotation.bo.QuotationRequestBO;
import mx.com.consupago_bancofacil.icbs.interfaces.quotation.bo.ReqQuotationBO;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import com.ibm.as400.access.AS400;
import com.ibm.as400.access.AS400Exception;

/**
 * @author M-FINIS
 *
 */
public class TestJavaQuatotation {

	/**
	 * @param args
	 */
	/*public static void main(String[] args) {
		//Test 1 prueba con 391 registros		
		Quotation test = new Quotation();
		double monto = 10000.00;		
		List<ReqQuotationBO> listaReq = new ArrayList<ReqQuotationBO>();
		Double[] InterestRate = new Double[]{0.48,0.48, 0.48, 0.48, 0.48,0.48,0.48,0.48,0.48,0.48,0.48,0.48,0.48,0.48,0.48,0.48,0.48};
		Double[] InterestRate2 = new Double[]{0.48,0.49, 0.50, 0.46, 0.48,0.48,0.48,0.48,0.48,0.48,0.48,0.48,0.48,0.48,0.48,0.48,0.48};
		
		for (int j=0; j< 2; j++){
			monto = 10000.00;
			for (int i=0; i< 3; i++){
				ReqQuotationBO reqQuotationBO = new ReqQuotationBO();			
				reqQuotationBO.setIdProductEnd(840);
				reqQuotationBO.setCreditAmount(10000.0);
				reqQuotationBO.setNumberPayments(168);//240
				reqQuotationBO.setPeriodPayments("D");
				reqQuotationBO.setFrecuencyPayments(15);
				reqQuotationBO.setAnnualInterestRate(InterestRate[j]);
				reqQuotationBO.setIVARate(0.11);
				reqQuotationBO.setAmountCommissionOpening(0.0);
				reqQuotationBO.setPercentageCommissionOpening(0.0);
				reqQuotationBO.setPercentageDeferredCommission(0.0);
				monto = monto + 500.0;
				listaReq.add(reqQuotationBO);		
			}
		}
		try {
			
			 test.getQuotation(new AS400("172.16.50.241", "S620100001","santafe07"), new QuotationRequestBO("App001", "0001", listaReq));
						
		} catch (RemoteException e) {			
			e.printStackTrace();
		} catch (MalformedURLException e) {			
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
		}*/
		
		
		/*for (int j=0; j< 17; j++){
			monto = 10000.00;
			for (int i=0; i< 7; i++){
				ReqQuotationBO reqQuotationBO = new ReqQuotationBO();			
				reqQuotationBO.setIdProductEnd(840);
				reqQuotationBO.setCreditAmount(10000.0);
				reqQuotationBO.setNumberPayments(168);//240
				reqQuotationBO.setPeriodPayments("D");
				reqQuotationBO.setFrecuencyPayments(15);
				reqQuotationBO.setAnnualInterestRate(InterestRate2[j]);
				reqQuotationBO.setIVARate(0.11);
				reqQuotationBO.setAmountCommissionOpening(0.0);
				reqQuotationBO.setPercentageCommissionOpening(0.0);
				reqQuotationBO.setPercentageDeferredCommission(0.0);
				monto = monto + 500.0;
				listaReq.add(reqQuotationBO);		
			}
		}
		try {
			test.getQuotation(new AS400("172.16.50.241", "S620100001","santafe07"), new QuotationRequestBO("App001", "0001", listaReq));			
		} catch (RemoteException e) {			
			e.printStackTrace();
		} catch (MalformedURLException e) {			
			e.printStackTrace();
		}*/
		
	//}
	public static void main(String[] args) {
		System.out.println("Listo+++");
	}

}
