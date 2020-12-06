package option;

/**
 * @Description
 * @Author tengjiang
 * @Date 2020/12/4 5:41 下午
 **/
public abstract class AbstractOption implements Option{

    private String name;

    private String image;

    public AbstractOption(String name, String image){
        this.name = name;
        this.image = image;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getImage() {
        return this.image;
    }
}
