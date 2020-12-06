package context;

import reader.ImageReader;
import reader.OptionReader;

/**
 * @Description 上下文
 * @Author tengjiang
 * @Date 2020/12/6 11:55 上午
 **/
public class EatsthApplicationContext {

    private OptionReader optionReader;

    private ImageReader imageReader;

    public OptionReader getOptionReader() {
        return optionReader;
    }

    public void setOptionReader(OptionReader optionReader) {
        this.optionReader = optionReader;
    }

    public ImageReader getImageReader() {
        return imageReader;
    }

    public void setImageReader(ImageReader imageReader) {
        this.imageReader = imageReader;
    }
}
