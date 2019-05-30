package IntersectionOfTwoArrays;

import java.util.*;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();

        for (int n : nums1) {
            s1.add(n);
        }

        Set<Integer> s2 = new HashSet<>();

        for (int n : nums2) {
            s2.add(n);
        }

        return s1.size() < s2.size() ? findIntersection(s1, s2) : findIntersection(s2, s1);
    }

    public int[] findIntersection(Set<Integer> s1, Set<Integer> s2) {
        List<Integer> intersects = new ArrayList<>();

        for (int n : s1) {
            if (s2.contains(n)) {
                intersects.add(n);
            }
        }

        int[] res = new int[intersects.size()];

        for (int i = 0; i < intersects.size(); i++) {
            res[i] = intersects.get(i);
        }

        return res;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int n : nums1) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }

        boolean[] seen = new boolean[max - min + 1];

        for (int n : nums1) {
            seen[n - min] = true;
        }

        int[] intersections = new int[max - min + 1];

        int iter = 0;

        for (int n : nums2) {
            if (n >= min && n <= max && seen[n - min]) {
                intersections[iter++] = n;
                seen[n - min] = false;
            }
        }

        int[] res = new int[iter];

        for (int i = 0; i < iter; i++) {
            res[i] = intersections[i];
        }

        return res;
    }
}
