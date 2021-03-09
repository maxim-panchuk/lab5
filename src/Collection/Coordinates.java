package Collection;

public class Coordinates {
    private final int newMovieX;
    private final Double newMovieY;
    public Coordinates(int newMovieX, Double newMovieY) {
        this.newMovieX = newMovieX;
        this.newMovieY = newMovieY;
    }

    public int getNewMovieX() {
        return newMovieX;
    }
    public Double getNewMovieY() {
        return newMovieY;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "newMovieX=" + newMovieX +
                ", newMovieY=" + newMovieY +
                '}';
    }
}
