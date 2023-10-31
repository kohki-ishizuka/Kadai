package begineer3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TravelSchedule {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		//休日の日数と旅行の日数を入力
		int totalDays = sc.nextInt();
		int travelDays = sc.nextInt();
		if (totalDays < 1 || totalDays > 30 || travelDays < 1 || travelDays > 30 || totalDays < travelDays) {
			System.out.println("無効な入力です");
			return;
		}

		//日付と降水確率のリストを初期化
		List<String> dates = new ArrayList<>();
		List<Integer> rainProbabilities = new ArrayList<>();

		//日付と降水確率を入力
		for (int i = 0; i < totalDays; i++) {
			int date = sc.nextInt();
			int rainProbability = sc.nextInt();

			if (date < 1 || date > 30 || rainProbability < 0 || rainProbability > 100) {
				System.out.println("無効な入力です");
				return;
			}

			dates.add(Integer.toString(date));
			rainProbabilities.add(rainProbability);
		}

		if (dates.size() != totalDays || dates.size() != rainProbabilities.size() || !consecutiveDates(dates)) {
			System.out.println("無効な入力です");
			return;

		}
		int[] minAvgRange = lowestAvgRange(rainProbabilities, travelDays);

		if (minAvgRange != null) {
			System.out.println(dates.get(minAvgRange[0]) + " " + dates.get(minAvgRange[1]));
		} else {
			System.out.println("無効な入力です");
		}
	}

	//連続した日付をチェックするメソッド
	public static boolean consecutiveDates(List<String> dates) {
		if (dates.size() <= 1) {
			return true;
		}

		for (int i = 1; i < dates.size(); i++) {
			int currentDate = Integer.parseInt(dates.get(i));
			int previousDate = Integer.parseInt(dates.get(i - 1));

			if (currentDate != previousDate + 1) {
				return false;
			}
		}
		return true;
	}

	//降水確率の平均が最も低い旅行の日数分の日付範囲を取得するメソッド
	public static int[] lowestAvgRange(List<Integer> rainProbabilities, int travelDays) {
		if (rainProbabilities.isEmpty() || travelDays > rainProbabilities.size()) {
			return null;
		}

		int minAvgRangeStart = 0;
		int minAvgRangeEnd = travelDays - 1;
		int currentRangeStart = 0;
		int currentRangeEnd = travelDays - 1;

		int minAvg = calculateAvg(rainProbabilities, currentRangeStart, currentRangeEnd);
		int currentAvg = minAvg;

		for (int i = travelDays; i < rainProbabilities.size(); i++) {
			currentRangeStart++;
			currentRangeEnd++;

			currentAvg = currentAvg - rainProbabilities.get(currentRangeStart - 1)
					+ rainProbabilities.get(currentRangeEnd);

			if (currentAvg < minAvg) {
				minAvg = currentAvg;
				minAvgRangeStart = currentRangeStart;
				minAvgRangeEnd = currentRangeEnd;
			}
		}
		int[] result = { minAvgRangeStart, minAvgRangeEnd };
		return result;
	}

	//特定の範囲の降水確率の平均値を計算するメソッド
	public static int calculateAvg(List<Integer> rainProbabilities, int start, int end) {
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += rainProbabilities.get(i);
		}
		return sum / (end - start + 1);
	}
}