import java.util.*;

public class Main {
    public List<List<Integer>> countFreq(int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int a : arr) mp.put(a, mp.getOrDefault(a, 0) + 1);
        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            ans.add(Arrays.asList(e.getKey(), e.getValue()));
        }
        return ans;
    }
}
