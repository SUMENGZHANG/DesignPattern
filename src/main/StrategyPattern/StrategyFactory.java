import org.apache.commons.lang3.StringUtils;

public class StrategyFactory {

    public static Strategy getStrategy(String type){
        if(StringUtils.isEmpty(type)){
            return null;
        }
        if(type.equals("a")){
            return new StrategyA();
        }else if(type.equals("b")){
            return new StrategyB();
        }

        return null;
    }

}
