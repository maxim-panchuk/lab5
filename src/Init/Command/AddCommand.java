package Init.Command;

import Collection.Movie;
import Init.Commands;
import Init.MovieBuilder;

import java.util.PriorityQueue;

/**
 * Добавление нового элемента в коллекцию
 */
public class AddCommand extends Commands {
    public static void execute (PriorityQueue<Movie> movies) {
        MovieBuilder movieBuilder = new MovieBuilder();
        Movie movieplus = movieBuilder.newMovie();
        if (movieplus != null)
            movies.add(movieplus);
    }
}
