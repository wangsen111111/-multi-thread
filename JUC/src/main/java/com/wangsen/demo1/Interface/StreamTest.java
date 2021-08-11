package com.wangsen.demo1.Interface;

import java.util.Arrays;
import java.util.List;

/**
 * Description：
 * 题目要求： 用一行代码实现
 * 1. Id 必须是偶数
 * 2.年龄必须大于23
 * 3. 用户名转为大写
 * 4. 用户名倒序
 * 5. 只能输出一个用户
 **/
public class StreamTest {
    public static void main(String[] args) {
        User u1 = new User(1, "a", 23);
        User u2 = new User(2, "b", 23);
        User u3 = new User(3, "c", 23);
        User u4 = new User(6, "d", 24);
        User u5 = new User(4, "e", 25);
        //集合就是存储
        List<User> list= Arrays.asList(u1,u2,u3,u4,u5);
        //计算交给Stream
        list.stream()
                .filter(u->{return u.getId()%2==0;})
                .filter(u->{return u.getAge()>23;})
                .map(u->{return u.getName().toUpperCase();})
                .sorted((x,y)->{return y.compareTo(x);})
                .limit(1)
                .forEach(System.out::println);

    }
}

