
package com.mycompany.textredactor;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;

public class TextRedactor {
public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Укажите путь к файлу в системе: ");
        String sourceFilePath = scanner.nextLine();
        try {
            BufferedReader stroka = new BufferedReader(new FileReader(sourceFilePath));//запись в буфер считанной строки из файла
            String line;
            StringBuilder modifiedText = new StringBuilder();
   
            while ((line = stroka.readLine()) != null) {
                modifiedText.append(PerevorotStroke(line)).append("\n");// переворот строки методом PerevorotStroke
            }
            stroka.close();
            String pathFile = NewAdressFile(sourceFilePath);// путь файла
            BufferedWriter writer = new BufferedWriter(new FileWriter(pathFile)); // запись в буфер нового адреса файла
            writer.write(modifiedText.toString());
            writer.close();
            System.out.println("Файл изменен  и пересохранен: " + pathFile);
        } catch (IOException x) {
            System.err.println("Ошибка при чтении  файла: " + x.getMessage());
        }
    }
    private static String PerevorotStroke(String stroka) {
        StringBuilder perevorot = new StringBuilder();
        for (int i = stroka.length() - 1; i >= 0; i--) {
            perevorot.append(stroka.charAt(i));
        }
        return perevorot.toString();
    }
    private static String NewAdressFile(String x) {
        int posledZnak = x.lastIndexOf(".");
        String addDomen = "";
        if (posledZnak != -1) {
            addDomen = x.substring(posledZnak);
        }
        String newDomen = "ExitFile"+addDomen;
        return x.replaceFirst("","")+"_"+newDomen;
    }
}
