package org.mytests.enums;

import com.epam.commons.linqinterfaces.JAction;
import com.epam.jdi.uitests.core.preconditions.IPreconditions;
import com.epam.jdi.uitests.web.selenium.preconditions.WebPreconditions;
import org.mytests.other.User;

import java.util.function.Supplier;

import static com.epam.jdi.uitests.core.preconditions.PreconditionsState.alwaysMoveToCondition;
import static org.mytests.JdiSite.loginForm;

/**
 * Created by Олег on 24.11.2016.
 */
public enum Preconditions implements IPreconditions {
    LOGIN(
            ()->loginForm.userName.isDisplayed(),
            ()->loginForm.submit(new User("epam","1234"))

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