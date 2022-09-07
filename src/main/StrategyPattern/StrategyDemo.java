public class StrategyDemo {

    public static void main(String[] args) {
        Strategy strategy = StrategyFactory.getStrategy("a");
        strategy.say();
    }
}
