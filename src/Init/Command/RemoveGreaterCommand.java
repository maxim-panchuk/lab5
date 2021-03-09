package Init.Command;

import Collection.Movie;

import java.util.PriorityQueue;

/**
 * Удалить из коллекции все элементы, превышающие заданный
 */

public class RemoveGreaterCommand {
    /**
     *
     * @param movies - Рабочая коллекция
     * @param input1 - id элемента, с которого будет происходить удаление
     */
    public static void execute(PriorityQueue<Movie> movies, String input1) {
        int input = Integer.parseInt(input1);
        movies.removeIf(movie1 -> movie1.getId() > input);
    }
}
