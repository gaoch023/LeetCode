package ZhezhiProblem;

/**
 * Created by Gaochao on 2015/8/3.
 */
public class shunshizhen {
    public static void main(String[] args) {
        int num=4;
        int y1=0;
        int x1=0;
        int x2=num-2;
        int y2=num-1;
        int tem=1;
        int[][] max=new int[num][num];
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                max[i][j]=tem;
                tem++;
            }
        }


        while(x1<=x2){
            if((x1==x2)&&(y1==y2)){
                System.out.println(max[x1][y1]);
                return;
            }else{
                printCircle(max,x1, y1, x2, y2);
                x1++;
                y1++;
                x2--;
                y2--;
            }
        }
    }
    public static void printCircle(int[][] max,int x1,int y1,int x2,int y2){
        for (int i = y1; i <=y2; i++) {
            System.out.print(max[x1][i]+" ");
        }
        for (int i = x1+1; i <=x2; i++) {
            System.out.print(max[i][y2]+" ");
        }
        for (int i = y2-1; i >=y1; i--) {
            System.out.print(max[x2][i]+" ");
        }
        for (int i = x2-1; i >x1; i--) {
            System.out.print(max[i][y1]+" ");
        }
    }
}
