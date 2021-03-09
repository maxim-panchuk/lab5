package Init.Command;

import Collection.Movie;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.PriorityQueue;

/**
 * Вывод информации о коллекции Movie,
 */
public class InfoCommand {
    /**
     * Метод выводит информацию о коллекции (Количество элементов, Тип коллекции, Имя файла)
     * @param movies - Рабочая коллекция
     * @param filepath - путь к рабочему файлу
     */
    public static void execute(PriorityQueue<Movie> movies, String filepath) {
        Path path = Paths.get(filepath);
        try {
            System.out.println("Количество элементов:  " + movies.size());
            System.out.println("Тип коллекции:  " + movies.getClass().toString());
            System.out.println("Имя фала:  " + path.toString());
            System.out.println(Files.getLastModifiedTime(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
