package edu.javaee.ssmcrud.bean;


import java.util.HashMap;
import java.util.Map;


/**
 * @program: SSMCRUD
 * @description: 一个返回json数据的通用的返回类
 * @author: 张清
 * @create: 2019-07-21 11:19
 **/
public class Message {
    //返回状态码
    private int stateCode;
    //返回状态信息
    private String mes;
    //用户要返回给浏览器的数据
    private Map<String,Object> extend = new HashMap<String,Object>();

    public static Message success(){
        Message result = new Message();
        result.setStateCode(200);
        result.setMes("处理成功");
        return result;
    }

    public static Message fail(){
        Message result = new Message();
        result.setStateCode(400);
        result.setMes("处理失败");
        return result;
    }

    public Message add(String key,Object value){
        this.getExtend().put(key,value);
        return this;
    }
    public int getStateCode() {
        return stateCode;
    }

    public void setStateCode(int stateCode) {
        this.stateCode = stateCode;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Map<String, Object> getExtend() {
        return extend;
    }

    public void setExtend(Map<String, Object> extend) {
        this.extend = extend;
    }
}
