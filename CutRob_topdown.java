public class CutRob_topdown {
    public static int[] prices = {1,5,8,9,10,17,17,20,24,30};
    public static int solution(int length ){
        int[] memo = new int[length+1];
        for (int i=0; i<memo.length; i++) {
            memo[i] = Integer.MIN_VALUE;
        }
        return cutrob_aux(length, memo);
    }
    public static int cutrob_aux (int length, int[] memo) {
        if (memo[length] >= 0) {
            return memo[length];
        }
        if (length == 0) {
            return 0;
        }
        else {
            for (int i=1; i<=length; i++) {
                memo[length] = Math.max(memo[length], prices[i-1]+cutrob_aux(length-i, memo));
            }
        }
        return memo[length];
    }
    public static void main(String[] args) {
        for(int i=1; i<= prices.length; i++)
            System.out.println("length:"+i+", profit: "+solution(i));
    }
}