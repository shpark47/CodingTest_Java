class Solution {
    int max = 0;
    boolean[] visited;
    public int solution(int[] info, int[][] edges) {
        visited = new boolean[info.length];
        visited[0] = true;
        dfs(info, edges, 1, 0);
        return max;
    }
    
    void dfs(int[] info, int[][] edges, int sheep, int wolf) {
        if(wolf >= sheep) return;
        
        max = Math.max(max, sheep);
        
        for(int[] e : edges) {
            int p = e[0];
            int c = e[1];
            if(visited[p] && !visited[c]) {
                visited[c] = true;
                if(info[c] == 0) {
                    dfs(info, edges, sheep + 1, wolf);
                } else {
                    dfs(info, edges, sheep, wolf + 1);
                }
                visited[c] = false;
            }
        }
    }
}