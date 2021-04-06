package Init.Command;

import Collection.Movie;
import Init.Commands;

import java.io.FileNotFoundException;
import java.util.PriorityQueue;

/**
 * Сохранение коллекции в рабочий файл формата json
 */
public class SaveCommand extends Commands {
    /**
     *
     * @param movies - Рабочая коллекция типа Movie
     * @param filepath - Путь к рабочему файлу
     */
    public static void execute(PriorityQueue<Movie> movies, String filepath, Boolean fileFound) {
        if (!fileFound) {
            System.out.println("Введите путь к файлу повторно");
            filepath = in.nextLine();
            jsonWorker.end(movies, filepath);
            System.out.println("Сохранение проведено");
        } else {
            jsonWorker.end(movies, filepath);
        }

    }
}