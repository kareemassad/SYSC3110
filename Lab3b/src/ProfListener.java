import java.util.EventListener;

public interface ProfListener extends EventListener {
    public void midtermAnnounced(ProfEvent e);
    public void midtermPostponed(ProfEvent e);
}
