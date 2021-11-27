package allTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testIntegracionAtencionPaciente.TestCP1;
import testIntegracionAtencionPaciente.TestCP2;
import testIntegracionAtencionPaciente.TestCP3;

@RunWith(Suite.class)
@SuiteClasses({ TestCP1.class, TestCP2.class, TestCP3.class })
public class AllTestsIntegracionAtencionPaciente {

}
