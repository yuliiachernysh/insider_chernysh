package configs;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:${env}.properties"})
public interface ConfigProperties extends Config {
    String baseUrl();
    String baseUrlApi();
    Integer defaultTimeout();
    String environment();
    String browser();

}