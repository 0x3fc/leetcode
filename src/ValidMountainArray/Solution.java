package ValidMountainArray;

class Solution {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3 || arr[0] >= arr[1])
            return false;

        int i = 1;
        while (i < arr.length - 1) {
            if (arr[i] == arr[i + 1])
                return false;
            if (arr[i] > arr[i + 1])
                break;
            i++;
        }

        if (i == arr.length - 1 && arr[i - 1] < arr[i])
            return false;

        while (i < arr.length - 1) {
            if (arr[i] <= arr[i + 1])
                return false;
            i++;
        }

        return true;
    }
}
