package Arrays;
import java.util.*;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<numRows;i++){
            List<Integer> row = new ArrayList<>();

            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    row.add(1);
                }else{
                    int x=ans.get(i-1).get(j-1)+ans.get(i-1).get(j);
                    row.add(x);
                }
            }
            ans.add(row);
        }
        return ans;
    
    }
}