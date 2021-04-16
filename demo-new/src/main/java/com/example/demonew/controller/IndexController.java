package com.example.demonew.controller;

import com.example.demonew.dao.UserDao;
import com.example.demonew.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.awt.*;
import java.util.*;
import java.util.List;

@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    UserDao userDao;

    /**
     * 首页
     * @return
     */
    @RequestMapping("/index")
    public Map<String,Object> index(Integer params){
        Map<String,Object> result = new HashMap<>();
        //Map<String,Integer> map = startCalculation(getRandom());
        //subAndAdd(params);
        result.put("code","1001");
        result.put("message","操作成功");
       // result.put("map",map);
        getRandom(params);
        return result;
    }


    /**
     * 首页
     * @return
     */
    @RequestMapping("/index2")
    public Map<String,Object> index2(Integer params){
        Map<String,Object> result = new HashMap<>();
        Map<String,Integer> map = startCalculation();
        result.put("code","1001");
        result.put("message","操作成功");
        result.put("map",map);
        return result;
    }

    /**
     * 首页
     * @return
     */
    @RequestMapping("/index3")
    public Map<String,Object> index3(Integer params){
        Map<String,Object> result = new HashMap<>();
        Map<String,Integer> map = startCalculation();
        result.put("code","1001");
        result.put("message","操作成功");
        result.put("map",map);
        subAndAdd(params);
        return result;
    }

    public List<Integer> getRandom(int a){
        List<Integer> list = new ArrayList<>();
        userDao.delete();
        for(int i=1;i<=a;i++){
            int num=(int)(Math.random()*16+1);
            userDao.insert(num,i);
            list.add(num);
        }
        return list;
    }

    public List<Integer> getRandom(){
        List<Integer> list = new ArrayList<>();
        userDao.delete();
        int a = 1000;
        for(int i=1;i<=a;i++){
            int num=(int)(Math.random()*16+1);
            userDao.insert(num,i);
            list.add(num);
        }
        return list;
    }

    public void subAndAdd(int a){
        userDao.delete();
        userDao.delete2();
        int temp = 0;
        for(int i=1;i<=a;i++){
            int num = (int)(Math.random()*16+1);
            if(i>1){
                int sub = num - temp;
                int add = num + temp;
                userDao.insert2(i,sub,add);
            }
            userDao.insert(num,i);
            temp = num;
        }
    }


    public static void main(String[] args) {
        List<Integer> nextList = new ArrayList<>();
        int hitNum = 0;
        for(int i=1;i<=1000000;i++){
            int num=(int)(Math.random()*16+1);
            if(i>1){
                if(nextList.contains(num)){
                    hitNum = hitNum + 1;
                }
            }
            nextList = helloWorld(num);
        }


        System.out.println("命中数量htiNum:"+(hitNum/(double)1000000));
    }


    /**
     * 开始计算
     * @return
     */
    public  Map<String,Integer> startCalculation(){
        List<Integer> list = userDao.getIntegerUserList();
        Map<String,Integer> result = new LinkedHashMap<>();
        //奇数
        int oddNum = 0;
        //偶数
        int evenNum = 0;
        //小区
        int minNum = 0;
        //大区
        int maxNum = 0;
        for(Integer num:list){
            //奇数
            if(!oddOrEven(num)){
                oddNum = oddNum + 1;
            }else{
                //偶数
                evenNum = evenNum + 1;
            }
            //小区大区
            if(minOrMax(num)){
                minNum = minNum + 1;
            }else{
                maxNum = maxNum + 1;
            }
        }

        result.put("1",oddNum);
        result.put("2",evenNum);
        result.put("minNum",minNum);
        result.put("maxNum",maxNum);
        return result;
    }

    /**
     * 奇数偶数
     * @param a
     * @return
     */
    public static boolean oddOrEven(int a) {
        if (a % 2 != 0) {
            //奇数
            return false;
        } else {
            //偶数
            return true;
        }
    }



    /**
     * 奇数偶数
     * @param a
     * @return
     */
    public static boolean minOrMax(double a) {
        double b = 8.5;
        if(a>b){
            return true;
        }else{
            return false;
        }
    }

    public static List<Integer> helloWorld(int num){
        List<Integer> baseNum = new ArrayList<>();
        for(int i=1;i<=16;i++){
            baseNum.add(i);
        }
        List<Integer> list = new ArrayList<>();
        for(int i=15;i<=19;i++){
            int temp = i-num;
            if(baseNum.contains(temp)){
                list.add(temp);
            }
        }

        for(int i=-2;i<=2;i++){
            int temp = i+num;
            if(baseNum.contains(temp)){
                list.add(temp);
            }
        }

        System.out.println("size:"+list.size());
        return list;
    }
}
