package io.gccs.diagnostics.components;


import io.gccs.diagnostics.constants.GCCSConstants;
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

import java.util.HashMap;

import static io.gccs.diagnostics.constants.OSCommandConstants.*;
import static io.gccs.diagnostics.constants.WindowsConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("integeration-test")
public class DriveSizeValidatorTest {

    //Validate doComparison

    private OSCommandService osCommandService;
    private DriveSizeValidator driveSizeValidator;

    private HashMap<String, Integer> wrongAllocationsExpected;

    @Before
    public void before() {
        osCommandService = Mockito.mock(OSCommandService.class);
    }

    @After
    public void after() {

    }

    @Test
    public void doComparisonShouldPass() throws Exception{
        TestResults baseResults =
            TestResults.builder()
                .name(DSV_ALLOC_NAME)
                .description(DSV_ALLOC_DESC)
                .category(DSV_CATEGORY)
                .build();
        TestResults expectedResults =
            TestResults.builder()
                .name(DSV_ALLOC_NAME)
                .description(DSV_ALLOC_DESC)
                .category(DSV_CATEGORY)
                .status(GCCSConstants.PASS)
                .message(DSV_ALLOC_SUCCESS)
                .build();
        driveSizeValidator = new DriveSizeValidator(osCommandService, USER_INPUT_FIELDS_DSV,
                APP_SERVER_DRIVE_ALLOCATIONS, COMMAND_TEMPLATE_DRIVE_ALLOC, DIR_DRIVE_DSV,
                baseResults);
        when(osCommandService.runCommandToStdOut(any(), any()))
            .thenReturn("C:         53687091200")
            .thenReturn("E:         21474836480")
            .thenReturn("F:         42949672960")
            .thenReturn("G:        214748364800")
            .thenReturn("Q:          2147483648")
            .thenReturn("T:          5368709120")
            .thenReturn("X:         53687091200");

        baseResults = driveSizeValidator.executeTest();

        assertEquals(baseResults, expectedResults);

    }

    @Test
    public void doComparisonShouldFailWrongAllocation() throws Exception {
        TestResults baseResults =
            TestResults.builder()
                .name(DSV_ALLOC_NAME)
                .description(DSV_ALLOC_DESC)
                .category(DSV_CATEGORY)
                .build();
        TestResults expectedResults =
            TestResults.builder()
                .name(DSV_ALLOC_NAME)
                .description(DSV_ALLOC_DESC)
                .category(DSV_CATEGORY)
                .status(GCCSConstants.FAIL)
                .message("C: drive has been allocated incorrectly. Q: drive has been allocated incorrectly. ")
                .build();
        driveSizeValidator = new DriveSizeValidator(osCommandService, USER_INPUT_FIELDS_DSV,
                APP_SERVER_DRIVE_ALLOCATIONS, COMMAND_TEMPLATE_DRIVE_ALLOC, DIR_DRIVE_DSV,
                baseResults);
        when(osCommandService.runCommandToStdOut(any(), any()))
            .thenReturn("C:         33687091200")   //fail
            .thenReturn("E:         21474836480")
            .thenReturn("F:         42949672960")
            .thenReturn("G:        214748364800")
            .thenReturn("Q:          6147483648")   //fail
            .thenReturn("T:          5368709120")
            .thenReturn("X:         53687091200");

        baseResults = driveSizeValidator.executeTest();

        assertEquals(baseResults, expectedResults);
    }

    @Test
    public void doComparisonShouldFailWrongDrives() throws Exception {
        TestResults baseResults =
            TestResults.builder()
                .name(DSV_ALLOC_NAME)
                .description(DSV_ALLOC_DESC)
                .category(DSV_CATEGORY)
                .build();
        TestResults expectedResults =
            TestResults.builder()
                .name(DSV_ALLOC_NAME)
                .description(DSV_ALLOC_DESC)
                .category(DSV_CATEGORY)
                .status(GCCSConstants.FAIL)
                .message("C: drive doesn't exist. Q: drive doesn't exist. ")
                .build();
        driveSizeValidator = new DriveSizeValidator(osCommandService, USER_INPUT_FIELDS_DSV,
                APP_SERVER_DRIVE_ALLOCATIONS, COMMAND_TEMPLATE_DRIVE_ALLOC, DIR_DRIVE_DSV,
                baseResults);
        when(osCommandService.runCommandToStdOut(any(), any()))
            .thenReturn("")   //fail - return would be empty if the drive doesnt exist
            .thenReturn("E:         21474836480")
            .thenReturn("F:         42949672960")
            .thenReturn("G:        214748364800")
            .thenReturn("             ")
            .thenReturn("T:          5368709120")
            .thenReturn("X:         53687091200");

        baseResults = driveSizeValidator.executeTest();

        assertEquals(baseResults, expectedResults);
    }

