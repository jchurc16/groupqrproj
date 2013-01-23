set APPENGINE=C:\software\appengine-java-sdk-1.7.4\bin
set EMAIL=tim.niblett@cilogi.com
set PATH=%JAVA_HOME%\bin;%PATH%;%APPENGINE%

appcfg.cmd -e %EMAIL% update target/qrproj-0.1
rem appcfg.cmd rollback target\qrproj-0.1