package org.indy.geored.repomigrator.conf;


import org.commonjava.propulsor.config.annotation.ConfigName;
import org.commonjava.propulsor.config.annotation.SectionName;
import org.indy.geored.repomigrator.core.conf.RepomigratorQueryConfigInfo;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@SectionName("rest")
public class RestConf implements RepomigratorQueryConfigInfo {

    private String indyUrl;

    public String getIndyUrl()
    {
        return indyUrl;
    }

    @ConfigName( "indy.url")
    public void setIndyUrl( String indyUrl )
    {
        this.indyUrl = indyUrl;
    }
}
