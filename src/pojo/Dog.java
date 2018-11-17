package pojo;

import java.util.ArrayList;

public class Dog implements Comparable<Dog> {
	private String date;
	private String Zheng;
	private String Id;
	private String Fan = "";
	private int Score;
	private Boolean Preresult;

	public Dog(String Zheng, int Score) {
		super();
		this.Zheng = Zheng;
		this.Score = Score;
		setFan(Zheng);
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFan() {
		return Fan;
	}

	public void setFan(String Zheng) {
		String[] split = Zheng.split("_");
		String qian = split[0];
		String hou = split[1];
		String[] arr = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		ArrayList<String> strArray = new ArrayList<String>();
		strArray.add("0");
		strArray.add("1");
		strArray.add("2");
		strArray.add("3");
		strArray.add("4");
		strArray.add("5");
		strArray.add("6");
		strArray.add("7");
		strArray.add("8");
		strArray.add("9");

		strArray.remove(hou.charAt(0) + "");
		strArray.remove(hou.charAt(1) + "");
		strArray.remove(hou.charAt(2) + "");
		strArray.remove(hou.charAt(3) + "");
		strArray.remove(hou.charAt(4) + "");

		for (String str : strArray) {
			Fan = Fan + str;
		}
	}

	public Boolean getPreresult() {
		return Preresult;
	}

	public void setPreresult(Boolean Preresult) {
		this.Preresult = Preresult;
	}

	public String getZheng() {
		return Zheng;
	}

	public void setZheng(String Zheng) {
		this.Zheng = Zheng;
	}

	public int getScore() {
		return Score;
	}

	public void setScore(int Score) {
		this.Score = Score;
	}

	@Override
	public int compareTo(Dog o) {
		int i = this.getScore() - o.getScore();
		return -i;
	}

}
