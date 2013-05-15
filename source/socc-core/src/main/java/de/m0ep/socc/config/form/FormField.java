package de.m0ep.socc.config.form;

import java.io.Serializable;

public class FormField implements Serializable {
    private static final long serialVersionUID = 1394551120060205230L;

    private Type type;

    private String variable;
    private String label;
    private String description;

    private Object defaultValue;

    private boolean hidden;
    private boolean required;
    private boolean positive;

    public FormField() {
	this.type = Type.STRING;
	this.variable = "";
	this.label = "";
	this.description = "";
	this.defaultValue = null;

	this.hidden = false;
	this.required = false;
	this.positive = false;
    }

    public String getVariable() {
	return this.variable;
    }

    public void setVariable(String variable) {
	this.variable = variable;
    }

    public String getLabel() {
	return this.label;
    }

    public void setLabel(String label) {
	this.label = label;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Object getDefaultValue() {
	return this.defaultValue;
    }

    public void setDefaultValue(Object value) {
	this.defaultValue = value;
    }

    public Type getType() {
	return this.type;
    }

    public void setType(Type type) {
	this.type = type;
    }

    public boolean isHidden() {
	return this.hidden;
    }

    public void setHidden(boolean hidden) {
	this.hidden = hidden;
    }

    public boolean isRequired() {
	return this.required;
    }

    public void setRequired(boolean required) {
	this.required = required;
    }

    public boolean isPositive() {
	return this.positive;
    }

    public void setPositive(boolean positive) {
	this.positive = positive;
    }

    public static enum Type {
	STRING, INTEGER, BOOLEAN, FLOAT
    }

    public static class Builder {
	FormField field;

	public Builder() {
	    field = new FormField();
	}

	public Builder setVariable(String name) {
	    this.field.setVariable(name);
	    return this;
	}

	public Builder setLabel(String label) {
	    this.field.setLabel(label);
	    return this;
	}

	public Builder setDescription(String desc) {
	    this.field.setDescription(desc);
	    return this;
	}

	public Builder setDefaultValue(Object value) {
	    this.field.setDefaultValue(value);
	    return this;
	}

	public Builder setType(Type type) {
	    this.field.setType(type);
	    return this;
	}

	public Builder isHidden() {
	    this.field.setHidden(true);
	    return this;
	}

	public Builder isRequired() {
	    this.field.setRequired(true);
	    return this;
	}

	public Builder isPositive() {
	    this.field.setPositive(true);
	    return this;
	}

	public FormField create() {
	    return field;
	}
    }
}