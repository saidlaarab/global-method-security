package spring.security.globalmethodsecurity.model;

public class Document {
    private String code;
    private String owner;

    public Document(String code, String owner) {
        this.code = code;
        this.owner = owner;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
