package com.payment.cardform.view;

import android.content.Context;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.InputType;
import android.util.AttributeSet;

import com.payment.cardform.R;

/**
 * Input for first name.
 */
public class FirstNameEditText extends ErrorEditText {

    public FirstNameEditText(Context context) {
        super(context);
        init();
    }

    public FirstNameEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FirstNameEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        InputFilter[] filters = {new LengthFilter(16)};
        setFilters(filters);
    }

    /**
     * @return the first name
     */
    public String getFirstName() {
        return getText().toString().trim();
    }

    @Override
    public boolean isValid() {
        return isOptional() || getText().toString().length() > 0;
    }

    @Override
    public String getErrorMessage() {
        return getContext().getString(R.string.bt_first_name_required);
    }
}
