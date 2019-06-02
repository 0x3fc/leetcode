package InsertDeleteGetRandomO1;

import java.util.*;

class RandomizedSet {
    Map<Integer, Integer> m;
    List<Integer> l;
    Random rand;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        m = new HashMap<>();
        l = new ArrayList<>();
        rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (m.containsKey(val)) {
            return false;
        }

        m.put(val, l.size());
        l.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if (!m.containsKey(val)) {
            return false;
        }

        int i = m.get(val);

        if (i < l.size() - 1) {
            int last = l.get(l.size() - 1);
            m.put(last, i);
            l.set(i, last);
        }

        l.remove(l.size() - 1);
        m.remove(val);

        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return l.get(rand.nextInt(l.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); int param_3 = obj.getRandom();
 */
