import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String string = scanner.nextLine();
        String[] splitted = string.split(" ");

        for (String s : splitted) {
            arr.add(Integer.parseInt(s));
        }

        MergeSort sort = new MergeSort(arr);
        sort.printArray();
    }
}

class MergeSort {

    ArrayList<Integer> arr;

    MergeSort(ArrayList<Integer> arrayList) {
        arr = arrayList;
    }

    void merge(int leftIndex, int middle, int rightIndex) {

        int size1 = middle - leftIndex + 1;
        int size2 = rightIndex - middle;

        int[] L = new int[size1];
        int[] R = new int[size2];

        for (int i = 0; i < size1; ++i)
            L[i] = arr.get(leftIndex + i);
        for (int j = 0; j < size2; ++j)
            R[j] = arr.get(middle + 1 + j);

        int i = 0, j = 0;

        int k = leftIndex;
        while (i < size1 && j < size2) {
            if (L[i] <= R[j]) {
                arr.set(k, L[i]);
                i++;
            } else {
                arr.set(k, R[j]);
                j++;
            }
            k++;
        }

        while (i < size1) {
            arr.set(k, L[i]);
            i++;
            k++;
        }

        while (j < size2) {
            arr.set(k, R[j]);
            j++;
            k++;
        }
    }

    void sort(int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middle = leftIndex + (rightIndex - leftIndex) / 2;

            sort(leftIndex, middle);
            sort(middle + 1, rightIndex);

            merge(leftIndex, middle, rightIndex);
        }
    }

    void printArray() {
        sort(0, arr.size() - 1);
        System.out.print("[");
        for (int i = 0; i < arr.size(); i++) {
            if (i == arr.size() - 1) System.out.print(arr.get(i));
            else System.out.print(arr.get(i) + ", ");
        }
        System.out.println("]");
    }

}

