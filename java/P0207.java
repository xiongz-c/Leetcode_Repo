import java.util.*;

/**
 * P207：课程表
 * 给出课程总量和课程先后顺序对，求能否完成所有课程
 * 题解：简单拓扑排序
 */
public class P0207 {
    public static void main( String[] args ) {
        int num = 2;
        int[][] p = {{1,0},{0,1}};
        System.out.println(new Solution().canFinish( num,p ) );

    }

    static class Solution{
        public boolean canFinish(int numCourses, int[][] prerequisites) {
           Node[] arr = new Node[numCourses];
           for (int i = 0;i < numCourses;i++){
               arr[i] = new Node();
           }
           for (int[] e:prerequisites){
               arr[e[0]].out.add( e[1] );
               arr[e[1]].in++;
           }
            Queue<Node> q = new LinkedList<>(  );
            for (int i = 0;i < numCourses;i++){
                if(arr[i].in==0){
                    q.add( arr[i] );
                }
            }
            while(q.size() >0 && q.peek().in==0){
                Node now = q.peek();
                for (Integer i : now.out){
                    arr[i].in--;
                    if(arr[i].in==0){
                        q.add( arr[i] );
                    }
                }
                q.poll();
            }
            for (int i = 0;i < numCourses;i++){
                if(arr[i].in != 0 )return false;
            }
            return true;
        }
        static class Node implements Comparable<Node>{
            int in;
            ArrayList<Integer> out;
            Node(){
                in = 0;
                out = new ArrayList<>(  );
            }

            @Override
            public int compareTo( Node o ) {
                return this.in - o.in;
            }
        }
    }
}
