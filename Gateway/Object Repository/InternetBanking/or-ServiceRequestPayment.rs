<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description>Test Api untuk melakukan proses payment dari customer ke BANK melalui Merchant ke API DOKU</description>
   <name>or-ServiceRequestPayment</name>
   <tag></tag>
   <elementGuidId>40b87f58-05da-4c11-95a6-43a820d7bf58</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;contentType&quot;: &quot;application/x-www-form-urlencoded&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;,
  &quot;parameters&quot;: [
    {
      &quot;name&quot;: &quot;SERVICEID&quot;,
      &quot;value&quot;: &quot;${SERVICEID}&quot;
    },
    {
      &quot;name&quot;: &quot;ACQUIRERID&quot;,
      &quot;value&quot;: &quot;${ACQUIRERID}&quot;
    },
    {
      &quot;name&quot;: &quot;MALLID&quot;,
      &quot;value&quot;: &quot;${MALLID}&quot;
    },
    {
      &quot;name&quot;: &quot;CHAINMALLID&quot;,
      &quot;value&quot;: &quot;${CHAINMALLID}&quot;
    },
    {
      &quot;name&quot;: &quot;INVOICENUMBER&quot;,
      &quot;value&quot;: &quot;${INVOICENUMBER}&quot;
    },
    {
      &quot;name&quot;: &quot;CURRENCY&quot;,
      &quot;value&quot;: &quot;${CURRENCY}&quot;
    },
    {
      &quot;name&quot;: &quot;AMOUNT&quot;,
      &quot;value&quot;: &quot;${AMOUNT}&quot;
    },
    {
      &quot;name&quot;: &quot;SESSIONID&quot;,
      &quot;value&quot;: &quot;${SESSIONID}&quot;
    },
    {
      &quot;name&quot;: &quot;WORDS&quot;,
      &quot;value&quot;: &quot;${WORDS}&quot;
    },
    {
      &quot;name&quot;: &quot;BASKET&quot;,
      &quot;value&quot;: &quot;${BASKET}&quot;
    },
    {
      &quot;name&quot;: &quot;DESCRIPTION&quot;,
      &quot;value&quot;: &quot;${DESCRIPTION}&quot;
    },
    {
      &quot;name&quot;: &quot;AUTH1&quot;,
      &quot;value&quot;: &quot;${AUTH1}&quot;
    },
    {
      &quot;name&quot;: &quot;AUTH2&quot;,
      &quot;value&quot;: &quot;${AUTH2}&quot;
    },
    {
      &quot;name&quot;: &quot;AUTH3&quot;,
      &quot;value&quot;: &quot;${AUTH3}&quot;
    },
    {
      &quot;name&quot;: &quot;AUTH4&quot;,
      &quot;value&quot;: &quot;${AUTH4}&quot;
    },
    {
      &quot;name&quot;: &quot;CUSTOMERNAME&quot;,
      &quot;value&quot;: &quot;${CUSTOMERNAME}&quot;
    },
    {
      &quot;name&quot;: &quot;CUSTOMEREMAIL&quot;,
      &quot;value&quot;: &quot;${CUSTOMEREMAIL}&quot;
    },
    {
      &quot;name&quot;: &quot;CUSTOMERMOBILEPHONE&quot;,
      &quot;value&quot;: &quot;${CUSTOMERMOBILEPHONE}&quot;
    },
    {
      &quot;name&quot;: &quot;TRANSACTIONTYPE&quot;,
      &quot;value&quot;: &quot;${TRANSACTIONTYPE}&quot;
    },
    {
      &quot;name&quot;: &quot;CUSTOMERIDENTIFIERNUMBER&quot;,
      &quot;value&quot;: &quot;${CUSTOMERIDENTIFIERNUMBER}&quot;
    },
    {
      &quot;name&quot;: &quot;PAYMENTTYPE&quot;,
      &quot;value&quot;: &quot;${PAYMENTTYPE}&quot;
    },
    {
      &quot;name&quot;: &quot;CUSTOMERREGION&quot;,
      &quot;value&quot;: &quot;${CUSTOMERREGION}&quot;
    },
    {
      &quot;name&quot;: &quot;CUSTOMERCITY&quot;,
      &quot;value&quot;: &quot;${CUSTOMERCITY}&quot;
    },
    {
      &quot;name&quot;: &quot;CUSTOMERADDRESS&quot;,
      &quot;value&quot;: &quot;${CUSTOMERADDRESS}&quot;
    },
    {
      &quot;name&quot;: &quot;CUSTOMERZIPCODE&quot;,
      &quot;value&quot;: &quot;${CUSTOMERZIPCODE}&quot;
    },
    {
      &quot;name&quot;: &quot;SHIPPING_ADDRESS&quot;,
      &quot;value&quot;: &quot;${SHIPPING_ADDRESS}&quot;
    },
    {
      &quot;name&quot;: &quot;SHIPPING_CITY&quot;,
      &quot;value&quot;: &quot;${SHIPPING_CITY}&quot;
    },
    {
      &quot;name&quot;: &quot;SHIPPING_ZIPCODE&quot;,
      &quot;value&quot;: &quot;${SHIPPING_ZIPCODE}&quot;
    },
    {
      &quot;name&quot;: &quot;SHIPPING_COUNTRY&quot;,
      &quot;value&quot;: &quot;${SHIPPING_COUNTRY}&quot;
    },
    {
      &quot;name&quot;: &quot;AIRLINESDATA&quot;,
      &quot;value&quot;: &quot;${AIRLINESDATA}&quot;
    },
    {
      &quot;name&quot;: &quot;STOREID&quot;,
      &quot;value&quot;: &quot;${STOREID}&quot;
    }
  ]
}</httpBodyContent>
   <httpBodyType>x-www-form-urlencoded</httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/x-www-form-urlencoded</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>http://localhost:8080/MIB/ServiceRequestPayment</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>a31526ca-2c2f-4db0-a4c4-6b91fd2355e0</id>
      <masked>false</masked>
      <name>SERVICEID</name>
   </variables>
   <variables>
      <defaultValue>'1023'</defaultValue>
      <description></description>
      <id>aef24505-3c5a-4ceb-855f-3e8814b3ce4b</id>
      <masked>false</masked>
      <name>ACQUIRERID</name>
   </variables>
   <variables>
      <defaultValue>'1'</defaultValue>
      <description></description>
      <id>d049f00f-b9ff-4efa-b362-1d328729fa22</id>
      <masked>false</masked>
      <name>MALLID</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>f2199bb6-fde2-4919-b287-8954f683b7cb</id>
      <masked>false</masked>
      <name>CHAINMALLID</name>
   </variables>
   <variables>
      <defaultValue>'S8VwBe6U1lyZqmF1'</defaultValue>
      <description></description>
      <id>22076176-c046-4cf4-91d3-f1dda78e9f3a</id>
      <masked>false</masked>
      <name>INVOICENUMBER</name>
   </variables>
   <variables>
      <defaultValue>'IDR'</defaultValue>
      <description></description>
      <id>9cdc37d7-27a9-4073-9123-ff21eb0fdcb6</id>
      <masked>false</masked>
      <name>CURRENCY</name>
   </variables>
   <variables>
      <defaultValue>'11000.00'</defaultValue>
      <description></description>
      <id>891b3fed-73ab-43ba-8378-a42cba942631</id>
      <masked>false</masked>
      <name>AMOUNT</name>
   </variables>
   <variables>
      <defaultValue>'gy7a9f79abt7f9af97tfd89afdafdsa'</defaultValue>
      <description></description>
      <id>ff8abc57-6427-4410-b696-d1ed2af0b922</id>
      <masked>false</masked>
      <name>SESSIONID</name>
   </variables>
   <variables>
      <defaultValue>'4b034c12175e62bfa25d977244ea1edc6db4e9d4'</defaultValue>
      <description></description>
      <id>a5c5bf80-1b68-433d-a491-d070c6c7bb3a</id>
      <masked>false</masked>
      <name>WORDS</name>
   </variables>
   <variables>
      <defaultValue>'Movie FEMALE AGENTS,69000.00,3,69000.00'</defaultValue>
      <description></description>
      <id>6a12f49e-980c-4f0a-ae20-fd5ab4f68e89</id>
      <masked>false</masked>
      <name>BASKET</name>
   </variables>
   <variables>
      <defaultValue>'Payment Description'</defaultValue>
      <description></description>
      <id>a5238618-40b2-4d80-910b-ba988c78e247</id>
      <masked>false</masked>
      <name>DESCRIPTION</name>
   </variables>
   <variables>
      <defaultValue>'085697719167'</defaultValue>
      <description></description>
      <id>2216c5e2-1c33-473e-9781-aa61fcbffd7d</id>
      <masked>false</masked>
      <name>AUTH1</name>
   </variables>
   <variables>
      <defaultValue>'085697719167'</defaultValue>
      <description></description>
      <id>faa76e04-ee9a-46b5-a732-2a3ef6365325</id>
      <masked>false</masked>
      <name>AUTH2</name>
   </variables>
   <variables>
      <defaultValue>'085697719167'</defaultValue>
      <description></description>
      <id>398d1621-b12c-4088-a82e-4bb4801b3065</id>
      <masked>false</masked>
      <name>AUTH3</name>
   </variables>
   <variables>
      <defaultValue>'085697719167'</defaultValue>
      <description></description>
      <id>f9f70b99-50de-44d4-ae6a-e24610a31e2d</id>
      <masked>false</masked>
      <name>AUTH4</name>
   </variables>
   <variables>
      <defaultValue>'Taufik Ismail'</defaultValue>
      <description></description>
      <id>9c341ef1-bc8f-4421-a5af-dd82a5d0c86b</id>
      <masked>false</masked>
      <name>CUSTOMERNAME</name>
   </variables>
   <variables>
      <defaultValue>'taufik@nsiapay.com'</defaultValue>
      <description></description>
      <id>3bfbf3e3-f462-4627-8fd0-ae6089b23686</id>
      <masked>false</masked>
      <name>CUSTOMEREMAIL</name>
   </variables>
   <variables>
      <defaultValue>'6281808903132'</defaultValue>
      <description></description>
      <id>856dc577-e73a-440a-85bf-d1fe57e9d807</id>
      <masked>false</masked>
      <name>CUSTOMERMOBILEPHONE</name>
   </variables>
   <variables>
      <defaultValue>'S'</defaultValue>
      <description></description>
      <id>01697a91-68f2-46d4-aad1-c6930fb57c0b</id>
      <masked>false</masked>
      <name>TRANSACTIONTYPE</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>cb27ede9-c49f-406c-8d3f-bcac0b3e4909</id>
      <masked>false</masked>
      <name>CUSTOMERIDENTIFIERNUMBER</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>4731c200-2945-409e-918b-38b92061cb50</id>
      <masked>false</masked>
      <name>PAYMENTTYPE</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>f57e720c-3769-4673-ba2f-508ef5714125</id>
      <masked>false</masked>
      <name>CUSTOMERREGION</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>8a2247df-ae63-4ff9-9721-06d45f51ab78</id>
      <masked>false</masked>
      <name>CUSTOMERCITY</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>0495b2d1-925a-49ac-93db-035cdb8bb3bf</id>
      <masked>false</masked>
      <name>CUSTOMERADDRESS</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>ff09419a-84c9-4a4d-94fd-acc58e63f2b4</id>
      <masked>false</masked>
      <name>CUSTOMERZIPCODE</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>822b1886-27ad-4048-bedd-e03e2c24e25b</id>
      <masked>false</masked>
      <name>SHIPPING_ADDRESS</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>3eff7cb6-0b22-46db-82b9-a1f6fc483414</id>
      <masked>false</masked>
      <name>SHIPPING_CITY</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>25780075-7ec5-4afe-8986-3ac98d60932e</id>
      <masked>false</masked>
      <name>SHIPPING_ZIPCODE</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>bee061c2-b2fa-4a93-b8bd-1e7ac712d8b4</id>
      <masked>false</masked>
      <name>SHIPPING_COUNTRY</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>c2f11e89-662b-43a6-809c-647b4800d73c</id>
      <masked>false</masked>
      <name>AIRLINESDATA</name>
   </variables>
   <variables>
      <defaultValue>''</defaultValue>
      <description></description>
      <id>3032fb8e-8668-4dfc-9471-4319a5776976</id>
      <masked>false</masked>
      <name>STOREID</name>
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
response.setContentType(&quot;application/xhtml+xml&quot;)</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
