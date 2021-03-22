package Init.Command;

import Collection.Movie;
import Init.Commands;
import Init.MovieBuilder;

import java.util.PriorityQueue;

/**
 * Добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции
 */

public class AddIfMinCommand extends Commands {
    /**
     *
     * @param movies - Коллекция
     * @param idd - id элемента
     */
    public static void execute(PriorityQueue<Movie> movies, String idd) {
        MovieBuilder movieBuilder = new MovieBuilder();
        int id = Integer.parseInt(idd);
        Movie newElement = movieBuilder.newMovie();
        if (newElement.getId() < id) {
            movies.add(newElement);
        }
    }
}
