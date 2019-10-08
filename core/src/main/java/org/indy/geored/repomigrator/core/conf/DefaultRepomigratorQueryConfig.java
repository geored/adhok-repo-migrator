package org.indy.geored.repomigrator.core.conf;

import java.io.InputStream;
import java.util.Properties;
import org.commonjava.propulsor.config.annotation.ConfigName;
import org.commonjava.propulsor.config.annotation.SectionName;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import org.commonjava.propulsor.config.DefaultConfigurationListener;

@Default
@SectionName(DefaultRepomigratorQueryConfig.CONFIG_DIR_SECTOR)
@ApplicationScoped
public class DefaultRepomigratorQueryConfig extends DefaultConfigurationListener implements RepomigratorQueryConfigInfo, SystemPropertyProvider {
	
	
	protected static final String CONFIG_DIR_SECTOR = "dir";
	
	private String configDir;

	public String getConfigDir() {
		return configDir;
	}

	@ConfigName("config.dir")
	public void setConfigDir(String configDir) {
		this.configDir = configDir;
	}

	@Override
	public String getDefaultConfigFileName() {
		return RepomigratorQueryConfigInfo.APPEND_DEFAULTS_TO_MAIN_CONF;
	}

	@Override
	public InputStream getDefaultConfig() {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream("./etc/main.conf");
	}

	@Override
	public Properties getSystemProperties() {
		Properties props = new Properties();
		return props;
	}

}
