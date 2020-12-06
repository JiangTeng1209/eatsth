package option;

/**
 * @Description 未知选项
 * @Author tengjiang
 * @Date 2020/12/4 5:45 下午
 **/
public class Unknown extends AbstractOption{

    public Unknown(){
        super("我是谁，我在哪？", "未知.jpg");
    }

    @Override
    public OptionTypeEnum getType() {
        return OptionTypeEnum.UNKNOWN;
    }

}
