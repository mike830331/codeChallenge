package com.yucheng.LloydsBanking;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.yucheng.LloydsBanking.Service.EnglishNumberFormatter;

public class ObjectOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution();
	}

	public static String solution() {
		EnglishNumberFormatter englishNumberFormatter = new EnglishNumberFormatter();
		String timeStamp = new SimpleDateFormat("HH:mm").format(Calendar.getInstance().getTime());
		System.out.println(timeStamp);
		String[] input = timeStamp.split(":");
		String output = "";
		int hr = Integer.valueOf(input[0]) >= 12 ? Integer.valueOf(input[0]) - 12 : Integer.valueOf(input[0]);
		int mi = Integer.valueOf(input[1]);
		if (mi == 0) {
			String hour = englishNumberFormatter.format(hr);
			output = hour + " o'clock";
		} else if (mi > 30) {
			String hour = englishNumberFormatter.format(hr + 1);
			String min = englishNumberFormatter.format(mi);
			output = min + "to " + hour.toLowerCase();
		} else {
			String hour = englishNumberFormatter.format(hr);
			String min = englishNumberFormatter.format(mi);
			output = min + "past " + hour.toLowerCase();
		}
		System.out.println(output);
		return output;

	}

}
