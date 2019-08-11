package io.p13i.ra.gui;

import io.p13i.ra.RemembranceAgentClient;

import java.io.File;

import static java.util.prefs.Preferences.userNodeForPackage;

public class User {

    public static String NAME = System.getenv("RA_USER_NAME");

    public static class Home {
        public static String DIR = System.getProperty("user.home");

        public static class Documents {
            public static String DIR = Home.DIR + File.separator + "Documents";

            public static class RA {
                public static String DIR = Home.Documents.DIR + File.separator + "RA";

                public static class Cache {
                    public static String DIR = Home.Documents.RA.DIR + File.separator + "~cache";
                }
            }
        }
    }

    public static class Preferences {

        private static String NOT_SET = "";

        public enum Pref {
            KeystrokesLogFile("KEYSTROKES_LOG_FILE_PATH_PREFS_NODE_NAME", Home.DIR + File.separator + "keystrokes.log"),
            RAClientLogFile("RA_CLIENT_LOG_FILE_PATH_PREFS_NODE_NAME", Home.DIR + File.separator + "ra.log"),
            LocalDiskDocumentsFolderPath("LOCAL_DISK_DOCUMENTS_FOLDER_PATH_PREFS_NODE_NAME", Home.DIR),
            GoogleDriveFolderID("GOOGLE_DRIVE_FOLDER_ID_PREFS_NODE_NAME", NOT_SET),
            GmailMaxEmailsCount("GMAIL_MAX_EMAILS_COUNT_NODE_NAME", "10");

            private String nodeName;
            private String defaultValue;

            Pref(String nodeName, String defaultValue) {
                this.nodeName = nodeName;
                this.defaultValue = defaultValue;
            }
        }

        public static String getString(Pref getPref) {

            for (Pref pref : Pref.values()) {
                if (getPref.nodeName.equals(pref.nodeName)) {
                    return userNodeForPackage(RemembranceAgentClient.class).get(getPref.nodeName, getPref.defaultValue);
                }
            }

            throw new IllegalArgumentException(getPref.toString());
        }

        public static int getInt(Pref getPref) {
            return Integer.parseInt(getString(getPref));
        }

        public static void set(Pref pref, String value) {
            userNodeForPackage(RemembranceAgentClient.class).put(pref.nodeName, value);
        }
    }
}
