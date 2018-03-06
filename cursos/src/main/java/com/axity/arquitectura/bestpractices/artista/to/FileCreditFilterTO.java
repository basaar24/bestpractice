package com.axity.arquitectura.bestpractices.artista.to;

public class FileCreditFilterTO {

    private String reference;
    private String document;
    private String status;
    private Integer idCredit;

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIdCredit() {
        return idCredit;
    }

    public void setIdCredit(Integer idCredit) {
        this.idCredit = idCredit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    private String type;


}
