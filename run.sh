#!/bin/bash
docker run --rm -m64m --memory-swappiness 0 --memory-swap 0 memorytest:latest /app/$1.sh
