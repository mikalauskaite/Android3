package com.example.android3;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule
            = new ActivityScenarioRule<>(MainActivity.class);
    @Test
    public void useAppContext() {
        // testuojamos programeles info
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.android3", appContext.getPackageName());
    }
    @Test
    public void CalculationWorks(){
        onView(withId(R.id.Six)).perform(click());
        onView(withId(R.id.Plus)).perform(click());
        onView(withId(R.id.Four)).perform(click());
        onView(withId(R.id.Equals)).perform(click());

        // patikrinam ar gaunam teisinga atsakyma
        onView(withId(R.id.resultTextView))
                .check(matches(withText("10.0")));
    }

}