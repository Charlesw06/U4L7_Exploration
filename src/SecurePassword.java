public class SecurePassword
{
    private String password;

    public SecurePassword(String password)
    {
        this.password = password;
    }

    public void setPassword(String newPassword)
    {
        password = newPassword;
    }

    public boolean isSecure()
    {
        if (containsDigit() && containsUppercase() && containsLowercase() && isLongEnough() && containsSpecialSymbol()) {
            return true;
        }
        return false;
    }

    public String status()
    {
        String result = "";
        if (isSecure()) {
            result += "Password is secure";
        }
        else {
            if (!isLongEnough()) {
                result += "The password must contain at least 8 characters \n";
            }
            if (!containsSpecialSymbol()) {
                result += "The password must contain a special symbol: ! @ # $ % ^ & * ? \n";
            }
            if (!containsLowercase()) {
                result += "The password must contain a lowercase letter \n";
            }
            if (!containsUppercase()) {
                result += "The password must contain an uppercase letter \n";
            }
            if (!containsDigit()) {
                result += "The password must contain a digit \n";
            }
        }
        return result;
    }

    private boolean isLongEnough()
    {
        return password.length() >= 8;
    }

    private boolean containsUppercase()
    {
        String upperCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return checkString(upperCaseLetters);
    }

    private boolean containsLowercase()
    {
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        return checkString(lowerCaseLetters);
    }

    private boolean containsDigit()
    {
        String digits = "1234567890";
        return checkString(digits);
    }

    private boolean containsSpecialSymbol()
    {
        String specialSybmols = "!@#$%^&*?";
        return checkString(specialSybmols);
    }

    private boolean checkString(String characterString)
    {
        for (int i = 0; i < characterString.length(); i++) {
            for (int a = 0; a < password.length(); a++) {
                if (characterString.substring(i, i + 1).equals(password.substring(a, a + 1))) {
                    return true;
                }
            }
        }
        return false;
    }
}

