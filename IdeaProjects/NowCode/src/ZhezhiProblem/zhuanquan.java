package ZhezhiProblem;

/**
 * Created by Gaochao on 2015/8/3.
 */
 class zhuanquanv1 {
    public static void main1(String[] args) {
        int num=4;
        int y1=0;
        int x1=0;
        int x2=num-1;
        int y2=num-1;
        int tem=1;
        int[][] max=new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                max[i][j]=tem;
                tem++;
            }
        }
        while (x1<=x2){
            if (x1==x2){
                System.out.println(max[x1][y1]);
                return;
            }else {
                printCirc(max, x1, y1, x2, y2);
                x1++;
                y1++;
                x2--;
                y2--;
            }
        }


    }
    public static void printCirc(int [][] max,int x1,int y1,int x2,int y2){
        for (int i=y1, j=y2,z=x1,m=x2;i<y2;i++,j--,z++,m--){
            System.out.println(max[x1][i]+" "+max[z][y2]+" "+max[x2][j]+" "+max[m][y1]);
        }


    }
}
//the solution of teacher
 class Problem_02_RotateMatrix {
    public static void rotate(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;//x.length
        int dC = matrix[0].length - 1;//y.length
        while (tR < dR) {
            rotateEdge(matrix, tR++, tC++, dR--, dC--);
        }
    }
    public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
        int times = dC - tC; // times就是总共的组数
        int tmp = 0;
        for (int i = 0; i != times; i++) { // 一次循环就是一组占据调整
            tmp = m[tR][tC + i];
            m[tR][tC + i] = m[dR - i][tC];
            m[dR - i][tC] = m[dR][dC - i];
            m[dR][dC - i] = m[tR + i][dC];
            m[tR + i][dC] = tmp;
        }
    }
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main1(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("=========");
        printMatrix(matrix);
    }
}

class zhuanquan{
    public static void main(String[] args) {
        //generate the matrix
        int num=4;
        int tem=1;
        int[][] max=new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                max[i][j]=tem;
                tem++;
            }
        }



    }

}