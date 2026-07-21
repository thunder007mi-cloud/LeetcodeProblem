import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class FizzBuzz {

    private int n;
    private int current = 1;

    private Semaphore fizzSem = new Semaphore(0);
    private Semaphore buzzSem = new Semaphore(0);
    private Semaphore fizzBuzzSem = new Semaphore(0);
    private Semaphore numberSem = new Semaphore(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            fizzSem.acquire();

            if (current > n) {
                break;
            }

            printFizz.run();
            current++;
            releaseNext();
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            buzzSem.acquire();

            if (current > n) {
                break;
            }

            printBuzz.run();
            current++;
            releaseNext();
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            fizzBuzzSem.acquire();

            if (current > n) {
                break;
            }

            printFizzBuzz.run();
            current++;
            releaseNext();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            numberSem.acquire();

            if (current > n) {
                fizzSem.release();
                buzzSem.release();
                fizzBuzzSem.release();
                break;
            }

            if (current % 3 != 0 && current % 5 != 0) {
                printNumber.accept(current);
                current++;
            }

            releaseNext();
        }
    }

    private void releaseNext() {
        if (current > n) {
            numberSem.release();
            fizzSem.release();
            buzzSem.release();
            fizzBuzzSem.release();
        } else if (current % 15 == 0) {
            fizzBuzzSem.release();
        } else if (current % 3 == 0) {
            fizzSem.release();
        } else if (current % 5 == 0) {
            buzzSem.release();
        } else {
            numberSem.release();
        }
    }
}
