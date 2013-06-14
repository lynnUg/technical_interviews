
public class Pascal
 { 
  public static final int X_SIZE = 4;
  public static final int Y_SIZE = 4;
    public static void main(String[] args) { 
int[][] array = new int[X_SIZE][Y_SIZE];

    for(int i = 0; i < X_SIZE; i++){
        for (int j = 0; j < Y_SIZE; j++){
            array[i][j] = i * X_SIZE + (j + 1);
            System.out.print(array[i][j] + " ");
        } 
        System.out.println();
    }

    System.out.println("************");
    System.out.println("Spiral");       

    spiralPrint(X_SIZE, Y_SIZE, array);
        //int N = Integer.parseInt(args[0]);
        int N=4;
        int[][] pascal  = new int[N+1][];

        // initialize first row
        pascal[1] = new int[1 + 2];
        pascal[1][1] = 1;
        System.out.println(pascal[1][1] + " ");
        // fill in Pascal's triangle
        for (int i = 2; i <= N; i++) {
            pascal[i] = new int[i + 2];
          
            for (int j = 1; j < pascal[i].length - 1; j++)
		{
                pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];
                System.out.print(pascal[i][j] + " ");
                }
                 System.out.println();
        }

        // print results
	/*   for (int i = 1; i <= N; i++) {
            for (int j = 1; j < pascal[i].length - 1; j++) {
                System.out.print(pascal[i][j] + " ");
            }
            System.out.println();
	    }*/
    }
    public static void spiralPrint(int xSize, int ySize, int matrix[][]){
    int i,  k = 0, l = 0;
    xSize--;  ySize--;      

    while(k <= xSize && l <= ySize){
        for(i = l; i <= ySize; ++i) {
            System.out.print(matrix[k][i]+ " ");
        }           
        k++;

        for(i = k; i <= xSize; ++i) {
            System.out.print(matrix[i][ySize] + " ");
        }
        ySize--;

        for(i = ySize; i >= l; --i) {
                System.out.print(matrix[xSize][i] + " ");
        }
        xSize--;


        for(i = xSize; i >= k; --i) {
            System.out.print(matrix[i][l] + " ");
        }
        l++;
    }
}
}
