package cn.rongcapital.bigdata.mr;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;
import java.util.StringTokenizer;

/**
 * @author li.hzh 2017-11-06 15:45
 */
public class ResumeParseMapper extends Mapper<Object, Text, IntWritable, Text> {

    private Text word = new Text();

    public void map(Object key, Text value, Context context
    ) throws IOException, InterruptedException {
        StringTokenizer itr = new StringTokenizer(value.toString());
        IntWritable index = new IntWritable(0);
        while (itr.hasMoreTokens()) {
            word.set(itr.nextToken());
            context.write(index, word);
            index.set(index.get() + 1);
        }
    }

}
