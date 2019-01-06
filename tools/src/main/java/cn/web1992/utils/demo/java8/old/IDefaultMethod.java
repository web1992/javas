package cn.web1992.utils.demo.java8.old;

/**
 * Created by Administrator on 2016/11/3.
 */
public interface IDefaultMethod {


    default void log(){
        System.out.println("log");
    }


    void doAction();
    void doAction2();




}



class M {

    public M() {
        super();
    }

    public static void main(String[] args){

        IDefaultMethod defaultMethod=new IDefaultMethod(){
            @Override
            public void doAction() {
                System.out.println("doAction");
            }

            @Override
            public void doAction2() {
                    System.out.println("doAction2");
            }
        };

        defaultMethod.log();
        defaultMethod.doAction();
        defaultMethod.doAction2();
    }
}
