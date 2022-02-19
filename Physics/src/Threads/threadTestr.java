package Threads;

import java.util.ArrayList;

public class threadTestr {
    static ArrayList<Double> listToEdit = new ArrayList<Double>();
    static ArrayList<Double> listToEdit1 = new ArrayList<Double>();
    static ArrayList<Double> listToEdit2 = new ArrayList<Double>();
    public static void main(String[] args) {
//hello
        for (int i = 0; i < 100000; i++) {
            listToEdit.add((double)(int)(Math.random()));
        }
        for(int i = 0; i < listToEdit.size(); i++) {
            listToEdit1.add(listToEdit.get(i));
            listToEdit2.add(listToEdit.get(i));
        }
        System.out.println("Starting single threaded operation...");
        long startTime1 = System.nanoTime();
        editListSingleThread();
        long endTime1 = System.nanoTime();
        long dur1 = (endTime1 - startTime1) / 1000000;
        System.out.println("Finishing single threaded operation...");
        System.out.println();
        System.out.println("Starting multi threaded operation...");
        long startTime2 = System.nanoTime();
        editListMultiThread(8, listToEdit2.size());
        long endTime2 = System.nanoTime();
        long dur2 = (endTime2 - startTime2) / 1000000;
        System.out.println("Finishing multi threaded operation...");

        System.out.println("Results");
        if (!listToEdit1.equals(listToEdit2)) {
            System.out.println("Multithreaded did not properly execute!");
            for (int i = 0; i < listToEdit1.size(); i++) {
                System.out.print(listToEdit1.get(i) + " ");
            }
            System.out.println();
            for (int i = 0; i < listToEdit2.size(); i++) {
                System.out.print(listToEdit2.get(i) + " ");
            }
            System.out.println();
        }
        System.out.println("Time to execute single threaded: " + dur1 + "ms");
        System.out.println("Time to execute multi threaded: " + dur2 + "ms");



    }

    public static void editListSingleThread() {

        for (int i = 0; i < listToEdit1.size(); i++) {
            for(int j = 0; j < listToEdit1.size(); j++) {
                listToEdit1.set(i, listToEdit1.get(i) + listToEdit.get(j));
            }
        }
    }

    public static void editListMultiThread(int threadCount, int size) {
        int chunk = size / threadCount;
        Worker[] threads = new Worker[threadCount];
        int count = 0;
        for (int i = 0; i < listToEdit2.size(); i +=  chunk) {

            ArrayList<Double> dividedData =  new ArrayList(listToEdit2.subList(i,(int) Math.min(listToEdit2.size(), i + chunk)));
            threads[count] = new Worker(dividedData);
            count ++;
        }

        for (int i = 0; i < threads.length; i++) {
            threads[i].start();
        }
        boolean allFinished = false;
        do {
            allFinished = true;
            for (int i = 0; i < threads.length; i++) {
                if (threads[i].isAlive()) allFinished = false;
            }
        } while (!allFinished);
        listToEdit2.clear();
        for (int i = 0; i < threads.length; i++) {
            listToEdit2.addAll(threads[i].getData());
        }

    }
    static class Worker extends Thread {
        private ArrayList<Double> data;
        public Worker(ArrayList<Double> data) {
            this.data = data;

        }
        @Override
        public void run() {
            for (int i = 0; i < data.size(); i++) {
                for (int j = 0; j < listToEdit2.size(); j++) {
                    data.set(i, data.get(i) + listToEdit2.get(j));
                }
            }
        }
        public ArrayList<Double> getData() {
            return data;
        }
    }
}

