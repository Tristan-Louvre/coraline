package io.louvre.templater.actions;

import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.plugins.ActionConfiguration;
import com.smartbear.ready.functional.actions.FunctionalActionGroups;


import static io.louvre.templater.actions.ManageTemplatesAction.*;

@ActionConfiguration(
        actionGroup = FunctionalActionGroups.FUNCTIONAL_MODULE_TOOLBAR_ACTIONS,
        targetType = ModelItem.class,
        description = TOOLBAR_ACTION_DESCRIPTION,
        iconPath = TOOLBAR_ICON_PATH,
        isToolbarAction = true,
        keyStroke = TOOLBAR_ACTION_KEYSTROKE
)

public class SoapUINGManageTemplateAction extends ManageTemplatesAction{

}
