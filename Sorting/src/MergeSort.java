
public class MergeSort {

    public static void main(String[] args) {
        int[] u = {2,9,16,1,3,9,32};
        MergeSort m = new MergeSort();
        m.mergesort(u,0,u.length-1);
        for (int i = 0; i < u.length; i++) {
            System.out.print(u[i] + " ");
        }
    }

    //Good implementation of Mergesort
    //Time Complexity O(nlogn)
    //Space Complexity O(n)
    
    //A[a..b]
    public void mergesort(int[] arr,int a,int b){

        if(a<b) {

            int m = a + (b - a) / 2;

            mergesort(arr, a, m);
            mergesort(arr, m + 1, b);

            merge(arr, a, m, b);

        }
    }


    //merges A[a..m] and A[m+1..b]
    public void merge(int[] arr , int a , int m , int b){
        int pl=0, pr=0 , p=0;

        int nl = m - a + 1;
        int nr = b - m;

        int[] L = new int[nl];
        int[] R = new int[nr];
        for (int i = 0; i < nl; i++) {
            L[i] = arr[a + i];
        }
        for (int j = 0; j < nr; j++) {
            R[j] = arr[m + 1 + j];
        }

        while(pl < nl && pr < nr){
            if(L[pl] < R[pr]){
                arr[a+p] = L[pl];
                pl++;
                p++;
            }else{
                arr[a+p] = R[pr];
                pr++;
                p++;
            }
        }

        while(pl < nl){
            arr[a+p] = L[pl];
            pl++;
            p++;
        }

        while(pr < nr){
            arr[a+p] = R[pr];
            pr++;
            p++;
        }
    }

}
