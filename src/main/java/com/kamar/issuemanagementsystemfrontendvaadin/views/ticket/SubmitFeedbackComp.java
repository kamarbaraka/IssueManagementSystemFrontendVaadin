package com.kamar.issuemanagementsystemfrontendvaadin.views.ticket;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

/**
 * component to submit feedback.
 * @author kamar baraka.*/

@Route("feedback")
public class SubmitFeedbackComp extends VerticalLayout {

    public SubmitFeedbackComp() {
    }

    private TextArea feedback(){

        TextArea theFeedback = new TextArea("feedback", "enter your feedback here");

        return theFeedback;
    }
}
