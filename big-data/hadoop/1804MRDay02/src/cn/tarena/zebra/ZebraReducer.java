package cn.tarena.zebra;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class ZebraReducer extends Reducer<Text,HttpAppHost,HttpAppHost,NullWritable>{

	@Override
	protected void reduce(Text key, Iterable<HttpAppHost> values,
			Reducer<Text, HttpAppHost, HttpAppHost, NullWritable>.Context context)
					throws IOException, InterruptedException {
		
		HttpAppHost result=new HttpAppHost();
		
		for(HttpAppHost value:values){
			result.setReportTime(value.getReportTime());
			result.setCellid(value.getCellid());
			result.setAppType(value.getAppType());
			result.setAppSubtype(value.getAppSubtype());
			result.setUserIP(value.getUserIP());
			result.setUserPort(value.getUserPort());
			result.setAppServerIP(value.getAppServerIP());
			result.setAppServerPort(value.getAppServerPort());
			
			//--累加总的接收次数
			result.setAccepts(result.getAccepts()+value.getAccepts());
			//--累加总的请求次数
			result.setAttempts(result.getAttempts()+value.getAttempts());
			//--累加总的下行流量
			result.setTrafficDL(result.getTrafficDL()+value.getTrafficDL());
			//--累加总的上行流量
			result.setTrafficUL(result.getTrafficUL()+value.getTrafficUL());
			//--累加重传下行流量
			result.setRetranDL(result.getRetranDL()+value.getRetranDL());
			//--累加重传上行流量
			result.setRetranUL(result.getRetranUL()+value.getRetranUL());
			//--累加总的请求时长
			result.setTransDelay(result.getTransDelay()+value.getTransDelay());	
		}
		
		context.write(result, NullWritable.get());
	}
}
