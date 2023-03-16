package lessonDZ3;

import java.text.DecimalFormat;
import java.util.*;
// 1. Пусть дан произвольный список целых чисел, удалить из него четные числа (в языке уже есть что-то готовое для этого)
// 2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
// 3. Создать список типа ArrayList<String>. Поместить в него как строки, так и целые числа. Пройти по списку, найти и удалить целые числа.

public class main {
    public static void main(String[] args) {
        task1();
//        task2();
//        task3();
    }

    private static void task1() {
        System.out.println("Введите сначала размер массива, а затем верхнюю границу массива");
        int count = getNumber();
        int lastBound = getNumber();
        long time1 = timeRun();
//        List<Integer> numericList = new LinkedList<>();
//        numericList = createList(count, lastBound);
          List<Integer> numericList = createList(count, lastBound);
//
        printList(numericList, false);
        deleteEvenNumber(numericList);
        printList(numericList, true);
        System.out.printf("Время выполнения - %d", timeRun() - time1);
    }

    private static void task2() {
        System.out.println("Введите сначала размер массива, а затем верхнюю границу массива");
        int count = getNumber();
        int lastBound = getNumber();
        long time1 = timeRun();
        List<Integer> numericList = new ArrayList<>();
        numericList.addAll(createList(count, lastBound));
//            System.out.println(numericList.getClass());
        printList(numericList, false);
        List<Double> parameterList = new ArrayList<>();
        parameterList = getMathParameterList(numericList);
//            System.out.println(parameterList);
//            System.out.println(parameterList.getClass());
        printParameter3set(parameterList);
        System.out.printf("Время выполнения - %d", timeRun() - time1);

    }

    private static void task3() {
        System.out.println("Введите размер массива");
        int count = getNumber();
        long time1 = timeRun();
        List<String> beList = new ArrayList<>();
        int numericRandom = 100;
        createBeList(beList, count, numericRandom);
        System.out.println(beList);
        deleteEvenNumberInStringArray(beList);
        System.out.println(beList);
        System.out.printf("Время выполнения - %d", timeRun() - time1);
    }

    private static void deleteEvenNumberInStringArray(List<String> collection) {
        int i = 0;
//        System.out.println(collection.getClass());
        while (i < collection.size()) {
            if (isNumeric(collection.get(i))) {
                if (Integer.parseInt(collection.get(i)) % 2 == 0) {
                    collection.remove(i);
                } else {
                    i++;
                }
            } else {
                i++;
            }
        }
    }
