package com.beans;

import java.util.Arrays;

/**
 * 定义一容器对象(用户借助此容器存储多个任意对象)
 * 1)无界容器
 * 2)对象存储在连续存储空间
 * 3)提供存和取的方法
 * 4)容器存取对象要遵循FIFO算法(先进先出算法)
 */
public class Container {
	/**存储对象的数组*/
    private Object[] array;
    /**记录有效元素个数*/
    private int size;
    public Container(){
    	this(10);
    }
    public Container(int cap){//cap表示容量
    	array=new Object[cap];
    }
    /**永远把数据放到size位置*/
    public synchronized void add(Object obj){
      //1.判定容器是否已满，假如满了则扩容
        if(array.length==size){
           //方式1
           /*Object[] newArray=new Object[2*array.length];
           for(int i=0;i<array.length;i++){
        	   newArray[i]=array[i];
           }
           array=newArray;*/
           //方式2
          array=Arrays.copyOf(array, 2*array.length);
        }
      //2.放数据(对象)
        array[size]=obj;
      //3.有效元素个数加1
        size++;
    }
    /**永远从0位置开始取*/
    public synchronized Object remove(){
    	//1.判定容器是否为空
    	if(size==0)return null;
    	//2.从容器获取数据(第一个)
    	Object obj=array[0];
    	//3.移动元素
    	System.arraycopy(
    			array,//src 原数组
    			1,//srcPos 从哪个位置开始拷贝
    			array, //dest 目标数组
    			0,//destPost 从哪个位置开始放
    			size-1);//length拷贝个数
        //4.有效元素个数减一
    	size--;
    	//5.最后一个有效元素置为空
    	array[size]=null;
    	//6.返回元素
    	return obj;
    }

}
