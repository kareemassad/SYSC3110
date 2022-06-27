package Composite;

import java.util.ArrayList;
import java.util.List;

public abstract class Component {
    AccountStatement accStatement;

    protected List<Component> list = new ArrayList<Component>();

    public abstract float getBalance();

    public abstract AccountStatement getStatement();

    public void add(Component component) {
        list.add(component);
    }

    public void remove(Component component) {
        list.remove(component);
    }

    public Component getChild(int i) {
        return (Component) list.get(i);
    }

}
