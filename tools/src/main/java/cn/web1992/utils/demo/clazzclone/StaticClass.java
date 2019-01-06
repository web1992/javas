package cn.web1992.utils.demo.clazzclone;

public class StaticClass {
    public static void main(String[] args){


    }

    public void test(){
        System.out.println("StaticClass test run ...");
    }

    static class A{
        private String testA(){
            // error
            // StaticClass.this.test();
            return "";
        }

    }

    class B{

       private void runB(){
           // class B can ref StaticClass method
           StaticClass.this.test();
       }
    }
}
