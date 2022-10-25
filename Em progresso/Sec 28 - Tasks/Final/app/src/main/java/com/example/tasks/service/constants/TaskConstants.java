package com.example.tasks.service.constants;

/**
 * Constantes usadas na aplicação
 */
public class TaskConstants {

    private TaskConstants() {
    }

    public static class SHARED {
        public static final String TOKEN_KEY = "token";
        public static final String PERSON_KEY = "personkey";
        public static final String PERSON_NAME = "personname";
        public static final String PERSON_EMAIL = "personemail";
    }

    public static class HTTP {
        public static final int SUCCESS = 200;
    }

    public static class TASKFILTER {
        public static final String KEY = "TASKFILTER";
        public static final int NO_FILTER = 0;
        public static final int NEXT_7_DAYS = 1;
        public static final int OVERDUE = 2;
    }

    public static class BUNDLE {
        public static final String TASKID = "taskid";
    }

}