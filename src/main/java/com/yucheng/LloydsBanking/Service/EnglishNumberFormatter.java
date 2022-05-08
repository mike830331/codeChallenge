package com.yucheng.LloydsBanking.Service;

import org.springframework.stereotype.Service;

@Service
public class EnglishNumberFormatter {

	private static final String[] INDNUM = { "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE",
			"TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN",
			"NINETEEN" };
//	private static final String[] TIES = { "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY",
//			"NINETY" };
//	private static final String Zero = "ZERO";
	private static final String Space = " ";

	public String format(int i) {

		StringBuilder sb = new StringBuilder();

		if (i == 0) {
			return "TWELVE";
		} else if (i < 30) {
			if (i >= 20) {
				sb.append("TWENTY").append(Space);
				if (i % 10 != 0) {
					sb.append(PickIND(i % 10)).append(Space);
				}
			} else {
				sb.append(PickIND(i)).append(Space);
			}
		} else if (i == 30) {
			sb.append("HALF").append(Space);
		} else {
			i = 60 - i;
			if (i >= 20) {
				sb.append("TWENTY").append(Space);
				if (i % 10 != 0) {
					sb.append(PickIND(i % 10)).append(Space);
				}
			} else {
				sb.append(PickIND(i)).append(Space);
			}
		}
		return sb.toString();

	}

	private static String PickIND(int i) {
		return INDNUM[i - 1];
	}

}
