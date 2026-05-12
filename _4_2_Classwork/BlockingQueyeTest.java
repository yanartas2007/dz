package _4_2_Classwork;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import static org.junit.jupiter.api.Assertions.*;

class MyBlockingQueueTest {
    @Test
    void testProducersConsumers(){
        MyBlockingQueue<Integer> q = new MyBlockingQueue<>(5);
        AtomicInteger pr_ans = new AtomicInteger(0); // ладно, если ide настаивает, попробую так
        AtomicInteger co_ans = new AtomicInteger(0);
        Thread pr1 = new Thread(() -> {for (int j = 0; j < 100; j++) {
                try {
                    Thread.sleep(new Random().nextInt(0, 6));
                    q.put(j);
                    pr_ans.incrementAndGet(); // это, видимо, аналог ++ для atomic, но еще зачем то возвращает значение
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });;
        Thread pr2 = new Thread(() -> {for (int j = 0; j < 100; j++) {
                try {
                    Thread.sleep(new Random().nextInt(0, 6));
                    q.put(j);
                    pr_ans.incrementAndGet();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
        });;
        pr1.start();
        pr2.start();

        Thread[] co = new Thread[3];
        for (int i = 0; i < 3; i++) {
            co[i] = new Thread(() -> {while (true) {try {
                        Thread.sleep(new Random().nextInt(0, 11));
                        Integer item = q.take();
                        if (item == -42) { // попробую все таки делать пилюлю, предположим, что в данных ее не встретится
                            break;
                        }
                        co_ans.incrementAndGet();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }});
            co[i].start();
        }

        try {
            pr1.join();
            pr2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }

        for (int i = 0; i < 3; i++) {
            q.put(-42);
        }

        for (Thread c : co) {
            try {
                c.join();
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }

        int needed = 2 * 100;
        assertEquals(needed, pr_ans.get());
        assertEquals(needed, co_ans.get());
        assertEquals(0, q.size());
    }}