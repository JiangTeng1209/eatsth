package compent;

import context.EatsthApplicationContext;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author tengjiang
 * @Date 2020/12/4 4:51 下午
 **/
public class MainFrame {

    private IndexFrame indexFrame;

    private JPanel mainPanel;

    private JPanel displayArea;

    private JPanel buttonsArea;

    private List<OptionPane> optionPanes =  new ArrayList<>();

    private EatsthApplicationContext eatsthApplicationContext;

    private MainFrame(String title){
        new IndexFrame(title);
    }

    public static MainFrame getInstance(String title){
        return new MainFrame(title);
    }

    public void setEatsthApplicationContext(EatsthApplicationContext eatsthApplicationContext){
        this.eatsthApplicationContext = eatsthApplicationContext;
    }

    public void addOptionPane(OptionPane optionPane){
        optionPanes.add(optionPane);
    }

    public void setIndexFrame(IndexFrame indexFrame) {
        this.indexFrame = indexFrame;
    }

    public void setMainPanel(JPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public void setDisplayArea(JPanel displayArea) {
        this.displayArea = displayArea;
    }

    public void setButtonsArea(JPanel buttonsArea) {
        this.buttonsArea = buttonsArea;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    public EatsthApplicationContext getEatsthApplicationContext() {
        return eatsthApplicationContext;
    }

    public JPanel getDisplayArea() {
        return displayArea;
    }

    public JPanel getButtonsArea() {
        return buttonsArea;
    }

    public List<OptionPane> getOptionPanes() {
        return optionPanes;
    }

    public void cleanOptionPanes(){
        optionPanes.clear();
    }

    class IndexFrame extends JFrame{

        public IndexFrame(String title){
            setLayout(null);
            setTitle(title);
            setBounds(700, 200, 800, 1000);
            // 设置主面板
            addMainPanel();
            // 设置一个展示区域
            addDisplayArea();
            // 设置一个按钮选择区域
            addButtonsArea();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            setIndexFrame(this);
        }

        private void addMainPanel(){
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(null);
            mainPanel.setSize(800, 1000);
            setMainPanel(mainPanel);
            getContentPane().add(mainPanel);
        }

        private void addDisplayArea() {
            JPanel displayArea = new JPanel();
            displayArea.setLayout(null);
            displayArea.setSize(800, 800);
            displayArea.setBackground(Color.CYAN);
            setDisplayArea(displayArea);
            getMainPanel().add(displayArea);
        }

        private void addButtonsArea() {
            JPanel buttonsArea = new JPanel();
            buttonsArea.setLayout(null);
            buttonsArea.setBounds(0, 800, 800, 200);
            buttonsArea.setBackground(Color.GRAY);
            setButtonsArea(buttonsArea);
            getMainPanel().add(buttonsArea);
        }
    }
}
