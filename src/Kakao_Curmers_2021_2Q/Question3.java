package Kakao_Curmers_2021_2Q;/*
 * Date : 2021-04-03
 * Question.No :
 * Remark :
 */

public class Question3 {

    private static boolean[][] trainMap;
    private static boolean[] visited;
    private static int N, maxPassenger, lastStation, count;
    private static int[] passengers;

    public static void main(String[] args) {
        int n = 6;
        int[] p = {1,1,1,1,1,1};
        int[][] train = {{1,2},{1,3},{1,4},{3,5},{3,6}};
        solution(n,p,train);
    }

    public static int[] solution(int n, int[] passenger, int[][] train) {

        N = n + 1;
        trainMap = new boolean[n + 1][n + 1];
        visited = new boolean[n+1];
        passengers = passenger;

        for (int i = 0; i < train.length; i++) {
                trainMap[train[i][0]][train[i][1]] = true;
        }

        dfs(1);

        int[] answer = {lastStation,maxPassenger+passenger[0]};
        return answer;
    }


    public static void dfs(int current) {
        for (int i = 1; i < N; i++) {
            if(trainMap[current][i] && !visited[i]) {
                count += passengers[i-1];
                lastStation = lastStation < i ? i : lastStation;
                visited[i] = true;
                dfs(i);
            }
        }
        if(lastStation == current) {
            maxPassenger = maxPassenger < count ? count : maxPassenger;
            count = 0;
        }
    }
}


