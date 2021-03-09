package Init.Command;

import Collection.Movie;

import java.util.PriorityQueue;

/**
 * Удалить элемент из коллекции по его id
 */
public class RemoveByIdCommand {
    /**
     *
     * @param movies - Рабочая коллекция
     * @param ida - id удаляемого элемента
     */
    public static void execute(PriorityQueue<Movie> movies, String ida) {
        int id = Integer.parseInt(ida);
        movies.removeIf(movie -> movie.getId().equals(id));
    }
}
