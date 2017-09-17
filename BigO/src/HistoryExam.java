import java.util.*;
import java.io.*;

/**
 * Created by anhtran on 7/8/17.
 */
public class HistoryExam {
    static class FastInput
    {
        final private int BUFFER_SIZE = 1 << 16;

        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastInput(InputStream in)
        {
            din = new DataInputStream(in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public long nextLong() throws Exception
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = c == '-';
            if (neg) c = read();
            do
            {
                ret = ret * 10 + c - '0';
                c = read();
            } while (c > ' ');
            if (neg) return -ret;
            return ret;
        }

        //reads in the next string
        public String next() throws Exception
        {
            StringBuilder ret =  new StringBuilder();
            byte c = read();
            while (c <= ' ') c = read();
            do
            {
                ret = ret.append((char)c);
                c = read();
            } while (c > ' ');
            return ret.toString();
        }

        public int nextInt() throws Exception
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = c == '-';
            if (neg) c = read();
            do
            {
                ret = ret * 10 + c - '0';
                c = read();
            } while (c > ' ');
            if (neg) return -ret;
            return ret;
        }

        private void fillBuffer() throws Exception
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws Exception
        {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
    }
    public static void main(String[] args) throws Exception{
        FastInput sc = new FastInput(System.in);
        int teacherDates = sc.nextInt();
        Set<Long> givenDates = new HashSet<Long>();
        for(int i = 0; i < teacherDates; i++){
            givenDates.add(sc.nextLong());

        }
        int studDates = sc.nextInt();
        TreeMap<Long,Integer> studentDates = new TreeMap<>();
        for(int i = 0; i < studDates; i++){
            long date = sc.nextLong();
            if(!studentDates.containsKey(date)){
                studentDates.put(date,1);
            }
            else {
                studentDates.put(date,studentDates.get(date)+1);
            }
        }

        int result = 0;
        for(long date: givenDates){
            if(studentDates.containsKey(date)){
                result+=studentDates.get(date);
            }
        }

        System.out.println(result);

    }
}
