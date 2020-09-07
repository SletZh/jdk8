package multithread.threadlocal.demo;

/**
 * @author SletZh
 * @Date 2020-04-13-13:42
 */
public class TestLockMethod {
    public static void main(String[] args) {
        TestLockMethod m=new TestLockMethod();
        new Thread(m::method1).start();
        new Thread(m::method1).start();
        new Thread(TestLockMethod::method2).start();
        new Thread(TestLockMethod::method2).start();
    }

    private synchronized void method1(){//锁对象默认是当前对象
        this.notify();
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"运行了"+i+"次");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                this.notify();
            }
        }
    }

    private static synchronized void method2(){//锁对象默认是类对象
        TestLockMethod.class.notify();
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"运行了"+i+"次");
            try {
                TestLockMethod.class.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                TestLockMethod.class.notify();
            }
        }
    }
}
