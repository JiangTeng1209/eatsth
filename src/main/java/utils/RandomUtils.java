package utils;

import java.util.Random;

/**
 * @Description
 * @Author tengjiang
 * @Date 2020/12/6 12:43 下午
 **/
public class RandomUtils {

    private static final Random RANDOM = new Random();

    /**
     * 获取指定范围内的随机数(含头不含尾)
     * 范围必须都是大于等于0的整数，并且结束范围 > 开始范围
     * @param begin 开始范围
     * @param end 结束范围
     * @return
     */
    public static int get(int begin, int end){
        int offset = end - begin;
        int num = RANDOM.nextInt(offset);
        return num + begin;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(get(10, 20));
        }
    }

}
