package multithread.threadlocal.demo;

/**
 * @author SletZh
 * @Date 2020-04-13-12:09
 */
public class TestLock {
    public static void main(String[] args) {
        TestLock testLock=new TestLock();
        Thread t1=new Thread(){
            @Override
            public void run() {
                synchronized (testLock){
                    testLock.notify();  //每次执行前都叫醒等待中的线程
                    for(int i=0;i<10;i++){
                        System.out.println("线程t1执行了"+i+"次");
                        try {
                            testLock.wait();
                            //System.out.println(1);  //线程等待后的代码不会执行
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                            //System.out.println(11); //线程等待finally语句块也不会执行
                            testLock.notify();//每次执行后还需要叫醒等待中的线程
                        }
                    }
                }
            }
        };
        Thread t2=new Thread(){
            @Override
            public void run() {
                synchronized (testLock){
                    testLock.notify(); //每次执行前都叫醒等待中的线程
                    for(int i=0;i<10;i++){
                        System.out.println("线程t2执行了"+i+"次");
                        try {
                            testLock.wait();
                            //System.out.println(2); //线程等待后的代码不会执行
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }finally {
                           // System.out.println(22); //线程等待finally语句块也不会执行
                            testLock.notify();//每次执行后还需要叫醒等待中的线程
                        }
                    }
                }
            }
        };
        t1.start();
        t2.start();
    }
}
