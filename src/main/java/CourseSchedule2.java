import java.util.*;

public class CourseSchedule2 {

    HashSet<Integer>[] nodePreCourses;
    HashSet<Integer>[] nodeFollowCourses;
    public int[] findOrder(int numCourses, int[][] pre) {

        int[] result = new int[numCourses];
        int index = 0;
        boolean[] visited = new boolean[numCourses];
        nodePreCourses = new HashSet[numCourses];
        nodeFollowCourses = new HashSet[numCourses];

        for (int i = 0; i < numCourses; i ++) {
            nodePreCourses[i] = new HashSet<Integer>();
            nodeFollowCourses[i] = new HashSet<Integer>();
        }

        for (int i = 0; i < pre.length; i ++) {
            nodePreCourses[ pre[i][0] ].add( pre[i][1] );
            nodeFollowCourses[ pre[i][1] ].add( pre[i][0] );
        }

        while (index < numCourses) {
            boolean loop = false;
            for (int i = 0; i < numCourses; i ++) {

                if (visited[i])
                    continue;
                HashSet<Integer> preSet = nodePreCourses[i];
                if (preSet.isEmpty()) {
                    removeAllFollows(i);
                    result[index] = i;
                    index ++;
                    visited[i] = true;
                    loop = true; // 标记一趟找到一个可以去除的结点
                }
            }
            if (!loop)
                return new int[0];
        }

        return result;
    }

    void removeAllFollows(int node) {

        HashSet<Integer> followSet = nodeFollowCourses[node];
        Iterator iter = followSet.iterator();
        while (iter.hasNext()) {
            int course = (Integer)iter.next();
            nodePreCourses[course].remove(node);
        }
        nodeFollowCourses[node].clear();
    }

}
