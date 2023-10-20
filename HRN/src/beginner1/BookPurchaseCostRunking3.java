package beginner1;

import java.util.Scanner;

public class BookPurchaseCostRunking3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//人数
		int empNum = 0;
		//名前
		String empNames[];
		//購入書籍の合計金額
		int totalCosts[];

		//①人数の読み込み
		empNum = sc.nextInt();

		//配列の要素の代入
		empNames = new String[empNum];
		totalCosts = new int[empNum];

		//②名前の読み込み
		for (int i = 0; i < empNum; i++) {
			empNames[i] = sc.next();
		}

		//③本の購入数の読み込み
		int bookNum = sc.nextInt();

		//④購入書籍の合計金額の読み込み
		for (int i = 0; i < bookNum; i++) {
			String empName = sc.next();
			int bookCost = sc.nextInt();
			for (int j = 0; j < empNames.length; j++) {
				if (empNames[j].equals(empName)) {
					totalCosts[j] += bookCost;
				}
			}
		}
		sc.close();
		
		//降順ソート
		for (int i = 0; i < totalCosts.length - 1; i++) {
			for (int j = 0; j < totalCosts.length - i - 1; j++) {
				if (totalCosts[j] < totalCosts[j + 1]) {
					//合計金額ソート
					int tmpCost = totalCosts[j];
					totalCosts[j] = totalCosts[j + 1];
					totalCosts[j + 1] = tmpCost;
					//名前も一緒にソート
					String tmpName = empNames[j];
					empNames[j] = empNames[j + 1];
					empNames[j + 1] = tmpName;
				}
			}
		}
		//ソート後のリスト表示
		for (String name : empNames) {
			System.out.println(name);
		}
	}
}