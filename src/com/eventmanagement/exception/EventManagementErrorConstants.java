package com.eventmanagement.exception;

public class EventManagementErrorConstants {
    public static class ErrorCode {
        /**
         * ErrorCode ranges:
         *   1) Common errorCodes range from 10000 to 19999
         *   2) Service Action errorCodes range from 20000 to 29999
         *   3) ApplicationPackage errorCodes range from 30000 to 39999
         *   4) Application errorCodes range from 40000 to 49999
         */

        //=== Common ===
        public static final String UNAUTHORIZED = "EVENTMGMT_10000";
        public static final String NULL_OR_EMPTY_ATTRIBUTE_VALUE = "EVENTMGMT_10001";
        public static final String ILLEGAL_ATTRIBUTE_VALUE = "EVENTMGMT_10002";
        public static final String INVALID_ATTRIBUTE_VALUE = "EVENTMGMT_10003";
        public static final String BAD_REQUEST = "EVENTMGMT_10004";
        public static final String OBJECT_NOT_FOUND = "EVENTMGMT_10005";
        public static final String DUPLICATE_OBJECT = "EVENTMGMT_10006";
        public static final String INTERNAL_SERVER_ERROR = "EVENTMGMT_10007";
        
        
        //=== Service Action ===
        
        
        //=== Application Package ===
        
        
        //=== Get App ===
        public static final String SERVICE_ENDPOINT_REST_ERROR = "EVENTMGMT_40000";
        public static final String GETAPP_MDB_ERROR = "EVENTMGMT_40001";
        public static final String GETAPP_DB_ERROR = "EVENTMGMT_40002";
        public static final String GETAPP_GENERIC_ERROR = "EVENTMGMT_40003";
        public static final String DUPLICATE_INSTALLATION = "EVENTMGMT_40004";
    }

    
    public static class ErrorPath {
        //=== ApplicationPackage ===
        public static final String APPLICATIONPACKAGE_ID = "id";
        public static final String APPLICATIONPACKAGE_NAME = "name";
        public static final String APPLICATIONPACKAGE_VERSION = "version";
        public static final String APPLICATIONPACKAGE_OWNER = "owner";
        public static final String APPLICATIONPACKAGE_PARTNERNAME = "partnerName";
        public static final String APPLICATIONPACKAGE_TYPE = "type";
        public static final String APPLICATIONPACKAGE_STATUS = "status";

        public static final String DEPENDENTPACKAGES = "dependentPackages";
        public static final String DEPENDENTSERVICES = "dependentServices";
        public static final String ACTIONS = "actions";
        public static final String OPERATIONS = "operations";
        
        
        //=== DependentPackages ===
        
        
        //=== DependentServices ===
    }
}