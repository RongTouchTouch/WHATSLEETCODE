public class ZigZagConversion {
    public String convert(String s, int numRows) {
        char[] characters = s.toCharArray();
        String result = "";

        for (int i = 0, j = i, index = 0, flag = 1; i < numRows; i++, flag = 1){
            j=i;
            while(j<characters.length){
                System.out.println(i+" "+j);
                result += characters[j];
                index++;
                if(i==0||(i == (numRows-1))){
                    j += 2*(numRows-1);
                }
                else{
                    if (flag==1){
                        j += 2*(numRows-i-1);
                        flag--;
                    }
                    else{
                        j+=2*i;
                        flag++;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String agrv[]){
        ZigZagConversion solution = new ZigZagConversion();
        String result = solution.convert("PAYPALISHIRING",2);
        System.out.print(result);
    }
}
