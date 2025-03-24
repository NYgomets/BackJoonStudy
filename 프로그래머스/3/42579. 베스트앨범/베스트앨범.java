import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreSumMap = new HashMap<>();
        for (int i=0; i<plays.length; i++) {
            genreSumMap.put(genres[i], genreSumMap.getOrDefault(genres[i], 0)+plays[i]);
        }
        List<Map.Entry<String, Integer>> maxGenre = new ArrayList<>(genreSumMap.entrySet());
        maxGenre.sort((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()));
        
        Map<String, List<Integer>> genreIdxMap = new HashMap<>();
        for (int i=0; i<genres.length; i++) {
            genreIdxMap.computeIfAbsent(genres[i], k->new ArrayList<>()).add(i);
        }
        
        for (String genre : genreIdxMap.keySet()) {
            genreIdxMap.get(genre).sort((o1, o2) -> Integer.compare(plays[o2], plays[o1]));
        }
        
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<String, Integer> map : maxGenre) {
            String genre = map.getKey();
            List<Integer> list = genreIdxMap.get(genre);
            
            for (int i=0; i<Math.min(2, list.size()); i++) {
                result.add(list.get(i));
            }
        }
        
        int[] answer = new int[result.size()];
        for (int i=0; i<result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}