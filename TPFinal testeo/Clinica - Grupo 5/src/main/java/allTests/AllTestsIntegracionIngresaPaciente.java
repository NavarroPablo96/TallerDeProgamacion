package allTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testIntegracionIngresaPaciente.TestCP1;
import testIntegracionIngresaPaciente.TestCP2;
import testIntegracionIngresaPaciente.TestCP3;
import testIntegracionIngresaPaciente.TestCP4;

@RunWith(Suite.class)
@SuiteClasses({ TestCP1.class, TestCP2.class, TestCP3.class, TestCP4.class })
public class AllTestsIntegracionIngresaPaciente {

}
