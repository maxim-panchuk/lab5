package Init.Command;

import Collection.Movie;
import Init.Commands;

import java.util.PriorityQueue;

/**
 * Вывод в стандартный поток вывода все элементы коллекции в строковом представлении
 */

public class ShowCommand extends Commands {
    /**
     *
     * @param movies - коллекция типа Movie
     */

    public static void execute(PriorityQueue<Movie> movies) {
        if (movies.size() == 0) {
            System.out.println("Коллекция пуста");
        } else {
            for (Movie o : movies) {
                System.out.println(o.toString());
            }
        }
    }
}
