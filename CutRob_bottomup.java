public class CutRob_bottomup {
    public static int[] prices = {1,5,8,9,10,17,17,20,24,30};
    public static int solution(int length){
        int[] memo = new int[length+1];
        memo[0] = 0;
        for (int j=1; j<=length; j++) {
            int max = Integer.MIN_VALUE;
            for(int i=1; i<=j; i++) {
                max= Math.max(max, prices[i-1]+ memo[j-i]);
            }
            memo[j] = max;
        }
        return memo[length];
    }

    public static void main(String[] args) {
        for(int i=1; i<= prices.length; i++)
            System.out.println("length:"+i+", profit: "+solution(i));
    }
}