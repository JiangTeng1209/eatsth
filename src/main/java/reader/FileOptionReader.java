package reader;

import option.Option;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Description 可选项文件读取器
 * @Author tengjiang
 * @Date 2020/12/6 10:23 上午
 **/
public class FileOptionReader implements OptionReader {

    private static final String DEFAULT_OPTION_FILE = "src/main/resources/config/options.list";

    private OptionFileLineParser optionFileLineParser;

    public FileOptionReader(){
        optionFileLineParser = new OptionFileLineParser();
    }

    @Override
    public List<Option> read(){
        try {
            return read(DEFAULT_OPTION_FILE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public List<Option> read(String filePath) throws FileNotFoundException {
        return read(new File(filePath));
    }

    public List<Option> read(File file) throws FileNotFoundException {
        return read(new FileReader(file));
    }

    private List<Option> read(FileReader fileReader) {
        List<Option> options = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        bufferedReader.lines()
                .forEach((line) -> {
                    if(!line.startsWith("#")){
                        System.out.println("读取到："+ line);
                        Option option = parseLine(line);
                        options.add(option);
                    }
                });
        return options;
    }

    private Option parseLine(String line) {
        return optionFileLineParser.parse(line);
    }


}
