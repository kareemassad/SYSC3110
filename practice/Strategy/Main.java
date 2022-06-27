package Strategy;

public class Main {
    public static void main(String[] args) {
        SocialMediaContext context = new SocialMediaContext();

        // Setting Strategy 1 as default (FB)
        context.setSocialMediaStrategy(new Strategy1());
        context.connect("Kareem");

        System.out.println("====================");

        // Setting Strategy 2 as default (G+)
        context.setSocialMediaStrategy(new Strategy2());
        context.connect("Kareem");

        System.out.println("====================");

        // Setting Strategy 3 as default (Twitter)
        context.setSocialMediaStrategy(new Strategy3());
        context.connect("Kareem");

        System.out.println("====================");

    }
}
