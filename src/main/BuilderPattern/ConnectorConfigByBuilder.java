public class ConnectorConfigByBuilder {

    private String name;
    private int maxTotal;
    private int minTotal;

    private ConnectorConfigByBuilder(Builder builder){
          this.name = builder.name;
          this.maxTotal = builder.maxTotal;
          this.minTotal = builder.minTotal;
    }

    public static class Builder{
        private static final int DEFAULT_MAX_TOTAL=50;
        private static final int DEFAULT_MIN_TOTAL=20;

        private String name;
        private int maxTotal;
        private int minTotal;

        public ConnectorConfigByBuilder build(){
            if("".equals(name)){
                throw  new IllegalArgumentException();
            }

            return new ConnectorConfigByBuilder(this);
        }

        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public int getMaxTotal() {
            return maxTotal;
        }

        public Builder setMaxTotal(int maxTotal) {
            this.maxTotal = maxTotal;
            return this;
        }

        public int getMinTotal() {
            return minTotal;
        }

        public Builder setMinTotal(int minTotal) {
            this.minTotal = minTotal;
            return this;
        }
    }


    public static void main(String[] args) {
        ConnectorConfigByBuilder config = new Builder()
                .setMaxTotal(50)
                .setMinTotal(20)
                .setName("simon").build();

        System.out.println(config);
    }


}
