public class Matrix{

    public int[][] coFactor(int[][] t,int r, int c){
        int n = t.length;
        int m = t[0].length;
        int coFact[][] = new int[n-1][m-1];
        int coI=0;
        
        for(int i=0;i<n;i++){
            if(i == r){
                continue;
            }
            int coJ=0;
            for(int j=0;j<m;j++){
                if(j == c){
                    continue;
                }
                coFact[coI][coJ] = t[i][j];
                coJ++;
            }
            coI++;
        }
        return coFact;
    }
    public void display(int[][] t){
        int n =t.length;
        int m = t[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(t[i][j]+" ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    public static void main(String s[]){
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        
        Matrix obj = new Matrix();
        obj.display(matrix);
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                obj.display(obj.coFactor(matrix,i,j));
            }
        }
    }

}
