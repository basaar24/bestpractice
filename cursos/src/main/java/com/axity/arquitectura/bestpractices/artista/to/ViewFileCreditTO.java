package com.axity.arquitectura.bestpractices.artista.to;

public class ViewFileCreditTO {


    private Integer idFile;
    private String reference;
    private String nameDoc;
    private CatalogoTO status;
    private CatalogoTO type;
    private CatalogoTO doc;
    private String mediaType;
    private String nameExtension;
    private Integer idFileContent;

    public Integer getIdFile() {
        return idFile;
    }

    public void setIdFile(Integer idFile) {
        this.idFile = idFile;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getNameDoc() {
        return nameDoc;
    }

    public void setNameDoc(String nameDoc) {
        this.nameDoc = nameDoc;
    }

    public CatalogoTO getStatus() {
        return status;
    }

    public void setStatus(CatalogoTO status) {
        this.status = status;
    }

    public CatalogoTO getType() {
        return type;
    }

    public void setType(CatalogoTO type) {
        this.type = type;
    }

    public CatalogoTO getDoc() {
        return doc;
    }

    public void setDoc(CatalogoTO doc) {
        this.doc = doc;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getNameExtension() {
        return nameExtension;
    }

    public void setNameExtension(String nameExtension) {
        this.nameExtension = nameExtension;
    }

    public Integer getIdFileContent() {
        return idFileContent;
    }

    public void setIdFileContent(Integer idFileContent) {
        this.idFileContent = idFileContent;
    }
}
