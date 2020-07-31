package com.company;

import java.io.*;
import java.util.Scanner;

public class MyStudents {
    private static File file;
    public static void main(String[] args) throws Exception {

        file = new File("D:\\WorkSpace\\myStudents\\StudentList.txt");
        System.out.println("Что вы хотите сделать?\nвнести\nпрочитать\nзакончить\nудалить");
        String inputOutput = new Scanner(System.in).nextLine();

        if (inputOutput.equalsIgnoreCase("внести")) {
            input();
        }

        if (inputOutput.equalsIgnoreCase("прочитать")) {
            if(file.exists()){
                FileReader fr = new FileReader("StudentList.txt");
                Scanner scan = new Scanner(fr);
                int i = 0;
                while (scan.hasNextLine()) {
                    System.out.println(++i + ": " + scan.nextLine());
                }
                fr.close();
            }
            else {
                System.out.println("Файла не существует. Выберите <внести>, чтобы создать файл");
            }
        }

        if (inputOutput.equalsIgnoreCase("закончить")) {
            System.out.println("Всего доброго!");
            System.exit(0); }

        if (inputOutput.equalsIgnoreCase("удалить")) {
            boolean b = file.delete();
            if(b) System.out.println("файл успешно удален");
        }

        System.out.println("Выберите действие");
        main(args);
    }

    public static void input() {
        String result;
        System.out.println("Введите фамилию/имя ученика");
        Scanner console = new Scanner(System.in);
        result = console.nextLine();
        System.out.println("Введите сумму оплаты");
        result = result + " " + console.nextLine();
        System.out.println("Введите дату платежа");
        result = result + " " + console.nextLine();

        try {
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(result + "\n");
            bw.close();
            fw.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}