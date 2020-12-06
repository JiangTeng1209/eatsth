package option;

/**
 * @Description 食堂
 * @Author tengjiang
 * @Date 2020/12/4 5:39 下午
 **/
public class Canteen extends AbstractOption{

    public Canteen(String name, String image){
        super(name, image);
    }

    @Override
    public OptionTypeEnum getType() {
        return OptionTypeEnum.CANTEEN;
    }

}
