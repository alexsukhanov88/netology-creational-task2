import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (int value : source) {
            if (value < treshold) {
                logger.log("Элемент \"" + value + "\" не проходит");
            } else {
                logger.log("Элемент \"" + value + "\" проходит");
                result.add(value);
            }
        }
        logger.log("Прошло фильтр " + result.size() + " из " + source.size());
        return result;
    }
}