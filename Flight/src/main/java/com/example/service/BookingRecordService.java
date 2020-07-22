package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pojo.BookingRecord;
import com.example.repository.BookingRecordRepository;

@Service
public class BookingRecordService {
	
	@Autowired
	private BookingRecordRepository bookingrecordRepository;

	public List<BookingRecord> findAllBookingRecord() {
		return bookingrecordRepository.findAll();
	}

	public BookingRecord saveBookingRecord(BookingRecord bookingrecord) {
		return bookingrecordRepository.save(bookingrecord);
	}

	public BookingRecord updateBookingRecord(BookingRecord bookingrecord, Long bookingId) {
		bookingrecord.setBookingId(bookingId);
		return bookingrecordRepository.save(bookingrecord);
	}

	public String deleteBookingRecord(Long bookingId) {

		System.out.println("dtl starting");
		Optional<BookingRecord> bookingrecord = bookingrecordRepository.findById(bookingId);
		BookingRecord fly = bookingrecord.get();
		String num = fly.getFlightNumber();
		bookingrecordRepository.delete(bookingrecord.get());
		System.out.println("Deleted flight number is: " + num);
		return num;
	}

	public Optional<BookingRecord> findBookingRecordById(Long flightInfoId) {

		Optional<BookingRecord> bookingrecord = bookingrecordRepository.findById(flightInfoId);
		return Optional.ofNullable(bookingrecord.get());
	}


}
