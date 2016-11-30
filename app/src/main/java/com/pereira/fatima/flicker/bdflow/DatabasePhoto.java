package com.pereira.fatima.flicker.bdflow;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Human Booster on 30/11/2016.
 */

@Database(name = DatabasePhoto.NAME, version = DatabasePhoto.VERSION,
        foreignKeysSupported = true)

public class DatabasePhoto {

        public static final String NAME = "Photo";
        public static final int VERSION = 1;


}
