import Algorithms.JosephusProblem;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args){

        String[] names = new String[]{"Bob", "Amy", "Lee"};
        String winner = JosephusProblem.solve(names, 2);
        System.out.println(winner);
        

    }


}
