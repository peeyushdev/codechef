package codechefpractise;

import java.util.Arrays;
import java.util.Scanner;

public class CHEFSUBA {


    public static int[] maxOnes;

    public static int[] shiftArray(int[] arr, int shift){
        shift%=arr.length;
        if(shift==0)
            return arr;
        int[] arr1 = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int index =  i+shift;
            if(index >= arr.length){
                index-=arr.length;
            }
            arr1[index]=arr[i];
        }
        return arr1;
    }

    public static int returnMaxOne(int[] arr, int k){
        int maxOne = 0;
        for(int i=0;i<arr.length;i++){
            int ones = 0;
            for(int j=i;j<arr.length && j <i+k;j++){
                if(arr[j]==1)
                    ones++;
            }
            if(maxOne < ones)
                maxOne=ones;
        }
        return  maxOne;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int p = sc.nextInt();
        int[] arr = new int[n];
        maxOnes = new int[n];
        Arrays.fill(maxOnes,-1);
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        String request = sc.next();
        int shiftRequest = 0;
        StringBuilder out = new StringBuilder();
        for(int i=0;i<p;i++){
            if(request.charAt(i)=='!')
                shiftRequest++;
            else if(maxOnes[shiftRequest%n]==-1){
                arr = shiftArray(arr,shiftRequest);
                int ones =returnMaxOne(arr,k);
                out.append(ones+"\n");
                maxOnes[shiftRequest%n]=ones;
            }
            else {
                out.append(maxOnes[shiftRequest%n]+"\n");
            }
        }
        System.out.println(out);
    }
}
