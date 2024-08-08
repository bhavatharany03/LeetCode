class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int rowbegin = 0;
        int rowend = matrix.length-1;
        int colbegin = 0;
        int colend = matrix[0].length-1;

        if(matrix.length == 0){
            return ans;
        }

        while(rowbegin <=rowend && colbegin <= colend){
            for(int j = colbegin;j<=colend;j++){
                ans.add(matrix[rowbegin][j]);
            }
            rowbegin++;

            for(int j=rowbegin;j<=rowend;j++){
                ans.add(matrix[j][colend]);
            }
            colend--;

            if(rowbegin <= rowend){
            for(int j=colend;j>=colbegin;j--){
                ans.add(matrix[rowend][j]);
            }
            }
            rowend--;

            if(colbegin <= colend){
            for(int j=rowend;j>=rowbegin;j--){
                ans.add(matrix[j][colbegin]);
            }
            }
            colbegin++;

        }

        return ans;

    }
}