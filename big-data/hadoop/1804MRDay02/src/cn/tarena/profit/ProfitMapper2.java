package cn.tarena.profit;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class ProfitMapper2 extends Mapper<LongWritable,Text,Profit,NullWritable>{
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Profit, NullWritable>.Context context)
			throws IOException, InterruptedException {
		String line=value.toString();
		Profit p=new Profit();
		p.setName(line.split("\t")[0]);
		p.setProfit(Integer.parseInt(line.split("\t")[1]));
		
		context.write(p, NullWritable.get());
		
	}
}
