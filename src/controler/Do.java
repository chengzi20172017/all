package controler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import pojo.Dog;
import service.CounterService;

public class Do {

	public static void main(String[] args) throws Exception {
		CounterService counterService = new CounterService();

		 //预测
		 File infile = new File("D:\\chengzi\\账号\\indata.txt");
		 File outfile = new File("D:\\chengzi\\账号\\outdata.txt");
		 ArrayList<Dog> result = Prediction(counterService,infile,outfile);
		
		 //结果是否正确判断
		 String str="0";
		 ArrayList<Dog> res = counterService.preResult(result,str);
		 System.out.println(res.get(0).getPreresult());

//		// 验证是否合理
//		File prindata = new File("D:\\chengzi\\账号\\prindata.txt");
//		File proutdata = new File("D:\\chengzi\\账号\\proutdata.txt");
//		File infile = new File("D:\\chengzi\\账号\\indata.txt");
//		File outfile = new File("D:\\chengzi\\账号\\outdata.txt");
//
//		// 大数据
//		ArrayList<String> inlist = new ArrayList<String>();
//		BufferedReader br = new BufferedReader(new FileReader(prindata));
//		String s = null;
//		while ((s = br.readLine()) != null) {
//			
//			inlist.add(s);
//		}
//		br.close();
//
//		ArrayList<String> inlistout = new ArrayList<String>();
//		ArrayList<Dog> resultout = new ArrayList<>();
//		BufferedWriter prbw = new BufferedWriter(new FileWriter(proutdata));
//		for (int i = 0; i < inlist.size() - 1; i++) {
//			BufferedWriter bw = new BufferedWriter(new FileWriter(infile));
//
//			inlistout.add(inlist.get(i));
//			// 造数据
//			for (String str : inlistout) {
//				bw.write(str);
//				bw.newLine();
//			}
//			bw.flush();
//			bw.close();
//			if (i > 1) {
//				// 预测
//				ArrayList<Dog> result = Prediction(counterService, infile, outfile);
//				String string = inlist.get(i + 1);
//				String[] split = string.split("\\D");
//				String string2 = split[1];
//				String str = inlist.get(i + 1).split("\\D")[2].substring(4);
//				// 判断是否对错
//				ArrayList<Dog> res = counterService.preResult(result, str);
//				Dog dog = res.get(0);
//				resultout.add(dog);
//			}
//		}
//		for (Dog dog : resultout) {
//			String str = "错";
//			if (dog.getPreresult()) {
//				str = "对";
//			}
//			System.out.println(dog.getDate() + ":" + "正=" + dog.getZheng() + ";" + "连续=" + dog.getScore() + ";" + "反="
//					+ dog.getFan() + ";" + "预测结果=" + str);
////			prbw.write(dog.getDate() + ":" + "正=" + dog.getZheng() + ";" + "连续=" + dog.getScore() + ";" + "反="
////					+ dog.getFan() + ";" + "预测结果=" + str);
//			prbw.newLine();
//		}
//		prbw.flush();
//		prbw.close();
//		System.out.println("完成");
	}

	private static ArrayList<Dog> Prediction(CounterService counterService, File infile, File outfile)
			throws Exception, IOException {
		// 原始数据属于那些组合
		ArrayList<ArrayList<String>> inlis = new ArrayList<ArrayList<String>>();
		// 原始数据
		ArrayList<String> inData = null;

		// 对结构排序并存到对象中
		ArrayList<Dog> result = new ArrayList<Dog>();

		// 获取原始数据
		inData = counterService.inData(infile);

		// 查找原始数据属于那些组合
		inlis = counterService.Combinadata(inData);
		// 计算
		result = counterService.counter(inlis, inData.get(inData.size() - 1));

		// 结果输出
		counterService.Output(result, outfile);
		return result;
	}
}
