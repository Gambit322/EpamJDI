package org.mytests.enums;

import com.epam.commons.linqinterfaces.JAction;
import com.epam.jdi.uitests.core.preconditions.IPreconditions;
import org.mytests.entitles.User;

import java.util.function.Supplier;

import static org.mytests.JdiSite.loginForm;

/**
 * Created by Олег on 24.11.2016.
 */
public enum Preconditions implements IPreconditions {
    LOGIN(
            ()->loginForm.userName.isDisplayed(),
            ()->loginForm.submit(new User("epam","1234"))

    ),
    LOGOUT(
            ()-> !loginForm.userName.isDisplayed(),
            ()-> { if (loginForm.logoutButton.isDisplayed())
                    loginForm.logoutButton.click();
                    else {
                    loginForm.userName.click();
                    loginForm.logoutButton.click();}
            }
    );

    public Supplier<Boolean> checkAction;
    public JAction moveToAction;

    Preconditions(Supplier<Boolean> checkAction, JAction moveToAction) {
        this.checkAction = checkAction;
        this.moveToAction = moveToAction;
    }

    @Override
    public Boolean checkAction() {
        return checkAction.get();
    }

    @Override
    public void moveToAction() {
        moveToAction.invoke();
    }
}