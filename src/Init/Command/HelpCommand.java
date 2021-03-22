package Init.Command;

/**
 * Вывод списка комманд, доступных пользователю
 */
public class HelpCommand {
    public static void execute() {
        System.out.println("help : вывести справку по доступным командам");
        System.out.println("info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)");
        System.out.println("show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении");
        System.out.println("add : добавить новый элемент в коллекцию");
        System.out.println("update {id} : обновить значение элемента коллекции, id которого равен заданному");
        System.out.println("remove {id} : удалить элемент из коллекции по его id");
        System.out.println("clear : очистить коллекцию");
        System.out.println("save : сохранить коллекцию в файл");
        System.out.println("execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.");
        System.out.println("exit : завершить программу (без сохранения в файл)");
        System.out.println("remove_head : вывести первый элемент коллекции и удалить его");
        System.out.println("add_if_min {id} : добавить новый элемент в коллекцию, если его значение меньше, чем у наименьшего элемента этой коллекции");
        System.out.println("remove_greater {id} : удалить из коллекции все элементы, превышающие заданный");
        System.out.println("filter_starts_with_name {name} : вывести элементы, значение поля name которых начинается с заданной подстроки");
        System.out.println("print_ascending : вывести элементы коллекции в порядке возрастания");
        System.out.println("print_field_ascending_director : вывести значения поля director всех элементов в порядке возрастания");
    }
}
