package Template;

public class ConcreteWallHouse extends House {

    @Override
    public void constructWalls() {
        System.out.println("Concrete walls are constructed.");
    }

    @Override
    public void constructWindows() {
        System.out.println("Constructing windows for Concrete Wall House.");
    }

    @Override
    public void decorateHouse() {
        System.out.println("Concrete house is decorated.");
    }

    @Override
    public void paintHouse() {
        System.out.println("Concrete house is painted.");
    }

}
