
public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int left = (nums1.length+nums2.length+1)/2;
       int right = (nums1.length+nums2.length+2)/2;

       return (findKthNumber(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, left) +
               findKthNumber(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, right))/2.0;

    }

    public double findKthNumber(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int target){
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return findKthNumber(nums2, start2, end2, nums1, start1, end1, target);
        if (len1 == 0) return nums2[start2 + target - 1];

        if (target == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, target / 2) - 1;
        int j = start2 + Math.min(len2, target / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return findKthNumber(nums1, start1, end1, nums2, j + 1, end2, target - (j - start2 + 1));
        }
        else {
            return findKthNumber(nums1, i + 1, end1, nums2, start2, end2, target - (i - start1 + 1));
        }
    }

    public double findMedianSortedArrays2(int[] A, int[] B) {
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
        double result = solution.findMedianSortedArrays(new int[]{1,3},new int[]{2});
        System.out.print(result);
    }
}
