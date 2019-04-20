@if "%DEBUG%" == "" @echo off
@rem ##########################################################################
@rem
@rem  web-frontend startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%..

@rem Add default JVM options here. You can also use JAVA_OPTS and WEB_FRONTEND_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS=

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if "%ERRORLEVEL%" == "0" goto init

echo.
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto init

echo.
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME%
echo.
echo Please set the JAVA_HOME variable in your environment to match the
echo location of your Java installation.

goto fail

:init
@rem Get command-line arguments, handling Windows variants

if not "%OS%" == "Windows_NT" goto win9xME_args

:win9xME_args
@rem Slurp the command line arguments.
set CMD_LINE_ARGS=
set _SKIP=2

:win9xME_args_slurp
if "x%~1" == "x" goto execute

set CMD_LINE_ARGS=%*

:execute
@rem Setup the command line

set CLASSPATH=%APP_HOME%\lib\web-frontend-0.0.1.jar;%APP_HOME%\lib\commons-lang3-3.8.1.jar;%APP_HOME%\lib\guava-27.0.1-jre.jar;%APP_HOME%\lib\jjwt-0.9.0.jar;%APP_HOME%\lib\joda-time-2.10.1.jar;%APP_HOME%\lib\spring-boot-starter-actuator-2.1.3.RELEASE.jar;%APP_HOME%\lib\jobjectformatter-0.2.1.jar;%APP_HOME%\lib\jdefensive-0.2.0.jar;%APP_HOME%\lib\spring-boot-starter-web-2.1.3.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-thymeleaf-2.1.3.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-security-2.1.3.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-data-mongodb-2.1.3.RELEASE.jar;%APP_HOME%\lib\failureaccess-1.0.1.jar;%APP_HOME%\lib\listenablefuture-9999.0-empty-to-avoid-conflict-with-guava.jar;%APP_HOME%\lib\jsr305-3.0.2.jar;%APP_HOME%\lib\checker-qual-2.5.2.jar;%APP_HOME%\lib\error_prone_annotations-2.2.0.jar;%APP_HOME%\lib\j2objc-annotations-1.1.jar;%APP_HOME%\lib\animal-sniffer-annotations-1.17.jar;%APP_HOME%\lib\spring-boot-actuator-autoconfigure-2.1.3.RELEASE.jar;%APP_HOME%\lib\spring-boot-starter-json-2.1.3.RELEASE.jar;%APP_HOME%\lib\jackson-datatype-jsr310-2.9.8.jar;%APP_HOME%\lib\jackson-datatype-jdk8-2.9.8.jar;%APP_HOME%\lib\jackson-module-parameter-names-2.9.8.jar;%APP_HOME%\lib\jackson-databind-2.9.8.jar;%APP_HOME%\lib\spring-boot-starter-2.1.3.RELEASE.jar;%APP_HOME%\lib\micrometer-core-1.1.3.jar;%APP_HOME%\lib\spring-boot-starter-tomcat-2.1.3.RELEASE.jar;%APP_HOME%\lib\hibernate-validator-6.0.14.Final.jar;%APP_HOME%\lib\spring-webmvc-5.1.5.RELEASE.jar;%APP_HOME%\lib\spring-security-web-5.1.4.RELEASE.jar;%APP_HOME%\lib\spring-web-5.1.5.RELEASE.jar;%APP_HOME%\lib\thymeleaf-spring5-3.0.11.RELEASE.jar;%APP_HOME%\lib\thymeleaf-extras-java8time-3.0.3.RELEASE.jar;%APP_HOME%\lib\spring-security-config-5.1.4.RELEASE.jar;%APP_HOME%\lib\spring-data-mongodb-2.1.5.RELEASE.jar;%APP_HOME%\lib\spring-boot-autoconfigure-2.1.3.RELEASE.jar;%APP_HOME%\lib\spring-boot-actuator-2.1.3.RELEASE.jar;%APP_HOME%\lib\spring-boot-2.1.3.RELEASE.jar;%APP_HOME%\lib\spring-security-core-5.1.4.RELEASE.jar;%APP_HOME%\lib\spring-context-5.1.5.RELEASE.jar;%APP_HOME%\lib\spring-aop-5.1.5.RELEASE.jar;%APP_HOME%\lib\mongodb-driver-3.8.2.jar;%APP_HOME%\lib\jackson-annotations-2.9.0.jar;%APP_HOME%\lib\jackson-core-2.9.8.jar;%APP_HOME%\lib\spring-boot-starter-logging-2.1.3.RELEASE.jar;%APP_HOME%\lib\javax.annotation-api-1.3.2.jar;%APP_HOME%\lib\spring-tx-5.1.5.RELEASE.jar;%APP_HOME%\lib\spring-data-commons-2.1.5.RELEASE.jar;%APP_HOME%\lib\spring-beans-5.1.5.RELEASE.jar;%APP_HOME%\lib\spring-expression-5.1.5.RELEASE.jar;%APP_HOME%\lib\spring-core-5.1.5.RELEASE.jar;%APP_HOME%\lib\snakeyaml-1.23.jar;%APP_HOME%\lib\HdrHistogram-2.1.9.jar;%APP_HOME%\lib\LatencyUtils-2.0.3.jar;%APP_HOME%\lib\tomcat-embed-websocket-9.0.16.jar;%APP_HOME%\lib\tomcat-embed-core-9.0.16.jar;%APP_HOME%\lib\tomcat-embed-el-9.0.16.jar;%APP_HOME%\lib\validation-api-2.0.1.Final.jar;%APP_HOME%\lib\jboss-logging-3.3.2.Final.jar;%APP_HOME%\lib\classmate-1.4.0.jar;%APP_HOME%\lib\thymeleaf-3.0.11.RELEASE.jar;%APP_HOME%\lib\logback-classic-1.2.3.jar;%APP_HOME%\lib\log4j-to-slf4j-2.11.2.jar;%APP_HOME%\lib\jul-to-slf4j-1.7.25.jar;%APP_HOME%\lib\slf4j-api-1.7.25.jar;%APP_HOME%\lib\mongodb-driver-core-3.8.2.jar;%APP_HOME%\lib\bson-3.8.2.jar;%APP_HOME%\lib\spring-jcl-5.1.5.RELEASE.jar;%APP_HOME%\lib\attoparser-2.0.5.RELEASE.jar;%APP_HOME%\lib\unbescape-1.1.6.RELEASE.jar;%APP_HOME%\lib\logback-core-1.2.3.jar;%APP_HOME%\lib\log4j-api-2.11.2.jar

@rem Execute web-frontend
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %WEB_FRONTEND_OPTS%  -classpath "%CLASSPATH%" io.rad.platfom.Application %CMD_LINE_ARGS%

:end
@rem End local scope for the variables with windows NT shell
if "%ERRORLEVEL%"=="0" goto mainEnd

:fail
rem Set variable WEB_FRONTEND_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
if  not "" == "%WEB_FRONTEND_EXIT_CONSOLE%" exit 1
exit /b 1

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega
