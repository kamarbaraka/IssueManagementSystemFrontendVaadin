package com.kamar.issuemanagementsystemfrontendvaadin.views.ticket;

import com.kamar.issuemanagementsystemfrontendvaadin.views.dashboard.UserDashboard;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;


/**
 * the creation issue component.
 * @author kamar baraka.*/

@Route("createIssue")
public class CreateIssueComp extends VerticalLayout {

    public CreateIssueComp() {

        /*raise button*/
        Button raiseIssueButton = new Button("raise Issue");
        raiseIssueButton.setEnabled(false);
        raiseIssueButton.addClickListener(click -> {});

        /*cancel button*/
        Button cancelButton = new Button("cancel");
        cancelButton.setEnabled(false);

        /*the issue title*/
        TextField titleField = new TextField("Issue title", "Fees");
        titleField.setTooltipText("enter a short description of your issue.");
        titleField.setRequired(true);
        titleField.addValueChangeListener(change -> cancelButton.setEnabled(true));

        /*the description area*/
        TextArea descriptionTextArea = new TextArea("Issue description", "extensive description of your issue");
        descriptionTextArea.setTooltipText("extensive description of your Issue");
        descriptionTextArea.addValueChangeListener(change -> raiseIssueButton.setEnabled(true));

        cancelButton.addClickListener(click -> {
            titleField.clear();
            descriptionTextArea.clear();
        });

        HorizontalLayout buttonLayout = new HorizontalLayout(raiseIssueButton, cancelButton);
        buttonLayout.setAlignItems(Alignment.BASELINE);

        VerticalLayout issueLayout = new VerticalLayout(titleField, descriptionTextArea, buttonLayout);

        HorizontalLayout genLayout = new HorizontalLayout(UserDashboard.sideNav(), issueLayout);

        this.add(genLayout);
    }

}
