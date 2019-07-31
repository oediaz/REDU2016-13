package com.susolabs.redu.controlador;

import com.susolabs.redu.modelo.facade.QuimioterapiaFacade;
import com.susolabs.redu.modelo.entidades.Quimioterapia;
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

@Named("quimioterapiaController")
@SessionScoped
public class QuimioterapiaController implements Serializable {

    @EJB
    private com.susolabs.redu.modelo.facade.QuimioterapiaFacade ejbFacade;
    private List<Quimioterapia> items = null;
    private Quimioterapia selected;
    private List<Quimioterapia> seleccion;

    public QuimioterapiaController() {
    }

    public List<Quimioterapia> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Quimioterapia> seleccion) {
        this.seleccion = seleccion;
    }

    
    
    public Quimioterapia getSelected() {
        return selected;
    }

    public void setSelected(Quimioterapia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private QuimioterapiaFacade getFacade() {
        return ejbFacade;
    }

    public Quimioterapia prepareCreate() {
        selected = new Quimioterapia();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("QuimioterapiaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("QuimioterapiaUpdated"));
        seleccion = ejbFacade.findAll();
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("QuimioterapiaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public List<Quimioterapia> getItems() {
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

    public Quimioterapia getQuimioterapia(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Quimioterapia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Quimioterapia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Quimioterapia.class)
    public static class QuimioterapiaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            QuimioterapiaController controller = (QuimioterapiaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "quimioterapiaController");
            return controller.getQuimioterapia(getKey(value));
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
            if (object instanceof Quimioterapia) {
                Quimioterapia o = (Quimioterapia) object;
                return getStringKey(o.getIdquimioterapia());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Quimioterapia.class.getName()});
                return null;
            }
        }

    }

}
