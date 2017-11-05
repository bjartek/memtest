#!/bin/bash
mvn clean compile
docker build -t memorytest:latest .
