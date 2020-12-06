package compent;

import context.EatsthApplicationContext;
import option.Option;
import reader.AbstractImageReader;

import javax.swing.*;
import java.awt.*;

/**
 * @Description 选项面板
 * @Author tengjiang
 * @Date 2020/12/4 5:54 下午
 **/
public class OptionPane {

    private Position position;

    private int size;

    private Option option;

    private JPanel jpanel;

    private EatsthApplicationContext eatsthApplicationContext;

    public OptionPane(MainFrame mainFrame){
        mainFrame.addOptionPane(this);
        eatsthApplicationContext = mainFrame.getEatsthApplicationContext();
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public Position getPosition() {
        return position;
    }

    public int getSize() {
    return size;
    }

    public Option getOption() {
    return option;
}

    public JPanel getJpanel() {
        return jpanel;
    }

    public EatsthApplicationContext getEatsthApplicationContext() {
        return eatsthApplicationContext;
    }

    public JPanel generate() {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(2, 1));
        jPanel.setBounds(getPosition().getX(), getPosition().getY(), getSize(), getSize());
        jPanel.setBackground(null);
        jPanel.setOpaque(false);

        JLabel image = new JLabel(getImageIcon(getOption().getImage()));
        image.setLayout(null);
        JLabel name = new JLabel(getOption().getName());
        name.setLayout(null);
        name.setHorizontalAlignment(SwingConstants.CENTER);
        name.setVerticalAlignment(SwingConstants.TOP);
        name.setBounds(0, getSize(), getSize(), size/2);
        jPanel.add(image);
        jPanel.add(name);
        this.jpanel = jPanel;
        return jPanel;
    }

    public ImageIcon getImageIcon(String imageName){
        AbstractImageReader imageReader = (AbstractImageReader) eatsthApplicationContext.getImageReader();
        if(imageReader.contains(imageName)){
            return imageReader.get(imageName);
        }
        return imageReader.get("未知.jpg");
    }

    public JPanel reGenerate(){
        return generate();
    }
}
