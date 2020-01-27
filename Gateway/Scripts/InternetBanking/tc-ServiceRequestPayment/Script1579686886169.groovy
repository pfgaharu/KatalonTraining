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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable


def containerEnv = System.getenv('CONTAINER_ENV')

println('CONTAINER_DEV: ' + containerEnv)

//CustomKeywords.'doku.com.DBHelper.connectDBPostgres'('MIB')
//
//
///** -- update setting database -- **/
//def oldNotifyUrl = ""
//if (DB_NOTIFYURL != null && DB_NOTIFYURL.trim() != "" && ACQUIRERID != null && ACQUIRERID.trim() != "" && MALLID != null && MALLID.trim() != "")
//    oldNotifyUrl = CustomKeywords.'doku.com.DBHelper.updateNotifyUrl'(DB_NOTIFYURL, ACQUIRERID, MALLID)
//
//def oldInitPaymentUrl = ""
//if (DB_INITPAYMENTURL != null && DB_INITPAYMENTURL.trim() != "" && ACQUIRERID != null && ACQUIRERID.trim() != "")
//    oldInitPaymentUrl = CustomKeywords.'doku.com.DBHelper.updateInitPaymentUrl'(DB_INITPAYMENTURL, ACQUIRERID)
//
//def oldPaymentUrl = ""
//if (DB_PAYMENTURL != null && DB_PAYMENTURL.trim() != "" && ACQUIRERID != null && ACQUIRERID.trim() != "")
//    oldPaymentUrl = CustomKeywords.'doku.com.DBHelper.updatePaymentUrl'(DB_PAYMENTURL, ACQUIRERID)
//
///** -- End update setting database -- **/

paymentReq = findTestObject('InternetBanking/or-ServiceRequestPayment', [('SERVICEID') : SERVICEID, ('ACQUIRERID') : ACQUIRERID, ('MALLID') : MALLID, ('CHAINMALLID') : CHAINMALLID, 
    ('INVOICENUMBER') : INVOICENUMBER, ('CURRENCY') : CURRENCY, ('AMOUNT') : AMOUNT, ('SESSIONID') : SESSIONID, 
    ('WORDS') : WORDS, ('BASKET') : BASKET, ('DESCRIPTION') : DESCRIPTION, ('AUTH1') : AUTH1, ('AUTH2') : AUTH2, 
    ('AUTH3') : AUTH3, ('AUTH4') : AUTH4, ('CUSTOMERNAME') : CUSTOMERNAME, ('CUSTOMEREMAIL') : CUSTOMEREMAIL, 
    ('CUSTOMERMOBILEPHONE') : CUSTOMERMOBILEPHONE, ('TRANSACTIONTYPE') : TRANSACTIONTYPE, ('CUSTOMERIDENTIFIERNUMBER') : CUSTOMERIDENTIFIERNUMBER, 
    ('PAYMENTTYPE') : PAYMENTTYPE, ('CUSTOMERREGION') : CUSTOMERREGION, ('CUSTOMERCITY') : CUSTOMERCITY, 
    ('CUSTOMERADDRESS') : CUSTOMERADDRESS, ('CUSTOMERZIPCODE') : CUSTOMERZIPCODE, ('SHIPPING_ADDRESS') : SHIPPING_ADDRESS, 
    ('SHIPPING_CITY') : SHIPPING_CITY, ('SHIPPING_ZIPCODE') : SHIPPING_ZIPCODE, ('SHIPPING_COUNTRY') : SHIPPING_COUNTRY, 
    ('AIRLINESDATA') : AIRLINESDATA, ('STOREID') : STOREID])

//paymentReq.setRestUrl(CustomKeywords.'doku.com.Helper.generateEndPoint'(System.getenv("CONTAINER_ENV"), "MIB/ServiceRequestPayment?"))

response = WS.sendRequest(paymentReq)
WS.comment(response.getResponseBodyContent())
println(response.getStatusCode())

///** -- revert setting database -- **/
//if (oldNotifyUrl != "")
//    CustomKeywords.'doku.com.DBHelper.updateNotifyUrl'(oldNotifyUrl, ACQUIRERID, MALLID)
//
//if (oldInitPaymentUrl != "")
//    CustomKeywords.'doku.com.DBHelper.updateInitPaymentUrl'(oldInitPaymentUrl, ACQUIRERID)
//
//if (oldPaymentUrl != "")
//    CustomKeywords.'doku.com.DBHelper.updatePaymentUrl'(oldPaymentUrl, ACQUIRERID)
///** -- End revert setting database -- **/

GlobalVariable.G_responseServiceRequestPayment = ""
try {
    response.setContentType('text/xml')
    WS.verifyElementText(response, 'MIBPaymentResponse.mallId', MALLID)
    GlobalVariable.G_responseServiceRequestPayment = response
	GlobalVariable.G_invoiceNumber = CustomKeywords.'utils.Utils.getXmlPropertyValue'(response, 'invoiceNumber')
	GlobalVariable.G_trxCode = CustomKeywords.'utils.Utils.getXmlPropertyValue'(response, 'trxCode')
	GlobalVariable.G_redirectUrl = CustomKeywords.'utils.Utils.getXmlPropertyValue'(response, 'redirectUrl')
	GlobalVariable.G_paymentHostRefNumber = CustomKeywords.'utils.Utils.getXmlPropertyValue'(response, 'paymentHostRefNumber')
	GlobalVariable.G_billReferenceNo = CustomKeywords.'utils.Utils.getXmlPropertyValue'(response, 'paymentSystrace')
} catch (Exception e) {

}


