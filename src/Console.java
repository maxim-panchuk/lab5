/**
  @author Maksim Panchuk
 */

import Collection.Movie;
import Init.CommandSelector;
import Init.Commands;
import Init.JsonWorker;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Console extends Commands {
    public static String filepath = null;

    public static void main(String[] args) {

        try {
            System.out.println("Введите путь к файлу .json");
            filepath = in.nextLine(); //"/Users/maksimpancuk/Desktop/JavaLab/file.json";
            String json = filepath.trim();

                JsonWorker jsonWorker = new JsonWorker();
                PriorityQueue<Movie> movies = jsonWorker.getMovieFromJson(json);
                CommandSelector commandSelector = new CommandSelector();
                Scanner in = new Scanner(System.in);
                System.out.println("Введите команду, для получения информации о возможных командах, введите: help");

                try {
                    String command = " ";
                    while (!command.equals("exit")) {
                        command = in.nextLine();
                        commandSelector.selectCommand(command, movies, filepath);
                    }
                } catch (NoSuchElementException e) {
                    System.out.println("Ошибка ввода");
                }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException Файл не найден");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String setFilePath () {
        filepath = in.nextLine();
        return filepath;
    }
}
