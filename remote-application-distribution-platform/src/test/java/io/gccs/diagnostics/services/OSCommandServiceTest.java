package io.gccs.diagnostics.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("integration-test")
public class OSCommandServiceTest {
    @Autowired
    private OSCommandService osCommandService;

    public final String sourceDirPath = "src/test/resources/test-directory";
    public final String command = "cmd /c ipconfig";   //test command used for majority of tests in this class

    @Before
    public void before() {
    }

    @After
    public void After() {
        File folder = new File(sourceDirPath);
        File[] listOfFiles = folder.listFiles();
            if(listOfFiles != null) {
                for(File f: listOfFiles) {
                    if(!f.isDirectory() && !f.getName().equals("empty test file"))
                        f.delete();
                }
            }
    }


    //TODO fix broken tests in this class

    //Test A - testing runCommandToFile() Function in OSCommandService.class Service

    //Test 1 - Successfully Pass
    @Test
    public void runCommandToFileSuccessfully() throws Exception {
            String fileName = "runCommandToFile.txt";
            osCommandService.runCommandToFile(command, sourceDirPath, fileName);
            File runCommandToFileSuccessFullyFile = new File(sourceDirPath + "/runCommandToFile.txt");

            //assertTrue(command) -> Command should return True since file can be created, so its True
            assertTrue(runCommandToFileSuccessFullyFile.exists());
    }

    //Test 2 - File Should not be created since filepath is incorrectly provided.
    @Test(expected = IOException.class)
    public void runCommandToFileUnsuccessfully() throws Exception {
        String fileName = "runCommandToFileIncorrectly.txt";
        String incorrectDirPath = "src/test/resources/test-directory/testfolder2";
        osCommandService.runCommandToFile(command, incorrectDirPath, fileName);
        File runCommandToFileUnsuccessfullyFile = new File(incorrectDirPath +
                "/runCommandToFileIncorrectly.txt");

        //assertFalse(command) -> Command should return True since file cannot be created, so its false
        assertFalse(runCommandToFileUnsuccessfullyFile.exists());

    }

    //Test 3 - Empty Parameters should throw IO Exception
    @Test(expected = IOException.class)
    public void runCommandToFileWithEmptyParameters() throws Exception {
        osCommandService.runCommandToFile(" ", " "," ");
    }

    //Test B - testing runCommandToStdOut() function in OSCommandService.class

    //Test 1 - Successfully Pass
    @Test
    public void runCommandToStdOutSuccessFully() throws Exception {
        String stdOutResult = osCommandService.runCommandToStdOut("cmd /c ipconfig", sourceDirPath);

        //assertTrue(command) -> Command should return True if ipconfig succesfully ran,
        //                       as the first line in output is 'Windows IP Configuration'
        assertTrue(stdOutResult.contains("Windows IP Configuration"));
    }

    //Test 2 - Should fail and throw IOException, Path is incorrect
    @Test(expected = IOException.class)
    public void runCommandToStdOutUnsuccessfully() throws Exception{
        String wrongcommand = "ipcofig"; //incorrect command
        String stdOutResult = osCommandService.runCommandToStdOut(wrongcommand, sourceDirPath);

    }

    //Test 3 - Both Parameters are Empty, should return array index out of bounds exception
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void runCommandToStdOutWithBothEmptyParameters() throws Exception{
        String stdOutResult = osCommandService.runCommandToStdOut(" ", " ");
    }

    //Test C - testing runCommand() function in OSCommandService.class

    //Test 1 - Successfully Pass
//    @Test
//    public void runCommandSuccessfully() throws Exception{
//        String rcCommand = "msinfo32 /report msinfo32.txt";
//        osCommandService.runCommand(rcCommand, sourceDirPath);
//        File msinfo32CreatedSuccessfullyFile = new File(sourceDirPath + "/msinfo32.txt");
//
//        //assertTrue(command) -> Command should return True since file can be created, so its True
//        assertTrue(msinfo32CreatedSuccessfullyFile.exists());
//    }

    //Test 2 - Unsuccessful due to incorrect file path
    @Test(expected = IOException.class)
    public void rumCommandUnsuccessfully() throws Exception{
        String rcCommand = "msinfo32 /report msinfo32.txt";
        String incorrectDirectory = sourceDirPath + "/testfiles";
        osCommandService.runCommand(rcCommand, incorrectDirectory);
        File msinfo32CreatedUnsuccessfullyFile = new File(incorrectDirectory + "/msinfo32.txt");
    }

    //Test 3 - Command string passed is empty
    @Test(expected = IOException.class)
    public void runCommandWithEmptyCommand() throws Exception{
        String rcCommand = "";
        osCommandService.runCommand(rcCommand, sourceDirPath);
        //Throws IOException if command is empty: "Parameter is Incorrect"
    }











}
