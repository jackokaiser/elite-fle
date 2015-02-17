//@TODO: Add a preview of the selected text
//@TODO: Add a preview of the sequence when created
//@TODO: Add toolTip Tutorial text
//@TODO: Add a preview of the text
//@TODO: Add actions buttons
//@TODO: Add icons in the buttons
//@TODO: Validation screen, came back and confirm button
package com.unalsoft.elitefle.presentation.controller;

import com.unalsoft.elitefle.businesslogic.facade.FacadeFactory;
import com.unalsoft.elitefle.businesslogic.facade.PersistException;
import com.unalsoft.elitefle.entity.Level;
import com.unalsoft.elitefle.entity.Notion;
import com.unalsoft.elitefle.entity.Text;
import com.unalsoft.elitefle.entity.TypeOfActivity;
import com.unalsoft.elitefle.vo.ActivityVo;
import com.unalsoft.elitefle.vo.SequenceVo;
import com.unalsoft.elitefle.vo.SupportVo;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author juanmanuelmartinezromero
 */
@ManagedBean(name = "sequenceBean")
@SessionScoped
public class SequenceBean implements Serializable {

    private boolean supports;
    private String name;
    private Level level;
    private Text spottingText;
    private TypeOfActivity spottingActivity;
    private Text systematisationText;
    private TypeOfActivity systematisationActivity;
    private String knowledgeApp;
    private String explication;
    private Notion notion;
    private Notion.SubNotion subNotion;
    @ManagedProperty(value = "#{teacherBean}")
    private TeacherBean author;
    @ManagedProperty(value = "#{supportBean}")
    private SupportBean supportBean;
    private List<SelectItem> levels;
    private List<SelectItem> notions;
    private List<SelectItem> subNotions;
    private List<SelectItem> spottingActivities;
    private List<SelectItem> spottingTexts;
    private List<SelectItem> systematisationActivities;
    private List<SelectItem> systematisationTexts;

    @PostConstruct
    public void init() {
        setInitialValues();
        allocateLists();
        fillFields();
    }

    /**
     * Set the initial values to the Notion, texts and activities
     */
    private void setInitialValues() {
        setNotion(Notion.textualStructuring);
        setSpottingActivity(TypeOfActivity.activity2);
        setSpottingText(Text.text2);
        setSystematisationActivity(TypeOfActivity.activity1);
        setSystematisationText(Text.text1);
    }

    /**
     * Allocate the arrayLists
     */
    private void allocateLists() {
        setNotions(new ArrayList<SelectItem>());
        setLevels(new ArrayList<SelectItem>());
        setSpottingActivities(new ArrayList<SelectItem>());
        setSpottingTexts(new ArrayList<SelectItem>());
        setSystematisationActivities(new ArrayList<SelectItem>());
        setSystematisationTexts(new ArrayList<SelectItem>());
    }

    /**
     * Fill the bean fields
     */
    private void fillFields() {
        //@TODO Fix bug when trying to select the first text in the first field.
        // Fill the Notions and SubNotions list
        for (Notion n : Notion.values()) {
            getNotions().add(new SelectItem(n, n.getDescription()));
        }

        fillSubNotions();
        fillSpottingActivities(getSpottingActivity());
        fillSpottingTexts(getSpottingText());
        fillSystematisationActivities(getSystematisationActivity());
        fillSystematisationTextList(getSystematisationText());

        // Fill the levels list
        for (Level l : Level.values()) {
            getLevels().add(new SelectItem(l, l.getLevel()));
        }
    }

    /**
     * Change the Sub-Notions list according to the selected Notion
     */
    public void changeSubNotions() {
        fillSubNotions();
    }

    /**
     * Refills the Sub-Notions Array List according to the selected Notion
     */
    private void fillSubNotions() {
        setSubNotions(new ArrayList<SelectItem>());
        for (Notion.SubNotion s : getNotion().getSubNotions()) {
            getSubNotions().add(new SelectItem(
                    s, s.getDescription()));
        }
    }

    /**
     * Change the Systematisation Texts list according to the selected Notion
     */
    public void changeSystematisationTexts() {
        fillSystematisationTextList(getSpottingText());
        fillSpottingTexts(getSystematisationText());
    }

    /**
     * Clear and set the systematisation text list
     *
     * @param selectedText
     */
    private void fillSystematisationTextList(Text selectedText) {
        setSystematisationTexts(new ArrayList<SelectItem>());
        for (Text t : Text.values()) {
            if (!t.equals(selectedText)) {
                getSystematisationTexts().add(new SelectItem(t, t.getText()));
            }
        }
    }

