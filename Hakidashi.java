import java.util.Scanner;

public class Hakidashi {
    public static void main(String[] args){
        double[][] a;
        double piv, piv2;
        int n, i, j, z;

        Scanner sc = new Scanner(System.in);

        System.out.printf("\n�|���o���@�ɂ��A���������̉𓱏o���s���܂��B\n\n");
        System.out.println("�W���s��̎���������͂��Ă��������B");
        System.out.print("n = ");
        n = sc.nextInt();

        a = new double[n + 1][n + 2];
        System.out.printf("\n�g��W���s��̐�������͂��Ă��������B\n");
        for(i = 1; i < n + 1; i++){
            for(j = 1; j < n + 2; j++){
                System.out.printf("a[%d][%d] = ", i, j);
                a[i][j] = sc.nextDouble();
            }
        }
        sc.close();

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
                    for(z = i; z < n + 2; z++){
                        a[j][z] = a[j][z] - piv2 * a[i][z];
                    }
                }
            }
        }

        System.out.printf("\n�g��W���s��̊K�i�s��́A\n");
        for(i = 1; i < n + 1; i++){
            System.out.print("[ ");
            for(j = 1; j < n + 2; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println("]");
        }
        
        System.out.printf("\n���������āA���߂�ꂽ���́A\n");
        for(i = 1; i < n + 1; i++){
            System.out.printf("x%d = %f\n", i, a[i][n + 1]);
        }
    }
}