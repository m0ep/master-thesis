/**
 * EventRecord.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

/**
 * Modified for KSoap2 library by pp@patrickpollet.net using KSoap2BeanWriter
 */

package de.m0ep.moodlews.soap;


import net.patrickpollet.ksoap2.KSoap2Utils;
import net.patrickpollet.ksoap2.Soapeabilisable;

import org.ksoap2.serialization.SoapObject;

public class EventRecord  extends SoapObject  implements Soapeabilisable{
    private int courseid;

    private java.lang.String description;

    private java.lang.String error;

    private java.lang.String eventtype;

    private int format;

    private int groupid;

    private int id;

    private int instance;

    private java.lang.String modulename;

    private java.lang.String name;

    private int repeatid;

    private int sequence;

    private int timeduration;

    private int timemodified;

    private int timestart;

    private int userid;

    private java.lang.String uuid;

    private int visible;

    public EventRecord(String nameSpace) {
        super(nameSpace,"EventRecord");
    }

    /**
     * Get Custom Deserializer
     */
    public Soapeabilisable fromSoapResponse (SoapObject response) {
      EventRecord ret = new EventRecord(this.namespace);
      ret.setCourseid(KSoap2Utils.getInt(response,"courseid") );
      ret.setDescription(KSoap2Utils.getString(response,"description") );
      ret.setError(KSoap2Utils.getString(response,"error") );
      ret.setEventtype(KSoap2Utils.getString(response,"eventtype") );
      ret.setFormat(KSoap2Utils.getInt(response,"format") );
      ret.setGroupid(KSoap2Utils.getInt(response,"groupid") );
      ret.setId(KSoap2Utils.getInt(response,"id") );
      ret.setInstance(KSoap2Utils.getInt(response,"instance") );
      ret.setModulename(KSoap2Utils.getString(response,"modulename") );
      ret.setName(KSoap2Utils.getString(response,"name") );
      ret.setRepeatid(KSoap2Utils.getInt(response,"repeatid") );
      ret.setSequence(KSoap2Utils.getInt(response,"sequence") );
      ret.setTimeduration(KSoap2Utils.getInt(response,"timeduration") );
      ret.setTimemodified(KSoap2Utils.getInt(response,"timemodified") );
      ret.setTimestart(KSoap2Utils.getInt(response,"timestart") );
      ret.setUserid(KSoap2Utils.getInt(response,"userid") );
      ret.setUuid(KSoap2Utils.getString(response,"uuid") );
      ret.setVisible(KSoap2Utils.getInt(response,"visible") );
      return ret;

    }


    /**
     * Gets the courseid value for this EventRecord.
     * 
     * @return courseid
     */
    public int getCourseid() {
        return courseid;
    }


    /**
     * Sets the courseid value for this EventRecord.
     * 
     * @param courseid
     */
    public void setCourseid(int courseid) {
        this.courseid = courseid;
       this.addProperty("courseid",courseid);
    }


    /**
     * Gets the description value for this EventRecord.
     * 
     * @return description
     */
    public java.lang.String getDescription() {
        return description;
    }


    /**
     * Sets the description value for this EventRecord.
     * 
     * @param description
     */
    public void setDescription(java.lang.String description) {
        this.description = description;
       this.addProperty("description",description);
    }


    /**
     * Gets the error value for this EventRecord.
     * 
     * @return error
     */
    public java.lang.String getError() {
        return error;
    }


    /**
     * Sets the error value for this EventRecord.
     * 
     * @param error
     */
    public void setError(java.lang.String error) {
        this.error = error;
       this.addProperty("error",error);
    }


    /**
     * Gets the eventtype value for this EventRecord.
     * 
     * @return eventtype
     */
    public java.lang.String getEventtype() {
        return eventtype;
    }


    /**
     * Sets the eventtype value for this EventRecord.
     * 
     * @param eventtype
     */
    public void setEventtype(java.lang.String eventtype) {
        this.eventtype = eventtype;
       this.addProperty("eventtype",eventtype);
    }


    /**
     * Gets the format value for this EventRecord.
     * 
     * @return format
     */
    public int getFormat() {
        return format;
    }


    /**
     * Sets the format value for this EventRecord.
     * 
     * @param format
     */
    public void setFormat(int format) {
        this.format = format;
       this.addProperty("format",format);
    }


