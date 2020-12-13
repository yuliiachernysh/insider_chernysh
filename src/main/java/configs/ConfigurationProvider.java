package configs;
import org.aeonbits.owner.ConfigFactory;

public class ConfigurationProvider {
    public static ConfigProperties getConfiguration() {
        String environmentName = System.getProperty("TestEnvironment");
        ConfigFactory.setProperty("env", environmentName);

        return ConfigFactory.create(ConfigProperties.class);
    }
}
