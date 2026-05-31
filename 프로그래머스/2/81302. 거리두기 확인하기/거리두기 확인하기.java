import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Node {
        int x, y, dist;

        Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            if (checkPlace(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    private boolean checkPlace(String[] place) {
        for (int r = 0; r < 5; r++) {
            for (int c = 0; c < 5; c++) {
                if (place[r].charAt(c) == 'P') {
                    if (!bfs(place, r, c)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean bfs(String[] place, int sx, int sy) {
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        queue.offer(new Node(sx, sy, 0));
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.dist == 2) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    char nextChar = place[nx].charAt(ny);

                    if (nextChar == 'X') {
                        continue;
                    }

                    if (nextChar == 'P') {
                        return false;
                    }

                    if (nextChar == 'O') {
                        queue.offer(new Node(nx, ny, current.dist + 1));
                    }
                }
            }
        }
        return true;
    }
}