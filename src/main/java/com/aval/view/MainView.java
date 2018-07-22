package com.aval.view;

import com.aval.domain.Function;
import com.aval.domain.Group;
import com.aval.domain.Param;
import com.aval.service.FunctionService;
import com.aval.service.GroupService;
import com.aval.service.ParamService;
import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@ManagedBean(name="mainView")
@ViewScoped
public class MainView implements Serializable {

    private List<Group> groups;
    private List<Function> functions;
    private List<Param> params;

    private Group selectedGroup;
    private Function selectedFunction;

    @ManagedProperty("#{groupService}")
    private GroupService groupService;

    @ManagedProperty("#{functionService}")
    private FunctionService functionService;

    @ManagedProperty("#{paramService}")
    private ParamService paramService;

    @PostConstruct
    public void initGroup(){
        try {
            groups = groupService.getAllGroups();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initFunction(Long groupId){
        try {
            functions = functionService.getAllGroups(groupId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initParam(Long funkId){
        try {
            params = paramService.getAllParansByFunk(funkId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void refresh(){
        initGroup();
    }

    public List<Group> getGroups() {
        return groups;
    }

    public List<Function> getFunctions() {
        return functions;
    }

    public List<Param> getParams() {
        return params;
    }

    public void setGroupService(GroupService groupService) {
        this.groupService = groupService;
    }

    public void setFunctionService(FunctionService functionService) {
        this.functionService = functionService;
    }

    public void setParamService(ParamService paramService) {
        this.paramService = paramService;
    }

    public Group getSelectedGroup() {
        return selectedGroup;
    }

    public void setSelectedGroup(Group selectedGroup) {
        this.selectedGroup = selectedGroup;
    }

    public void onRowSelectGroup(SelectEvent event) {
        Long idGroup = ((Group) event.getObject()).getId();
        initFunction(idGroup);
    }

    /*FUNCTION*/
    public Function getSelectedFunction() {
        return selectedFunction;
    }

    public void setSelectedFunction(Function selectedFunction) {
        this.selectedFunction = selectedFunction;
    }

    public void onRowSelectFunction(SelectEvent event) {
        Long idFunction = ((Function) event.getObject()).getId();
        initParam(idFunction);
    }

    public void onRowEdit(RowEditEvent event){
        Function function = (Function) event.getObject();
        functionService.updateFunction(function);
        initGroup();
    }

    public void onRowCancel(RowEditEvent event) {
        System.out.println("====onRowCancel====");
    }

    public void addMessage(Function function) {
        functionService.updateFunction(function);
        initGroup();
    }


}
