package com.kamar.issuemanagementsystemfrontendvaadin.views.register;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;


/**
 * the normal user's home page.
 * @author kamar baraka.*/

//@SpringComponent
@Route("register")
public class RegistrationView extends VerticalLayout {

    public RegistrationView() {

        /*set the banner and form layout*/
        this.add(banner(), getFormLayout());
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
        layoutStyle.setBackground("light-grey");
        layoutStyle.set("border-radius", "10px");

        return layout;
    }

    private static VerticalLayout getFormLayout() {
        /*register button*/
        Button registerButton = new Button("register");
        registerButton.setEnabled(false);
        registerButton.addClickListener(click -> UI.getCurrent().navigate("activate"));

        /*login button*/
        Button loginButton = new Button("login");

        HorizontalLayout buttonLayout = new HorizontalLayout(registerButton, loginButton);
        buttonLayout.setAlignItems(Alignment.BASELINE);

        /*compose the form*/
        TextField usernameField = new TextField("username", "someone@somewhere.com");
        usernameField.setRequired(true);
        usernameField.focus();
        usernameField.setTooltipText("enter your username");

        PasswordField passwordField = new PasswordField("password", "enter your password here");
        passwordField.setRequired(true);
        passwordField.addValueChangeListener(listener -> registerButton.setEnabled(true));

        VerticalLayout formLayout = new VerticalLayout(usernameField, passwordField, buttonLayout);
        formLayout.setAlignItems(Alignment.CENTER);
        return formLayout;

    }
}
