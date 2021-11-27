package allTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testClinica.AgregarMedicoTestEscenario1;
import testClinica.AgregarMedicoTestEscenario2;
import testClinica.AgregarPrestacionTestEscenario1;
import testClinica.AgregarPrestacionTestEscenario2;
import testClinica.AltaPacienteTestEscenario1;
import testClinica.AltaPacienteTestEscenario2;
import testClinica.AtenderPacienteTestEscenario1;
import testClinica.AtenderPacienteTestEscenario2;
import testClinica.ConsultarPacienteTestEscenario1;
import testClinica.ConsultarPacienteTestEscenario2;
import testClinica.DarAltaYFacturarTestEscenario1;
import testClinica.DarAltaYFacturarTestEscenario2;
import testClinica.DevuelveMedicoTestEscenario1;
import testClinica.DevuelveMedicoTestEscenario2;
import testClinica.ModPacienteDomTestEscenario1;
import testClinica.ModPacienteDomTestEscenario2;
import testClinica.ModPacienteNomyApeTestEscenario1;
import testClinica.ModPacienteNomyApeTestEscenario2;
import testClinica.ModPacienteTelTestEscenario1;
import testClinica.ModPacienteTelTestEscenario2;
import testClinica.ReporteActividadMedicaTestEscenario1;
import testClinica.removerMedicoTestE1;
import testClinica.removerMedicoTestE2;
import testClinica.removerPacienteTestE1;
import testClinica.removerPacienteTestE2;

@RunWith(Suite.class)
@SuiteClasses({ AgregarMedicoTestEscenario1.class, AgregarMedicoTestEscenario2.class,
		AgregarPrestacionTestEscenario1.class, AgregarPrestacionTestEscenario2.class, AltaPacienteTestEscenario1.class,
		AltaPacienteTestEscenario2.class, AtenderPacienteTestEscenario1.class, AtenderPacienteTestEscenario2.class,
		ConsultarPacienteTestEscenario1.class, ConsultarPacienteTestEscenario2.class,
		DarAltaYFacturarTestEscenario1.class, DarAltaYFacturarTestEscenario2.class, DevuelveMedicoTestEscenario1.class,
		DevuelveMedicoTestEscenario2.class, ModPacienteDomTestEscenario1.class, ModPacienteDomTestEscenario2.class,
		ModPacienteNomyApeTestEscenario1.class, ModPacienteNomyApeTestEscenario2.class,
		ModPacienteTelTestEscenario1.class, ModPacienteTelTestEscenario2.class, removerMedicoTestE1.class,
		removerMedicoTestE2.class, removerPacienteTestE1.class, removerPacienteTestE2.class,
		ReporteActividadMedicaTestEscenario1.class })
public class AllTestsClinica {

}
