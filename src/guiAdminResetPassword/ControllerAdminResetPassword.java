package guiAdminResetPassword;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import guiNewAccount.ModelNewAccount;
import database.Database;
import entityClasses.User;
import guiAdminHome.ViewAdminHome;

public class ControllerAdminResetPassword {

    private static Database theDatabase =
            applicationMain.FoundationsMain.database;

    // Store the admin who opened this page
    protected static User adminUser;

    protected static void initialize(User user) {

        // Save admin for Cancel navigation
        adminUser = user;

        // Populate user dropdown
        ObservableList<String> users =
                FXCollections.observableArrayList(theDatabase.getUserList());

        ViewAdminResetPassword.combo_Users.setItems(users);

        // Reset button
        ViewAdminResetPassword.button_Reset
                .setOnAction(e -> handleReset());

        // Cancel button → return to Admin Home
        ViewAdminResetPassword.button_Cancel.setOnAction(e ->
                ViewAdminHome.displayAdminHome(
                        ViewAdminResetPassword.theStage,
                        adminUser
                )
        );
    }

    private static void handleReset() {

        String username =
                ViewAdminResetPassword.combo_Users.getValue();
        String newPassword =
                ViewAdminResetPassword.text_NewPassword.getText();
        String confirm =
                ViewAdminResetPassword.text_ConfirmPassword.getText();

        if (username == null || username.equals("<Select a User>")) {
            showError("Please select a user.");
            return;
        }

        if (!newPassword.equals(confirm)) {
            showError("Passwords do not match.");
            return;
        }

        String validation =
                ModelNewAccount.validatePassword(newPassword);

        if (!validation.isEmpty()) {
            showError(validation);
            return;
        }

        theDatabase.updatePassword(username, newPassword);

        showInfo("Password reset successfully.");

        ViewAdminResetPassword.text_NewPassword.clear();
        ViewAdminResetPassword.text_ConfirmPassword.clear();
    }

    private static void showError(String msg) {
        Alert a = new Alert(AlertType.ERROR);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    private static void showInfo(String msg) {
        Alert a = new Alert(AlertType.INFORMATION);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }
}