    /**
     * Gets the groupid value for this EventRecord.
     * 
     * @return groupid
     */
    public int getGroupid() {
        return groupid;
    }


    /**
     * Sets the groupid value for this EventRecord.
     * 
     * @param groupid
     */
    public void setGroupid(int groupid) {
        this.groupid = groupid;
       this.addProperty("groupid",groupid);
    }


    /**
     * Gets the id value for this EventRecord.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this EventRecord.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
       this.addProperty("id",id);
    }


    /**
     * Gets the instance value for this EventRecord.
     * 
     * @return instance
     */
    public int getInstance() {
        return instance;
    }


    /**
     * Sets the instance value for this EventRecord.
     * 
     * @param instance
     */
    public void setInstance(int instance) {
        this.instance = instance;
       this.addProperty("instance",instance);
    }


    /**
     * Gets the modulename value for this EventRecord.
     * 
     * @return modulename
     */
    public java.lang.String getModulename() {
        return modulename;
    }


    /**
     * Sets the modulename value for this EventRecord.
     * 
     * @param modulename
     */
    public void setModulename(java.lang.String modulename) {
        this.modulename = modulename;
       this.addProperty("modulename",modulename);
    }


    /**
     * Gets the name value for this EventRecord.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this EventRecord.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
       this.addProperty("name",name);
    }


    /**
     * Gets the repeatid value for this EventRecord.
     * 
     * @return repeatid
     */
    public int getRepeatid() {
        return repeatid;
    }


    /**
     * Sets the repeatid value for this EventRecord.
     * 
     * @param repeatid
     */
    public void setRepeatid(int repeatid) {
        this.repeatid = repeatid;
       this.addProperty("repeatid",repeatid);
    }


    /**
     * Gets the sequence value for this EventRecord.
     * 
     * @return sequence
     */
    public int getSequence() {
        return sequence;
    }


    /**
     * Sets the sequence value for this EventRecord.
     * 
     * @param sequence
     */
    public void setSequence(int sequence) {
        this.sequence = sequence;
       this.addProperty("sequence",sequence);
    }


    /**
     * Gets the timeduration value for this EventRecord.
     * 
     * @return timeduration
     */
    public int getTimeduration() {
        return timeduration;
    }


    /**
     * Sets the timeduration value for this EventRecord.
     * 
     * @param timeduration
     */
    public void setTimeduration(int timeduration) {
        this.timeduration = timeduration;
       this.addProperty("timeduration",timeduration);
    }


    /**
     * Gets the timemodified value for this EventRecord.
     * 
     * @return timemodified
     */
    public int getTimemodified() {
        return timemodified;
    }


    /**
     * Sets the timemodified value for this EventRecord.
     * 
     * @param timemodified
     */
    public void setTimemodified(int timemodified) {
        this.timemodified = timemodified;
       this.addProperty("timemodified",timemodified);
    }


    /**
     * Gets the timestart value for this EventRecord.
     * 
     * @return timestart
     */
    public int getTimestart() {
        return timestart;
    }


    /**
     * Sets the timestart value for this EventRecord.
     * 
     * @param timestart
     */
    public void setTimestart(int timestart) {
        this.timestart = timestart;
       this.addProperty("timestart",timestart);
    }


    /**
     * Gets the userid value for this EventRecord.
     * 
     * @return userid
     */
    public int getUserid() {
        return userid;
    }


    /**
     * Sets the userid value for this EventRecord.
     * 
     * @param userid
     */
    public void setUserid(int userid) {
        this.userid = userid;
       this.addProperty("userid",userid);
    }


    /**
     * Gets the uuid value for this EventRecord.
     * 
     * @return uuid
     */
    public java.lang.String getUuid() {
        return uuid;
    }


    /**
     * Sets the uuid value for this EventRecord.
     * 
     * @param uuid
     */
    public void setUuid(java.lang.String uuid) {
        this.uuid = uuid;
       this.addProperty("uuid",uuid);
    }


    /**
     * Gets the visible value for this EventRecord.
     * 
     * @return visible
     */
    public int getVisible() {
        return visible;
    }


    /**
     * Sets the visible value for this EventRecord.
     * 
     * @param visible
     */
    public void setVisible(int visible) {
        this.visible = visible;
       this.addProperty("visible",visible);
    }

}
