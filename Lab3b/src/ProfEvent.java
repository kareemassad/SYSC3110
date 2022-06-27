import java.util.Date;
import java.util.EventObject;

public class ProfEvent extends EventObject {
    private Date midtermDate;

    public ProfEvent(Object arg0){
        super(arg0);
    }
}
