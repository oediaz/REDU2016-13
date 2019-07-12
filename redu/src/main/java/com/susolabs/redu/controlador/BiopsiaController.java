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
        selected.getBiopsiaPK().setIdtrtamientocm(selected.getTratamientocancermama().getIdtrtamientocm());
    }

    protected void initializeEmbeddableKey() {
        selected.setBiopsiaPK(new com.susolabs.redu.modelo.entidades.BiopsiaPK());
    }

    private BiopsiaFacade getFacade() {
        return ejbFacade;
    }

    public Biopsia prepareCreate() {
        selected = new Biopsia();
        initializeEmbeddableKey();
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

    public Biopsia getBiopsia(com.susolabs.redu.modelo.entidades.BiopsiaPK id) {
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

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            BiopsiaController controller = (BiopsiaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "biopsiaController");
            return controller.getBiopsia(getKey(value));
        }

        com.susolabs.redu.modelo.entidades.BiopsiaPK getKey(String value) {
            com.susolabs.redu.modelo.entidades.BiopsiaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.susolabs.redu.modelo.entidades.BiopsiaPK();
            key.setIdtrtamientocm(Integer.parseInt(values[0]));
            key.setIdbiopsia(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.susolabs.redu.modelo.entidades.BiopsiaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdtrtamientocm());
            sb.append(SEPARATOR);
            sb.append(value.getIdbiopsia());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Biopsia) {
                Biopsia o = (Biopsia) object;
                return getStringKey(o.getBiopsiaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Biopsia.class.getName()});
                return null;
            }
        }

    }

}
