public class IterativeBinarySearch {

    public static int iterativeBinarySearch(int a[], int key) {
        int imin = 0;
        int imax = a.length - 1;

        while (imin <= imax) {
            int imid = (imin + imax) / 2;
            if (a[imid] == key)
                return imid;
            else if (a[imid] < key)
                imin = imid + 1;
            else
                imax = imid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 6, 8, 9, 11};
        System.out.println(iterativeBinarySearch(a, 4));
        System.out.println(iterativeBinarySearch(a, 10));
    }

}
