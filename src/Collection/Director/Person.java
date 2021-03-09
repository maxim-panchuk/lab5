package Collection.Director;

public class Person {
    /**
     * private final String name - Поле не может быть null, Строка не может быть пустой
     * private final double height - Значение поля должно быть больше 0
     * private final Color eyeColor - Поле может быть null
     * private final Country nationality - Поле может быть null
     * private final Location location - Поле не может быть null
     */
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final double height; //Значение поля должно быть больше 0
    private final Color eyeColor; //Поле может быть null
    private final Country nationality; //Поле может быть null
    private final Location location; //Поле не может быть null

    /**
     *
     * @param name - Имя директора
     * @param height - Рост директора
     * @param eyeColor - цвет глаз директора
     * @param nationality - нацилнальность директора
     * @param location -  место
     */

    public Person(String name, double height, Color eyeColor, Country nationality, Location location) {
        this.name = name;
        this.height = height;
        this.eyeColor = eyeColor;
        this.nationality = nationality;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public Color getEyeColor() {
        return eyeColor;
    }

    public Country getNationality() {
        return nationality;
    }

    public Location getLocation() {
        return location;
    }

    /**
     *
     * @return - Возврат объекта типа Person, преобразованного к строке
     */
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", eyeColor=" + eyeColor +
                ", nationality=" + nationality +
                ", location=" + location +
                '}';
    }
}
