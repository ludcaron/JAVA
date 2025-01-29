package JAVA;
import java.util.List;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);

        for (Integer item : list) {
            System.out.println("Id = " + item);
        }
    }
}