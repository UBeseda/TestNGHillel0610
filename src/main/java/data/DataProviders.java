package data;

import org.testng.annotations.DataProvider;

public class DataProviders {
        @DataProvider
        public Object[][] dateLang() {
            return new Object[][]{
                    {"en"},
                    {"fr"},
            };
        }
    }


