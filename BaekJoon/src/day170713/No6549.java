package day170713;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by pose2 on 2017-07-13.
 */
public class No6549 {
    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = 1;

        while (N!=0) {

            N = Integer.parseInt(st.nextToken());

            int[] height = new int[N];

            for (int i = 0; i < N; i++) {
                height[i] = Integer.parseInt(st.nextToken());
            }
            System.out.println(findMaxRact(height,0,N-1));
        }

        return;
    }

    public static int findMaxRact(int[] height,int from, int to){
        //기저
        if(from == to) {
            return height[from];
        }
            int tmp = 0;
            int a = findMaxRact(height,0,(from+to)/2);
            int b = findMaxRact(height,(from+to)/2,height.length-1);
            int c = middleMaxRact(height,(from+to)/2);

            return tmp = a>b?a:(b>c)?b:c;
    }

    public static int middleMaxRact(int[] height, int middlePoint){

        int tmp = height[middlePoint];
        int tmp1 = Integer.MAX_VALUE;

        int from = middlePoint;
        int to = middlePoint;

        int minHeight = height[middlePoint];

        while(to<height.length && from>0)
        {
            minHeight = findMinHeight(height,from,to);

            //좌우로 최소높이가 바뀌기 직전까지 넓혀놓고 넓이구해서 tmp1에 저장시킨다.
            while ((to<height.length && from>0) || (minHeight == findMinHeight(height,from,to))) {
                if (to < height.length) {
                    to++;
                }
                if (from > 0) {
                    from--;
                }
            }
            tmp1 = (to - from+1)*minHeight;
            tmp = tmp1>tmp?tmp1:tmp;
        }
        return tmp;
    }
    public static int findMinHeight(int[] height , int from , int to){
        int min = Integer.MAX_VALUE;

        for(int i = from; i<=to; i++){
            min = min>height[i]?height[i]:min;
        }
        return min;
    }
}
