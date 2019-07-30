package com.susolabs.redu.controlador;

import com.susolabs.redu.modelo.facade.BiopsiaFacade;
import com.susolabs.redu.modelo.entidades.Biopsia;
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

@Named("biopsiaController")
@SessionScoped
public class BiopsiaController implements Serializable {

    @EJB
    private com.susolabs.redu.modelo.facade.BiopsiaFacade ejbFacade;
    private List<Biopsia> items = null;
    private Biopsia selected;
    private List<Biopsia> seleccion;

    public BiopsiaController() {
    }

    public List<Biopsia> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Biopsia> seleccion) {
        this.seleccion = seleccion;
    }
    
    

    public Biopsia getSelected() {
        return selected;
    }

    public void setSelected(Biopsia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }
    
    private BiopsiaFacade getFacade() {
        return ejbFacade;
    }

    public Biopsia prepareCreate() {
        selected = new Biopsia();
     
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("BiopsiaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("BiopsiaUpdated"));
        seleccion = ejbFacade.findAll();
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("BiopsiaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public List<Biopsia> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
        
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

public Biopsia getBiopsia(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Biopsia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Biopsia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }
    @FacesConverter(forClass = Biopsia.class)
    public static class BiopsiaControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BiopsiaController controller = (BiopsiaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "medicamentoController");
            return controller.getBiopsia(getKey(value));
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
            if (object instanceof Biopsia) {
                Biopsia o = (Biopsia) object;
                return getStringKey(o.getIdbiopsia());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Biopsia.class.getName()});
                return null;
            }
        }

    }
   

}
