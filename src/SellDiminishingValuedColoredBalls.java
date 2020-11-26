import java.util.Arrays;
/***
 * Index: 1648
 * Difficulty: Medium
 * Related Topic: Greedy, Sort, Math
 *
 */

/***
 * 周赛的第三道，这道题真的是值得好好反思的一道题
 * 首先关于long的处理
 */
public class SellDiminishingValuedColoredBalls {
    public int maxProfit(int[] inventory, int orders) {
        long sum = 0;
        int l = inventory.length - 1;
        Arrays.sort(inventory);
//        int sub_l = 1;
        long count = 1;
        long interval;
        while(orders > 0){
            if( l >0 && orders - count * (inventory[l] - inventory[l-1]) > 0 ){
                interval = inventory[l] - inventory[l-1] ;
                orders -= interval*count;
                sum += interval * count * (inventory[l]*2-interval+1)/2;
                inventory[l] -= interval;
            }
            else if (l == 0 || (inventory[l] - inventory[l-1]) > 0 ){
                long a = orders/count;
                sum += a * count * (inventory[l]*2 - a + 1)/2;
                long b = orders%count;;
                sum += b * (inventory[l] - a);
                orders = 0;
            }
            count++;
            l--;
        }
        return (int)(sum%1000000007);
    }

    public static void main(String[] args){
        int[] inventory = {497978859,167261111,483575207,591815159};
        int orders = 836556809;
        SellDiminishingValuedColoredBalls solution = new SellDiminishingValuedColoredBalls();
        int result = solution.maxProfit(inventory, orders);
        System.out.println(result);
    }
}

//超时的代码 看起来和后来AC（time>100%）的代码没有差很多 但其实。。唉。。都不知道说什么好了
//        long sum = 0;
//        int l = inventory.length;
//        Arrays.sort(inventory);
//        inventory = reverse(inventory);
//        int sub_l = 1;
//        long interval = 0;
//        while(orders > 0){
//            if( l >=2 && sub_l <l && orders - sub_l * (inventory[sub_l - 1] - inventory[sub_l]) > 0 ){
//                interval = inventory[sub_l - 1] - inventory[sub_l] ;
//                orders -= interval*sub_l;
//                sum += interval *sub_l * (inventory[0]*2-interval+1)/2;
//                for(int i = 0; i < sub_l; i++)
//                    inventory[i] -= interval;
//                sub_l++;
//            }
//            //l == 1 || inventory 全部相等
//            else{
//                long a = orders/sub_l;
//                sum += a * sub_l * (inventory[0]*2 - a + 1)/2;
//                long b = orders%sub_l;;
//                sum += b * (inventory[0] - a);
//                orders = 0;
//            }
//        }
//        return (int)(sum%1000000007);
//    }
//
//    public int[] reverse(int[] arrays){
//        int[] r = new int[arrays.length];
//        for(int i = 0; i < arrays.length; i++)
//            r[i] = arrays[arrays.length-1-i];
//        return r;
//    }