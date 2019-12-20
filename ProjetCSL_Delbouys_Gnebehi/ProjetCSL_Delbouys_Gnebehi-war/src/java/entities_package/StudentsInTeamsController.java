package entities_package;

import entities_package.util.JsfUtil;
import entities_package.util.PaginationHelper;

import java.io.Serializable;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;

@Named("studentsInTeamsController")
@SessionScoped
public class StudentsInTeamsController implements Serializable {

    private StudentsInTeams current;
    private DataModel items = null;
    @EJB
    private entities_package.StudentsInTeamsFacade ejbFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public StudentsInTeamsController() {
    }

    public StudentsInTeams getSelected() {
        if (current == null) {
            current = new StudentsInTeams();
            current.setStudentsInTeamsPK(new entities_package.StudentsInTeamsPK());
            selectedItemIndex = -1;
        }
        return current;
    }

    private StudentsInTeamsFacade getFacade() {
        return ejbFacade;
    }

    public PaginationHelper getPagination() {
        if (pagination == null) {
            pagination = new PaginationHelper(10) {

                @Override
                public int getItemsCount() {
                    return getFacade().count();
                }

                @Override
                public DataModel createPageDataModel() {
                    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
                }
            };
        }
        return pagination;
    }

    public String prepareList() {
        recreateModel();
        return "List";
    }

    public String prepareView() {
        current = (StudentsInTeams) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "View";
    }

    public String prepareCreate() {
        current = new StudentsInTeams();
        current.setStudentsInTeamsPK(new entities_package.StudentsInTeamsPK());
        selectedItemIndex = -1;
        recreatePagination();
        recreateModel();
        return "Create";
    }

    public String create() {
        try {
            current.getStudentsInTeamsPK().setStudentId(current.getStudentsAthletes().getStudentId());
            current.getStudentsInTeamsPK().setTeamId(current.getTeams().getTeamId());
            getFacade().create(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("StudentsInTeamsCreated"));
            return prepareCreate();
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String prepareEdit() {
        current = (StudentsInTeams) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        return "Edit";
    }

    public String update() {
        try {
            current.getStudentsInTeamsPK().setStudentId(current.getStudentsAthletes().getStudentId());
            current.getStudentsInTeamsPK().setTeamId(current.getTeams().getTeamId());
            getFacade().edit(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("StudentsInTeamsUpdated"));
            return "View";
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            return null;
        }
    }

    public String destroy() {
        current = (StudentsInTeams) getItems().getRowData();
        selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
        performDestroy();
        recreatePagination();
        recreateModel();
        return "List";
    }

    public String destroyAndView() {
        performDestroy();
        recreateModel();
        updateCurrentItem();
        if (selectedItemIndex >= 0) {
            return "View";
        } else {
            // all items were removed - go back to list
            recreateModel();
            return "List";
        }
    }

    private void performDestroy() {
        try {
            getFacade().remove(current);
            JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("StudentsInTeamsDeleted"));
        } catch (Exception e) {
            JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
        }
    }

    private void updateCurrentItem() {
        int count = getFacade().count();
        if (selectedItemIndex >= count) {
            // selected index cannot be bigger than number of items:
            selectedItemIndex = count - 1;
            // go to previous page if last page disappeared:
            if (pagination.getPageFirstItem() >= count) {
                pagination.previousPage();
            }
        }
        if (selectedItemIndex >= 0) {
            current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
        }
    }

    public DataModel getItems() {
        if (items == null) {
            items = getPagination().createPageDataModel();
        }
        return items;
    }

    private void recreateModel() {
        items = null;
    }

    private void recreatePagination() {
        pagination = null;
    }

    public String next() {
        getPagination().nextPage();
        recreateModel();
        return "List";
    }

    public String previous() {
        getPagination().previousPage();
        recreateModel();
        return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    public StudentsInTeams getStudentsInTeams(entities_package.StudentsInTeamsPK id) {
        return ejbFacade.find(id);
    }

    @FacesConverter(forClass = StudentsInTeams.class)
    public static class StudentsInTeamsControllerConverter implements Converter {

        private static final String SEPARATOR = "#";
        private static final String SEPARATOR_ESCAPED = "\\#";

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            StudentsInTeamsController controller = (StudentsInTeamsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "studentsInTeamsController");
            return controller.getStudentsInTeams(getKey(value));
        }

        entities_package.StudentsInTeamsPK getKey(String value) {
            entities_package.StudentsInTeamsPK key;
            String values[] = value.split(SEPARATOR_ESCAPED);
            key = new entities_package.StudentsInTeamsPK();
            key.setTeamId(values[0]);
            key.setStudentId(values[1]);
            return key;
        }

        String getStringKey(entities_package.StudentsInTeamsPK value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value.getTeamId());
            sb.append(SEPARATOR);
            sb.append(value.getStudentId());
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof StudentsInTeams) {
                StudentsInTeams o = (StudentsInTeams) object;
                return getStringKey(o.getStudentsInTeamsPK());
            } else {
                throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + StudentsInTeams.class.getName());
            }
        }

    }

}
