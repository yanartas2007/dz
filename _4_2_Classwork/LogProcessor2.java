package _4_2_Classwork;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class LogProcessor2 {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\admin\\IdeaProjects\\dz\\_4_2_Classwork\\acess.log"));
            final int[] errorCount = {0};
            LinkedList<String> product = new LinkedList<>();
            final boolean[] isEnd = {false}; // система с POISON мне не нравится по причине что мало ли нехорошие люди такое в лог закинут и не будет корректно работать
            Thread pr = new Thread(() -> {synchronized (product) {while (!isEnd[0]) {
                while (product.size() == 10) {
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

            Thread co1 = new Thread(() -> {synchronized (product) {while (!isEnd[0]) {
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

            Thread co2 = new Thread(() -> {synchronized (product) {while (!isEnd[0]) {
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
                        synchronized (errorCount) {
                            errorCount[0]++;
                        }
                    }
                    product.notifyAll();
                }
            }
            }});

            pr.start();
            co1.start();
            co2.start();

            pr.join();
            co1.join();
            co2.join();

            System.out.println(errorCount[0]);

        } catch (IOException | InterruptedException e) {
            System.out.println(e);
        }


    }
    // при замене notifyAll на notify ничего не поменялось

}