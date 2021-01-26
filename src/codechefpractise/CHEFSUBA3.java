package codechefpractise;

import java.util.Arrays;
import java.util.Scanner;

public class CHEFSUBA3 {

    public static int[] getFrameChunks(int[] arr, int k) {
        int k1 = 1, j = 0;
        int[] maxOneInFrame = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (k1 <= k) {
                if (arr[i] == 1)
                    maxOneInFrame[j] += 1;
                k1++;
            } else {
                int diff = Math.abs(arr[j] - maxOneInFrame[j]);
                j++;
                maxOneInFrame[j] = diff;
                if (arr[i] == 1)
                    maxOneInFrame[j] += 1;
            }
        }
        j = k;
        k1 = 1;
        int i = j;
        while (j < arr.length) {
            if (k1 <= k) {
                if (arr[i] == 1) {
                    maxOneInFrame[j] += 1;
                }
                k1++;
            } else {
                int diff = Math.abs(arr[j] - maxOneInFrame[j]);
                j++;
                if (j == arr.length)
                    break;
                maxOneInFrame[j] = diff;
                if (arr[i] == 1)
                    maxOneInFrame[j] += 1;
            }
            i++;
            if (i >= arr.length)
                i -= arr.length;
        }
        return maxOneInFrame;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int p = sc.nextInt();
        int[] arr = new int[n];
        int[] maxOneInShiftedArray = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            maxOneInShiftedArray[i] = -1;
        }
        String request = sc.next();
        int[] maxOnes = getFrameChunks(arr, k);
        int[] shift = new int[n];
        Arrays.fill(shift,-1);
        int j = 0;
        for (int i = 0; i < k; i++) {
            if (shift[j] < maxOnes[i])
                shift[j] = maxOnes[i];
        }
        int shiftRequest =0;
        for(int i=0;i<p;i++){
            if(request.charAt(i)=='!')
                shiftRequest++;
            else{
                shiftRequest%=arr.length;
                if(shift[shiftRequest]!=-1)
                    System.out.println(shift[shiftRequest]);
                else{
                    int max = 0;
                    j = arr.length-1;
                    int l = 1;
                    while(l<=shiftRequest){
                        max =  Math.max(max,maxOnes[j]);
                        j--;
                        l++;
                    }
                    if(arr.length-shiftRequest-k<0){
                        shift[shiftRequest]=max;
                    }
                    else{
                        for(j=0;j<=arr.length-shiftRequest-k;j++){
                            max =  Math.max(max,maxOnes[j]);
                        }
                        shift[shiftRequest]=max;
                    }
                    System.out.println(shift[shiftRequest]);
                }
            }
        }
    }
}


//    public static int getFrameChunks(int[] arr, int k) {
//        int k1 = 1, j = 0;
//        int maxOnes = 0;
//        int[] maxOneInFrame = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            if (k1 <= k) {
//                if (arr[i] == 1)
//                    maxOneInFrame[j] += 1;
//                k1++;
//            } else {
//                int diff = Math.abs(arr[j] - maxOneInFrame[j]);
//                j++;
//                maxOneInFrame[j] = diff;
//                if (arr[i] == 1)
//                    maxOneInFrame[j] += 1;
//            }
//            if (maxOneInFrame[j] > maxOnes)
//                maxOnes = maxOneInFrame[j];
//        }
//        return maxOnes;
//    }
//
//    public static int[] shiftArray(int[] arr, int shift) {
//        shift %= arr.length;
//        if (shift == 0)
//            return arr;
//        int[] arr1 = new int[arr.length];
//        for (int i = 0; i < arr.length; i++) {
//            int index = i + shift;
//            if (index >= arr.length) {
//                index -= arr.length;
//            }
//            arr1[index] = arr[i];
//        }
//        return arr1;
//    }



//    public static int getFrameChunks1(int[] arr, int k, int startingIndex) {
//        int k1 = 1, j = startingIndex;
//        int maxOnes = 0;
//        int[] maxOneInFrame = new int[arr.length];
//        int index = startingIndex;
//        boolean firstMatch = true;
//        do {
//            if (index == startingIndex && firstMatch) {
//                firstMatch = false;
//            } else if (index == startingIndex && !firstMatch)
//                break;
//            if (k1 <= k) {
//                if (arr[index] == 1)
//                    maxOneInFrame[j] += 1;
//                k1++;
//            } else {
//                int diff = Math.abs(arr[j] - maxOneInFrame[j]);
//                j++;
//                if (j >= arr.length)
//                    j -= arr.length;
//                maxOneInFrame[j] = diff;
//                if (arr[index] == 1)
//                    maxOneInFrame[j] += 1;
//            }
//            if (maxOneInFrame[j] > maxOnes)
//                maxOnes = maxOneInFrame[j];
//            index++;
//            if (index >= arr.length)
//                index -= arr.length;
//        } while (index != startingIndex);
//        return maxOnes;
//    }