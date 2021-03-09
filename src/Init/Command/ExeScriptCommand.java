package Init.Command;

import Collection.Movie;
import Init.CommandSelector;

import java.io.*;
import java.util.PriorityQueue;

/**
 *
 */

public class ExeScriptCommand {
    /**
     *
     * @param movies - Рабочая коллекция
     * @param filepath - Путь до рабочего файла
     * @param filePathForCommand - Путь до файла, который хранит команды для исполнения формата .txt
     */
    public static void execute (PriorityQueue<Movie> movies, String filepath, String filePathForCommand) {
        try {
            String line;
            File file = new File(filePathForCommand);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            CommandSelector commandSelector = new CommandSelector();

            while ((line = bufferedReader.readLine()) != null) {
                String[] lines = line.split(" ");
                if (lines[0].trim().equals("execute_script")) {
                    throw new StackOverflowError();
                } else {
                    commandSelector.selectCommand(line.trim(), movies, filepath);
                    SaveCommand.execute(movies, filepath);
                }
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println(".");
        } catch (StackOverflowError e) {
            System.out.println("В файле команды находится рекурсия, т.е execute_script в execute_script ");
        }
    }
}
