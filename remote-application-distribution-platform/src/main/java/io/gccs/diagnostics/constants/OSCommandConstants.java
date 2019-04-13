package io.gccs.diagnostics.constants;

import io.gccs.diagnostics.domain.UserInputField;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import static io.gccs.diagnostics.constants.GCCSConstants.CATEGORY_CONFIGURATION;
import static io.gccs.diagnostics.constants.GCCSConstants.DEFAULT_USER_INPUT;

public class OSCommandConstants {


    private static final String TEST_NAME_OSC_TEMPLATE = "Check %s Service Status";
    //General Constants for OCS
    public static final String OCS_EXECUTE_PASS = "Service %s is running";
    public static final String OCS_EXECUTE_FAIL_STOPPED = "Service %s is stopped";
    public static final String OCS_EXECUTE_FAIL_CANNOT_DETERMINE = "Cannot determine %s service status";
    public static final String SERVICE_SHOULD_RUNNING = "RUN";
    public static final String SERVICE_SHOULD_STOPPED = "STOP";

    //Service Running ActiveMQ
    public static final String COMMAND_ACTIVEMQ = "cmd /c sc query ActiveMQ";
    public static final String DIR_ACTIVEMQ = ".";
    public static final String NAME_ACTIVEMQ = "ActiveMQ";
    public static final String DESC_ACTIVEMQ = "Verify the ActiveMQ Service is Running";
    public static final String TEST_NAME_ACTIVEMQ = String.format(TEST_NAME_OSC_TEMPLATE, NAME_ACTIVEMQ);
    public static final List<UserInputField> USER_INPUT_FIELDS_ACTIVEMQ = DEFAULT_USER_INPUT;

    //Service Running Apache Tomcat
    public static final String COMMAND_TOMCAT = "cmd /c sc query Tomcat8";
    public static final String DIR_TOMCAT = ".";
    public static final String NAME_TOMCAT = "Apache Tomcat";
    public static final String DESC_TOMCAT = "Verify the Apache Tomcat Service is Running";
    public static final String TEST_NAME_TOMCAT = String.format(TEST_NAME_OSC_TEMPLATE, NAME_TOMCAT);
    public static final List<UserInputField> USER_INPUT_FIELDS_TOMCAT = DEFAULT_USER_INPUT;

    //Service Stopped Windows Firewall
    public static final String COMMAND_FIREWALL_STATUS = "cmd /c sc query mpssvc";
    public static final String DIR_FIREWALL_STATUS = ".";
    public static final String NAME_FIREWALL_STATUS = "Windows Firewall";
    public static final String DESC_FIREWALL_STATUS = "Verify that the Windows Firewall is turned off";
    public static final List<UserInputField> USER_INPUT_FIELDS_FIREWALL_STATUS = DEFAULT_USER_INPUT;

    //Service Running Postgres
    public static final String COMMAND_POSTGRES_STATUS = "cmd /c sc query GCCS-PostgreSQL-Server";
    public static final String DIR_POSTGRES_STATUS = "src/main";
    public static final String NAME_POSTGRES_STATUS = "Postgres Server";
    public static final String DESC_POSTGRES_STATUS = "Verify that the Postgres Server is Running";
    public static final List<UserInputField> USER_INPUT_FIELDS_POSTGRES_STATUS = DEFAULT_USER_INPUT;

    //Drive Size Validator
    public static final String COMMAND_TEMPLATE_DRIVE_ALLOC = "cmd /c wmic logicaldisk get size,caption | find \"%s\"";
    public static final String COMMAND_TEMPLATE_DRIVE_FREE = "cmd /c fsutil volume diskfree %s | find \"of free bytes\"";
    public static final String DIR_DRIVE_DSV = ".";
    public static final String DSV_ALLOC_NAME = "Check the partition allocation size for each drive";
    public static final String DSV_ALLOC_DESC = "Verify that each of the Disk Partition Allocations are the right size";
    public static final String DSV_CATEGORY = CATEGORY_CONFIGURATION;
    public static final String DSV_ALLOC_SUCCESS = "All the drive partitions are allocated correctly.";
    public static final String DSV_FREE_NAME = "Calculate free space in each partition";
    public static final String DSV_FREE_DESC = "Check and Print the amount of free space in each Drive Partition";

    public static final BigInteger BYTES_TO_GB = new BigInteger("1073741824");
    public static final int ALLOCATION_VARIANCE_SMALL = 2;
    public static final int ALLOCATION_VARIANCE_MED = 5;
    public static final int ALLOCATION_VARIANCE_LARGE = 10;
    public static final List<UserInputField> USER_INPUT_FIELDS_DSV = Collections.emptyList();
    public static final int DSV_NO_DRIVE_EXISTS = 0;
    public static final int DSV_INCORRECT_ALLOCATION = 1;


}
