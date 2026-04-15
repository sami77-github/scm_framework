package com.scm.login_verifications;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.scm.baseclasses.AdminBaseClass;


@Listeners(com.scm.listenerimppackage.ListenerImpClass.class)
public class Temp extends AdminBaseClass {

	@Test
		public void test() {
		String ExpectedName = "sami";
		String ActualName = "samiuddin";
		Assert.assertEquals(ActualName, ExpectedName);
	}
}
