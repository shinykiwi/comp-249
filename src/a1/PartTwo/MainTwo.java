package a1.PartTwo;

public class MainTwo {

    public static void main(String[] args) {

    }

    public static void copyTheObjects(Object[] objects){
         Object[] copy = new Object[objects.length];

        for (int i = 0; i < copy.length; i++){
            if (objects[i] != null){
                copy[i] = objects[i];
            }
        }

    }
}
