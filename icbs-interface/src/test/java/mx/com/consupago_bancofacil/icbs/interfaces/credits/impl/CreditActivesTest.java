/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.credits.impl;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

import mx.com.consubanco.icbs.interfaces.ConstantesICBS;
import mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditRequestBO;
import mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditBO;
import mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditResponseBO;
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
public class CreditActivesTest {
	
	private static List<String> encabezado = Arrays.asList(new String[]{"CreditNumber", "Formalizationdate","Amount","DueAmount","PaymentNumber","TotalPayments","DiscountAmount","PaymentFrecuency","PaymentBehavior","NumberOfPayment","PaymentHistory","FraudFlag","FraudFormalizeDate","convenioId","convenioName","RFC","Name","middleName","paternalName","maternalName","FechaPosteo","quebranto","pagoVoluntario","DiasRetraso","idEstatusCredito","totalAplicadoNMeses","ratificado","MesesDesdePrimerPago", "tipoAmortizacion","MontoExigible","FechaPrimerPago","MontoAplicado"});
	private static int espacios = 100;
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
	 * Exito en la consulta  de Creditos Activos
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	@Test
	public void testGetCreditsActives_TestCase1()  {
		CreditActives test = new CreditActives();
		CreditResponseBO creditResponseBO;
		try {
			
			AS400 as400CxN = new AS400(ConstantesICBS.ConnectionCXN.IP,
					ConstantesICBS.ConnectionCXN.USER,
					ConstantesICBS.ConnectionCXN.PASSWORD);
			
			//172.16.50.245
			creditResponseBO = test.getCreditsActives( as400CxN , new CreditRequestBO("App001", "0001", "0001",
			"MOVP500317"));  //MOVP500317, PARM430826, CARF530115KD4, HEGA5306011Q5, GOCO610306
			
			//creditResponseBO = test.getCreditsActives(new AS400("172.16.50.241", "S620100003",
			//		"santafe07"), new CreditRequestBO("App001", "0001", "0001",
			//		"GOCO610306"));//GOPD660621N77   GARJ620914     PEGZ710119	GUMA671022 
				
		List<CreditBO> creditActive = creditResponseBO.getCreditBO();
		System.out.println("STATUS::" + creditResponseBO.getStatus());
		System.out.println("CODE::" + creditResponseBO.getCode());
		System.out.println("RESPONSE::" + creditResponseBO.getResponse());
		if (creditActive != null && creditActive.size() > 0) {
			
			
			//FormatUtils.formatoEncabezado(encabezado);
			
			for (CreditBO creditBO : creditActive) {
				System.out.println(creditBO);
			}
		} else {
			System.out.println("NO HAY CREDITOS");
		}
		assertTrue(creditResponseBO.getCreditBO().size()>0);
		} catch (RemoteException e1) {			
			e1.printStackTrace();
		} catch (MalformedURLException e1) {			
			e1.printStackTrace();
		} catch (AS400Exception e1) {			
			e1.printStackTrace();
		} catch (ICBSInterfaceException e1) {			
			e1.printStackTrace();
		} catch (AS400ICBSInterfaceException e1) {			
			e1.printStackTrace();
		} catch (Exception e1) {			
			e1.printStackTrace();
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
	public void testGetCreditsActives_TestCase2()  {
		CreditActives test = new CreditActives();
		CreditResponseBO creditResponseBO=null;
		try {
			creditResponseBO = test.getCreditsActives(new AS400("172.16.50.241", "S620100001",
					"santafe07"), new CreditRequestBO("App001", "0001", "0001",
					"DOMG63030"));
				
		if (creditResponseBO!=null){
				List<CreditBO> creditActive = creditResponseBO.getCreditBO();
				//System.out.println("STATUS::" + creditResponseBO.getStatus());
				//System.out.println("CODE::" + creditResponseBO.getCode());
				//System.out.println("RESPONSE::" + creditResponseBO.getResponse());
				if (creditActive != null && creditActive.size() > 0) {
					
					
					FormatUtils.formatoEncabezado(encabezado);
					
					for (CreditBO creditBO : creditActive) {
						System.out.print("|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getCreditNumber(),espacios," ")+"|");
						try {
							System.out.print(FormatUtils.llenarCaracter(DateFormat.getDateInstance().format(creditBO.getFormalizationdate())+"",espacios," ")+"|");
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}				
						System.out.print(FormatUtils.llenarCaracter(creditBO.getAmount()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getDueAmount()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getPaymentNumber()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getTotalPayments()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getDiscountAmount()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getPaymentFrecuency()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getPaymentBehavior()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getNumberOfPayment()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getPaymentHistory()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getFraudFlag()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getFraudFormalizeDate()+"",espacios," ")+"|");						
						System.out.print(FormatUtils.llenarCaracter(creditBO.getConvenioId()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getConvenioName()+"",0," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getRfc()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getName()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getMiddleName()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getPaternalName()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getMaternalName()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getFechaPosteo()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getQuebranto()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getPagoVoluntario()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getIdEstatusCredito()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getTotalAplicadoNMeses()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getRatificado()+"",espacios," ")+"|");
						System.out.print(FormatUtils.llenarCaracter(creditBO.getMesesDesdePrimerPago()+"",espacios," ")+"|");
						System.out.println(FormatUtils.llenarCaracter(creditBO.getTipoAmortizacion()+"",espacios," ")+"|");
						//System.out.println(FormatUtils.llenarCaracter(creditBO.getFraudFormalizeDate()+"",espacios," ")+"|");
					}
				} else {
					System.out.println("NO HAY CREDITOS");
				}
		}
		assertNull(creditResponseBO);
		} catch (RemoteException e1) {			
			e1.printStackTrace();
		} catch (MalformedURLException e1) {			
			e1.printStackTrace();
		} catch (AS400Exception e1) {			
			e1.printStackTrace();
		} catch (ICBSInterfaceException e1) {			
			e1.printStackTrace();
		} catch (AS400ICBSInterfaceException e1) {			
			e1.printStackTrace();
		} catch (Exception e1) {			
			e1.printStackTrace();
		}
	}*/
	
	
	/**
	 * Test method for
	 * {@link mx.com.consupago_bancofacil.icbs.interfaces.credits.impl.CreditActives#getCreditsActives(com.ibm.as400.access.AS400, mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditRequestBO)}
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testGetCreditsActives_TestCase3()  {
		CreditActives test = new CreditActives();
		CreditResponseBO creditResponseBO;
		try {
			
			InputStream is = CreditActivesTest.class.getResourceAsStream("RFC2.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				creditResponseBO = test.getCreditsActives(new AS400("172.16.50.241", "S620100001",
				"santafe07"), new CreditRequestBO("App001", "0001", "0001",
						strLine));
				System.out.println("RFC::" +strLine);
				if (creditResponseBO != null && creditResponseBO.getCreditBO().size() > 0) {
				System.out.println("STATUS::" + creditResponseBO.getStatus());
				System.out.println("CODE::" + creditResponseBO.getCode());
				System.out.println("RESPONSE::" + creditResponseBO.getResponse());
				//List<CreditBO> creditActive = creditResponseBO.getCreditBO();
				
					System.out.println("HAY CREDITOS -RCF-" +strLine);
					
				}else{
					System.out.println("NO HAY CREDITOS");
				}
				//assertNotNull(creditResponseBO);
			}		
		in.close();
		
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
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}*/
	
	/**
	 * Test method for
	 * {@link mx.com.consupago_bancofacil.icbs.interfaces.credits.impl.CreditActives#getCreditsActives(com.ibm.as400.access.AS400, mx.com.consupago_bancofacil.icbs.interfaces.credits.bo.CreditRequestBO)}
	 * .
	 * @throws MalformedURLException 
	 * @throws RemoteException 
	 */
	/*@Test
	public void testGetCreditsActives_TestCase4() throws RemoteException, MalformedURLException {
		CreditActives test = new CreditActives();
		CreditResponseBO creditResponseBO = test.getCreditsActives(new AS400("", "",
				"santafe07"), new CreditRequestBO("App001", "0001", "0001",
				"DOMG630303UP"));	
		System.out.println("STATUS::" + creditResponseBO.getStatus());
		System.out.println("CODE::" + creditResponseBO.getCode());
		System.out.println("RESPONSE::" + creditResponseBO.getResponse());
		List<CreditBO> creditActive = creditResponseBO.getCreditBO();
		if (creditActive != null && creditActive.size() > 0) {
		}else{
			System.out.println("NO HAY CREDITOS");
		}
		assertNotNull(creditResponseBO);
	}*/
	
	/*public static void readFile() {
		try {			
			InputStream is = CreditActivesTest.class.getResourceAsStream("RFC.txt");
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(is);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			int cont = 1;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {	
			}
			in.close();
		} catch (Exception e) {// Catch exception if any
			e.printStackTrace();
		}
	}*/
			
	

}
