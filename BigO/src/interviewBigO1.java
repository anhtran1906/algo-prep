/**
 * Created by anhtran on 9/7/17.
 */
public class interviewBigO1 {
    // package whatever; // don't place package name!

/*
You are in an infinite 2D grid where you can move in any of the 8 directions :

 (x,y) to
    (x+1, y),
    (x - 1, y),
    (x, y+1),
    (x, y-1),
    (x-1, y-1),
    (x+1,y+1),
    (x-1,y+1),
    (x+1,y-1)
You are given a sequence of points and the order in which you need to cover the points.
Give the minimum number of steps in which you can achieve it. You start from the first point.
*/
/*
    array of coordinates arr[0] -> arr[1]
    (0,0) -> (1,2) order?

    step
    curX
    curY
    [(0,1),(1,2),(2,3)];
    the output: 2 steps
    x0, y0
    for(i=0->n-1){
        curX = xj
        curY = yj


        step ++;

        xj,yj (j=i+1)
        //check if both curX and curY needs to change

        while(curX != xj){
            curX=  curX+1; //xj > curX
            curX=curX-1 //xj < curX
            step++;
        }
        step = Math.abs(xj-curX);
        while(curY != xj){
            curY=  curY+1;
            curY=curY-1
            step++;
        }
        curX=Math.abs(xj-x0)
        curY=yj-y0
        step++;

    }
    return step;
    [(0, 0), (4, 4)] => 4 steps
    [(0,1),(1,4),(2,3)] //stepx=1; stepy=1 //stepx=2; stepy2=2;

*/

    class myCode
    {
        private class Coord{
            static int x;
            static int y;
            public Coord(x,y){
                this.x = x;
                this.y = y;
            }
        }

        public static int findStep(Coord[] coords){
            int step = 0;
            int curX = 0;
            int curY = 0;
            int i = 0;
            while(i < coords.length-1){
                int xj = coords[i+1].x;
                int yj = coords[i+1].y;


                int difX = Math.abs(xj - curX); //step to get from curX -> xj
                int difY = Math.abs(yj-curY);
                steps+= Integer.max(difX,difY); //step to get from curY -> yj (0,3) (1,5)


            }
            return step;
        }

        public static void main (String[] args) throws java.lang.Exception
        {
            System.out.println("Hello Java");
        }
    }

/*
Given a non-negative number represented as an array of digits,

add 1 to the number ( increment the number represented by the digits ).

The digits are stored such that the most significant digit is at the head of the list.

Example:

If the vector has [1, 2, 3]

the returned vector should be [1, 2, 4]

as 123 + 1 = 124.
*/

//a= [3,2,1] -> [3,2,2] -> return a
//b = [0,2,1] -> [2,2]

import java.io.*;

    class myCode
    {
        public static int[] findNum(int[] arr){
            Stack<Integer> result= new Stack<Integer>();
            int i = 0; //beginning index

            while(i < arr.length && arr[i] == 0){
                // [0, 1] -> [1,0,1]
                i++;
            }
            // [9] -> [1,0]
            //[1,9] -> [2,0]
            // [3, 9, 9] -> [4, 0, 0]
            //stack s
        /*
            count++;
            s.push(0);
            s.push(arr[j]+count);

        */

            int j = arr.length-1;
            int count =0;
            while(j >= 0){
                if(arr[j] == 9 && count==1){
                    count=1;
                    result.push(0);
                }
                else {
                    result.push(arr[j] + count);
                    count--;
                }

            }

            int i = 0;

            int[] arrRes =new int[result.size()];
            while(!result.size().isEmpty){ //{0}
                arrRes[i] = result.pop();
                i++;
            }
        [0]

            return result;

        }



        public static void main (String[] args) throws java.lang.Exception
        {
            System.out.println("Hello Java");
        }
    }

}
