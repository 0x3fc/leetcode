package IntersectionOfTwoArraysII;

import java.util.*;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;
        int count = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                nums1[count++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] res = new int[count];

        for (int k = 0; k < count; k++) {
            res[k] = nums1[k];
        }

        return res;
    }

    public int[] intersect2(int[] nums1, int[] nums2) {
        if (nums1.length < 1 || nums2.length < 1) {
            return new int[] {};
        }

        Map<Integer, Integer> seen = new HashMap<>();

        for (int num : nums1) {
            if (!seen.containsKey(num)) {
                seen.put(num, 0);
            }

            seen.put(num, seen.get(num) + 1);
        }

        List<Integer> intersects = new ArrayList<>();

        for (int num : nums2) {
            if (!seen.containsKey(num) || seen.get(num) < 1) {
                continue;
            }

            intersects.add(num);
            seen.put(num, seen.get(num) - 1);
        }

        int[] res = new int[intersects.size()];

        for (int i = 0; i < intersects.size(); i++) {
            res[i] = intersects.get(i);
        }

        return res;
    }
}
