package com.susolabs.redu.controlador;

import com.susolabs.redu.modelo.facade.ResultadoexamenFacade;
import com.susolabs.redu.modelo.entidades.Resultadosexamen;
import com.susolabs.redu.controlador.util.JsfUtil;
import com.susolabs.redu.controlador.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("resultadoexamenController")
@SessionScoped
public class ResultadoexamenController implements Serializable {

    @EJB
    private com.susolabs.redu.modelo.facade.ResultadoexamenFacade ejbFacade;
    private List<Resultadosexamen> items = null;
    private Resultadosexamen selected;
    private List<Resultadosexamen> seleccion;

    public ResultadoexamenController() {
    }

    public List<Resultadosexamen> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Resultadosexamen> seleccion) {
        this.seleccion = seleccion;
    }

    
    public Resultadosexamen getSelected() {
        return selected;
    }

    public void setSelected(Resultadosexamen selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ResultadoexamenFacade getFacade() {
        return ejbFacade;
    }

    public Resultadosexamen prepareCreate() {
        selected = new Resultadosexamen();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ResultadoexamenCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ResultadoexamenUpdated"));
        seleccion = ejbFacade.findAll();
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ResultadoexamenDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public List<Resultadosexamen> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Resultadosexamen getResultadoexamen(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Resultadosexamen> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Resultadosexamen> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Resultadosexamen.class)
    public static class ResultadoexamenControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ResultadoexamenController controller = (ResultadoexamenController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "resultadoexamenController");
            return controller.getResultadoexamen(getKey(value));
        }

        java.lang.Integer getKey(String value) {
             java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Resultadosexamen) {
                Resultadosexamen o = (Resultadosexamen) object;
                return getStringKey(o.getIdresultadosexamen());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Resultadosexamen.class.getName()});
                return null;
            }
        }

    }

}
