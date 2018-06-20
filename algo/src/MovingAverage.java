
import java.util.ArrayList;

public class MovingAverage {
    private int[] data;
    private int i, length;
    private int total;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        data = new int[size];
        i = 0;
        total = 0;
    }

    public double next(int val) {
        if(length < data.length)
            length++;
        total -= data[i];
        data[i] = val;
        i = ++i % data.length;
        total += val;
        return (double)total/length;
    }


    public static void main(String[] args) {


    }

    public int[] arrayReturn(){
        ArrayList<Integer> array = new ArrayList<>();
        array.add(3);
        array.add(1);
        int[] ans = new int[array.size()];
        for (int i=0; i < array.size(); i++) {
            ans[i] = array.get(i);
        }
        return ans;
    }

}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */