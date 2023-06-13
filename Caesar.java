public class Caesar implements Cipher {
    Caesar(){

    }
    public String encode(String a) {
        String res = "";
        for (int i = 0; i < a.length(); i++) {
            char sign = a.charAt(i);
            if (sign == ' ') {
                res += " ";
            } else {
                int a1 = (int) sign + 3;
                if((a1 > 90 && a1 < 95) || a1 > 122){
                    a1-=26;
                }
                res += (char) a1;
            }
        }
        return res;
    }
    public String decode(String a){
        String res = "";
        for (int i = 0; i < a.length(); i++) {
            char sign = a.charAt(i);
            if (sign == ' ') {
                res += " ";
            } else {
                int a1 = (int) sign - 3;
                if (a1 < 65 || (a1 < 97 && a1 > 91) ) {
                    a1 += 26;
                }
                res += (char) (a1);
            }
        }
        return res;
    }
}
