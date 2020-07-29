#!/bin/bash
SERVICE_NAME=${artifactId}
SERVICE_VERSION=${version}
unzip -o $HOME/app/SERVICE_NAME-SERVICE_VERSION.zip -d $HOME/app/$SERVICE_NAME
cd $HOME/app/$SERVICE_NAME/scripts
./shutdown.sh
./startup.sh

