#!/bin/bash

for psize in 256 512; do 
for size in 2 4; do 
for nsize in 2 4; do 
  start=$(date +"%s")
  printf ${size}asd
#Xms${size}g --Xmx${size}g --Xmn${size}g  -XX:PermSize=64M -XX:MaxPermSize=${psize}M -XX:-OmitStackTraceInFastThrow -XX:SurvivorRatio=2 -XX:+UseG1GC -XX:NewSize=${nsize}g -XX:MaxNewSize=${nsize}g -XX:ConcGCThreads -XX:+UseStringDeduplication
  stop=$(date +"%s")
  date
  echo "size: $size seconds:" $(expr $stop - $start)
done
