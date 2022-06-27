package Strategy;

//twitter strategy
public class Strategy3 implements SocialMediaStrategyInterface {
    public void connectTo(String friendName) {
        System.out.println("Connecting to " + friendName + " via Twitter");
    }

}
