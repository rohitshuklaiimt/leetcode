class Solution {
    public double largestTriangleArea(int[][] points) {
        double max_area = 0;
        int len = points.length;
        double a=0,b=0,c=0,S=0;
        
        for(int i=0;i<len;++i){
            for(int j=i+1;j<len;++j){
                for(int k=j+1;k<len;++k){
                    a = euclideanDistance(points[i],points[j]);
                    b = euclideanDistance(points[j],points[k]);
                    c = euclideanDistance(points[k],points[i]);
                    
                    if(isValidTriangle(a,b,c)){
                        S = (a + b + c) / 2;
                        max_area = Math.max(max_area,Math.sqrt(S*(S-a)*(S-b)*(S-c)));
                    }                    
                }
            }
        }        
        
        return max_area;
    }
    
    private double euclideanDistance(int[] p1,int[] p2){
        int x = p1[0]-p2[0];
        int y = p1[1] - p2[1];
        return Math.sqrt(x*x + y*y);
    }
    
    private boolean isValidTriangle(double a,double b,double c){
        return a+b > c && b+c > a && c+a > b;
    }
}