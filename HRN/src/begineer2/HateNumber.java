package begineer2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HateNumber {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//①嫌いな数字を入力
		String HNum = sc.next();
		int n = Integer.parseInt(HNum);
		if (n < 0 || n > 9) {
			System.out.println("無効な入力です");
		}

		//②病室の総数を入力
		int RNum = sc.nextInt();
		if (RNum < 1 || RNum > 100) {
			System.out.println("無効な入力です");
		}

		//③希望する部屋番号
		List<String> preRoomNum = new ArrayList<>();

		//部屋番号を入力
		for (int i = 0; i < RNum; i++) {
			String r = sc.next();
			int b = Integer.parseInt(r);
			preRoomNum.add(r);
			if (b < 1 || b > 1000) {
				System.out.println("無効な入力です");
			}
		}

		//嫌いな数字を含む部屋番号を除外
		List<String> list = preRoomNum.stream() //streamの取得
				.filter(r -> !r.contains(HNum)) //中間操作
				.collect(Collectors.toList()); //終端操作

		//結果を出力
		if (list.isEmpty()) {
			System.out.println("none");
		} else {
			for(String z:list)
			System.out.println(z);
		}
		sc.close();
	}
}