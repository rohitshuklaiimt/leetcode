class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions);

        int n = spells.length;
        int ans[] = new int[n]; 
        // For each spell, find the minimum potion index that makes product >= success
        for (int i = 0; i < n; i++) {


            int index = getMinPotion(spells[i], potions, success);

            // All potions from 'index' to end of array form successful pairs
            ans[i] = potions.length - index;
        }

        return ans;
    }

    // Finds the smallest index in 'potions' such that potions[index] * spell >= success
    // Returns potions.length if no such potion exists
    int getMinPotion(int spell, int[] potions, long success) {
        int left = 0, right = potions.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;


            if ((long) potions[mid] * spell >= success) {
                // This potion works, but check if there's a smaller index that also works
                right = mid - 1;
            } else {

                left = mid + 1;
            }
        }

        // 'left' will point to the first valid potion index or potions.length if none is valid
        return left;
    }
}