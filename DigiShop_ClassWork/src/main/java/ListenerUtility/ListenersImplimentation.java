package ListenerUtility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import genericLibrary.DWBaseClass;

public class ListenersImplimentation extends DWBaseClass implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Execution Started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Execution Completed");
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + "Execution Started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + "Execution Completed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(LogStatus.FAIL, test.addScreenCapture(getScreenShotWebPage(driver)));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP,"Execution is Skipped" );
	}
}
