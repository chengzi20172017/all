package controler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import product.Data;

public class Do {
	public static void main(String[] args) {
		//252种情况
		ArrayList<String> list = new  ArrayList<String>();
		//原始数据
		ArrayList<String> inData = null;
		//过滤后原始数据
		ArrayList<ArrayList<String>> inlis =new ArrayList<ArrayList<String>>();
		//计算后的结果
		HashMap<String, Integer> result=new HashMap<String, Integer>();
		//获取252种情况
		int[] com = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int k = 5;
		Data data=new Data();
		 list = data.product(k, com);
		//获取原始数据
	    inData = inData();
		//原始数据属于252种情况的那种
	    for (String in : inData) {
	    	ArrayList<String> tmplis = new  ArrayList<String>();
	    	for (String str : list) {
				if(str.contains(in)){
					tmplis.add(str);
				}
			}
	    	inlis.add(tmplis);
	    	
		}
	    
	    
//	    //测试
//	    for(int i=0;i<4;i++){
//	    	   ArrayList<String> tmplis1 = new  ArrayList<String>();
//	   	    ArrayList<String> tmplis2 = new  ArrayList<String>();
//	   	    ArrayList<String> tmplis3 = new  ArrayList<String>();
//	   	    tmplis1.add("13579");
//	   	    tmplis1.add("13578");
//	   	    tmplis1.add("13589");
//	   	    inlis.add(tmplis1);
//
//	    }
	 
	    
		//计算
		result = counter(inlis);
		System.out.println("1111111111111");
		System.out.println(result.toString());
	}

	private static HashMap<String, Integer> counter(ArrayList<ArrayList<String>> inlis) {
 		HashMap<String, Integer> result=new HashMap<String, Integer>();
 		
 		//首次出现设置为1
 		ArrayList<String> lisfirst =inlis.get(0);
			for (String string : lisfirst) {
				result.put(string, 1);
		}
			
 		//把每次结果放再inlist
 		for (int j=1;j< inlis.size();j++) {
 				//前一次
 				ArrayList<String> tmplisfirst =inlis.get(j-1);
 				//后一次
 				ArrayList<String> tmplistwo =inlis.get(j);
 				for (String string : tmplistwo) {
 					if(result.containsKey(string) && tmplisfirst.contains(string)){
 	 					int a =result.get(string);
 	 					a++;
 	 					result.put(string, a);
 	 				}else{
 	 					result.put(string, 1);
 	 				}
				}		
		}
 		
 		
		return result;
	}
	
	
	private static ArrayList<String> inData() {
		 ArrayList<String> inlist =new  ArrayList<String>();
		 inlist.add("1");
		 inlist.add("6");
		 inlist.add("4");
		 inlist.add("0");
		 inlist.add("8");
		 inlist.add("6");
		 inlist.add("4");
		 inlist.add("7");
		 inlist.add("6");
		 inlist.add("9");
		 inlist.add("6");
		 inlist.add("8");
		 inlist.add("5");
		 inlist.add("6");
		 inlist.add("5");
		 inlist.add("8");
		 inlist.add("6");
		return inlist;
		
		}
}
