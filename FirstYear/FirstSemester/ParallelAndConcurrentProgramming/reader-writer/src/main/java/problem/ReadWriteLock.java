package problem;

import java.util.concurrent.Semaphore;

public class ReadWriteLock {
    private Semaphore readSemaphore = new Semaphore(1);
    private Semaphore writeSemaphore = new Semaphore(1);

    private int noOfReadThreads = 0;

    public void readLock() throws InterruptedException {
        readSemaphore.acquire();
        if (noOfReadThreads == 0){
            writeSemaphore.acquire();
        }
        noOfReadThreads++;
        readSemaphore.release();
    }

    public void readUnLock() throws InterruptedException {
        readSemaphore.acquire();
        noOfReadThreads--;
        if (noOfReadThreads == 0){
            writeSemaphore.release();
        }
        readSemaphore.release();
    }

    public void writeLock() throws InterruptedException {
        writeSemaphore.acquire();
    }

    public void writeUnlock(){
        writeSemaphore.release();
    }
}
