package multithread.threadlocal.demo;

/**
 * @author SletZh
 * @Date 2020-04-13-9:04
 */
public class Test {
    /**
     * 静态代码块和非静态代码块锁的问题
     *
     * 用户线程和守护线程
     * 1.用户线程执行完成后结束，守护线程在用户线程执行完，jvm关闭后强制结束
     * @param args
     */
    public static void main(String[] args) {
        Test test=new Test();
        Thread a=new Thread(){
            @Override
            public void run() {
                test.method1(); //锁是test对象
            }
        };
        Thread b=new Thread(){
            @Override
            public void run() {
                Test.method2(); //锁是Test.class对象
            }
        };
        Thread c=new Thread(){
            @Override
            public void run() {
                while(true){
                    System.out.println("执行资源监控");
                }
            }
        };
        //先设置为守护线程在启动
        c.setDaemon(true);
        //c.start();
        Thread d=new Thread(){
            @Override
            public void run() {
                test.method3();
            }
        };
        Thread e=new Thread(){
            @Override
            public void run() {
                Test.method4();
            }
        };
        try {
            //先启动在join
            a.start();
            b.start();
            a.join();
            b.join();
            d.start();
            d.join();
            e.start();
            e.join();
        } catch (InterruptedException m) {
           m.printStackTrace();
        }
        /*for(int i=0;i<10;i++) {
            System.out.println("主线程执行"+i+"次");
        }*/

    }

    public synchronized void  method1(){  //默认锁对象是当前对象
            for(int i=0;i<10;i++){
                System.out.println("线程a"+i+"正在执行");
            }
    }

    public synchronized void  method3(){  //默认锁对象是当前对象
        for(int i=0;i<10;i++){
            System.out.println("线程d"+i+"正在执行");
        }
    }

    public static synchronized void method2(){//默认锁对象是类对象
            for(int i=0;i<10;i++){
                System.out.println("线程b"+i+"正在执行");
                try {
                    Test.class.wait(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
    }

    public static synchronized void method4(){//默认锁对象是类对象
        for(int i=0;i<10;i++){
            System.out.println("线程e"+i+"正在执行");
        }
    }
}
