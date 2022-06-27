package Template;

public class GlassWallHouse extends House {

    @Override
    public void constructWalls() {
        System.out.println("Glass walls are constructed.");
    }

    @Override
    public void constructWindows() {
        System.out.println("Constructing windows for Glass Wall House.");
    }

    @Override
    public void decorateHouse() {
        System.out.println("Glass house is decorated.");
    }

    @Override
    public void paintHouse() {
        System.out.println("Glass house is painted.");
    }

}
