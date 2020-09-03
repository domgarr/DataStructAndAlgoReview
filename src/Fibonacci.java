public class Fibonacci {
    public static long[] efficientFiboncci(int index){
        if(index <= 1){
            return new long[]{index,1};
        }else{
            long[] temp = efficientFiboncci(index - 1);
            long[] answer = {temp[0] + temp[1], temp[0]};
            return answer;
        }
    }
}
