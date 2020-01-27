
/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */

import java.lang.String

import com.kms.katalon.core.testobject.ResponseObject


def static "utils.Utils.getXMLValue"(
    	String xmlValue	
     , 	String tagData	) {
    (new utils.Utils()).getXMLValue(
        	xmlValue
         , 	tagData)
}

def static "utils.Utils.generateEndPoint"(
    	String env	
     , 	String path	) {
    (new utils.Utils()).generateEndPoint(
        	env
         , 	path)
}

def static "utils.Utils.jsonParsingToMap"(
    	ResponseObject response	) {
    (new utils.Utils()).jsonParsingToMap(
        	response)
}

def static "utils.Utils.generateSignatureBriCeria"(
    	String wordsComponents	) {
    (new utils.Utils()).generateSignatureBriCeria(
        	wordsComponents)
}

def static "utils.Utils.xmlParsing"(
    	ResponseObject response	) {
    (new utils.Utils()).xmlParsing(
        	response)
}

def static "utils.Utils.checkStringValue"(
    	String data	) {
    (new utils.Utils()).checkStringValue(
        	data)
}

def static "com.database.DBHelper.connectDBPostgres"() {
    (new com.database.DBHelper()).connectDBPostgres()
}

def static "com.database.DBHelper.connectDBMerchantActivity"() {
    (new com.database.DBHelper()).connectDBMerchantActivity()
}

def static "com.database.DBHelper.executeQuery"(
    	String queryString	) {
    (new com.database.DBHelper()).executeQuery(
        	queryString)
}

def static "com.database.DBHelper.executeQueryElementNumeric"(
    	String Table	
     , 	String Key	
     , 	String Value	) {
    (new com.database.DBHelper()).executeQueryElementNumeric(
        	Table
         , 	Key
         , 	Value)
}

def static "com.database.DBHelper.executeQueryElementString"(
    	String Table	
     , 	String Key	
     , 	String Value	) {
    (new com.database.DBHelper()).executeQueryElementString(
        	Table
         , 	Key
         , 	Value)
}

def static "com.database.DBHelper.executeQuery2ElementString"(
    	String Table	
     , 	String Key	
     , 	String Value	
     , 	String Key2	
     , 	String Value2	) {
    (new com.database.DBHelper()).executeQuery2ElementString(
        	Table
         , 	Key
         , 	Value
         , 	Key2
         , 	Value2)
}

def static "com.database.DBHelper.closeDatabaseConnection"() {
    (new com.database.DBHelper()).closeDatabaseConnection()
}

def static "com.database.DBHelper.execute"(
    	String query	) {
    (new com.database.DBHelper()).execute(
        	query)
}
