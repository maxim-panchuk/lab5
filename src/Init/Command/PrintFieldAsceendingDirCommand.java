package Init.Command;

import Collection.Director.Person;
import Collection.Movie;
import Init.Commands;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Вывести значения поля director всех элементов в порядке возрастания
 */

public class PrintFieldAsceendingDirCommand extends Commands {
    /**
     *
     * @param movies - Рабочая коллекция
     */
    public static void execute(PriorityQueue<Movie> movies) {
        ArrayList<Person> dirNames = new ArrayList<>();
        for (Movie o : movies) {
            dirNames.add(o.getDirector());
        }
        class DirNamesComparator implements Comparator<Person> {
            /**
             *
             * @param dirName1 - первый объект типа Person для сравнения
             * @param dirName2 - второй объект типа Person для сравнения
             * @return - возвращает значение типа int для реализации сортировки
             */
            @Override
            public int compare (Person dirName1, Person dirName2) {
                return dirName1.getName().length() - dirName2.getName().length();
            }
        }
        Comparator<Person> comparator = new DirNamesComparator();
        dirNames.sort(comparator);
        for (Person dirName : dirNames) {
            System.out.println(dirName);
        }
    }
}
