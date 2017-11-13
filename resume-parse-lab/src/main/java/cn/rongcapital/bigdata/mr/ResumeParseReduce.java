package cn.rongcapital.bigdata.mr;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @author li.hzh 2017-11-06 17:06
 */
public class ResumeParseReduce extends Reducer<IntWritable, Text, IntWritable, Text> {

    private IntWritable result = new IntWritable();

    public void reduce(IntWritable key, Iterable<Text> values,
                       Context context
    ) throws IOException, InterruptedException {
        IntWritable totalCount = new IntWritable(111111);
        IntWritable zhilianCount = new IntWritable(222222);
        context.write(totalCount, new Text("Total Count"));
        context.write(zhilianCount, new Text("ZhiLian Count"));
    }
}
