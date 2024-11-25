class Solution {
    int getValue(char c) {
        return c - '0';
    }

    public int myAtoi(String s) {
        long temp = 0;
        boolean isPositive = true;
        int n = s.length();
        int i = 0;
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        if (i < n) {
            if (s.charAt(i) == '-') {
                isPositive = false;
                i++;
            } else if (s.charAt(i) == '+') {
                i++;
            }
        }

        for (; i < n; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                temp = temp * 10 + getValue(c);
            } else {
                break;
            }
            if (!isPositive && (temp*-1) <= Integer.MIN_VALUE || isPositive && temp >= Integer.MAX_VALUE) {
                return (isPositive) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        if ((!isPositive && temp > 0)) {
            temp = -1 * temp;
        }

        return (int) temp;
    }
}