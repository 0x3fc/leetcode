package PrintInOrder;

import java.util.concurrent.*;

class Foo {
    Semaphore firstRan = new Semaphore(0);
    Semaphore secondRan = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        firstRan.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        firstRan.acquire();
        printSecond.run();
        secondRan.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        secondRan.acquire();
        printThird.run();
    }
}

class Foo2 {
    volatile int count = 0;

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        count = 1;
    }

    public void second(Runnable printSecond) throws InterruptedException {
        while (count < 1) {
        }

        printSecond.run();

        count = 2;
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (count < 2) {
        }

        printThird.run();
    }
}
