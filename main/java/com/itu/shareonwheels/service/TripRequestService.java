package com.itu.shareonwheels.service;

import com.itu.shareonwheels.dao.TripRequestDao;
import com.itu.shareonwheels.entity.Trip;
import com.itu.shareonwheels.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by nikitasonthalia on 10/17/15.
 */

@Service
public class TripRequestService {

    @Autowired
    private TripRequestDao tripRequestDao;
    private User userDriver;
    private  User userRider;

   public Long tripRequest(Trip trip, Long requesterId) {

        int tripId=trip.getTripId();

       int flag = tripRequestDao.checktripstatus(tripId);

       if(flag>0) {

           System.out.print("ready");
           // the EmailID from user table using trip
           String userType = trip.getUserType();
           String driverId = null;
           String riderId = null;


           if (userType.equalsIgnoreCase("driver")) {
               driverId = trip.getUserId();
               riderId = requesterId.toString();

           } else {

               riderId = trip.getUserId();
               driverId = requesterId.toString();

           }
           userDriver = tripRequestDao.getDriverInfo(driverId);
           userRider = tripRequestDao.getRiderInfo(riderId);


//        System.out.print(Rider_Mail_Msg);
//       System.out.print(Driver_mail_Msg);


           // update the seat in trip table

           tripRequestDao.updateSeat(trip);


           //send the mail to Both the user

           String driverMailId = userDriver.getEmailAddress();
           String riderMailId = userRider.getEmailAddress();

           String Rider_Mail_Msg = "Hi " + userRider.getFirstName() + ",\nDriver informations are as follows:\n" +
                   "Driver Name: " + userDriver.getFirstName() +
                   "\nDriver Email: " + userDriver.getEmailAddress() +
                   "\nDriver contact no: " + userDriver.getPhoneNumber() +
                   "\n\nThank you," +
                   "\nShareonwheels";
           String Driver_mail_Msg = "Hi " + userDriver.getFirstName() + ",\nRider informations are as follows:" +
                   "\nRider Name: " + userRider.getFirstName() +
                   "\nDriver Email: " + userRider.getEmailAddress() +
                   "\nDriver contact no: " + userRider.getPhoneNumber() +
                   "\n\nThank you," +
                   "\nShareonwheels";

           try {
               generateAndSendEmail(driverMailId, Driver_mail_Msg);
               generateAndSendEmail(riderMailId, Rider_Mail_Msg);
           } catch (MessagingException e) {
               e.printStackTrace();
           }


           // insert into the trip confrimed

           tripRequestDao.createComfrimedTrip(driverId, riderId, trip);
           // return  tripRequestDao.(trip,requesterId);

       }
       else {
           return null;
       }
       return null;
   }



    public static void generateAndSendEmail(String userEmail, String token) throws AddressException, MessagingException {

        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage generateMailMessage;
        // Step1

        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        // Step2

        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        generateMailMessage = new MimeMessage(getMailSession);
        generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));

        generateMailMessage.setSubject("Information about trip.");
        String emailBody =token;
        generateMailMessage.setContent(emailBody, "text/html");

        // Step3

        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "shareonwheels@gmail.com","Nikita@123");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }



}
