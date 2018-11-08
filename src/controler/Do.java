package controler;

import java.util.ArrayList;

import product.Data;

public class Do {
	public static void main(String[] args) {
		int[] com = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int k = 5;
		Data data=new Data();
		ArrayList<String> list = data.product(k, com);
		System.out.println("1111111111111");
		System.out.println(list.toString());
	}
}
