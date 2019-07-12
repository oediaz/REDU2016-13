package com.susolabs.redu.controlador;

import com.susolabs.redu.modelo.facade.ResultadosmamografiaepFacade;
import com.susolabs.redu.modelo.entidades.Resultadosmamografiaep;
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

@Named("resultadosmamografiaepController")
@SessionScoped
public class ResultadosmamografiaepController implements Serializable {

    @EJB
    private com.susolabs.redu.modelo.facade.ResultadosmamografiaepFacade ejbFacade;
    private List<Resultadosmamografiaep> items = null;
    private Resultadosmamografiaep selected;
    private List<Resultadosmamografiaep> seleccion;

    public ResultadosmamografiaepController() {
    }

    public List<Resultadosmamografiaep> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Resultadosmamografiaep> seleccion) {
        this.seleccion = seleccion;
    }
    
    

    public Resultadosmamografiaep getSelected() {
        return selected;
    }

    public void setSelected(Resultadosmamografiaep selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ResultadosmamografiaepFacade getFacade() {
        return ejbFacade;
    }

    public Resultadosmamografiaep prepareCreate() {
        selected = new Resultadosmamografiaep();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ResultadosmamografiaepCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ResultadosmamografiaepUpdated"));
        seleccion = ejbFacade.findAll();
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ResultadosmamografiaepDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public List<Resultadosmamografiaep> getItems() {
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

    public Resultadosmamografiaep getResultadosmamografiaep(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Resultadosmamografiaep> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Resultadosmamografiaep> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Resultadosmamografiaep.class)
    public static class ResultadosmamografiaepControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ResultadosmamografiaepController controller = (ResultadosmamografiaepController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "resultadosmamografiaepController");
            return controller.getResultadosmamografiaep(getKey(value));
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
            if (object instanceof Resultadosmamografiaep) {
                Resultadosmamografiaep o = (Resultadosmamografiaep) object;
                return getStringKey(o.getIdresultadosmep());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Resultadosmamografiaep.class.getName()});
                return null;
            }
        }

    }

}
