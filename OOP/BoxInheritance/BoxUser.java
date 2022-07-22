package OOP.BoxInheritance;

public class BoxUser extends Box{
    int weight;
    BoxUser (int weight) {
        this.weight = weight;
    }

    BoxUser (int h, int l, int b, int weight) {
        super(h, l, b);
        this.weight = weight;
    }
    public static void main(String[] args) {
        BoxUser box = new BoxUser(5);
        System.out.println(box.weight);

        BoxUser box2 = new BoxUser(5, 5, 5, 20);
        System.out.println(box2.weight);
        box2.setWeight(25);
        System.out.println(box2.weight);
    }

    public void setWeight(int weight) {
        this.weight = super.weight;
    }

}
