package LengthOfLastWord;

class Solution {
    public int lengthOfLastWord(String s) {
        char[] arr = s.toCharArray();
        int i = arr.length - 1;

        while (i >= 0 && arr[i] == ' ')
            i--;

        if (i < 0)
            return 0;

        int count = 0;
        while (i >= 0 && arr[i] != ' ') {
            i--;
            count++;
        }

        return count;
    }
}
