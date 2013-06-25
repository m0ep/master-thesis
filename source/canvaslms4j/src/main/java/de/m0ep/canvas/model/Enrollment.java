package de.m0ep.canvas.model;

import com.google.gson.annotations.SerializedName;

public class Enrollment {
    /*
     * Constants
     */
    public static final String TYPE_STUDENT = "StudentEnrollment";
    public static final String TYPE_TEACHER = "TeacherEnrollment";
    public static final String TYPE_TA = "TaEnrollment";
    public static final String TYPE_OBSERVER = "ObserverEnrollment";
    public static final String TYPE_DESIGNER = "DesignerEnrollment";

    public static final String STATE_ACTIVE = "active";
    public static final String STATE_INVITED = "invited";
    public static final String STATE_CREATION_PENDING = "creation_pending";
    public static final String STATE_DELETED = "deleted";
    public static final String STATE_REJECTED = "rejected";
    public static final String STATE_COMPLETED = "completed";
    public static final String STATE_INACTIVE = "inactive";

    /*
     * Internal classes
     */
    public static class Grades {
	@SerializedName("")
	private String htmlUrl;

	@SerializedName("")
	private String currentGrade;

	@SerializedName("")
	private String finalGrade;

	public String getHtmlUrl() {
	    return htmlUrl;
	}

	public String getCurrentGrade() {
	    return currentGrade;
	}

	public String getFinalGrade() {
	    return finalGrade;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result
		    + ((currentGrade == null) ? 0 : currentGrade.hashCode());
	    result = prime * result
		    + ((finalGrade == null) ? 0 : finalGrade.hashCode());
	    result = prime * result
		    + ((htmlUrl == null) ? 0 : htmlUrl.hashCode());
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    Grades other = (Grades) obj;
	    if (currentGrade == null) {
		if (other.currentGrade != null)
		    return false;
	    } else if (!currentGrade.equals(other.currentGrade))
		return false;
	    if (finalGrade == null) {
		if (other.finalGrade != null)
		    return false;
	    } else if (!finalGrade.equals(other.finalGrade))
		return false;
	    if (htmlUrl == null) {
		if (other.htmlUrl != null)
		    return false;
	    } else if (!htmlUrl.equals(other.htmlUrl))
		return false;
	    return true;
	}
    }

    public static class User {
	private long id;

	@SerializedName("login_id")
	private String loginId;

	private String name;

	@SerializedName("short_name")
	private String shortName;

	@SerializedName("sortable_name")
	private String sortableName;

	public long getId() {
	    return id;
	}

	public String getLoginId() {
	    return loginId;
	}

	public String getName() {
	    return name;
	}

	public String getShortName() {
	    return shortName;
	}

	public String getSortableName() {
	    return sortableName;
	}

	@Override
	public int hashCode() {
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + (int) (id ^ (id >>> 32));
	    result = prime * result
		    + ((loginId == null) ? 0 : loginId.hashCode());
	    result = prime * result + ((name == null) ? 0 : name.hashCode());
	    result = prime * result
		    + ((shortName == null) ? 0 : shortName.hashCode());
	    result = prime * result
		    + ((sortableName == null) ? 0 : sortableName.hashCode());
	    return result;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    User other = (User) obj;
	    if (id != other.id)
		return false;
	    if (loginId == null) {
		if (other.loginId != null)
		    return false;
	    } else if (!loginId.equals(other.loginId))
		return false;
	    if (name == null) {
		if (other.name != null)
		    return false;
	    } else if (!name.equals(other.name))
		return false;
	    if (shortName == null) {
		if (other.shortName != null)
		    return false;
	    } else if (!shortName.equals(other.shortName))
		return false;
	    if (sortableName == null) {
		if (other.sortableName != null)
		    return false;
	    } else if (!sortableName.equals(other.sortableName))
		return false;
	    return true;
	}
    }

    /*
     * Fields
     */

    private long id;

    @SerializedName("course_id")
    private long courseId;

    @SerializedName("course_section_id")
    private long courseSectionId;

    @SerializedName("enrollment_state")
    private String enrollmentState;

