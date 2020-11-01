package com.company;

public class Main {
//********************Biginteger class*****************************
    public class MyBigInteger{
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
    public static void main(String[] args) {
	// write your code here
    }
//********************Addition algorithm***************************
    public static void addition(){

    }
//*****************************************************************
}
