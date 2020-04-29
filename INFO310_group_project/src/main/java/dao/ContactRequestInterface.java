/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.ContactRequest;
// Probably don't need to import Collection
import java.util.Collection;
/**
 *
 * @author leon
 */
public interface ContactRequestInterface {
    void saveContactRequest(ContactRequest cr);
    
    ContactRequest getRequestByStaffID(Integer staffID);
    
    ContactRequest getRequestByStudentID(Integer studentID);
    
}