    @SerializedName(" limit_privileges_to_course_section")
    private boolean limitPrivilegesToCourseSection;

    @SerializedName("root_account_id")
    private long rootAccountId;

    private String type;

    private String role;

    @SerializedName("user_id")
    private long userId;

    @SerializedName("html_url")
    private String htmlUrl;

    private Grades grades;

    private User user;

    public static String getTypeStudent() {
	return TYPE_STUDENT;
    }

    public static String getTypeTeacher() {
	return TYPE_TEACHER;
    }

    public static String getTypeTa() {
	return TYPE_TA;
    }

    public static String getTypeObserver() {
	return TYPE_OBSERVER;
    }

    public static String getTypeDesigner() {
	return TYPE_DESIGNER;
    }

    public static String getStateActive() {
	return STATE_ACTIVE;
    }

    public static String getStateInvited() {
	return STATE_INVITED;
    }

    public static String getStateCreationPending() {
	return STATE_CREATION_PENDING;
    }

    public static String getStateDeleted() {
	return STATE_DELETED;
    }

    public static String getStateRejected() {
	return STATE_REJECTED;
    }

    public static String getStateCompleted() {
	return STATE_COMPLETED;
    }

    public static String getStateInactive() {
	return STATE_INACTIVE;
    }

    public long getId() {
	return id;
    }

    public long getCourseId() {
	return courseId;
    }

    public long getCourseSectionId() {
	return courseSectionId;
    }

    public String getEnrollmentState() {
	return enrollmentState;
    }

    public boolean isLimitPrivilegesToCourseSection() {
	return limitPrivilegesToCourseSection;
    }

    public long getRootAccountId() {
	return rootAccountId;
    }

    public String getType() {
	return type;
    }

    public String getRole() {
	return role;
    }

    public long getUserId() {
	return userId;
    }

    public String getHtmlUrl() {
	return htmlUrl;
    }

    public Grades getGrades() {
	return grades;
    }

    public User getUser() {
	return user;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (courseId ^ (courseId >>> 32));
	result = prime * result
		+ (int) (courseSectionId ^ (courseSectionId >>> 32));
	result = prime * result
		+ ((enrollmentState == null) ? 0 : enrollmentState.hashCode());
	result = prime * result + ((grades == null) ? 0 : grades.hashCode());
	result = prime * result + ((htmlUrl == null) ? 0 : htmlUrl.hashCode());
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result
		+ (limitPrivilegesToCourseSection ? 1231 : 1237);
	result = prime * result + ((role == null) ? 0 : role.hashCode());
	result = prime * result
		+ (int) (rootAccountId ^ (rootAccountId >>> 32));
	result = prime * result + ((type == null) ? 0 : type.hashCode());
	result = prime * result + ((user == null) ? 0 : user.hashCode());
	result = prime * result + (int) (userId ^ (userId >>> 32));
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Enrollment other = (Enrollment) obj;
	if (courseId != other.courseId)
	    return false;
	if (courseSectionId != other.courseSectionId)
	    return false;
	if (enrollmentState == null) {
	    if (other.enrollmentState != null)
		return false;
	} else if (!enrollmentState.equals(other.enrollmentState))
	    return false;
	if (grades == null) {
	    if (other.grades != null)
		return false;
	} else if (!grades.equals(other.grades))
	    return false;
	if (htmlUrl == null) {
	    if (other.htmlUrl != null)
		return false;
	} else if (!htmlUrl.equals(other.htmlUrl))
	    return false;
	if (id != other.id)
	    return false;
	if (limitPrivilegesToCourseSection != other.limitPrivilegesToCourseSection)
	    return false;
	if (role == null) {
	    if (other.role != null)
		return false;
	} else if (!role.equals(other.role))
	    return false;
	if (rootAccountId != other.rootAccountId)
	    return false;
	if (type == null) {
	    if (other.type != null)
		return false;
	} else if (!type.equals(other.type))
	    return false;
	if (user == null) {
	    if (other.user != null)
		return false;
	} else if (!user.equals(other.user))
	    return false;
	if (userId != other.userId)
	    return false;
	return true;
    }
}