package Init.Command;

import Collection.Movie;

import java.util.NoSuchElementException;
import java.util.PriorityQueue;

/**
 * Вывод первого элемента коллекции и его удаление
 */
public class RemoveHeadCommand {
    /**
     *
     * @param movies - Рабочая коллекция
     * @throws NoSuchElementException - возникает в случае, когда пользователь пытается удалить элемент из пустой
     * коллекции
     */
    public static void execute(PriorityQueue<Movie> movies) throws NoSuchElementException{
        try {
            System.out.println(movies.remove());
            System.out.println("Элемент успешно удален");
        } catch (NoSuchElementException e) {
            System.out.println("Все элементы коллекции удалены");
        }

    }
}
