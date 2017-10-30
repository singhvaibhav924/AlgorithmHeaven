
public class BadMergeSort {

    public static void main(String[] args) {
        int[] u = {2,9,16,1,3,9,32};
        BadMergeSort m = new BadMergeSort();
        int[] s = m.mergesort(u);
        for (int i = 0; i < s.length; i++) {
            System.out.print(s[i] + " ");
        }
    }

    //Bad implementation of Mergesort
    //Time Complexity O(nlogn)
    //Space Complexity O(nlogn)
    public int[] mergesort(int[] input){
        if(input.length == 1) return input;
        int[] right;
        int[] left;
        int m = input.length / 2;
        int n = input.length-m;
        right = new int[m];
        for (int i = 0; i < m; i++) {
            right[i] = input[i];
        }
        left = new int[n];
        for (int i = 0; i < n ;i++) {
            left[i] = input[m + i];
        }
        right = mergesort(right);
        left = mergesort(left);
        return merge(right,left);

    }

    public int[] merge(int[] r , int[] l){
        int[] result = new int[r.length + l.length];
        int rp = 0 ,lp = 0 , p=0;
        while(rp < r.length && lp < l.length){
            if(r[rp]<l[lp]){
                result[p] = r[rp];
                rp++;
                p++;
            }else{
                result[p] = l[lp];
                lp++;
                p++;
            }
        }
        while(rp < r.length){
            result[p] = r[rp];
            rp++;
            p++;
        }
        while(lp < l.length){
            result[p] = l[lp];
            lp++;
            p++;
        }
        return result;
    }

}
