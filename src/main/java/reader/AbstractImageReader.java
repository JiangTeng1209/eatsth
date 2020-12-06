package reader;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author tengjiang
 * @Date 2020/12/6 11:39 上午
 **/
public abstract class AbstractImageReader implements ImageReader{

    private Map<String, ImageIcon> imageIconMap = new HashMap<>();

    public void setImageIconMap(Map<String, ImageIcon> imageIconMap) {
        this.imageIconMap = imageIconMap;
    }

    public Map<String, ImageIcon> getImageIconMap() {
        return imageIconMap;
    }

    public ImageIcon put(String name, ImageIcon imageIcon){
        return imageIconMap.put(name, imageIcon);
    }

    public ImageIcon get(String imageName){
        return imageIconMap.get(imageName);
    }

    public boolean contains(String imageName){
        return imageIconMap.containsKey(imageName);
    }
}
