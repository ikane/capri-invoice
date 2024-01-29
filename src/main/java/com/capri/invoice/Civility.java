package com.capri.invoice;

public enum Civility {
    MADAME("MME"),
    MADEMOISELLE("MLLE"),
    MONSIEUR("MR") ;

    private String abreviation ;

    private Civility(String abreviation) {
        this.abreviation = abreviation ;
    }

    public String getAbreviation() {
        return  this.abreviation ;
    }
}
