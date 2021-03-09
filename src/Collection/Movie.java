package Collection;

import Collection.Director.Person;

import java.time.LocalDateTime;

public class Movie implements Comparable<Movie>{

    /**
     * private Integer id - Поле не может быть null, Значение поля должно быть больше 0,
     * Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
     * private final String name - Поле не может быть null, Строка не может быть пустой
     * private final Coordinates coordinates - Поле не может быть null
     * private final int oscarsCount - Значение поля должно быть больше 0
     * private final MovieGenre genre - Поле может быть null
     * private final MpaaRating mpaaRating - Поле не может быть null
     * private final Person director - Поле не может быть null
     * private final String time - Время создания объекта
     */

    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final int oscarsCount; //Значение поля должно быть больше 0
    private final int goldenPalmCount; //Значение поля должно быть больше 0
    private final MovieGenre genre; //Поле может быть null
    private final MpaaRating mpaaRating; //Поле не может быть null
    private final Person director; //Поле не может быть null
    private final String time;

    /**
     *
     * @param name - Название фильма
     * @param coordinates - Координаты места съемки
     * @param time - Время создание фильма
     * @param oscarsCount - Количество завоеванных оскаров
     * @param goldenPalmCount - Количество заслуженных goldenPalms
     * @param genre - Жанр фильма
     * @param mpaaRating - Возрастное ограничение на фильм
     * @param director - Объект типа Person
     */
    public Movie(String name, Coordinates coordinates, String time,
                 int oscarsCount, int goldenPalmCount, MovieGenre genre, MpaaRating mpaaRating, Person director) {
        this.id = Math.toIntExact((java.util.UUID.randomUUID().getMostSignificantBits() & Integer.MAX_VALUE));
        this.name = name;
        this.coordinates = coordinates;
        //private final java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
        this.oscarsCount = oscarsCount;
        this.goldenPalmCount = goldenPalmCount;
        this.genre = genre;
        this.mpaaRating = mpaaRating;
        this.director = director;
        this.time = time;
    }

    /**
     *
     * @return id - Возвращает значение id фильма
     */

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @return name - Возвращает название фильма
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return coordinates - Возврат координат
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }
    public String getTime() {
        return time;
    }

    public int getOscarsCount() {
        return oscarsCount;
    }

    public int getGoldenPalmCount() {
        return goldenPalmCount;
    }

    public MovieGenre getGenre() {
        return genre;
    }

    public MpaaRating getMpaaRating() {
        return mpaaRating;
    }

    public Person getDirector() {
        return director;
    }

    @Override
    public int compareTo(Movie p) {
        return this.id - p.id;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", oscarsCount=" + oscarsCount +
                ", goldenPalmCount=" + goldenPalmCount +
                ", genre=" + genre +
                ", mpaaRating=" + mpaaRating +
                ", director=" + director +
                ", time='" + time + '\'' +
                '}';
    }
}
