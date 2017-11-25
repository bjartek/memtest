#!/bin/bash
docker run --rm -m128M --name memtest --memory-swappiness 0 --memory-swap 0 memorytest:latest /app/$1.sh
