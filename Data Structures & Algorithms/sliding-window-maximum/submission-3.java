

class SegmentTree {
    int n;
    int[] tree;

    SegmentTree(int N, int[] A) {
        this.n = N;
        // Step 1: Round up n to the next power of 2 for a perfect tree
        while (Integer.bitCount(n) != 1) {
            n++;
        }
        build(N, A);
    }

    void build(int N, int[] A) {
        // Step 2: Create array of size 2n. Index 0 is unused.
        tree = new int[2 * n];
        Arrays.fill(tree, Integer.MIN_VALUE);

        // Step 3: Put original data into the "Ground Floor" (indices n to 2n-1)
        for (int i = 0; i < N; i++) {
            tree[n + i] = A[i];
        }

        // Step 4: Build the "Upper Floors" by picking the max of two children
        for (int i = n - 1; i > 0; i--) {
            int leftChild = 2 * i;
            int rightChild = 2 * i + 1;
            tree[i] = Math.max(tree[leftChild], tree[rightChild]);
        }
    }

    int query(int l, int r) {
        int res = Integer.MIN_VALUE;

        // Step 5: Move search range to the Ground Floor
        l += n;
        r += n;

        // Step 6: Climb the tree
        while (l <= r) {
            // If l is a right-hand child (ODD), its left sibling is out of range
            if (l % 2 == 1) {
                res = Math.max(res, tree[l]);
                l++; // Move inward
            }
            // If r is a left-hand child (EVEN), its right sibling is out of range
            if (r % 2 == 0) {
                res = Math.max(res, tree[r]);
                r--; // Move inward
            }

            // Move both pointers up one floor (divide by 2)
            l = l / 2;
            r = r / 2;
        }
        return res;
    }
}

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        
        int n = nums.length;
        SegmentTree segTree = new SegmentTree(n, nums);
        
        // Step 7: Slide the window and query the tree for each range
        int[] output = new int[n - k + 1];
        for (int i = 0; i <= n - k; i++) {
            // Query range [i, i + k - 1]
            output[i] = segTree.query(i, i + k - 1);
        }
        
        return output;
    }
}