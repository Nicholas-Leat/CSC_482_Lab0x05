package com.company;

public class Main {
//********************Biginteger class*****************************
    public class MyBigInteger{
        string Value;
        //constructor
        MyBigInteger(string val){
            Value = val;
        }
        //returns a string representation of the integer
        string Value(){
            return Value;
        }
        //returns first 5 and last 5 digits or up to all 11 digits
        string AbbreviatedValue(){
            string returnVal = " ";
            if(Value.length() < 12){
                return Value;
            }else{
                returnVal = Value.substring(Value.length()-5) + Value.substring(0,4);
            }

            return returnVal;
        }
        //returns a new biginteger with value of this.value + x.value
        MyBigInteger Plus(MyBigInteger x){
            MyBigInteger val;

            return val;
        }
        //returns a new biginteger with value of this.value * x.value
        MyBigInteger Times(MyBigInteger x){

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
