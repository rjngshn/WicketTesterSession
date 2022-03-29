package uk.ac.ox.ndph.ckb;

import org.apache.wicket.Session;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.Model;

public class UserPage extends WebPage {
    String userName;
    public UserPage() {
        super();
    }
    
    @Override
    protected void onInitialize() 
    {
        super.onInitialize();
        Session session = getSession();
        userName = session.getAttribute("userName").toString();
        System.out.println("UserPage: user is " + userName);
        add(new TextField<>("txtUserName", Model.of(userName)));
    } 
}
