class Solution {
    class UnionFind {
        private Map<Integer, Integer> parent;

        public UnionFind() {
            parent = new HashMap<>();
        }

        public int find(int x) {
            if (parent.get(x) != x) {
                parent.put(x, find(parent.get(x))); // Path compression
            }
            return parent.get(x);
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent.put(rootY, rootX);
            }
        }

        public void add(int x) {
            if (!parent.containsKey(x)) {
                parent.put(x, x);
            }
        }

        public int getUniqueRootsCount() {
            Set<Integer> uniqueRoots = new HashSet<>();
            for (int key : parent.keySet()) {
                uniqueRoots.add(find(key));
            }
            return uniqueRoots.size();
        }
    }

    public int removeStones(int[][] stones) {
        UnionFind uf = new UnionFind();

        for (int[] stone : stones) {
            int row = stone[0];
            int col = ~stone[1]; // Use ~ to differentiate row and column indices
            uf.add(row);
            uf.add(col);
            uf.union(row, col);
        }

        // Number of connected components
        return stones.length - uf.getUniqueRootsCount();
        
    }
}