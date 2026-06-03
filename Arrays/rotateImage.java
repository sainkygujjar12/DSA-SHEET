package Arrays;

public class rotateImage {
    
    public void rotate(int[][] matrix) {
        int n=matrix.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        //rotate
        for(int i=0;i<n;i++){
            int right=n-1;
            int start=0;
            while(start<=right){
                int temp=matrix[i][right];
                matrix[i][right]=matrix[i][start];
                matrix[i][start]=temp;
                start++;
                right--;
            }
        }
        
    }
}

