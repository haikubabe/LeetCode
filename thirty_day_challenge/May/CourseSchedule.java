package thirty_day_challenge.May;

import java.util.ArrayList;

/**
 * Leetcode - #207
 */
public class CourseSchedule
{
    enum Color {
        DFS_WHITE, DFS_BLACK, DFS_RED
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        Color[] visited = new Color[numCourses];
        for (int i=0;i<numCourses;i++) {
            graph[i] = new ArrayList<>();
            // mark it not visited
            visited[i] = Color.DFS_WHITE;
        }
        for (int i=0;i<prerequisites.length;i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for (int i=0;i<numCourses;i++) {
            if (!topologicalSort(graph, visited, i)) {
                return false;
            }
        }
        return true;
    }

    private static boolean topologicalSort(ArrayList[] graph, Color[] visited, int course) {
        // already visited
        if (visited[course] == Color.DFS_BLACK) {
            return false;
        }
        // mark it visited
        visited[course] = Color.DFS_BLACK;
        for (int i=0;i<graph[course].size();i++) {
            int c = (int)graph[course].get(i);
            if (!topologicalSort(graph, visited, c)) {
                return false;
            }
        }
        // mark it done visiting
        visited[course] = Color.DFS_RED;
        return true;
    }

    public static void main(String[] args)
    {
        int numCourses = 2;
        int[][] prerequisites = {
                {1,0}
        };
        System.out.println(canFinish(numCourses,prerequisites));
    }
}
