package dao;

import java.util.ArrayList;
/**
 * 产生组合数据
 */
public class CombinationData {
	private static ArrayList<Integer> tmpArr = new ArrayList<>();
	private static ArrayList<String> list = new ArrayList<>();

	public ArrayList<String> product(int k, int[] com) {

		if (k > com.length || com.length <= 0) {
			return list;
		}
		combine(0, k, com);
		// System.out.println(list.toString());
		return list;
	}

	private void combine(int index, int k, int[] arr) {
		if (k == 1) {
			for (int i = index; i < arr.length; i++) {
				tmpArr.add(arr[i]);
				// System.out.println(tmpArr.toString());
				String str = "";
				for (Integer tem : tmpArr) {
					str = str + tem;
				}
				list.add(str);
				tmpArr.remove((Object) arr[i]);
			}
		} else if (k > 1) {
			for (int i = index; i <= arr.length - k; i++) {
				tmpArr.add(arr[i]);
				combine(i + 1, k - 1, arr);
				tmpArr.remove((Object) arr[i]);
			}
		} else {
			return;
		}
	}
}
