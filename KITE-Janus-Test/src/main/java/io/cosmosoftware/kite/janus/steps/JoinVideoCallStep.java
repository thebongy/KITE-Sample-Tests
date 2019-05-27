package io.cosmosoftware.kite.janus.steps;

import io.cosmosoftware.kite.exception.KiteTestException;
import io.cosmosoftware.kite.janus.pages.JanusPage;
import io.cosmosoftware.kite.steps.TestStep;
import org.openqa.selenium.WebDriver;



public class JoinVideoCallStep extends TestStep {

  private final String runnerId;
  private final String testCaseName;

  public JoinVideoCallStep(WebDriver webDriver, String runnerId, String testCaseName) {

    super(webDriver);
    this.runnerId = runnerId;
    this.testCaseName = testCaseName;

  }

  @Override
  public String stepDescription() {
    if (("000").equalsIgnoreCase(this.runnerId)){
      return "Wait for the user Bob" + testCaseName + " to answer" ;
    } else {
      return "Answer the call from Alice" + testCaseName ;
    }

  }

  @Override
  protected void step() throws KiteTestException {
    final JanusPage janusPage = new JanusPage(this.webDriver, this.logger);

    //for now, tupleSize has to be equal to 2
    //but need to adapt the following lines if we want to enable tupleSize>2


    if (("001").equalsIgnoreCase(runnerId)){
      janusPage.answerCall();
    }

  }
}
