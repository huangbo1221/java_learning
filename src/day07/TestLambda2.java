package day07;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName TestLambda2
 * @Description 进一步加深对lambda表达式的理解
 * @Author huangbo1221
 * @Date 2021/8/21 10:21
 * @Version 1.0
 */
public class TestLambda2 {
    public static void main(String[] args) {
        Lambda2 lambda2 = null;
        // 1、参数显示指定
        lambda2 = (String str2) ->System.out.println("lambda " + str2);
        lambda2.know("niupi1");
        // 2、去掉参数的定义
        lambda2 = (str2) ->System.out.println("lambda " + str2);
        lambda2.know("niupi2");
        // 3、去掉参数括号
        lambda2 = str2 ->System.out.println("lambda " + str2);
        lambda2.know("niupi3");



        List<String> list = new ArrayList<>();
        list.add("huangbo1221");
        list.add("");
        list.add("liubo");
        System.out.println(list);

        // 下面也用到了lambda表达式，若有多行，则必须用代码块包起来
        list = list.stream().filter(str -> {
            if (str != "") {
                System.out.println("hahahha");
                return true;
            }
            return false;
        }).collect(Collectors.toList());
        System.out.println(list);

    }
}

interface Lambda2 {
    void know(String str);
}
