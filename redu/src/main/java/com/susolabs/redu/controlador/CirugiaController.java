package com.susolabs.redu.controlador;

import com.susolabs.redu.modelo.facade.CirugiaFacade;
import com.susolabs.redu.modelo.entidades.Cirugia;
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

@Named("cirugiaController")
@SessionScoped
public class CirugiaController implements Serializable {

    @EJB
    private com.susolabs.redu.modelo.facade.CirugiaFacade ejbFacade;
    private List<Cirugia> items = null;
    private Cirugia selected;
    private List<Cirugia> seleccion;

    public CirugiaController() {
    }

    public List<Cirugia> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Cirugia> seleccion) {
        this.seleccion = seleccion;
    }

    
    public Cirugia getSelected() {
        return selected;
    }

    public void setSelected(Cirugia selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
        selected.getCirugiaPK().setIdtrtamientocm(selected.getTratamientocancermama().getIdtrtamientocm());
    }

    protected void initializeEmbeddableKey() {
        selected.setCirugiaPK(new com.susolabs.redu.modelo.entidades.CirugiaPK());
    }

    private CirugiaFacade getFacade() {
        return ejbFacade;
    }

    public Cirugia prepareCreate() {
        selected = new Cirugia();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CirugiaCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CirugiaUpdated"));
        seleccion = ejbFacade.findAll();
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CirugiaDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public List<Cirugia> getItems() {
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

    public Cirugia getCirugia(com.susolabs.redu.modelo.entidades.CirugiaPK id) {
        return getFacade().find(id);
    }

    public List<Cirugia> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Cirugia> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Cirugia.class)
    public static class CirugiaControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CirugiaController controller = (CirugiaController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "cirugiaController");
            return controller.getCirugia(getKey(value));
        }

        com.susolabs.redu.modelo.entidades.CirugiaPK getKey(String value) {
            com.susolabs.redu.modelo.entidades.CirugiaPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new com.susolabs.redu.modelo.entidades.CirugiaPK();
            key.setIdtrtamientocm(Integer.parseInt(values[0]));
            key.setIdcirugia(Integer.parseInt(values[1]));
            return key;
        }

        String getStringKey(com.susolabs.redu.modelo.entidades.CirugiaPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getIdtrtamientocm());
            sb.append(SEPARATOR);
            sb.append(value.getIdcirugia());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Cirugia) {
                Cirugia o = (Cirugia) object;
                return getStringKey(o.getCirugiaPK());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Cirugia.class.getName()});
                return null;
            }
        }

    }

}
