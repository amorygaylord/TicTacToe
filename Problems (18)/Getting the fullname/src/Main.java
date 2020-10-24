class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        if (firstName == null) {
            this.firstName = "";
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if (lastName == null) {
            this.lastName = "";
        } else {
            this.lastName = lastName;
        }
    }

    public String getFullName() {
        Boolean firstNull = false;
        Boolean lastNull = false;

        if (firstName == "") {
            firstNull = true;
        }

        if (lastName == "") {
            lastNull = true;
        }

        if (firstNull && !lastNull) {
            return lastName;
        } else if (!firstNull && lastNull) {
             return firstName;
        } else if (!firstNull && !lastNull) {
            return (firstName + " " + lastName);
        }

        return "Unknown";
    }
}