public class ConnectorConfig {
    private static final int DEFAULT_MAX_TOTAL= 8;
    private static final int DEFAULT_MAX_IDLE=8;
    private static final int DEFAULT_MIN_IDLE=0;


    private String name;
    private int maxTotal = DEFAULT_MAX_TOTAL;
    private int maxIdle = DEFAULT_MAX_IDLE;
    private int minIdle = DEFAULT_MIN_IDLE;

    public ConnectorConfig(String name, int maxTotal, int maxIdle, int minIdle) {
        this.name = name;
        this.maxTotal = maxTotal;
        this.maxIdle = maxIdle;
        this.minIdle = minIdle;
    }
}
