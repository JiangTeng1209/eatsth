package reader;

import javax.swing.*;
import java.util.Map;

/**
 * @Description
 * @Author tengjiang
 * @Date 2020/12/6 11:37 上午
 **/
public interface ImageReader extends Reader {

    Map<String, ImageIcon> read();

}
