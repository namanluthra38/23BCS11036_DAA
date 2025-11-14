
public class Main {
    double helper(double x, int n){
        if(n==1) return x;
        if(n%2==0) return helper(x*x,n/2);
        return x * helper(x*x,n/2);
    }
    public double myPow(double x, int n) {
        if(n==0 || x==1) return 1;
        if(x==-1) return (n%2==0)?1:-1;
        if(n==1) return x;
        if(n<0){
            if(n==Integer.MIN_VALUE) return 0;
            return helper(1/x,-n);
        }
        return helper(x,n);        
    }
}
