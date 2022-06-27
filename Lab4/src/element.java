import java.util.ArrayList;

public abstract class element {
    private static String tag;

    /*children of this element*/
    private ArrayList<element> children;

    public element(String name){
        this.tag = tag;
        this.children = new ArrayList<element>();
    }

    public void add (element elem){
        this.children.add(elem);
    }
    public String getTag() {
        return tag;
    }
    public ArrayList<element> getChildren() {
        return this.children;
    }

    static void print() {
        System.out.println(tag);
    }
}
