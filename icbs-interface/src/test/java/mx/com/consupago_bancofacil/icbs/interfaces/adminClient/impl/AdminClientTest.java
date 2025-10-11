/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.adminClient.impl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import mx.com.consupago_bancofacil.icbs.interfaces.adminClient.bo.AdminClientRequestBO;
import mx.com.consupago_bancofacil.icbs.interfaces.adminClient.bo.AdminClientResponseBO;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.as400.access.AS400;

/**
 * @author Mfinis
 *
 */
public class AdminClientTest {

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
	public void testAdminClient() throws RemoteException, MalformedURLException {
		
		AdminClientRequestBO adminClientRequestBO = new AdminClientRequestBO();
		adminClientRequestBO.setIdClient("5005");//idClient				
		adminClientRequestBO.setPrimaryLastName("Becerra");//Apellido Paterno
		adminClientRequestBO.setSecondLastName("Sanchez");//Apellido Materno
		adminClientRequestBO.setName("Juan Ramon");//Nombre		
		adminClientRequestBO.setStreet("Reforma");// Calle			
		adminClientRequestBO.setOutsideNumber("1000");// No.Ext			
		adminClientRequestBO.setInternalNumber("0");// No.Int
		adminClientRequestBO.setState("MEX");// Estado
		adminClientRequestBO.setTown("");// Municipio
		adminClientRequestBO.setSettlement("2");// Colonia
		adminClientRequestBO.setCp(62000);// CP
		adminClientRequestBO.setPhone1(552411110);// Telefono
		adminClientRequestBO.setSubsidiary(2);// Sucursal
		adminClientRequestBO.setRfc("BESJ780130P12");// RFC
		adminClientRequestBO.setCurp("BESJ780130PUHP4536");//CURP
		
		AdminClient test = new AdminClient();
		
		
		AdminClientResponseBO adminClientResponseBO = test.adminClient(new AS400("172.16.50.245", "S620100013","S620100013"), adminClientRequestBO);
		
		System.out.println("status::"+adminClientResponseBO.getStatus());
		System.out.println("code::"+adminClientResponseBO.getCode());
		System.out.println("IdClient::"+adminClientResponseBO.getIdClient());//idClient				
		System.out.println("LastName::"+adminClientResponseBO.getPrimaryLastName());//Apellido Paterno
		System.out.println("Apellido Materno::"+adminClientResponseBO.getSecondLastName());//Apellido Materno
		System.out.println("name::"+adminClientResponseBO.getName());//Nombre
		System.out.println("calle::"+adminClientResponseBO.getStreet());// Calle			
		System.out.println("Numero Exterior::"+adminClientResponseBO.getOutsideNumber());// No.Ext			
		System.out.println("Numero Interior::"+adminClientResponseBO.getInternalNumber());// No.Int
		System.out.println("Estado::"+adminClientRequestBO.getState());// Estado
		System.out.println("Municipio::"+adminClientRequestBO.getTown());// Municipio
		System.out.println("Colonia::"+adminClientRequestBO.getSettlement());// Colonia
		System.out.println("CP::"+adminClientRequestBO.getCp());// CP
		System.out.println("Telefono"+adminClientRequestBO.getPhone1());// Telefono
		System.out.println("Sucursal::"+adminClientRequestBO.getSubsidiary());// Sucursal
		System.out.println("Rfc::"+adminClientRequestBO.getRfc());// RFC
		System.out.println("Curp::"+adminClientRequestBO.getCurp());//CURP

		
		fail("Not yet implemented");
	}	

}
