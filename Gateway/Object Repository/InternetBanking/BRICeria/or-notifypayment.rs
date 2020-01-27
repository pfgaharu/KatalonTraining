<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>or-notifypayment</name>
   <tag></tag>
   <elementGuidId>1129244d-5c9c-41ee-95ce-6ce932feb2fe</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n  \&quot;status\&quot;: \&quot;${NOTIFYSTATUS}\&quot;,\n  \&quot;message\&quot;: \&quot;${MESSAGE}\&quot;,\n  \&quot;transaction_id\&quot;: \&quot;${TRANSACTIONID}\&quot;,\n  \&quot;order_id\&quot;: \&quot;${ORDERID}\&quot;,\n  \&quot;amount\&quot;: ${AMOUNT}\n}&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>http://localhost:8080/MIB/BRICeriaNotify</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'SUCCESS'</defaultValue>
      <description></description>
      <id>4768d226-4b33-4f42-8bf5-4f9d0de898cb</id>
      <masked>false</masked>
      <name>NOTIFYSTATUS</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>ef66cfbe-9dd0-4994-afbd-ba8325074bf2</id>
      <masked>false</masked>
      <name>MESSAGE</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>faa679e7-35e5-4189-bc88-c536bd15131c</id>
      <masked>false</masked>
      <name>TRANSACTIONID</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>65558d86-c158-4b38-ae74-7c4d70e7069a</id>
      <masked>false</masked>
      <name>ORDERID</name>
   </variables>
   <variables>
      <defaultValue>'0'</defaultValue>
      <description></description>
      <id>68aab67a-0104-40ce-9e00-67cbeb282d15</id>
      <masked>false</masked>
      <name>AMOUNT</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
