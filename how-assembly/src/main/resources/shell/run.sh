#!/usr/bin/env bash

frameworkFile=$(ls | grep jar | head -n 1)

java -Dfelix.fileinstall.dir=application -jar $frameworkFile
