package Strategy;

//FB strategy
public class Strategy1 implements SocialMediaStrategyInterface {
    public void connectTo(String friendName) {
        System.out.println("Connecting to " + friendName + " via Facebook");
    }
}
