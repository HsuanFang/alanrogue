package com.example.fanghsuan.espressofirst;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import tools.fastlane.screengrab.Screengrab;
import tools.fastlane.screengrab.locale.LocaleTestRule;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


/**
 * Created by fanghsuan on 16/2/20.
 */

@RunWith(AndroidJUnit4.class)
public class MainActivityEspressoTest {
    @ClassRule
    public static final LocaleTestRule localeTestRule = new LocaleTestRule();


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void ensureTextChangesWork() {
        // Type text and then press the button.
        Screengrab.screenshot("show_message_before_enter");
        onView(withId(R.id.inputField)).perform(typeText("HELLO"), closeSoftKeyboard());
        Screengrab.screenshot("show_message_after_enter_somethings");
        onView(withId(R.id.changeText)).perform(click());
        Screengrab.screenshot("show_message_after_click_perform_button");

        // Check that the text was changed.
        onView(withId(R.id.inputField)).check(matches(withText("Lalala")));
        Screengrab.screenshot("show_message_check_match");
    }

    @Test
    public void changeText_newActivity() {
        // Type text and then press the button.
        Screengrab.screenshot("show_message_before_enter_somethings");
        onView(withId(R.id.inputField)).perform(typeText("NewText"), closeSoftKeyboard());
        Screengrab.screenshot("show_message_after_enter_somethings_else");
        onView(withId(R.id.switchActivity)).perform(click());
        Screengrab.screenshot("show_message_after_click_perform_button_again");

        // This view is in a different Activity, no need to tell Espresso.
        onView(withId(R.id.resultView)).check(matches(withText("NewText")));
        Screengrab.screenshot("show_message_check_match_2");
    }

}
