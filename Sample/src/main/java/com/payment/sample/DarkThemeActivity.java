package com.payment.sample;

import android.view.Menu;

public class DarkThemeActivity extends BaseCardFormActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        if (mCardForm.isCardScanningAvailable()) {
            getMenuInflater().inflate(R.menu.card_io_dark, menu);
        }

        return true;
    }
}
