package com.example.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.pojo.BookingRecord;
import com.example.service.BookingRecordService;

@RestController
@RequestMapping("/BookingRecord")
public class BookingRecordController {

	@Autowired
	private BookingRecordService bookingrecordservice;

	@GetMapping("/getAllBookingRecords")
	public List<BookingRecord> getAllBookingRecords() {
		return bookingrecordservice.findAllBookingRecord();
	}

	@PostMapping("/saveBookingRecord")
	public BookingRecord saveBookingRecord(@RequestBody BookingRecord bookingrecord) {
		return bookingrecordservice.saveBookingRecord(bookingrecord);
	}

	@PutMapping("/updateBookingRecord/{bookingId}")
	public BookingRecord updateBookingRecordById(@RequestBody BookingRecord bookingrecord,
			@PathVariable("bookingId") Long bookingId) {
		return bookingrecordservice.updateBookingRecord(bookingrecord, bookingId);

	}

	@DeleteMapping("/deleteBookingRecord/{bookingId}")
	public String deleteBookingRecord(@PathVariable("bookingId") Long bookingId) {
		return bookingrecordservice.deleteBookingRecord(bookingId);
	}

	@GetMapping("/findOneInAll/{bookingId}")
	public Optional<BookingRecord> findBookingRecordInAll(@PathVariable("bookingId") Long bookingId) {
		return bookingrecordservice.findBookingRecordById(bookingId);

	}

}
