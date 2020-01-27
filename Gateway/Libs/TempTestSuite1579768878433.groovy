import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.reporting.ReportUtil
import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.testdata.TestDataColumn
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import internal.GlobalVariable as GlobalVariable

Map<String, String> suiteProperties = new HashMap<String, String>();


suiteProperties.put('id', 'Test Suites/InternetBanking/BRICeria/Refund')

suiteProperties.put('name', 'Refund')

suiteProperties.put('description', '')
 

DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())



RunConfiguration.setExecutionSettingFile("/Users/prant/project/gateway-automatedtest/Gateway/Reports/InternetBanking/BRICeria/Refund/20200123_154118/execution.properties")

TestCaseMain.beforeStart()

TestCaseMain.startTestSuite('Test Suites/InternetBanking/BRICeria/Refund', suiteProperties, [new TestCaseBinding('Test Cases/Cancellation/BRI Ceria/TC01-SuccessRefund', 'Test Cases/Cancellation/BRI Ceria/TC01-SuccessRefund',  [ 'lastExpectedResponseCode' : '' , 'lastPaymentHostAuthId' : '' , 'BANKDATA' : '' , 'SHAREDKEY' : '123' , 'JSON_STATUS' : 'SUCCESS' , 'lastExpectedResponseMsg' : '' , 'firstAmount' : '600000.00' , 'flag' : '' , 'RESPONSE_NOTIFY_MESSAGE' : 'Payment is success' , 'DATA1' : '' , 'DATA2' : '' , 'DATA3' : '' , 'DATA4' : '' , 'paymentHostAuthId' : 'successRefund' , 'CURRENCY' : '' , 'firstExpectedResponseMsg' : 'REFUNDED' , 'MALLID' : '1' , 'REASON' : 'refund' , 'refundUrlBriCeria' : 'http://demo1010380.mockable.io/' , 'firstExpectedResponseCode' : '0000' , 'testCaseDesc' : 'SuccessRefund' , 'REFUNDTYPE' : '' , 'NOTIFYSTATUS' : 'success' , 'lastAmount' : '' ,  ])])
