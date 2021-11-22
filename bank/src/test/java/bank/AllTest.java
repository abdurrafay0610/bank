package bank;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ account_test.class, checking_test.class, saving_test.class })
public class AllTest
{

}
