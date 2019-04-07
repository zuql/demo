package com.zql.demo.relation;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.mortbay.util.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RelationReducer extends Reducer<Text,Relation,Text, NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<Relation> values, Context context) throws IOException, InterruptedException {
        List<Relation> relations=new ArrayList<Relation>();
        for(Relation relation:values){
            Relation relation1=new Relation();
            relation1.setFather(relation.getFather());
            relation1.setSon(relation.getSon());
            relations.add(relation1);
        }

        if(relations.size()>1){
            Map<String,String> yesuns=new HashMap<String, String>();
            for(Relation relation1:relations){
                String sun="";
                if(yesuns.get(relation1.getFather())!=null){
                    sun=yesuns.get(relation1.getFather());
                }
                for(Relation relation2:relations){
                    if(StringUtil.nonNull(relation1.getSon()).equals(relation2.getFather())){
                        sun+=relation2.getSon()+",";
                    }
                }
                if (!"".equals(sun)) {
                    yesuns.put(relation1.getFather(),sun);
                }
            }
            for(String ye:yesuns.keySet()){
                String suns=yesuns.get(ye);
                suns=suns.substring(0,suns.length()-1);
                String value="爷爷辈:"+ye+"-->孙子辈:"+suns;
                System.out.println(value);
                context.write(new Text(value.getBytes()),NullWritable.get());

            }

        }
    }
}
