import java.util.Scanner;

public class Hakidashi {
    public static void main(String[] args){
        double[][] a;
        int n;

        Scanner sc = new Scanner(System.in);

        System.out.printf("\n�|���o���@�ɂ��A���������̉𓱏o���s���܂��B\n\n");
        System.out.println("�W���s��̎���������͂��Ă��������B");
        System.out.print("n = ");
        n = sc.nextInt();
        a = new double[n + 1][n + 2];
        System.out.printf("\n�g��W���s��̐�������͂��Ă��������B\n");
        a = gyoretsu(n, a, 'a', sc);
        System.out.printf("\n���͂��ꂽ�g��W���s��́A\n");
        printGyoretsu(n, a);
        check(sc);
        sc.close();
        a = hakidashi(n, a);
        System.out.printf("\n�g��W���s��̊K�i�s��́A\n");
        printGyoretsu(n, a);
        System.out.printf("\n���������āA���߂�ꂽ���́A\n");
        printKai(n, a);
    }

    public static double[][] gyoretsu(int n, double[][] a, char c, Scanner sc){
        int i, j;

        for(i = 1; i < n + 1; i++){
            for(j = 1; j < n + 2; j++){
                System.out.printf("%c[%d][%d] = ", c, i, j);
                a[i][j] = sc.nextDouble();
            }
        }
        
        return a;
    } 

    public static double[][] hakidashi(int n, double a[][]){
        int i, j, k;
        double piv, piv2;

        for(i = 1; i < n + 1; i++){
            piv = a[i][i];
            if(piv == 0.0){
                System.out.printf("\n������ӂɒ�܂�܂���B\n�v�Z�������I�����܂��B\n");
                System.exit(0);
            }
            for(j = i; j < n + 2; j++){
                a[i][j] = a[i][j] / piv;
            }
            for(j = 1; j < n + 1; j++){
                piv2 = a[j][i];
                if(j != i){
                    for(k = i; k < n + 2; k++){
                        a[j][k] = a[j][k] - piv2 * a[i][k];
                    }
                }
            }
        }

        return a;
    }

    public static void printGyoretsu(int n, double a[][]){
        int i, j;

        for(i = 1; i < n + 1; i++){
            System.out.print("[ ");
            for(j = 1; j < n + 2; j++){
                System.out.printf("%f ", a[i][j]);
            }
            System.out.println("]");
        }
    } 

    public static void printKai(int n, double a[][]){
        int i;

        for(i = 1; i < n + 1; i++){
            System.out.printf("x%d = %f\n", i, a[i][n + 1]);
        }
    }

    public static void check(Scanner sc){
        char a;
        
        System.out.printf("\n���͓��e�͐������ł����H�@(y/n) ");
        a = sc.next().charAt(0);
        if(a == 'n'){
            System.out.printf("\n�v���O�������Ď��s���Ă��������B\n");
            System.exit(0);
        }else if(a == 'y'){

        }else{
            check(sc);
        }
    }
}