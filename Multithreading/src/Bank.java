import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: LeMatin (Administrator)
 * @Date: 2019/6/19 13:51
 * @Description:
 */
public class Bank {

    public static void main(String[] args) {

        Person person = new Person();

        Thread t1 = new Thread(person);
        t1.setName("1");
        Thread t2 = new Thread(person);
        t2.setName("2");

        t1.start();
        t2.start();

    }

}

class Person implements Runnable{

    private int add = 1000;
    private int Count = 3000;
    private ReentrantLock lock = new ReentrantLock(true);

    public Person() {

    }

    @Override
//    public synchronized void  run() {
//
//        for (int i = 0; i < 3; i++) {
//            Count+=add;
//            System.out.println(Thread.currentThread().getName()+"存"+Count);
//        }
//
//    }

//    public void run(){
//
//        synchronized (this) {
//            for (int i = 0; i < 3; i++) {
//                Count+=add;
//                System.out.println(Thread.currentThread().getName()+"存"+Count);
//            }
//        }
//
//    }


    public void run(){

        try{
            lock.lock();

            for (int i = 0; i < 3; i++) {
                Count+=add;
                System.out.println(Thread.currentThread().getName()+"存"+Count);
            }

        }finally {

            lock.unlock();

        }


    }
}

