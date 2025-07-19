import java.util.*;
class Solution {
    class Song implements Comparable<Song>{
        int num;
        int play;
        public Song (int num, int play){
            this.num =num;
            this.play = play;
        }
        @Override
        public int compareTo(Song s){
            if(this.play == s.play) return this.num - s.num;
            else return s.play - this.play;
        }
        @Override
        public String toString(){
            return "["+num+ " " +play+"]";
        }
    }
    class GenreDetail implements Comparable<GenreDetail>{
        int plays;
        TreeSet<Song> songs;
        public GenreDetail (){
            this.plays = 0;
            this.songs = new TreeSet<Song>();
        }
        @Override
        public int compareTo(GenreDetail g){
            return g.plays - this.plays;
        }
        @Override
        public String toString(){
            return plays+" "+songs;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> ans = new ArrayList<>();
        
        Map<String, GenreDetail> genreMap = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            Song song = new Song(i, plays[i]);
            GenreDetail nowGenreDetail = genreMap.getOrDefault(genres[i], new GenreDetail());
            nowGenreDetail.plays += plays[i];
            nowGenreDetail.songs.add(song);
            genreMap.put(genres[i], nowGenreDetail);
        }
        Set<String> keySet = genreMap.keySet();
        PriorityQueue<GenreDetail> q = new PriorityQueue<>();
        
        for(String key : keySet){
            GenreDetail gd = genreMap.get(key);
            q.add(gd);
        }
        
        while(!q.isEmpty()){
            GenreDetail gd = q.remove();
            for(int i=0; i<2; i++){
                Song s = gd.songs.pollFirst();
                if(s==null) break;
                ans.add(s.num);
            }
        }
        
        int[] answer = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}