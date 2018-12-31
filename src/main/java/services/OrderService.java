package services;

import forms.CheckoutForm;

import java.sql.SQLException;

public interface OrderService{
   void checkOut(CheckoutForm checkoutForm, Long id) throws SQLException;
}
