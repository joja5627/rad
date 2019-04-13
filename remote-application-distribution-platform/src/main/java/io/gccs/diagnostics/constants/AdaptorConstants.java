package io.gccs.diagnostics.constants;

import io.gccs.diagnostics.domain.UserInputField;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AdaptorConstants {

    private static final String TEST_NAME_TEMPLATE = "Check %s Configuration";
    private static final String TEST_DESC_TEMPLATE = "Verify the %s has the proper configuration";
    public static final HashMap<String, String> NO_CUSTOM_TAGS = null;

    //CHECK ADAPTER GPS

    public static final String ADAPTOR_NAME_GPS = "Adaptor-GPS";
    public static final String ADAPTOR_TEST_NAME_GPS = String.format(TEST_NAME_TEMPLATE, ADAPTOR_NAME_GPS);
    public static final String ADAPTOR_DESC_GPS = String.format(TEST_DESC_TEMPLATE, ADAPTOR_NAME_GPS);

    public static final HashMap<String, String> PROPERTY_VALS_GPS = new HashMap<String, String>() {{
        put("baudRate", "9600");
        put("parity", "NONE");
        put("flowControl", "NONE");
        put("dataBits", "8");
        put("stopBits", "1");
        put("logMessages", "false");
        put("useSystemTime", "true");
        put("tcpHost", "localhost");
    }};
    public static final HashMap<String, HashMap<String, String>> COMMON_VALS_GPS = new HashMap<String, HashMap<String, String>>() {{
        put("Property", PROPERTY_VALS_GPS);
    }};

    public static final HashMap<String, String> CUSTOM_TAG_VALS_GPS = new HashMap<String, String>() {{
        put("ProtocolIn", "Serial");
    }};

    public static final List<UserInputField> USER_INPUT_FIELDS_GPS
            = Arrays.asList(WindowsConstants.USER_CONFIG_CLASSIFICATION, WindowsConstants.USER_CONFIG_GPS_PORT);

    public static final String ADAPTOR_GPS_FILE_MISSING = "Could not locate the active Adaptor-GPS. It may not be running";
    public static final String ADAPTOR_GPS_SUCCESS = "The Adaptor-GPS is configured properly.";

    //CHECK ADAPTER AADS

    public static final String ADAPTOR_NAME_AADS = "Adaptor-AADS";
    public static final String ADAPTOR_TEST_NAME_AADS = "Adaptor-AADS";
    public static final String ADAPTOR_DESC_AADS = String.format(TEST_NAME_TEMPLATE, ADAPTOR_TEST_NAME_AADS);
    public static final String DESC_AADS = String.format(TEST_DESC_TEMPLATE, ADAPTOR_TEST_NAME_AADS);

    public static final HashMap<String, String> PROPERTY_VALS_AADS = new HashMap<String, String>() {{
        put("tcpPort", "2023");
        put("tcpHost", "localhost");
    }};
    public static final HashMap<String, HashMap<String, String>> COMMON_VALS_AADS = new HashMap<String, HashMap<String, String>>() {{
        put("Property", PROPERTY_VALS_AADS);
    }};
    public static final HashMap<String, String> CUSTOM_TAG_VALS_AADS = null;

    public static final List<UserInputField> USER_INPUT_FIELDS_AADS
            = Arrays.asList(WindowsConstants.USER_CONFIG_CLASSIFICATION);

    public static final String ADAPTOR_AADS_FILE_MISSING = "Could not locate the active Adaptor-AADS. It may not be running";
    public static final String ADAPTOR_AADS_SUCCESS = "The Adaptor-AADS is configured properly.";



    //CHECK ADAPTER LINK11

    public static final String ADAPTOR_NAME_LINK11 = "Adaptor-LINK11";
    public static final String ADAPTOR_TEST_NAME_LINK11 = String.format(TEST_NAME_TEMPLATE, ADAPTOR_NAME_LINK11);
    public static final String ADAPTOR_DESC_LINK11 = String.format(TEST_DESC_TEMPLATE, ADAPTOR_NAME_LINK11);

    public static final HashMap<String, String> PROPERTY_VALS_LINK11 = new HashMap<String, String>() {{
        put("protocol", "EDO/TDP");
        put("tcpPort", "4004");
        put("tcpHost", "localhost");
        put("logMessages", "false");
        put("linkName", "LINK-A");
        put("waitForDLRP", "false");
    }};
    public static final HashMap<String, HashMap<String, String>> COMMON_VALS_LINK11 = new HashMap<String, HashMap<String, String>>() {{
        put("Property", PROPERTY_VALS_LINK11);
    }};

    public static final HashMap<String, String> CUSTOM_TAG_VALS_ADAPTOR_LINK11 = new HashMap<String, String>() {{
        put("ProtocolIn", "TCP/Client");
    }};

    public static final List<UserInputField> USER_INPUT_FIELDS_LINK11
            = Collections.emptyList();

    public static final String ADAPTOR_LINK11_FILE_MISSING = "Could not locate the active Adaptor-LINK11. It may not be running";
    public static final String ADAPTOR_LINK11_SUCCESS = "The Adaptor-LINK11 is configured properly.";


    //CHECK ADAPTER LINK16

    public static final String ADAPTOR_NAME_LINK16 = "Adaptor-LINK16";
    public static final String ADAPTOR_TEST_NAME_LINK16 = String.format(TEST_NAME_TEMPLATE, ADAPTOR_NAME_LINK16);
    public static final String ADAPTOR_DESC_LINK16 = String.format(TEST_DESC_TEMPLATE, ADAPTOR_NAME_LINK16);

    public static final HashMap<String, String> PROPERTY_VALS_LINK16 = new HashMap<String, String>() {{
        put("protocol", "JREAP");
        put("tcpPort", "2042");
        put("udpPort", "2042");
        put("logMessages", "true");
        put("linkName", "LINK-A");
        put("useSSL", "false");
    }};
    public static final HashMap<String, HashMap<String, String>> COMMON_VALS_LINK16 = new HashMap<String, HashMap<String, String>>() {{
        put("Property", PROPERTY_VALS_LINK16);
    }};

    public static final HashMap<String, String> CUSTOM_TAG_VALS_ADAPTOR_LINK16 = new HashMap<String, String>() {{
        put("ProtocolIn", "UDP/Client");
    }};

    public static final List<UserInputField> USER_INPUT_FIELDS_LINK16
            = Arrays.asList(WindowsConstants.USER_CONFIG_JREAP_HOST_IP, WindowsConstants.USER_CONFIG_OWN_UNIT_JTN,
            WindowsConstants.USER_CONFIG_SSL_ENABLED, WindowsConstants.USER_CONFIG_UDP_PORT);

    public static final String ADAPTOR_LINK16_FILE_MISSING = "Could not locate the active Adaptor-LINK16. It may not be running";
    public static final String ADAPTOR_LINK16_SUCCESS = "The Adaptor-LINK16 is configured properly.";

    //CHECK ADAPTER NAVSSI

    public static final String NAME_NAVSSI = "Adaptor-NAVSSI";
    public static final String TEST_NAME_NAVSSI = String.format(TEST_NAME_TEMPLATE, NAME_NAVSSI);
    public static final String DESC_NAVSSI = String.format(TEST_DESC_TEMPLATE, NAME_NAVSSI);

    public static final HashMap<String, String> PROPERTY_VALS_NAVSSI = new HashMap<String, String>() {{
        put("baudRate", "4800");
        put("parity", "NONE");
        put("flowControl", "NONE");
        put("dataBits", "8");
        put("stopBits", "1");
        put("logMessages", "false");
        put("useSystemTime", "true");
    }};

    public static final HashMap<String, HashMap<String, String>> COMMON_VALS_NAVSSI = new HashMap<String, HashMap<String, String>>() {{
        put("Property", PROPERTY_VALS_NAVSSI);
    }};

    public static final HashMap<String, String> CUSTOM_TAG_VALS_ADAPTOR_NAVSSI = new HashMap<String, String>() {{
        put("ProtocolIn", "Serial");
    }};

    public static final List<UserInputField> USER_INPUT_FIELDS_NAVSSI
            = Arrays.asList(WindowsConstants.USER_CONFIG_CLASSIFICATION, WindowsConstants.USER_CONFIG_NAVSSI_PORT);

    public static final String ADAPTOR_NAVSSI_FILE_MISSING = "Could not locate the active Adaptor-NAVSSI. It may not be running";
    public static final String ADAPTOR_NAVSSI_SUCCESS = "The Adaptor-NAVSSI is configured properly.";


    //CHECK ADAPTER TAB37FFTBMD

    public static final String ADAPTOR_NAME_TAB37FFTBMD = "Adaptor-TAB37.*FFT.*BMD";
    public static final String ADAPTOR_NAME_TAB37FFTBMD_NO_REGEX = "Adaptor-TAB37-FFT-BMD";
    public static final String ADAPTOR_TEST_NAME_TAB37FFTBMD = String.format(TEST_NAME_TEMPLATE, ADAPTOR_NAME_TAB37FFTBMD_NO_REGEX);
    public static final String ADAPTOR_DESC_TAB37FFTBMD = String.format(TEST_DESC_TEMPLATE, ADAPTOR_NAME_TAB37FFTBMD_NO_REGEX);

    public static final HashMap<String, String> PROPERTY_VALS_TAB37FFTBMD = new HashMap<String, String>() {{
        put("baudRate", "19200");
        put("parity", "NONE");
        put("flowControl", "NONE");
        put("dataBits", "8");
        put("stopBits", "1");
        put("logMessages", "true");
        put("commPort", "COM1");
        put("channelClass", "SECRET");
        put("showMessages", "true");
        put("debug", "true");
    }};

    public static final HashMap<String, HashMap<String, String>> COMMON_VALS_TAB37FFTBMD = new HashMap<String, HashMap<String, String>>() {{
        put("Property", PROPERTY_VALS_TAB37FFTBMD);
    }};

    public static final HashMap<String, String> CUSTOM_TAG_VALS_ADAPTOR_TAB37FFTBMD = new HashMap<String, String>() {{
        put("ProtocolIn", "Serial");
        put("AutoStart", "false");
        put("AutoRestart", "false");
    }};

    public static final List<UserInputField> USER_INPUT_FIELDS_TAB37FFTBMD
            = Arrays.asList(WindowsConstants.USER_CONFIG_TAB37_PORT);

    //CHECK CORRELATOR LINK 11

    public static final String NAME_CORRELATOR_LINK11 = "Correlator-LINK11";
    public static final String DESC_CORRELATOR_LINK11 = "Verify the LINK11 Correlator has the proper configuration";
    public static final String TEST_NAME_CORRELATOR_LINK11 = String.format(TEST_NAME_TEMPLATE, NAME_CORRELATOR_LINK11);

    public static final HashMap<String, String> PROPERTY_VALS_CORELLATOR_LINK11 = new HashMap<String, String>() {{
        put("doTweak", "true");             //enable oni db processing
        put("preferONIData", "true");       //prefer oni name and callsign to reported
        put("useMMSI_Lookup", "true");      //mmsi to lookup
        put("useIMO_Lookup", "true");       //imo to lookup
        put("useIRCS_Lookup", "true");      //callsign to lookup
        put("exerciseState", "0");          //0 is real world
    }};
    public static final HashMap<String, HashMap<String, String>> COMMON_VALS_CORRELATOR_LINK11 = new HashMap<String,
            HashMap<String, String>>() {{
        put("Property", PROPERTY_VALS_CORELLATOR_LINK11);
    }};
    public static final HashMap<String, String> CUSTOM_TAG_VALS_CORRELATOR_LINK11 = null;
    public static final List<UserInputField> USER_INPUT_FIELDS_CORRELATOR_LINK11
            = Collections.emptyList();

    public static final String CORRELATOR_LINK11_FILE_MISSING = "Could not locate the active Correlator-LINK11. It may not be running";
    public static final String CORRELATOR_LINK11_SUCCESS = "The Correlator-LINK11 is configured properly.";

    // CHECK CORRELATOR LINK 16

    public static final String NAME_CORRELATOR_LINK16 = "Correlator-LINK16";
    public static final String DESC_CORRELATOR_LINK16 = "Verify the LINK16 Correlator has the proper configuration";
    public static final String TEST_NAME_CORRELATOR_LINK16 = String.format(TEST_NAME_TEMPLATE, NAME_CORRELATOR_LINK16);

    public static final HashMap<String, String> PROPERTY_VALS_CORELLATOR_LINK16 = new HashMap<String, String>() {{
        put("doTweak", "true");             //enable oni db processing
        put("preferONIData", "true");       //prefer oni name and callsign to reported
        put("useMMSI_Lookup", "true");      //mmsi to lookup
        put("useIMO_Lookup", "true");       //imo to lookup
        put("useIRCS_Lookup", "true");      //callsign to lookup
        put("exerciseState", "0");          //0 is real world
    }};
    public static final HashMap<String, HashMap<String, String>> COMMON_VALS_CORRELATOR_LINK16 = new HashMap<String,
            HashMap<String, String>>() {{
        put("Property", PROPERTY_VALS_CORELLATOR_LINK16);
    }};
    public static final HashMap<String, String> CUSTOM_TAG_VALS_CORRELATOR_LINK16 = null;
    public static final List<UserInputField> USER_INPUT_FIELDS_CORRELATOR_LINK16
            = Collections.emptyList();

    public static final String CORRELATOR_LINK16_FILE_MISSING = "Could not locate the active Correlator-LINK16. It may not be running";
    public static final String CORRELATOR_LINK16_SUCCESS = "The Correlator-LINK16 is configured properly.";

    //CHECK CORRELATOR OWNSHIP

    public static final String ADAPTOR_NAME_CORRELATOR_OWNSHIP = "Correlator-Ownship";
    public static final String ADAPTOR_DESC_CORRELATOR_OWNSHIP = "Verify the Correlator-Ownship has the proper configuration";
    public static final String ADAPTOR_TEST_NAME_CORRELATOR__OWNSHIP = String.format(TEST_NAME_TEMPLATE, ADAPTOR_NAME_CORRELATOR_OWNSHIP);

    public static final HashMap<String, String> PROPERTY_VALS_CORELLATOR_OWNSHIP = new HashMap<String, String>() {{
        put("useSystemTime", "true");
    }};
    public static final HashMap<String, HashMap<String, String>> COMMON_VALS_CORRELATOR_OWNSHIP = new HashMap<String,
            HashMap<String, String>>() {{
        put("Property", PROPERTY_VALS_CORELLATOR_OWNSHIP);
    }};
    public static final HashMap<String, String> CUSTOM_TAG_VALS_CORRELATOR_OWNSHIP = null;
    public static final List<UserInputField> USER_INPUT_FIELDS_CORRELATOR_OWNSHIP
            = Arrays.asList(WindowsConstants.USER_CONFIG_TRACK_UPDATE_INTERVAL);

    public static final String CORRELATOR_OWNSHIP_FILE_MISSING = "Could not locate the active Correlator-Ownship. It may not be running";
    public static final String CORRELATOR_OWNSHIP_SUCCESS = "The Correlator-Ownship is configured properly.";

    //CHECK COUPLER TCP TWO WAY SERIAL

    public static final String ADAPTOR_NAME_COUPLERTCP = "Coupler-TCP-Two-Way-Serial";
    public static final String ADAPTOR_DESC_COUPLERTCP = "Check Coupler TCP Two Way Serial Configuration";
    public static final String ADAPTOR_TEST_NAME_COUPLERTCP = String.format(TEST_NAME_TEMPLATE, ADAPTOR_NAME_COUPLERTCP);

    public static final HashMap<String, String> PROPERTY_VALS_COUPLERTCP = new HashMap<String, String>() {{
        put("ReadtcpMode", "Server");
        put("ReadtcpPort", "4004");
        put("baudRate", "9600");
        put("flowControl", "NONE");
        put("dataBits", "8");
        put("parity", "NONE");
        put("stopBits", "1");
        put("useReadLine", "false");
    }};
    public static final HashMap<String, HashMap<String, String>> COMMON_VALS_COUPLERTCP = new HashMap<String,
            HashMap<String, String>>() {{
        put("Property", PROPERTY_VALS_COUPLERTCP);
    }};
    public static final HashMap<String, String> CUSTOM_TAG_VALS_COUPLERTCP = null;
    public static final List<UserInputField> USER_INPUT_FIELDS_COUPLERTCP
            = Arrays.asList(WindowsConstants.USER_CONFIG_CLASSIFICATION, WindowsConstants.USER_CONFIG_COUPLERTCP_PORT);

    public static final String COUPLERTCP_FILE_MISSING = "Could not locate the active Coupler-TCP-Two-Way-Serial. It may not be running";
    public static final String COUPLERTCP_SUCCESS = "The Coupler-TCP-Two-Way-Serial is configured properly.";


    //CHECK MESSAGE PROCESSOR TCPIP
    public static final String ADAPTOR_NAME_MESSAGE_PROCESSOR = "Message-Processor";
    public static final String ADAPTOR_DESC_MESSAGE_PROCESSOR = "Verify the Message Processor TCP/IP has the proper configuration";
    public static final String ADAPTOR_TEST_NAME_MESSAGE_PROCESSOR = String.format(TEST_NAME_TEMPLATE, ADAPTOR_NAME_MESSAGE_PROCESSOR);

    public static final HashMap<String, String> PROPERTY_VALS_MESSAGE_PROCESSOR = new HashMap<String, String>() {{
        put("tcpPort", "2021");
        put("logMessages", "false");
        put("useSSL", "false");
    }};
    public static final HashMap<String, HashMap<String, String>> COMMON_VALS_MESSAGE_PROCESSOR = new HashMap<String,
            HashMap<String, String>>() {{
        put("Property", PROPERTY_VALS_MESSAGE_PROCESSOR);
    }};
    public static final HashMap<String, String> CUSTOM_TAG_VALS_MESSAGE_PROCESSOR = new HashMap<String, String>() {{
        put("ProtocolIn", "TCP/Client");
    }};
    public static final List<UserInputField> USER_INPUT_FIELDS_MESSAGE_PROCESSOR
            = Arrays.asList(WindowsConstants.USER_CONFIG_CLASSIFICATION);

    public static final String MESSAGE_PROCESSOR_FILE_MISSING = "Could not locate the active Message Processor TCP/IP. It may not be running";
    public static final String MESSAGE_PROCESSOR_SUCCESS = "The Message Processor TCP/IP is configured properly.";


}