package Init.Command;

import Collection.Movie;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Вывести элементы, значение поля name которых начинается с заданной подстроки
 */

public class FilterStartsWithNameCommand {
    /**
     *
     * @param movies - Рабочая коллекция
     */
    public static void execute (PriorityQueue<Movie> movies) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите подстроку для вывода");
        String regex = in.nextLine();
        for (Movie movie : movies) {
            if (movie.getName().contains(regex)) {
                System.out.println(movie.toString());
            }
        }
    }
}
