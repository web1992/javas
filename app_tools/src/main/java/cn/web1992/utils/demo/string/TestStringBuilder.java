package cn.web1992.utils.demo.string;

public class TestStringBuilder {
	public static void main(String[] args){

		String a="C";
		String d="D";
		StringBuilder sb=new StringBuilder("D");

		long start2=System.currentTimeMillis();
		for (int i = 10001; i < 20001; i++) {
//			sb.append(i);
			d+=i;
		}
		System.out.println("costTime="+(System.currentTimeMillis()-start2));


		long start=System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			a+=i;
		}
		System.out.println("costTime="+(System.currentTimeMillis()-start));


		System.out.println(a);
		System.out.println(sb);
	}

	public static void test(Object str){
		StringBuilder s=new StringBuilder("A");
		s.append(str);
		System.out.println(s);
	}
}