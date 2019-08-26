package com.susolabs.redu.controlador;

import com.susolabs.redu.modelo.facade.CatalogoFacade;
import com.susolabs.redu.modelo.entidades.Catalogo;
import com.susolabs.redu.controlador.util.JsfUtil;
import com.susolabs.redu.controlador.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.ArrayList;
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

@Named("catalogoController")
@SessionScoped
public class CatalogoController implements Serializable {

    @EJB
    private com.susolabs.redu.modelo.facade.CatalogoFacade ejbFacade;
    private List<Catalogo> items = null;
    private Catalogo selected;
    private List<Catalogo> seleccion;
    private Catalogo newCatalogo;

    public CatalogoController() {
    }

    public Catalogo getNewCatalogo() {
        return newCatalogo;
    }

    public void setNewCatalogo(Catalogo newCatalogo) {
        this.newCatalogo = newCatalogo;
    }

    public List<Catalogo> getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(List<Catalogo> seleccion) {
        this.seleccion = seleccion;
    }

    public Catalogo getSelected() {
        return selected;
    }

    public void setSelected(Catalogo selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private CatalogoFacade getFacade() {
        return ejbFacade;
    }

    public Catalogo prepareCreate() {
        selected = new Catalogo();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("CatalogoCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("CatalogoUpdated"));
        seleccion = ejbFacade.findAll();
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("CatalogoDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
        seleccion = ejbFacade.findAll();
    }

    public List<Catalogo> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public List<Catalogo> getItemsFind(String nombre) {
        items = new ArrayList();
        List<Catalogo> aux = getFacade().findAll();
        
        System.out.println("Nombre: " + nombre);
        System.out.println("Resultado:");
        for (int i = 0; i < aux.size(); i++) {
            if (aux.get(i).getNombre().equals(nombre)) {
                items.add(aux.get(i));
                System.out.println(aux.get(i).getDescripcion());
               } else {
                

            }
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

    public Catalogo getCatalogo(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Catalogo> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Catalogo> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Catalogo.class)
    public static class CatalogoControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            CatalogoController controller = (CatalogoController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "catalogoController");
            return controller.getCatalogo(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.String value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Catalogo) {
                Catalogo o = (Catalogo) object;
                return getStringKey(o.getDescripcion());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Catalogo.class.getName()});
                return null;
            }
        }

    }

}
