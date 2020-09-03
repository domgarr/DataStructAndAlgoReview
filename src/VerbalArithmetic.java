import java.awt.*;
import java.util.*;
import java.util.List;

public class VerbalArithmetic {
    public static int stackOrder = 0;

    public static String numerator;
    public static String denominator;
    public static String answer;

    public static void summation(int k, List<Character> s, List<Character> u , boolean findingAnswer){
        for(int i = 0 ; i < u.size(); i++){
            s.add(u.get(i));
            u.remove(i);
            if(k == 1){

                if(findingAnswer) {

                    String num = VerbalArithmetic.numerator;
                    String den = VerbalArithmetic.denominator;
                    String ans = VerbalArithmetic.answer;

                    for (int cInd = 0; cInd < s.size(); cInd++) {
                        Character c = s.get(cInd);
                        Character digit = Character.forDigit(cInd, 10);

                        num = num.replace(c, digit);
                        den = den.replace(c, digit);
                        ans = ans.replace(c, digit);
                    }

                    Integer numI = Integer.valueOf(num);
                    Integer denI = Integer.valueOf(den);
                    Integer ansI = Integer.valueOf(ans);

                    int sum = numI + denI;

                    int base = 10;
                    //Minus one because One's is 10^0
                    int power = VerbalArithmetic.answer.length() - 1;

                    if (sum >= Math.pow(base, power)) {
                        if (numI + denI == ansI) {

                            System.out.print(stackOrder++ + ": S: ");
                            for (Character c : s) {
                                System.out.print(c);
                            }
                            System.out.println();


                            System.out.println(numI);
                            System.out.println(denI);
                            System.out.println(ansI);
                            System.out.println("=======");
                        }
                    }
                }else{
                    System.out.print(stackOrder++ + ": S: ");
                    for(Character c : s){
                        System.out.print(c);
                    }
                    System.out.println();
                }


            }else{

                summation(k - 1, s, u, findingAnswer);
            }


            Character c1 = s.remove(s.size() - 1);
            u.add(i, c1);
        }
    }

    public static void sum(String numerator, String denominator, String answer){
        VerbalArithmetic.numerator = numerator;
        VerbalArithmetic.denominator = denominator;
        VerbalArithmetic.answer = answer;

        StringBuilder sb = new StringBuilder();
        sb.append(numerator).append(denominator).append(answer);

        Set<Character> uniqueChars = new HashSet<>();
        String appendedString = sb.toString();
        for(int i = 0; i < appendedString.length(); i++){
            uniqueChars.add(appendedString.charAt(i));
        }

        List<Character> u = new ArrayList<>(uniqueChars);
        while(u.size() < 10){
            u.add('*'); //Add filler
        }
        List<String> strings = new ArrayList<>();
        strings.add(numerator);
        strings.add(denominator);
        strings.add(answer);

        ArrayList<Character> u1 = new ArrayList<>();
        u1.add('A');
        u1.add('B');
        u1.add('C');

        //summation(u.size(), new ArrayList<Character>(), u, true);
        summation(2, new ArrayList<Character>(), u1, false);
    }

    public static void equal(){

    }
}
