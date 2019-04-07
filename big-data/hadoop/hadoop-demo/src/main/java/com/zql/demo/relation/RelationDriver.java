package com.zql.demo.relation;

import com.zql.util.StaticResource;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class RelationDriver {
    public static void main(String[] args) throws Exception {
        Configuration conf=new Configuration();
        Job job=Job.getInstance(conf);
        job.setJarByClass(RelationDriver.class);
        job.setMapperClass(RelationMapper.class);
        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(Relation.class);
        job.setReducerClass(RelationReducer.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(NullWritable.class);
        job.setNumReduceTasks(1);
        job.setPartitionerClass(RelationPartitioner.class);
        FileInputFormat.setInputPaths(job,new Path("hdfs://" + StaticResource.getIp() + ":9000/relation"));
        FileOutputFormat.setOutputPath(job,new Path("hdfs://"+StaticResource.getIp()+":9000/relation/result"));
        job.waitForCompletion(true);
    }
}