    /**
     * Change the Systematisation Activities list according to the selected
     * Notion
     */
    public void changeSystematisationActivities() {
        fillSystematisationActivities(getSpottingActivity());
        fillSpottingActivities(getSystematisationActivity());
    }

    /**
     * Clear and set the systematisation activities list
     *
     * @param selectedActivity
     */
    private void fillSystematisationActivities(TypeOfActivity selectedActivity) {
        setSystematisationActivities(new ArrayList<SelectItem>());
        for (TypeOfActivity t : TypeOfActivity.values()) {
            if (!t.equals(selectedActivity)) {
                getSystematisationActivities().add(new SelectItem(t, t.getActivityName()));
            }
        }
    }

    /**
     * Change the Spotting Texts list according to the selected Notion
     */
    public void changeSpottingTexts() {
        fillSpottingTexts(getSystematisationText());
        fillSystematisationTextList(getSpottingText());
    }

    /**
     * Clear and set the Spotting Text list
     *
     * @param selectedText
     */
    private void fillSpottingTexts(Text selectedText) {
        setSpottingTexts(new ArrayList<SelectItem>());
        for (Text t : Text.values()) {
            if (!t.equals(selectedText)) {
                getSpottingTexts().add(new SelectItem(t, t.getText()));
            }
        }
    }

    /**
     * Change the Spotting Activities list according to the selected Notion
     */
    public void changeSpottingActivities() {
        fillSpottingActivities(getSystematisationActivity());
        fillSystematisationActivities(getSpottingActivity());
    }

    /**
     * Clear and set the Spotting Activities list
     *
     * @param selectedActivity
     */
    private void fillSpottingActivities(TypeOfActivity selectedActivity) {
        setSpottingActivities(new ArrayList<SelectItem>());
        for (TypeOfActivity t : TypeOfActivity.values()) {
            if (!t.equals(selectedActivity)) {
                getSpottingActivities().add(new SelectItem(t, t.getActivityName()));
            }
        }
    }

    public boolean validateSequence() throws PersistException {
        SequenceVo sv = new SequenceVo();
        sv.setNameSequence(getName());
        sv.setNotion(getNotion().getDescription());
        sv.setSubNotion(getSubNotion().getDescription());
        sv.setLevel(getLevel().getLevel());
        sv.setSupports(isSupports());

        Integer idSpottingActivity = getActivityId(getSpottingText().getText(), getSpottingText().getUrl(), getSpottingActivity().getActivityName());
        sv.setIdSpottingActivity(idSpottingActivity);

        Integer idSystematisationActivity = getActivityId(getSystematisationText().getText(), getSystematisationText().getUrl(), getSystematisationActivity().getActivityName());
        sv.setIdSystematizationActivity(idSystematisationActivity);

        String cuttedAppAct = getKnowledgeApp().length() <= 2500
                ? getKnowledgeApp() : getKnowledgeApp().substring(0, 2500-1);
        String cuttedexp = getExplication().length() <= 2500
                ? getExplication() : getExplication().substring(0, 2500-1);

        sv.setApplicationActivity(cuttedAppAct);
        sv.setIdAuthor(getAuthor().getIdTeacher());
        sv.setExplication(cuttedexp);

        // Link Sequence and supports
        List<String> supportsIds = new ArrayList<String>(supportBean.getSupportList().size());
        for (SupportVo support : supportBean.getSelectedSupports()) {
            supportsIds.add(support.getUrlSupport());
        }
        sv.setSupportIdList(supportsIds);
        //@TODO Solve "No transaction is currently active" when complex strings in explication and App Activity
        FacadeFactory.getInstance().getSequenceFacade().persist(sv);

        this.setName(null);
        this.setExplication(null);
        this.setKnowledgeApp(null);
        this.getSupportBean().setSelectedSupports(new ArrayList<SupportVo>());
        return true;
    }

    /**
     * Get an activity by all his fields
     *
     * @param text
     * @param url
     * @param activityName
     * @return
     * @throws PersistException
     */
    private Integer getActivityId(String text, String url, String activityName) throws PersistException {
        ActivityVo activityVo = new ActivityVo();
        activityVo.setTextName(text);
        activityVo.setUrl(url);
        activityVo.setType(activityName);

        Integer idActivity = FacadeFactory.getInstance().
                getActivityFacade().findByAll(activityVo);
        if (idActivity == null) {
            FacadeFactory.getInstance().getActivityFacade().persist(activityVo);
            idActivity = FacadeFactory.getInstance().
                    getActivityFacade().findByAll(activityVo);
        }
        return idActivity;
    }

    /**
     * @return the supports
     */
    public boolean isSupports() {
        return supports;
    }

