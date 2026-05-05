class Solution {
    public int maxArea(int[] heights) {
        
        // [1, 7, 2, 5, 4, 7, 3, 6]
        // Potrei usare i two pointers alla ricerca di 
        // A destra: l'ultimo numero più grande prima di diminuire
        // A sinistra: il primo numero più grande prima di diminuire

        // Poi prendo il minore degli estremi e lo moltiplico per il numero di slot presi

        int l = 0;
        int r = heights.length - 1;

        int maxArea = 0;
        while (l < r) {

            int area = Math.min(heights[l], heights[r]) * (r - l);
            if (area > maxArea) maxArea = area;

            if (heights[l] > heights[r]) r--;
            else l++;
        }

        return maxArea;
    }
}
