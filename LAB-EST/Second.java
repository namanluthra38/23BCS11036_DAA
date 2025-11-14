import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Second {
    public int minPlatform(int arr[], int dep[]) {
        int n = arr.length;
        List<Pair> pairs = new ArrayList<>();
        for(int i = 0; i < n; i++){
            pairs.add(new Pair(arr[i], dep[i]));
        }
        
        PriorityQueue<Pair> q = new PriorityQueue<>((p1,p2) -> p1.dept - p2.dept);
        pairs.sort((p1,p2) -> p1.arri - p2.arri);
        int ans = 0;
        
        for(Pair p : pairs){
            while(!q.isEmpty() && q.peek().dept < p.arri){
                q.poll();
            }
            q.add(p);
            ans = Math.max(ans, q.size());
        }
        
        return ans;
    }
        
}

class Pair{
    int arri;
    int dept;
    
    public Pair(int a, int b){
        this.arri = a;
        this.dept = b;
    }
}
