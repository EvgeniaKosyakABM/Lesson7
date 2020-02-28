package test.java.tests;

import java.util.ArrayList;
import java.util.List;

public class DelMe {
    public static void main(String[]args) {
        for(int i =0; i<10; i++){
            List<String> list = new ArrayList<String>();
            list.add(0,"0");
            list.add(1,"A");
            list.add(2,"B");
            list.add(3,"C");
            System.out.println();
            int rand = (int)(Math.random()*(list.size()));
            System.out.println(list.get(rand));

        }
    }
}
