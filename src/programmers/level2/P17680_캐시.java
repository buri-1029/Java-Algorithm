package programmers.level2;

import java.util.LinkedHashSet;
import java.util.Set;

/*
 * LRU(Least Recently Used) : 가장 오랫동안 사용되지 않은 것 교체
 */
public class P17680_캐시 {

	public static void main(String[] args) {
		int cacheSize1 = 3;
		String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul",
			"NewYork", "LA"};

		int cacheSize2 = 3;
		String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo",
			"Seoul"};

		int cacheSize3 = 2;
		String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul",
			"Rome", "Paris", "Jeju", "NewYork", "Rome"};

		System.out.println(solution(cacheSize1, cities1));
		System.out.println(solution(cacheSize2, cities2));
		System.out.println(solution(cacheSize3, cities3));

	}

	public static int solution(int cacheSize, String[] cities) {
		int answer = 0;

		if (cacheSize == 0) {
			return cities.length * 5;
		}

		Set<String> cache = new LinkedHashSet<>();

		for (String city : cities) {
			city = city.toLowerCase();

			if (cache.contains(city)) {
				cache.remove(city);
				answer += 1;
			} else {
				answer += 5;
			}

			cache.add(city);

			if (cache.size() > cacheSize) {
				String old = cache.iterator()
								  .next();
				cache.remove(old);
			}
		}

		return answer;
	}
}
