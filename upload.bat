set APPENGINEC:\appengine-java-sdk-1.7.5\bin
set EMAIL=j.h.churchill.3@gmail.com
set PATH=%JAVA_HOME%\bin;%PATH%;%APPENGINE%

appcfg.cmd -e %EMAIL% update target/qrproj-0.1
rem appcfg.cmd rollback target\qrproj-0.1
PAUSE