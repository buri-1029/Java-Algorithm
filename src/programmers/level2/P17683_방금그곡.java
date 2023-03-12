package programmers.level2;

public class P17683_방금그곡 {

	public static void main(String[] args) {
		String m = "ABCDEFG";
		String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
		System.out.println(solution(m, musicinfos));
	}

	public static String solution(String m, String[] musicInfos) {
		String answer = "";
		int longTime = -1;

		m = changeMelody(m);

		for (String musicInfo : musicInfos) {
			String[] info = musicInfo.split(",");
			String title = info[2];
			String melody = changeMelody(info[3]);

			String[] time1 = info[0].split(":");
			String[] time2 = info[1].split(":");

			int play = (Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]))
				- (Integer.parseInt(time1[0]) * 60 + Integer.parseInt(time1[1]));

			if (play > melody.length()) {
				melody = melody.repeat(play / melody.length())
					+ melody.substring(0, play % melody.length());
			} else {
				melody = melody.substring(0, play);
			}

			if (melody.contains(m) && play > longTime) {
				answer = title;
				longTime = play;
			}

		}

		return longTime != -1 ? answer : "(None)";
	}

	private static String changeMelody(String oldMelody) {
		oldMelody = oldMelody.replaceAll("C#", "H");
		oldMelody = oldMelody.replaceAll("D#", "I");
		oldMelody = oldMelody.replaceAll("F#", "J");
		oldMelody = oldMelody.replaceAll("G#", "K");

		return oldMelody.replaceAll("A#", "L");
	}
}
