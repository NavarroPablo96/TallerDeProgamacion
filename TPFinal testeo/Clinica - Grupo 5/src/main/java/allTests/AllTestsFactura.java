package allTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testFactura.TestMuestraPrestacionMedicoEscenario2;
import testFactura.TestMuestraPrestracionMedicoEscenario1;

@RunWith(Suite.class)
@SuiteClasses({ TestMuestraPrestacionMedicoEscenario2.class, TestMuestraPrestracionMedicoEscenario1.class })
public class AllTestsFactura {

}
