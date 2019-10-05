class Solution {
    public String convert(String s, int numRows) {
        int len = s.length();
        String newStr = "";
        // System.out.println(newStr);
        int col = 0;
        int index1 = 0;
        int index2 = 0;
        
        //一定要考虑这种特殊情况
        if (numRows == 1) {
            return s;
        }
        
        for (int i = 0; i < numRows; i++ ) {
            if (i == 0) {
                col = 0;
                index1 = col * (2 * numRows - 2);
                while (index1 < len) {                                        
                    newStr += s.charAt(index1);
                    // System.out.println(newStr);
                    col++;
                    index1 = col * (2 * numRows - 2);
                }
            } else if (i == numRows - 1) {
                col = 0;
                index1 = col * (2 * numRows - 2) + i;
                while (index1 < len) {
                    newStr += s.charAt(index1);
                    col++;
                    index1 = col * (2 * numRows - 2) + i;
                }
            } else {
                col = 0;
                index1 = col * (2 * numRows - 2) + i;
                index2 = (col + 1) * (2 * numRows - 2) - i;
                while (index1 < len) {                
                    newStr += s.charAt(index1);
                    if (index2 < len) {
                        newStr += s.charAt(index2);
                    }
                    col++;
                    index1 = col * (2 * numRows - 2) + i;
                    index2 = (col + 1) * (2 * numRows - 2) - i;
                }
            }
        }
        return newStr;
    }
}

//参考答案
class Solution {
    public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}

//看参考答案后自己写的答案
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> ans = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            ans.add(new StringBuilder());
        }
        boolean goingDown = false;
        int curRow = 0;
        
        for (char ch : s.toCharArray()) {
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            ans.get(curRow).append(ch);
            curRow += goingDown? 1 : -1;                        
        }
        
        String result = "";
        for (StringBuilder sb : ans) {
            result += sb.toString();
        }
        return result;
    }
}
