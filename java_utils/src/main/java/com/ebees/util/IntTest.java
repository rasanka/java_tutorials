package com.ebees.util;

public class IntTest {

    public static void main(String args[]) {
        
        IntTest obj = new IntTest();
        Test t1 = obj.new Test();
        
        System.out.println(t1.getA());
        System.out.println(t1.getB());
                
    }
    
    class Test {
        int a;
        Integer b;
        public int getA() {
            return a;
        }
        public void setA(int a) {
            this.a = a;
        }
        public Integer getB() {
            return b;
        }
        public void setB(Integer b) {
            this.b = b;
        }
        
        
    }
}
