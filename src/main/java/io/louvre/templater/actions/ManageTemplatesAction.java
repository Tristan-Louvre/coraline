package io.louvre.templater.actions;


import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.plugins.ActionConfiguration;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;
import com.google.inject.Inject;
import com.smartbear.ready.functional.actions.FunctionalActionGroups;


@ActionConfiguration(
        actionGroup = FunctionalActionGroups.FUNCTIONAL_MODULE_TOOLBAR_ACTIONS,
        targetType = ModelItem.class,
        isToolbarAction = true,
        iconPath = ManageTemplatesAction.TOOLBAR_ICON_PATH,
        keyStroke = ManageTemplatesAction.TOOLBAR_ACTION_KEYSTROKE,
        description = ManageTemplatesAction.TOOLBAR_ACTION_DESCRIPTION
)

public class ManageTemplatesAction extends AbstractSoapUIAction<ModelItem> {
    public static final String TOOLBAR_BUTTON_CAPTION = "Templates";
    public static final String TOOLBAR_ACTION_DESCRIPTION = "Manage Project Templates";
    public static final String TOOLBAR_ACTION_KEYSTROKE = "T";
    public static final String TOOLBAR_ICON_PATH = "io/louvre/templater/icons/template-icon_20-20-px.png";

    @Inject
    public ManageTemplatesAction() {
        super(TOOLBAR_BUTTON_CAPTION, TOOLBAR_ACTION_DESCRIPTION);
    }

    @Override
    public void perform(ModelItem modelItem, Object o) {

    }
}

