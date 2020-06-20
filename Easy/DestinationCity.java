package Easy;

import java.util.*;

/**
 * Leetcode - #1436
 */
public class DestinationCity
{
    public static String destCity(List<List<String>> paths) {
        if (paths.size() == 1) {
            return paths.get(0).get(1);
        }
        Map<String,String> map = new HashMap<>();
        for (List<String> path : paths)
        {
            map.put(path.get(0), path.get(1));
        }
        for (String dest : map.values()) {
            if (!map.containsKey(dest)) {
                return dest;
            }
        }
        return "";
    }

    public static void main(String[] args)
    {
        List<List<String>> paths = new ArrayList<>();
        paths.add(Arrays.asList("pYyNGfBYbm","wxAscRuzOl"));
        paths.add(Arrays.asList("kzwEQHfwce","pYyNGfBYbm"));
        System.out.println(destCity(paths));
    }
}
