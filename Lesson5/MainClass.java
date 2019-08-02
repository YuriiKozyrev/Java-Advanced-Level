package Lesson5;

import java.util.Arrays;

public class MainClass {
    public static void main(String[] args) {
        MainClass mc = new MainClass();
        mc.DivideAndCalculateArrays();
    }

    static final int size = 10000000;
    static final int quantityOfThreads = 2;  // здесь указываем количество потоков больше или равно 1
    static final int h = size/quantityOfThreads;

    float[] arraySource = new float[size];
    float[][] arrayDestination = new float[quantityOfThreads][h];
    Thread[] myThread = new Thread[quantityOfThreads];


//    public void CalculateArray() {
//        Arrays.fill(arraySource, 1);
//        long a = System.currentTimeMillis();
//        for (int i = 0; i < arraySource.length; i++) {
//            arraySource[i] = (float) (arraySource[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
//        }
//        System.out.println("Общее время операции без разбивки на потоки, мс: " + (System.currentTimeMillis() - a));
//    }

    public void DivideAndCalculateArrays() {
        Arrays.fill(arraySource, 1);
        long a = System.currentTimeMillis();

        //разделение массива на требуемое количество массивов для потоков
        for (int i = 0; i < quantityOfThreads; i++) {
            System.arraycopy(arraySource, h*i, arrayDestination[i], 0, h);
        }

        //запуск потоков в цикле
        for(int i = 0; i < quantityOfThreads; i++){
            int step = i;
            myThread[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < arrayDestination[step].length; j++){
                        arrayDestination[step][j] = (float)(arrayDestination[step][j] * Math.sin(0.2f + j/5) * Math.cos(0.2f + j/5) * Math.cos(0.4f + j/2));
                    }
                }
            });
            myThread[i].start();
        }

        try {
            for(int i = 0; i < quantityOfThreads; i++){
                myThread[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //склеивание массивов в один
        for(int i = 0; i < quantityOfThreads; i++) {
            System.arraycopy(arrayDestination[i],0, arraySource, h*i, h);
        }
        System.out.println("Общее время работы " + quantityOfThreads + " потоков, мс: " + (System.currentTimeMillis() - a));
    }
}


