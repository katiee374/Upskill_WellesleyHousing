
public class WellesleySorting {
    private GenericTree<String> tree;
    private String n1 = "Which dorm would you like to live in?" + 
        "\nPick one: Caz, Beebe, Munger, Pom, Shafer, Stone D, " +
        "McAfee, Bates, Sev, Claf, Tower Court, Lake House, or Freeman.";
    private String n2 = "What type of dorm room would you like to live?" + 
        "\nPick one: single, double, triple.";
    private String n3 = "Here's your options!";
    private String n4 = "Uh oh spaghetti oh, that's an invalid input";
    private final String[] buildings = {"Caz", "Beebe", "Munger", "Pom", "Shafer", "Stone D", "McAfee", "Bates", "Sev", "Claf", "Tower Court", "Lake House", "Freeman"};

    public WellesleySorting(){
        tree = new GenericTree<String>();
        GenericTreeNode<String> root = new GenericTreeNode<String>(n1);
        root.setChildren()
    }

    public void doSorting() {

    }
}
