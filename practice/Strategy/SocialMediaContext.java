package Strategy;

public class SocialMediaContext {
    SocialMediaStrategyInterface smStrategy;

    public void setSocialMediaStrategy(SocialMediaStrategyInterface smStrategy) {
        this.smStrategy = smStrategy;
    }

    public void connect(String name) {
        smStrategy.connectTo(name);
    }
}
