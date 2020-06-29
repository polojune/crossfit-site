package com.cos.crossfit.action.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticatior extends Authenticator {
      @Override
    protected PasswordAuthentication getPasswordAuthentication() {
    	  return new PasswordAuthentication("polo_june","8574wjtmxls+");
    }
}
