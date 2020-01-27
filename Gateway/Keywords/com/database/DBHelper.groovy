package com.database

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.sql.Connection



public class DBHelper {
	public static Connection connection = null;
	public static ResultSet rs=null;
	public static Statement stm = null;
	String url = 'localhost'
	String dbname='MIB'
	String port='5433'
	String username='postgres'
	String password='postgres'

	def initParams() {
		def containerEnv = System.getenv("CONTAINER_ENV");
		//if not null, we assume this script run on environment dev openshift (NTT)
		print("CONTAINER_ENV : "+containerEnv);
		if (containerEnv != null) {
			url='cm-mib-db'
			port='5433'
		}
	}
	/**
	 * Open and return a connection to database
	 * @param dataFile absolute file path
	 * @return an instance of java.sql.Connection
	 */

	//Establishing a connection to the DataBase

	@Keyword
	def connectDBPostgres(){
		initParams();
		Class.forName("org.postgresql.Driver");
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		println ("url ="+url.concat(":").concat(port).concat("/").concat(dbname))
		connection = DriverManager.getConnection("jdbc:postgresql://".concat(url.concat(":").concat(port).concat("/").concat(dbname)) , username, password)
		println ("jdbc:postgresql://".concat(url.concat(":").concat(port).concat("/").concat(dbname)) +", "+ username+ ", " + password)
		return connection
	}

	@Keyword
	def connectDBMerchantActivity(){
		initParams();
		Class.forName("org.postgresql.Driver");
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		println ("url ="+url.concat(":").concat(portAuditTrail).concat("/").concat(dbAuditTrail))
		connection = DriverManager.getConnection("jdbc:postgresql://".concat(url.concat(":").concat(portAuditTrail).concat("/").concat(dbAuditTrail)) , username, password)
		println ("jdbc:postgresql://".concat(url.concat(":").concat(portAuditTrail).concat("/").concat(dbAuditTrail)) +", "+ username+ ", " + password)
		return connection
	}


	/**	
	 * execute a SQL query on database
	 * @param queryString SQL query string
	 * @return a reference to returned data collection, an instance of java.sql.ResultSet
	 */

	//Executing the constructed Query and Saving results in resultset
	@Keyword
	def executeQuery(String queryString) {
		stm = connection.createStatement()
		rs = stm.executeQuery(queryString)
		return rs
	}

	//Executing query when value in numeric format
	@Keyword
	def executeQueryElementNumeric(String Table, String Key, String Value) {
		String element = 'select * from ' +Table +' where '+Key +'='+Value
		String queryString = element
		println(queryString)
		Statement stm = connection.createStatement()
		ResultSet rs1 = stm.executeQuery(queryString)
		return rs1
	}

	//Executing query when value in string format
	@Keyword
	def executeQueryElementString(String Table, String Key, String Value) {
		String element = "select * from " +Table +" where "+Key +"='"+Value+"'"
		String queryString = element
		println(queryString)
		Statement stm = connection.createStatement()
		ResultSet rs1 = stm.executeQuery(queryString)
		return rs1
	}

	@Keyword
	def executeQuery2ElementString(String Table, String Key, String Value, String Key2, String Value2) {
		String element = "select * from " +Table +" where "+Key +"='"+Value+"'"+" and "+Key2 +"='"+Value2+"'"
		String queryString = element
		println(queryString)
		Statement stm = connection.createStatement()
		ResultSet rs1 = stm.executeQuery(queryString)
		return rs1
	}
	/**
	 * Close a connection to database
	 * @param dataFile absolute file path
	 * @return an instance of java.sql.Connection
	 */

	//Closing the connection
	@Keyword
	def closeDatabaseConnection() {
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = null
	}

	/**
	 * Execute non-query (usually INSERT/UPDATE/DELETE/COUNT/SUM...) on database
	 * @param query a SQL statement	
	 * @return single value result of SQL statement	
	 */

	//Execute update,insert,delete
	@Keyword
	def execute(String query) {
		stm = connection.createStatement()
		boolean result = stm.execute(query)
		return result
	}



}
