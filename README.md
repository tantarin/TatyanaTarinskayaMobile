# TatyanaTarinskayaMobile
TatianaTarinskaiaMobile

A way to run with maven:

install adb tool and appium server
run Appium Server
connect your device to your computer
in cmd enter command: adb devices
copy your device id and insert value into src\main\resources\native.properties and src\main\resources\web.properties for key "device"
in terminal enter command: mvn clean test
