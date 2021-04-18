package com.stripe.stripe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.stripe.http.PaymentIntentDTO;
import com.stripe.stripe.service.PaymentService;

@RestController
@RequestMapping("/stripe")
@CrossOrigin
public class PaymentController {

	@Autowired
	PaymentService paymentService;
	
	@PostMapping("/paymentintent")
	public ResponseEntity<String> payment(@RequestBody PaymentIntentDTO paymentIntentDTO ) throws StripeException{
		PaymentIntent paymentIntent = paymentService.paymentIntent(paymentIntentDTO);
		String paymentStr = paymentIntent.toJson();
		return new ResponseEntity<String>(paymentStr, HttpStatus.OK);
	}
	@PostMapping("/confirm/{id}")
	public ResponseEntity<String> confirm(@PathVariable("id") String id) throws StripeException{
		PaymentIntent paymentIntent = paymentService.confirm(id);
		String paymeString = paymentIntent.toJson();
		return new ResponseEntity<String>(paymeString,HttpStatus.OK);
	}
	@PostMapping("/cancel/{id}")
	public ResponseEntity<String> cancel(@PathVariable("id") String id) throws StripeException{
		PaymentIntent paymentIntent = paymentService.cancel(id);
		String paymeString = paymentIntent.toJson();
		return new ResponseEntity<String>(paymeString,HttpStatus.OK);
	}
}
