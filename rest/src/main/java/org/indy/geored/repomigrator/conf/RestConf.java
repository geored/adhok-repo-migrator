package org.indy.geored.repomigrator.conf;


import java.io.InputStream;
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

	@Override
	public String getDefaultConfigFileName() {
		return RepomigratorQueryConfigInfo.APPEND_DEFAULTS_TO_MAIN_CONF;
	}

	@Override
	public InputStream getDefaultConfig() {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream("./etc/main.conf");
	}
}
