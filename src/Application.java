import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        String pattern ="({[])}";

        boolean answer = MatchingDelimeter.match(pattern);
        System.out.println(answer);

    }


}
