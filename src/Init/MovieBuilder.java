package Init;
import Collection.*;
import Collection.Director.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import java.util.Scanner;

/**
 * Класс для создания объектов коллекции типа Movie
 */
public class MovieBuilder {

    public static Scanner scan = new Scanner(System.in);
    private final LocalDate date = LocalDate.now();
    private final LocalTime time = LocalTime.now();

    String regex1 = "[0-9]+";
    String regex2 = "\\d+.\\d+";

    public MovieBuilder() {
    }
    /**
     * @return moviePlus - объект, добавляемый в коллекцию
     * @exception NumberFormatException - появляется в результате ввода значений для поля coords
     */
    public Movie newMovie () {

        Movie moviePlus = null;

        scan = new Scanner(System.in);

        String newMovieName;
        while (true) {
            System.out.println("Какое название фильма?:     ");
            String enterMovieName = scan.nextLine().trim();
            if (enterMovieName.isEmpty()) {
                System.out.println("Название не должно быть пустым, повторите ввод.");
            } else {
                newMovieName = enterMovieName;
                break;
            }
        }

        int newMovieX;
        double newMovieY;


        while (true) {
            try {
                System.out.println("Введи широту места съемок основного события [-180; 180] :    ");
                String newMovieXStr = scan.nextLine().trim();
                // coordinates
                newMovieX = Integer.parseInt(newMovieXStr);

                System.out.println("Введи долготу места съемок основного события [-180; 180] :     ");
                String newMovieYStr = scan.nextLine().trim();
                // coordinates
                newMovieY = Double.parseDouble(newMovieYStr);

                if (!(newMovieX >= -180 && newMovieX <= 180) || !(newMovieY <= 180 && newMovieY >= -180)) {
                    System.out.println("Широта и долгота вводятся в пределах [-180;180]");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Значение должно быть введено в натуральных числах");
            }
        }

        LocalDateTime dateTime = time.atDate(date);
        String time = dateTime.toString();
        System.out.println("Время создания:     " + dateTime);

        int oscarsCount;
        while (true) {
            System.out.println("Какое количество оскаров завовевал" + newMovieName + " (не меньше 1) ?");
            String enterMovieOscars = scan.nextLine().trim();
            if (!enterMovieOscars.matches(regex1)) {
                System.out.println("Введи число в натуральных числах");
            } else {
                oscarsCount = Integer.parseInt(enterMovieOscars);
                break;
            }
        }

        int goldenPalmCount;
        while (true) {
            System.out.println("Введите количество golden palm (не менее 1) :   ");
            String enterGoldenPalmCount = scan.nextLine().trim();
            if (!enterGoldenPalmCount.matches(regex1))
                System.out.println("Введите число в натуральных числах");
            else {
                goldenPalmCount = Integer.parseInt(enterGoldenPalmCount);
                break;
            }
        }

        System.out.println("Какой жанр фильма? : -- COMEDY ; ADVENTURE ; THRILLER ");
        MovieGenre newMovieGenre;
        switch (scan.nextLine()) {                                                      // Возможно улучшение с while
            case "COMEDY": {
                newMovieGenre = MovieGenre.COMEDY;
                break;
            }
            case "ADVENTURE": {
                newMovieGenre = MovieGenre.ADVENTURE;
                break;
            }
            case "THRILLER": {
                newMovieGenre = MovieGenre.THRILLER;
                break;
            }
            default: {
                System.out.println("Некорректный ввод жанра, жанр будет установлен по умолчанию");
                newMovieGenre = MovieGenre.ADVENTURE;
                break;
            }
        }

        System.out.println("Какой рейтинг фильма? : -- G ; PG ; PG_13 ; R ; NC_17 ");
        MpaaRating newMpaaRating;
        switch (scan.nextLine()) {                                                      // Возможно улучшение с while
            case "G": {
                newMpaaRating = MpaaRating.G;
                break;
            }
            case "PG": {
                newMpaaRating = MpaaRating.PG;
                break;
            }
            case "PG_13": {
                newMpaaRating = MpaaRating.PG_13;
                break;
            }
            case "NC_17": {
                newMpaaRating = MpaaRating.NC_17;
                break;
            }
            default: {
                System.out.println("Некорректный ввод возрастной категории, категория будет установлена по умолчанию");
                newMpaaRating = MpaaRating.G;
                break;
            }
        }

//------------------------------------------- Person -------------------------------------------------------------------
        String newDirectorName;
        while (true) {
            System.out.println("Введите имя директора:    ");
            newDirectorName = scan.nextLine().trim();
            if (newDirectorName.isEmpty()) {
                System.out.println("Имя не должно быть пустым, повтори ввод");
            } else {
                break;
            }
        }
        double newHeight;
        while (true) {
            System.out.println("Введите рост директора:   ");
            String newHeightString = scan.nextLine().trim();
            if (!newHeightString.matches(regex2)) {
                System.out.println("Рост должен быть введен в формате double");
            } else {
                newHeight = Double.parseDouble(newHeightString);
                break;
            }
        }

        System.out.println("Выберите цвет глаз : -- RED ; WHITE ; BROWN");
        Color newColor;
        switch (scan.nextLine()) {
            case "RED": {
                newColor = Color.RED;
                break;
            }
            case "WHITE": {
                newColor = Color.WHITE;
                break;
            }
            case "BROWN": {
                newColor = Color.BROWN;
                break;
            }
            default: {
                System.out.println("Неверный ввод цвета глаз, значение будет выбрано по умолчанию");
                newColor = Color.RED;
                break;
            }
        }

        System.out.println("Выберите национальность директора : -- UNITED_KINGDOM ; GERMANY ; ITALY");
        Country newCountry;
        switch (scan.nextLine()) {
            case "UNITED_KINGDOM": {
                newCountry = Country.UNITED_KINGDOM;
                break;
            }
            case "GERMANY": {
                newCountry = Country.GERMANY;
                break;
            }
            case "ITALY": {
                newCountry = Country.ITALY;
                break;
            }
            default: {
                System.out.println("Неверный ввод национальности, значение будет выбрано по умолчанию");
                newCountry = Country.ITALY;
                break;
            }
        }

        int newLocationX;
        int newLocationY;
        int newLocationZ;

        while (true) {
            System.out.println("Выберите широту, долготу и высоту расположения родного города продюссера. Для широты и долготы: " +
                    "[-180; 180], для высоты: [0; 2] ");

            try {
                String newDirectorXStr = scan.nextLine().trim();
                String newDirectorYStr = scan.nextLine().trim();
                String newDirectorZStr = scan.nextLine().trim();

                newLocationX = Integer.parseInt(newDirectorXStr);
                newLocationY = Integer.parseInt(newDirectorYStr);
                newLocationZ = Integer.parseInt(newDirectorZStr);

                if (!(newLocationX >= -180 && newLocationX <= 180 && newLocationY >= -180 && newLocationY <= 180
                        && newLocationZ >= 0 && newLocationZ <= 2)) {
                    System.out.println("Данные введены некорректно");
                } else {
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Нужно ввести целое число");
            }
        }
        String newDirectorHomeTown;
        System.out.println("Введите название родного города продюссера");
        newDirectorHomeTown = scan.nextLine().trim();

        Coordinates newCoords = new Coordinates(newMovieX, newMovieY);
        Location newLocation = new Location(newLocationX, newLocationY, newLocationZ, newDirectorHomeTown);
        Person newPerson = new Person(newDirectorName, newHeight, newColor, newCountry, newLocation);
        moviePlus = new Movie(newMovieName, newCoords, time, oscarsCount, goldenPalmCount, newMovieGenre,
                newMpaaRating, newPerson);
        return moviePlus;


    }
}
