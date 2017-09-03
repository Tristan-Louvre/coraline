package io.louvre.templater.actions;

import com.eviware.soapui.impl.WorkspaceImpl; // Not sure about this
import com.eviware.soapui.plugins.ActionConfiguration;
import com.eviware.soapui.support.StringUtils;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;
import com.eviware.x.form.XFormDialog;
import com.eviware.x.form.support.ADialogBuilder;
import com.eviware.x.form.support.AField;
import com.eviware.x.form.support.AField.AFieldType; // Don't thing this ref is correct.
import com.eviware.x.form.support.AForm;

import static com.eviware.soapui.support.action.ActionGroups.WORKSPACE_ACTIONS;

import java.io.File;

@ActionConfiguration (
        actionGroup = WORKSPACE_ACTIONS  // Still trying to figure out if this is the correct way to ref actionGroups
//        beforeAction = ,
//        afterAction = ,
//        description = ,
//        defaultAction = ,
//        iconPath = ,
//        keyStroke = ,
//        separatorBefore = ,
//        separatorAfter = ,
//        isToolbarAction =
)
public class ManageTemplatesAction extends AbstractSoapUIAction<WorkspaceImpl> { // The value between the arrow braces is not correct
    private XFormDialog dialog;

    public ManageTemplatesAction() {
        super("Manage TestCase Templates", "Manage TestCase templates in Ready! API");
    }

    @Override
    public void perform(WorkspaceImpl workspace, Object param) { // WorkspaceImpl may not be correct
        if (dialog == null) {
            dialog = ADialogBuilder.buildDialog(Form.class);
        } else {
            dialog.setValue(Form.POSTMAN_COLLECTION_FILE, "");
        }

        while (dialog.show()) {
            try {
                String fieldValue = dialog.getValue(Form.POSTMAN_COLLECTION_FILE);
                if (StringUtils.hasContent(fieldValue)) {
                    String filePath = fieldValue.trim();
                    if (StringUtils.hasContent(filePath)) {
                        if (new File(filePath).exists()) {
                            PostmanImporter importer = new PostmanImporter(new GuiTestCreator());
                            importer.importPostmanCollection(workspace, filePath);
                        }
                        break;
                    }
                }
            } catch (Exception ex) {
                UISupport.showErrorMessage(ex);
            }
        }
    }

    @AForm(name = "hi1", description = "hi2")
    public interface Form {
        @AField(name = "hi3", description = "hi4", type = AFieldType.FILE)
        String POSTMAN_COLLECTION_FILE = "Postman Collection";
    }
}

