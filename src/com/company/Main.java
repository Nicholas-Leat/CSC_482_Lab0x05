package com.company;
import java.math.BigInteger;

public class Main {
    static int trialnum = 100;
    static int mxTime = 20000000;
//********************Biginteger class*****************************
    public static class MyBigInteger{
        String Value;
        //constructor
        MyBigInteger(String val){
            Value = val;
        }
        //returns a string representation of the integer
        String Value(){
            return Value;
        }
        //returns first 5 and last 5 digits or up to all 11 digits
        String AbbreviatedValue(){
            String returnVal = " ";
            if(Value.length() < 12){
                return Value;
            }else{
                returnVal = Value.substring(Value.length()-5) + Value.substring(0,4);
            }

            return returnVal;
        }
        //returns a new biginteger with value of this.value + x.value
        MyBigInteger Plus(MyBigInteger x){
            MyBigInteger ret = new MyBigInteger(" ");
            ret.Value = Integer.toString(Integer.parseInt(x.Value) +Integer.parseInt(Value));

            return ret;
        }
        //returns a new biginteger with value of this.value * x.value
        MyBigInteger Times(MyBigInteger x){
            MyBigInteger ret = new MyBigInteger(" ");
            ret.Value = Integer.toString(Integer.parseInt(x.Value) * Integer.parseInt(Value));

            return ret;
        }
}
//*****************************************************************
//********************Fibonacci functions**************************
    public static BigInteger fibRecur(BigInteger x){
        BigInteger retval = new BigInteger(" ");
        if(x <=1){
            return x;
        }else{
            BigInteger temp = new BigInteger(" ");
            BigInteger temp2 = new BigInteger(" ");


        }


    }
    public static BigInteger fibCache(BigInteger x){

    }
    public static BigInteger fibCacheHelp(BigInteger x){

    }
    public static BigInteger fibLoop(BigInteger x){

    }
    public static BigInteger fibMatrix(BigInteger x){
        BigInteger F[][] = new BigInteger[][]{{BigInteger.valueOf(1),BigInteger.valueOf(1)},{BigInteger.valueOf(1),BigInteger.valueOf(0)}};
        if(x.equals(BigInteger.ZERO)){
            return BigInteger.ZERO;
        }
    }
    public static void power(BigInteger x, long y){

    }
    public static void multiply(BigInteger x, BigInteger y){

    }
//*****************************************************************
    public static void main(String[] args) {
	// write your code here

        return;
    }

}
