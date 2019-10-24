package ayrikyapilarcstudy2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author biocomitsystems
 */
public class AyrikYapilarCStudy2 {

    public static void main(String[] args) {

        int sizeA, sizeB;

        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of array A");
        sizeA = s.nextInt();
        System.out.println("Enter the size of array B?");
        sizeB = s.nextInt();

        Integer arrA[] = new Integer[sizeA];
        Integer arrB[] = new Integer[sizeB];

        System.out.println("Enter the elements of A");

        for (int i = 0; i < sizeA; i++) {
            arrA[i] = s.nextInt();

        }
        System.out.println(Arrays.toString(arrA));

        System.out.println("Enter the elements of B");
        for (int j = 0; j < sizeB; j++) {
            arrB[j] = s.nextInt();
        }
        System.out.println(Arrays.toString(arrB));

        printUnion(arrA, arrB, sizeA, sizeB);
        printIntersection(arrA, arrB, sizeA, sizeB);
        printDifference(arrA, arrB, sizeA, sizeB);
        printComplement(arrA, arrB);

    }

    static void printUnion(Integer arrA[], Integer bDizi[], int sizeA, int sizeB) {

        int f, i, j, k = 0;
        int tempArr[] = new int[100];

        for (i = 0; i < sizeA; i++) {
            tempArr[k] = arrA[i];
            k++;
        }

        for (i = 0; i < sizeB; i++) {
            f = 0;
            for (j = 0; j < sizeA; j++) {
                if (bDizi[i] == arrA[j]) {
                    f = 1;
                }
            }

            if (f == 0) {
                tempArr[k] = bDizi[i];
                k++;
            }
        }

        System.out.print("Union of Sets :");
        for (i = 0; i < k; i++) {
            System.out.print(tempArr[i] + " ");
        }

    }

    static void printIntersection(Integer arrA[], Integer bDizi[], int sizeA, int sizeB) {

        int tempArr[] = new int[100];
        int i, j, k = 0;

        for (i = 0; i < sizeA; i++) {
            for (j = 0; j < sizeB; j++) {
                if (arrA[i] == bDizi[j]) {
                    tempArr[k] = arrA[i];
                    k++;
                }
            }
        }

        for (i = 0; i < k; i++) {
            System.out.print("\nIntersection of Sets : " + tempArr[i] + " ");
        }

    }

    static void printDifference(Integer arrA[], Integer bDizi[], int sizeA, int sizeB) {
        boolean isFound = false;
        for (int i = 0; i < sizeA; i++) {
            isFound = false;

            for (int j = 0; j < sizeB; j++) {
                if (arrA[i] == bDizi[j]) {
                    isFound = true;
                }

            }
            if (!isFound) {

                System.out.println("\nDifference of A from B :" + arrA[i]);
            }

        }
        for (int i = 0; i < sizeB; i++) {
            isFound = false;

            for (int j = 0; j < sizeA; j++) {
                if (bDizi[i] == arrA[j]) {
                    isFound = true;
                }
            }
            if (!isFound) {

                System.out.print("Difference of B from A : " + bDizi[i] + " ");

            }
        }
    }

    static void printComplement(Integer aDizi[], Integer bDizi[]) {

        Set<Integer> A = new HashSet<Integer>();
        A.addAll(Arrays.asList(aDizi));

        Set<Integer> B = new HashSet<Integer>();
        B.addAll(Arrays.asList(bDizi));

        Set<Integer> complement = new HashSet<Integer>();
        complement.addAll(B);
        complement.removeAll(A);

        System.out.println("Complement of A : " + complement);

    }
}
