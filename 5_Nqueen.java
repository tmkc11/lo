public class ass5 {

    public static void display(int matrix[][])
    {
        for(int row = 0 ; row < matrix.length ; row++)
        {
            for(int col = 0; col < matrix.length ; col++)
            {
                System.out.print(matrix[row][col]+" ");
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int row, int col , int matrix[][])
    {
        int i,j;

        for(i=0;i<col;i++)
        {
            if(matrix[row][i]==1)
            {
                return false;
            }
        }

        for(i=row,j=col; i>=0 && j>=0 ; i--,j--)
        {
            if(matrix[i][j]==1)
            {
                return false;
            }
        }

        for(i=row,j=col; i<matrix.length && j>=0 ; i++,j--)
        {
            if(matrix[i][j]==1)
            {
                return false;
            }
        }

        return true;
    }
    
    public static boolean solve(int matrix[][], int col)
    {
        if(col >= matrix.length)
        {
            return true;
        }

        for(int row = 0; row < matrix.length; row++)
        {
            if(isSafe(row,col,matrix))
            {
                matrix[row][col] = 1;

                if(solve(matrix, col+1))
                {
                    return true;
                }

                matrix[row][col] = 0;
            }
        }

        return false;
    }
    public static void initialize(int n)
    {
        int matrix[][] = new int[n][n];

        if(!solve(matrix,0))
        {
            System.out.println("No solution exist");
        }
        display(matrix);
    }
    public static void main(String [] args)
    {
        int n=4;
        initialize(n);
    }
}
