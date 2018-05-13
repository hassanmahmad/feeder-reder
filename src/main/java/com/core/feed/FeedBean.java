/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.core.feed;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;


@Stateless
public class FeedBean {
    
    private List<String> listIt = new ArrayList<>(); 
    private static List<String> timeStamp = new ArrayList<>();

    public int calAdd(int a, int b)
    {
        return (a+b);
    }
    
     public List<String> calAdList(String b)
    {
        listIt.add(b);
        String ts = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        timeStamp.add(ts);
        return listIt;
    }
    
    public List<String> getTime()
    {
        return timeStamp;
    }
    
}
