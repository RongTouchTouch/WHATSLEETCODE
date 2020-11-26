/***
 * Index: 38
 * Difficulty: Easy
 * Related Topic: String
 */

public class CountandSay {
//    public String countAndSay(int n) {
//        String last = "1";
//        String result = "";
//        int index = 0;
//        int count = 1;
//        for(int i = 1; i < n; i++){
//            result = "";
//            index = 0;
//            while(index < last.length()){
//                if(index != last.length()-1 && last.charAt(index)==last.charAt(index + 1)){
//                    count++;
//                }
//                else {
//                    result += ""+ count + last.charAt(index);
//                    count = 1;
//                }
//                index++;
//            }
//            last = result;
//        }
//        return last;
//    }

    // StringBuilder改进版 以后对于长的字符串一定要用StringBuilder 能从17ms提升到2ms
    // 这里还可以做进一步提升，就是再多加一个函数，以达到自己调用自己，就不用多搞一个last了
    public String countAndSay(int n) {
        StringBuilder last = new StringBuilder("1");
        StringBuilder result = new StringBuilder();
        int index;
        int count = 1;
        for(int i = 1; i < n; i++){
            result.delete(0, result.length()); // 清空
            index = 0;
            while(index < last.length()){
                if(index != last.length()-1 && last.charAt(index)==last.charAt(index + 1)){
                    count++;
                }
                else {
                    result.append(count);
                    result.append(last.charAt(index));
                    count = 1;
                }
                index++;
            }
            last.delete(0, last.length());
            last.append(result.toString());
        }
        return last.toString();
    }

    public static void main(String[] args){
        int n = 30;
        CountandSay solution = new CountandSay();
        String result = solution.countAndSay(n);
        System.out.println(result);
    }
}
