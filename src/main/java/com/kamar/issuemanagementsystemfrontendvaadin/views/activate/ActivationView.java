package com.kamar.issuemanagementsystemfrontendvaadin.views.activate;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.Autocomplete;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;

import java.awt.*;

/**
 * the user activation route.
 * @author kamar baraka.*/

@Route("activate")
public class ActivationView extends VerticalLayout {

    public ActivationView() {

        /*set the banner and activation form*/
        add(banner(), activationForm());
        /*set alignment*/
        this.setAlignItems(Alignment.CENTER);
    }

    private VerticalLayout banner(){

        /*compose the title*/
        H1 baseTitle = new H1("Issue Management System");
        H2 title = new H2("User Activation");
        /*put them in a layout*/
        VerticalLayout layout = new VerticalLayout(baseTitle, title);
        layout.setAlignItems(Alignment.CENTER);
        Style layoutStyle = layout.getStyle();
        layoutStyle.setBackground(Color.LIGHT_GRAY.brighter().toString());
        layoutStyle.set("border-radius", "10px");

        return layout;
    }

    private VerticalLayout activationForm(){

        /*text field*/
        TextField usernameField = new TextField("username", "someone@example.com");
        usernameField.focus();
        usernameField.setTooltipText("enter the username to activate");
        usernameField.setRequired(true);
        usernameField.setWidth("200");
        usernameField.setAutocomplete(Autocomplete.EMAIL);

        /*activation field*/
        TextField activationTokenField = new TextField("activation token", "XXXX-XXXX-XXXX-XXXX");
        activationTokenField.setRequired(true);
        activationTokenField.setTooltipText("enter the 16 digit activation token");

        /*activation button*/
        Button activateButton = new Button("activate");

        activateButton.setEnabled(false);
        activateButton.addClickListener(click -> UI.getCurrent().navigate("login"));

        activationTokenField.addValueChangeListener(change -> {
            activateButton.setEnabled(true);
            activateButton.getStyle().setBackground("green");
            activateButton.getStyle().setColor("white");
        });

        VerticalLayout activationFormLayout = new VerticalLayout(usernameField, activationTokenField, activateButton);
        activationFormLayout.setAlignItems(Alignment.CENTER);
        activationFormLayout.getStyle().setWidth("200px");
        return activationFormLayout;
    }
}
