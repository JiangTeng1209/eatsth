package utils;

import javax.swing.*;

/**
 * @Description
 * @Author tengjiang
 * @Date 2020/12/4 6:00 下午
 **/
public class ScreenUtils {

    private JFrame jFrame;
    private int width;
    private int height;

    public ScreenUtils(JFrame jFrame){
        this.jFrame = jFrame;
        init();
    }

    private void init(){
        extract();
    }

    public void refresh(){
        extract();
    }

    private void extract(){
        if(jFrame != null){
            this.width = jFrame.getWidth();
            this.height = jFrame.getHeight();
        }
    }

    private int getNum(int minNum, int maxNum){
        return 0;
    }

    public static int getX(){
        return 0;
    }

    public static int getY(){
        return 0;
    }

    public static int getSize(){
        return 0;
    }

}
