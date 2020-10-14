package JavaProjects;
@SuppressWarnings("unchecked")
public class ClassTest {
    public static void main(String[] args) {
        
        DynamicArray a1 = new DynamicArray(5);
        // test
        String cap = Integer.toString(a1.getCapacity());

        System.out.println(cap);

        System.out.println(Integer.toString(a1.getSize()));

        for(int i = 0; i<7;i++)a1.add(i);
        System.out.println(a1.toString());


        
        
    }
}
