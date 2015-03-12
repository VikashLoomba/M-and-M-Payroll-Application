/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MandM;

import javax.swing.JOptionPane;

/**
 *************************************************************
 *Comments by prof.
 *
 *************************************************************
 * File name:   Payroll.java
 * @author:     Vikash Loomba
 * @version:    1.1
 * Platform:    PC, Windows XP, Netbeans 8.02, jdk 8
 *************************************************************
 * <b>
 * This class calculates the pay amount for an employee at
 * M and M. All inputs are taken from MMGui.java.
 * </b>
 *************************************************************
 * Input:   Employee's departments, dependents, and hours.
 * Output:  Pay amount for individual employee.
 *************************************************************
 * Comments by student
 * See MMGui.java
 *************************************************************
 */
public class Payroll {
    
    //Instance Variables
    static final double SALES = 15.00,
                        PRODUCTION = 25.00,
                        DESIGN = 40.00,
                        SHIPPING = 10.00,
                        MARKETING = 30.00,
                        OTHER = 12.00,
                        STATETAX = 0.032;
    int dependents;
    double hours;
    int departmentCode,
            departmentHourly = 0;
    /**
     * Default constructor
     */
    public Payroll()
    {
        dependents = 0;
        hours = 0;
        departmentCode = '\u0000';       
    }
    /**
     * Overloaded constructor
     */
    public Payroll(int dep, double hrs, int dC)
    {
        dependents = dep;
        hours = hrs;
        departmentCode = dC;
    }
    /**
     * Selects appropriate department of employee.
     */
    public static double getDepartmentHourly(int departmentCode)
    {
        double departmentHourly;        
        switch (departmentCode)
        {
            case 1: departmentHourly = SALES;
                break;
            case 2: departmentHourly = PRODUCTION;
                break;
            case 3: departmentHourly = DESIGN;
                break;
            case 4: departmentHourly = SHIPPING;
                break;
            case 5: departmentHourly = MARKETING;
                break;
            default: departmentHourly = OTHER;
                
                
        }
        return departmentHourly;
    }
    /**
     * Calculates pay based of department, and determines whether
     * overtime was worked or not. 
     */
    public double getTotalPay(double departmentHourly)
    {
        double totalPay = 0000.00;
        double grossPay = 0.00;
        double extraTime = 0;
        double fedTax = 0.00;
        double stateTax = 0.00;
        //Check for overtime (hours > 40)
        if (hours > 80)
        {
            JOptionPane.showMessageDialog(null, "Please enter the correct number of hours worked");
        }
        if (hours > 40)
        {
            extraTime = hours - 40;
            grossPay = (40 * departmentHourly) + (extraTime * (departmentHourly * 1.5));
            
        }
        else
        {
            grossPay = hours * departmentHourly;
            
        }
               
        //Calculate federal tax (20% * (gross pay - dependents * 48.60)
        fedTax = 0.20 * (grossPay - dependents * 48.60);
        //Calculate state tax (3.2% * gross pay)
        stateTax = 0.032 * grossPay;
        //Subtract total witholdings
        totalPay = grossPay - stateTax - fedTax;
        return totalPay;
        
    }
    
}
