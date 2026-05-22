class Solution {
    public int[] solution(String[] wallpaper) {
        int minY = 51;
        int maxY = 0;
        int minX = 51;
        int maxX = 0;
        for (int i=0; i<wallpaper.length; i++) {
            for (int j=0; j<wallpaper[i].length(); j++) {
                if (wallpaper[i].charAt(j) == '#') {
                    if (minY > i) {
                        minY = i;
                    }
                    if (maxY < i) {
                        maxY = i;
                    }
                    if (minX > j) {
                        minX = j;
                    }
                    if (maxX < j) {
                        maxX = j;
                    }
                }
            }
        }
        
        return new int[]{minY, minX, maxY+1, maxX+1};
    }
}