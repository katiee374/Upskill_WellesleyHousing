import java.util.*;
public class WellesleySorting {
    private GenericTree<String> tree;
    
    private final String[] buildings = {"Caz", "Beebe", "Munger", "Pom", "Shafer", "Stone D", "McAfee", "Bates", "Sev", "Claf", "Tower Court", "Lake House", "Freeman"};

    public WellesleySorting(){
        tree = new GenericTree<String>();
        GenericTreeNode<String> root = new GenericTreeNode<String>(n1);
        ArrayList<GenericTreeNode<String>> children = new ArrayList<GenericTreeNode<String>>();
        for (String s: buildings) {
            children.add(new GenericTreeNode<String>(s));
        }
        root.setChildren(children);
        System.out.println(tree);
    }
    public static void main(String[] args) {
        //for testing
        System.out.println(new WellesleySorting());
    }

    public void doSorting() {

    }
}
