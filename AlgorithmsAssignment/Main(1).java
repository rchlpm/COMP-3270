import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import java.io.IOException;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Main {
    public static int[] A1 = new int[10];
    public static int[] A2 = new int[15];
    public static int[] A3 = new int[20];
    public static int[] A4 = new int[25];
    public static int[] A5 = new int[30];
    public static int[] A6 = new int[35];
    public static int[] A7 = new int[40];
    public static int[] A8 = new int[45];
    public static int[] A9 = new int[50];
    public static int[] A10 = new int[55];
    public static int[] A11 = new int[60];
    public static int[] A12 = new int[65];
    public static int[] A13 = new int[70];
    public static int[] A14 = new int[75];
    public static int[] A15 = new int[80];
    public static int[] A16 = new int[85];
    public static int[] A17 = new int[90];
    public static int[] A18 = new int[95];
    public static int[] A19 = new int[100];

    public static int[][] matrix = new int[19][8];

    public static void main(String[] args){

        int[] x = readFile();

        int max = 0;
        max = algorithm1(x);
        System.out.println("Algorithm-1: " + max);
        max = algorithm2(x);
        System.out.println("\n" + "Algorithm-2: " + max);
        max = algorithm3(x, 0, 9);
        System.out.println("\n" + "Algorithm-3: " + max);
        max = algorithm4(x);
        System.out.println("\n" + "Algorithm-4: " + max);


        arraysHand();
        createFile();
    }

    /**
     *
     *  Source: https://www.tutorialspoint.com/How-to-read-a-2d-array-from-a-file-in-java
     */
     static Scanner scann;
    public static int[] readFile()
    {
    String input = "";
    
        //String[] input = new String[10];
        //int[] inputNums = new int[10];
        try {
        scann = new Scanner (new File("phw_input.txt"));
        }
        catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
        }
        while (scann.hasNext()) {
        input += scann.next();
        }
        String[] array = input.split(",");
        int[] inputNums = new int[array.length];
        for(int i = 0; i < array.length; i++) {
        inputNums[i] = Integer.parseInt(array[i]);
        }
        return inputNums;
        
    }

    /**
     * 	Algorithm1
     */
    public static int algorithm1(int X[]) {
        int maxSoFar = 0, P = 0;
        int Q = X.length;

        for(int L = P; L < Q; L++) {
            for(int U = L; U < Q; U++) {
                int sum = 0;
                for(int I = L; I <= U; I++) {
                    sum = sum + X[I];
                }
                maxSoFar = Math.max(maxSoFar, sum);
            }
        }

        return maxSoFar;
    }

    /**
     * 	Algorithm2
     */
    public static int algorithm2(int X[]) {
        int maxSoFar = 0, P = 0;
        int Q = X.length;

        for(int L = P; L < Q; L++) {
            int sum = 0;
            for(int U = L; U < Q; U++) {
                sum = sum + X[U];
                maxSoFar = Math.max(maxSoFar, sum);
            }
        }

        return maxSoFar;
    }

    /**
     * 	Algorithm 3
     */
    public static int algorithm3(int X[], int L, int U) {

        if(L > U) return 0;
        if(L == U) return Math.max(0, X[L]);

        int M = (L + U)/2;
        int sum = 0, maxToLeft = 0;

        for(int I = M; I >= L; I--) {
            sum = sum + X[I];
            maxToLeft = Math.max(maxToLeft, sum);
        }

        sum = 0;
        int maxToRight = 0;

        for(int I = M+1; I <= U; I++) {
            sum = sum + X[I];
            maxToRight = Math.max(maxToRight, sum);
        }

        int maxCrossing = maxToLeft + maxToRight;

        int maxInA = algorithm3(X, L, M);
        int maxInB = algorithm3(X, M+1, U);

        return Math.max(maxCrossing,Math.max(maxInA, maxInB));
    }

    /**
     * 	Algorithm4 is the fourth algorithm that was provided in pseudocode
     */
    public static int algorithm4(int X[]) {
        int maxSoFar = 0, maxEndingHere = 0, P = 0;
        int Q = X.length;

        for(int I = P; I < Q; I++) {
            maxEndingHere = Math.max(0, maxEndingHere + X[I]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }

    /**
     *
     */
    public static void arraysHand() {
        A1 = addArray(10);
        A2 = addArray(15);
        A3 = addArray(20);
        A4 = addArray(25);
        A5 = addArray(30);
        A6 = addArray(35);
        A7 = addArray(40);
        A8 = addArray(45);
        A9 = addArray(50);
        A10 =addArray(55);
        A11 =addArray(60);
        A12 =addArray(65);
        A13 =addArray(70);
        A14 =addArray(75);
        A15 =addArray(80);
        A16 =addArray(85);
        A17 =addArray(90);
        A18 =addArray(95);
        A19 =addArray(100);

        Time(A1, 0);
        Time(A2, 1);
        Time(A3, 2);
        Time(A4, 3);
        Time(A5, 4);
        Time(A6, 5);
        Time(A7, 6);
        Time(A8, 7);
        Time(A9, 8);
        Time(A10, 9);
        Time(A11, 10);
        Time(A12, 11);
        Time(A13, 12);
        Time(A14, 13);
        Time(A15, 14);
        Time(A16, 15);
        Time(A17, 16);
        Time(A18, 17);
        Time(A19, 18);
    }


    /**
     *
     * Source: https://www.tutorialspoint.com/generate-a-random-array-of-integers-in-java#:~:text=In%20order%20to%20generate%20random,this%20random%20number%20generator%20sequence.
     */
    private static int[] addArray(int length) {
        Random ran = new Random();
        int[] temp = new int[length];

        for(int i = 0; i < length; i++)
            temp[i] = ran.nextInt(100) - 50;

        return temp;
    }


    /**
     *
     * Source: // https://www.programiz.com/java-programming/examples/calculate-methods-execution-time
     */
    public static void Time(int[] temp, int row) {

        long start = 0, end = 0, execution = 0;
        int Alg1Time = 0, Alg2Time = 0, Alg3Time = 0, Alg4Time = 0;
        double tn_Alg1 = 0, tn_Alg2 = 0, tn_Alg3 = 0, tn_Alg4 = 0;

        int length = temp.length;

        for(int i = 0; i < 400; i++) {

            start = System.nanoTime();
            int max = algorithm1(temp);
            end = System.nanoTime();

            execution = end - start;
            Alg1Time += execution;
            System.out.println(Alg1Time);

            start = System.nanoTime();
            max = algorithm2(temp);
            end = System.nanoTime();

            execution = end - start;
            Alg2Time += execution;

            start = System.nanoTime();
            max = algorithm3(temp, 0, length-1);
            end = System.nanoTime();

            execution = end - start;
            Alg3Time += execution;

            start = System.nanoTime();
            max = algorithm4(temp);
            end = System.nanoTime();

            execution = end - start;
            Alg4Time += execution;
        }

        int[] arrayOfTime = { Alg1Time, Alg2Time, Alg3Time, Alg4Time, (int) tn_Alg1, (int) tn_Alg2, (int) tn_Alg3, (int) tn_Alg4 };

// matrix
        for(int j = 0; j < 8; j++) {
            matrix[row][j] = arrayOfTime[j];
        }


    }

    /**
     *
     * 	Source: https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it
     */
    public static void createFile() {

        try {
            File file = new File("RachelMeredith_KaitlynSmith_phw_output.txt");
            FileWriter writeFile = new FileWriter("RachelMeredith_KaitlynSmith_phw_output.txt");

            writeFile.write("algorithm-1,algorithm-2,algorithm-3,algorithm-4,'O(n^3)','O(n^2)','O(n)','O(n)'\n");

            for(int i = 0; i < 19; i++) {
                for(int j = 0; j < 8; j++) {
                    String value = Integer.toString(matrix[i][j]);
                    writeFile.write(value);

                    if(j < 7) writeFile.write(",");

                }
                writeFile.write("\n");
            }

            writeFile.close();

        }
        catch(IOException e) { System.out.println(e); }

    }

}
