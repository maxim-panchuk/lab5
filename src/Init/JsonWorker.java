package Init;

//import Collection.Director.*;
import Collection.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
//import com.google.gson.JsonSyntaxException;
import java.io.*;

import java.util.PriorityQueue;
import java.util.UUID;

/**
 * Класс, отвечающий за работу приложения с коллекцией типа PriorityQueue
 */
public class JsonWorker {

    /**
     *
     * @param filepath - Переменная окружения, в которой лежит файл формата .json, в котором хранится коллекция
     * @return movies - возвращает коллекцию типа movie из указанного файла с объектами
     * @throws FileNotFoundException - Исключение, возникающее в результате указания неверного пути до целевого файла
     */

    public PriorityQueue<Movie> getMovieFromJson(String filepath) throws FileNotFoundException {
        PriorityQueue<Movie> movies = new PriorityQueue<>();

        try {
            File file = new File(filepath);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                Movie movie = gson.fromJson(line, Movie.class);
                movie.setId(Math.toIntExact(UUID.randomUUID().getMostSignificantBits() & Integer.MAX_VALUE));
                movies.add(movie);
            }

            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Возникла ошибка доступа к файлу, либо недостаточно прав, либо файла не существует");
        }

        return movies;
    }

    public void end (PriorityQueue<Movie> movies, String filepath) {
        try {
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            File file = new File(filepath);
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (Movie movie : movies) {
                String json = gson.toJson(movie);
                bufferedWriter.write(json + "\n");
            }

            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Возникла ошибка доступа к файлу, либо недостаточно прав, либо файла не существует");
        }
    }
}
