package com.example.databasebuilding;

    interface sqlAddingtoBase {
    

        String JDBC_URL = "jdbc:mysql://localhost:3306/fnba";
        String username = "root";
        String password = "******";
        String path =  System.getProperty("user.dir") + "\\SqlCommandHistory.txt";

        //add sql command to histry
        public void addToCommandHistory();

    }
