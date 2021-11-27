package testSala_Privada;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)

@SuiteClasses({AgregarPacienteTest.class, QuitaPacienteTestE2.class, QuitaPacienteTestE1.class})
public class AllTests
{
	
}
