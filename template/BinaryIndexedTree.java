public class BinaryIndexedTree {

    public int[] bit;

    public BinaryIndexedTree(int n){
        bit = new int[n + 1];
//        bit[0] = 0;
    }

    /***
     * lowbit(n) = n & (~n + 1) = n & -n
     * 为非负整数n在二进制表示下"最低位的1及其后边所有的0"构成的数值
     */
    public int lowbit(int x){
        return x&-x;
    }

    /***
     * 计算区间
     * 假设非负整数n可以被表示为 n = 2^i1 + 2^i2 + 2^i3 ...，其中i1>i2>i3...
     * 那么可以将区间[1,n]划分为log(n)个小区间，即
     * [1,2^i1],[2^i1+1,2^i1+2^i2],[2^i1+2^i2+1,2^i1+2^i2+2^i3]...
     */
    public int[] computerRange(int x){
        // x -= lowbit(x);
        return new int[]{x-lowbit(x)+1, x};
    }

    /***
     * 查询前缀和
     * 从数组第一个位置到第idx（含idx）个位置所有数字的和。
     * 在寻求序列A的前n项的前缀和时，等于n代表的log(n)个区间的总和。
     */
    public int query(int x){
        int ans = 0;
        for(; x > 0; x -= x & -x)
            ans +=bit[x];
        return ans;
    }

    /***
     * 单点增加
     * 将num加到位置idx的数字上。
     * 观察父子节点的关系，可以推算出，父节点的索引parent(i)，为其子节点索引值 + 其低位 —— parent(n)=i+lowbit(i) .
     */
    public void update(int x, int delta){
        for(; x < bit.length ; x += x & -x)
            bit[x] += delta;
    }
}
