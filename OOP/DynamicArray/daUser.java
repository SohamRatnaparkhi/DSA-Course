package OOP.DynamicArray;

public class daUser {
    public static void main(String[] args) {
        // dynamicArray da = new dynamicArray();
        // dynamicArray da2 = new dynamicArray();
        dynamicArray da3 = new dynamicArray();

        // da.add(7);
        // da.add(7);
        // da.add(7);
        // da.add(7);
        // da.add(7);
        // da.add(7);
        // da.add(7);
        // da.print();

        // da2.add(10);
        // da2.add(10);
        // da2.add(10);
        // da2.add(10);
        // da2.add(10);
        // da2.add(10);
        // da2.add(10);
        // da2.print();

        for(int i = 0; i < 50; i++){
            da3.add(i);
        }

        da3.print();
        System.out.println(da3.length);
        
        da3.pop(7);
        da3.print();
        System.out.println(da3.length);

        da3.pop();
        da3.print();
        System.out.println(da3.length);
        

        System.out.println(da3.get(10));

        da3.set(10, -1);
        da3.print();
        System.out.println(da3.length);
    }
}
