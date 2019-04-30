package br.ufma.lsdi.neurodailyweb.util;

import javax.faces.context.FacesContext;
import javax.faces.context.Flash;


public class WebUtil {

    private WebUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }

    public static Flash flashScope() {
        return (FacesContext.getCurrentInstance().getExternalContext().getFlash());
    }
}
