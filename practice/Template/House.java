package Template;

/**
 * abstract class House containing template method buildHouse and implementation
 * of steps which is same for all types of houses. Those implementations have
 * been marked as final.
 */

public abstract class House {
    // Create template method. Notice it is final as we don't want other classes
    // re-implementing it.

    public final void buildHouse() {
        constructFoundation();
        constructRoof();
        constructWalls();
        constructWindows();
        paintHouse();
        decorateHouse();
        System.out.println("House is built.");
    }

    public abstract void constructWalls();

    public abstract void constructWindows();

    public abstract void decorateHouse();

    public abstract void paintHouse();

    // Now implement classes that apply to all houses. Notice that these are final.

    private final void constructFoundation() {
        System.out.println("Foundation is constructed.");
    }

    private final void constructRoof() {
        System.out.println("Roof is constructed.");
    }

}
