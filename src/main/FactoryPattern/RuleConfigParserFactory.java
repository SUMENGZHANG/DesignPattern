public class RuleConfigParserFactory {
    public static IRuleConfigParser createParser(String configFormat){
        IRuleConfigParser parser = null;
        if("json".equalsIgnoreCase(configFormat)){
            parser = new JsonRuleConfigParser();
        }else if("xml".equals(configFormat)){
            parser = new XmlRuleConfigParser();
        }else if("properties".equalsIgnoreCase(configFormat)){
            parser  = new PropertiesRuleConfigParser();

        }else {

            System.out.println("exception");

        }
        return parser;
    }
}
