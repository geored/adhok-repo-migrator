package org.indy.geored.repomigrator.core.conf;

import org.commonjava.propulsor.config.annotation.ConfigName;
import org.commonjava.propulsor.config.annotation.SectionName;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;



@Default
@ApplicationScoped
public class DefaultRepomigratorQueryConfig implements RepomigratorQueryConfigInfo {

    private String configDir;

    public String getConfigDir()
    {
        return configDir;
    }

    @ConfigName( "config.dir" )
    public void setConfigDir( String configDir )
    {
        this.configDir = configDir;
    }


}
