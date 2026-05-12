package _4_2_Classwork;

public class Task2 {
    public static void main(String[] args) {
        Account A = new Account(100, 100);
        Account B = new Account(200, 200);
        Thread t1 = new Thread(() -> transfer(A, B, 10));
        Thread t2 = new Thread(() -> transfer(B, A, 25));

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }


    }

    public static void transfer(Account from, Account to, int amount){
        Account first  = from.getId() < to.getId() ? from : to;
        Account second = from.getId() < to.getId() ? to   : from;

        synchronized (first) {
            }
            synchronized (second) {
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }