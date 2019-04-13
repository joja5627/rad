package io.gccs.diagnostics.components;

import io.gccs.diagnostics.constants.GCCSConstants;
import io.gccs.diagnostics.constants.OSCommandConstants;
import io.gccs.diagnostics.domain.TestResults;
import io.gccs.diagnostics.domain.UserInputField;
import io.gccs.diagnostics.modules.ConfigAndTestRunner;
import io.gccs.diagnostics.services.OSCommandService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import static io.gccs.diagnostics.constants.OSCommandConstants.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Builder
@AllArgsConstructor
@Slf4j
public class ServiceRunningChecker implements ConfigAndTestRunner {

    private final OSCommandService osCommandService;
    private final String serviceName;
    private final String osCommand;
    private final String directoryPath;
    private final String checkTestType;
    private final List<UserInputField> UserInputField;
    private final TestResults testResults;
    /* Constructor
    - OsCommandService
    - Name
    - Command
    - Directory
    - List UserInputField
    - TestResults testResults
     */
    @Override
    public List<UserInputField> configPageRequirements(){
        return UserInputField;

    }

    @Override
    public TestResults setInputAndRunTest(Map<String, io.gccs.diagnostics.domain.UserInputField> inputs) {
        //does not need anything from user input at this time, so just get
        return executeTest();
    }

    public int executeServiceRunningCheck(String command, String directoryPath) throws InterruptedException,
            IOException {
        String stdOut = "";
        stdOut = osCommandService.runCommandToStdOut(command, directoryPath);
        if(checkTestType.equals(SERVICE_SHOULD_RUNNING)) {
            if (stdOut.contains("RUNNING")) {
                return 0;   //Service Running - PASS
            } else if (stdOut.contains("STOPPED")) {
                return 1;   //Service Not Running, Stopped - FAIL
            } else {
                return 2;   //Other errors, can't figure out service - FAIL
            }
        }
        else if(checkTestType.equals(SERVICE_SHOULD_STOPPED)) {
            if (stdOut.contains("RUNNING")) {
                return 1;   //Service Running - FAIL
            } else if (stdOut.contains("STOPPED")) {
                return 0;   //Service Not Running, Stopped - PASS
            } else {
                return 2;   //Other errors, can't figure out service - FAIL
            }
        }
        else {
            return 2;   //default return
        }
    }

    public TestResults executeTest() {
        int execSRCResult = 2; //Default state is failed - unable to determine failure reason
        int testPass = 0;   //default 0 is pass
        int testFail = 1;   //default 1 is fail
        try {
            execSRCResult = this.executeServiceRunningCheck(osCommand, directoryPath);
        }
        catch(InterruptedException ignored) {}
        catch(IOException e) {
            testResults.setStatus(GCCSConstants.FAIL);
            testResults.setMessage(String.format(OCS_EXECUTE_FAIL_CANNOT_DETERMINE,serviceName));
        }
        switch(execSRCResult) {
            case 0:
                testResults.setStatus(GCCSConstants.PASS);
                if(checkTestType.equals(SERVICE_SHOULD_RUNNING)) {
                    testResults.setMessage(String.format(OCS_EXECUTE_PASS, serviceName));
                }
                else if(checkTestType.equals(SERVICE_SHOULD_STOPPED)) {
                    testResults.setMessage(String.format(OCS_EXECUTE_FAIL_STOPPED, serviceName));
                }
                break;
            case 1:
                testResults.setStatus(GCCSConstants.FAIL);
                if(checkTestType.equals(SERVICE_SHOULD_RUNNING)) {
                    testResults.setMessage(String.format(OCS_EXECUTE_FAIL_STOPPED, serviceName));
                }
                else if(checkTestType.equals(SERVICE_SHOULD_STOPPED)) {
                    testResults.setMessage(String.format(OCS_EXECUTE_PASS, serviceName));
                }
                break;
            case 2:
                testResults.setStatus(GCCSConstants.FAIL);
                testResults.setMessage(String.format(OCS_EXECUTE_FAIL_CANNOT_DETERMINE,serviceName));
                break;
        }
        return testResults;
    }
}
