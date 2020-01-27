import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


def containerEnv = System.getenv('CONTAINER_ENV')
println('CONTAINER_DEV: ' + containerEnv)

WebUI.callTestCase(findTestCase('InternetBanking/tc-ServiceRequestPayment'), [ ('SERVICEID') : SERVICEID, ('ACQUIRERID') : ACQUIRERID, ('MALLID') : MALLID, 
	('CHAINMALLID') : CHAINMALLID, ('INVOICENUMBER') : INVOICENUMBER, ('CURRENCY') : CURRENCY, ('AMOUNT') : AMOUNT, ('SESSIONID') : SESSIONID, ('WORDS') : WORDS, 
	('BASKET') : BASKET, ('DESCRIPTION') : DESCRIPTION, ('AUTH1') : AUTH1, ('AUTH2') : AUTH2, ('AUTH3') : AUTH3, ('AUTH4') : AUTH4, ('CUSTOMERNAME') : CUSTOMERNAME, 
	('CUSTOMEREMAIL') : CUSTOMEREMAIL, ('CUSTOMERMOBILEPHONE') : CUSTOMERMOBILEPHONE, ('TRANSACTIONTYPE') : TRANSACTIONTYPE, 
	('CUSTOMERIDENTIFIERNUMBER') : CUSTOMERIDENTIFIERNUMBER, ('PAYMENTTYPE') : PAYMENTTYPE, ('CUSTOMERREGION') : CUSTOMERREGION, ('CUSTOMERCITY') : CUSTOMERCITY, 
	('CUSTOMERADDRESS') : CUSTOMERADDRESS, ('CUSTOMERZIPCODE') : CUSTOMERZIPCODE, ('SHIPPING_ADDRESS') : SHIPPING_ADDRESS, ('SHIPPING_CITY') : SHIPPING_CITY, 
	('SHIPPING_ZIPCODE') : SHIPPING_ZIPCODE, ('SHIPPING_COUNTRY') : SHIPPING_COUNTRY, ('AIRLINESDATA') : AIRLINESDATA, ('STOREID') : STOREID, 
	('DB_NOTIFYURL') : DB_NOTIFYURL, ('DB_INITPAYMENTURL') : DB_INITPAYMENTURL, ('DB_PAYMENTURL') : DB_PAYMENTURL ],
FailureHandling.STOP_ON_FAILURE)

if (GlobalVariable.G_responseServiceRequestPayment != "") {
	response = GlobalVariable.G_responseServiceRequestPayment

	def wordsComponents = ""
	if (NOTIFYSTATUS.toString().toUpperCase() == "EMPTY") {
		wordsComponents = GlobalVariable.G_billReferenceNo + "||" + GlobalVariable.G_trxCode
	} else if (NOTIFYSTATUS == "") {
		wordsComponents = GlobalVariable.G_billReferenceNo + "|" + GlobalVariable.G_trxCode
	} else {
		wordsComponents = GlobalVariable.G_billReferenceNo + "|" + NOTIFYSTATUS.toString() + "|" + GlobalVariable.G_trxCode
	}
	def words = CustomKeywords.'utils.Utils.generateSignatureBriCeria'(wordsComponents)
	def amountDouble = Double.parseDouble(JSON_AMOUNT.toString())
	
	RequestObject notifyPayment = findTestObject('InternetBanking/BRICeria/or-notifypayment', [ ('NOTIFYSTATUS') : JSON_STATUS, ('MESSAGE') : "", 
		('TRANSACTIONID') : '989898', ('ORDERID') : GlobalVariable.G_billReferenceNo, ('AMOUNT') : (int) amountDouble ])
	
//	GlobalVariable.G_billReferenceNo
	notifyPayment.setRestUrl(CustomKeywords.'utils.Utils.generateEndPoint'(System.getenv("CONTAINER_ENV"), "MIB/BRICeriaNotify?words=" + words ))
	response = WS.sendRequest(notifyPayment)
	response.setContentType('application/json')
	 WS.comment(response.getResponseText())
	
	 def responseBodyObject = CustomKeywords.'utils.Utils.jsonParsingToMap'(response)
	 if (responseBodyObject != null) {
		 WebUI.verifyMatch(responseBodyObject.status, RESPONSE_NOTIFY_STATUS, false, FailureHandling.STOP_ON_FAILURE)
		 WebUI.verifyMatch(responseBodyObject.message, RESPONSE_NOTIFY_MESSAGE, false, FailureHandling.STOP_ON_FAILURE)
	 }
	
} else {
	println('Failed Response')
}
