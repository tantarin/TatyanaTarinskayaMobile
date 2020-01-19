# TatyanaTarinskayaMobile
TatianaTarinskaiaMobile
branch #2
A way to run with maven:
1) install adb tool and appium server;

2) run Appium Server;

3) connect your device to your computer;

4) in cmd enter command: adb devices;

5) copy your device id and insert value into src\main\resources\native.properties and src\main\resources\web.properties for key "device"

6) also insert in .properties your email,username and password;

7) in terminal enter command: mvn clean test;

8) enjoy.
