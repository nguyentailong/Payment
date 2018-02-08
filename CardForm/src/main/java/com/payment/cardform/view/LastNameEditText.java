package com.payment.cardform.view;

import android.content.Context;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.InputType;
import android.util.AttributeSet;

import com.payment.cardform.R;

/**
 * Input for last name.
 */
public class LastNameEditText extends ErrorEditText {

    public LastNameEditText(Context context) {
        super(context);
        init();
    }

    public LastNameEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LastNameEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        if (isInEditMode()) {
            return;
        }

        setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        InputFilter[] filters = {new LengthFilter(16)};
        setFilters(filters);
        addTextChangedListener(new PhoneNumberFormattingTextWatcher());
    }

    /**
     * @return the last name
     */
    public String getLastName() {
        return getText().toString().trim();
    }

    @Override
    public boolean isValid() {
        return isOptional() || getText().toString().length() >= 0;
    }

    @Override
    public String getErrorMessage() {
        return getContext().getString(R.string.bt_last_name_required);
    }
}
