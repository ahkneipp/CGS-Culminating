package com.canine505.util;

import java.time.LocalDateTime;
//TODO create printErr methods for each data type
//TODO maybe create printTesting method and add "TESTING:" tag to beginning of line
/**
 * Created by Alex Kneipp on 2/26/2015.
 */
public class ErrorMessage
{
    public static void printErr(String errMessage, boolean appendTimeStamp)
    {
        if(printErrorStatements == true)
        {
            if(appendTimeStamp == true)
            {
                System.out.print("ERROR: ");
                System.out.print(errMessage);
                System.out.println(LocalDateTime.now() + "\n");
            }
            else
            {
                System.out.print("ERROR: ");
                System.out.print(errMessage + "\n");
            }
        }
    }
    public static void printErr(int errMessage, boolean appendTimeStamp)
    {
        if(printErrorStatements == true)
        {
            if(appendTimeStamp == true)
            {
                System.out.print("ERROR: ");
                System.out.print(errMessage);
                System.out.println(LocalDateTime.now() + "\n");
            }
            else
            {
                System.out.print("ERROR: ");
                System.out.print(errMessage + "\n");
            }
        }
    }
    public static void printErr(double errMessage, boolean appendTimeStamp)
    {
        if(printErrorStatements == true)
        {
            if(appendTimeStamp == true)
            {
                System.out.print("ERROR: ");
                System.out.print(errMessage);
                System.out.print("  Time of Error: ");
                System.out.println(LocalDateTime.now() + "\n");
            }
            else
            {
                System.out.print("ERROR: ");
                System.out.print(errMessage + "\n");
            }
        }
    }
    public static void printErr(long errMessage, boolean appendTimeStamp)
    {
        if(printErrorStatements == true)
        {
            if(appendTimeStamp == true)
            {
                System.out.print("ERROR: ");
                System.out.print(errMessage);
                System.out.println(LocalDateTime.now() + "\n");
            }
            else
            {
                System.out.print("ERROR: ");
                System.out.print(errMessage + "\n");
            }
        }
    }

    public static void printTst(String message, boolean appendTimeStamp)
    {
        if(printTestingStatements == true)
        {
            if(appendTimeStamp == true)
            {
                System.out.print("TESTING: ");
                System.out.print(message);
                System.out.println(LocalDateTime.now() + "\n");
            }
            else
            {
                System.out.print("TESTING: ");
                System.out.print(message + "\n");
            }
        }
    }
    public static void setPrintErrorStatements(boolean a)
    {
        printErrorStatements = a;
    }
    public static void setPrintTestingStatements(boolean a)
    {
        printTestingStatements = a;
    }

    private static boolean printErrorStatements = true;
    private static boolean printTestingStatements = true;
}
