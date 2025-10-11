/**
 * 
 */
package mx.com.consupago_bancofacil.icbs.interfaces.createcredit.impl;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.Address;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.AddressInfoBO;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.ComissionInfoBO;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.Commission;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.Contact;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.ContactInfoBO;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.CreateCreditRequestBO;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.CreateCreditResponseBO;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.Credit;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.CreditBO;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.CreditICBSInfoBO;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.CreditInfoBO;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.Credits;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.Customer;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.CustomerInfoBO;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.Customizable;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.CustomizableInfoBO;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.Employment;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.EmploymentInfoBO;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.Insurance;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.InsuranceInfoBO;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.Reference;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.ReferenceInfoBO;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.bo.SubstitutionInfoBO;
import mx.com.consupago_bancofacil.icbs.interfaces.createcredit.impl.CreateCredit;
import mx.com.consupago_bancofacil.interfaces.exception.AS400ICBSInterfaceException;
import mx.com.consupago_bancofacil.interfaces.exception.ICBSInterfaceException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ibm.as400.access.AS400;

/**
 * @author Mfinis
 *
 */
public class CreateCreditTest {

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
	public void creatClientTest4() throws RemoteException, MalformedURLException {	
				
		try {			
			CreateCredit test = new CreateCredit();		
			System.out.println(createCredit50412014());
			CreateCreditResponseBO createCreditResponseBO = test.createCredit(new AS400("172.16.50.245", "S620100013","S620100013"), createCredit50412014() );		
			System.out.println("status::"+createCreditResponseBO.getStatus());
			System.out.println("code::"+createCreditResponseBO.getCode());
			System.out.println("Response::"+createCreditResponseBO.getResponse());
			System.out.println("accountId::"+createCreditResponseBO.getAccountId());
			System.out.println("PrincipalPaymentAMT::"+createCreditResponseBO.getPrincipalPaymentAMT());
			System.out.println("InterestPaymentAMT::"+createCreditResponseBO.getInterestPaymentAMT());
			System.out.println("TaxPaymentAMT::"+createCreditResponseBO.getTaxPaymentAMT());
			System.out.println("FeePaymentAMT::"+createCreditResponseBO.getFeePaymentAMT());
			System.out.println("FeeTaxPaymentAMT::"+createCreditResponseBO.getFeeTaxPaymentAMT());
			
		assertNotNull(createCreditResponseBO);
		} catch (ICBSInterfaceException e) {			
			e.printStackTrace();
		} catch (AS400ICBSInterfaceException e) {			
			e.printStackTrace();
		} catch (Exception e) {			
			e.printStackTrace();
		}
	}
	
