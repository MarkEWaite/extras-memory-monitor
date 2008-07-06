package org.jvnet.hudson;

/**
 * Memory usage. Immutable.
 *
 * @author Kohsuke Kawaguchi
 */
public class MemoryUsage {
    /**
     * Total physical memory of the system, in bytes.
     */
    public final long totalPhysicalMemory;
    /**
     * Of the total physical memory of the system, available bytes.
     */
    public final long availablePhysicalMemory;

    /**
     * Total number of swap space in bytes.
     */
    public final long totalSwapSpace;
    /**
     * Available swap space in bytes.
     */
    public final long availableSwapSpace;

    public MemoryUsage(long totalPhysicalMemory, long availablePhysicalMemory, long totalSwapSpace, long availableSwapSpace) {
        this.totalPhysicalMemory = totalPhysicalMemory;
        this.availablePhysicalMemory = availablePhysicalMemory;
        this.totalSwapSpace = totalSwapSpace;
        this.availableSwapSpace = availableSwapSpace;
    }

    public String toString() {
        return String.format("Memory:%d/%dMB  Swap:%d/%dMB",
            toMB(availablePhysicalMemory),
            toMB(totalPhysicalMemory),
            toMB(availableSwapSpace),
            toMB(totalSwapSpace));        
    }

    private static long toMB(long l) {
        return l/(1024*1024);
    }
}
