package programmers.level3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P43163_단어변환 {

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(begin, target, words));

		String begin1 = "hit";
		String target1 = "cog";
		String[] words1 = {"hot", "dot", "dog", "lot", "log" };
		System.out.println(solution(begin1, target1, words1));
	}

	public static int solution(String begin, String target, String[] words) {
		if (!Arrays.asList(words)
				   .contains(target)) {
			return 0;
		}

		int answer = words.length;
		boolean[] visit = new boolean[words.length];
		Queue<Word> queue = new LinkedList<>();

		for (int i = 0; i < words.length; i++) {
			if (!visit[i] && checkOneDifferentChar(begin, words[i])) {
				queue.add(new Word(i, 1));
				visit[i] = true;
			}
		}

		while (!queue.isEmpty()) {
			Word cur = queue.poll();

			if (words[cur.idx].equals(target)) {
				answer = Math.min(answer, cur.cnt);
			}

			for (int i = 0; i < words.length; i++) {
				if (!visit[i] && checkOneDifferentChar(words[cur.idx], words[i])) {
					queue.add(new Word(i, cur.cnt + 1));
					visit[i] = true;
				}
			}

		}

		return answer;
	}

	private static boolean checkOneDifferentChar(String cur, String word) {
		int one = 0;
		for (int i = 0; i < word.length(); i++) {
			if (cur.charAt(i) != word.charAt(i)) {
				one++;
				if (one > 1) {
					return false;
				}
			}

		}
		return true;
	}

	static class Word {

		int idx, cnt;

		public Word(int idx, int cnt) {
			this.idx = idx;
			this.cnt = cnt;
		}
	}
}
