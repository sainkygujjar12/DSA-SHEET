package Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class mergeInterval {
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));

        ArrayList<int[]>merge=new ArrayList<>();

        merge.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int curr[] = intervals[i];
            int last[]=merge.get(merge.size()-1);

            if(last[1]>=curr[0]){
                last[1]=Math.max(last[1],curr[1]);
            }else{
                merge.add(curr);
            }
        }
        return merge.toArray(new int[merge.size()][]);
    }
}

