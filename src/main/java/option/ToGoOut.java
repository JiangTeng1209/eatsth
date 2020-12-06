package option;

/**
 * @Description
 * @Author tengjiang
 * @Date 2020/12/4 5:39 下午
 **/
public class ToGoOut extends AbstractOption{

    public ToGoOut(String name, String image){
        super(name, image);
    }

    @Override
    public OptionTypeEnum getType() {
        return OptionTypeEnum.TO_GO_OUT;
    }
}
