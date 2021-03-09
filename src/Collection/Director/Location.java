package Collection.Director;

public class Location {
    private final Integer x; // Поле не может быть null
    private final Integer y; // Поле не может быть null
    private final Integer z; // Поле не может быть null
    private final String name; // Строка не может быть пустой, Поле может быть null

    public Location(Integer x, Integer y, Integer z, String name) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }


    public Integer getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }

    public Integer getZ() {
        return z;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                ", name='" + name + '\'' +
                '}';
    }
}
