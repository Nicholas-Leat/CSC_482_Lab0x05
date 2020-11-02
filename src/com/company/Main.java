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

    public static BigInteger fibLoop(int x){
        BigInteger t1 = new BigInteger("0");
        BigInteger t2 = new BigInteger("1");
        BigInteger sum = new BigInteger("0");
        t1.valueOf(0);
        t2.valueOf(1);
        if(x == 0){
            return BigInteger.ZERO;
        }

        for(int i = 2; i <= x; i++){
            sum = t1.add(t2);
            t1 = t2;
            t2 = sum;
        }
        return t2;

    }
    public static BigInteger fibMatrix(int x){
        BigInteger F[][] = new BigInteger[][]{{BigInteger.ONE,BigInteger.ONE},{BigInteger.ONE,BigInteger.ZERO}};
        if(x == 0){
            return BigInteger.ZERO;
        }
        power(F,x-1);

        return F[0][0];
    }
    public static void power(BigInteger F[][], int x){
        BigInteger M[][] = new BigInteger[][] {{BigInteger.ONE,BigInteger.ONE},{BigInteger.ONE,BigInteger.ZERO}};

        for(int i = 2; i <= x; i++){
            multiply(F,M);
        }
    }
    public static void multiply(BigInteger F[][], BigInteger M[][]){
        BigInteger a = (F[0][0].multiply(M[0][0])).add((F[0][1].multiply(M[1][0])));
        BigInteger b = (F[0][0].multiply(M[0][1])).add((F[0][1].multiply(M[1][1])));
        BigInteger c = (F[1][0].multiply(M[0][0])).add((F[1][1].multiply(M[1][0])));
        BigInteger d = (F[1][0].multiply(M[0][1])).add((F[1][1].multiply(M[1][1])));

        F[0][0] = a;
        F[0][1] = b;
        F[1][0] = c;
        F[1][1] = d;
    }
//*****************************************************************
    public static void main(String[] args) {
	// write your code here
        //bigIntResults();
        fibResults();
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
//*****************************************************************

//********************Results for Fib******************************
    public static void fibResults(){
        double before, after;
        double fibloopTime[] = new double[10000];
        double fibmatrixTime[] = new double[10000];
        boolean con = true;
        boolean flcon = true;
        boolean fmcon = true;
        double fldr[] = new double[10000];
        double fledr = 0;
        double fmdr[] = new double[10000];
        double fmedr = 0;
        int x = 0;
        int Xval = 1;
        double avg = 0;
        long N;
        int count = 0;
        BigInteger num1 = BigInteger.ZERO;
        while(con){
            N = (int) Math.ceil(Math.log(2*(x+1)));
            //fib loop
            if(flcon){
                for(int i = 0; i < trialnum; i++){
                    before = getCpuTime();
                    fibLoop(x);
                    after = getCpuTime();
                    avg+= after-before;
                }
                avg = avg/trialnum;
                fibloopTime[count] = avg;
                if(fibloopTime[count] > mxTime){
                    flcon = false;
                }
                if(x > 2){
                    fldr[count] = fibloopTime[count]/ fibloopTime[x/10];
                    fledr = fldr[count -1] + fldr[count-2];
                }
            }
            avg =0;
            if(fmcon){
                for(int i = 0; i < trialnum; i++){
                    before = getCpuTime();
                    num1 = fibMatrix(x);
                    after = getCpuTime();
                    avg += after - before;
                }
                avg = avg/trialnum;
                fibmatrixTime[count] = avg;
                if(fibmatrixTime[count] > mxTime){
                    fmcon = false;
                }
                fledr = 0;
                if(x > 2){
                    fmdr[count] = fibmatrixTime[count] / fibmatrixTime[x/10];
                    fmedr = fmdr[count-1] + fmdr[count-2];
                    //fledr = x/(x/10);
                }
            }
            if(!fmcon && flcon){
                con = false;
            }
            String First = num1.toString();
            if(First.length() > Xval){
                Xval++;
            }
            System.out.printf("X = %d \t N = %d \t Fibloop time = %f \t Fibmatrix time = %f \t", x, Xval, fibloopTime[count], fibmatrixTime[count]);

            if(N > 1)
                fmedr = Math.log((double)N)/Math.log((double)N-1);
            if(First.length() >12) {
                String last = First.substring(0, 5);
                First = First.substring(First.length() - 5, First.length());
                System.out.printf("Fib(x) = %s...%s \t 10x ratio = %f \t Tx expected 10x ratio = %f \t Tn expected +1 ration = %s\n",last, First, fldr[count],fmedr,0);
            }else{
                System.out.printf("Fib(x) = %s \t 10x ratio = %f \t Tx expected 10x ratio = %f \t Tn expected +1 ration = %s\n",First, fmdr[count],fmedr,0);
            }
            count++;
            x++;


        }
    }
    public static long getCpuTime( ) {

        ThreadMXBean bean = ManagementFactory.getThreadMXBean( );

        return ((ThreadMXBean) bean).isCurrentThreadCpuTimeSupported( ) ?

                bean.getCurrentThreadCpuTime( ) : 0L;

    }


}
