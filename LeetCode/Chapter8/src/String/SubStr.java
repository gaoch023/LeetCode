package String;

public class SubStr {

	public static void main(String[] args) {
		System.out.println(subStr("abc", "ashdikwefvlacbdshfc"));
	}

	public static boolean subStr(String s, String str) {
		boolean isOk = true;
		for (int i = 0; i <= str.length() - s.length(); i++) {
			String tem = str.substring(i, i + s.length());
			System.out.println(tem);
			if (tem.equals(s)) {
				isOk = true;
				return isOk;
			} else {
				isOk = false;

			}
		}
		return isOk;

	}
}
