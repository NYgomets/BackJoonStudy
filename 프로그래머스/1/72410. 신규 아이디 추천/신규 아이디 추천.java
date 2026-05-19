class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        answer = one(new_id);
        answer = two(answer);
        answer = three(answer);
        answer = four(answer);
        answer = five(answer);
        answer = six(answer);
        answer = seven(answer);
        
        return answer;
    }
    
    static public String one(String id) {
        return id.toLowerCase();
    }
    static public String two(String id) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<id.length(); i++) {
            char c = id.charAt(i);
            
            if (
                ('a'<= c && c<='z') ||
                ('0'<= c && c<='9') ||
                (c == '-') ||
                (c == '_') ||
                (c == '.')
            ) {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
    static public String three(String id) {
        StringBuilder sb = new StringBuilder();
        boolean check = false;
        for (int i=0; i<id.length(); i++) {
            char c = id.charAt(i);
            
            if (c == '.' && check) {
                continue;
            } else {
                if (c == '.') {
                    check = true;
                } else {
                    check = false;
                }
                sb.append(c);
            }
        }
        
        return sb.toString();
    } 
    static public String four(String id) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<id.length(); i++) {
            char c = id.charAt(i);
            
            if (
                (c == '.' && i==0) ||
                (c == '.' && i==id.length()-1) 
            ) {
                continue;
            } else {
                sb.append(c);
            }
        }
        
        return sb.toString();
    } 
    static public String five(String id) {
        if (id.equals("")) {
            return "a";
        } else {
            return id;
        }
    }
    static public String six(String id) {
        if (id.length() >= 16) {
            id = id.substring(0, 15);
        }
        if (id.endsWith(".")) {
            id = id.substring(0, id.length()-1);
        }
        return id;
    } 
    static public String seven(String id) {
        while (id.length()<=2) {
            id += id.charAt(id.length()-1);
        }
        return id;
    }
}