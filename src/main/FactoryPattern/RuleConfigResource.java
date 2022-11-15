public class RuleConfigResource {

    public RuleConfig load(String ruleConfigFilePath){
        String ruleConfigFileExtension  = getFileExtension(ruleConfigFilePath);
        IRuleConfigParser parser = null;
        // 剥离出来
        if("json".equalsIgnoreCase(ruleConfigFileExtension)){
            parser = new JsonRuleConfigParser();
        }else if("xml".equals(ruleConfigFileExtension)){
            parser = new XmlRuleConfigParser();
        }else if("properties".equalsIgnoreCase(ruleConfigFileExtension)){
            parser  = new PropertiesRuleConfigParser();
        }else {
            System.out.println("exception");
        }
        String configText = "";
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }


    private String getFileExtension(String ruleConfigFilePath) {


        return "";
    }
}
