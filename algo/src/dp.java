import java.util.Arrays;

public class dp{
  public int coinChange(int[] coins, int amount) {
      int[] dp = new int[amount+1];
      int num = 0;
      for (int i=1; i <= amount; i ++) {
        int min = Integer.MAX_VALUE;
        for(int coin: coins) {
          if(i -coin >= 0 && dp[i-coin] != -1 && min > dp[i-coin]){
            min = dp[i-coin];
          }

        }
        if (min == Integer.MAX_VALUE) {
          dp[i] = -1;
        }else {
          dp[i] = min + 1;
        }
      }

      return dp[amount];

    }


  public static void main(String[] args) {

//    dp test= new dp();
//    int res = test.coinChange(new int[]{1,2,5}, 6);
//    System.out.println(res);

    int [][] dp = new int[2][3];
    System.out.println(dp.length);
    for (int [] a: dp){
      System.out.println(Arrays.toString(a));
    }

  }

}
