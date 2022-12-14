package virtual;

import address.Address;

public class WebPageAddress extends Address {
    private String URL;
    private String domain;
    private String resource;

    public WebPageAddress(String validFrom, String validTo, String domain, String resource) {
        super(validFrom, validTo);
        this.domain = domain;
        this.resource = resource;
        this.URL = "www." + this.domain + this.resource;
    }

    public WebPageAddress(String validFrom, String validTo, String domain) {
        this(validFrom, validTo, domain, "");
    }

    public WebPageAddress() {
        this("2022-12-14", "2022-12-25", "Google", "/search");
    }

    public WebPageAddress(WebPageAddress other) {
        this(other.validFrom, other.validTo, other.domain, other.resource);
    }

    @Override
    public String toString() {
        return "The URL " + URL + " is valid from " + validFrom + " to " + validTo;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (other == this) {
            return true;
        }

        if (!(other instanceof WebPageAddress)) {
            return false;
        }

        // need to cast the object into a webPagesAddress
        WebPageAddress temp = (WebPageAddress) other;
        if (URL == temp.URL && domain == temp.domain && resource == temp.resource) {
            return true;
        } else {
            return false;
        }
    }

    // GETTERS
    public String getURL() {
        return URL;
    }

    public String getDomain() {
        return domain;
    }

    public String getResource() {
        return resource;
    }

    // SETTERS

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
