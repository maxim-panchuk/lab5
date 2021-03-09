package Init.Command;

import Collection.Movie;
import Init.Commands;

import java.util.*;

/**
 * Вывести элементы коллекции в порядке возрастания
 */

public class PrintAsceendingCommand extends Commands {
    /**
     *
     * @param movies - Рабочая коллекция
     */

    public static void execute(PriorityQueue<Movie> movies) {

        ArrayList<Integer> list = new ArrayList<>();
        for (Movie id : movies) {
            list.add(id.getId());
        }
        class MovieComparator implements Comparator<Integer> {
            @Override
            public int compare(Integer id1, Integer id2) {
                return id1.compareTo(id2);
            }
        }
        Comparator<Integer> comparator = new MovieComparator();
        list.sort(comparator);
        for (Integer id : list) {
            for (Movie movie : movies) {
                if (id.equals(movie.getId())) {
                    System.out.println(movie.toString());
                }
            }
        }
    }
}
