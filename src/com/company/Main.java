package com.company;
import jdk.jfr.Unsigned;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.math.BigInteger;
import java.util.Random;

public class Main {
    static int trialnum = 100;
    static double mxTime = 2000000;
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
    /**
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
//*****************************************************************/
    public static void main(String[] args) {
	// write your code here
        bigIntResults();

        return;
    }
//********************Results for Big integer**********************
    public static void bigIntResults(){
        long N[] = new long[10000];
        String x1[] = new String[10000];
        String x2[] = new String[10000];
        double addTime[] = new double[10000];
        double multTime[] = new double[10000];
        double dr[] = new double[10000];
        double expdr[] = new double[10000];
        double mdr[] = new double[10000];
        double mexpdr[] = new double[10000];
        long NVal = 1;
        boolean contrun = true;
        String temp;
        int val;
        int count = 0;
        double before;
        double after;

        while(contrun){
            N[count] = NVal;
            val = ((int) new Random().nextInt());
            val = val %10;
            temp = Integer.toString(val);
            for(int i =1; i < NVal; i++){
                val = ((int) new Random().nextInt());
                val = val %10;
                while(val < 0){
                    val = ((int) new Random().nextInt());
                    val = val %10;
                }
                temp = temp + val;
            }
            System.out.println(temp);
            x1[count] = temp;
            val = ((int) new Random().nextInt());
            val = val %10;
            temp = Integer.toString(val);
            for(int i =1; i < NVal; i++){
                val = ((int) new Random().nextInt());
                val = val %10;
                while(val < 0){
                    val = ((int) new Random().nextInt());
                    val = val %10;
                }
                temp = temp + val;
            }
            x2[count] = temp;
            MyBigInteger num1 = new MyBigInteger(x1[count]);
            MyBigInteger num2 = new MyBigInteger(x2[count]);
            before = getCpuTime();
            //MyBigInteger num3 = num1.Plus(num2);
            after = getCpuTime();
            addTime[count] = after - before;

            before = getCpuTime();
            //num3 = num1.Times(num2);
            after = getCpuTime();
            multTime[count] = after - before;

            if(NVal == 1){
                dr[count] = 0.0;
                expdr[count] = 0.0;
                mdr[count] = 0.0;
                mexpdr[count] = 0.0;
            }else{
                dr[count] = addTime[count]/addTime[count-1];
                mdr[count] = multTime[count]/multTime[count-1];
            }

            if(addTime[count] > mxTime || multTime[count] > mxTime){
                contrun = false;
            }
            System.out.printf("N = %d \t x1 = %s \t x2 = %s \t add Time = %f \t MultTime = %f \t dr = %f \t expdr = %f \t mdr = %f \t mexpdr = %f\n",NVal, x1[count], x2[count], addTime[count], multTime[count],dr[count],expdr[count],mdr[count],mexpdr[count]);
            count++;
            NVal = NVal * 2;
        }


    }
    public static long getCpuTime( ) {

        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );

        return ((ThreadMXBean) bean).isCurrentThreadCpuTimeSupported( ) ?

                bean.getCurrentThreadCpuTime( ) : 0L;

    }

}
