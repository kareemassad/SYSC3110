package Strategy;

//google+ strategy
public class Strategy2 implements SocialMediaStrategyInterface {
    public void connectTo(String friendName) {
        System.out.println("Connecting to " + friendName + " via Google+");
    }
}