    /**
     * @param supports the supports to set
     */
    public void setSupports(boolean supports) {
        this.supports = supports;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(Level level) {
        this.level = level;
    }

    /**
     * @return the spottingText
     */
    public Text getSpottingText() {
        return spottingText;
    }

    /**
     * @param spottingText the spottingText to set
     */
    public void setSpottingText(Text spottingText) {
        this.spottingText = spottingText;
    }

    /**
     * @return the spottingActivity
     */
    public TypeOfActivity getSpottingActivity() {
        return spottingActivity;
    }

    /**
     * @param spottingActivity the spottingActivity to set
     */
    public void setSpottingActivity(TypeOfActivity spottingActivity) {
        this.spottingActivity = spottingActivity;
    }

    /**
     * @return the systematisationText
     */
    public Text getSystematisationText() {
        return systematisationText;
    }

    /**
     * @param systematisationText the systematisationText to set
     */
    public void setSystematisationText(Text systematisationText) {
        this.systematisationText = systematisationText;
    }

    /**
     * @return the systematisationActivity
     */
    public TypeOfActivity getSystematisationActivity() {
        return systematisationActivity;
    }

    /**
     * @param systematisationActivity the systematisationActivity to set
     */
    public void setSystematisationActivity(TypeOfActivity systematisationActivity) {
        this.systematisationActivity = systematisationActivity;
    }

    /**
     * @return the knowledgeApp
     */
    public String getKnowledgeApp() {
        return knowledgeApp;
    }

    /**
     * @param knowledgeApp the knowledgeApp to set
     */
    public void setKnowledgeApp(String knowledgeApp) {
        this.knowledgeApp = knowledgeApp;
    }

    /**
     * @return the explication
     */
    public String getExplication() {
        return explication;
    }

    /**
     * @param explication the explication to set
     */
    public void setExplication(String explication) {
        this.explication = explication;
    }

    /**
     * @return the notion
     */
    public Notion getNotion() {
        return notion;
    }

    /**
     * @param notion the notion to set
     */
    public void setNotion(Notion notion) {
        this.notion = notion;
    }

    /**
     * @return the subNotion
     */
    public Notion.SubNotion getSubNotion() {
        return subNotion;
    }

    /**
     * @param subNotion the subNotion to set
     */
    public void setSubNotion(Notion.SubNotion subNotion) {
        this.subNotion = subNotion;
    }

    /**
     * @return the author
     */
    public TeacherBean getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(TeacherBean author) {
        this.author = author;
    }

    /**
     * @return the supportBean
     */
    public SupportBean getSupportBean() {
        return supportBean;
    }

    /**
     * @param supportBean the supportBean to set
     */
    public void setSupportBean(SupportBean supportBean) {
        this.supportBean = supportBean;
    }

    /**
     * @return the levels
     */
    public List<SelectItem> getLevels() {
        return levels;
    }

    /**
     * @param levels the levels to set
     */
    public void setLevels(List<SelectItem> levels) {
        this.levels = levels;
    }

    /**
     * @return the notions
     */
    public List<SelectItem> getNotions() {
        return notions;
    }

    /**
     * @param notions the notions to set
     */
    public void setNotions(List<SelectItem> notions) {
        this.notions = notions;
    }

    /**
     * @return the subNotions
     */
    public List<SelectItem> getSubNotions() {
        return subNotions;
    }

    /**
     * @param subNotions the subNotions to set
     */
    public void setSubNotions(List<SelectItem> subNotions) {
        this.subNotions = subNotions;
    }

    /**
     * @return the spottingActivities
     */
    public List<SelectItem> getSpottingActivities() {
        return spottingActivities;
    }

    /**
     * @param spottingActivities the spottingActivities to set
     */
    public void setSpottingActivities(List<SelectItem> spottingActivities) {
        this.spottingActivities = spottingActivities;
    }

    /**
     * @return the spottingTexts
     */
    public List<SelectItem> getSpottingTexts() {
        return spottingTexts;
    }

    /**
     * @param spottingTexts the spottingTexts to set
     */
    public void setSpottingTexts(List<SelectItem> spottingTexts) {
        this.spottingTexts = spottingTexts;
    }

    /**
     * @return the systematisationActivities
     */
    public List<SelectItem> getSystematisationActivities() {
        return systematisationActivities;
    }

    /**
     * @param systematisationActivities the systematisationActivities to set
     */
    public void setSystematisationActivities(List<SelectItem> systematisationActivities) {
        this.systematisationActivities = systematisationActivities;
    }

    /**
     * @return the systematisationTexts
     */
    public List<SelectItem> getSystematisationTexts() {
        return systematisationTexts;
    }

    /**
     * @param systematisationTexts the systematisationTexts to set
     */
    public void setSystematisationTexts(List<SelectItem> systematisationTexts) {
        this.systematisationTexts = systematisationTexts;
    }

}
