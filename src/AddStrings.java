import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

/***
 * Index: 415
 * Difficulty: Easy
 * Related Topic: String
 */

/***
 * 解法一：List/Vector（正确）
 *
 * 速度是倒数95%倒是我没想到的。。
 * 对比了速度是1ms的代码
 *
 */

public class AddStrings {
//    //48s
//    public String addStrings1(String num1, String num2) {
//        List<Integer> vector = new LinkedList<>();
//        char[] chars_1 = num1.toCharArray();
//        char[] chars_2 = num2.toCharArray();
//        int i = 0;
//        int length1 = chars_1.length;
//        int length2 = chars_2.length;
//        int flag = 0, num;
//        while(length1 - 1 - i >= 0 || length2 - 1 - i >= 0) {
//            int val1 = length1 >= i + 1 ? chars_1[length1 - 1 - i] - '0' : 0;
//            int val2 = length2 >= i + 1 ? chars_2[length2 - 1 - i] - '0' : 0;
//            num = val1 + val2 + flag;
//            vector.add(num % 10);
//            flag = num / 10;
//            i++;
//        }
//        if(flag!=0)
//            vector.add(1);
//        String result = "";
//        for(i = vector.size() - 1; i >= 0; i--)
//            result += vector.get(i);
//        return result;
//    }

//    //46 ms 调整了length1和length2
//    public String addStrings(String num1, String num2) {
//        List<Integer> vector = new LinkedList<>();
//        int i = 0;
//        int length1 = num1.length()-1;
//        int length2 = num2.length()-1;
//        int flag = 0, num;
//        while(length1 >=i || length2 >= i) {
//            int val1 = length1 >= i ? num1.charAt(length1-i) - '0' : 0;
//            int val2 = length2 >= i ? num2.charAt(length2-i) - '0' : 0;
//            num = val1 + val2 + flag;
//            vector.add(num % 10);
//            flag = num / 10;
//            i++;
//        }
//        if(flag!=0)
//            vector.add(1);
//        String result = "";
//        for(i = vector.size() - 1; i >= 0; i--)
//            result += vector.get(i);
//        return result;
//    }

    //1ms 牛啊StringBuilder 以后返回类型是String的话感觉可以优先考虑使用StringBuilder
    public String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int length1 = num1.length()-1;
        int length2 = num2.length()-1;
        int flag = 0, num;
        while(length1 >=i || length2 >= i) {
            int val1 = length1 >= i ? num1.charAt(length1-i) - '0' : 0;
            int val2 = length2 >= i ? num2.charAt(length2-i) - '0' : 0;
            num = val1 + val2 + flag;
            stringBuilder.append(num % 10);
            flag = num / 10;
            i++;
        }
        if(flag!=0)
            stringBuilder.append(1);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static void main(String args[]){
        String num1 = "0";
        String num2 = "1";
        AddStrings solution = new AddStrings();
        String result = solution.addStrings(num1, num2);
        System.out.println(result);
    }
}

//    public String addStrings(String num1, String num2) {
//        StringBuilder sb = new StringBuilder();
//        int carry = 0;
//        int p1 = num1.length() - 1;
//        int p2 = num2.length() - 1;
//        while (p1 >= 0 || p2 >= 0) {
//            int x1 = p1 >= 0 ? num1.charAt(p1) - '0' : 0;
//            int x2 = p2 >= 0 ? num2.charAt(p2) - '0' : 0;
//            int sum = (x1 + x2 + carry) % 10;
//            carry = (x1 + x2 + carry) / 10;
//            sb.append(sum);
//            p1--;
//            p2--;
//        }
//        if (carry!=0) {
//            sb.append(carry);
//        }
//        return sb.reverse().toString();
//    }