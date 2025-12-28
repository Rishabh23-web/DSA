class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack <Integer> stk = new Stack<>();
        int n=heights.length;
        int maxArea = 0;
        for(int i=0;i<=n;i++){
            while(!stk.isEmpty() && (i==n || heights[stk.peek()]>= (i<n? heights[i]:0))){
                int element = heights[stk.pop()];
                int width;
                if(stk.isEmpty()){
                    width = i;
                }else{
                    width = i-stk.peek()-1;
                }maxArea = Math.max(maxArea,element*width);
            }
            stk.push(i);
        }
        return maxArea;
    }
}