package foo.ui;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import foo.ui.model.FooModel;

@Route
public class MainView extends VerticalLayout {
    public MainView() {

        MenuBar menuBar = new MenuBar();
        menuBar.setOpenOnHover(true);

        MenuItem project = menuBar.addItem("Project");
        MenuItem account = menuBar.addItem("Account");

        SubMenu projectSubMenu = project.getSubMenu();
        MenuItem users = projectSubMenu.addItem("Users");
        MenuItem billing = projectSubMenu.addItem("Billing");

        SubMenu usersSubMenu = users.getSubMenu();
//        usersSubMenu.addItem("List", e -> selected.setText("List"));
//        usersSubMenu.addItem("Add", e -> selected.setText("Add"));

        add(menuBar);

//        add(new Text("Welcome to MainView."));
        TextField labelField = new TextField();
        labelField.setLabel("Label");
        add(labelField);

        FooModel model = new FooModel();
        Binder<FooModel> binder = new Binder(FooModel.class);
        binder.bind(labelField, FooModel::getName, FooModel::setName);
        binder.setBean(model);


        Button leftButton = new Button("Left", new Icon(VaadinIcon.ARROW_LEFT));
        leftButton.addClickListener(ev -> {
            model.setName("José Cruz");
            binder.readBean(model);
        });
        add(leftButton);


    }
}
