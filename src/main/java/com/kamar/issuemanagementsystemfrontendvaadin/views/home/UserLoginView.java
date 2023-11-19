package com.kamar.issuemanagementsystemfrontendvaadin.views.home;

import com.kamar.issuemanagementsystemfrontendvaadin.service.LoginService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.Autocomplete;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.Route;
import lombok.RequiredArgsConstructor;

/**
 * the user login view.
 * @author kamar baraka.*/

@Route("login")
public class UserLoginView extends VerticalLayout {

    private final LoginService loginService;
    private final TextField usernameField = new TextField("username", "someone@example.com");

    private final PasswordField passwordField = new PasswordField("password");
    private final Button loginButton = new Button("login");
    private final Button registerButton = new Button("register");

    public UserLoginView(
            final LoginService loginService
            ) {

        this.loginService = loginService;

        /*configure the layout*/
        this.add(loginForm(), loginButtons());
        this.setAlignItems(Alignment.CENTER);
    }

    private VerticalLayout loginForm(){


        usernameField.setTooltipText("enter your username");
        usernameField.setAutocomplete(Autocomplete.EMAIL);
        usernameField.setRequired(true);

        passwordField.setTooltipText("enter your password");
        passwordField.setRequired(true);
        passwordField.addValueChangeListener(change -> loginButton.setEnabled(true));

        VerticalLayout formLayout = new VerticalLayout(usernameField, passwordField);
        formLayout.setAlignItems(Alignment.CENTER);
        return formLayout;
    }

    private HorizontalLayout loginButtons(){

        /*login button*/
        loginButton.setEnabled(false);
        loginButton.addClickListener(click -> {

            String username = usernameField.getValue();
            String password = passwordField.getValue();
            loginService.login(username, password);
        });

        /*registration button*/
        registerButton.addClickListener(click -> UI.getCurrent().navigate("register"));

        /*add them to layout*/
        HorizontalLayout buttonLayout = new HorizontalLayout(loginButton, registerButton);
        buttonLayout.setAlignItems(Alignment.BASELINE);
        return buttonLayout;
    }
}
