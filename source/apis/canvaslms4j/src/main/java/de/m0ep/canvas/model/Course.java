/*
 * The MIT License (MIT) Copyright © 2013 Florian Müller
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the “Software”), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package de.m0ep.canvas.model;

import java.util.Arrays;
import java.util.Date;

import com.google.common.base.Objects;
import com.google.gson.annotations.SerializedName;

public class Course {

	public static class Enrollment {
		private String type;

		private String role;

		@SerializedName( "computed_final_score" )
		private Double computedFinalScore;

		@SerializedName( "computed_current_score" )
		private Integer computedCurrentScore;

		@SerializedName( "computed_final_grade" )
		private String computedFinalGrade;

		@SerializedName( "computed_current_grade" )
		private String computedCurrentGrade;

		public String getType() {
			return type;
		}

		public String getRole() {
			return role;
		}

		public Double getComputedFinalScore() {
			return computedFinalScore;
		}

		public Integer getComputedCurrentScore() {
			return computedCurrentScore;
		}

		public String getComputedFinalGrade() {
			return computedFinalGrade;
		}

		public String getComputedCurrentGrade() {
			return computedCurrentGrade;
		}

		@Override
		public int hashCode() {
			return Objects.hashCode(
			        type,
			        role,
			        computedFinalScore,
			        computedCurrentScore,
			        computedFinalGrade,
			        computedCurrentGrade );
		}

		@Override
		public boolean equals( Object obj ) {
			if ( null == obj ) {
				return false;
			}

			if ( this == obj ) {
				return true;
			}

			if ( this.getClass() != obj.getClass() ) {
				return false;
			}

			Enrollment other = (Enrollment) obj;

			return Objects.equal( this.type, other.type ) &&
			        Objects.equal( this.role, other.role ) &&
			        Objects.equal( this.computedFinalScore, other.computedFinalScore ) &&
			        Objects.equal( this.computedCurrentScore, other.computedCurrentScore ) &&
			        Objects.equal( this.computedFinalGrade, other.computedFinalGrade ) &&
			        Objects.equal( this.computedCurrentGrade, other.computedCurrentGrade );
		}

		@Override
		public String toString() {
			return Objects.toStringHelper( this )
			        .add( "type", type )
			        .add( "role", role )
			        .add( "computed_final_score", computedFinalScore )
			        .add( "computed_current_score", computedCurrentScore )
			        .add( "computed_final_grade", computedFinalGrade )
			        .add( "computed_current_grade", computedCurrentGrade )
			        .toString();
		}
	}

	public static class Term {

		private long id;

		private String name;

		@SerializedName( "start_at" )
		private Date startAt;

		@SerializedName( "end_at" )
		private Date endAt;

		public long getId() {
			return id;
		}

		public String getName() {
			return name;
		}

		public Date getStartAt() {
			return startAt;
		}

		public Date getEndAt() {
			return endAt;
		}

		@Override
		public int hashCode() {
			return Objects.hashCode( id, name, startAt, endAt );
		}

		@Override
		public boolean equals( Object obj ) {
			if ( null == obj ) {
				return false;
			}

			if ( this.getClass() != obj.getClass() ) {
				return false;
			}

			Term other = (Term) obj;

			if ( !Objects.equal( this.id, other.id ) ) {
				return false;
			}

			if ( !Objects.equal( this.name, other.name ) ) {
				return false;
			}

			if ( !Objects.equal( this.startAt, other.startAt ) ) {
				return false;
			}

			if ( !Objects.equal( this.endAt, other.endAt ) ) {
				return false;
			}

			return true;
		}

		@Override
		public String toString() {
			return Objects.toStringHelper( this )
			        .add( "id", id )
			        .add( "name", name )
			        .add( "start_at", startAt )
			        .add( "end_at", endAt )
			        .toString();
		}
	}

	private long id;

	@SerializedName( "sis_course_id" )
	private String sisCourseId;

	private String name;

	@SerializedName( "course_code" )
	private String courseCode;

	@SerializedName( "workflow_state" )
	private String workflowState;

	@SerializedName( "account_id" )
	private long accountId;

	@SerializedName( "start_at" )
	private Date startAt;

	@SerializedName( "end_at" )
	private Date endAt;

	private Enrollment[] enrollments;

	private Calendar calendar;

	@SerializedName( "default_view" )
	private String defaultView;

	@SerializedName( "syllabus_body" )
	private String syllabusBody;

	@SerializedName( " needs_grading_count" )
	private String needsGradingCount;

	private Term term;

	public long getId() {
		return id;
	}

	public String getSisCourseId() {
		return sisCourseId;
	}

	public String getName() {
		return name;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public String getWorkflowState() {
		return workflowState;
	}

	public long getAccountId() {
		return accountId;
	}

	public Date getStartAt() {
		return startAt;
	}

	public Date getEndAt() {
		return endAt;
	}

	public Enrollment[] getEnrollments() {
		return enrollments;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public String getDefaultView() {
		return defaultView;
	}

	public String getSyllabusBody() {
		return syllabusBody;
	}

	public String getNeedsGradingCount() {
		return needsGradingCount;
	}

	public Term getTerm() {
		return term;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(
		        id,
		        sisCourseId,
		        name, courseCode,
		        workflowState,
		        accountId,
		        startAt,
		        endAt,
		        Arrays.hashCode( enrollments ),
		        calendar,
		        defaultView,
		        syllabusBody,
		        needsGradingCount,
		        term );
	}

	@Override
	public boolean equals( Object obj ) {
		if ( null == obj ) {
			return false;
		}

		if ( this.getClass() != obj.getClass() ) {
			return false;
		}

		Course other = (Course) obj;

		if ( !Objects.equal( this.id, other.id ) ) {
			return false;
		}

		if ( !Objects.equal( this.sisCourseId, other.sisCourseId ) ) {
			return false;
		}

		if ( !Objects.equal( this.name, other.name ) ) {
			return false;
		}

		if ( !Objects.equal( this.courseCode, other.courseCode ) ) {
			return false;
		}

		if ( !Objects.equal( this.accountId, other.accountId ) ) {
			return false;
		}

		if ( !Objects.equal( this.startAt, other.startAt ) ) {
			return false;
		}

		if ( !Objects.equal( this.endAt, other.endAt ) ) {
			return false;
		}

		if ( !Arrays.equals( this.enrollments, other.enrollments ) ) {
			return false;
		}

		if ( !Objects.equal( this.calendar, other.calendar ) ) {
			return false;
		}

		if ( !Objects.equal( this.defaultView, other.defaultView ) ) {
			return false;
		}

		if ( !Objects.equal( this.syllabusBody, other.syllabusBody ) ) {
			return false;
		}

		if ( !Objects.equal( this.needsGradingCount, other.needsGradingCount ) ) {
			return false;
		}

		if ( !Objects.equal( this.term, other.term ) ) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return Objects.toStringHelper( this )
		        .add( "id", id )
		        .add( "sys_course_id", sisCourseId )
		        .add( "name", name )
		        .add( "course_code", courseCode )
		        .add( "workflow_state", workflowState )
		        .add( "account_id", accountId )
		        .add( "start_at", startAt )
		        .add( "end_at", endAt )
		        .add( "enrollments", Arrays.toString( enrollments ) )
		        .add( "calendar", calendar )
		        .add( "default_view", defaultView )
		        .add( "syllabus_body", syllabusBody )
		        .add( "need_grading_count", needsGradingCount )
		        .add( "term", term )
		        .toString();
	}
}
