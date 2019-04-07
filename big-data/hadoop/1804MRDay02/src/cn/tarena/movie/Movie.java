package cn.tarena.movie;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;
/**
 * MR框架会按Mapper的输出key排序。具体排序的规则，是有输出key的类型来决定的
 * 实际上是由输出key类型的compareTo()来决定的。
 * 注：MR框架只能按Mapper的输出key排序
 * @author ysq
 *
 */
public class Movie implements WritableComparable<Movie>{
	
	private String name;
	private int hot;

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeUTF(name);
		out.writeInt(hot);
		
	}

	@Override
	public void readFields(DataInput in) throws IOException {
		this.name=in.readUTF();
		this.hot=in.readInt();
		
	}

	@Override
	public int compareTo(Movie o) {
		//--按照热度值做降序排序
		return o.hot-this.hot;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHot() {
		return hot;
	}

	public void setHot(int hot) {
		this.hot = hot;
	}

	@Override
	public String toString() {
		return "Movie [name=" + name + ", hot=" + hot + "]";
	}
	

}
