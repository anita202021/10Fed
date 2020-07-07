import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/feature/web/")
//@CucumberOptions(features="src/test/resources/feature/web/facility.feature")
public class RunTests {
}
