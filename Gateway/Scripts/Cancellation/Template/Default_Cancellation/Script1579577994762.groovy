import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable


RequestObject requestCancel = findTestObject("Template/Default_RESTFul");
List<TestObjectProperty> restParameters = new ArrayList();

restParameters.add(new TestObjectProperty("MALLID", ConditionType.EQUALS, MALLID))
restParameters.add(new TestObjectProperty("REFIDMERCHANT", ConditionType.EQUALS, REFIDMERCHANT))
restParameters.add(new TestObjectProperty("TRANSIDMERCHANT", ConditionType.EQUALS, TRANSIDMERCHANT))
restParameters.add(new TestObjectProperty("APPROVALCODE", ConditionType.EQUALS, APPROVALCODE))
restParameters.add(new TestObjectProperty("AMOUNT", ConditionType.EQUALS, AMOUNT))
restParameters.add(new TestObjectProperty("CURRENCY", ConditionType.EQUALS, CURRENCY))
restParameters.add(new TestObjectProperty("SESSIONID", ConditionType.EQUALS, SESSIONID))
restParameters.add(new TestObjectProperty("WORDS", ConditionType.EQUALS, WORDS))
restParameters.add(new TestObjectProperty("REASON", ConditionType.EQUALS, REASON))
restParameters.add(new TestObjectProperty("BANKDATA", ConditionType.EQUALS, BANKDATA))
restParameters.add(new TestObjectProperty("DATA1", ConditionType.EQUALS, DATA1))
restParameters.add(new TestObjectProperty("DATA2", ConditionType.EQUALS, DATA2))
restParameters.add(new TestObjectProperty("DATA3", ConditionType.EQUALS, DATA3))
restParameters.add(new TestObjectProperty("DATA4", ConditionType.EQUALS, DATA4))
restParameters.add(new TestObjectProperty("REFUNDTYPE", ConditionType.EQUALS, REFUNDTYPE))


restURL = GlobalVariable.hostNameOCOLocal+"/DoCancelRequest"

requestCancel.setRestParameters(restParameters)
requestCancel.setRestUrl(restURL)
requestCancel.setRestRequestMethod("POST")

response = WS.sendRequest(requestCancel)
response.setContentType('text/xml')
WebUI.comment(response.getResponseBodyContent())

'Do Verify Response Cancelation'
if (CustomKeywords.'utils.Utils.getXMLValue'(response.getResponseBodyContent(), 'REFNUM') != '') {
	WS.verifyMatch(CustomKeywords.'utils.Utils.getXMLValue'(response.getResponseBodyContent(), 'RESPONSECODE'), expectedResponseCode, false, FailureHandling.CONTINUE_ON_FAILURE)
	WS.verifyMatch(CustomKeywords.'utils.Utils.getXMLValue'(response.getResponseBodyContent(), 'RESPONSEMSG'), expectedResponseMsg, false,FailureHandling.CONTINUE_ON_FAILURE)
	WS.verifyMatch(CustomKeywords.'utils.Utils.getXMLValue'(response.getResponseBodyContent(), 'TRANSIDMERCHANT'), expectedTransIdMerchant, false,FailureHandling.CONTINUE_ON_FAILURE)
	WS.verifyMatch(CustomKeywords.'utils.Utils.getXMLValue'(response.getResponseBodyContent(), 'SESSIONID'), expectedSessionId, false,FailureHandling.CONTINUE_ON_FAILURE)
	WS.verifyMatch(CustomKeywords.'utils.Utils.getXMLValue'(response.getResponseBodyContent(), 'REFIDMERCHANT'), expectedRefIdMerchant, false,FailureHandling.CONTINUE_ON_FAILURE)
	
	expRefNum= CustomKeywords.'utils.Utils.getXMLValue'(response.getResponseBodyContent(), 'REFNUM')
	println(expRefNum)
	
	GlobalVariable.G_Refnum = expRefNum
	CustomKeywords.'utils.Utils.checkStringValue'(expRefNum)
	}
	else
	{
	WS.verifyMatch(CustomKeywords.'utils.Utils.getXMLValue'(response.getResponseBodyContent(), 'RESPONSECODE'), expectedResponseCode, false, FailureHandling.CONTINUE_ON_FAILURE)
	WS.verifyMatch(CustomKeywords.'utils.Utils.getXMLValue'(response.getResponseBodyContent(), 'RESPONSEMSG'), expectedResponseMsg, false,FailureHandling.CONTINUE_ON_FAILURE)
	WS.verifyMatch(CustomKeywords.'utils.Utils.getXMLValue'(response.getResponseBodyContent(), 'TRANSIDMERCHANT'), expectedTransIdMerchant, false,FailureHandling.CONTINUE_ON_FAILURE)
	WS.verifyMatch(CustomKeywords.'utils.Utils.getXMLValue'(response.getResponseBodyContent(), 'SESSIONID'), expectedSessionId, false,FailureHandling.CONTINUE_ON_FAILURE)
	WS.verifyMatch(CustomKeywords.'utils.Utils.getXMLValue'(response.getResponseBodyContent(), 'REFNUM'), '', false,FailureHandling.CONTINUE_ON_FAILURE)
	WS.verifyMatch(CustomKeywords.'utils.Utils.getXMLValue'(response.getResponseBodyContent(), 'REFIDMERCHANT'), expectedRefIdMerchant, false,FailureHandling.CONTINUE_ON_FAILURE)
	}

