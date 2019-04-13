package io.gccs.diagnostics.components;

import io.gccs.diagnostics.domain.TestResults;
import io.gccs.diagnostics.services.OSCommandService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static io.gccs.diagnostics.constants.GCCSConstants.CATEGORY_SERVICE;
import static io.gccs.diagnostics.constants.OSCommandConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("integration-test")
public class ServiceRunningCheckerTest {

    OSCommandService ocsmock;
    private TestResults expectedresults = TestResults.builder()
            .name(NAME_ACTIVEMQ)
            .description(DESC_ACTIVEMQ)
            .category(CATEGORY_SERVICE)
            .build();

    private TestResults actualresults;
    private ServiceRunningChecker serviceRunningChecker;


    @Before
    public void before() {
        ocsmock = Mockito.mock(OSCommandService.class);
        serviceRunningChecker = new ServiceRunningChecker(ocsmock,NAME_ACTIVEMQ,COMMAND_ACTIVEMQ,DIR_ACTIVEMQ, SERVICE_SHOULD_RUNNING, USER_INPUT_FIELDS_ACTIVEMQ, expectedresults);
    }

    @After
    public void after() {

    }

    @Test
    public void getShouldPass() throws Exception{
        expectedresults.setStatus("Pass");
        expectedresults.setMessage(OCS_EXECUTE_PASS);
        Mockito.when(ocsmock.runCommandToStdOut(anyString(),  anyString())).thenReturn("RUNNING");
        actualresults = serviceRunningChecker.executeTest();

        assertEquals(expectedresults, actualresults);
    }

    @Test
    public void getShouldFailStopped() throws Exception{

        expectedresults.setStatus("Fail");
        expectedresults.setMessage(OCS_EXECUTE_FAIL_STOPPED);
        Mockito.when(ocsmock.runCommandToStdOut(anyString(),  anyString())).thenReturn("STOPPED");
        actualresults = serviceRunningChecker.executeTest();

        assertEquals(expectedresults, actualresults);
    }

    @Test
    public void getShouldFailNotDeterminable() throws Exception{
        //Mockito.doReturn(0).when(srcspy).executeServiceRunningCheck(command, directoryPath);
        expectedresults.setStatus("Fail");
        expectedresults.setMessage(OCS_EXECUTE_FAIL_CANNOT_DETERMINE);
        Mockito.when(ocsmock.runCommandToStdOut(anyString(),  anyString())).thenReturn("N/A");
        actualresults = serviceRunningChecker.executeTest();

        assertEquals(expectedresults, actualresults);
    }
    /*
    Test get() return TestResults with right status/message appended
    Test doComparison() return 0,1,2
     */


}
