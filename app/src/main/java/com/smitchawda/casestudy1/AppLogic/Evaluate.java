package com.smitchawda.casestudy1.AppLogic;

public class Evaluate {
    private double leftOperand;
    private double rightOperand;
    private String operator;
    private String allOperators = "/*+-";

    public Evaluate(double leftOperand, double rightOperand, String operator) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
        this.operator = operator;
    }

    public String calculate(String equation, int numberOfOperators)
    {
        int i=0;
        String result = equation;
        while(true)
        {
            if (i>=allOperators.length())
            {
                break;
            }

            if (result.contains(allOperators.charAt(i)+""))
            {
                try{
                    leftOperand = Double.parseDouble(result.substring(0,i));
                }
                catch (Exception e)
                {
                    System.out.println("Error parsing left operand in Evaluate class");
                    e.printStackTrace();
                }
            }
            else{
                i++;
            }
            result = result.substring(i+1);
        }
        return "";
    }

    public double getLeftOperand() {
        return leftOperand;
    }

    public void setLeftOperand(double leftOperand) {
        this.leftOperand = leftOperand;
    }

    public double getRightOperand() {
        return rightOperand;
    }

    public void setRightOperand(double rightOperand) {
        this.rightOperand = rightOperand;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
