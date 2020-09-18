import java.util.Arrays;
import java.util.Scanner;


public class AllSort {

    public static void Arrange(int arr[],int st,int ed){
        if(st==ed)
            System.out.println(Arrays.toString(arr));
        else{
            for(int i=st;i<=ed;i++){
                Swap(arr,st,i);
                Arrange(arr,st+1,ed);
                Swap(arr,i,st);
            }
        }
    }

    public static void Swap(int arr[],int i,int j){
        if(i==j)
            return;
        else{
            int temp=arr[j];
            arr[j]=arr[i];
            arr[i]=temp;
        }
    }

    public static void main(String[] args) {
        int array[] = {1,2,3,4};
        Arrange(array,0,array.length-1);
    }
}