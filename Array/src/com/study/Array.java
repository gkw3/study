package com.study;

/**
 * 二次封装数组
 * @author 高孔威
 * @version 1.0
 * @Description:
 * @email:gaokw@ffcs.cn
 * @Company: 北京福富软件有限公司
 * @Copyright: Copyright (c) 2015 FFCS All Rights Reserved
 * @history:
 * @创建时间：2018/5/12 上午1:48
 */
public class Array<E> {
    private  E[] data;
    private  int size;

    /**
     * 构造函数，传入容量创建数组
     * @param capacity
     */
    public Array(int capacity){

       data = (E[])new Object[capacity];
    }

    /**
     * 当传入参数为空，容量默认是10
     */
    public Array(){
            this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity(){
        return data.length;
    }

    /**
     * 判断数组是否为空
     * @return
     */
    public  boolean isEmpty(){
        return size==0;
    }

    /**
     * 向数组末尾添加一个元素
     * @param e
     */
    public void addLast(E e){
        add(size,e);
    }

    /**
     * 向数组头部添加一个元素
     * @param e
     */
    public void addFirst(E e){
        add(0,e);
    }


    /**
     * 在第index个位置插入一个元素e
     * @param index
     * @param e
     */
    public void add(int index,E e){

        if(index<0||index>size){
            throw new IllegalArgumentException("Add failed.Require index>=0 and index<=size ");

        }

        if(size==data.length){
            //throw new IllegalArgumentException("Add failed.Array is full ");
            resize(2*data.length);//对数组进行扩容
        }

        //index后面的元素都向后挪一位
        for(int i=size-1;i>=index;i--){
                data[i+1]=data[i];
        }
        data[index] =e;
        size++;

    }

    /**
     * 获取index索引位置元素
     * @return
     */
    public E get(  int index){
        if(index<0||index>=size){

            throw new IllegalArgumentException("Get failed. Index is  illegal");

        }
        return data[index];
    }

    /**
     * 改变index索引位置元素
     * @return
     */
    public E set(int index,E e){
        if(index<0||index>=size){

            throw new IllegalArgumentException("Get failed. Index is  illegal");

        }
        return data[index]=e;
    }


    //查找数组中是否有元素e
    public boolean contains(int e){
        for(int i=0;i<size;i++){
            if(data[i].equals(e))
                return false;
        }

        return false;
    }

    //查找数组中元素e所在的索引,如果不存在元素e，则返回-1
    public int find(E e){

        for(int i=0;i<size;i++){
            if(data[i].equals(e))
                return i ;
        }

        return -1;

    }

    public E remove(int index){
        if(index<0||index>=size){

            throw new IllegalArgumentException("Get failed. Index is  illegal");

        }

        E ret = data[index];
        for(int i=index+1;i<size;i++)
            data[i-1]=data[i];//第index开始往前进1位，长度减少1，即实现删除
        size--;
        data[size]=null;//将size指向的遗留对象置空。手动垃圾回收。

        if(size==data.length/2){//当元素个数小于数组长度1/2的时候
                resize(data.length/2);
        }
        return ret;



    }

    //删除第一个元素
    public E removeFisrst(){
        return remove(0);
    }

    //删除最后一个元素
    public E removeLast(){
        return remove(size-1);
    }

    //删除指定元素
    public void removeElement(E e){
            int index=find(e);
            if(index !=-1){
                remove(index);
            }
    }


    @Override
    public String toString(){
        StringBuilder res=new StringBuilder();
        res.append(String.format("Array size = %d,capcity = %d \n",size,data.length));
        res.append("[");
        for(int i=0;i<size;i++){
            res.append(data[i]);
            if(i!=size-1){
                res.append(", ");
            }else{
                res.append(']');

            }

        }

        return res.toString();
    }

    private void resize(int newCapcity){
        E[] newData = (E[])new Object[newCapcity];
        for(int i=0;i<size;i++){
            newData[i]=data[i];//迁移原数组的值
        }
        data=newData;//原数组变量指向新数组
    }


}
