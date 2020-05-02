package domain;

import java.util.Objects;

/**
 *
 * @author leon
 */
public class ContactRequest {
    private Integer staffID, studentID;
    private String message;
    private String studentFirstname;
    private String studentLastname;
    private String staffFirstname;
    private String staffLastname;
    private boolean studentToStaff;

    public ContactRequest(Integer staffID, Integer studentID, String studentFirstname, String studentLastname, String staffFirstname, String staffLastname, String message, boolean studentToStaff) {
        this.staffID = staffID;
        this.studentID = studentID;
        this.studentFirstname = studentFirstname;
        this.studentLastname = studentLastname;
        this.staffFirstname = staffFirstname;
        this.staffLastname = staffLastname;
        this.message = message;
        this.studentToStaff = studentToStaff;
    }

    public Integer getStaffID() {
        return staffID;
    }

    public void setStaffID(Integer staffID) {
        this.staffID = staffID;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public String getStudentFirstname() {
        return studentFirstname;
    }

    public void setStudentFirstname(String studentFirstname) {
        this.studentFirstname = studentFirstname;
    }

    public String getStudentLastname() {
        return studentLastname;
    }

    public void setStudentLastname(String studentLastname) {
        this.studentLastname = studentLastname;
    }

    public String getStaffFirstname() {
        return staffFirstname;
    }

    public void setStaffFirstname(String staffFirstname) {
        this.staffFirstname = staffFirstname;
    }

    public String getStaffLastname() {
        return staffLastname;
    }

    public void setStaffLastname(String staffLastname) {
        this.staffLastname = staffLastname;
    }

    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isStudentToStaff() {
        return studentToStaff;
    }

    public void setStudentToStaff(boolean studentToStaff) {
        this.studentToStaff = studentToStaff;
    }

    @Override
    public String toString() {
        return "ContactRequest{" + "staffID=" + staffID + ", studentID=" + studentID + ", message=" + message + ", studentToStaff=" + studentToStaff + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.staffID);
        hash = 29 * hash + Objects.hashCode(this.studentID);
        hash = 29 * hash + Objects.hashCode(this.message);
        hash = 29 * hash + (this.studentToStaff ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContactRequest other = (ContactRequest) obj;
        if (this.studentToStaff != other.studentToStaff) {
            return false;
        }
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        if (!Objects.equals(this.staffID, other.staffID)) {
            return false;
        }
        if (!Objects.equals(this.studentID, other.studentID)) {
            return false;
        }
        return true;
    }
    
    
}
