package io.louvre.templater.config;


import com.eviware.soapui.plugins.PluginAdapter;
import com.eviware.soapui.plugins.PluginConfiguration;


@PluginConfiguration (
        groupId = "io.louvre",
        name = "Testcase Templating Plugin",
        version = "1.0.0",
        description = "A testcase templating plugin for Ready!Api",
        infoUrl = "https://github.com/Tristan-Louvre/readyapi-templating-plugin"
)

public class PluginConfig extends PluginAdapter {
}
