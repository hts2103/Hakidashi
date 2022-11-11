import java.util.Scanner;

public class Hakidashi {
    public static void main(String[] args){
        double[][] a;
        double piv, piv2;
        int n, i, j, z;

        Scanner sc = new Scanner(System.in);

        System.out.printf("\n掃き出し法による連立方程式の解導出を行います。\n\n");
        System.out.println("係数行列の次元数を入力してください。");
        System.out.print("n = ");
        n = sc.nextInt();

        a = new double[n + 1][n + 2];
        System.out.printf("\n拡大係数行列の成分を入力してください。\n");
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
                System.out.printf("\n解が一意に定まりません。\n計算を強制終了します。\n");
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

        System.out.printf("\n拡大係数行列の階段行列は、\n");
        for(i = 1; i < n + 1; i++){
            System.out.print("[ ");
            for(j = 1; j < n + 2; j++){
                System.out.print(a[i][j] + " ");
            }
            System.out.println("]");
        }
        
        System.out.printf("\nしたがって、求められた解は、\n");
        for(i = 1; i < n + 1; i++){
            System.out.printf("x%d = %f\n", i, a[i][n + 1]);
        }
    }
}