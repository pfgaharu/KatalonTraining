package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object hostNameOCOLocal
     
    /**
     * <p></p>
     */
    public static Object G_responseServiceRequestPayment
     
    /**
     * <p></p>
     */
    public static Object G_billReferenceNo
     
    /**
     * <p></p>
     */
    public static Object G_trxCode
     
    /**
     * <p></p>
     */
    public static Object G_invoiceNumber
     
    /**
     * <p></p>
     */
    public static Object G_redirectUrl
     
    /**
     * <p></p>
     */
    public static Object G_paymentHostRefNumber
     
    /**
     * <p></p>
     */
    public static Object G_Refnum
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += RunConfiguration.getOverridingParameters()
    
            hostNameOCOLocal = selectedVariables['hostNameOCOLocal']
            G_responseServiceRequestPayment = selectedVariables['G_responseServiceRequestPayment']
            G_billReferenceNo = selectedVariables['G_billReferenceNo']
            G_trxCode = selectedVariables['G_trxCode']
            G_invoiceNumber = selectedVariables['G_invoiceNumber']
            G_redirectUrl = selectedVariables['G_redirectUrl']
            G_paymentHostRefNumber = selectedVariables['G_paymentHostRefNumber']
            G_Refnum = selectedVariables['G_Refnum']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
