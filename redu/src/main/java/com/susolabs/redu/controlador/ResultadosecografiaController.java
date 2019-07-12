package com.susolabs.redu.controlador;

import com.susolabs.redu.modelo.facade.ResultadosecografiaFacade;
import com.susolabs.redu.modelo.entidades.Resultadosecografia;
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

@Named("resultadosecografiaController")
@SessionScoped
public class ResultadosecografiaController implements Serializable {

    @EJB
    private com.susolabs.redu.modelo.facade.ResultadosecografiaFacade ejbFacade;
    private List<Resultadosecografia> items = null;
    private Resultadosecografia selected;
    private List<Resultadosecografia> seleccion;

    public ResultadosecografiaController() {
    }

    public List<Resultadosecografia> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Resultadosecografia> seleccion) {
        this.seleccion = seleccion;
    }
    
    

    public Resultadosecografia getSelected() {
        return selected;
    }

    public void setSelected(Resultadosecografia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private ResultadosecografiaFacade getFacade() {
        return ejbFacade;
    }

    public Resultadosecografia prepareCreate() {
        selected = new Resultadosecografia();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("ResultadosecografiaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("ResultadosecografiaUpdated"));
        seleccion = ejbFacade.findAll();
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("ResultadosecografiaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public List<Resultadosecografia> getItems() {
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

    public Resultadosecografia getResultadosecografia(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Resultadosecografia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Resultadosecografia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Resultadosecografia.class)
    public static class ResultadosecografiaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            ResultadosecografiaController controller = (ResultadosecografiaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "resultadosecografiaController");
            return controller.getResultadosecografia(getKey(value));
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
            if (object instanceof Resultadosecografia) {
                Resultadosecografia o = (Resultadosecografia) object;
                return getStringKey(o.getIdresultadoe());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Resultadosecografia.class.getName()});
                return null;
            }
        }

    }

}
