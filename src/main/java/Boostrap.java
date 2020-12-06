import compent.MainFrame;
import context.EatsthApplicationContext;
import reader.FileOptionReader;
import reader.LocalImageReader;

/**
 * @Description 吃点啥启动类，为吃饭选择困难症的同学准备
 * @Author tengjiang
 * @Date 2020/12/4 4:48 下午
 **/
public class Boostrap {

    public static void main(String[] args) {

        MainFrame mainFrame = MainFrame.getInstance("今天吃点啥？");

        EatsthApplicationContext eatsthApplicationContext = new EatsthApplicationContext();
        eatsthApplicationContext.setOptionReader(new FileOptionReader());
        eatsthApplicationContext.setImageReader(new LocalImageReader());
        mainFrame.setEatsthApplicationContext(eatsthApplicationContext);

        new AssemblyWorker(mainFrame).work();

    }

}