	public CreateCreditRequestBO createCredit50412014 () {
		CreateCreditRequestBO request = new CreateCreditRequestBO();
		request.setApplicationId("123"); // ---
		request.setRequestId("0051429995"); // ---
		Credits credits = new Credits();
		CreditBO creditBO = new CreditBO();
		CreditInfoBO creditInfoBO = new CreditInfoBO();
		// Cerdit
		Credit credit = new Credit();
		credit.setAccountSpreadMethodCRM("02"); // ---
		credit.setBankReferenceNBR("000504120148"); // ---
		credit.setBranchCRM("0017001036"); // ---
		credit.setCreditCRM("0051429995"); // ---
		credit.setCompanyCD("000000001200"); // ---
		credit.setDependenciaCRM("0017504284"); // ---
		credit.setDisbursementDT("2015/06/25"); // ---
		credit.setDistribuidorCRM("0017000704"); // ---
		credit.setEmployeeTypeDesc("");
		credit.setFieldReference1("");
		credit.setFieldReference2("");
		credit.setFieldReference3("");
		credit.setFirstPaymentExpectedDT("");
		credit.setFormalizationDT("2015/06/25"); // ---
		credit.setFundingAMT("41083.55"); // ---
		credit.setFundingDT("2015/06/25");  // ---
		credit.setInterestPaymentAMT("0.00"); // ---
		credit.setInterestRatePCT("0.15"); // ---
		credit.setOldCreditCRM("");
		credit.setTotalPaymentsNBR("030"); // ---
		credit.setTotalPrincipalAMT("41083.55"); // ---
		credit.setTotalInterestAMT("933.82"); // ---
		credit.setTotalTaxAMT("149.73"); // ---
		credit.setTaxPaymentAMT("0.00"); // ---
		credit.setPrincipalPaymentAMT("0.00"); // ---
		credit.setPayerNBR("0001670451"); // ---
		credit.setPaymentFrecuencyCRM("Z004"); // ---
		credit.setPaymentUnitCRM("0017800482"); // ---
		credit.setPayrollNBR(""); // ---
		credit.setPromoterCRM("0017115305"); // ---
		credit.setProductCRM("EFEC"); // ---
		credit.setReferenceNBR("");
		credit.setRegionCRM("07"); // ---
		credit.setvATRate("0.16"); // ---
		credit.setBudgetNBR("");
		credit.setCAT("2.60"); // ---
		// Customizable
		CustomizableInfoBO customizableInfoBO = new CustomizableInfoBO();
//		Customizable customizable = new Customizable();
//		customizable.setConvenioCRM("10000262");
//		customizable.setFieldKey("D58_CUOTA SINDICAL");
//		customizable.setFieldValue("100.00");
//		
//		Customizable customizable2 = new Customizable();
//		customizable2.setConvenioCRM("10000262");
//		customizable2.setFieldKey("P07_SUELDOS COMPACTOS");
//		customizable2.setFieldValue("10000.00");
//		
//		Customizable customizable3 = new Customizable();
//		customizable3.setConvenioCRM("10000262");
//		customizable3.setFieldKey("0210_folio-lider-sindical");
//		customizable3.setFieldValue("0");
//		
//		Customizable customizable4 = new Customizable();
//		customizable4.setConvenioCRM("10000262");
//		customizable4.setFieldKey("0285_comision-apertura");
//		customizable4.setFieldValue("1");
//		
//		Customizable customizable5 = new Customizable();
//		customizable5.setConvenioCRM("10000262");
//		customizable5.setFieldKey("0007_nombre1");
//		customizable5.setFieldValue("LORENZO");
//		
//		Customizable customizable6 = new Customizable();
//		customizable6.setConvenioCRM("10000262");
//		customizable6.setFieldKey("0008_nombre2");
//		customizable6.setFieldValue("");
//		
//		Customizable customizable7 = new Customizable();
//		customizable7.setConvenioCRM("10000262");
//		customizable7.setFieldKey("0009_apellido-paterno");
//		customizable7.setFieldValue("JOSE");
//		
//		Customizable customizable8 = new Customizable();
//		customizable8.setConvenioCRM("10000262");
//		customizable8.setFieldKey("0010_apellido-materno");
//		customizable8.setFieldValue("JOSE");
//		
//		Customizable customizable9 = new Customizable();
//		customizable9.setConvenioCRM("10000262");
//		customizable9.setFieldKey("0036_clave-nomina");
//		customizable9.setFieldValue("01-10");
//		
//		Customizable customizable10 = new Customizable();
//		customizable10.setConvenioCRM("10000262");
//		customizable10.setFieldKey("0082_fecha-ingreso");
//		customizable10.setFieldValue("01-10");
//		
//		Customizable customizable11 = new Customizable();
//		customizable11.setConvenioCRM("10000262");
//		customizable11.setFieldKey("0159_periodo-final-pago");
//		customizable11.setFieldValue("15/05/2013");
//		
//		Customizable customizable12 = new Customizable();
//		customizable12.setConvenioCRM("10000262");
//		customizable12.setFieldKey("0160_periodo-inicial-pago");
//		customizable12.setFieldValue("01/05/2013");
//		
//		Customizable customizable13 = new Customizable();
//		customizable13.setConvenioCRM("10000262");
//		customizable13.setFieldKey("0179_rfc");
//		customizable13.setFieldValue("JOJL6208101X6");
//		
//		Customizable customizable14 = new Customizable();
//		customizable14.setConvenioCRM("10000262");
//		customizable14.setFieldKey("0205_validar-prorroga");
//		customizable14.setFieldValue("true");
//		
//		Customizable customizable15 = new Customizable();
//		customizable15.setConvenioCRM("10000262");
//		customizable15.setFieldKey("Monto");
//		customizable15.setFieldValue("5000.00");
//		
//		Customizable customizable16 = new Customizable();
//		customizable16.setConvenioCRM("10000262");
//		customizable16.setFieldKey("Importe a Depositar");
//		customizable16.setFieldValue("4944.5");
//		
//		Customizable customizable17 = new Customizable();
//		customizable17.setConvenioCRM("10000262");
//		customizable17.setFieldKey("Importe de Descuentos");
//		customizable17.setFieldValue("55.50");
//		
//		Customizable customizable18 = new Customizable();
//		customizable18.setConvenioCRM("10000262");
//		customizable18.setFieldKey("Tipo de Depósito");
//		customizable18.setFieldValue("Pago en Ventanilla");
//		
//		Customizable customizable19 = new Customizable();
//		customizable19.setConvenioCRM("10000262");
//		customizable19.setFieldKey("Plazo");
//		customizable19.setFieldValue("024");
//		
//		Customizable customizable20 = new Customizable();
//		customizable20.setConvenioCRM("10000262");
//		customizable20.setFieldKey("Banco");
//		customizable20.setFieldValue("BBVA BANCOMER");
//		
//		Customizable customizable21 = new Customizable();
//		customizable21.setConvenioCRM("10000262");
//		customizable21.setFieldKey("Deducciones Totales");
//		customizable21.setFieldValue("1000.00");
//		
		Customizable customizable22 = new Customizable();
		customizable22.setConvenioCRM("10000570");
		customizable22.setFieldKey("Valor Cuota Calculada");
		customizable22.setFieldValue("1906.49");
//		
//		Customizable customizable23 = new Customizable();
//		customizable23.setConvenioCRM("10000262");
//		customizable23.setFieldKey("CreditoPolitico");
//		customizable23.setFieldValue("NO");
		
		List<Customizable> listaCustomizable = new ArrayList();
//		listaCustomizable.add(customizable);
//		listaCustomizable.add(customizable2);
//		listaCustomizable.add(customizable3);
//		listaCustomizable.add(customizable4);
//		listaCustomizable.add(customizable5);
//		listaCustomizable.add(customizable6);
//		listaCustomizable.add(customizable7);
//		listaCustomizable.add(customizable8);
//		listaCustomizable.add(customizable9);
//		listaCustomizable.add(customizable10);
//		listaCustomizable.add(customizable11);
//		listaCustomizable.add(customizable12);
//		listaCustomizable.add(customizable13);
//		listaCustomizable.add(customizable14);
//		listaCustomizable.add(customizable15);
//		listaCustomizable.add(customizable16);
//		listaCustomizable.add(customizable17);
//		listaCustomizable.add(customizable18);
//		listaCustomizable.add(customizable19);
//		listaCustomizable.add(customizable20);
//		listaCustomizable.add(customizable21);
		listaCustomizable.add(customizable22);
//		listaCustomizable.add(customizable23);
		customizableInfoBO.setCustomizable(listaCustomizable);
		
		InsuranceInfoBO insuranceInfoBO = new InsuranceInfoBO();
		Insurance insurance = new Insurance();
		insurance.setInsuranceAMT("0.00");
		insurance.setProductCategory("");
		insurance.setProductID("");
		insurance.setProductNM("");
		List<Insurance> listaInsurance = new ArrayList();
		listaInsurance.add(insurance);
		insuranceInfoBO.setInsurance(listaInsurance);
		// Commission
		ComissionInfoBO commissionInfoBO = new ComissionInfoBO();
		List<Commission> listComission = new ArrayList<Commission>();
		Commission commission = new Commission();
		commission.setAmount("0");
		commission.setDeffered("0");
		commission.setPercentage("0");		
		listComission.add(commission);
		commissionInfoBO.setComission(listComission);
		// creditICBS
		CreditICBSInfoBO creditICBSInfoBO = new CreditICBSInfoBO();
		creditICBSInfoBO.setBankName("BBVABANCOMER");
		creditICBSInfoBO.setOperationType("Deposito a cuenta");
		creditICBSInfoBO.setProductICBS("144");
		// Asigna Credit
		creditInfoBO.setCredit(credit);
		creditInfoBO.setCustomizableInfoBO(customizableInfoBO);
		creditInfoBO.setInsuranceInfoBO(insuranceInfoBO);
		creditInfoBO.setCommissionInfoBO(commissionInfoBO);
		creditInfoBO.setCreditICBSInfoBO(creditICBSInfoBO);
		creditBO.setCreditInfoBO(creditInfoBO);
		CustomerInfoBO customerInfoBO = new CustomerInfoBO();
		Customer customer = new Customer();
		customer.setCurp("HEPA510607HSPRND02");
		customer.setCustomerCRM("0001670451");
		customer.setPartenalNM("HERNANDEZ");
		customer.setMaternalNM("PONCE");
		customer.setFirstNM("ADALBERTO");
		customer.setMiddleNM("");
		customer.setRfc("HEPA510607-01");
		customer.setIfe("1959005142017");
		customer.setBirthDT("1951/06/07");
		customer.setGender("");
		customer.setMaritalStatus("Soltero/a");
		customer.setIdentificationType("Clave Unica de Registro Poblacional");
		customer.setIdentificationNBR("HEPA510607HSPRND02");
		customerInfoBO.setCustomer(customer);
		EmploymentInfoBO employmentInfoBO = new EmploymentInfoBO();
		
		Employment employment = new Employment();
		employment.setCompany("");
		employment.setPositionNM("");
		employment.setPuestoCRM("");
		employment.setPuestoNM("");
		employment.setGrossIncome("");
		employment.setHiringDT("2015/06/18"); // --
		employment.setNetIncome("0.000000000");
		employmentInfoBO.setEmployment(employment);
		customerInfoBO.setEmploymentInfoBO(employmentInfoBO);
		AddressInfoBO addressInfoBO = new AddressInfoBO();
		Address address = new Address();
		address.setAddressTypeNM("PARTICULAR");
		address.setStreet("AV PAVO REAL");
		address.setExternaNBR("");
		address.setCiudad("PUERTO VALLARTA");
		address.setInternalNBR("202");
		address.setColonia("LAS ARALIAS");
		address.setPostalCode("48328");
		address.setMunicipio("PUERTO VALLARTA");
		address.setStateCRM("JAL");
		
		List<Address> listaAddress = new ArrayList<Address>();
		listaAddress.add(address);
	
		addressInfoBO.setAddress(listaAddress);
		customerInfoBO.setAddressInfoBO(addressInfoBO);
		ContactInfoBO contactInfoBO = new ContactInfoBO();
		Contact contact = new Contact();
		contact.setContactTypeNM("Movil");
		contact.setContactNBR("3222004210");
		contact.setContactExt("");
		
		List<Contact> lstContact = new ArrayList();
		lstContact.add(contact);
		contactInfoBO.setContact(lstContact);
		customerInfoBO.setContactInfoBO(contactInfoBO);
		ReferenceInfoBO referencesInfoBO = new ReferenceInfoBO();
		Reference reference = new Reference();
		List<Reference> lstReference = new ArrayList();
		reference.setPersonalRelationCRN("");
		reference.setPartenalNM("");
		reference.setMaternalNM("");
		reference.setFirstNM("");
		reference.setMiddleNM("");
		reference.setRFC("");
		reference.setCURP("");
		reference.setIFE("");
		reference.setBirthDT("");
		reference.setGender("");
		reference.setMaritalStatus("");
		reference.setPersonalRelationTypeNM("");
		lstReference.add(reference);
		referencesInfoBO.setReference(lstReference);
		customerInfoBO.setReferenceInfoBO(referencesInfoBO);
		List<Credit> listCreditSubstitution = new ArrayList<Credit>();
		SubstitutionInfoBO substitutionInfoBO = new SubstitutionInfoBO();
		
		Credit creditSub = new Credit();
		creditSub.setOldCreditCRM("");
		creditSub.setSubstitutionAMT("");
		listCreditSubstitution.add(creditSub);
		
		substitutionInfoBO.setCredit(listCreditSubstitution);
		creditBO.setSubstitutionInfoBO(substitutionInfoBO);
		// Seteo de Objetos
		creditBO.setCustomerInfoBO(customerInfoBO);
		credits.setCreditBO(creditBO);
		request.setCredits(credits);
		return request;
	}

