package regex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1 {
	public static void main(String[] args) {
		String content1 = "crcb Crcb CRCb CrBB I Grcb CRCB you BRcb CRcb";
		Pattern pattern1 = Pattern.compile("crcb", Pattern.CASE_INSENSITIVE);
		Matcher m =pattern1.matcher(content1);
		while(m.find()) {
			System.out.println(m.group(0));
		}

		String line = "222bc-56566zz-789oc-aa";
		String pattern2 = "\\d{3,5}[A-Za-z]{2}";
		Pattern r = Pattern.compile(pattern2);
		Matcher m2 = r.matcher(line);
		while(m2.find()) {
			System.out.println(m2.group(0));
		}

		String line1 = "ert567uioda12bka56789bdca4562bdca333bmqwe325xmlo";
		String pattern3 = "[^c]a.*bd";
		Pattern r2 = Pattern.compile(pattern3);
		Matcher m3 = r2.matcher(line1);
		while (m3.find()) {
			System.out.println(m3.group(0));
		}

		String line4 = "192.68.01.254 102.49.23.013 10.10.10.010 10.00.10.10 2.2.002.2 08.109.90.30";
		String pattern4 = "\\d+\\.\\d+\\.\\d+\\.\\d+";
		Pattern r4 = Pattern.compile(pattern4);
		Matcher m4 = r4.matcher(line4);
		List<String> ips = new ArrayList<String>();
		while (m4.find()) {
			String ip = m4.group();
			ips.add(ip);
		}

		for (String s : ips) {
			System.out.println(s.replaceAll("0+(\\d+)", "$1"));
		}

		try {

			FileReader fr = new FileReader("D:\\test.txt");
			BufferedReader br = new BufferedReader(fr);
			StringBuffer sb = new StringBuffer();
			while (br.ready()) {
		      sb.append(br.readLine());
			}
			
			String string = sb.toString();
			String re = "^([a-zA-Z]+-?)+[a-zA-Z0-9]+\\\\.[x|X][m|M][l|L]$";
			
			Pattern r5 = Pattern.compile(re);
			Matcher m5 = r5.matcher(string);
			while (m5.find()) {
				System.err.println(m5.group());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}
