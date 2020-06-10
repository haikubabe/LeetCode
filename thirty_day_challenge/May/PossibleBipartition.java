package thirty_day_challenge.May;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode - #886
 */
public class PossibleBipartition
{
    enum Color {
        RED, BLUE
    }

    private static ArrayList<Integer>[] graph;
    private static Map<Integer, Color> colorMap;

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        graph = new ArrayList[N+1];
        for (int i=1;i<=N;i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0;i<dislikes.length;i++) {
            graph[dislikes[i][0]].add(dislikes[i][1]);
            graph[dislikes[i][1]].add(dislikes[i][0]);
        }
        colorMap = new HashMap<>();
        for (int i=1;i<=N;i++) {
            if (!colorMap.containsKey(i) && !canGroup(i, Color.RED)) {
                return false;
            }
        }
        return true;
    }

    private static boolean canGroup(int people, Color c) {
        if (colorMap.containsKey(people)) {
            return colorMap.get(people) == c;
        }
        colorMap.put(people, c);
        for (int i=0;i<graph[people].size();i++) {
            Color color;
            if (colorMap.get(people) == Color.RED) {
                color = Color.BLUE;
            } else {
                color = Color.RED;
            }
            if (!canGroup(graph[people].get(i), color)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        int N = 5;
        int[][] dislikes = {
                {1,2},
                {2,3},
                {3,4},
                {4,5},
                {1,5}
        };
        System.out.println(possibleBipartition(N,dislikes));
    }
}
