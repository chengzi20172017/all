package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import dao.CombinationData;
import pojo.Dog;

public class CounterService {

	public ArrayList<Dog> preResult(ArrayList<Dog> res, String next) {
		String str=res.get(0).getFan();
		Boolean preresult = res.get(0).getFan().contains(next);
		res.get(0).setPreresult(preresult);
		return res;
	}

	public void Output(ArrayList<Dog> result,File file) throws IOException {
		
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		if (result.get(0).getScore() >= 6) {
			bw.write("日期"+result.get(0).getDate()+";"+"正="+result.get(0).getZheng() + ";" + "连续"+ "="+result.get(0).getScore()+ ";" +"反="+result.get(0).getFan());
			bw.newLine();
			bw.write("===================");
			bw.newLine();
		}
		for (Dog dog : result) {
			bw.write("日期"+dog.getDate()+";"+"正="+dog.getZheng() + ";" + "连续"+ "="+dog.getScore()+ ";" +"反="+dog.getFan());
			bw.newLine();
//			System.out.println("正="+result.get(0).getZheng() + ";" + "连续"+ "="+result.get(0).getScore()+ ";" +"反="+result.get(0).getFan());
		}
		bw.flush();
		bw.close();
	}

	// 查找原始数据属于那些组合
	public ArrayList<ArrayList<String>> Combinadata(ArrayList<String> inData) {
		// 252种情况
		ArrayList<String> list = new ArrayList<String>();
		// 过滤后原始数据
		ArrayList<ArrayList<String>> inlis = new ArrayList<ArrayList<String>>();
		// 获取252种情况
		int[] com = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int k = 5;
		CombinationData data = new CombinationData();
		list = data.product(k, com);
		// 原始数据属于252种情况的那种
		for (String in : inData) {
			String[] split = in.split("_");
			String qian = split[0];
			String hou = split[1];
			ArrayList<String> tmplis = new ArrayList<String>();
			for (String str : list) {
				if (str.contains(hou)) {
					tmplis.add(qian+"_"+str);
				}
			}
			inlis.add(tmplis);

		}
	
//		for (int i=0;i<4;i++) {
//			ArrayList<String> tmplis = new ArrayList<String>();
//			tmplis.add("03648");
//			inlis.add(tmplis);
//		}
		

		return inlis;
	}

	// 对数据进行统计
	public ArrayList<Dog> counter(ArrayList<ArrayList<String>> inlis,String date) {
		
		// 统计后的结果
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		// 对结果进行排序并存到对象中
		ArrayList<Dog> tmplis1 = new ArrayList<Dog>();

		// 首次出现设置为1
		ArrayList<String> lisfirst = inlis.get(0);
		for (String string : lisfirst) {
			result.put(string, 1);
		}

		// 把每次结果放再inlist
		for (int j = 1; j < inlis.size(); j++) {
			// 前一次
			ArrayList<String> tmplisfirst = inlis.get(j - 1);
			// 后一次
			ArrayList<String> tmplistwo = inlis.get(j);
			for (String string : tmplistwo) {
				if (result.containsKey(string) && tmplisfirst.contains(string)) {
					int a = result.get(string);
					a++;
					result.put(string, a);
				} else {
					result.put(string, 1);
				}
			}
		}

		// 排序
		Iterator<String> it = result.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			Integer value = result.get(key);
			Dog dog = new Dog(key, value);
			dog.setDate(date);
			tmplis1.add(dog);
		}

		Collections.sort(tmplis1);

		return tmplis1;
	}

	// 数据的输入
	public ArrayList<String> inData(File file) throws Exception {
		ArrayList<String> inlist = new ArrayList<String>();
		BufferedReader br;
		br = new BufferedReader(new FileReader(file));
		String s = null;
		while ((s = br.readLine()) != null) {
			if(!s.equals("")){
				String[] split = s.split("\\D");
				
			inlist.add(split[1]+"_"+split[2].substring(4));
			}
		}
		br.close();
		return inlist;
	}

}
