#!/bin/bash
cd "$(dirname "$0")" || exit 1


if ! ps aux | grep -q "[b]aby-redis.jar"; then	
echo "Building package..."

	mvn clean package

	echo "Starting Baby Redis..."
	java -jar target/baby-redis.jar &
else
	echo "Baby Redis is already running"

fi
