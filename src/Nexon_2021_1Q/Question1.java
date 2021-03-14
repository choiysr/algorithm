package Nexon_2021_1Q;


public class Question1 {
    // Function to find the maximum size
    // of matrix with sum <= K
    static void findMaxMatrixSize(int[][] arr, int K) {
        int i, j;

        // N size of rows and M size of cols
        int n = arr.length;
        int m = arr[0].length;

        // To store the prefix sum of matrix
        int[][] sum = new int[n + 1][m + 1];

        // Create prefix sum
        for (i = 0; i <= n; i++) {

            // Traverse each rows
            for (j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    sum[i][j] = 0;
                    continue;
                }

                // Update the prefix sum
                // till index i x j
                sum[i][j] = arr[i - 1][j - 1]
                        + sum[i - 1][j] + sum[i][j - 1]
                        - sum[i - 1][j - 1];
            }
        }

        // To store the maximum size of
        // matrix with sum <= K
        int ans = 0;

        // Traverse the sum matrix
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= m; j++) {

                // Index out of bound
                if (i + ans - 1 > n || j + ans - 1 > m)
                    break;

                int mid, lo = ans;

                // Maximum possible size
                // of matrix
                int hi = Math.min(n - i + 1, m - j + 1);

                // Binary Search
                while (lo < hi) {

                    // Find middle index
                    mid = (hi + lo + 1) / 2;

                    // Check whether sum <= K
                    // or not
                    // If Yes check for other
                    // half of the search
                    if (sum[i + mid - 1][j + mid - 1]
                            + sum[i - 1][j - 1]
                            - sum[i + mid - 1][j - 1]
                            - sum[i - 1][j + mid - 1]
                            <= K) {
                        lo = mid;
                    }

                    // Else check it in first
                    // half
                    else {
                        hi = mid - 1;
                    }
                }

                // Update the maximum size matrix
                ans = Math.max(ans, lo);
            }
        }

        // Print the final answer
        System.out.print(ans + "\n");
    }

    // Driver Code
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 3, 2, 4, 3, 2},
                {1, 1, 3, 2, 4, 3, 2},
                {1, 1, 3, 2, 4, 3, 2}};

        int[][] arr2 = {{1,1,1,},{1,1,1,},{1,1,1,}};


        int[][] x = {{2,87,78,57,78,47,46,40,100,19,99,55,24,49,87,14,79,27,87,13,80,77,56,46,84,5,53,63,66,59,5,5,32,61,17,3,50,58,69,30,95,10,79,18,14,8,70,42,64,48,53,7,17,63,45,67,8,99,18,4,37,55,20,63,2,36,67,56,11,39,44,23,83,32,87,1,96,78,23,63,64,52,43,61,98,92,13,60,37,35,35,47,25,5,8,100,88,78,85,93},
                {81,82,64,76,75,6,48,56,73,40,57,10,65,34,13,59,41,12,83,44,11,70,100,56,81,67,56,35,82,65,60,71,62,100,54,90,95,71,32,68,88,10,88,21,18,33,36,83,32,10,76,57,50,52,69,96,3,27,61,83,57,11,14,77,93,54,74,62,59,45,97,19,37,67,18,46,88,88,38,91,75,63,10,13,54,29,77,32,40,24,90,42,80,62,90,79,78,62,2,50},
                {12,63,55,81,77,9,97,38,59,24,58,98,91,34,6,98,85,27,4,97,83,43,45,49,72,86,69,97,69,8,45,82,61,19,84,47,50,40,100,25,21,43,34,88,57,58,4,55,45,44,84,85,73,26,37,61,49,85,61,50,7,28,57,5,71,4,98,44,47,34,30,20,80,79,94,30,30,3,20,25,72,14,95,17,61,5,74,82,18,1,90,5,64,96,18,60,3,35,51,48},
                {12,74,40,52,26,9,15,51,24,59,16,71,26,83,72,81,81,19,39,86,15,36,36,38,40,77,85,22,28,75,61,90,55,91,67,64,10,55,71,90,64,55,9,90,9,28,24,15,50,59,95,20,47,43,17,66,59,43,33,67,84,33,45,51,71,91,54,1,34,80,69,43,48,55,57,82,48,47,89,18,30,95,98,35,15,2,76,76,60,74,31,24,38,69,33,99,54,49,31,78},
                {58,89,29,10,22,83,31,66,73,32,3,30,62,4,3,37,61,96,57,32,100,7,25,40,54,81,78,22,77,63,97,50,83,3,44,11,41,6,97,35,62,23,74,67,41,53,58,39,78,15,27,21,46,29,32,81,2,76,18,93,93,58,58,29,12,56,7,21,29,49,61,5,87,99,15,99,93,68,72,32,33,76,45,80,31,35,35,15,35,40,98,71,93,94,61,20,50,79,62,38},
                {29,76,61,93,41,29,81,70,99,32,16,32,65,33,69,3,72,99,61,98,42,88,68,40,23,40,28,100,34,5,52,7,83,96,3,26,68,67,97,78,61,12,88,22,33,74,72,21,36,44,76,75,14,80,28,35,51,17,76,55,22,35,55,11,39,4,89,30,75,24,17,4,12,67,84,81,9,85,9,25,24,70,86,13,48,70,16,56,1,4,72,48,62,25,11,69,72,42,4,49},
                {8,26,90,64,75,83,92,89,98,73,57,69,12,100,79,88,10,33,72,4,78,93,6,17,93,70,50,56,5,38,93,84,33,81,72,39,35,19,60,56,66,14,48,11,53,12,2,22,9,73,79,84,11,32,77,40,68,3,82,24,33,95,38,89,56,58,81,37,71,60,79,68,85,75,30,20,38,16,53,17,7,80,98,60,8,8,93,37,11,73,47,34,44,46,96,96,81,64,61,93},
                {67,34,20,57,77,86,5,46,79,14,72,38,89,51,99,40,76,1,97,92,44,45,77,67,27,23,61,87,59,32,34,3,86,42,34,8,73,34,95,37,53,42,8,60,23,91,31,88,94,44,35,43,34,94,59,73,13,49,45,12,13,56,29,79,15,66,25,60,76,55,64,62,18,20,6,23,67,54,99,48,91,5,68,25,87,36,52,26,79,93,56,99,95,43,15,76,90,82,27,33},
                {35,51,50,99,51,11,58,27,25,66,62,19,99,71,62,82,95,6,83,81,42,60,99,84,92,59,26,74,78,15,29,97,63,73,39,84,45,93,28,64,59,15,41,74,44,68,10,19,67,74,5,57,82,66,85,17,92,81,88,11,16,97,23,45,36,14,72,14,40,78,56,55,100,22,26,98,55,54,37,68,79,42,47,14,23,29,7,5,86,73,59,41,62,29,6,2,20,41,50,22},
                {16,23,87,15,28,69,16,50,69,24,76,10,16,23,18,55,44,88,25,22,90,59,88,2,90,98,15,8,72,41,91,24,59,41,65,6,29,32,3,38,47,38,61,13,20,33,83,43,68,39,25,8,45,74,7,61,50,15,70,4,9,45,28,68,56,40,18,67,32,77,31,44,15,16,30,69,73,74,75,33,12,81,68,72,47,60,42,43,4,61,55,37,65,80,32,26,87,61,80,63},
                {28,33,97,2,35,76,2,76,49,38,68,40,48,88,76,21,47,3,68,51,74,40,86,59,19,59,45,1,12,76,72,87,91,70,83,66,83,42,58,66,31,74,42,47,19,5,25,100,86,9,39,58,74,20,76,44,33,41,82,56,7,30,36,90,34,53,39,79,85,94,71,67,90,69,55,61,7,84,9,72,29,43,24,8,93,79,43,57,59,54,31,92,99,61,73,8,86,17,36,28},
                {93,20,91,80,61,27,62,75,17,92,11,63,73,36,30,36,7,77,55,64,93,81,8,56,76,82,5,47,62,83,4,30,93,71,69,83,86,84,97,7,29,14,6,94,87,88,89,78,2,83,40,87,31,44,45,69,63,53,2,70,94,77,51,71,97,71,68,95,11,59,29,95,54,41,98,84,85,66,1,91,70,55,10,20,22,7,23,1,41,27,81,83,23,73,51,69,77,43,39,68},
                {15,25,98,86,16,34,12,91,68,54,89,8,24,18,79,86,78,23,13,88,76,70,82,62,11,78,12,53,33,96,81,61,35,47,62,43,54,57,42,55,48,1,9,82,17,44,15,80,45,14,79,80,9,47,16,45,54,68,24,46,34,52,9,1,59,83,35,58,65,99,41,43,38,99,89,81,35,38,27,26,77,27,76,92,43,15,93,78,23,36,99,90,6,34,79,36,77,58,62,58},
                {41,68,49,98,14,27,18,74,61,100,64,51,58,94,78,49,93,35,75,60,27,28,42,24,88,81,23,46,87,95,26,82,19,87,72,54,3,70,84,22,53,72,71,51,47,13,52,57,75,80,89,2,77,91,24,84,60,17,40,98,88,42,30,27,83,15,24,26,20,37,94,95,62,88,53,91,46,42,44,61,1,91,83,84,30,58,65,84,31,38,57,94,65,82,70,22,62,30,12,4},
                {37,56,62,87,92,24,57,35,67,37,72,3,20,49,75,77,57,11,27,17,38,4,89,96,32,98,50,85,63,29,31,64,46,16,75,5,6,64,31,62,83,21,35,93,96,94,91,58,52,58,73,73,74,50,18,7,10,40,80,7,28,76,19,52,3,25,11,77,21,97,35,83,70,49,71,85,82,24,77,84,3,51,48,51,47,60,63,17,58,50,37,87,54,20,69,80,60,24,5,72},
                {54,22,73,64,54,21,14,72,28,49,46,61,36,18,77,84,95,47,67,59,49,73,34,82,15,69,78,38,89,82,100,93,60,86,8,4,10,72,75,60,55,51,77,38,44,93,78,43,51,74,84,7,62,68,31,35,76,9,46,4,69,46,24,23,97,4,83,6,66,69,2,44,90,76,49,85,85,81,18,70,23,28,90,86,41,11,59,20,5,62,63,76,83,35,70,43,49,93,65,2},
                {7,68,38,44,18,61,39,79,13,70,29,80,39,48,75,82,67,50,47,58,33,82,18,96,17,35,10,34,95,7,24,55,80,72,83,54,11,14,95,77,33,21,13,75,47,43,9,37,92,55,2,97,56,51,100,47,58,12,88,37,32,46,62,58,84,87,19,66,76,31,36,5,1,34,98,75,33,59,33,91,15,12,46,14,73,63,48,87,24,78,49,43,31,50,24,88,67,81,28,67},
                {20,49,87,2,79,10,100,20,1,37,51,64,91,19,84,63,97,80,9,21,6,76,40,35,54,92,75,92,49,45,73,77,25,59,33,49,11,84,88,19,78,53,97,93,69,99,82,73,45,19,26,82,78,48,90,73,42,18,75,71,59,50,51,21,57,81,31,17,22,20,7,23,46,81,26,17,30,43,78,49,78,57,73,42,83,70,22,64,59,10,32,79,66,1,4,86,85,56,56,99},
                {73,41,98,38,74,66,88,58,29,46,98,81,33,100,9,98,69,41,23,88,15,80,1,34,89,28,15,91,25,5,89,27,76,67,31,94,64,43,38,91,34,65,54,46,25,82,43,97,38,77,48,14,50,33,87,70,10,43,32,49,34,69,13,3,11,2,89,22,93,11,16,11,55,26,79,31,38,42,36,64,99,68,7,32,91,49,33,22,58,59,28,14,84,9,27,59,23,51,74,23},
                {81,58,32,44,100,53,61,87,29,91,29,39,87,46,38,40,6,98,31,90,73,95,34,22,7,13,31,39,50,11,14,97,76,59,85,44,64,52,10,34,52,3,61,58,83,70,23,12,63,27,79,87,62,11,92,83,76,73,87,30,35,81,87,70,65,77,68,43,9,11,80,98,47,30,38,43,30,58,80,100,86,46,33,9,47,64,54,22,61,73,7,89,4,77,26,48,18,55,25,55},
                {69,88,50,34,72,76,40,32,16,24,38,42,19,27,26,42,20,94,97,95,47,70,38,1,69,26,18,16,11,7,81,4,92,36,92,53,51,56,47,78,46,76,43,82,11,79,66,7,33,51,57,30,45,33,36,61,42,86,58,36,9,49,84,87,57,8,25,7,81,32,77,63,68,84,49,31,7,90,99,42,84,42,22,14,65,41,17,74,88,3,85,46,55,56,90,21,27,77,51,84},
                {23,28,22,41,36,36,19,27,30,39,86,47,1,81,46,91,87,30,8,87,67,32,7,77,29,47,4,66,50,40,2,14,11,12,98,20,58,84,30,46,79,9,6,83,62,19,91,38,37,10,20,8,16,64,80,64,93,10,20,27,87,49,45,61,56,96,79,63,74,58,5,25,72,55,61,5,36,90,16,16,68,51,55,72,57,65,55,91,35,38,23,92,25,67,78,35,71,16,40,100},
                {58,8,97,52,22,50,24,7,61,37,13,39,3,8,84,100,67,99,70,47,61,45,53,50,59,61,38,35,65,44,40,49,98,90,9,58,48,69,3,82,5,42,34,80,51,62,86,31,85,84,91,68,87,21,65,67,27,48,58,70,75,60,13,35,47,31,61,90,63,5,95,1,12,83,87,45,38,69,41,51,20,4,82,61,74,11,77,59,39,27,44,76,41,23,61,21,97,89,63,90},
                {27,93,80,44,86,56,90,37,34,62,70,8,37,52,63,34,62,56,47,17,67,52,38,59,61,100,99,49,4,49,11,73,80,62,8,69,38,97,53,81,36,57,20,98,25,74,46,24,47,53,45,73,51,2,75,4,23,6,22,1,49,1,26,19,30,55,78,14,66,49,65,32,4,82,87,4,3,24,47,7,73,69,31,76,87,36,89,50,76,38,22,27,78,61,36,6,4,37,22,14},
                {99,37,55,59,7,66,58,12,50,30,34,76,100,76,69,60,32,82,99,55,37,88,26,61,43,72,71,28,11,15,43,98,45,46,89,15,31,57,5,96,9,32,12,10,44,50,27,100,72,20,17,66,92,68,64,85,98,2,58,93,70,37,66,33,60,98,5,15,77,54,1,19,70,30,43,4,18,64,57,77,87,97,66,30,11,18,73,2,53,27,42,95,100,91,64,60,86,14,27,52},
                {77,57,43,83,65,25,76,74,5,41,87,74,74,13,40,33,96,44,33,73,56,77,76,89,89,76,95,17,18,32,69,59,6,82,57,15,32,58,45,10,56,14,71,23,43,86,46,60,29,78,18,46,36,89,4,12,7,9,14,100,84,14,33,9,12,3,71,17,57,17,53,31,56,91,39,85,45,35,29,62,57,19,52,87,91,2,63,67,74,24,29,58,3,42,60,31,35,19,55,81},
                {41,4,57,60,6,82,37,46,16,89,59,94,69,52,84,57,28,71,58,61,26,40,28,97,74,95,19,47,7,60,35,55,30,6,30,86,11,81,87,17,39,35,48,99,14,41,46,91,49,78,55,57,74,85,6,23,23,33,27,66,70,57,47,41,88,29,26,52,41,13,78,20,98,29,42,36,45,35,10,15,52,23,67,68,21,47,62,14,97,30,33,83,17,74,20,22,47,57,79,6},
                {37,60,91,33,70,55,19,51,64,34,37,20,94,2,20,17,67,34,80,40,81,86,72,26,75,85,67,55,48,3,47,40,27,92,99,81,44,60,47,95,37,52,47,100,39,76,66,75,90,55,28,13,4,62,30,13,58,82,6,66,31,90,10,24,1,2,61,75,67,95,12,60,43,64,7,15,84,78,4,41,50,36,61,31,14,69,100,35,66,1,38,58,38,57,42,72,65,98,21,7},
                {30,89,57,87,58,76,67,5,60,34,82,69,2,57,74,94,53,69,25,41,28,44,98,50,89,62,92,80,23,68,47,40,66,78,25,15,65,11,59,26,38,24,7,27,57,42,99,84,70,5,47,46,93,72,45,22,69,51,57,39,21,40,52,10,78,37,77,46,8,40,75,14,73,12,31,6,64,77,49,29,66,30,41,48,11,65,92,54,60,99,3,36,49,68,26,10,28,58,10,55},
                {65,10,99,81,3,57,37,12,95,70,95,63,76,93,5,27,36,43,70,14,48,92,32,29,62,38,69,33,17,72,69,95,10,98,22,94,49,83,78,3,14,86,90,10,2,5,98,2,20,26,87,91,1,50,15,84,61,19,100,40,51,91,10,7,61,7,13,79,23,11,67,26,86,4,78,19,46,20,8,54,3,74,34,18,12,81,74,4,95,24,24,57,88,13,24,94,99,75,5,82},
                {35,5,66,87,12,55,85,10,26,76,1,21,56,88,86,73,100,43,11,54,57,85,83,37,81,85,52,74,65,47,43,5,40,76,57,100,23,89,43,38,80,4,84,97,25,43,12,85,2,15,64,83,3,83,8,18,20,79,33,15,20,92,83,79,36,69,5,6,75,1,94,9,88,29,63,99,60,93,51,31,49,61,61,84,3,19,56,15,57,85,24,2,97,72,95,69,78,7,52,58},
                {49,71,77,9,24,42,4,92,85,1,48,91,11,76,47,97,28,95,93,20,56,76,2,82,76,81,96,67,29,49,78,64,69,100,8,29,75,86,53,14,18,82,35,63,32,86,57,23,5,16,96,75,66,46,100,93,89,29,52,80,6,96,73,54,65,73,60,45,65,23,9,80,74,69,29,34,78,43,48,49,97,39,45,77,30,5,31,64,11,75,46,69,55,61,8,68,81,87,56,28},
                {10,76,29,28,99,79,47,45,63,8,67,45,15,72,87,10,95,45,4,8,34,53,7,20,40,85,41,19,86,24,10,90,98,100,3,39,1,23,67,20,28,3,64,39,83,50,13,30,85,36,3,64,44,32,54,11,14,83,92,59,67,84,89,24,40,48,12,6,86,91,12,72,50,13,25,50,9,22,52,19,70,89,78,72,53,19,72,43,4,1,69,50,56,44,75,95,50,4,83,65},
                {53,94,63,63,11,55,11,83,28,53,99,23,44,91,20,47,46,56,20,47,20,54,13,92,1,68,2,58,94,37,20,2,80,22,42,15,95,68,87,19,96,41,44,91,39,39,36,54,87,57,86,64,52,21,31,94,100,21,78,65,3,37,63,74,90,37,30,36,67,57,89,42,89,80,27,23,34,54,43,1,41,60,73,57,92,18,96,24,98,52,89,70,15,43,10,14,18,29,84,37},
                {18,16,42,82,82,95,99,19,58,10,45,20,89,28,27,88,38,42,24,27,1,80,42,28,21,50,68,14,60,81,33,7,100,56,29,25,14,32,62,12,97,19,63,100,95,67,76,28,25,71,3,70,18,79,17,5,57,42,20,1,37,32,2,48,34,16,28,23,91,60,46,41,16,29,29,28,76,7,21,46,14,50,10,28,40,99,23,8,49,61,73,48,69,42,39,48,29,65,91,34},
                {95,3,42,90,36,72,73,37,29,66,61,58,79,60,44,53,17,77,37,96,12,27,61,39,85,85,99,39,27,72,92,47,49,54,51,63,50,56,36,31,55,100,28,86,52,47,44,31,66,45,94,79,14,55,30,3,15,71,28,52,38,36,75,26,69,60,23,11,14,20,78,42,6,48,97,25,89,35,47,84,88,4,97,63,87,96,58,32,94,35,54,53,59,78,99,31,98,13,82,19},
                {83,93,26,4,14,36,6,84,57,28,46,51,40,48,85,37,41,94,58,59,30,4,2,19,42,15,60,46,86,94,3,20,56,42,60,81,68,38,33,88,3,69,11,79,41,90,55,14,10,55,56,5,11,5,93,3,12,52,39,79,88,89,79,88,88,18,31,11,96,51,60,51,15,28,81,65,58,73,18,79,88,94,16,57,85,45,98,3,16,3,32,82,50,89,22,2,21,4,75,99},
                {47,17,73,27,85,39,10,6,23,12,56,79,28,66,55,19,43,27,28,4,83,96,48,13,70,37,87,71,61,88,32,51,50,38,59,66,15,73,91,23,19,94,42,60,25,12,97,64,16,14,16,35,80,74,21,24,58,12,77,37,98,65,25,83,31,27,67,5,73,42,53,28,69,84,22,2,18,92,26,28,89,68,31,13,53,96,33,23,39,26,58,96,97,3,88,59,4,100,68,28},
                {79,99,18,45,25,67,48,70,100,3,1,2,90,9,72,75,70,41,85,60,46,66,90,68,57,36,19,93,1,89,13,88,59,12,50,79,1,21,24,66,82,59,8,31,43,33,5,25,39,6,92,4,62,89,9,59,53,46,20,44,72,35,71,65,27,3,5,69,71,80,83,59,60,49,37,18,68,88,55,84,93,88,27,3,37,84,46,14,39,84,44,10,14,92,84,80,84,85,36,9},
                {99,33,20,35,93,32,61,19,79,44,79,13,89,48,45,55,61,14,31,80,96,41,64,86,97,12,66,99,40,51,25,48,6,67,43,81,96,71,90,45,23,66,44,100,35,41,20,46,44,99,17,57,33,92,91,13,86,84,38,51,77,84,10,26,78,47,75,58,74,25,35,45,75,18,86,28,70,26,17,46,83,18,47,33,6,86,71,90,63,31,1,86,1,20,7,55,11,65,53,71},
                {56,57,82,87,62,12,65,72,22,21,90,8,26,16,8,44,66,84,84,80,38,36,93,76,74,54,50,54,47,96,85,36,96,55,99,28,52,56,82,42,6,49,46,27,64,30,25,96,40,72,26,84,56,11,73,45,10,25,91,68,55,68,40,56,64,11,73,83,96,38,9,78,1,32,72,77,64,63,74,5,9,57,100,61,9,20,60,83,68,100,99,52,15,77,81,95,60,7,56,98},
                {74,18,64,65,34,50,1,1,51,19,6,16,82,52,77,24,48,91,78,24,79,55,82,33,23,14,76,8,91,15,23,11,78,69,17,77,79,50,63,2,10,4,99,54,55,37,90,11,16,99,13,76,44,2,23,12,53,21,69,45,71,21,12,3,50,64,83,20,50,22,59,34,49,6,75,50,74,91,70,89,6,72,99,8,94,94,20,56,83,91,47,28,22,89,3,20,32,91,49,97},
                {9,5,40,92,19,66,50,94,79,52,31,68,28,22,69,66,56,47,40,2,87,71,89,68,60,59,73,7,69,14,77,53,96,12,28,40,31,59,87,44,41,66,31,36,5,36,17,16,37,57,20,26,60,91,56,54,29,81,30,85,65,79,73,50,31,86,45,82,92,79,82,65,96,31,72,63,61,31,60,65,78,38,8,3,63,15,55,25,93,26,96,70,14,75,77,40,78,97,8,14},
                {48,38,98,79,22,67,62,54,18,32,92,29,24,55,5,5,4,90,85,99,41,61,21,79,75,59,18,47,81,13,52,34,31,66,33,33,7,2,20,1,40,68,69,18,2,10,19,42,55,94,84,47,42,89,90,97,37,72,53,2,21,17,12,61,29,78,30,99,35,43,9,3,97,17,84,74,18,74,13,12,31,18,20,83,76,29,25,88,56,8,83,95,26,77,19,90,55,72,64,67},
                {86,37,79,67,49,41,8,40,79,41,15,98,84,27,2,96,20,74,60,75,13,9,54,55,68,55,12,75,32,95,16,7,89,61,73,45,46,52,41,24,88,57,3,1,29,18,41,61,53,64,31,83,68,89,92,68,20,56,73,87,53,80,62,72,43,19,35,59,9,9,29,75,48,58,46,12,65,18,1,18,68,85,39,5,41,90,95,82,5,90,11,78,43,63,12,67,44,22,56,22},
                {34,64,24,8,13,61,2,95,22,74,9,59,46,50,100,53,16,14,71,36,11,4,58,57,77,92,92,95,53,16,27,2,89,53,18,46,22,20,97,77,58,98,7,94,7,71,79,84,27,71,83,21,74,87,40,27,18,69,21,30,60,81,72,79,25,34,33,4,77,53,24,64,53,56,9,61,9,90,78,32,23,22,47,65,67,73,11,80,2,34,66,36,10,80,81,42,40,36,51,29},
                {36,81,57,88,100,48,26,72,30,23,73,64,27,35,77,78,58,96,83,68,64,82,9,5,67,39,12,98,79,67,8,64,74,60,44,92,77,79,62,72,50,75,49,1,69,15,35,57,58,65,30,49,29,68,75,65,49,13,40,45,42,57,35,39,85,52,20,70,4,57,27,6,79,54,67,58,86,93,12,35,79,31,89,11,54,64,63,30,10,72,69,7,48,34,33,76,25,12,96,94},
                {53,99,14,55,78,55,85,41,85,30,33,36,47,73,44,29,15,59,80,33,15,23,37,57,10,89,99,17,58,73,72,28,41,73,24,40,12,26,53,22,26,32,37,25,65,31,79,69,88,58,94,1,45,6,82,68,57,15,42,47,17,30,37,42,73,26,18,40,41,21,22,85,7,90,15,90,54,46,28,81,1,94,96,58,67,68,4,9,20,61,3,70,15,31,75,12,43,95,28,16},
                {6,23,49,30,26,26,16,39,43,48,89,97,26,2,38,27,61,63,18,27,51,1,3,85,43,59,5,26,44,31,93,91,92,36,87,85,70,32,41,16,67,56,84,52,2,26,38,60,62,24,20,63,83,99,66,23,27,28,2,36,96,61,33,60,71,42,26,36,22,21,42,52,34,67,43,74,71,87,25,71,50,55,32,10,85,82,13,82,30,47,78,20,54,60,86,37,24,49,26,73},
                {28,16,71,17,50,86,77,94,97,99,52,51,12,77,7,51,79,68,47,6,9,56,83,60,38,39,76,38,85,89,14,24,28,99,59,41,80,51,4,6,70,9,12,47,62,18,17,36,40,93,10,62,44,23,92,95,56,93,21,38,78,6,54,53,13,49,3,9,9,43,89,12,86,77,80,98,8,11,16,30,57,22,84,82,70,37,89,44,77,61,30,54,41,37,78,55,58,35,99,77},
                {58,26,1,92,10,17,53,89,91,2,8,44,71,88,11,11,36,5,97,77,55,53,99,82,12,23,94,76,20,45,56,88,57,83,46,68,41,62,22,89,79,59,97,43,50,86,53,63,37,13,50,100,25,41,44,93,89,64,98,27,72,66,39,97,41,70,64,81,44,4,37,29,3,17,86,43,41,22,91,30,57,3,51,55,56,32,15,11,57,64,95,85,97,91,84,35,54,32,57,23},
                {3,88,41,71,12,6,45,93,86,4,35,12,93,79,43,52,47,67,73,61,48,92,13,99,95,78,56,15,32,59,56,2,69,60,18,21,68,49,14,69,90,14,69,17,100,49,45,11,4,27,46,39,70,18,41,63,30,66,82,94,19,90,89,63,98,63,55,37,40,28,90,78,50,92,75,62,73,88,54,8,72,26,65,44,72,53,37,4,72,27,64,75,40,36,27,87,52,42,25,12},
                {26,71,94,37,26,14,45,17,53,93,88,93,46,11,63,59,49,41,61,1,60,50,51,8,72,60,74,51,92,35,95,9,12,22,93,77,4,62,21,41,53,11,99,23,94,44,30,61,99,1,69,11,83,93,40,9,59,37,83,51,74,62,21,71,80,76,61,49,63,18,21,19,92,77,75,35,3,25,99,24,23,30,3,8,77,62,31,64,33,3,39,59,66,20,40,10,80,38,70,41},
                {84,13,83,5,28,80,5,88,60,15,100,45,76,83,85,41,81,57,47,6,65,2,81,100,84,89,17,79,54,85,27,1,71,90,99,95,15,90,82,33,20,79,26,74,49,60,19,68,18,57,86,30,97,14,96,84,64,3,93,49,91,40,16,75,35,14,17,57,76,86,57,58,43,58,72,12,19,56,68,55,63,98,12,25,27,63,27,92,37,97,2,84,48,42,72,24,78,16,5,20},
                {99,94,21,25,59,24,95,32,3,28,26,39,4,51,49,6,16,50,24,75,10,78,12,73,4,100,39,32,29,88,80,14,53,47,72,36,67,70,25,73,35,19,96,52,78,68,32,77,6,67,89,81,14,50,10,33,32,45,15,83,61,27,47,31,69,55,46,70,73,60,81,56,46,72,62,94,5,7,88,65,81,74,3,57,25,24,30,58,51,40,92,93,15,13,86,67,32,23,81,72},
                {29,100,39,16,14,41,30,16,64,96,49,22,74,63,12,89,93,42,98,7,49,89,90,98,81,63,35,95,41,13,52,60,7,31,22,12,4,32,22,43,24,79,43,36,37,2,53,73,46,2,42,99,40,56,17,51,75,94,59,35,40,61,43,42,40,100,43,73,2,80,89,28,2,33,37,12,1,67,46,55,18,26,77,91,68,81,2,16,84,91,38,79,4,64,6,47,63,82,40,61},
                {80,25,10,1,86,20,66,14,48,31,95,100,86,47,53,35,93,61,95,99,28,95,88,25,76,29,2,32,90,85,36,88,78,6,68,93,11,17,10,42,34,17,43,90,53,69,39,84,27,52,20,74,28,4,59,64,87,49,24,15,89,83,53,24,82,23,23,96,29,42,81,62,67,13,40,5,85,41,5,96,10,17,35,69,99,20,83,76,40,98,23,12,78,28,68,26,82,100,18,21},
                {9,89,29,89,85,92,37,64,1,7,34,19,64,21,38,14,84,45,30,53,26,77,50,19,43,24,43,66,1,79,23,89,17,37,38,60,38,64,5,4,55,55,41,97,26,13,1,94,81,54,94,84,78,97,80,48,64,91,84,67,11,88,56,89,11,73,64,70,79,41,35,13,92,98,5,20,71,7,28,56,55,28,48,62,96,96,3,93,50,73,29,21,36,58,35,21,88,92,61,100},
                {70,41,36,76,35,59,77,43,41,55,51,6,93,29,69,86,54,73,24,82,39,32,11,33,9,67,72,12,13,97,49,13,12,36,6,39,76,33,63,49,25,74,69,46,100,58,48,41,46,29,48,32,39,38,96,96,65,50,54,51,42,75,96,58,77,34,3,97,82,13,69,72,81,56,34,79,44,13,24,37,95,61,53,35,69,86,11,64,55,3,91,28,2,1,81,61,2,13,15,2},
                {95,73,96,70,59,11,21,3,4,58,58,51,53,85,20,45,18,53,14,86,39,77,74,27,87,55,78,29,85,58,7,20,83,66,83,8,99,11,62,32,86,30,17,62,55,64,67,3,10,13,45,35,29,60,95,65,61,81,74,38,6,99,58,59,13,53,71,61,18,79,17,51,64,22,85,77,45,61,74,12,69,75,94,62,1,18,20,70,88,34,56,1,2,81,30,70,46,58,97,29},
                {81,11,48,31,19,18,34,82,75,81,38,24,46,36,42,27,53,35,7,45,14,76,99,97,2,27,88,33,71,51,16,65,7,69,75,66,91,96,49,85,34,44,84,27,82,66,20,31,87,12,16,81,52,55,70,5,58,14,72,84,87,35,61,87,42,28,10,63,69,16,13,91,12,71,61,43,59,41,46,19,76,76,90,57,69,68,70,17,17,17,84,35,52,74,28,35,20,75,74,36},
                {26,95,99,48,23,18,52,60,46,44,8,76,100,19,55,69,6,51,87,43,10,15,99,56,30,93,46,78,50,21,2,54,55,12,50,92,100,47,88,22,50,96,49,15,98,100,34,86,5,83,45,94,57,20,15,76,79,69,72,1,8,35,56,76,30,63,93,42,91,97,93,80,41,56,50,32,87,13,38,50,19,44,55,65,36,97,86,29,80,97,56,18,97,71,85,83,24,42,61,91},
                {19,25,33,27,11,54,31,65,8,64,63,33,46,67,96,71,51,91,14,85,99,70,22,83,40,14,57,32,40,4,45,47,37,51,62,48,43,7,83,80,9,73,68,69,44,64,64,27,18,13,48,30,24,2,21,89,12,18,55,52,77,77,8,45,96,39,53,99,93,42,65,76,69,79,23,1,22,72,68,26,84,82,52,81,18,26,4,45,78,38,88,73,9,39,68,39,72,29,76,44},
                {71,76,65,51,90,1,58,80,46,29,21,51,29,80,97,8,64,17,80,28,6,7,73,63,84,98,45,91,90,10,94,37,38,92,8,80,10,66,61,18,92,10,80,18,2,22,32,4,24,95,49,73,50,74,37,51,54,77,83,82,79,32,5,9,14,85,13,20,67,82,90,16,100,69,36,24,4,92,41,25,55,50,75,68,31,24,17,75,31,38,31,41,48,5,57,59,92,32,13,71},
                {64,22,62,13,43,65,42,73,29,60,53,25,19,69,85,55,63,50,36,80,4,81,17,66,78,36,32,35,75,84,24,53,62,57,21,55,75,41,99,73,66,17,80,95,6,90,63,92,20,28,21,18,19,41,85,43,91,75,88,77,57,43,99,21,10,63,23,50,68,98,62,97,4,81,3,80,43,19,16,22,99,76,50,9,89,29,95,84,93,77,63,83,4,81,61,97,69,61,69,67},
                {96,80,94,38,75,56,37,45,78,56,58,97,16,45,25,67,57,99,81,21,91,27,89,6,31,32,14,32,38,46,66,31,19,33,67,85,60,83,55,100,86,48,9,47,95,84,81,54,42,2,27,38,52,39,24,42,93,68,94,14,46,65,99,3,31,87,29,92,28,63,58,26,31,92,39,45,7,5,95,66,84,60,30,47,75,64,38,54,56,39,74,24,45,37,15,7,52,86,1,90},
                {89,81,74,92,86,54,45,12,92,33,61,51,66,70,1,99,45,84,79,87,29,24,39,22,59,79,45,86,67,51,69,76,26,34,37,88,24,28,77,57,30,33,77,85,38,73,22,17,11,15,34,46,57,1,67,18,91,29,21,48,65,98,87,24,78,5,84,72,46,37,71,77,49,44,50,10,8,69,68,90,70,41,97,39,24,73,58,61,14,56,53,71,8,59,96,34,8,50,23,75},
                {66,55,92,77,99,97,84,36,35,94,86,87,42,20,61,2,90,56,59,4,6,26,61,47,7,70,83,34,44,73,30,56,36,47,72,37,67,26,61,19,3,22,33,51,77,5,98,46,75,34,11,42,64,91,87,64,48,43,45,97,38,15,18,19,80,69,54,97,6,42,66,34,65,16,32,24,7,10,44,50,1,70,75,64,53,73,93,43,19,10,7,67,95,5,38,78,80,16,84,29},
                {97,56,68,11,66,56,85,70,94,5,67,46,80,48,21,6,89,83,75,82,85,73,5,22,84,56,5,58,99,2,29,88,37,26,49,5,2,41,46,93,43,63,73,39,52,34,42,9,57,67,46,8,59,59,23,60,56,68,57,19,85,13,96,60,29,48,30,71,47,13,84,100,1,47,49,26,16,43,73,35,9,22,87,73,65,39,84,10,91,49,28,49,81,84,16,54,36,54,93,45},
                {73,45,1,51,58,52,16,23,28,98,79,8,74,51,22,11,76,64,16,18,7,89,40,71,95,46,82,87,47,24,5,73,12,81,17,44,10,46,3,39,4,68,72,95,91,30,91,55,54,57,3,19,7,36,57,48,16,86,95,48,97,33,43,36,28,25,69,14,24,65,26,55,35,54,22,54,91,91,56,44,87,89,34,59,80,78,15,14,91,98,31,45,92,89,11,50,86,39,61,55},
                {74,25,48,71,74,33,5,88,37,15,66,36,65,97,66,64,91,78,98,84,94,10,76,31,33,99,10,25,15,1,23,7,60,16,42,61,51,96,91,29,11,86,38,42,26,81,30,95,8,13,73,66,24,97,1,24,15,82,99,63,2,68,40,96,81,67,84,13,17,68,74,57,88,38,92,17,59,46,82,16,91,29,52,14,9,66,79,53,40,69,4,74,99,92,37,86,38,56,84,25},
                {55,71,18,15,65,11,48,60,38,67,47,80,54,5,100,45,51,35,59,36,34,37,76,45,94,41,27,35,22,66,47,40,31,85,61,3,41,56,32,17,86,72,44,92,69,61,95,78,17,6,7,87,23,39,93,38,83,72,40,54,18,57,35,27,89,73,38,56,85,92,36,21,44,4,58,95,85,29,74,48,30,89,39,3,70,55,72,14,41,78,87,81,95,3,24,77,85,90,47,10},
                {83,62,49,95,50,43,88,24,49,82,44,42,69,67,87,69,28,67,10,14,92,14,19,99,19,32,30,17,85,100,8,11,32,30,19,80,8,2,3,57,6,95,43,62,17,80,9,25,100,37,16,81,96,57,50,36,34,74,43,68,3,97,15,91,79,54,67,57,60,45,18,13,37,76,24,96,80,55,68,52,83,62,78,99,59,90,34,82,25,95,92,66,85,79,18,63,66,62,76,22},
                {4,75,2,39,20,85,84,54,78,56,45,81,81,69,98,17,36,83,27,56,9,4,67,46,56,25,96,33,96,55,96,26,31,90,98,75,89,93,58,100,51,20,85,84,7,38,76,98,1,50,22,96,18,68,87,12,62,40,32,54,54,98,91,4,38,89,77,67,53,87,90,34,64,54,51,12,95,32,5,34,80,24,36,78,58,84,7,70,9,94,7,87,6,77,34,58,20,63,86,35},
                {76,19,20,20,84,59,21,7,70,8,99,16,57,8,33,58,87,82,73,74,93,20,53,15,45,52,88,63,92,22,46,5,44,52,50,48,4,6,88,78,10,40,62,51,72,29,66,28,89,49,61,53,10,66,5,86,44,53,69,89,40,16,1,97,71,10,82,24,63,40,48,85,74,68,4,65,1,23,52,94,80,56,43,26,91,49,62,11,67,89,19,49,31,67,86,18,4,62,37,27},
                {23,96,89,85,53,96,14,89,4,86,11,40,62,4,29,64,36,83,48,64,59,89,86,91,75,73,15,24,83,53,67,93,12,54,98,8,88,18,18,65,10,76,63,39,99,31,10,42,24,51,70,19,100,42,62,1,30,94,41,86,95,5,63,47,49,20,25,94,80,20,10,62,92,62,1,46,99,81,74,6,22,74,99,32,67,100,3,21,17,65,1,59,57,37,83,14,20,39,90,50},
                {47,38,93,63,45,64,45,43,96,27,43,79,17,69,87,77,87,96,45,14,55,8,29,65,75,96,33,57,83,68,93,99,69,76,26,34,14,89,77,92,26,40,14,84,36,51,68,99,14,96,90,28,6,85,55,92,40,36,49,42,32,88,91,50,90,15,49,80,62,65,24,99,1,28,65,63,38,29,71,51,20,58,92,39,20,99,5,51,81,40,67,40,89,38,1,10,45,82,92,58},
                {76,17,47,96,77,62,68,38,74,57,41,39,89,68,43,79,23,22,85,66,38,84,39,14,74,9,56,79,67,23,77,34,8,50,13,9,77,99,20,81,92,31,49,8,62,99,27,43,75,18,91,96,22,82,9,76,55,79,22,3,56,23,73,19,46,87,22,8,83,52,92,50,68,46,92,15,30,40,32,24,51,76,97,70,5,24,86,70,19,61,47,27,29,17,29,43,44,58,57,7},
                {12,88,28,48,42,47,67,50,18,59,93,72,96,46,69,7,53,73,43,93,22,99,28,91,3,54,30,72,7,85,93,38,95,86,92,93,100,48,2,12,16,76,83,85,28,21,45,47,23,62,71,9,71,37,52,31,30,53,100,47,81,99,37,5,24,2,19,93,33,37,9,94,10,8,7,34,21,15,32,49,26,36,99,73,4,99,21,48,13,69,74,90,4,100,13,100,4,6,20,18},
                {3,39,41,69,74,94,38,57,33,36,38,99,15,37,90,7,24,91,8,10,66,62,95,74,60,3,81,17,39,17,16,19,52,61,66,62,20,36,18,14,87,80,40,52,2,76,94,60,13,31,17,25,89,76,6,59,40,57,8,28,54,85,46,90,7,75,35,71,26,84,33,48,10,99,85,76,21,78,24,49,77,14,78,59,69,94,72,71,18,74,20,39,38,23,17,39,33,50,70,34},
                {74,13,79,55,80,31,55,21,9,25,76,4,61,16,3,71,6,54,22,55,25,100,28,67,61,59,83,54,58,11,84,84,92,94,48,31,40,13,75,93,48,18,94,91,97,72,19,96,13,54,91,46,40,40,94,40,29,5,58,82,75,62,28,27,2,34,32,86,65,68,1,21,65,20,11,66,81,83,59,6,12,21,31,23,16,97,35,61,79,92,54,33,35,65,11,6,100,31,76,75},
                {29,22,12,71,47,83,61,24,53,95,5,48,1,85,57,86,3,99,27,91,72,56,49,31,36,2,46,49,33,31,26,21,41,81,72,36,28,5,35,24,85,83,6,18,77,57,5,75,73,31,5,66,75,8,78,64,42,46,15,23,20,3,15,46,68,14,32,41,61,88,16,76,50,13,30,79,31,61,41,46,78,52,8,81,25,95,16,10,19,66,69,40,74,33,75,42,41,29,60,54},
                {44,89,15,91,54,3,44,94,94,88,95,24,29,43,16,60,34,48,2,87,30,91,47,31,100,88,58,70,86,40,21,73,92,29,87,58,20,45,23,22,84,67,97,35,17,8,99,20,67,51,33,94,36,84,34,39,5,58,55,83,51,99,30,75,38,6,58,35,31,58,10,58,97,36,54,59,53,66,92,17,30,84,37,42,40,67,28,69,21,4,63,80,96,49,11,32,61,23,92,27},
                {74,50,13,36,42,34,62,4,13,45,46,64,3,72,18,34,61,39,93,58,86,49,61,21,66,22,80,40,68,55,82,85,81,50,78,47,67,26,76,74,48,8,16,46,50,5,77,33,87,38,56,86,75,83,25,44,76,93,51,38,83,54,8,93,17,19,31,75,43,46,57,63,57,16,15,31,73,99,47,72,15,88,56,23,25,60,71,34,45,13,45,19,53,92,48,38,88,39,49,4},
                {1,10,26,11,32,38,41,17,88,82,75,13,61,32,85,69,92,27,93,31,75,80,52,19,55,20,95,68,39,34,30,58,40,3,92,67,51,82,92,7,20,1,15,86,83,69,74,87,28,62,97,65,99,66,22,4,76,89,94,43,64,9,52,38,12,90,14,19,37,3,25,45,34,27,95,86,59,98,3,72,84,2,51,28,79,64,72,13,46,34,59,8,91,74,33,77,66,2,88,97},
                {94,46,71,64,38,39,61,26,59,46,26,29,52,80,64,23,78,77,78,61,88,6,81,78,47,74,10,52,24,51,42,95,38,65,29,46,47,47,91,97,40,47,2,44,22,31,70,94,90,92,9,40,65,76,80,8,86,20,44,92,58,46,4,17,49,90,46,51,38,42,86,37,94,31,51,68,5,99,75,94,76,97,56,12,25,34,84,67,40,3,31,22,75,26,54,90,61,99,78,19},
                {14,98,23,43,30,6,34,80,91,95,95,54,47,60,80,59,60,13,99,47,25,17,44,30,34,45,87,34,41,5,36,60,52,76,63,36,3,15,95,87,21,24,60,4,74,52,74,92,85,41,13,47,62,22,6,35,66,59,91,3,82,30,73,56,85,36,2,8,76,91,1,17,27,83,87,97,22,27,53,10,86,47,64,92,23,9,83,52,21,25,80,53,82,34,26,26,13,3,83,16},
                {38,82,95,48,40,93,29,59,44,74,77,31,15,52,76,57,86,84,92,78,37,66,87,28,66,34,24,44,51,39,61,4,83,31,43,45,92,58,45,63,22,24,96,52,40,32,89,20,59,4,45,85,90,31,21,13,100,45,7,88,24,57,10,70,14,92,62,79,61,28,13,2,81,40,41,93,96,11,15,27,15,44,84,52,53,12,25,5,63,21,67,91,73,86,23,43,89,12,62,23},
                {28,83,92,80,53,93,100,49,92,15,43,16,48,88,79,31,100,100,8,43,75,18,63,33,29,28,46,94,61,77,82,88,35,38,8,19,11,95,7,11,29,58,18,36,22,41,29,45,21,77,52,21,91,4,1,22,36,82,21,34,56,44,32,69,65,85,3,5,98,53,60,37,98,62,80,70,69,84,38,48,26,2,58,38,6,93,5,85,9,13,31,93,59,98,65,47,23,12,99,73},
                {51,67,95,83,14,91,1,33,3,57,29,91,73,65,19,39,31,99,12,98,21,58,93,68,12,15,16,9,72,83,98,80,79,81,44,80,17,78,6,19,65,30,75,80,58,14,3,8,29,9,35,7,83,92,25,37,54,71,55,40,10,74,75,33,90,72,77,57,61,36,97,77,75,4,83,20,61,73,93,24,70,90,8,89,25,10,60,6,5,53,83,63,94,90,81,10,62,86,68,100},
                {62,17,38,25,7,13,38,80,70,9,29,75,16,8,76,44,43,85,55,83,9,80,12,34,59,88,96,11,87,76,17,53,42,6,87,63,62,37,30,44,15,88,99,55,96,29,82,10,18,81,6,34,85,90,61,76,41,45,47,18,86,14,80,96,59,86,79,27,67,7,35,45,74,10,61,21,79,72,93,27,27,20,80,90,62,76,70,8,34,91,82,28,5,95,84,36,20,54,24,19},
                {37,21,35,95,34,52,60,47,69,58,94,90,40,10,81,30,29,60,26,8,38,39,96,1,59,18,94,92,12,73,77,44,3,68,25,33,28,44,21,94,26,8,13,35,6,60,37,73,8,67,44,78,35,53,2,11,32,28,35,93,38,5,12,90,51,64,31,73,90,12,100,30,88,44,19,41,16,12,14,67,12,2,66,79,59,10,5,73,20,39,21,31,20,95,52,74,38,72,19,80},
                {17,40,67,48,53,12,95,15,6,90,62,6,44,8,17,97,60,28,69,80,94,92,54,70,50,82,97,9,42,15,72,55,95,90,15,19,63,90,31,97,80,24,35,97,67,48,44,63,9,83,76,21,10,3,17,86,43,23,92,23,6,53,88,73,5,81,49,100,54,97,4,35,72,69,36,97,1,70,74,20,1,91,12,51,1,97,58,39,29,25,10,30,36,68,58,72,95,46,89,58},
                {90,98,100,50,61,44,100,25,63,25,30,23,85,30,57,97,97,87,61,88,60,76,10,99,45,72,9,40,76,35,8,96,40,56,24,6,56,42,87,93,28,23,100,71,28,48,59,79,19,100,75,13,52,45,85,47,40,36,63,23,9,64,19,53,97,50,14,39,30,2,86,28,91,44,49,43,40,28,15,35,14,61,28,30,98,37,40,71,99,74,28,97,75,35,66,5,10,12,47,42},
                {62,52,55,98,6,60,23,19,10,27,19,85,77,75,21,21,26,87,100,38,49,19,5,44,22,97,60,91,27,49,46,76,78,28,66,9,8,80,71,30,80,42,69,33,36,67,7,16,12,80,96,22,79,6,65,70,12,77,15,29,51,9,100,87,91,72,61,12,11,84,41,20,64,66,68,2,37,97,95,34,44,72,51,66,18,19,68,33,42,2,6,96,98,40,3,2,31,46,14,74},
                {85,11,5,75,77,18,99,14,91,98,75,60,52,2,51,36,59,33,49,6,15,51,51,91,77,58,48,90,56,4,27,71,29,65,52,60,51,75,51,41,39,25,32,59,48,10,42,36,94,22,97,27,34,76,58,36,94,53,2,94,98,26,9,19,27,25,79,20,66,58,59,29,72,62,9,33,4,33,50,78,87,100,85,89,15,91,45,54,25,51,68,4,56,20,3,77,52,34,11,78},
                {43,89,97,92,94,87,15,66,65,68,25,33,79,16,74,6,1,58,55,78,41,5,96,26,28,69,67,8,9,24,95,4,92,16,5,19,44,18,56,65,32,59,62,14,1,50,98,3,75,43,27,20,25,26,83,54,90,49,93,46,59,72,37,27,61,41,9,44,30,22,73,32,94,50,9,9,76,3,66,7,85,21,31,77,78,59,91,28,82,83,33,73,94,96,6,49,85,99,12,17},
                {68,82,76,58,15,78,78,47,11,5,1,85,78,99,83,37,77,22,60,80,25,80,39,7,26,55,3,7,25,5,27,17,49,81,31,20,40,66,10,65,55,25,27,23,75,48,59,80,7,1,79,55,50,37,92,77,61,62,23,84,94,86,22,64,39,28,5,99,44,99,38,48,70,90,36,86,29,11,9,87,7,3,41,56,60,100,90,50,50,99,66,45,26,83,86,62,98,11,62,3},
                {26,14,19,37,71,52,53,49,31,96,41,72,38,45,21,33,9,34,78,76,61,72,89,57,29,74,45,13,65,85,43,95,33,100,21,40,39,60,87,8,43,22,53,90,52,1,10,7,12,35,97,66,68,16,90,23,71,62,18,75,69,41,46,48,65,86,15,18,79,57,79,30,86,75,97,8,67,53,34,29,10,71,46,16,99,8,3,67,97,64,100,73,58,5,4,94,1,33,75,94},
                {61,11,89,10,88,36,6,95,75,85,6,19,56,88,81,84,67,54,26,39,72,4,82,30,14,85,42,99,83,7,33,49,34,25,91,29,92,53,52,12,94,71,87,94,10,27,41,76,33,39,60,66,30,44,76,100,8,72,18,54,38,93,91,74,70,26,31,25,1,19,24,100,89,72,12,55,19,46,78,70,8,51,60,73,34,43,32,62,70,67,31,4,14,26,58,74,26,72,84,58}};


        // Given target sum
        int K = 7888;

        // Function Call
        findMaxMatrixSize(x, K);
    }

}
