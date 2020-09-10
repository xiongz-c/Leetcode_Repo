package week205;
/**
 * P1579：保证图的可完全遍历
 * 题意：两个用户共有一个无向图，给出三种类型的边
 * 类型 1：只能由 Alice 遍历。
 * 类型 2：只能由 Bob 遍历。
 * 类型 3：Alice 和 Bob 都可以遍历。
 * 在保证两个用户都可以遍历完整个图的情况下，删除最多的边，返回可以删除的最大的边数
 * 如果最开始就不能完全便利，返回-1
 */

import java.util.Arrays;

public class P1579 {
    public static void main( String[] args ) {

    }
    static class Solution {
        public int findRoot(int[] union,int idx){//并查集
            if(union[idx]!=idx){
                int root = findRoot( union, union[idx] );
                union[idx] = root;//把所有子节点都连到root，即答主所说的压缩路径
                return root;
            }
            return idx;
        }

        public int unionFind(int n, int[][] edges, int excludedType,boolean[] visit){
            int[] union = new int[n+1];
            for (int i = 1;i <= n ; i++)union[i] = i;
            for (int i = 0;i < edges.length;i++){
                int[] edge = edges[i];
                if(edge[0] == excludedType)continue;
                int rootA = findRoot( union,edge[1] );
                int rootB = findRoot( union,edge[2] );
                if(rootA != rootB){
                    union[rootA] = rootB;
                    visit[i] = true;
                }
            }
            int res = 0;
            for (int i = 1;i <= n;i++){
                if(union[i] == i) res +=1;
            }
            return res;
        }
        public int maxNumEdgesToRemove(int n, int[][] edges) {
            boolean[] visited = new boolean[edges.length];
            Arrays.sort( edges, (a,b)->Integer.compare( b[0],a[0] ));
            if(unionFind(n, edges, 1,visited) != 1) return -1;
            if(unionFind(n, edges, 2,visited) != 1) return -1;
            int ans = 0;
            for (boolean u : visited){
                if(!u)ans += 1;
            }
            return ans;
        }
    }
}
