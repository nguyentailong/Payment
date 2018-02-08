package com.payment.cardform.view;

import com.payment.cardform.R;
import com.payment.cardform.test.TestActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class LastNameEditTextTest {

    private LastNameEditText mView;

    @Before
    public void setup() {
        mView = Robolectric.setupActivity(TestActivity.class)
                .findViewById(R.id.bt_card_form_last_name);
    }

    @Test
    public void getMobileNumber_returnsStrippedMobileNumber() {
        mView.setText("(555) 555-5555");

        assertEquals("5555555555", mView.getLastName());
    }

    @Test
    public void invalidIfEmpty() {
        assertFalse(mView.isValid());
    }

    @Test
    public void invalidIfFewerThan8Characters() {
        mView.setText("123");
        assertFalse(mView.isValid());
    }

    @Test
    public void validIfMoreThan8Characters() {
        mView.setText("12341234");
        assertTrue(mView.isValid());
    }

    @Test
    public void validIfEmptyAndOptional() {
        mView.setOptional(true);

        assertTrue(mView.isValid());
    }

    @Test
    public void getErrorMessage_returnsErrorMessageWhenEmpty() {
        assertEquals(RuntimeEnvironment.application.getString(R.string.bt_last_name_required), mView.getErrorMessage());
    }
}
