package cn.web1992.utils.demo.java8;

import java.util.function.Supplier;

/**
 * Created by web on 2017/1/11.
 */
public class LambdaNew {

    public LambdaNew() {
    }

    public static void main(String[] args) {
        Supplier<LambdaNew> lamnew= LambdaNew::new;
        LambdaNew lambdaNew = lamnew.get();

    }

    public static void pf(){

    }



    public void pl(){
        System.out.printf("LambdaNew#pl");
    }
}
