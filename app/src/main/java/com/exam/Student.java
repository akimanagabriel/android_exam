package com.exam;

public class Student {
    private String names;
    private String regNumber;
    private float fa1marks;
    private float fa2marks;
    private int id;

    private String decision;

    public String getNames() {
        return names.trim();
    }

    public void setNames(String names) {
        this.names = names.trim();
    }

    public String getRegNumber() {
        return regNumber.trim().toUpperCase();
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber.trim().toUpperCase();
    }

    public float getFa1marks() {
        return fa1marks;
    }

    public void setFa1marks(float fa1marks) {
        this.fa1marks = fa1marks>100?100:fa1marks;
    }

    public float getFa2marks() {
        return fa2marks;
    }

    public void setFa2marks(float fa2marks) {
        this.fa2marks = fa2marks>100?100:fa2marks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getDecision() {
        this.setDecision();
        return decision;
    }

    private void setDecision() {
        if (getFa2marks()>=70 && getFa1marks() >= 70 ) {
            this.decision = "EXAM OK";
        } else {
            this.decision = "NO EXAM";
        }
    }


    @Override
    public String toString() {
        return "\n"+getNames().toUpperCase()+"\n\n" +
                "REG NUMBER: "+getRegNumber()+"\n" +
                "F.A ONE: "+getFa1marks()+"%\n" +
                "F.A TWO: "+getFa2marks()+"%\n" +
                "DECISION: " +getDecision()+"\n";
    }
}
