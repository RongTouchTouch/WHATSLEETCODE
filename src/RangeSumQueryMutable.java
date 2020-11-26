/***
 * Index: 307
 * Difficulty: Medium
 * Related Topic: Binary Indexed Tree, Segment Tree
 */

/***
 * 很经典的适合用BIT来实现的题。NumArray2会比NumArray快一杯，主要是因为NumArray每次update都要做两次query，
 * 不过NumArray只有一个update。各有利弊。
 */
public class RangeSumQueryMutable {
    public static void main(String[] args) {
        int[] nums = {1,2,3,5,5};
        NumArray numArray = new NumArray(nums);
        numArray.update(1,8);
        numArray.update(2,8);
    }
}

class NumArray {
    private final int[] bit;

    public NumArray(int[] nums) {
        bit = new int[nums.length+1];
        bit[0] = 0;
        for(int i = 0; i < nums.length; i++)
            update(i,nums[i]);
    }

    public void update(int i, int val) {
        int interval = val-query(i)+query(i-1);
        i++;
        for(; i < bit.length; i += i&-i)
            bit[i] += interval;
    }

    public int query(int i){
        i++;
        int res = 0;
        for( ; i > 0; i -= i&-i)
            res += bit[i];
        return res;
    }

    public int sumRange(int i, int j) {
        return query(j) - query(i-1);
    }
}

class NumArray2 {
    private final int[] bit;

    public NumArray2(int[] nums) {
        bit = new int[nums.length+1];
        bit[0] = 0;
        for(int i = 0; i < nums.length; i++)
            update2(i,nums[i]);
    }

    public void update2(int i, int val) {
        i++;
        for(; i < bit.length; i += i&-i)
            bit[i] += val;
    }

    public void update(int i, int val) {
        int interval = val-query(i)+query(i-1);
        i++;
        for(; i < bit.length; i += i&-i)
            bit[i] += interval;
    }

    public int query(int i){
        i++;
        int res = 0;
        for( ; i > 0; i -= i&-i)
            res += bit[i];
        return res;
    }

    public int sumRange(int i, int j) {
        return query(j) - query(i-1);
    }
}