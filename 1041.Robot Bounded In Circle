class Solution {
  private static final int[][] DIR = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
  public boolean isRobotBounded(String instructions) {
    if (instructions == null || instructions.length() == 0) return true;
    char[] arr = instructions.toCharArray();
    int direction = 0;
    int[] pos = {0, 0};
    for (int i = 0; i < arr.length; i++) {
      int index = direction % 4;
      if (index < 0) {
        index += 4;
      }
      if (arr[i] == 'G') {
        pos[0] += DIR[index][0];
        pos[1] += DIR[index][1];
      } else if (arr[i] == 'L') {
        direction--;
      } else {
        direction++;
      }
    }
    return direction % 4 != 0 || (pos[0] == 0 && pos[1] == 0);
  }
}
