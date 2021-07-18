package programmers;

public class P72410_신규아이디추천 {
    public static void main(String[] args) {
        String new_id1 = "...!@BaT#*..y.abcdefghijklm";
        String ans1 = solution(new_id1);
        System.out.println(ans1);

        String new_id2 = "z-+.^.";
        String ans2 = solution(new_id2);
        System.out.println(ans2);

        String new_id3 = "=.=";
        String ans3 = solution(new_id3);
        System.out.println(ans3);

        String new_id4 = "123_.def";
        String ans4 = solution(new_id4);
        System.out.println(ans4);

        String new_id5 = "abcdefghijklmn.p";
        String ans5 = solution(new_id5);
        System.out.println(ans5);
    }

    private static String solution(String new_id) {
        // 1단계 - > String str = new_id.toLowerCase();
        new_id = new_id.toLowerCase();

        // 2단계 -> str = str.replaceAll("[^-_.a-z0-9]","");
        String str = "";
        for(int i = 0; i < new_id.length(); i++){
            if('a' <= new_id.charAt(i) && new_id.charAt(i) <= 'z'||
                    '0' <= new_id.charAt(i) && new_id.charAt(i) <= '9'||
                    new_id.charAt(i) == '-' || new_id.charAt(i) == '_' || new_id.charAt(i) == '.'){
                str += new_id.charAt(i);
            }
        }

        // 3단계 -> str = str.replaceAll("[.]{2,}",".");
        while(str.contains("..")) {
            str = str.replace("..", ".");
        }

        // 4단계 -> str = str.replaceAll("^[.]|[.]$","");
        str = !str.isEmpty() && str.charAt(0) == '.' ? str.replaceFirst(".","") : str;
        str = !str.isEmpty() && str.charAt(str.length()-1) == '.' ? str.substring(0,str.length()-1) : str;

        // 5단계
        if(str.isEmpty()) str += "a";

        // 6단계
        if(str.length() >= 16) {
            str = str.substring(0, 15);
            if (str.charAt(str.length() - 1) == '.') str = str.substring(0, 14);
            // -> str = str.replaceAll("^[.]|[.]$","");
        }

        // 7단계
        if(str.length() <= 2){
            while(str.length() != 3){
                str += str.charAt(str.length()-1);
            }
        }

        return str;
    }
}
