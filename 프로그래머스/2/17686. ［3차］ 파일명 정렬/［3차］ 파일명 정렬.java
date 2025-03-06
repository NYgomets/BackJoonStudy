import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, (o1, o2) -> {
            String head1 = extractHead(o1);
            String head2 = extractHead(o2);
            int num1 = extractNum(o1);
            int num2 = extractNum(o2);
            
            int check = head1.compareTo(head2);
            if (check != 0) {
                return check;
            }
            return Integer.compare(num1, num2);
        });
        return files;
    }
    
    public String extractHead(String file) {
        StringBuilder sb = new StringBuilder();
        for (char c : file.toCharArray()) {
            if (Character.isDigit(c)) {
                break;
            }
            sb.append(c);
        }
        
        return sb.toString().toLowerCase();
    }
    
    public int extractNum(String file) {
        StringBuilder sb = new StringBuilder();
        for (char c : file.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                if (sb.length()>0) {
                    break;
                }
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}