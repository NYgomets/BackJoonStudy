import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> que=new LinkedList<>();
        int min=10000000;

        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int temp=Integer.parseInt(st.nextToken());
            que.offer(temp);
            min= min >temp ? temp: min;
        }
        while(true){
            if(que.peek()==min){
                break;
            }
            que.offer(que.poll());
        }

        int answer=1;
        int num=que.poll();
        while(que.size()!=0){
            if(que.peek()<=num){
                answer+=1;
                num=que.poll();
            }
            else{
                num=que.poll();
            }
        }
        bw.write(answer+"");
        bw.flush();

    }
}