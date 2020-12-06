import compent.MainFrame;
import compent.OptionPane;
import compent.Position;
import context.EatsthApplicationContext;
import option.Option;
import utils.RandomUtils;

import javax.swing.*;
import java.util.List;

/**
 * @Description 页面组装工人
 * @Author tengjiang
 * @Date 2020/12/4 5:01 下午
 **/
public class AssemblyWorker {

    private static final String SELECT = "一锤定音";
    private static final String SELECTING = "选取中...";
    private static final String AGAIN = "再来一次？";

    private EatsthApplicationContext eatsthApplicationContext;
    private MainFrame mainFrame;
    private List<Option> options;
    private int readOffset;
    private int maxDisplayNum;
    private volatile boolean randomDisplay = true;
    private volatile int sleep = 2000;
    private Thread thread;
    private JDialog jDialog;


    public AssemblyWorker(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        this.readOffset = 0;
        this.maxDisplayNum = 5;
        this.eatsthApplicationContext = mainFrame.getEatsthApplicationContext();
    }

    public void work(){
        init();
        randomDisplayAll();
        addButtons();
    }

    private void init() {
        options = eatsthApplicationContext.getOptionReader().read();
        eatsthApplicationContext.getImageReader().read();
        this.jDialog = new JDialog();
        jDialog.setLayout(null);
        jDialog.setBounds(950, 400, 300, 200);
    }


    public void randomDisplayAll(){

        thread = new Thread(() -> {
            do {
                tryClean();
                if(!options.isEmpty()){
                    for (int i = 0; i < maxDisplayNum; i++) {
                        int size = options.size();
                        if(readOffset > size - 1){
                            readOffset = 0;
                        }
                        Option option = options.get(readOffset++);
                        int x = RandomUtils.get(0, 700);
                        int y = RandomUtils.get(0, 700);
                        OptionPane optionPane = new OptionPane(mainFrame);
                        optionPane.setPosition(new Position(x, y));
                        optionPane.setOption(option);
                        optionPane.setSize(150);
                        mainFrame.getDisplayArea().add(optionPane.generate());
                        mainFrame.getDisplayArea().revalidate();
                        mainFrame.getDisplayArea().repaint();
                    }
                }
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                }
            } while (randomDisplay);
        });
        thread.start();
    }

    private void tryClean() {
        mainFrame.cleanOptionPanes();
        getDisplayArea().removeAll();
    }

    public void turnAround(){
        new Thread(() -> {
            JPanel displayArea = getDisplayArea();
            List<OptionPane> optionPanes = getOptionPanes();
            do {

                for (OptionPane optionPane : optionPanes) {
                    resetPosition(optionPane);
                    displayArea.remove(optionPane.getJpanel());
                    displayArea.add(optionPane.reGenerate());
                    displayArea.revalidate();
                    displayArea.repaint();
                }


            }while (true);

        }).start();
    }

    private void resetPosition(OptionPane optionPane) {

//        Position position = optionPane.getPosition();
//        int x = position.getX();
//        int y = position.getY();
//        // 圆心 400， 400
////        double r2 = Math.pow(x - 400, 2) + Math.pow(y + 400, 2);
////        double r2 = 400 * 400;
////        // x范围：1-800
//        int speed = 1;
//        int r = position.getR();
//        if(r == -1){
//            r = (int)Math.sqrt(Math.abs(Math.pow(x - 400, 2) + Math.pow(y - 400, 2)));
//        }
//        int x0, y0;
////        int offset = (int)(r * Math.sin(Math.PI/(100/speed)));
//        int yOffset = (int)(0.98480775301221 * r);
//        int xOffset = (int)(0.17364817766693 * r);
//        if(position.isRight()){
//            x0 = x + xOffset;
//            if(x0 <= 400){
//                y0 = y - offset;
//            }else{
//                y0 = y + offset;
//            }
//            if(y0 >= 400){
//                position.setRight(false);
//            }
//        }else{
//            x0 = x - offset;
//            if(x0 >= 400){
//                y0 = y - offset;
//            }else {
//                y0 = y + offset;
//            }
//            if(x0 <= 400){
//                position.setRight(true);
//            }
//        }
////        // 根据圆形方程求Y
////        y = Math.abs((position.isRight() ? (int)Math.sqrt(Math.abs(r2 - Math.pow(x - 400, 2))) : -(int)Math.sqrt(Math.abs(r2 - Math.pow(x - 400, 2)))) - 400);
////        System.out.println(x + ":" + y + ":" + r2);
//
//
//        position.setX(x0);
//        position.setY(y0);
//        System.out.println(x + ":" +y);
    }


    public void addButtons(){
        JPanel buttonsArea = getButtonsArea();


        JButton main = new JButton();
        main.setLayout(null);
        main.setText(SELECT);
        main.setBounds(340, 50,100, 50);

        main.addActionListener((event) -> {
            new Thread(() -> {

                switch (main.getText()){
                    case SELECT:
                        main.setText(SELECTING);
                        main.setEnabled(false);
                        main.revalidate();
                        main.repaint();
                        this.sleep = 20;
                        thread.interrupt();
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        getResult();
                        randomDisplay = false;

                        main.setText(AGAIN);
                        main.setEnabled(true);
                        main.revalidate();
                        main.repaint();
                        break;
                    case AGAIN:
                        jDialog.setVisible(false);
                        main.setText(SELECT);
                        this.sleep = 2000;
                        this.randomDisplay = true;
                        main.revalidate();
                        main.repaint();
                        randomDisplayAll();
                }

            }).start();
//            turnAround();

        });

        buttonsArea.add(main);

        buttonsArea.revalidate();
        buttonsArea.repaint();

    }

    private JPanel getDisplayArea(){
        return mainFrame.getDisplayArea();
    }

    private JPanel getButtonsArea(){
        return mainFrame.getButtonsArea();
    }

    private List<OptionPane> getOptionPanes(){
        return mainFrame.getOptionPanes();
    }

    private void getResult(){
        jDialog.getContentPane().removeAll();
        Option option = randomResult();
        OptionPane optionPane = new OptionPane(mainFrame);
        optionPane.setOption(option);
        optionPane.setSize(200);
        optionPane.setPosition(new Position(50, 25));

        jDialog.getContentPane().add(optionPane.generate());
        jDialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        jDialog.setVisible(true);
    }

    private Option randomResult(){
        int optionNum = RandomUtils.get(0, options.size());
        return options.get(optionNum);
    }

}
