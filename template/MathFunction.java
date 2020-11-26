public class MathFunction {

    public long factorial(long n){
        if(n == 0)
            return 1;
        long result = 1;
        for(int i = 2; i < n; i++)
            result *= i;
        return result;
    }

    public int factorial(int n){
        if(n == 0)
            return 1;
        int result = 1;
        for(int i = 2; i < n; i++)
            result *= i;
        return result;
    }
}
