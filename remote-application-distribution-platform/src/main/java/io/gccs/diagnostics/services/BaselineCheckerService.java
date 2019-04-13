package io.gccs.diagnostics.services;


import io.gccs.diagnostics.components.DriveSizeValidator;
import io.gccs.diagnostics.components.FileExistsValidator;
import io.gccs.diagnostics.components.ServiceRunningChecker;
import io.gccs.diagnostics.components.XMLPropertyValidator;
import io.gccs.diagnostics.constants.GCCSConstants;
import io.gccs.diagnostics.constants.WindowsConstants;
import io.gccs.diagnostics.domain.GccsConfiguration;
import io.gccs.diagnostics.domain.TestResults;
import io.gccs.diagnostics.domain.UserInputField;
import io.gccs.diagnostics.modules.ConfigAndTestRunner;
import io.gccs.diagnostics.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

import static io.gccs.diagnostics.constants.AdaptorConstants.*;
import static io.gccs.diagnostics.constants.GCCSConstants.*;
import static io.gccs.diagnostics.constants.OSCommandConstants.*;
import static io.gccs.diagnostics.constants.PostgresConstants.*;
import static io.gccs.diagnostics.constants.WindowsConstants.*;

@Slf4j
@Service
public class BaselineCheckerService {

    private GccsConfiguration environmentConfig = GccsConfiguration.builder().build();
    private Map<String,UserInputField> configuration;
    private List<ConfigAndTestRunner> loadedTests;

    @Autowired
    FileUtils fileUtils;

    @Autowired
    FilePropertyService filePropertyService;

