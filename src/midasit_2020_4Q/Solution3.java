package midasit_2020_4Q;

import java.util.LinkedList;
import java.util.List;

public class Solution3 {

    private int boxSize;
    private List<List<Integer>> valiableCookies = new LinkedList<>();
    private int maxLength;

    public int[] solution(int[] cookies, int k) {

        boxSize = cookies.length;
        for (int i = 0; i < cookies.length; i++) {
            List<Integer> tmpList = new LinkedList<>();
            tmpList.add(cookies[i]);
            search(i, cookies, tmpList);
        }

        valiableCookies.sort((list1, list2) -> {
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) != list2.get(i)) {
                    return list1.get(i) - list2.get(i);
                }
            }
            return 0;
        });

        System.out.println(valiableCookies);
        return valiableCookies.get(k - 1).stream().mapToInt(i -> i).toArray();
    }

    public void search(int index, int[] orgCookies, List<Integer> canEatCookies) {

        for (int i = index + 1; i < boxSize; i++) {
            if (orgCookies[i] > orgCookies[index]) {
                List<Integer> tmpList = new LinkedList<>();
                tmpList.addAll(canEatCookies);
                tmpList.add(orgCookies[i]);
                search(i, orgCookies, tmpList);
                tmpList.remove(tmpList.size() - 1);
            }
        }

        List<Integer> finalList = new LinkedList<>();
        finalList.addAll(canEatCookies);

        maxLength = Math.max(finalList.size(), maxLength);
        if (finalList.size() >= maxLength) {
            valiableCookies.add(finalList);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 6, 5, 3};
        new Solution3().solution(arr, 2);
    }
}