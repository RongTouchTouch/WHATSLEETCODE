// 以前写过一个python版本的
// 中心扩展
//
//import numpy as np
//
//        def expand(s, left, right):
//        l = left
//        r = right
//        while l >= 0 and r < len(s) and s[l]==s[r]:
//        l = l - 1
//        r = r + 1
//        return r - l - 1
//
//class Solution(object):
//        def longestPalindrome(self, s):
//        if len(s) < 1: # the input is null or ""?
//        return ""
//        largest = -1
//        start = 0
//        end = 0
//        n = len(s)
//        dp = np.zeros((n,n)) #n*n matrix
//        for i in range(n):
//        len1 = expand(s, i, i)
//        len2 = expand(s, i, i + 1)
//        len_ = len1 if len1>=len2 else len2
//        if len_ > end - start:
//        start = i - (len_ - 1) / 2
//        end = i + len_ / 2
//        return(s[start:end+1]) # get the target substring



//这个是写的最长不一定要相邻的回文子串 比如assba返回assa
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//public class Main{
//
//    public static String www(int length, String s){
//        //if ((length==null)||(length < 1));
//        //   return "";
//        int largest = -1;
//        int start = 0;
//        int end = 0;
//        int n = length;
//        int[][] dp = new int[n][n];
//        String[][] show = new String[n][n];
//        for (int i = 0;i<n;i++)
//            for(int j=0;j<n;j++)
//                show[i][j]="--";
//        for (int i=0;i<n;i++){
//            dp[i][i] = 1;
//            show[i][i] = "↗";
//        }
//        for (int j=1;j<n;j++){
//            for (int i=j-1;i>=0;i--){
//                if (s.charAt(i) == s.charAt(j)){
//                    dp[i][j] = dp[i+1][j-1]+2;
//                    show[i][j] = "↗";
//                    if( dp[i][j] > largest ){
//                        largest = dp[i][j];
//                        start = i;
//                        end = j;
//                        //System.out.print(i+" "+j);
//                    }
//                }
//                else{
//                    if (dp[i+1][j]>=dp[i][j-1])
//                    {
//                        dp[i][j] = dp[i+1][j];
//                        show[i][j]="↑";
//                    }
//                    else{
//                        dp[i][j] = dp[i][j-1];
//                        show[i][j]="→";
//                    }
//
//
//                }
//            }
//        }
////        for(int i=0;i<n;i++)
////        {
////            for(int j=0;j<n;j++)
////                System.out.print(show[i][j]+' ');
////            System.out.println();
////        }
////        System.out.println(start+ " "+ (end+1));
//        String head="";
//        String tail="";
//        String result="";
//        while(start<end)
//        {
//            if (show[start][end].equals("双击查看原图"))
//            {
//                head = head + s.charAt(start);
//                tail = s.charAt(end) + tail;
//                start++;
//                end--;
//            }
//            else if (show[start][end].equals("→"))
//            {
//                end--;
//            }
//            else if (show[start][end].equals("↑")) {
//                start++;
//            }
//        }
//        if(start == end)
//            result = head+s.charAt(start)+tail;
//        else
//            result = head+tail;
//
//        System.out.println("result:"+ result);
//
//        return(s.substring(start,end+1));
//    }
//
//    public static void main(String args[] ) throws Exception {
//        Scanner scanner=new Scanner(System.in);
//        int n=scanner.nextInt();
//        String s=scanner.next();
//        System.out.println(s);
//
//        System.out.println(www(n, s));
//
//
//    }
//}

public class LongestPalindromicSubstring{
    public String longestPalindrome(String s) {
        return "";
    }
}