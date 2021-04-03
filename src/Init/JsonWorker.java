package Init;

import Collection.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.UUID;

/**
 * Класс, отвечающий за работу приложения с коллекцией типа PriorityQueue
 */
public class JsonWorker {

    Random random = new Random();

    /**
     *
     * @param filepath - Переменная окружения, в которой лежит файл формата .json, в котором хранится коллекция
     * @return movies - возвращает коллекцию типа movie из указанного файла с объектами
     * @throws FileNotFoundException - Исключение, возникающее в результате указания неверного пути до целевого файла
     */

    public PriorityQueue<Movie> getMovieFromJson(String filepath) throws IOException {
        PriorityQueue<Movie> movies = new PriorityQueue<>();

        boolean fileFound;
        File file = new File(filepath);
        if (file.exists() && !file.isDirectory()) {
            fileFound = true;
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                GsonBuilder gsonBuilder = new GsonBuilder();
                Gson gson = gsonBuilder.create();
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    try {
                        Movie movie = gson.fromJson(line, Movie.class);
                        movies.add(movie);
                    } catch (JsonSyntaxException e) {
                        System.out.println("поврежждение файла");
                    }

                }
                bufferedReader.close();
            } catch (IOException e) {
                Path path = Paths.get(filepath);
                if (!Files.isReadable(path)) {
                    System.out.println("Нет прав на чтение");
                }
            }
        } else {
            System.out.println("Файл не найден");
            fileFound = false;
        }


//            Path path = Paths.get(filepath);
//            boolean isreadable;
//            isreadable = Files.isReadable(path);
//            if (!isreadable) {
//                System.out.println("Прав на чтение нет");
//            }
        return movies;
    }

    public void end (PriorityQueue<Movie> movies, String filepath) {
        boolean fileFound;
        File file = new File(filepath);
        if (file.exists() && !file.isDirectory()) {
            try {
                GsonBuilder builder = new GsonBuilder();
                Gson gson = builder.create();
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (Movie movie : movies) {
                    String json = gson.toJson(movie);
                    bufferedWriter.write(json + "\n");
                }

                bufferedWriter.close();

            } catch (IOException e) {
                Path path = Paths.get(filepath);
                if (!Files.isWritable(path)) {
                    System.out.println("Нет прав на запись");
                }
                //System.out.println("Возникла ошибка доступа к файлу, либо недостаточно прав, либо файла не существует");
            }
        } else {
            System.out.println("файл не найден");
        }

    }
}