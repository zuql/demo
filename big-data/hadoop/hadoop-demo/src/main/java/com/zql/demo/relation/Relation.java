package com.zql.demo.relation;

import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

/**
 * 人物关系
 */
public class Relation implements Writable {
    private String father;
    private String son;

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeUTF(father);
        out.writeUTF(son);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
       this.father=in.readUTF();
       this.son=in.readUTF();
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getSon() {
        return son;
    }

    public void setSon(String son) {
        this.son = son;
    }

    @Override
    public String toString() {
        return "Relation{" +
                "father='" + father + '\'' +
                ", son='" + son + '\'' +
                '}';
    }
}
