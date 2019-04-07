package com.zql.demo.relation;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class RelationMapper extends Mapper<LongWritable, Text,Text,Relation> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        String line=value.toString();
        Relation relation=new Relation();
        String[] lines=line.split(" ");
        relation.setSon(lines[0]);
        relation.setFather(lines[1]);
        context.write(new Text(relation.getFather()),relation);
        context.write(new Text(relation.getSon()),relation);
    }
}
