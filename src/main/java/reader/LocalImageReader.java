package reader;

import javax.swing.*;
import java.io.File;
import java.util.Map;

/**
 * @Description
 * @Author tengjiang
 * @Date 2020/12/6 11:24 上午
 **/
public class LocalImageReader extends AbstractImageReader{

    private static final String DEFAULT_IMAGE_PATH = "src/main/resources/images/";

    @Override
    public Map<String, ImageIcon> read() {
        File dir = new File(DEFAULT_IMAGE_PATH);
        String[] fileNames = dir.list();
        for (String fileName : fileNames) {
            ImageIcon imageIcon = new ImageIcon(DEFAULT_IMAGE_PATH + fileName);
            put(fileName, imageIcon);
        }
        return getImageIconMap();
    }

    @Override
    public ImageIcon get(String imageName) {
        return super.get(imageName);
    }

    @Override
    public boolean contains(String imageName) {
        return super.contains(imageName);
    }
}
