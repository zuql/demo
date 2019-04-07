package com.zql.demo.relation;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class RelationPartitioner extends Partitioner<Text,Relation> {
    @Override
    public int getPartition(Text text, Relation relation, int i) {
        return 0;
    }
}
