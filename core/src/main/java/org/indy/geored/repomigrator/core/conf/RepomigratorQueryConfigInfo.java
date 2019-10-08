package org.indy.geored.repomigrator.core.conf;

import java.io.InputStream;

public interface RepomigratorQueryConfigInfo {
	
	String APPEND_DEFAULTS_TO_MAIN_CONF = "main.conf";

    String CONF_INCLUDES_DIR = "conf";

    /**
     * The name of the file to be written in case no configuration is provided, to allow modification of defaults in future executions.
     * @return a filename, of the form *.conf (unless it's 'main.conf', in which case it'll be appended to the main config file),
     *  which will be written to the etc/indy/conf.d directory.
     */
    String getDefaultConfigFileName();

    /**
     * The actual content which should be added to the default configuration file in case no configuration is provided, to allow modification of
     * defaults in future executions.
     *
     * @return The content, usually as a result of loading Thread.currentThread().getContextClassLoader().getResourceAsStream("foo")
     */
    InputStream getDefaultConfig();
}
