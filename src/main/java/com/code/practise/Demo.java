package com.code.practise;

/**
 * description
 *
 * @author Summer 2020/03/31 13:43
 */
public class Demo {

    class Two{
        byte x;
    }

    public static void main(String[] args){
        Demo p=new Demo();
        p.start();
    }
    void start(){
        Two t=new Two();
        System.out.print(t.x+"");
        Two t2=fix(t);
        System.out.print(t.x+" " +t2.x);
    }
    Two fix(Two tt){
        tt.x=42;
        return tt;
    }


}
