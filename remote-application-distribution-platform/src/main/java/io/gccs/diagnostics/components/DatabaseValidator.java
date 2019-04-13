package io.gccs.diagnostics.components;

import io.gccs.diagnostics.constants.GCCSConstants;
import io.gccs.diagnostics.domain.TestResults;
import io.gccs.diagnostics.domain.UserInputField;
import io.gccs.diagnostics.modules.ConfigAndTestRunner;
import io.gccs.diagnostics.services.FilePropertyService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.xml.sax.SAXException;
import java.io.*;

import java.io.IOException;
import java.util.*;
import java.sql.*;
//import io.lib.*;

@Builder
@AllArgsConstructor
@Slf4j
public class DatabaseValidator implements ConfigAndTestRunner {
    private String ServerName;
    private String DatabaseName;
    private String UserName;
    private String Password;
    private String Query;
    private final List<UserInputField> UserInputField;
    private final TestResults testResults;

    @Override
    public List<UserInputField> configPageRequirements() {
        return UserInputField;
    }

    @Override
    public TestResults setInputAndRunTest(Map<String, io.gccs.diagnostics.domain.UserInputField> inputs) {
        //does not need anything from user input at this time, so just get
        return executeTest();
    }

    public TestResults executeTest() {
        try
        {
            Class dbDriver = Class.forName("org.postgresql.Driver");
            String postgresURL = "jdbc:postgresql://" + ServerName + "/" + DatabaseName;
            Properties postgresProps = new Properties();
            postgresProps.setProperty("user", UserName);
            postgresProps.setProperty("password", Password);
            //postgresProps.setProperty("ssl", "false");
            Connection postgresConn = DriverManager.getConnection(postgresURL, postgresProps);
            Statement state = postgresConn.createStatement();
            ResultSet results = state.executeQuery(Query);
            if(results.next())
            {
                testResults.setStatus(GCCSConstants.PASS);
                testResults.setMessage("");
            }
            else
            {
                testResults.setStatus(GCCSConstants.FAIL);
                testResults.setMessage("Did not get any results from query:\n" + Query);
            }
        }
        catch (Exception e)
        {
            testResults.setStatus(GCCSConstants.FAIL);
            testResults.setMessage("Could not connect to the " + DatabaseName + " database.");
        }
        return testResults;
    }

}
