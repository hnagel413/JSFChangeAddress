package validators;

import java.util.StringTokenizer;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value = "dateValidator")
public class DateValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        HtmlInputText htmlInputText = (HtmlInputText) component;
        String label = htmlInputText.getLabel() == null || htmlInputText.getLabel().trim().equals("") ? 
                htmlInputText.getId() : htmlInputText.getLabel();               
        if (!isDate((String)value)) {
            FacesMessage facesMessage = new FacesMessage(label + ": Illegal value for date");
            throw new ValidatorException(facesMessage);
        }
    }

    private boolean isDate(String text) {
        try {
            StringTokenizer stk = new StringTokenizer(text, "-");
            if(stk.countTokens() != 3) return false;
            int day = toNumber(stk.nextToken(), 1, 31);
            int month = toNumber(stk.nextToken(), 1, 12);
            int year = toNumber(stk.nextToken(), 1900, 2100);
            if((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) return false;
            else if(month == 2 && day > (leapyear(year) ? 29 : 28)) return false;
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    private int toNumber(String text, int a, int b) throws Exception{
        int t = Integer.parseInt(text);
        if(a <= t && t <= b) return t;
        throw new Exception("Illegal value!");
    }
    
    private boolean leapyear(int year){
        if(year % 100 == 0) return year % 400 == 0;
        return year % 4 == 0;
    }
    
}
