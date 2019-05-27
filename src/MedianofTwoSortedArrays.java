
public class MedianofTwoSortedArrays {
    // 好的我又做不出来。。
    public double findMedianSortedArraysError(int[] nums1, int[] nums2) {
        int total_length = (nums1.length+nums2.length-1)/2;
        if (nums1.length>nums2.length && nums1[0]>nums2[nums2.length-1])
            return nums1[total_length-1];
        if ((nums1.length<nums2.length && nums2[0]>nums1[nums1.length-1]))
            return nums2[total_length-1];
        int index1 = 0, index2 = 0;
        int step1 = (nums1.length-index1-1)/2;
        int step2 = (nums2.length-index2-1)/2;
        while(total_length!=0){
            if(nums1[index1+step1]>nums2[index2+step2]){
                step2 = (nums2.length-index2-1)!=1?(nums2.length-index2-1)/2:1;
                System.out.println("step2 "+step2);
                index2 += step2;
                total_length -=step2;
            }
            else if (nums1[index1+step1]<nums2[index2+step2]){
                step1 = (nums1.length-index1-1)!=1?(nums1.length-index1-1)/2:1;
                System.out.println("step1 "+step1);
                index1 += step1;
                total_length -=step1;
            }
            else
                return nums1[index1];
            System.out.println(index1 + " " + index2);
            System.out.println(total_length);
        }
        System.out.println(Math.max(nums1[index1-1],nums2[index2]-1) + " " + Math.min(nums1[index1],nums2[index2]));

        if((nums1.length+nums2.length)%2==1)
            return Math.min(nums1[index1],nums2[index2]);
        else
            return (Math.max(nums1[index1-1],nums2[index2-1])+Math.min(nums1[index1],nums2[index2]))/2.0;

    }

    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        if (m > n) { // to ensure m<=n
            int[] temp = A; A = B; B = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && B[j-1] > A[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] agrv) {
        MedianofTwoSortedArrays solution = new MedianofTwoSortedArrays();
        double result = solution.findMedianSortedArrays(new int[]{1,2},new int[]{3});
        System.out.print(result);
    }
}
