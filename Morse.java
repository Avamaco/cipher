public class Morse implements Cipher {
    Morse(){

    }
    public String encode(String a) {
        if(a.length() == 0){
            return a;
        }
        a = a.toUpperCase();
        String ret = "";
        for (int i = 0; i < a.length(); i++) {
            char sign = a.charAt(i);
            switch (sign) {
                case 'A':
                    ret += "•-";
                    break;
                case 'B':
                    ret += "-•••";
                    break;
                case 'C':
                    ret += "-•-•";
                    break;
                case 'D':
                    ret += "-••";
                    break;
                case 'E':
                    ret += "•";
                    break;
                case 'F':
                    ret += "••-•";
                    break;
                case 'G':
                    ret += "--•";
                    break;
                case 'H':
                    ret += "••••";
                    break;
                case 'I':
                    ret += "••";
                    break;
                case 'J':
                    ret += "•---";
                    break;
                case 'K':
                    ret += "-•-";
                    break;
                case 'L':
                    ret += "•-••";
                    break;
                case 'M':
                    ret += "--";
                    break;
                case 'N':
                    ret += "-•";
                    break;
                case 'O':
                    ret += "---";
                    break;
                case 'P':
                    ret += "•--•";
                    break;
                case 'Q':
                    ret += "--•-";
                    break;
                case 'R':
                    ret += "•-•";
                    break;
                case 'S':
                    ret += "•••";
                    break;
                case 'T':
                    ret += "-";
                    break;
                case 'U':
                    ret += "••-";
                    break;
                case 'V':
                    ret += "•••-";
                    break;
                case 'W':
                    ret += "•--";
                    break;
                case 'X':
                    ret += "-••-";
                    break;
                case 'Y':
                    ret += "-•--";
                    break;
                case 'Z':
                    ret += "--••";
                    break;
                case ' ':
                    ret += "/";
            }
            ret += " ";
        }
        String ret1 = "";
        for (int i = 0; i < ret.length() - 1; i++){
            char sign = ret.charAt(i);
            ret1 += sign;
        }
        return ret1;
    }

    public String decode(String a) {
        String[] morse = new String[]{"•-", "-•••", "-•-•", "-••", "•", "••-•", "--•", "••••", "••", "•---", "-•-", "•-••", "--", "-•", "---",
                "•--•", "--•-", "•-•", "•••", "-", "••-", "•••-", "•--", "-••-", "-•--", "--••"};
        String ret = "";
        for (int i = 0; i < a.length(); i++) {
            char sign = a.charAt(i);
            String help = "";
            while ((int) sign != 47 && (int) sign != 32 && i < a.length()) {
                help += sign;
                i++;
                if(i < a.length()) {
                    sign = a.charAt(i);
                }
            }

            for(int j = 0; j < 26; j++) {
                if (help.equals(morse[j])) {
                    ret += (char) (j + 65);
                }
            }
            if(sign == '/'){
                ret += " ";
            }
        }
        return ret;
    }
}
