import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import utils.Utils as Utils
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import internal.GlobalVariable as GlobalVariable

WebUI.comment('Test Case = '+testCaseDesc)
INVOICENUMBER = Utils.generateInvoice()
sessionId = Utils.generateInvoice()+'321'
refidmerchant = (Utils.generateInvoice() + '123')

'Payment Process'
WebUI.callTestCase(findTestCase('InternetBanking/BRI Ceria/TC01-Payment'), [('SERVICEID') : '1', ('ACQUIRERID') : '1024'
        , ('MALLID') : '1', ('CHAINMALLID') : '', ('INVOICENUMBER') : INVOICENUMBER, ('CURRENCY') : 'IDR', ('AMOUNT') : '600000.00'
        , ('SESSIONID') : 'gy7a9f79abt7f9af97tfd89afdafdsa', ('WORDS') : '4b034c12175e62bfa25d977244ea1edc6db4e9d4', ('BASKET') : 'Movie FEMALE AGENTS,600000.00,1,600000.00'
        , ('DESCRIPTION') : 'Payment Description', ('AUTH1') : '085722915368', ('AUTH2') : '', ('AUTH3') : '', ('AUTH4') : ''
        , ('CUSTOMERNAME') : 'Dadang Setiadji', ('CUSTOMEREMAIL') : 'taufik@nsiapay.com', ('CUSTOMERMOBILEPHONE') : '6281808903132'
        , ('TRANSACTIONTYPE') : 'S', ('CUSTOMERIDENTIFIERNUMBER') : '', ('PAYMENTTYPE') : '', ('CUSTOMERREGION') : 'Jakarta'
        , ('CUSTOMERCITY') : 'Jakarta', ('CUSTOMERADDRESS') : 'Jawa Timur', ('CUSTOMERZIPCODE') : '16406785', ('SHIPPING_ADDRESS') : 'Jakarta'
        , ('SHIPPING_CITY') : 'Jakarta', ('SHIPPING_ZIPCODE') : '16406785', ('SHIPPING_COUNTRY') : 'INDONESIA', ('AIRLINESDATA') : ''
        , ('STOREID') : '', ('SERVICETRANSACTIONID') : 'qwertyuiop0987654321', ('ADDITIONALAMOUNT') : '600000.00', ('CUSTOMERCOUNTRY') : 'ID'
        , ('CUSTOMERHOMEPHONE') : '6281808903132', ('CUSTOMERWORKPHONE') : '6281808903132', ('CUSTOMERBIRTHDAY') : '20101997'
        , ('PAYMENTAPPROVALCODE') : '', ('TRXCODE') : '', ('NOTE') : 'Success Notify', ('RESPONSE_RESULT') : 'REDIRECT', ('RESPONSE_MESSAGE') : 'PLEASE REDIRECT TO redirectUrl FOR CONTINUE THE PAYMENT'
        , ('RESPONSE_ERRORCODE') : '', ('DB_NOTIFYURL') : '', ('DB_INITPAYMENTURL') : 'https://partner.api.bri.co.id/oauth/client_credential/accesstoken?grant_type=client_credentials'
        , ('DB_PAYMENTURL') : 'https://partner.api.bri.co.id/ceria-sandbox/v1/merchant/charges', ('NOTIFYSTATUS') : NOTIFYSTATUS
        , ('RESPONSE_NOTIFY_STATUS') : 'OK', ('RESPONSE_NOTIFY_MESSAGE') : RESPONSE_NOTIFY_MESSAGE, ('JSON_AMOUNT') : '600000.00'
        , ('JSON_STATUS') : JSON_STATUS], FailureHandling.CONTINUE_ON_FAILURE)

CustomKeywords.'com.database.DBHelper.connectDBPostgres'()

CustomKeywords.'com.database.DBHelper.execute'(((('update transaction set payment_host_auth_id = \'' + paymentHostAuthId) + 
    '\' where invoice_number = \'') + INVOICENUMBER) + '\'')

CustomKeywords.'com.database.DBHelper.execute'(('update acquirer set void_url = \'' + refundUrlBriCeria) + '\' where id = \'1024\'')


int i
int j = 0

i = flag == 'retry' ? 3 : 1

'Refund Process'
for (j = 0; j < i; j++) {
    if ((j == 0) || (j == 1) ){
        expectedResponseCode = firstExpectedResponseCode
        expectedResponseMsg = firstExpectedResponseMsg
		AMOUNT = firstAmount
		
		CustomKeywords.'com.database.DBHelper.execute'(((('update transaction set payment_host_auth_id = \'' + paymentHostAuthId) +
			'\' where invoice_number = \'') + INVOICENUMBER) + '\'')
		
    }
	else
	{
		expectedResponseCode = lastExpectedResponseCode
		expectedResponseMsg = lastExpectedResponseMsg
		AMOUNT = lastAmount
		
		CustomKeywords.'com.database.DBHelper.execute'(((('update transaction set payment_host_auth_id = \'' + lastPaymentHostAuthId) +
			'\' where invoice_number = \'') + INVOICENUMBER) + '\'')
	}

	StringBuilder sb = new StringBuilder()
	sb.append(AMOUNT).append(MALLID).append(SHAREDKEY).append(refidmerchant).append(sessionId)
	words = Utils.generateWords(sb.toString())
	
WebUI.callTestCase(findTestCase('Cancellation/Template/Default_Cancellation'), [('MALLID') : MALLID, ('REFIDMERCHANT') : refidmerchant, ('TRANSIDMERCHANT') : INVOICENUMBER
        , ('APPROVALCODE') : APPROVALCODE, ('AMOUNT') : AMOUNT, ('CURRENCY') : CURRENCY, ('SESSIONID') : sessionId, ('WORDS') : words, ('REASON') : REASON
        , ('BANKDATA') : BANKDATA, ('DATA1') : DATA1, ('DATA2') : DATA2, ('DATA3') : DATA3, ('DATA4') : DATA4, ('REFUNDTYPE') : REFUNDTYPE, ('expectedResponseCode') : expectedResponseCode
        , ('expectedResponseMsg') : expectedResponseMsg, ('expectedTransIdMerchant') : INVOICENUMBER,('expectedSessionId') : sessionId
        , ('expectedRefIdMerchant') : refidmerchant], FailureHandling.CONTINUE_ON_FAILURE)

}
