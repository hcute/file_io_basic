package link.hooray.io.buffer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ExerciseSortFile {
    public static void main(String[] args) throws IOException{
        File in = new File("in.txt");
        File out = new File("out.txt");

        BufferedReader bufferedReader = new BufferedReader(new FileReader(in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(out));

        Map<Integer,String> contents = new HashMap<>();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lineInfos = line.split(",");
            contents.put(Integer.valueOf(lineInfos[0]),lineInfos[1]);
        }

        Set<Integer> integers = contents.keySet();
        for (Integer integer : integers) {
            StringBuffer sb = new StringBuffer();
            sb.append(integer);
            sb.append(",");
            sb.append(contents.get(integer));
            bufferedWriter.write(sb.toString());
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        bufferedReader.close();

    }

}
