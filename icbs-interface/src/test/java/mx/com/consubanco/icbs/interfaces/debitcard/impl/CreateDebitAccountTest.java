/**
 * 
 */
package mx.com.consubanco.icbs.interfaces.debitcard.impl;


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

/**
 * @author Mfinis
 *
 */
public class CreateDebitAccountTest {

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
		
		CreateDebitAccountRequestBO debitAccountRequestBO = new CreateDebitAccountRequestBO();
		debitAccountRequestBO.setApplicationId("test1");	
		debitAccountRequestBO.setRequestId("test1");
		debitAccountRequestBO.setProcessId("test1");
		ProductBO productoBO = new ProductBO();
		
		AddressBO addressBO =new AddressBO();
		InterviningBO interviningBO = new InterviningBO();
		
		interviningBO.setCURP("JOJL620810HOCSSR08");
		interviningBO.setBussinesPartnerID("00000000285483");
		interviningBO.setClientId("001");
		interviningBO.setPartenalNM("JOSE");
		interviningBO.setMaternalNM("JOSE");
		interviningBO.setFirstNM("LORENZO");
		interviningBO.setMiddleNM("");
		interviningBO.setRFC("OJL6208101X6");		
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd");
		String strFecha = "1962-08-10";//1962/08/10
		interviningBO.setBirthDT(strFecha);
		interviningBO.setIsGenderMasculine("M");
		interviningBO.setMaritalStatus("C");
		interviningBO.setBastantType("BastantType");
		interviningBO.setSignatureType("B");
		interviningBO.setRelationType("JAO");
		List<InterviningBO> interviningsBO= new ArrayList<InterviningBO>();
		interviningsBO.add(interviningBO);
		productoBO.setListInterviningBO(interviningsBO);		
		productoBO.setNumberBranch("990");
		productoBO.setProductNumber("300");
		productoBO.setCreateInvestment(true);		
		productoBO.setAccountType("2");
		strFecha = "2014-08-26";//1962/08/10
		Date fechaApertura = null;
		try {
			fechaApertura = formatoDelTexto.parse(strFecha);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		productoBO.setOpeningDate(fechaApertura);
		productoBO.setExecutiveBranch("0000285484");
		
		addressBO.setStreet("15 DE SEPTIEMBRE");
		addressBO.setExternaNBR("MZ 19");
		addressBO.setCity("CHIMALHUACAN");
		addressBO.setInternalNBR("LT 3");
		addressBO.setSettlement("Lomas San Pablo");
		addressBO.setPostalCode("56395");
		addressBO.setTownship("CHIMALHUACAN");
		addressBO.setStateCRM("MEX");
		interviningBO.setAddressBO(addressBO);
		
		debitAccountRequestBO.setProductBO(productoBO);
		CreateDebitAccount test = new CreateDebitAccountImpl();
		CreateDebitAccountResponseBO debitAccountResponseBO=null;
		try {
			AS400 as400Captacion = new AS400(ConstantesICBS.ConnectionCXN.IP,
					ConstantesICBS.ConnectionCXN.USER,
					ConstantesICBS.ConnectionCXN.PASSWORD);
			
			debitAccountResponseBO = test.createDebitAccount(as400Captacion, debitAccountRequestBO);			  
			System.out.println("status::"+debitAccountResponseBO.getStatus());
			System.out.println("code::"+debitAccountResponseBO.getCode());
			System.out.println("Response::"+debitAccountResponseBO.getResponse());
			System.out.println("Accunt::"+debitAccountResponseBO.getNumberAccount());
			System.out.println("CLABE::"+debitAccountResponseBO.getCLABE());
			System.out.println("InvestmentAccount::"+debitAccountResponseBO.getInvesmentAccount());
		} catch (AS400Exception e) {
			
			e.printStackTrace();
		} catch (ICBSInterfaceException e) {
			
			e.printStackTrace();
		} catch (AS400ICBSInterfaceException e) {
			
			e.printStackTrace();
		}
		Assert.assertNotNull(debitAccountResponseBO);
	}	

}
