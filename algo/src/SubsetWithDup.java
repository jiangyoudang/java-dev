import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SubsetWithDup {

  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);

    List<List<Integer>> ans = new ArrayList<>();
    ans.add(new ArrayList<>());
    List<List<Integer>> pre = ans;

    for (int k = 0; k < nums.length; k++) {
      List<List<Integer>> currLevel = new ArrayList<>();
      if (k == 0 || nums[k] != nums[k - 1]) {
        pre = ans;
      }
      for (List<Integer> aPre : pre) {
        List<Integer> copy = new ArrayList<>(aPre);
        copy.add(nums[k]);
        currLevel.add(copy);
      }
      pre = currLevel;
      ans.addAll(pre);
    }

    return ans;
  }


  public static void main(String[] args) {
    int[] nums = {1, 2, 2, 2};
    System.out.println(new SubsetWithDup().subsetsWithDup(nums));
  }
}