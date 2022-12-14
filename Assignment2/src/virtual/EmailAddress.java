package virtual;

import address.Address;

public class EmailAddress extends Address {
    private String email;
    private String username;
    private String domain;
    private String TLD;

    public EmailAddress(String username, String domain, String TLD, String validFrom, String validTo) {
        super(validFrom, validTo);
        this.username = username;
        this.domain = domain;
        this.TLD = TLD;
        this.email = username + "@" + domain + "." + TLD;
    }

    public EmailAddress() {
        this("allanyin17", "gmail", "com", "2017-09-07", "2090-01-07");
    }

    public EmailAddress(EmailAddress other) {
        this(other.username, other.domain, other.TLD, other.validFrom, other.validTo);
    }

    @Override
    public String toString() {
        return "The Email " + email + " is valid from " + validFrom + " to " + validTo;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }

        if (other == this) {
            return true;
        }

        if (!(other instanceof EmailAddress)) {
            return false;
        }

        // need to cast the object into a webPagesAddress
        EmailAddress temp = (EmailAddress) other;
        if (username == temp.username && domain == temp.domain && TLD == temp.TLD) {
            return true;
        } else {
            return false;
        }
    }

    // GETTERS
    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getDomain() {
        return domain;
    }

    public String getTLD() {
        return TLD;
    }

    // SETTERS
    public void setUsername(String username) {
        this.username = username;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public void setTLD(String TLD) {
        this.TLD = TLD;
    }
}
