package servletAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import actionForm.AlterContactValidationForm;
import actionForm.CheckLoginValidationForm;
import domain.DAOContact;

public class CheckLoginAction extends Action {
	
	public ActionForward execute(final ActionMapping pMapping,
			ActionForm pForm, final HttpServletRequest pRequest,
			final HttpServletResponse pResponse) {
		
		
		final CheckLoginValidationForm lForm=(CheckLoginValidationForm)pForm;

		
		
		final String username = lForm.getFirstName();
		final String password = lForm.getLastName();
		
		if (!username.equals(password))
		{
			pRequest.setAttribute("username", username);
			return pMapping.findForward("error");
		}
		

        return pMapping.findForward("success");
        
        
		
		
	}
}
