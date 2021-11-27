package configuration;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"classpath:config/ConfigurationSelenoid.properties"})
public interface ConfigurationSelenoidSets extends Config {

    @Config.Key("auth.login")
    String login();

    @Config.Key("auth.password")
    String password();

}
