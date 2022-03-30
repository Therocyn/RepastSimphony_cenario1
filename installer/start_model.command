#!/bin/bash

# Repast Simphony Model run script for macOS and Linux

PWD="${0%/*}"
cd "$PWD"

# Note the Repast Simphony Directories.
REPAST_SIMPHONY_ROOT=/home/therocyn/eclipse/plugins/repast.simphony.runtime_2.9.0

# Define the Core Repast Simphony Directories and JARs
CP=$CP:$REPAST_SIMPHONY_ROOT/bin
CP=$CP:$REPAST_SIMPHONY_ROOT/lib/*

# Groovy jar

CP=$CP:/mnt/HD/repastworkspace/cenario1/installer/groovy-3.0.9.jar

# User model lib jars
CP=$CP:lib/*

# Change to the project directory
cd "/mnt/HD/repastworkspace/cenario1"

# Start the Model
java -XX:+IgnoreUnrecognizedVMOptions --add-modules=ALL-SYSTEM --add-exports=java.base/jdk.internal.ref=ALL-UNNAMED -cp "$CP" repast.simphony.runtime.RepastMain  "/mnt/HD/repastworkspace/cenario1/cenario1.rs"
