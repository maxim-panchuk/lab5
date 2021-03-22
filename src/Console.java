/**
  @author Maksim Panchuk
 */

import Collection.Movie;
import Init.CommandSelector;
import Init.Commands;
import Init.JsonWorker;

import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Console extends Commands {
    public static String filepath = null;

    public static void main(String[] args) {
        try {
            System.out.println("Введите путь к файлу .json");
            filepath = in.nextLine(); //"/Users/maksimpancuk/Desktop/JavaLab/file.json";
            String json = filepath.trim();
            if (filepath.contains("json")) {

                JsonWorker jsonWorker = new JsonWorker();
                PriorityQueue<Movie> movies = jsonWorker.getMovieFromJson(json);
                CommandSelector commandSelector = new CommandSelector();
                Scanner in = new Scanner(System.in);
                System.out.println("Введите команду, для получения информации о возможных командах, введите: help");

                //boolean state = false;
                while (in.hasNextLine()) {
                    String command = in.nextLine();
                    while (!command.equals("exit")) {
                        commandSelector.selectCommand(command, movies, filepath);
                        command = in.nextLine();
                    }
                    break;
                }
            } else {
                System.out.println("Формат файла должен быть json");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException Файл не найден");
        }
    }
}
