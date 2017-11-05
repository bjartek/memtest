package test;

import sun.misc.Unsafe;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {

    private static final long MB = 1024 * 1024;


    public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
        List<byte[]> b = new ArrayList<byte[]>();
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        for (int i = 0; i < 128; i++) {
            b.add(new byte[4096 * 512]);
            TimeUnit.SECONDS.sleep(1);
            long usedMemoryHeap = memoryBean.getHeapMemoryUsage().getUsed() / MB;
            long usedMemoryNonHeap = memoryBean.getNonHeapMemoryUsage().getUsed() / MB;
            long maxHeapMemory = memoryBean.getHeapMemoryUsage().getMax() / MB;
            System.out.println(
                     " Heap: " + usedMemoryHeap + "MB"
                    + " NonHeap:  " + usedMemoryNonHeap + "MB"
                    + " Max: " + maxHeapMemory + "MB");
        }
        System.out.print(b.size());
    }

}
