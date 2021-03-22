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
        try {
            int id = Integer.parseInt(ida);
            boolean found = false;

            for (Movie movie : movies) {
                if (movie.getId().equals(id)) {
                    movies.remove(movie);
                    found = true;
                    System.out.println("Элемент успешно удален");
                }
            }
            if (!found) {
                System.out.println("Элемента с таким ID не существует, список элементов коллекции:");
                ShowCommand.execute(movies);
            }
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException:  Некорректное значение ID, команда не может быть выполнена!");
        }
    }
}
