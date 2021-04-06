package Init;


import Collection.Movie;
import Init.Command.*;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Класс, отвечающий за выбор команд пользователем в консоли
 */
public class CommandSelector {

    Scanner in = new Scanner(System.in);

    /**
     *
     * @param command - комманда, которую пользователь вводит в консоли при работе с программой
     * @param movies - коллекция типа Movie для работы с объектами
     * @param filepath - путь до файла, в котором хранятся объекты коллекции
     */
    public void selectCommand(String command, PriorityQueue<Movie> movies, String filepath, Boolean fileFound) {

        String[] commandParts = command.trim().split(" ");

        switch (commandParts[0].trim()) {
            case "add_if_min": {
                assert movies.peek() != null;
                AddIfMinCommand.execute(movies, movies.peek().getId().toString());
                break;
            }
            case "filter_starts_with_name": {
                FilterStartsWithNameCommand.execute(movies);
                break;
            }
            case "help": {
                HelpCommand.execute();
                break;
            }
            case "info": {
                InfoCommand.execute(movies, filepath);
                break;
            }
            case "show": {
                ShowCommand.execute(movies);
                break;
            }
            case "add": {
                AddCommand.execute(movies);
                break;
            }
            case "update": {
                try {
                    String input = commandParts[1].trim();
                    UpdateIdCommand.execute(movies, input);
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Введите команду в консольном формате update {id}");
                    break;
                }

            }
            case "remove": {
                try {
                    String input = commandParts[1].trim();
                    RemoveByIdCommand.execute(movies, input);
                    break;
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Введите команду в консольном формате remove {id}");
                    break;
                }
            }
            case "clear": {
                ClearCommand.execute(movies);
                break;
            }
            case "save": {
                SaveCommand.execute(movies, filepath, fileFound);
                break;
            }
            case "remove_head": {
                RemoveHeadCommand.execute(movies);
                break;
            }
            case "print_ascending": {
                PrintAsceendingCommand.execute(movies);
                break;
            }
            case "remove_greater": {
                String input1 = commandParts[1].trim();
                RemoveGreaterCommand.execute(movies, input1);
                break;
            }
            case "execute_script": {
                ExeScriptCommand.execute(movies, filepath, commandParts[1].trim());
                break;
            }
            case "print_field_ascending_director": {
                PrintFieldAsceendingDirCommand.execute(movies);
                break;
            }
            case "exit": {
                System.out.println("Выход");
                break;
            }
            default: {
                System.out.println("Некорректный ввод команды");
                break;
            }
        }
    }
}

