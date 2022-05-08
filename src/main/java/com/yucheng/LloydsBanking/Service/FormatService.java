package com.yucheng.LloydsBanking.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yucheng.LloydsBanking.Model.Response;

@Service
public class FormatService {

	@Autowired
	private EnglishNumberFormatter englishNumberFormatter;

	public Response getformat(String time) {
		// TODO Auto-generated method stub
		Response response = new Response();
		String[] input = time.split(":");
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
		response.setReadableTime(output);
		return response;
	}

}
