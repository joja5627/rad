package io.rad.web.listeners;

import io.rad.web.config.TomcatPortConfig;
import io.rad.web.constants.WindowsConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
@Profile({"prod","dev"})
@Slf4j
public class ApplicationReadyListener {


    @Autowired
    private TomcatPortConfig config;

    @Value("${spring.profiles.active}")
    private String activeProfile;

    private  String getBrowserExecPath(){
        if(activeProfile.equals("dev")){
            if (Files.isDirectory(Paths.get(WindowsConstants.C_DRIVE_PROGRAM_FILES + WindowsConstants.CHROM_DIR))) {
                    return WindowsConstants.C_DRIVE_PROGRAM_FILES + WindowsConstants.CHROM_DIR+ WindowsConstants.CHROME_EXE;
                }else if (Files.isDirectory(Paths.get(WindowsConstants.C_DRIVE_PROGRAM_X86_FILES + WindowsConstants.CHROM_DIR))) {
                    return WindowsConstants.C_DRIVE_PROGRAM_X86_FILES + WindowsConstants.CHROM_DIR+ WindowsConstants.CHROME_EXE;
                }
        }
        String browserExecPath;

        if (Files.isDirectory(Paths.get(WindowsConstants.PROGRAM_FILES + WindowsConstants.MOZILLA_DIR))) {
            browserExecPath = WindowsConstants.C_DRIVE_PROGRAM_FILES + WindowsConstants.MOZILLA_DIR + WindowsConstants.MOZILLA_EXE;
        }else if (Files.isDirectory(Paths.get(WindowsConstants.PROGRAM_X86_FILES + WindowsConstants.MOZILLA_DIR))) {
            browserExecPath = WindowsConstants.C_DRIVE_PROGRAM_X86_FILES + WindowsConstants.MOZILLA_DIR+ WindowsConstants.MOZILLA_EXE;
        }else if (Files.isDirectory(Paths.get(WindowsConstants.C_DRIVE_PROGRAM_FILES + WindowsConstants.CHROM_DIR))) {
            browserExecPath = WindowsConstants.C_DRIVE_PROGRAM_FILES + WindowsConstants.CHROM_DIR+ WindowsConstants.CHROME_EXE;
        }else if (Files.isDirectory(Paths.get(WindowsConstants.C_DRIVE_PROGRAM_X86_FILES + WindowsConstants.CHROM_DIR))) {
            browserExecPath = WindowsConstants.C_DRIVE_PROGRAM_X86_FILES + WindowsConstants.CHROM_DIR+ WindowsConstants.CHROME_EXE;
        }else{
            browserExecPath = WindowsConstants.WINDOWS_DEFAULT_EXE;
        }
        return browserExecPath;
    }

    @EventListener({ApplicationReadyEvent.class})
    public void applicationReadyEvent() throws InterruptedException {
        String openCommand = String.format("%s  %s",getBrowserExecPath(), WindowsConstants.LOCAL_HOST + config.getPort());
        log.info("Opening Base Line Checker with " + openCommand );
        openHomePage(openCommand);
    }

    private static void openHomePage(String url ) {
            Runtime runtime = Runtime.getRuntime();
            try {
                runtime.exec(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}
