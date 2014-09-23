gradle clean build
cd ~/apps/Tomcat7/webapps/
rm Test02.war
rm -r Test02
cd ~/Desktop/FinalYearProject/Testing01/Test02/build/libs
cp Test02.war ~/apps/Tomcat7/webapps/
