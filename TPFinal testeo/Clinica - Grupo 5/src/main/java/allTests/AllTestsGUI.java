package allTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import testGUI.GuiTestEnabledDisabled;
import testGUI.GuiTestPacientesNoVacio;
import testGUI.GuiTestPacientesVacio;

@RunWith(Suite.class)
@SuiteClasses({ GuiTestEnabledDisabled.class, GuiTestPacientesNoVacio.class, GuiTestPacientesVacio.class })
public class AllTestsGUI {

}
