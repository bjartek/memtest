package test;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 */
public class App {

	private static final int MB = 1024 * 1024;
	private static ByteBuffer byteBuffer;


	public static void main(String[] args) throws InterruptedException, NoSuchFieldException, IllegalAccessException {
		List<byte[]> b = new ArrayList<byte[]>();
		byteBuffer = ByteBuffer.allocateDirect(MB * 50);
		MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
		for (int i = 0; i < 128; i++) {
			b.add(new byte[MB * 4]);
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
