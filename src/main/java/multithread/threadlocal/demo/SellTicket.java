package multithread.threadlocal.demo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author SletZh
 * @Date 2020-04-13-12:50
 */
public class SellTicket {
    private static AtomicInteger ticketTotal =new AtomicInteger(50);
    public static void main(String[] args) {
        new Thread(() -> {
            //synchronized ("锁") {  //这个锁其他窗口都锁住了
                while (ticketTotal.get() > 0) {
                    synchronized ("锁") { //这个锁出现了超卖现象
                            if(ticketTotal.get()>0) {//再次判断，防止超卖
                                ticketTotal.getAndDecrement();
                                System.out.println("一号窗口卖出一张，" + "当前票数" + ticketTotal + "张");
                            }
                        }
                }
            //}
        }).start();
        new Thread(() -> {
            //synchronized ("锁") { //这个锁其他窗口都锁住了
                while (ticketTotal.get() > 0) {
                    synchronized ("锁") { //这个锁出现了超卖现象
                            if(ticketTotal.get()>0) {//再次判断，防止超卖
                                ticketTotal.getAndDecrement();
                                System.out.println("二号窗口卖出一张，" + "当前票数" + ticketTotal + "张");
                            }
                        }
                }
            //}
        }).start();
        new Thread(() -> {
            //synchronized ("锁") { //这个锁其他窗口都锁住了
                while (ticketTotal.get() > 0) {
                    synchronized ("锁") { //这个锁出现了超卖现象
                            if(ticketTotal.get()>0) {//再次判断，防止超卖
                                ticketTotal.getAndDecrement();
                                System.out.println("三号窗口卖出一张，" + "当前票数" + ticketTotal + "张");
                            }
                        }
                }
            //}
        }).start();
    }

}
