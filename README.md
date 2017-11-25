# Build
Look at build.sh

# Run

This program will allocate a 50Mb Off-Heap ByteBuffer, then it will loop and allocate chunks of 4Mb OnHeap.

## To run with normal heap initialization XMX and XMS set to 256
./run.sh start 

## To run with -XX:AlwayPreTouch and XMX=XMS=256
./run.sh pretouch

You can see the limits and current memory usage with docker stats

## To run with using cgroups limits for memory
./run.sh cgroups


## Observations
 - start will be OOM killed by the kernel when it allocates to much memory
 - pretrouch will not start since it allocates to much memory up front
 - cgroups will be killed by java with a normal stack trace and NOT oomkiller

## Resources
https://stackoverflow.com/questions/38597965/difference-between-resident-set-size-rss-and-java-total-committed-memory-nmt?noredirect=1&lq=1
http://trustmeiamadeveloper.com/2016/03/18/where-is-my-memory-java/
http://matthewkwilliams.com/index.php/2016/03/17/docker-cgroups-memory-constraints-and-java-cautionary-tale/
https://stackoverflow.com/questions/31173374/why-does-a-jvm-report-more-committed-memory-than-the-linux-process-resident-set
