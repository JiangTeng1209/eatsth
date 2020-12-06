package reader;

import option.Option;

/**
 * @Description 选项行解析器
 * @Author tengjiang
 * @Date 2020/12/6 10:44 上午
 **/
public class OptionFileLineParser implements OptionParser{

    @Override
    public Option parse(Object object) {
        if(object instanceof String){
            String[] multiInfo = ((String)object).split(",");
            String type = get(multiInfo, 0);
            String name = get(multiInfo, 1);
            String image = get(multiInfo, 2);
            Option option = getEligibleOption(type, name, image);
            return option;
        }
        throw new IllegalArgumentException("只支持解析参数为String类型的Option");
    }

    private String get(String[] multiInfo, int index){
        if(multiInfo.length-1 >= index){
            return multiInfo[index];
        }
        return null;
    }
}
