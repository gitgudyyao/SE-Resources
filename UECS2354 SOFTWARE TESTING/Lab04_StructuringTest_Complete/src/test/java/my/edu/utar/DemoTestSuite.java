package my.edu.utar;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = { SimpleClassTestV1.class, SimpleClassTestV2.class, SimpleClassTestV3.class,
		DemoExceptionsTest.class, DemoSetupTest.class })
public class DemoTestSuite {

}
