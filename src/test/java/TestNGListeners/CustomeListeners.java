package TestNGListeners;

import org.testng.*;

public class CustomeListeners implements IExecutionListener, IInvokedMethodListener, ITestListener {

    public void onExecutionStart() {
        System.out.println("Test Suite Execution Starts!");
    }
    public void onExecutionFinish() {
        System.out.println("Test Suite Execution Finished!");
    }


    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {
        if(method.isTestMethod()) {
            System.out.println(method.getTestMethod().getMethodName() + " Test Case Starts!");
        }
    }
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        if(method.isTestMethod()) {
            System.out.println(method.getTestMethod().getMethodName() + " Test Case Finished!");
        }
    }


    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " Passed.");
    }
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " Failed.");
    }

}