    @Test
    public void calcFreeSpaceShouldPass() throws Exception{
        TestResults baseResults =
                TestResults.builder()
                        .name(DSV_FREE_NAME)
                        .description(DSV_FREE_DESC)
                        .category(DSV_CATEGORY)
                        .build();
        TestResults expectedResults =
                TestResults.builder()
                        .name(DSV_FREE_NAME)
                        .description(DSV_FREE_DESC)
                        .category(DSV_CATEGORY)
                        .status(GCCSConstants.PASS)
                        .message("X: drive has 50 of free space left. G: drive has 143 of free space left. " +
                                "F: drive has 22 of free space left. E: drive has 68 of free space left. " +
                                "T: drive has 3 of free space left. C: drive has 50 of free space left. " +
                                "Q: drive has 40 of free space left. ")
                        .build();
        driveSizeValidator = new DriveSizeValidator(osCommandService, USER_INPUT_FIELDS_DSV,
                APP_SERVER_DRIVE_ALLOCATIONS, COMMAND_TEMPLATE_DRIVE_FREE, DIR_DRIVE_DSV,
                baseResults);
        when(osCommandService.runCommandToStdOut(any(), any()))
                .thenReturn("Total # of free bytes:          53687091200")
                .thenReturn("Total # of free bytes:          73687091200")
                .thenReturn("Total # of free bytes:          23687091200")
                .thenReturn("Total # of free bytes:          153687091200")
                .thenReturn("Total # of free bytes:          43687091200")
                .thenReturn("Total # of free bytes:          3687091200")
                .thenReturn("Total # of free bytes:          53687091200");

        baseResults = driveSizeValidator.executeTest();

        assertEquals(baseResults, expectedResults);

    }
    @Test
    public void calcFreeSpaceShouldFailonC() throws Exception{
        TestResults baseResults =
                TestResults.builder()
                        .name(DSV_FREE_NAME)
                        .description(DSV_FREE_DESC)
                        .category(DSV_CATEGORY)
                        .build();
        TestResults expectedResults =
                TestResults.builder()
                        .name(DSV_FREE_NAME)
                        .description(DSV_FREE_DESC)
                        .category(DSV_CATEGORY)
                        .status(GCCSConstants.FAIL)
                        .message("X: drive has 50 of free space left. G: drive has 143 of free space left. " +
                                "F: drive has 22 of free space left. E: drive has 68 of free space left. " +
                                "T: drive has 3 of free space left. C: drive doesn't exist. " +
                                "Q: drive has 40 of free space left. ")
                        .build();
        driveSizeValidator = new DriveSizeValidator(osCommandService, USER_INPUT_FIELDS_DSV,
                APP_SERVER_DRIVE_ALLOCATIONS, COMMAND_TEMPLATE_DRIVE_FREE, DIR_DRIVE_DSV,
                baseResults);
        when(osCommandService.runCommandToStdOut(any(), any()))
                .thenReturn("     ")    //this is for C Drive
                .thenReturn("Total # of free bytes:          73687091200")
                .thenReturn("Total # of free bytes:          23687091200")
                .thenReturn("Total # of free bytes:          153687091200")
                .thenReturn("Total # of free bytes:          43687091200")
                .thenReturn("Total # of free bytes:          3687091200")
                .thenReturn("Total # of free bytes:          53687091200");

        baseResults = driveSizeValidator.executeTest();

        assertEquals(baseResults, expectedResults);

    }

}
