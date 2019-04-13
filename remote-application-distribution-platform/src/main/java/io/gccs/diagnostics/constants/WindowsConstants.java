package io.gccs.diagnostics.constants;

import io.gccs.diagnostics.domain.UserInputField;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WindowsConstants {

    public static final String C_DRIVE = "C:\\";
    public static final String X_DRIVE = "X:\\";
    public static final String J_DRIVE = "J:\\";
    public static final String E_DRIVE = "E:\\";
    public static final String F_DRIVE = "F:\\";
    public static final String D_DRIVE = "D:\\";
    public static final String P_DRIVE = "P:\\";

    public static final  String PROGRAMS = "Programs";
    public static final  String PROGRAM_FILES = "Program Files\\";
    public static final  String PROGRAM_X86_FILES = "Program Files (x86)\\";
    public static final  String MOZILLA_DIR = "Mozilla Firefox\\";
    public static final  String CHROM_DIR = "Google\\Chrome\\Application\\";
    public static final  String MOZILLA_EXE = "firefox.exe";
    public static final  String CHROME_EXE = "chrome.exe";
    public static final  String WINDOWS_DEFAULT_EXE = "rundll32 url.dll,FileProtocolHandler";
    public static final  String LOCAL_HOST = "http://localhost:";

    public static final String C_DRIVE_PROGRAM_FILES = C_DRIVE + PROGRAM_FILES;
    public static final String F_DRIVE_PROGRAM_FILES = F_DRIVE + PROGRAM_FILES;
    public static final String C_DRIVE_PROGRAMS = C_DRIVE + PROGRAMS;
    public static final String F_DRIVE_PROGRAMS = F_DRIVE + PROGRAMS;
    public static final String P_DRIVE_PROGRAMS = P_DRIVE + PROGRAMS;
    public static final String C_DRIVE_PROGRAM_X86_FILES = C_DRIVE + PROGRAM_X86_FILES;
    public static final String X_DRIVE_PROGRAM_FILES = X_DRIVE + PROGRAM_FILES;
    public static final String X_DRIVE_PROGRAMS = X_DRIVE + PROGRAMS;

    public static final String CANES_DEFAULT_DRIVE = F_DRIVE;
    public static final String COMPOSE_DEFAULT_DRIVE = E_DRIVE;
    public static final String DB_DEFAULT_DRIVE = J_DRIVE;

    public static final String INPUT_FIELD_TYPE_CLASSIFICATION = "classification";
    public static final String INPUT_FIELD_TYPE_IP = "ip";
    public static final String INPUT_FIELD_TYPE_PORT = "port";
    public static final String INPUT_FIELD_TYPE_BOOLEAN = "boolean";
    public static final String INPUT_FIELD_TYPE_NUMBER = "number";
    public static final String INPUT_FIELD_TYPE_DEFAULT = "default";

    public static final String INPUT_FIELD_PROP_TYPE_PROP = "Property";

    public static final UserInputField USER_CONFIG_CLASSIFICATION = new UserInputField("Classification", "The classification level of your system",INPUT_FIELD_TYPE_CLASSIFICATION, INPUT_FIELD_PROP_TYPE_PROP, "channelClass","");
    public static final UserInputField USER_CONFIG_APP_SERVER_IP = new UserInputField("AppServerIP", "The host address of the app server in your system",INPUT_FIELD_TYPE_IP, INPUT_FIELD_PROP_TYPE_PROP, "tcpHost", "");
    public static final UserInputField USER_CONFIG_UDP_PORT = new UserInputField("UDPPort", "The UDP Port",INPUT_FIELD_TYPE_PORT, INPUT_FIELD_PROP_TYPE_PROP, "udpPort", "");
    public static final UserInputField USER_CONFIG_JREAP_HOST_IP = new UserInputField("JREAPHostIP", "The host address of the JREAP host",INPUT_FIELD_TYPE_DEFAULT, INPUT_FIELD_PROP_TYPE_PROP, "tcpHost", ""); //TODO FIX NOTREAL
    public static final UserInputField USER_CONFIG_SSL_ENABLED = new UserInputField("SSLEnabled", "Are you using SSL encryption?",INPUT_FIELD_TYPE_BOOLEAN, INPUT_FIELD_PROP_TYPE_PROP, "useSSL", "");
    public static final UserInputField USER_CONFIG_OWN_UNIT_JTN = new UserInputField("OwnUnitJTN", "JTN Number of Own Unit",INPUT_FIELD_TYPE_DEFAULT, INPUT_FIELD_PROP_TYPE_PROP, "ownJTN", "");     //TODO FIX propname, noclue
    public static final UserInputField USER_CONFIG_TRACK_UPDATE_INTERVAL = new UserInputField("TrackUpdateInterval", "The number of seconds between each request is made to update tracks",INPUT_FIELD_TYPE_NUMBER, INPUT_FIELD_PROP_TYPE_PROP, "navUpdateRate", "");

    public static final UserInputField USER_CONFIG_NAVSSI_PORT = new UserInputField("NAVSSIcommPort","The Comm port used by NAVSSI", INPUT_FIELD_TYPE_DEFAULT, INPUT_FIELD_PROP_TYPE_PROP,"commPort","");
    public static final UserInputField USER_CONFIG_GPS_PORT = new UserInputField("GPSCommPort", "The Comm port used by GPS", INPUT_FIELD_TYPE_DEFAULT, INPUT_FIELD_PROP_TYPE_PROP, "commPort", "");
    public static final UserInputField USER_CONFIG_TAB37_PORT = new UserInputField("TAB37CommPort", "The Comm port used by TAB37-FFT-BMD", INPUT_FIELD_TYPE_DEFAULT, INPUT_FIELD_PROP_TYPE_PROP, "commPort", "");
    public static final UserInputField USER_CONFIG_COUPLERTCP_PORT = new UserInputField("CouplerTCPCommPort", "The Comm port used by Coupler-TCP", INPUT_FIELD_TYPE_DEFAULT, INPUT_FIELD_PROP_TYPE_PROP, "commPort", "");

    public static final HashMap<String, Integer> DB_SERVER_DRIVE_ALLOCATONS = new HashMap<String, Integer>() {{
        //Drive Name and Allocation Size (in GB)
        put("C:",50);
        put("E:",20);
        put("F:",40);
        put("G:",200);  //Backup
        put("J:",100);  //PostGreSQL Logs
        put("P:",150);  //PostGreSQL Data Files
        put("X:",15);   //GCCS-M GL Client
    }};
    //app server allocation hashmap
    public static final HashMap<String, Integer> APP_SERVER_DRIVE_ALLOCATIONS = new HashMap<String, Integer>() {{
        put("C:",50);
        put("E:",20);
        put("F:",40);
        put("G:",200);  //backup
        put("Q:",2);    //activeMQ
        put("T:",5);    //Tomcat
        put("X:",50);   //GCCS-M GL Server
    }};







}
