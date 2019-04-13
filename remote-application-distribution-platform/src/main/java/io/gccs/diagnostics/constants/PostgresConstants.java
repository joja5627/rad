package io.gccs.diagnostics.constants;

import io.gccs.diagnostics.domain.UserInputField;

import java.util.List;

import static io.gccs.diagnostics.constants.GCCSConstants.*;
import static io.gccs.diagnostics.constants.WindowsConstants.*;

public class PostgresConstants {
    public static final String POSTGRES_TEST_NAME_TEMPLATE = "Check if %s exists" ;
    public static final String POSTGRES_TEST_DESC_TEMPLATE = "Verify that %s exists or doesn't exist as expected." ;
    public static final List<UserInputField> USER_INPUT_FIELDS_POSTGRES = DEFAULT_USER_INPUT;
    public static final String CATEGORY_POSTGRES = "Postgres";

    public static final String POSTGRES_DIR = "PostgresPlus\\";
    public static final String _94 = "9.4AS\\";
    public static final String _96 = "9.6AS\\";
    public static final String C_DRIVE_POSTGRES_DIR = C_DRIVE_PROGRAMS + POSTGRES_DIR;
    public static final String F_DRIVE_POSTGRES_DIR = F_DRIVE_PROGRAMS + POSTGRES_DIR;
    public static final String P_DRIVE_POSTGRES_DIR = P_DRIVE_PROGRAMS + POSTGRES_DIR;
    public static final String POSTGRES_96_DIR = P_DRIVE_POSTGRES_DIR + _96;
    public static final String POSTGRES_94_DIR = P_DRIVE_POSTGRES_DIR + _94;
    public static final String C_POSTGRES_94_DIR = C_DRIVE_POSTGRES_DIR + _94;
    public static final String F_POSTGRES_94_DIR = F_DRIVE_POSTGRES_DIR + _94;
    public static final String EXTENSION_DIR = "PostgreSQL\\9.6\\share\\extension\\";
    public static final String C_EXTENSION_DIR = C_DRIVE_PROGRAM_FILES + EXTENSION_DIR;
    public static final String F_EXTENSION_DIR = F_DRIVE_PROGRAM_FILES + EXTENSION_DIR;


    public static final String PG_HBA = "pg_hba.conf";
    public static final String ROOT = "root.crt";
    public static final String SERVER_CRT = "server.crt";
    public static final String SERVER_KEY = "server.key";
    public static final String POSTGRESQL = "postgresql.conf";
    public static final String PG_IDENT = "pg_ident.conf";
    public static final String ROOTCERTS_FOLDER = "RootCerts\\";
    public static final String POSTGIS_CONTROL = "postgis.control";
    public static final String POSTGRES_96_INSTALL = "PostgreSQL 9.6\\";

    public static final String PG_HBA_FULL = POSTGRES_96_DIR + PG_HBA;
    public static final String ROOT_FULL = POSTGRES_96_DIR + ROOT;
    public static final String SERVER_CRT_FULL = POSTGRES_96_DIR + SERVER_CRT;
    public static final String SERVER_KEY_FULL = POSTGRES_96_DIR + SERVER_KEY;
    public static final String POSTGRESQL_FULL = POSTGRES_96_DIR + POSTGRESQL;
    public static final String PG_IDENT_FULL = POSTGRES_96_DIR + PG_IDENT;
    public static final String ROOTCERTS_FOLDER_FULL = POSTGRES_96_DIR + ROOTCERTS_FOLDER;
    public static final String C_POSTGIS_CONTROL_FULL = C_EXTENSION_DIR + POSTGIS_CONTROL;
    public static final String F_POSTGIS_CONTROL_FULL = F_EXTENSION_DIR + POSTGIS_CONTROL;

    public static final String _94_NAME = String.format(POSTGRES_TEST_NAME_TEMPLATE, _94);
    public static final String PG_HBA_NAME = String.format(POSTGRES_TEST_NAME_TEMPLATE, PG_HBA);
    public static final String ROOT_NAME = String.format(POSTGRES_TEST_NAME_TEMPLATE, ROOT);
    public static final String SERVER_CRT_NAME = String.format(POSTGRES_TEST_NAME_TEMPLATE, SERVER_CRT);
    public static final String SERVER_KEY_NAME = String.format(POSTGRES_TEST_NAME_TEMPLATE, SERVER_KEY);
    public static final String POSTGRESQL_NAME = String.format(POSTGRES_TEST_NAME_TEMPLATE, POSTGRESQL);
    public static final String PG_IDENT_NAME = String.format(POSTGRES_TEST_NAME_TEMPLATE, PG_IDENT);
    public static final String ROOTCERTS_FOLDER_NAME = String.format(POSTGRES_TEST_NAME_TEMPLATE, ROOTCERTS_FOLDER);
    public static final String POSTGIS_CONTROL_NAME = String.format(POSTGRES_TEST_NAME_TEMPLATE, ROOTCERTS_FOLDER);

    public static final String _94_DESC = String.format(POSTGRES_TEST_DESC_TEMPLATE, _94);
    public static final String PG_HBA_DESC = String.format(POSTGRES_TEST_DESC_TEMPLATE, PG_HBA);
    public static final String ROOT_DESC = String.format(POSTGRES_TEST_DESC_TEMPLATE, ROOT);
    public static final String SERVER_CRT_DESC = String.format(POSTGRES_TEST_DESC_TEMPLATE, SERVER_CRT);
    public static final String SERVER_KEY_DESC = String.format(POSTGRES_TEST_DESC_TEMPLATE, SERVER_KEY);
    public static final String POSTGRESQL_DESC = String.format(POSTGRES_TEST_DESC_TEMPLATE, POSTGRESQL);
    public static final String PG_IDENT_DESC = String.format(POSTGRES_TEST_DESC_TEMPLATE, PG_IDENT);
    public static final String ROOTCERTS_FOLDER_DESC = String.format(POSTGRES_TEST_DESC_TEMPLATE, ROOTCERTS_FOLDER);
    public static final String POSTGIS_CONTROL_DESC = String.format(POSTGRES_TEST_DESC_TEMPLATE, ROOTCERTS_FOLDER);
}
