package com.thoughtworks.tddintro.factorial;

public class Factorial {
    public Integer compute(int i) {
        int fact;
        if (i<0){
            throw new IllegalArgumentException("Negative argument is not valid");
        }
        if (i <= 1)
        {
           fact = 1;
        }else{
           //fact = 2 *compute(1);
           fact = i*compute(i-1);
        }
        return fact;
    }
}
