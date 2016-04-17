package com.itu.shareonwheels.service;

import com.itu.shareonwheels.dao.UserDao;
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
import java.util.List;
import java.util.Properties;

/**
 * Created by ramya on 9/28/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    public Long create(User user) {

        String userEmail = user.getEmailAddress();
        String token = user.getStatus();
        Long id = userDao.create(user);
        if(id==123456789)
        {
            return id;
        }
        else {

            try {
                generateAndSendEmail(userEmail, token, id);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            return id;
        }


    }


    public void update(User user) {
         userDao.update(user);
    }


    public User get(Long aLong) {
        return null;
    }


    public List<User> getAll() {
        return null;
    }
//remove by id

    public void removeById(Long aLong) {

    }
    public void statusUpdate(Long userId,String token)
    {
        userDao.statusUpdate(userId,token);
    }




    @Override
    public User get(String userName) {
        return userDao.getByUserName(userName);
    }

    @Override
    public void forgotpassword(User user) throws MessagingException {
        User user1 = new User();

        String emailId=user.getEmailAddress();
        System.out.print(emailId);
        user1=userDao.forgotpassword(emailId);
        String password=user1.getPassword();
        Long id =user1.getUserId();
        generateAndSendEmail1(emailId, password);
    }
    public static void generateAndSendEmail1(String userEmail, String pass) throws AddressException, MessagingException {

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

        generateMailMessage.setSubject("Forgot Password mail");
        String emailBody = "Your password is "+pass+".";
        generateMailMessage.setContent(emailBody, "text/html");

        // Step3

        Transport transport = getMailSession.getTransport("smtp");

        // Enter your correct gmail UserID and Password
        // if you have 2FA enabled then provide App Specific Password
        transport.connect("smtp.gmail.com", "shareonwheels@gmail.com","Nikita@123");
        transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
        transport.close();
    }

    public static void generateAndSendEmail(String userEmail, String token, Long id) throws AddressException, MessagingException {

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

        generateMailMessage.setSubject("Confirmation mail");
        String emailBody = "To confirm the account click below link:\n http://localhost:8080/shareonwheels/v1/user/verify/"+id+"?token="+token;
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
