package cn.web1992.utils.demo.template;

/**
 * Created by web1992 on 2016/8/29.
 *
 * @desc
 */
public abstract class AbstractCal {


    public int calculate(String rge, String opt) {
        int[] split = this.split(rge, opt);

        return cal(split[0], split[1]);
    }

    abstract int cal(int a, int b);

    private int[] split(String rge, String opt) {
        String[] split = rge.split("\\" + opt);

        int[] a = new int[2];
        a[0] = Integer.valueOf(split[0]);
        a[1] = Integer.valueOf(split[1]);
        return a;
    }
}


class Plus extends AbstractCal {

    @Override
    public int cal(int a, int b) {

        return a + b;
    }

    public static void main(String[] args) {
        AbstractCal abstractCal =   new Plus();
        String s = "1+2";
        int calculate =  abstractCal.calculate(s, "+");
        System.out.println(calculate);

        String s1 = "1-2";
        AbstractCal abstractCal2 = new Minus();
        int calculate1 = abstractCal2.calculate(s1, "-");
        System.out.println(calculate1);


    }
}


class Minus extends AbstractCal {
    @Override
    int cal(int a, int b) {
        return a - b;
    }
}