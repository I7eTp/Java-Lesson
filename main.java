package lessonDZ2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

//1. Напишите метод, который принимает на вход строку (String) и определяет является ли строка палиндромом (возвращает boolean значение).
//2. Напишите метод, который составит строку, состоящую из 100 повторений слова TEST и метод, который запишет эту строку
// в простой текстовый файл, обработайте исключения.
public class main {
    public static void main(String[] args) {
        System.out.print(" Домашнее задание №2\n" +
                "1. Задача 'Полиндром' \n" +
                "2. Задача 'Запись в файл и Исключения'\n" +
                "Введите пункт: ");
        Scanner in = new Scanner(System.in);
        int choice = in.nextInt();
        switch (choice) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            default:
                System.out.println("Не введен № задачи");
        }
    }

    private static void task2() {
//        String str = makeWord(100,"TEST");
//        System.out.println(str);
        String path = System.getProperty("user.dir") + "/src/main/java/lessonDZ2/";
        String fileName = "fileSem2.txt";
        makeFileWord(fileName, path, makeWord(100, "TEXT"), false);
        readFileWord(fileName, path);
    }

    private static void makeFileWord(String file, String path, String text, boolean recordType) {
        try {
//            System.out.println("pathProject = " + pathProject);
//            System.out.println(System.getProperty("file.separator"));
            File fileUser = new File(path, file);
//            System.out.println(fileUser.getAbsolutePath());
            if (fileUser.createNewFile()) {
                System.out.println("Создан новый файл");
            } else {
                System.out.println("Используется существующий файл");
            }
            if (fileUser.canWrite()) {
                System.out.println("Возможна запись в файл");
            }
            FileWriter fileUserWriter = new FileWriter(fileUser, recordType);
            fileUserWriter.append(text);
            fileUserWriter.flush();
            fileUserWriter.close();
            // Чтение из файла
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Алярма! Проблемы с файлом");
        }
    }

    private static void readFileWord(String file, String path) {
        try (FileReader fileReader = new FileReader(path + file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String text;
            while ((text = bufferedReader.readLine()) != null) {
                System.out.println(text);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println("Алярма! Файл не читается или отсутствует :(");
        }
    }

    private static String makeWord(int circle, String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < circle; i++) {
            sb.append(word).append(";");
        }
        return sb.toString();
    }


    private static void task1() {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите слово:");
        String inWord = in.next();
//        System.out.println(inWord);
        if (checkPolindrom(inWord)) {
            System.out.printf("Слово %s полиндром", inWord);
        } else {
            System.out.printf("Слово %s НЕ полиндром", inWord);
        }
    }

    private static Boolean checkPolindrom(String word) {
        Boolean flag = true;
        char[] wordArray = word.toCharArray();
        for (int i = 0; i < wordArray.length / 2; i++) {
            if (wordArray[i] != wordArray[wordArray.length - i - 1]) {
                flag = false;
            }
        }
        return flag;
    }
}
