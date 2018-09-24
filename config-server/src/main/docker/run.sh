#!/bin/sh
echo "********************************************************"
echo "Starting config-server "
echo "********************************************************"
java -jar /usr/local/config-server/@project.build.finalName@.jar
