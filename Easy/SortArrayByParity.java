public class SortArrayByParity {

    //1st Approach - read the even elements first followed by the odd elements
    private static int[] sortArrayByParity(int[] a ) {
        int n = a.length;
        int[] result = new int[n];
        int j=0;
        for (int i=0;i<n&&j<n;i++) {
            if (a[i]%2==0) {
                result[j]=a[i];
                j++;
            }
        }
        for (int i=0;i<n&&j<n;i++) {
            if (a[i]%2==1) {
                result[j]=a[i];
                j++;
            }
        }
        return result;
    }

    //2nd Approach - in-place sort, quicksort
    private static int[] sortArrayByParity1(int[] a ) {
        int n = a.length;
        int i=0, j=n-1;
        while (i<j) {
            if (a[i]%2>a[j]%2) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            if (a[i]%2==0) {
                i++;
            }
            if (a[j]%2==1) {
                j--;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int[] a = {3,1,2,4};
        int[] res = sortArrayByParity1(a);
        for (int i=0;i<a.length;i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
