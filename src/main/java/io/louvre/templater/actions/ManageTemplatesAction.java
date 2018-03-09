package io.louvre.templater.actions;


import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.ready.LicenseCheckUtils;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;

import com.google.inject.Inject;

public class ManageTemplatesAction extends AbstractSoapUIAction<ModelItem> {
    public static final String TOOLBAR_BUTTON_CAPTION = "TEMPLATES";
    public static final String TOOLBAR_ICON_PATH = "io/louvre/templater/icons/placeholder.png";
    public static final String TOOLBAR_ACTION_DESCRIPTION = "Manage Project Templates";
    public static final String TOOLBAR_ACTION_KEYSTROKE = "T";

    @Inject
    public ManageTemplatesAction() {
        super(TOOLBAR_BUTTON_CAPTION);
    }

    @Override
    public void perform(ModelItem modelItem, Object o) {
        if (!LicenseCheckUtils.userHasAccessToSoapUING()) {
            UISupport.showErrorMessage("To use this feature, you need a SoapUI NG Pro license.\nYou can request a Pro trial at SmartBear.com.");
            return;
        }
    }
}

