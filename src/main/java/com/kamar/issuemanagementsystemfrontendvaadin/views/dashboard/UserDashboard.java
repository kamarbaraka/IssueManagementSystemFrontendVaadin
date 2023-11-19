package com.kamar.issuemanagementsystemfrontendvaadin.views.dashboard;

import com.kamar.issuemanagementsystemfrontendvaadin.views.ticket.CreateIssueComp;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.sidenav.SideNav;
import com.vaadin.flow.component.sidenav.SideNavItem;
import com.vaadin.flow.router.Route;

/**
 * the user dashboard.
 * @author kamar baraka.*/

@Route("dashboard")
public class UserDashboard extends VerticalLayout {

    public UserDashboard() {

        /*add side nav*/
        add(sideNav());
    }

    public static VerticalLayout sideNav(){

        /*create side nav*/
        SideNav sideNav = new SideNav("options");
        sideNav.setCollapsible(true);

        /*raise an issue component*/
        SideNavItem raiseIssue = new SideNavItem("raise issue", CreateIssueComp.class);
//        raiseIssue.setPath("createIssue");

        sideNav.addItem(raiseIssue);

        return new VerticalLayout(sideNav);
    }
}
