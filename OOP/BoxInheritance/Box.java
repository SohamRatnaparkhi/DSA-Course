package OOP.BoxInheritance;

public class Box {
    int h, l, b, weight;
    Box (){
        h = 0;
        l = 0;
        b = 0;
        weight = 0;
    }

    Box(int h, int l, int b, int weight){
        this.h = h;
        this.l = l;
        this.b = b;
        this.weight = weight;
    }

    Box(int h, int l, int b){
        this.h = h;
        this.l = l;
        this.b = b;
        this.weight = 10;
    }

}
