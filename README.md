# Build
Look at build.sh

# Run

## To run with normal heap initialization
./run.sh start 

## To run with -XX:AlwayPreTouch
./run.sh pretouch

You can see the limits and current memory usage with docker stats

## To run with using cgroups limits for memory
./run.sh cgroups


## Observations
 - start will be OOM killed by the kernel when it allocates to much memory
 - pretrouch will not start since it allocates to much memory up front
 - cgroups will be killed by java with a normal stack trace and NOT oomkiller
