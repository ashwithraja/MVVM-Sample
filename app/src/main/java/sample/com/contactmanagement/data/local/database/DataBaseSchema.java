package sample.com.contactmanagement.data.local.database;

import android.provider.BaseColumns;

/**
 * Created by ashwith on 2/11/17.
 */

public final class DataBaseSchema {

    private DataBaseSchema() {

    }

    public static class ContactSchema implements BaseColumns {

        public static final String TABLE_NAME = "conatct_manager";

        public static final String KEY_ID = "key_id";

        public static final String KEY_NAME = "key_name";

        public static final String KEY_PHONE_NUMBER = "phone_number";
    }
}
