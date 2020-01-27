package utils
import java.security.MessageDigest

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.testobject.ResponseObject

import groovy.json.JsonSlurper
import groovy.util.slurpersupport.NodeChild
import doku.mib.util.MIBEncryptionUtil as MIBEncryptionUtil;


public class Utils {
	public static def generateInvoice() {
		Date dte=new Date();
		long milliSeconds = dte.getTime();
		String strLong = Long.toString(milliSeconds);
		return strLong;
	}


	public static def generateWords(String words) {
		MessageDigest sha1 = MessageDigest.getInstance("SHA1")
		byte[] digest  = sha1.digest(words.getBytes());
		String result = new  BigInteger(1, digest).toString(16).padLeft(40, '0')
		return result;
	}

	@Keyword
	def getXMLValue(String xmlValue, String tagData) {
		String resultData = new XmlSlurper().parseText(xmlValue).getProperty(tagData).toString();
		println(resultData);
		return (resultData);
	}

	@Keyword
	def generateEndPoint(String env, String path) {
		println("CONTAINER_DEV: " + env)
		String endPoint = ""
		if (env != null){
			if (path.contains('MVA')){
				endPoint = "http://cm-mva:8080/"
			} else if (path.contains('MIB')){
				endPoint = "http://cm-mib:8080/"
			} else {
				endPoint = "http://cm-mpg:8080/"
			}
		} else {
			endPoint = "http://localhost:8080/"
		}
		endPoint += path
		println("END_POINT: " + endPoint)
		return endPoint
	}

	@Keyword
	def jsonParsingToMap (ResponseObject response) {
		String temp = response.getResponseBodyContent()
		def jsonSlurper = new JsonSlurper()
		def object = jsonSlurper.parseText(temp)
		return object //as Map
	}

	@Keyword
	def generateSignatureBriCeria(String wordsComponents) {
		MIBEncryptionUtil encUtil = new MIBEncryptionUtil()
		println(wordsComponents)
		def words = encUtil.encrypt(wordsComponents)
		println(words)
		return words
	}

	@Keyword
	def xmlParsing (ResponseObject response) {
		String temp = response.getResponseBodyContent()
		def xmlSlurper = new XmlSlurper()
		def object = xmlSlurper.parseText(temp)
		return object
	}

	def getXmlPropertyValue (ResponseObject response, String key) {
		NodeChild object = xmlParsing(response)
		return object.getProperty(key).text()
	}

	@Keyword
	def checkStringValue(String data) {
		if (data != '' && data != null) {
			return true
		}
		return false
	}
}