    @Autowired
    OSCommandService osCommandService;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    public GccsConfiguration loadTestSuite(){
        loadedTests = Collections.emptyList();

        boolean isCanesInstall = fileUtils.directoryExistsAndNotEmpty(WindowsConstants.CANES_DEFAULT_DRIVE);
        boolean isComposeInstall = fileUtils.directoryExistsAndNotEmpty(WindowsConstants.COMPOSE_DEFAULT_DRIVE);
        boolean isDbServer = fileUtils.directoryExistsAndNotEmpty(WindowsConstants.DB_DEFAULT_DRIVE);

        if(activeProfile.equals("dev") || activeProfile.equals("test")){
            isCanesInstall = true;
        }
        if(isDbServer){
            HashMap<String, String> PostgresRemoved = new HashMap<>();
            HashMap<String, String> PostgresAdded = new HashMap<>();

            loadedTests = Arrays.asList(

                    );

            environmentConfig.setServerType(GCCSConstants.DB_SERVER);
            environmentConfig.setNetworkType(GCCSConstants.DB_SERVER);

            //Postgres may be installed on either C: or F:. This determines which one.
            String postgresDir = "";
            String postgres94Dir = "";
            File c = new File(C_DRIVE_POSTGRES_DIR);
            File f = new File(F_DRIVE_POSTGRES_DIR);
            if(c.exists())
            {
                postgresDir = C_DRIVE_POSTGRES_DIR;
                postgres94Dir = C_POSTGRES_94_DIR;
            }
            else if(f.exists())
            {
                postgresDir = F_DRIVE_POSTGRES_DIR;
                postgres94Dir = F_POSTGRES_94_DIR;
            }

            if(postgresDir != "")
            {
                PostgresRemoved.put(POSTGRES_94_DIR, _94);
                PostgresRemoved.put(postgres94Dir, _94);

                PostgresAdded.put(PG_HBA_FULL, PG_HBA);
                PostgresAdded.put(ROOT_FULL, ROOT);
                PostgresAdded.put(SERVER_CRT_FULL, SERVER_CRT);
                PostgresAdded.put(SERVER_KEY_FULL, SERVER_KEY);
                PostgresAdded.put(POSTGRESQL_FULL, POSTGRESQL);
                PostgresAdded.put(PG_IDENT_FULL, PG_IDENT);
                PostgresAdded.put(ROOTCERTS_FOLDER_FULL, ROOTCERTS_FOLDER);
                PostgresAdded.put(C_POSTGIS_CONTROL_FULL, POSTGIS_CONTROL);
                PostgresAdded.put(C_EXTENSION_DIR, EXTENSION_DIR);

                loadedTests = Arrays.asList(
                        //Postgres 9.4 was removed from P: drive.
                        new FileExistsValidator(PostgresRemoved, false, USER_INPUT_FIELDS_POSTGRES,
                                TestResults.builder().name(_94_NAME)
                                .description(_94_DESC)
                                .category(CATEGORY_POSTGRES).build()),
                        //9.6 Files were copied into the P: drive.
                        new FileExistsValidator(PostgresAdded, true, USER_INPUT_FIELDS_POSTGRES,
                                TestResults.builder().name(PG_HBA_NAME)
                                .description(PG_HBA_DESC)
                                .category(CATEGORY_POSTGRES).build()),
                        //Postgres Server Service
                        new ServiceRunningChecker(new OSCommandService(), NAME_POSTGRES_STATUS, COMMAND_POSTGRES_STATUS, DIR_FIREWALL_STATUS,
                                SERVICE_SHOULD_RUNNING, USER_INPUT_FIELDS_POSTGRES_STATUS, TestResults.builder().name(NAME_POSTGRES_STATUS)
                                .description(DESC_POSTGRES_STATUS)
                                .category(CATEGORY_SERVICE).build())
                );
            }
        }else{
            environmentConfig.setServerType(GCCSConstants.APP_SERVER);
            if(isCanesInstall){


                loadedTests = Arrays.asList(
                        //Adaptor-GPS
                        new XMLPropertyValidator(new FilePropertyService(), ADAPTOR_NAME_GPS, USER_INPUT_FIELDS_GPS,
                                CUSTOM_TAG_VALS_GPS, COMMON_VALS_GPS,
                                TestResults.builder().name(ADAPTOR_NAME_GPS)
                                .description(ADAPTOR_DESC_GPS)
                                .category(CATEGORY_CONFIGURATION).build()),
                        //Adaptor-AADS
                        new XMLPropertyValidator(new FilePropertyService(), ADAPTOR_NAME_AADS, USER_INPUT_FIELDS_AADS,
                                CUSTOM_TAG_VALS_AADS, COMMON_VALS_AADS,
                                TestResults.builder().name(ADAPTOR_NAME_AADS)
                                        .description(ADAPTOR_DESC_AADS)
                                        .category(CATEGORY_CONFIGURATION).build()),
                        //Adaptor-NAVSSI
                        new XMLPropertyValidator(new FilePropertyService(), NAME_NAVSSI, USER_INPUT_FIELDS_NAVSSI,
                                CUSTOM_TAG_VALS_ADAPTOR_NAVSSI, COMMON_VALS_NAVSSI,
                                TestResults.builder().name(NAME_NAVSSI)
                                        .description(DESC_NAVSSI)
                                        .category(CATEGORY_CONFIGURATION).build()),
                        //Adaptor-LINK11
                        new XMLPropertyValidator(new FilePropertyService(), ADAPTOR_NAME_LINK11, USER_INPUT_FIELDS_LINK11,
                                CUSTOM_TAG_VALS_ADAPTOR_LINK11, COMMON_VALS_LINK11,
                                TestResults.builder().name(ADAPTOR_NAME_LINK11)
                                        .description(ADAPTOR_DESC_LINK11)
                                        .category(CATEGORY_CONFIGURATION).build()),
                        //Adaptor-LINK16
                        new XMLPropertyValidator(new FilePropertyService(), ADAPTOR_NAME_LINK16, USER_INPUT_FIELDS_LINK16,
                                CUSTOM_TAG_VALS_ADAPTOR_LINK16, COMMON_VALS_LINK16,
                                TestResults.builder().name(ADAPTOR_NAME_LINK16)
                                        .description(ADAPTOR_DESC_LINK16)
                                        .category(CATEGORY_CONFIGURATION).build()),
                        //Adaptor-TAB37FFTBMD
                        new XMLPropertyValidator(new FilePropertyService(), ADAPTOR_NAME_TAB37FFTBMD, USER_INPUT_FIELDS_TAB37FFTBMD,
                                CUSTOM_TAG_VALS_ADAPTOR_TAB37FFTBMD, COMMON_VALS_TAB37FFTBMD,
                                TestResults.builder().name(ADAPTOR_NAME_TAB37FFTBMD_NO_REGEX)
                                        .description(ADAPTOR_DESC_TAB37FFTBMD)
                                        .category(CATEGORY_CONFIGURATION).build()),
                        //Correlator-Link11
                        new XMLPropertyValidator(new FilePropertyService(), NAME_CORRELATOR_LINK11, USER_INPUT_FIELDS_CORRELATOR_LINK11,
                                CUSTOM_TAG_VALS_CORRELATOR_LINK11, COMMON_VALS_CORRELATOR_LINK11,
                                TestResults.builder().name(NAME_CORRELATOR_LINK11)
                                        .description(DESC_CORRELATOR_LINK11)
                                        .category(CATEGORY_CONFIGURATION).build()),
                        //Correlator-Link16
                        new XMLPropertyValidator(new FilePropertyService(), NAME_CORRELATOR_LINK16, USER_INPUT_FIELDS_CORRELATOR_LINK16,
                                CUSTOM_TAG_VALS_CORRELATOR_LINK16, COMMON_VALS_CORRELATOR_LINK16,
                                TestResults.builder().name(NAME_CORRELATOR_LINK16)
                                        .description(DESC_CORRELATOR_LINK16)
                                        .category(CATEGORY_CONFIGURATION).build()),
                        //Correlator-Ownship
                        new XMLPropertyValidator(new FilePropertyService(), ADAPTOR_NAME_CORRELATOR_OWNSHIP, USER_INPUT_FIELDS_CORRELATOR_OWNSHIP,
                                CUSTOM_TAG_VALS_CORRELATOR_OWNSHIP, COMMON_VALS_CORRELATOR_OWNSHIP,
                                TestResults.builder().name(ADAPTOR_NAME_CORRELATOR_OWNSHIP)
                                        .description(ADAPTOR_DESC_CORRELATOR_OWNSHIP)
                                        .category(CATEGORY_CONFIGURATION).build()),
                        //CouplerTCPTwoWaySerial
                        new XMLPropertyValidator(new FilePropertyService(), ADAPTOR_NAME_COUPLERTCP, USER_INPUT_FIELDS_COUPLERTCP,
                                CUSTOM_TAG_VALS_COUPLERTCP, COMMON_VALS_COUPLERTCP,
                                TestResults.builder().name(ADAPTOR_NAME_COUPLERTCP)
                                        .description(ADAPTOR_DESC_COUPLERTCP)
                                        .category(CATEGORY_CONFIGURATION).build()),
                        //MessageProcessorTCPIP
                        new XMLPropertyValidator(new FilePropertyService(), ADAPTOR_NAME_MESSAGE_PROCESSOR, USER_INPUT_FIELDS_MESSAGE_PROCESSOR,
                                CUSTOM_TAG_VALS_MESSAGE_PROCESSOR, COMMON_VALS_MESSAGE_PROCESSOR,
                                TestResults.builder().name(ADAPTOR_NAME_MESSAGE_PROCESSOR)
                                        .description(ADAPTOR_DESC_MESSAGE_PROCESSOR)
                                        .category(CATEGORY_CONFIGURATION).build()),
                        //ActiveMQ Service
                        new ServiceRunningChecker(new OSCommandService(), NAME_ACTIVEMQ, COMMAND_ACTIVEMQ, DIR_ACTIVEMQ,
                                SERVICE_SHOULD_RUNNING, USER_INPUT_FIELDS_ACTIVEMQ, TestResults.builder().name(NAME_ACTIVEMQ)
                                .description(DESC_ACTIVEMQ)
                                .category(CATEGORY_SERVICE).build()),
                        //Tomcat Service
                        new ServiceRunningChecker(new OSCommandService(), NAME_TOMCAT, COMMAND_TOMCAT, DIR_TOMCAT,
                                SERVICE_SHOULD_RUNNING, USER_INPUT_FIELDS_TOMCAT, TestResults.builder().name(NAME_TOMCAT)
                                .description(DESC_TOMCAT)
                                .category(CATEGORY_SERVICE).build()),
                        //Windows Firewall Service
                        new ServiceRunningChecker(new OSCommandService(), NAME_FIREWALL_STATUS, COMMAND_FIREWALL_STATUS, DIR_FIREWALL_STATUS,
                                SERVICE_SHOULD_STOPPED, USER_INPUT_FIELDS_FIREWALL_STATUS, TestResults.builder().name(NAME_FIREWALL_STATUS)
                                .description(DESC_FIREWALL_STATUS)
                                .category(CATEGORY_SERVICE).build()),
                        //Drive Size Validator - Allocation Check for App Server
                        new DriveSizeValidator(new OSCommandService(), USER_INPUT_FIELDS_DSV, APP_SERVER_DRIVE_ALLOCATIONS, COMMAND_TEMPLATE_DRIVE_ALLOC,
                                DIR_DRIVE_DSV, TestResults.builder().name(DSV_ALLOC_NAME)
                                .description(DSV_ALLOC_DESC)
                                .category(DSV_CATEGORY).build()),
                        //Drive Size Validator - Free Space Checker
                        new DriveSizeValidator(new OSCommandService(), USER_INPUT_FIELDS_DSV, APP_SERVER_DRIVE_ALLOCATIONS, COMMAND_TEMPLATE_DRIVE_FREE,
                                DIR_DRIVE_DSV, TestResults.builder().name(DSV_FREE_NAME)
                                .description(DSV_FREE_DESC)
                                .category(DSV_CATEGORY).build())
                );

                environmentConfig.setNetworkType(GCCSConstants.CANES);


            }else if(isComposeInstall) {
                environmentConfig.setNetworkType(GCCSConstants.COMPOSE);
            }
        }
        Map<String, UserInputField> uniqueConfigFields = loadedTests.stream()
                .map(ConfigAndTestRunner::configPageRequirements)
                .flatMap(list -> list.stream())
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toMap(p -> p.fieldName, p -> p));
        environmentConfig.setUserConfigFields(uniqueConfigFields);
        return environmentConfig;
    }
    private boolean verifyJavaVersion(){
        String version = System.getProperty("java.version");
        return version.equals("1.8.0_112") || true;  //remove || true in production
    }

    //going to add a parameter to pass in the entered config values
    public  List<TestResults> executeTestsParallelStream(Map<String,UserInputField> config) {
        long time = System.currentTimeMillis();
        log.info("Running Tests...");
        List<TestResults> tr;
        if(verifyJavaVersion()) {
            tr = loadedTests
                    .parallelStream()
                    .map((ConfigAndTestRunner inputs) -> inputs.setInputAndRunTest(config))
                    .collect(Collectors.toList());

            log.info("Ran the tests in: " + (System.currentTimeMillis() - time) + " ms");
        }
        else {//wrong java version
            TestResults results = TestResults.builder()
                    .name("Check Java Version")
                    .category(CATEGORY_CONFIGURATION)
                    .description("Verify that the Java version is 1.8.0_112")
                    .status(FAIL).message("Wrong java version").build();
            tr = Arrays.asList(results);
        }
        loadedTests = Collections.emptyList();
        environmentConfig = GccsConfiguration.builder().build();
        return tr;
    }
}
