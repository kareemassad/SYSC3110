package Observer;

public class Main {
    public static void main(String[] args) {
        MessageSubscriberOne s1 = new MessageSubscriberOne();
        MessageSubscriberTwo s2 = new MessageSubscriberTwo();
        MessageSubscriberThree s3 = new MessageSubscriberThree();

        MessagePublisher p = new MessagePublisher();

        p.attach(s1);
        p.attach(s2);

        // only S1 and S2 should be notified of msg
        p.notifyUpdate(new Message("First message"));

        p.detach(s2);
        p.attach(s3);

        // only S1 and S3 should be notified of msg
        p.notifyUpdate(new Message("Second message"));
    }
}
