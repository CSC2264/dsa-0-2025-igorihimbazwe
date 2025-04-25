// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] numbers = generate(1, 100, 10000);
        mergesort(numbers, 0, numbers.length - 1);
        display(numbers);
    }

    /* Generate 10000 random integers between 1 and 100 */
    public static int[] generate(int low, int high, int size) {
        int[] result = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            result[i] = rand.nextInt(high - low + 1) + low;
        }
        return result;
    }

    public static void mergesort(int[] a, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergesort(a, low, mid);
            mergesort(a, mid + 1, high);

            
            int n1 = mid - low + 1;
            int n2 = high - mid;

            int[] left = new int[n1];
            int[] right = new int[n2];

            for (int i = 0; i < n1; i++) {
                left[i] = a[low + i];
            }
            for (int j = 0; j < n2; j++) {
                right[j] = a[mid + 1 + j];
            }

            int i = 0, j = 0;
            int k = low;
            while (i < n1 && j < n2) {
                if (left[i] <= right[j]) {
                    a[k] = left[i];
                    i++;
                } else {
                    a[k] = right[j];
                    j++;
                }
                k++;
            }

            while (i < n1) {
                a[k] = left[i];
                i++;
                k++;
            }

            while (j < n2) {
                a[k] = right[j];
                j++;
                k++;
            }
        }
    }

    public static void display(int[] a) {
        for (int x : a) {
            System.out.print(x);
            System.out.print("\t");
        }
    }
}
