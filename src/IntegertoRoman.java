/***
 * Index: 12
 * Difficulty: Medium
 * Related Topic: Math, String
 */

/***
 * 解法一：（正确）
 */

public class IntegertoRoman {
    public String intToRoman(int num) {
        String result = "";
        String sTemp = String.valueOf(num);
        char[] digits = sTemp.toCharArray();
        System.out.println(digits);
        String[] order = {"I", "V", "X", "L", "C", "D", "M"};
        int j = 0;
        for(int i = digits.length-1; i >= 0 ;i-- ){
            if ( digits[i] - '0' <= 3 ){
                for(int k = 0; k < digits[i] - '0'; k++)
                    result = order[j] + result;
            }
            else if ( digits[i] - '0' == 4 )
                result = order[j] + order[j+1] + result;
            else if ( digits[i] - '0' <= 8) {
                String temp = "";
                for(int k = 0; k < digits[i] - '5'; k++)
                    temp += order[j];
                result  = order[j + 1] + temp + result;
            }
            else
                result = order[j] + order[j+2] + result;
            j+=2;
        }
        return result;
    }

    public static void main(String[] argv){
        int num = 1995;
        IntegertoRoman solution = new IntegertoRoman();
        String result = solution.intToRoman(num);
        System.out.println(result);
    }
}

/***
 * 解法二：暴力
 * 挺牛的，其实我之前就在想为什么我的时间落后于90%的人，原来是这样。。。
 */
//public String intToRoman(int num) {
//    String M[] = {"", "M", "MM", "MMM"};//0,1000,2000,3000
//    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};//0,100,200,300...
//    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};//0,10,20,30...
//    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};//0,1,2,3...
//    return M[num/1000] + C[(num%1000)/100]+ X[(num%100)/10] + I[num%10];
//}