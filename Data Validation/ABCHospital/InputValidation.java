package ABCHospital;

import java.time.LocalDate;

public class InputValidation {
    public boolean nameValid = false;
    public boolean idValid = false;
    public boolean dateValid = false;
    public Boolean birthDateValidation(LocalDate dateOfBirth){
        //Logic Check
        if (dateOfBirth.getYear()>((LocalDate.now().getYear())-18)){ //Must be 18 years or above
            return false;
        } else if (dateOfBirth.getYear() < (LocalDate.now().getYear()) - 65){ //Must be younger than 65
            return false;
        } else {
            dateValid = true;
            return true;
        }
    }
    public Boolean validationOfFullName(String fullName){ //Presence Check
        if (fullName.isEmpty() || fullName.isBlank()){ //If inputName is empty
            return false;
        } else { //If inputName has contents
            nameValid = true;
            return true;
        }
    }
    public Boolean validationOfIdentificationNumber(String IDNumber){ //Length Check & Check Digit
        if (IDNumber.length()==8 && IDNumber.endsWith("E1")){ //If ID number is 8 digits and has E1 suffix (valid)
            idValid = true;
            return true;
        } else { //If ID number is longer/shorter than 8 digits (invalid)
            return false;
        }
    }
    public boolean isValid(){
        return nameValid && idValid && dateValid;
    }
}
