package compent;

/**
 * @Description 位置
 * @Author tengjiang
 * @Date 2020/12/4 5:55 下午
 **/
public class Position {

    private int x;

    private int y;

    private int r = -1;

    private boolean right = true;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
        if(y >= 400){
            right = false;
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void setRight(boolean right){
        this.right = right;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getR() {
        return r;
    }

    public boolean isRight(){
        return right;
    }

}
