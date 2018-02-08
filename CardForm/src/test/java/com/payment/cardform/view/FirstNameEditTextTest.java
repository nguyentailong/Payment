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
public class FirstNameEditTextTest {

    private FirstNameEditText mView;

    @Before
    public void setup() {
        mView = Robolectric.setupActivity(TestActivity.class)
                .findViewById(R.id.bt_card_form_first_name);
    }

    @Test
    public void getCountryCode_returnsStrippedCountryCode() {
        mView.setText("+86");

        assertEquals("86", mView.getFirstName());
    }

    @Test
    public void invalidIfEmpty() {
        assertFalse(mView.isValid());
    }

    @Test
    public void validIfNotEmpty() {
        mView.setText("+86");

        assertTrue(mView.isValid());
    }

    @Test
    public void validIfEmptyAndOptional() {
        mView.setOptional(true);

        assertTrue(mView.isValid());
    }

    @Test
    public void getErrorMessage_returnsErrorMessageWhenEmpty() {
        assertEquals(RuntimeEnvironment.application.getString(R.string.bt_first_name_required),
                mView.getErrorMessage());
    }
}
