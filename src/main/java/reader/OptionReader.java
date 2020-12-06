package reader;

import option.Option;

import java.util.List;

/**
 * @Description
 * @Author tengjiang
 * @Date 2020/12/6 10:21 上午
 **/
public interface OptionReader extends Reader{

    List<Option> read();

}