	public CreateCreditRequestBO createCredit50473611 () {
		CreateCreditRequestBO request = new CreateCreditRequestBO();
		request.setApplicationId("123"); // ---
		request.setRequestId("0050473611"); // ---
		Credits credits = new Credits();
		CreditBO creditBO = new CreditBO();
		CreditInfoBO creditInfoBO = new CreditInfoBO();
		// Cerdit
		Credit credit = new Credit();
		credit.setAccountSpreadMethodCRM("02"); // ---
		credit.setBankReferenceNBR("000504120148"); // ---
		credit.setBranchCRM("0017001001"); // ---
		credit.setCreditCRM("0050473611"); // ---
		credit.setCompanyCD("000000001200"); // ---
		credit.setDependenciaCRM("0017504284"); // ---
		credit.setDisbursementDT("2015/11/27"); // ---
		credit.setDistribuidorCRM("0017000582"); // ---
		credit.setEmployeeTypeDesc("");
		credit.setFieldReference1("");
		credit.setFieldReference2("");
		credit.setFieldReference3("");
		credit.setFirstPaymentExpectedDT("");
		credit.setFormalizationDT("2015/11/27"); // ---
		credit.setFundingAMT("200584.08"); // ---
		credit.setFundingDT("2015/11/27");  // ---
		credit.setInterestPaymentAMT("0.00"); // ---
		credit.setInterestRatePCT("2.08"); // ---
		credit.setOldCreditCRM("");
		credit.setTotalPaymentsNBR("048"); // ---
		credit.setTotalPrincipalAMT("200584.08"); // ---
		credit.setTotalInterestAMT("58262.14"); // ---
		credit.setTotalTaxAMT("9321.94"); // ---
		credit.setTaxPaymentAMT("0.00"); // ---
		credit.setPrincipalPaymentAMT("0.00"); // ---
		credit.setPayerNBR("0000554819"); // ---
		credit.setPaymentFrecuencyCRM("Z004"); // ---
		credit.setPaymentUnitCRM("0017800482"); // ---
		credit.setPayrollNBR(""); // ---
		credit.setPromoterCRM("0010007357"); // ---
		credit.setProductCRM("LCOM"); // ---
		credit.setReferenceNBR("");
		credit.setRegionCRM("10"); // ---
		credit.setvATRate("0.16"); // ---
		credit.setBudgetNBR("");
		credit.setCAT("28.05"); // ---
		// Customizable
		CustomizableInfoBO customizableInfoBO = new CustomizableInfoBO();
//		Customizable customizable = new Customizable();
//		customizable.setConvenioCRM("10000262");
//		customizable.setFieldKey("D58_CUOTA SINDICAL");
//		customizable.setFieldValue("100.00");
//		
//		Customizable customizable2 = new Customizable();
//		customizable2.setConvenioCRM("10000262");
//		customizable2.setFieldKey("P07_SUELDOS COMPACTOS");
//		customizable2.setFieldValue("10000.00");
//		
//		Customizable customizable3 = new Customizable();
//		customizable3.setConvenioCRM("10000262");
//		customizable3.setFieldKey("0210_folio-lider-sindical");
//		customizable3.setFieldValue("0");
//		
//		Customizable customizable4 = new Customizable();
//		customizable4.setConvenioCRM("10000262");
//		customizable4.setFieldKey("0285_comision-apertura");
//		customizable4.setFieldValue("1");
//		
//		Customizable customizable5 = new Customizable();
//		customizable5.setConvenioCRM("10000262");
//		customizable5.setFieldKey("0007_nombre1");
//		customizable5.setFieldValue("LORENZO");
//		
//		Customizable customizable6 = new Customizable();
//		customizable6.setConvenioCRM("10000262");
//		customizable6.setFieldKey("0008_nombre2");
//		customizable6.setFieldValue("");
//		
//		Customizable customizable7 = new Customizable();
//		customizable7.setConvenioCRM("10000262");
//		customizable7.setFieldKey("0009_apellido-paterno");
//		customizable7.setFieldValue("JOSE");
//		
//		Customizable customizable8 = new Customizable();
//		customizable8.setConvenioCRM("10000262");
//		customizable8.setFieldKey("0010_apellido-materno");
//		customizable8.setFieldValue("JOSE");
//		
//		Customizable customizable9 = new Customizable();
//		customizable9.setConvenioCRM("10000262");
//		customizable9.setFieldKey("0036_clave-nomina");
//		customizable9.setFieldValue("01-10");
//		
//		Customizable customizable10 = new Customizable();
//		customizable10.setConvenioCRM("10000262");
//		customizable10.setFieldKey("0082_fecha-ingreso");
//		customizable10.setFieldValue("01-10");
//		
//		Customizable customizable11 = new Customizable();
//		customizable11.setConvenioCRM("10000262");
//		customizable11.setFieldKey("0159_periodo-final-pago");
//		customizable11.setFieldValue("15/05/2013");
//		
//		Customizable customizable12 = new Customizable();
//		customizable12.setConvenioCRM("10000262");
//		customizable12.setFieldKey("0160_periodo-inicial-pago");
//		customizable12.setFieldValue("01/05/2013");
//		
//		Customizable customizable13 = new Customizable();
//		customizable13.setConvenioCRM("10000262");
//		customizable13.setFieldKey("0179_rfc");
//		customizable13.setFieldValue("JOJL6208101X6");
//		
//		Customizable customizable14 = new Customizable();
//		customizable14.setConvenioCRM("10000262");
//		customizable14.setFieldKey("0205_validar-prorroga");
//		customizable14.setFieldValue("true");
//		
//		Customizable customizable15 = new Customizable();
//		customizable15.setConvenioCRM("10000262");
//		customizable15.setFieldKey("Monto");
//		customizable15.setFieldValue("5000.00");
//		
//		Customizable customizable16 = new Customizable();
//		customizable16.setConvenioCRM("10000262");
//		customizable16.setFieldKey("Importe a Depositar");
//		customizable16.setFieldValue("4944.5");
//		
//		Customizable customizable17 = new Customizable();
//		customizable17.setConvenioCRM("10000262");
//		customizable17.setFieldKey("Importe de Descuentos");
//		customizable17.setFieldValue("55.50");
//		
//		Customizable customizable18 = new Customizable();
//		customizable18.setConvenioCRM("10000262");
//		customizable18.setFieldKey("Tipo de Depósito");
//		customizable18.setFieldValue("Pago en Ventanilla");
//		
//		Customizable customizable19 = new Customizable();
//		customizable19.setConvenioCRM("10000262");
//		customizable19.setFieldKey("Plazo");
//		customizable19.setFieldValue("024");
//		
//		Customizable customizable20 = new Customizable();
//		customizable20.setConvenioCRM("10000262");
//		customizable20.setFieldKey("Banco");
//		customizable20.setFieldValue("BBVA BANCOMER");
//		
//		Customizable customizable21 = new Customizable();
//		customizable21.setConvenioCRM("10000262");
//		customizable21.setFieldKey("Deducciones Totales");
//		customizable21.setFieldValue("1000.00");
//		
		Customizable customizable22 = new Customizable();
		customizable22.setConvenioCRM("10000570");
		customizable22.setFieldKey("Valor Cuota Calculada");
		customizable22.setFieldValue("5571.78");
//		
//		Customizable customizable23 = new Customizable();
//		customizable23.setConvenioCRM("10000262");
//		customizable23.setFieldKey("CreditoPolitico");
//		customizable23.setFieldValue("NO");
		
		List<Customizable> listaCustomizable = new ArrayList();
//		listaCustomizable.add(customizable);
//		listaCustomizable.add(customizable2);
//		listaCustomizable.add(customizable3);
//		listaCustomizable.add(customizable4);
//		listaCustomizable.add(customizable5);
//		listaCustomizable.add(customizable6);
//		listaCustomizable.add(customizable7);
//		listaCustomizable.add(customizable8);
//		listaCustomizable.add(customizable9);
//		listaCustomizable.add(customizable10);
//		listaCustomizable.add(customizable11);
//		listaCustomizable.add(customizable12);
//		listaCustomizable.add(customizable13);
//		listaCustomizable.add(customizable14);
//		listaCustomizable.add(customizable15);
//		listaCustomizable.add(customizable16);
//		listaCustomizable.add(customizable17);
//		listaCustomizable.add(customizable18);
//		listaCustomizable.add(customizable19);
//		listaCustomizable.add(customizable20);
//		listaCustomizable.add(customizable21);
		listaCustomizable.add(customizable22);
//		listaCustomizable.add(customizable23);
		customizableInfoBO.setCustomizable(listaCustomizable);
		
		InsuranceInfoBO insuranceInfoBO = new InsuranceInfoBO();
		Insurance insurance = new Insurance();
		insurance.setInsuranceAMT("0.00");
		insurance.setProductCategory("");
		insurance.setProductID("");
		insurance.setProductNM("");
		List<Insurance> listaInsurance = new ArrayList();
		listaInsurance.add(insurance);
		insuranceInfoBO.setInsurance(listaInsurance);
		// Commission
		ComissionInfoBO commissionInfoBO = new ComissionInfoBO();
		List<Commission> listComission = new ArrayList<Commission>();
		Commission commission = new Commission();
		commission.setAmount("0");
		commission.setDeffered("0");
		commission.setPercentage("0");		
		listComission.add(commission);
		commissionInfoBO.setComission(listComission);
		// creditICBS
		CreditICBSInfoBO creditICBSInfoBO = new CreditICBSInfoBO();
		creditICBSInfoBO.setBankName("HSBC");
		creditICBSInfoBO.setOperationType("Deposito a cuenta");
		creditICBSInfoBO.setProductICBS("144");
		// Asigna Credit
		creditInfoBO.setCredit(credit);
		creditInfoBO.setCustomizableInfoBO(customizableInfoBO);
		creditInfoBO.setInsuranceInfoBO(insuranceInfoBO);
		creditInfoBO.setCommissionInfoBO(commissionInfoBO);
		creditInfoBO.setCreditICBSInfoBO(creditICBSInfoBO);
		creditBO.setCreditInfoBO(creditInfoBO);
		CustomerInfoBO customerInfoBO = new CustomerInfoBO();
		Customer customer = new Customer();
		customer.setCurp("SARA420316HDFRLB15");
		customer.setCustomerCRM("0000554819");
		customer.setPartenalNM("SARABIA");
		customer.setMaternalNM("RELLO");
		customer.setFirstNM("ABRAHAM");
		customer.setMiddleNM("ABELARDO");
		customer.setRfc("SARA420316-01");
		customer.setIfe("0279046568818");
		customer.setBirthDT("1942/03/16");
		customer.setGender("");
		customer.setMaritalStatus("Casado/a");
		customer.setIdentificationType("Clave Unica de Registro Poblacional");
		customer.setIdentificationNBR("SARA420316HDFRLB15");
		customerInfoBO.setCustomer(customer);
		EmploymentInfoBO employmentInfoBO = new EmploymentInfoBO();
		
		Employment employment = new Employment();
		employment.setCompany("");
		employment.setPositionNM("");
		employment.setPuestoCRM("1031");
		employment.setPuestoNM("Jubilado/Pensionado");
		employment.setGrossIncome("");
		employment.setHiringDT("2015/11/24"); // --
		employment.setNetIncome("0.000000000");
		employmentInfoBO.setEmployment(employment);
		customerInfoBO.setEmploymentInfoBO(employmentInfoBO);
		AddressInfoBO addressInfoBO = new AddressInfoBO();
		Address address = new Address();
		address.setAddressTypeNM("PARTICULAR");
		address.setStreet("RIVERA");
		address.setExternaNBR("");
		address.setCiudad("ATIZAPAN DE ZARAGOZA");
		address.setInternalNBR("11");
		address.setColonia("FRACC LOMAS DE BELLAVISTA");
		address.setPostalCode("52994");
		address.setMunicipio("ATIZAPAN DE ZARAGOZA");
		address.setStateCRM("MEX");
		
		List<Address> listaAddress = new ArrayList<Address>();
		listaAddress.add(address);
	
		addressInfoBO.setAddress(listaAddress);
		customerInfoBO.setAddressInfoBO(addressInfoBO);
		ContactInfoBO contactInfoBO = new ContactInfoBO();
		Contact contact = new Contact();
		contact.setContactTypeNM("Movil");
		contact.setContactNBR("5532639670");
		contact.setContactExt("");
		
		List<Contact> lstContact = new ArrayList();
		lstContact.add(contact);
		contactInfoBO.setContact(lstContact);
		customerInfoBO.setContactInfoBO(contactInfoBO);
		ReferenceInfoBO referencesInfoBO = new ReferenceInfoBO();
		Reference reference = new Reference();
		List<Reference> lstReference = new ArrayList();
		reference.setPersonalRelationCRN("");
		reference.setPartenalNM("");
		reference.setMaternalNM("");
		reference.setFirstNM("");
		reference.setMiddleNM("");
		reference.setRFC("");
		reference.setCURP("");
		reference.setIFE("");
		reference.setBirthDT("");
		reference.setGender("");
		reference.setMaritalStatus("");
		reference.setPersonalRelationTypeNM("");
		lstReference.add(reference);
		referencesInfoBO.setReference(lstReference);
		customerInfoBO.setReferenceInfoBO(referencesInfoBO);
		List<Credit> listCreditSubstitution = new ArrayList<Credit>();
		SubstitutionInfoBO substitutionInfoBO = new SubstitutionInfoBO();
		
		Credit creditSub = new Credit();
		creditSub.setOldCreditCRM("");
		creditSub.setSubstitutionAMT("");
		listCreditSubstitution.add(creditSub);
		
		substitutionInfoBO.setCredit(listCreditSubstitution);
		creditBO.setSubstitutionInfoBO(substitutionInfoBO);
		// Seteo de Objetos
		creditBO.setCustomerInfoBO(customerInfoBO);
		credits.setCreditBO(creditBO);
		request.setCredits(credits);
		return request;
	}

}
