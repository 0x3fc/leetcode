package ProductOfTheLastKNumbers;

import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    private int count = 0;
    private List<Integer> prods = new ArrayList<>();

    public ProductOfNumbers() {
        prods.add(1);
    }
    
    public void add(int num) {
        if (num == 0) {
            count = 0;
            prods.add(1);
            return;
        }

        prods.add(prods.get(prods.size() - 1) * num);
        count++;
    }
    
    public int getProduct(int k) {
        if (k > count) return 0;

        int lastIndex = prods.size() - 1;

        return prods.get(lastIndex) / prods.get(lastIndex - k);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
