package cn.rongcapital.resume.mr;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * @author li.hzh 2017-11-07 15:35
 */
@CommonsLog
public class ResumeParseMain {

    public static void main(String[] args) throws Exception {
        log.info("Start resume parse job。。。");
        Configuration conf = new Configuration();
        Job job = Job.getInstance(conf, "Resume Parse");
        job.setJarByClass(ResumeParseMain.class);
        job.setMapperClass(ResumeParseMapper.class);
        job.setCombinerClass(ResumeParseReduce.class);
        job.setReducerClass(ResumeParseReduce.class);
        job.setOutputKeyClass(IntWritable.class);
        job.setOutputValueClass(Text.class);
        FileInputFormat.addInputPath(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }

}
