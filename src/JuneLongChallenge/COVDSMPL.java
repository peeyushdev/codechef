package JuneLongChallenge;

import java.util.Arrays;
import java.util.Scanner;

public class COVDSMPL {

    public  static  int grader(int r1,int c1,int r2,int c2){
        Scanner sc = new Scanner(System.in);
        StringBuilder interaction = new StringBuilder();
        interaction.append(1);
        interaction.append(" "+r1+" "+c1+" "+r2+" "+c2);
        System.out.println(interaction);
        return sc.nextInt();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- >0){
            StringBuilder ans = new StringBuilder();
            int n = sc.nextInt();
            int p = sc.nextInt();
            int[][] matrix = new int[n][n];
            for(int i=0;i<n;i++)
                Arrays.fill(matrix[i],-1);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][j]>-1)
                        continue;
                    else{
                        int r1,c1,r2,c2;
                        r1 = i+1;
                        c1 = j+1;
                        r2 = i+1;
                        c2 = n;
                        int rowOutput = grader(r1,c1,r2,c2);
                        if(rowOutput == 0){
                            for(int k=j;k<n;k++)
                                matrix[i][k]=0;
                            continue;
                        }
                        if(rowOutput ==  c2-c1+1){
                            for(int k =j;k<n;k++)
                                matrix[i][k]=1;
                            continue;
                        }
                        r2 = n;
                        c2 = j+1;
                        int colOutput = grader(r1,c1,r2,c2);
                        if(colOutput == 0){
                            for(int k=i;k<n;k++)
                                matrix[k][j]=0;
                            continue;
                        }
                        if(colOutput == r2-r1+1){
                            for(int k =i;k<n;k++)
                                matrix[k][j]=1;
                            continue;
                        }
                        r2 = r1;
                        c2= c1;
                        int output = grader(r1,c1,r2,c2);
                        if(colOutput == 1){
                            if(output == 1){
                                matrix[i][j]=1;
                                for(int k = i+1;k<n;k++)
                                    matrix[k][j]=0;
                            }
                            if(output == 0 && i==n-2){
                                matrix[i][j]=0;
                                matrix[n-1][j]=1;
                            }
                        }
                        if(rowOutput == 1){
                            if(output == 1){
                                matrix[i][j]=1;
                                for(int k=j+1;k<n;k++)
                                    matrix[i][k]=0;
                            }
                            if(output == 0 && j== n-2){
                                 matrix[i][j]=0;
                                 matrix[i][n-1]=1;
                            }
                        }
                        matrix[i][j]=output;
                    }
                }
            }
            ans.append("2\n");
            for(int i=0;i<n;i++){
                for (int j=0;j<n;j++)
                    ans.append(matrix[i][j]+" ");
                ans.append("\n");
            }
            System.out.println(ans);
            int x = sc.nextInt();
            if(x ==-1)
                System.exit(-1);
        }
    }
}
