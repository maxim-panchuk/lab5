package Init.Command;

import Collection.Movie;
import Init.Commands;
import Init.MovieBuilder;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.PriorityQueue;

public class UpdateIdCommand extends Commands {       // обновить значение элемента коллекции, id которого равен заданному

    /**
     * Метод обновляет элемент коллекции с указанным id
     * @param movies - Коллекция типа Movie
     * @exception NumberFormatException - Возникает при некорректном вводе поля id
     * @exception ConcurrentModificationException - Возникает из-за особенности используемой в программе коллекции типа
     * PriorityQueue, в которой нельзя изменять значения элемента во время работы итератора в одном потоке, обращение
     * к элементу по индексу в этой коллекции так же невозможно есть возможность изменить последний элемент.
     */
    public static void execute(PriorityQueue<Movie> movies, String input) {
        try {
            int id = Integer.parseInt(input);
            MovieBuilder movieBuilder = new MovieBuilder();
            boolean found = false;
            for (Movie movie : movies) {
                if (movie.getId().equals(id)) {
                    movies.remove(movie);
                    movies.add(movieBuilder.newMovie());
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Такого ID нет в коллекции");
                System.out.println("Существующие элементы:");
                ShowCommand.execute(movies);
            }
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException:  Некорректное значение ID, команда не может быть выполнена!");
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException: Невозможно извлечь элемент их коллекции типа Queue, попро" +
                    "буйте взять последний элемент для перезаписи");
        }
    }
}
