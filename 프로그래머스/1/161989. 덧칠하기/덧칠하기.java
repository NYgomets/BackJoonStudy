class Solution {
    public int solution(int n, int m, int[] section) {
        boolean[] visited = new boolean[n+1];
        for (int i : section) {
            visited[i] = true;
        }
        int answer = 0;
        for (int sec : section) {
            if (sec+m-1<=n) {
                if (visited[sec]) {
                    for (int i=sec; i<sec+m; i++) {
                        visited[i] = false;
                    }
                    answer++;
                }
            }
        }
        
        for (int i=1; i<=n; i++) {
            if (visited[i]) {
                answer++;
                break;
            }
        }
        return answer;
    }
}