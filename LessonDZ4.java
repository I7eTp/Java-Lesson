package lessonDZ4;
// 1. Реализовать консольное приложение, которое:
//    Принимает от пользователя и “запоминает” строки.
//    Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
//    Если введено revert, удаляет предыдущую введенную строку из памяти.
// 2. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.


import java.util.*;

public class main {
    public static final List<String> dataExample = List.of(
            "Первый элемент",
            "Второй элемент",
            "Третий элемент",
            "Четвертый элемент",
            "Мила Йовович",
            "Шестой элемент",
            "Седьмой элемент"
    );

    public static void main(String[] args) {
        task1();
//        task2();
    }

    private static void task2() {
        LinkedList<String> listData = initialList();
        System.out.println("Исходный список:");
        printStringList(listData, true);
        System.out.println("Инверсированный список:");
        printStringList(listData, false);
        printStringArray(listData);
    }

    private static void printStringArray(LinkedList<String> stringList) {
        if (emptyLinkedList(stringList)) {
            return;
        }
        String[] listArray = new String[stringList.size()];
        for (int i = stringList.size() - 1; i >= 0; i--) {
            listArray[stringList.size() - 1 - i] = stringList.get(i);
        }
        System.out.println(String.join(" ", Arrays.toString(listArray)));
    }

    private static LinkedList<String> initialList() {
        List<String> stringList = new LinkedList<>();
        stringList.addAll(dataExample);
        return (LinkedList<String>) stringList;
    }


    private static void task1() {
        System.out.println("Введите строку \n" +
                "возможен ввод нескольких строк\n" +
                "для выхода наберите 'выход'\n" +
                "'печать' - вывод задом наперед\n" +
                "'возврат' - удаление предыдущей введенной строки");
        Scanner in = new Scanner(System.in);
        LinkedList<String> stringList = new LinkedList<>();
        while (true) {
            System.out.print("=>: ");
            String word = in.next();
            if (word.equals("выход")) {
                System.out.println("Пока-пока :)");
                return;
            } else if (word.equals("печать")) {
                boolean orderPrint = false; // выбор направления вывода данных
                printStringList(stringList, orderPrint);
            } else if (word.equals("возврат")) {
                stringList.removeLast();
            } else {
                stringList.add(word);
            }
        }
    }

    private static void printStringList(LinkedList<String> stringList, boolean printOrderNext) {
        if (emptyLinkedList(stringList)) {
            return;
        }
        System.out.print("{ ");
        if (printOrderNext) {
            ListIterator<String> iterator = stringList.listIterator();
            while (iterator.hasNext()) {
                System.out.printf("%s  ", iterator.next());
            }
        } else {
            ListIterator<String> iterator = stringList.listIterator(stringList.size());
            while (iterator.hasPrevious()) {
                System.out.printf("%s  ", iterator.previous());
            }
        }
        System.out.println("}");
    }

    private static boolean emptyLinkedList(LinkedList stringList) {
        if (stringList.isEmpty()) {
            System.out.println("Печалька, нет данных :(\n" +
                    "введите что-нибудь :)");
            return true;
        } else {
            return false;
        }
    }
}

