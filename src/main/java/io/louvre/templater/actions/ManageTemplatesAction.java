//package io.louvre.templater.actions;
//
//
//import com.eviware.soapui.impl.WorkspaceImpl;
//import com.eviware.soapui.plugins.ActionConfiguration;
//import com.eviware.soapui.support.StringUtils;
//import com.eviware.soapui.support.UISupport;
//import com.eviware.soapui.support.action.support.AbstractSoapUIAction;
//import com.eviware.x.form.XFormDialog;
//import com.eviware.x.form.support.ADialogBuilder;
//import com.eviware.x.form.support.AField;
//import com.eviware.x.form.support.AField.AFieldType;
//import com.eviware.x.form.support.AForm;
//
//import java.io.File;
//
//import static com.eviware.soapui.support.action.ActionGroups.WORKSPACE_ACTIONS;
//
//
//@ActionConfiguration(
//        actionGroup = WORKSPACE_ACTIONS,
//        afterAction = "ClearWorkspaceAction",
//        keyStroke = "T",
//        separatorBefore = true,
//        separatorAfter = true
//)
//public class ManageTemplatesAction extends AbstractSoapUIAction<WorkspaceImpl> {
//    private XFormDialog dialog;
//
//    public ManageTemplatesAction() {
//        super("Manage TestCase Templates", "Manage TestCase templates in Ready! API");
//    }
//
//    @Override
//    public void perform(WorkspaceImpl workspace, Object param) {
//        if (dialog == null) {
//            dialog = ADialogBuilder.buildDialog(Form.class);
//        } else {
//            dialog.setValue(Form.POSTMAN_COLLECTION_FILE, "");
//        }
//
//        while (dialog.show()) {
//            try {
//                String fieldValue = dialog.getValue(Form.POSTMAN_COLLECTION_FILE);
//                if (StringUtils.hasContent(fieldValue)) {
//                    String filePath = fieldValue.trim();
//                    if (StringUtils.hasContent(filePath)) {
//                        if (new File(filePath).exists()) {
//                            //PostmanImporter importer = new PostmanImporter(new GuiTestCreator());
//                            //importer.importPostmanCollection(workspace, filePath);
//                            return;
//                        }
//                        break;
//                    }
//                }
//            } catch (Exception ex) {
//                UISupport.showErrorMessage(ex);
//            }
//        }
//    }
//
//    @AForm(name = "hi1", description = "hi2")
//    public interface Form {
//        @AField(name = "hi3", description = "hi4", type = AFieldType.FILE)
//        String POSTMAN_COLLECTION_FILE = "Postman Collection";
//    }
//}

