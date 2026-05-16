class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 0;
        int[] end = new int[24+k];
        for (int i=0; i<24; i++) {
            server -= end[i];
            int needServer = players[i]/m;
            if (server < needServer) {
                int add = needServer-server;
                answer += add;
                server += add;
                end[i+k] = add;
            }
        }
        
        return answer;
    }
}