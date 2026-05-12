package _4_2_Classwork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class LogProcessor {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\admin\\IdeaProjects\\dz\\_4_2_Classwork\\acess.log"));
            final int[] errorCount = {0};
            LinkedList<String> product = new LinkedList<>();
            final boolean[] isEnd = {false}; // не работает в лямбде просто boolean почему то. ide предложила или так или через atomic. не знаю что такое atomic, поэтому так
            Thread pr = new Thread(() -> {synchronized (product) {while (!isEnd[0]) {
                        while (product.size() == 5) {
                            try {
                                product.wait();
                                if (isEnd[0]) {
                                    break;
                                }
                            } catch (InterruptedException e) {
                                System.out.println(e);
                            }
                        }
                        try {
                            String s = br.readLine();
                            if (s != null) {
                                product.add(s);
                            } else {
                                isEnd[0] = true;
                                product.notifyAll();
                                break;
                            }
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        synchronized (product) {
                            product.notifyAll();
                        }
                    }
                }});

            Thread co = new Thread(() -> {synchronized (product) {while (!isEnd[0]) {
                        while (product.size() == 0) {
                            try {
                                product.wait();
                                if (isEnd[0]) {
                                    break;
                                }
                            } catch (InterruptedException e) {
                                System.out.println(e);
                            }
                        }
                if (isEnd[0]) {
                    break;
                }

                        synchronized (product) {
                            if (product.pop().indexOf("ERROR") != -1) {
                                errorCount[0]++;
                            }
                            product.notifyAll();
                        }
                    }
                }});

            pr.start();
            co.start();

            pr.join();
            co.join();

            System.out.println(errorCount[0]);

        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }


    }

    // здесь еще нужны методы produce и consume, но я не вижу смысла их делать, тк их логика уже реализована
    // логи чайника сгенерены дипсиком. самое удивительное в них то что в моменте на чайник приходит звонок
}