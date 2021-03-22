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
        try {
            int input = Integer.parseInt(input1);
            movies.removeIf(movie1 -> movie1.getId() > input);
        } catch (NumberFormatException e) {
            System.out.println("Элементов с большим ID в коллекции не существует");
        }

    }
}
