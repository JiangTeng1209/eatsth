package reader;

import option.*;

/**
 * @Description 选项解析器
 * @Author tengjiang
 * @Date 2020/12/6 10:44 上午
 **/
public interface OptionParser extends Parser{

    Option parse(Object object);

    default Option getEligibleOption(String type, String name, String image) {
        switch (type){
            case "外卖":
                return new TakeOut(name, image);
            case "食堂":
                return new Canteen(name, image);
            case "外出":
                return new ToGoOut(name, image);
            default:
                return new Unknown();
        }
    }
}
