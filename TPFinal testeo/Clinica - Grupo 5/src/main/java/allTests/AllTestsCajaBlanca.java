package allTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testCajaBlanca.TestCalculoImporteAdicionalC2;
import testCajaBlanca.TestCalculoImporteAdicionalesC7;
import testCajaBlanca.TestCalculoImporteAdionalesC1;

@RunWith(Suite.class)
@SuiteClasses({ TestCalculoImporteAdicionalC2.class, TestCalculoImporteAdicionalesC7.class,
		TestCalculoImporteAdionalesC1.class })
public class AllTestsCajaBlanca {

}
