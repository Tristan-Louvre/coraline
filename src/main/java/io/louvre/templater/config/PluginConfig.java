package io.louvre.templater.config;

import com.eviware.soapui.plugins.PluginAdapter;
import com.eviware.soapui.plugins.PluginConfiguration;

@PluginConfiguration (
        groupId = "io.louvre",
        name = "Testcase Templating Plugin",
        version = "1.0.0",
        description = "A testcase templating plugin for ready!api",
        infoUrl = "https://github.com/Tristan-Louvre/coraline"
)

public class PluginConfig extends PluginAdapter {
}
