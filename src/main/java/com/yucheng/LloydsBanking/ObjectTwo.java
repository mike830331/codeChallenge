package com.yucheng.LloydsBanking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.yucheng.LloydsBanking.Service.EnglishNumberFormatter;

public class ObjectTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			solution(bufferedReader.readLine().trim());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String solution(String timeStamp) {
		EnglishNumberFormatter englishNumberFormatter = new EnglishNumberFormatter();
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
