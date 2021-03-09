package Init.Command;

import Collection.Movie;

import java.util.PriorityQueue;

/**
 * Очистить коллекцию Работает отлично
 */

public class ClearCommand {
    public static void execute (PriorityQueue<Movie> movies) {
        movies.clear();
    }
}
