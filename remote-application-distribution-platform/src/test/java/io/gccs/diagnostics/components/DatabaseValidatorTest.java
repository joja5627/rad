package io.gccs.diagnostics.components;

import io.gccs.diagnostics.constants.GCCSConstants;
import io.gccs.diagnostics.constants.PostgresConstants;
import io.gccs.diagnostics.domain.TestResults;
import io.gccs.diagnostics.services.FilePropertyService;
import org.assertj.core.error.ShouldNotContainOnlyWhitespaces;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.HashMap;

import static io.gccs.diagnostics.constants.PostgresConstants.*;
import static io.gccs.diagnostics.constants.WindowsConstants.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("integration-test")
public class DatabaseValidatorTest {

    @Test
    public void CanConnectShouldPass() throws Exception {
        TestResults baseResults =
                TestResults.builder()
                        .name("DatabaseExists")
                        .description("Check if the specified database exists")
                        .category(CATEGORY_POSTGRES)
                        .build();
        TestResults expectedResults =
                TestResults.builder()
                        .name("DatabaseExists")
                        .description("Check if the specified database exists")
                        .category(CATEGORY_POSTGRES)
                        .status(GCCSConstants.PASS)
                        .message("")
                        .build();
        DatabaseValidator validator = new DatabaseValidator("localhost", "postgres", "postgres", "pass", "select 1", PostgresConstants.USER_INPUT_FIELDS_POSTGRES, baseResults);
        baseResults = validator.executeTest();

        assertEquals(baseResults, expectedResults);
    }
}
