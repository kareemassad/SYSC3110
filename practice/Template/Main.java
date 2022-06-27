package Template;

public class Main {
    public static void main(String[] args) {
        System.out.println("Building Glass Wall House");
        House glassHouse = new GlassWallHouse();
        glassHouse.buildHouse();

        System.out.println("Glass Wall House constructed successfully");

        System.out.println("************************");

        System.out.println("Building Concrete Wall House");
        House concreteHouse = new GlassWallHouse();
        concreteHouse.buildHouse();

        System.out.println("Concrete Wall House constructed successfully");
    }
}
