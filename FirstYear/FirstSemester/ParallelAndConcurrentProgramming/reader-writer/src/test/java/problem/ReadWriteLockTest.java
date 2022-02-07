package problem;

import org.junit.jupiter.api.Test;

class ReadWriteLockTest {
    static int resursaComuna = 10;

    @Test
    public void testRead() throws InterruptedException {
        ReadWriteLock readWriteLock = new ReadWriteLock();
        Thread t1 = new Thread(() -> {
            try {
                readWriteLock.readLock();
                System.out.println("Thread 1");
                System.out.println(resursaComuna);
                Thread.sleep(3000);
                readWriteLock.readUnLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                readWriteLock.readLock();
                System.out.println("Thread 2");
                System.out.println(resursaComuna + "t2");
                Thread.sleep(2000);
                readWriteLock.readUnLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                readWriteLock.writeLock();
                System.out.println("Thread 3");
                resursaComuna = 100;
                System.out.println(resursaComuna);
                readWriteLock.writeUnlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t3.join();
    }

    @Test
    public void testWrite() throws InterruptedException {
        ReadWriteLock readWriteLock = new ReadWriteLock();
        Thread t1 = new Thread(() -> {
            try {
                readWriteLock.readLock();
                System.out.println(resursaComuna);
                readWriteLock.readUnLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                readWriteLock.readLock();
                System.out.println(resursaComuna);
                readWriteLock.readUnLock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                readWriteLock.writeLock();
                resursaComuna = 100;
                System.out.println(resursaComuna);
                Thread.sleep(2000);
                readWriteLock.writeUnlock();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        t3.start();
        t1.start();
        t2.start();

        t2.join();
    }
}