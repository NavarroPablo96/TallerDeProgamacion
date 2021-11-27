package allTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testPatio.ListaPacienteTestEscenario1;
import testPatio.ListaPacienteTestEscenario2;
import testPatio.MuestraPacienteTestEscenario1;
import testPatio.MuestraPacienteTestEscenario2;
import testPatio.QuitaPacienteTestEscenario1;
import testPatio.QuitaPacienteTestEscenario2;
import testPatio.TestAgregarPacienteEscenario1;
import testPatio.TestAgregarPacienteEscenario2;

@RunWith(Suite.class)
@SuiteClasses({ ListaPacienteTestEscenario1.class, ListaPacienteTestEscenario2.class,
		MuestraPacienteTestEscenario1.class, MuestraPacienteTestEscenario2.class, QuitaPacienteTestEscenario1.class,
		QuitaPacienteTestEscenario2.class, TestAgregarPacienteEscenario1.class, TestAgregarPacienteEscenario2.class })
public class AllTestsPatio {

}
