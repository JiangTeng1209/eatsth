package option;

/**
 * @Description 外卖
 * @Author tengjiang
 * @Date 2020/12/4 5:38 下午
 **/
public class TakeOut extends AbstractOption{

    public TakeOut(String name, String image){
        super(name, image);
    }

    @Override
    public OptionTypeEnum getType() {
        return OptionTypeEnum.TAKE_OUT;
    }
}
