import java.util.ArrayList;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        ArrayList<Server> servers = new ArrayList<>();
        for (int i = 0; i < players.length; i++) {
            // i는 시간, players[i]는 i ~ i+1시의 게임 이용자 수
            for (int j = servers.size() - 1; j >= 0; j--) {
                Server server = servers.get(j);
                server.time -= 1;

                if (server.time == 0) {
                    servers.remove(j);
                }
            }

            if (players[i] / m > servers.size()) {
                int more = players[i] / m - servers.size();
                answer += more;
                while (more-- > 0) {
                    servers.add(new Server(k));
                }
            }
        }
        return answer;
    }
}

class Server {
    int time;

    public Server(int time) {
        this.time = time;
    }
}