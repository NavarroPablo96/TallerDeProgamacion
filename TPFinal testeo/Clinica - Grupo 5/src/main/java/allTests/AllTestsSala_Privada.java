package allTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testSala_Privada.AgregarPacienteTest;
import testSala_Privada.QuitaPacienteTestE1;
import testSala_Privada.QuitaPacienteTestE2;


@RunWith(Suite.class)

@SuiteClasses({AgregarPacienteTest.class, QuitaPacienteTestE2.class, QuitaPacienteTestE1.class})
public class AllTestsSala_Privada
{
	
}
