class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            if (stack.empty()) {
                stack.add(i);
            } else {
                if (heights[stack.peek()] < heights[i]) {
                    stack.push(i);
                } else {
                    while (!stack.empty() && heights[stack.peek()] >= heights[i]) {
                        int idx = stack.peek();
                        stack.pop();
                        int lidx = stack.empty() ? -1 : stack.peek();
                        int currArea = (i - lidx - 1) * heights[idx];
                        maxArea = Math.max(currArea, maxArea);
                    }
                    stack.push(i);
                }
            }
        }
        int n = heights.length;
        while (!stack.empty()) {
            int idx = stack.peek();
            stack.pop();
            int lidx = stack.empty() ? -1 : stack.peek();
            int currArea = (n - lidx - 1) * heights[idx];
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }
}